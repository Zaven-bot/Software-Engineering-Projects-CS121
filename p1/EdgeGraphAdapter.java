import java.util.*;

public class EdgeGraphAdapter implements EdgeGraph {
        // boolean addNode(String n);
        // boolean addEdge(String n1, String n2);
        // boolean hasNode(String n);
        // boolean hasEdge(String n1, String n2);
        // boolean removeNode(String n);
        // boolean removeEdge(String n1, String n2);
        // List<String> nodes();
        // List<String> succ(String n);
        // List<String> pred(String n);
        // Graph union(Graph g);
        // Graph subGraph(Set<String> nodes);
        // boolean connected(String n1, String n2);

        private Graph g;

        public EdgeGraphAdapter(Graph g) { this.g = g; }

        /* 
                Name:    addEdge
                Purpose: Adds an edge e to the graph
                Inputs:  edge e
                Returns: 
                         True: edge is new
                         False: edge existed
        */
        public boolean addEdge(Edge e) {
                this.g.addNode(e.getSrc());
                this.g.addNode(e.getDst());
                return this.g.addEdge(e.getSrc(), e.getDst());
        }

        /* 
                Name:    hasNode
                Purpose: Checks if node a node n exists, attached to an edge        
                Inputs:  node n to be checked
                Returns: 
                         True: node exists with an edge (in graph)
                         False: node doesn't exist
        */
        public boolean hasNode(String n) {
                // Node exists
                if (this.g.hasNode(n)) {
                        // Check if node has an edge on it
                        if ((this.g.succ(n)).size() > 0 || (this.g.pred(n)).size() > 0) {
                                return true;
                        } else {
                                return false;
                        }
                } else {
                        return false;
                }
        }

        /* 
                Name:    hasEdge
                Purpose: Checks if edge e exists
                Inputs:  
                Returns: 
                         True: edge exists in graph
                         False: edge doesn't exist
        */
        public boolean hasEdge(Edge e) {
                // Check if Nodes exist
                if (this.g.hasNode(e.getSrc()) && this.g.hasNode(e.getDst())) {
                        // Check if Edge exists
                        List<String> directedEdges = this.g.succ(e.getSrc());
                        int i = 0;
                        while (i < directedEdges.size()) {
                                if (directedEdges.get(i) == e.getDst()) {
                                        return true;
                                }
                                i++;
                        }
                        // Edge doesn't exist
                        return false;
                // Nodes don't exist
                } else {
                        return false;
                }
        }

        /* 
                Name:    removeEdge
                Purpose: Removes the edge e from the graph
                Inputs:  edge n1 to n2 to be removed
                Returns: 
                         True: edge existed in graph
                         False: edge didn't exist
                         If removes last edge to/from a node,
                         node should be removed. Should not
                         throw an exception even if a node
                         doesn't exist.
        */
        public boolean removeEdge(Edge e) {
                // Check if edge exists
                if (hasEdge(e)) {
                        String n1 = e.getSrc();
                        String n2 = e.getDst();
                        
                        // Remove the edge from n1's node list
                        this.g.removeEdge(n1, n2);

                        List<String> nSuccNodes = this.g.succ(n1);
                        List<String> nPredNodes = this.g.pred(n1);

                        // Check if node 1 was all by itself
                        if (nSuccNodes.size() == 0 && nPredNodes.size() == 0) {
                                // If no edges, remove.
                                this.g.removeNode(n1);
                        }

                        // Remove the edge from n2's node list
                        this.g.removeEdge(n1, n2);

                        List<String> n2SuccNodes = this.g.succ(n2);
                        List<String> n2PredNodes = this.g.pred(n2);

                        // Check if node 2 is all by itself
                        if (n2SuccNodes.size() == 0 && n2PredNodes.size() == 0) {
                                // If no edges, remove.
                                this.g.removeNode(n2);
                        }
                        return true;
                // Edge doesn't exist
                } else {
                        return false;
                }
        }

        /* 
                Name:    outEdges
                Purpose: Returns a list of all edges that start at node n
                Inputs:  String of node n
                Returns: List of all edges that start at n
        */
        public List<Edge> outEdges(String n) {
                // List outgoing edges
                List<Edge> listEdges = new LinkedList<Edge>();
                // Check if node exists
                if (this.g.hasNode(n)) {
                        // List outgoing nodes
                        List<String> outgoingNodes = this.g.succ(n);
                        for (int i = 0; i < outgoingNodes.size(); i++) {
                                Edge newEdge = new Edge(n, outgoingNodes.get(i));
                                listEdges.add(newEdge);
                        }
                } 
                // Return list
                return listEdges;
        }

        /* 
                Name:    inEdges
                Purpose: Returns a list of all edges that end at node n
                Inputs:  String of node n
                Returns: List of all edges that end at n
        */
        public List<Edge> inEdges(String n) {
                // List incoming edges
                List<Edge> listEdges = new LinkedList<Edge>();
                // Check if node exists
                if (this.g.hasNode(n)) {
                        // List incoming nodes
                        List<String> incomingNodes = this.g.pred(n);
                        for (int i = 0; i < incomingNodes.size(); i++) {
                                Edge newEdge = new Edge(incomingNodes.get(i), n);
                                listEdges.add(newEdge);
                        }
                } 
                // Return list
                return listEdges;
        }

        /* 
                Name:    edges
                Purpose: Returns a list of all edges
                Inputs:  
                Returns: List of all edges
        */
        public List<Edge> edges() {
                List<String> allNodes = this.g.nodes();
                LinkedList<Edge> allEdges = new LinkedList<Edge>();
                // For all nodes
                for (int i = 0; i < allNodes.size(); i++) {
                        String node = allNodes.get(i);
                        // Get list of outgoing edges
                        List<Edge> outgoingEdges = outEdges(node);
                        // Add each edge to allEdges list
                        for (int j = 0; j < outgoingEdges.size(); j++) {
                                allEdges.add(outgoingEdges.get(j));
                        }
                }
                return allEdges;
        }

        public EdgeGraph union(EdgeGraph g) {
        
                Graph newGraph = new ListGraph();
                EdgeGraphAdapter adaptedGraph = new EdgeGraphAdapter(newGraph);

                // Add other list's edges to adaptedGraph
                List<Edge> otherGraphEdges= g.edges();
                for (int i = 0; i < otherGraphEdges.size(); i++) {
                        adaptedGraph.addEdge(otherGraphEdges.get(i));
                }

                // Add this list's edges to adaptedGraph
                List<Edge> thisGraphEdges = edges();
                for (int j = 0; j < thisGraphEdges.size(); j++) {
                        adaptedGraph.addEdge(thisGraphEdges.get(j));
                }

                return adaptedGraph;
        }

        public boolean hasPath(List<Edge> e) {
                // Return true if Edge list is empty
                if (e.isEmpty() || e.size() == 0) {
                        return true;
                }
                // Check each edge
                for (int i = 0; i < e.size(); i++) {
                        // Check if an edge doesn't exist
                        if (!hasEdge(e.get(i))) {
                                return false;
                        }
                        // Check that the ei.Dest() == e(i+1). 
                        if (i + 1 != e.size()) {
                                // Check if edge after doesn't exist
                                if (!hasEdge(e.get(i + 1))) {
                                        return false;
                                }
                                String dstNode = (e.get(i)).getDst();
                                String srcNode = (e.get(i + 1)).getSrc();
                                if (dstNode != srcNode) {
                                        throw new BadPath();
                                }
                        }
                }
                return true;
        }
}
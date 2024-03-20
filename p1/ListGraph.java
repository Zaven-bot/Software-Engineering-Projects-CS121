import java.util.*;

public class ListGraph implements Graph {
        private HashMap<String, LinkedList<String>> nodes = new HashMap<>();

        /* 
                Name:    addNode
                Purpose: Adds a node n to the graph
                Inputs:  string n to add
                Returns: 
                         True: node is new
                         False: node existed
        */
        public boolean addNode(String n) {
                // Node is new
                if (nodes.get(n) == null) {
                        LinkedList<String> edges = new LinkedList<String>();
                        nodes.put(n, edges);
                        return true;
                }
                // Node existed
                return false;
        }

        /* 
                Name:    addEdge
                Purpose: Adds an edge from nodes n1 to n2
                Inputs:  n1 to n2 directed edge
                Returns: 
                         True: edge is new
                         False: edge existed
                         throw NoSuchElementException: if n1 or n2
                                were not previously added nodes
        */
        public boolean addEdge(String n1, String n2) {
                // Nodes exist
                if (nodes.containsKey(n1) == true && nodes.containsKey(n2) == true) {
                        // Edge already exists
                        LinkedList<String> directedEdges = nodes.get(n1);
                        int i = 0;
                        while (i < directedEdges.size()) {
                                if (directedEdges.get(i) == n2) {
                                        return false;
                                }
                                i++;
                        }
                        // Edge doesn't exist
                        directedEdges.addLast(n2);
                        return true;
                        // Nodes don't exist
                } else {
                        throw new NoSuchElementException();
                }
        }

        /* 
                Name:    hasNode
                Purpose: Checks if node exists        
                Inputs:  node n to be checked
                Returns: 
                         True: node exists in graph
                         False: node doesn't exist
        */
        public boolean hasNode(String n) {
                // Node exists
                return nodes.containsKey(n);
        }

        /* 
                Name:    hasEdge
                Purpose: Checks if edge exists
                Inputs:  edge n1-n2 to be checked
                Returns: 
                         True: edge exists in graph
                         False: edge doesn't exist
        */
        public boolean hasEdge(String n1, String n2) {
                // Nodes exist
                if (nodes.containsKey(n1) == true && nodes.containsKey(n2) == true) {
                        // Edge exists
                        LinkedList<String> directedEdges = nodes.get(n1);
                        int i = 0;
                        while (i < directedEdges.size()) {
                                if (directedEdges.get(i) == n2) {
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
                Name:    removeNode
                Purpose: Removes both the node and edges connected to it
                Inputs:  node n to be removed
                Returns: 
                        True: node existed in graph
                        False: node didn't exist
        */
        public boolean removeNode(String n) {
                // Node exists
                if (nodes.containsKey(n) == true) {
                        int i = 0;
                        Set <String>setKeys = nodes.keySet();
                        List<String> listKeys = new ArrayList<>(setKeys);
                        // For all keys
                        while (i < listKeys.size()) {
                                String key = listKeys.get(i);
                                // Remove the edge including n
                                LinkedList<String> edges = nodes.get(key);
                                edges.remove(n);
                                i++;
                        }
                        // Remove the node n
                        nodes.remove(n);
                        return true;
                }
                // Node didn't exist
                return false;
        }

        /* 
                Name:    removeEdge
                Purpose: Removes the edge from the graph
                Inputs:  edge n1 to n2 to be removed
                Returns: 
                         True: edge existed in graph
                         False: edge didn't exist
                         throw NoSuchElementException: if n1 or n2
                         were not previously added nodes
        */
        public boolean removeEdge(String n1, String n2) {
                if (nodes.containsKey(n1) && nodes.containsKey(n2)) {
                        LinkedList<String> directedEdges = nodes.get(n1);
                        int i = 0;
                        // Does edge exist?
                        while (i < directedEdges.size()) {
                                if (directedEdges.get(i) == n2) {
                                        directedEdges.remove(i);
                                        return true;
                                }
                                i++;
                        }
                        // Edge doesn't exist
                        return false;
                } else {
                        throw new NoSuchElementException();
                }
                
        }

        /* 
                Name:    nodes
                Purpose: Returns a list of the nodes
                Inputs:  
                Returns: 
                         A list containing all the nodes in the current graph
        */
        public List<String> nodes() {
                Set <String>setKeys = nodes.keySet();
                List<String> listKeys = new ArrayList<>(setKeys);
                return listKeys;
        }


        /*  
                Name:    succ
                Purpose: Returns a list of successors n2, s.t. there is an edge 
                         from n to n2 in the graph. 
                Inputs:  node to be searched of successors
                Returns: 
                         List<String> n: all the successors of n
                         throw NoSuchElementException if n was not previously 
                         added as a node.
        */
        public List<String> succ(String n) {
                // Node exists
                
                if (nodes.containsKey(n)) {
                        LinkedList<String> succ = nodes.get(n);
                        LinkedList<String> copy = new LinkedList<>(succ);
                        return copy;
                } else {
                        throw new NoSuchElementException();
                }
        }

        /*  
                Name:    pred
                Purpose: Returns a list of predecessors n2, s.t. there is an
                         edge from n2 to n in the graph. 
                Inputs:  node to be searched of predecessors
                Returns: 
                         List<String> : all the predecessors of n
                         throw NoSuchElementException if n was not previously
                         added as a node.
        */
        public List<String> pred(String n) {
                List<String> pred = new LinkedList<String>();
                if (nodes.containsKey(n)) {
                        int i = 0;
                        Set <String> setKeys = nodes.keySet();
                        List<String> listKeys = new ArrayList<>(setKeys);
                        // For all keys
                        while (i < listKeys.size()) {
                                String key = listKeys.get(i);
                                LinkedList<String> edges = nodes.get(key);
                                // Check if edge n exists in n2
                                int nIndex = edges.indexOf(n);
                                // indexOf returns -1 when an element doesn't
                                // exist inside the linkedlist
                                if (nIndex != -1) {
                                        pred.add(key);
                                }
                                i++;
                        }
                } else {
                        throw new NoSuchElementException();
                }
                return pred;
        }

        /*  
                Name:    union
                Purpose: Returns a new graph that includes both this graph and the graph
                        g. Nodes with the same string combines in the returned graph.
                        DO NOT ASSUME g is implemented by a ListGraph. Code that casts
                        g to a ListGraph receive no credit. (This method will be very
                        annoying to write).
                Inputs:  node to be searched of predecessors
                Returns: 
                        Graph: a new graph that contains all the nodes and edges of g
                                and the current graph
        */
        public Graph union(Graph g) {
                // this.addNode([derived from g])
                // g.addNode
                Graph newGraph = new ListGraph();
                List<String> thisNodes = this.nodes();
                List<String> gNodes = g.nodes();
                List<String> allNodes = new ArrayList<String>();

                // Add unique nodes from this graph to graph nodes list
                for (int i = 0; i < thisNodes.size(); i++) {
                        if (!allNodes.contains(thisNodes.get(i))) {
                                allNodes.add(thisNodes.get(i));
                        }
                }
                // Add unique nodes from this graph to graph nodes list
                for (int j = 0; j < gNodes.size(); j++) {
                        if (!allNodes.contains(gNodes.get(j))) {
                                allNodes.add(gNodes.get(j));
                        }
                }
                // From graph nodes list, add all nodes to graph
                for (int k = 0; k < allNodes.size(); k++) {
                        newGraph.addNode(allNodes.get(k));
                }



                // Traverse through this Graph and create edges
                String node;
                for (int i = 0; i < thisNodes.size(); i++) {
                        // Receive node's edges
                        node = thisNodes.get(i);
                        List<String> thisSucc = this.succ(node);
                        // Add edges
                        for (int j = 0; j < thisSucc.size(); j++) {
                                newGraph.addEdge(node, thisSucc.get(j));
                        }
                }
                // Traverse through g Graph and create edges
                for (int i = 0; i < gNodes.size(); i++) {
                        // Receive node's edges
                        node = gNodes.get(i);
                        List<String> gSucc = g.succ(node);
                        // Add edges
                        for (int j = 0; j < gSucc.size(); j++) {
                                newGraph.addEdge(node, gSucc.get(j));
                        }
                }

                return newGraph;
        }

        /*  
                Name:    subGraph
                Purpose: Returns a new graph containing the nodes of the current graph
                        that are specified. Edges to nodes that aren't specified, 
                        don't exist.
                Inputs:  A string of nodes that should be copied into the new graph.
                Returns: 
                        Graph: a new graph that contains all the nodes specified by
                        user and (included) edges 
        */
        public Graph subGraph(Set<String> nodes) {
                Graph subGraph = new ListGraph();
                for (String node : nodes) {
                        if (this.hasNode(node)) {
                                subGraph.addNode(node);
                        }
                }
                
                List<String> subNodes = subGraph.nodes();
                // For every node in subgraph
                for (int i = 0; i < subNodes.size(); i++) {
                        // Check its successors in old graph
                        if (this.hasNode(subNodes.get(i))) {
                                List<String> thisSucc = this.succ(subNodes.get(i));
                                // Add its edges
                                for (int j = 0; j < thisSucc.size(); j++) {
                                        // if both nodes (on the edge) exist in subgraph
                                        if (subGraph.hasNode(thisSucc.get(j))) {
                                                subGraph.addEdge(subNodes.get(i), thisSucc.get(j));
                                        }
                                }
                        }
                }
                return subGraph;
        }

        /*  
                Name:    connected
                Purpose: Returns true if and only if there is a path from n1 to n2.
                        If n1.equals(n2) this methods should true as well. BFS or DFS
                        is recommended for this graph. Use a HashSet<String> to ensure
                        there are no cycles in the graph.
                Inputs:  A string of nodes that should be copied into the new graph.
                Returns: 
                        true: if there is a path from n1 to n2
                        false: there's no path from n1 to n2
                        NoSuchElementException: if neither n1 nor n2 exist
        */
        public boolean connected(String n1, String n2) {
                
                if (!nodes.containsKey(n1) || !nodes.containsKey(n2)) {
                        throw new NoSuchElementException();
                }

                if (n1 == n2) {
                        return true;
                }

                // Create "visited" of size of all nodes
                HashSet<String> visited = new HashSet<String>(nodes.size());
                
                // Queue for BFS
                LinkedList<String> queue = new LinkedList<String>();

                visited.add(n1);
                queue.add(n1);

                String startNode;
                int adjEdgesSize = 0;
                int idx = 0;
                while (queue.size() != 0) {
                        idx = 0;
                        startNode = queue.removeFirst();
                        LinkedList<String> adjEdges = nodes.get(startNode);
                        adjEdgesSize = adjEdges.size();

                        while (idx < adjEdgesSize) {
                                if (adjEdges.get(idx) == n2) {
                                        return true;
                                }

                                if (!visited.contains(adjEdges.get(idx))) {
                                        visited.add(adjEdges.get(idx));
                                        queue.add(adjEdges.get(idx));
                                }               
                                idx++;
                        }
                }
                return false;
        }


        
}





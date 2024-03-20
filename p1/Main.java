import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    // Run "java -ea Main" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)
    
	public static void test1() {
		Graph g = new ListGraph();
		assert g.addNode("a");
		assert g.hasNode("a");
	}

	public static void test2() {
		Graph g = new ListGraph();
		EdgeGraph eg = new EdgeGraphAdapter(g);
		Edge e = new Edge("a", "b");
		assert eg.addEdge(e);
		assert eg.hasEdge(e);
	}
    
	public static void main(String[] args) {
		// test1();
		// test2();
		// BasicGraphTest();
		// test3();
		// test4();
		// test5();
		// test6();
		// test7();
		// test8();
		// test9();
		// test10();
		// test11();
		// test12();
		// test13();
		// test14();
		// test15();
		// test16();
		// test17();
		// test18();
		// test19();
		// test20();
		// test21();
		// test22();
		// test23();
		// test24();
	}

	public static void BasicGraphTest() {
		// Can I create a graphj?
		Graph g = new ListGraph();

		// Can I create multiple nodes?
		g.addNode("a");
		assert g.hasNode("a");
		g.addNode("b");
		g.addNode("c");

		// Can I create an edge
		boolean expT0 = g.addEdge("b", "c");
		// Can I create an already created edge
		boolean expF0 = g.addEdge("b", "c");

		// Can I find a non-existing edge
		boolean expF1 = g.hasEdge("c", "b");
		// Can I find a non-existing edge
		boolean expF2 = g.hasEdge("b", "b");
		// Can I find an existing edge
		boolean expT1 = g.hasEdge("b", "c");

		// Can I remove an existing edge?
		boolean expT2 = g.removeEdge("b", "c");

		// Can I remove a non-existing node?
		boolean expF3 = g.removeNode("d");

		System.out.println("(F0, F1, F2, F3): " + expF0 + " " + expF1 + " " + expF2 + " " + expF3);
		System.out.println("(T0, T1, T2): " + expT0 + " " + expT1 + " " + expT2);
	}

    // nodes() on a filled list
	public static void test3() {
		System.out.println("Test 3:");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		List<String> listKeys = g.nodes();
		int i = 0;
		while (i < listKeys.size()) {
			System.out.println(listKeys.get(i));
			i++;
		}
	}

    // nodes() on a reduced list
	public static void test4() {
		System.out.println("Test 4:");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.removeNode("c");
		List<String> listKeys = g.nodes();
		int i = 0;
		while (i < listKeys.size()) {
			System.out.println(listKeys.get(i));
			i++;
		}
	}

	// nodes() on an empty-reduced list
	public static void test5() {
		System.out.println("Test 5:");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.removeNode("c");
		g.removeNode("b");
		g.removeNode("a");
		List<String> listKeys = g.nodes();
		int i = 0;
		while (i < listKeys.size()) {
			System.out.println(listKeys.get(i));
			i++;
		}
	}



	// succ() on lonely node
	public static void test6() {
		System.out.println("Test 6:");
		Graph g = new ListGraph();
		g.addNode("a");
		List<String> listSucc = g.succ("a");
		System.out.println(Arrays.toString(listSucc.toArray()));
	}


	// succ() with 1 succ
	public static void test7() {
		System.out.println("Test 7:");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addEdge("a", "b");

		List<String> listSucc = g.succ("a");
		System.out.println(Arrays.toString(listSucc.toArray()));
	}

	// succ() with multiple succ
	public static void test8() {
		System.out.println("Test 8:");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		
		g.addEdge("a", "b");
		g.addEdge("a", "c");
		g.addEdge("a", "d");
		g.addEdge("a", "e");

		List<String> listSucc = g.succ("a");
		System.out.println(Arrays.toString(listSucc.toArray()));
	}

	// pred() on lonely node
	public static void test9() {
		System.out.println("Test 9:");
		Graph g = new ListGraph();
		g.addNode("a");
		List<String> listPred = g.pred("a");
		System.out.println(Arrays.toString(listPred.toArray()));
	}

	// pred() with 1 pred
	public static void test10() {
		System.out.println("Test 10:");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");

		g.addEdge("a", "b");
		List<String> listPred = g.pred("b");
		System.out.println(Arrays.toString(listPred.toArray()));
	}

	// pred() with multiple pred
	public static void test11() {
		System.out.println("Test 11:");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		
		g.addEdge("b", "a");
		g.addEdge("c", "a");
		g.addEdge("d", "a");
		g.addEdge("e", "a");

		List<String> listPred = g.pred("a");
		System.out.println(Arrays.toString(listPred.toArray()));
	}



	// succ() on empty graph
	public static void test12() {
		System.out.println("Test 12:");
		Graph g = new ListGraph();
		List<String> listSucc = g.succ("a");
		System.out.println(Arrays.toString(listSucc.toArray()));
	}

	// pred() on empty graph
	public static void test13() {
		System.out.println("Test 13:");
		Graph g = new ListGraph();
		List<String> listSucc = g.succ("a");
		System.out.println(Arrays.toString(listSucc.toArray()));
	}

	// union() with two empty graphs
	public static void test14() {
		System.out.println("Test 14: {nothing} ");
		Graph g = new ListGraph();
		Graph h = new ListGraph();
		Graph i = g.union(h);
		List<String> nodesList = i.nodes();
		System.out.println(Arrays.toString(nodesList.toArray()));
	}

	// union() with 1st empty graph, no edges though
	public static void test15() {
		System.out.println("Test 15: a b c d e ");
		Graph g = new ListGraph();
		Graph h = new ListGraph();
		h.addNode("a");
		h.addNode("b");
		h.addNode("c");
		h.addNode("d");
		h.addNode("e");
		Graph i = g.union(h);
		List<String> nodesList = i.nodes();
		System.out.println(Arrays.toString(nodesList.toArray()));
	}

	// union() with 2nd empty graph, no edges though
	public static void test16() {
		System.out.println("Test 16: a b c d e");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		Graph h = new ListGraph();
		Graph i = g.union(h);
		List<String> nodesList = i.nodes();
		System.out.println(Arrays.toString(nodesList.toArray()));
	}

	// union() with 2nd empty graph, 1st graph with edges
	public static void test17() {
		System.out.println("Test 17: b c d e");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		
		g.addEdge("b", "a");
		g.addEdge("c", "a");
		g.addEdge("d", "a");
		g.addEdge("e", "a");

		Graph h = new ListGraph();
		Graph i = g.union(h);
		List<String> listPred = i.pred("a");
		System.out.println(Arrays.toString(listPred.toArray()));
	}

	// union() with diverse graphs
	public static void test18() {
		System.out.println("Test 18: a b c d e f g h i j");
		System.out.println("	     g h i j");
		Graph h = new ListGraph();
		h.addNode("a");
		h.addNode("b");
		h.addNode("c");
		h.addNode("d");
		h.addNode("e");
		
		h.addEdge("b", "a");
		h.addEdge("c", "a");
		h.addEdge("d", "a");
		h.addEdge("e", "a");

		Graph g = new ListGraph();
		g.addNode("f");
		g.addNode("g");
		g.addNode("h");
		g.addNode("i");
		g.addNode("j");

		g.addEdge("f", "g");
		g.addEdge("f", "h");
		g.addEdge("f", "i");
		g.addEdge("f", "j");

		Graph i = g.union(h);
		List<String> listNodes = i.nodes();
		List<String> listSucc = i.succ("f");
		System.out.println(Arrays.toString(listNodes.toArray()));
		System.out.println(Arrays.toString(listSucc.toArray()));
	}

	// subGraph with an empty graph
	public static void test19() {
		System.out.println("Test 19: {nothing}");
		Graph g = new ListGraph();
		String[] vowels = {"a","e","i","o","u"};
		Set<String> mySet = new HashSet<>(Arrays.asList(vowels));
		Graph h = g.subGraph(mySet);
		List<String> listNodes = h.nodes();
		System.out.println(Arrays.toString(listNodes.toArray()));
	} 

	// subGraph with a graph with nodes + pred edges
	public static void test20() {
		System.out.println("Test 20: a e ");
		System.out.println("	     e");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		
		g.addEdge("b", "a");
		g.addEdge("c", "a");
		g.addEdge("d", "a");
		g.addEdge("e", "a");

		String[] vowels = {"a","e","i","o","u"};
		Set<String> mySet = new HashSet<>(Arrays.asList(vowels));
		Graph h = g.subGraph(mySet);
		List<String> listNodes = h.nodes();
		List<String> predNodes = h.pred("a");
		System.out.println(Arrays.toString(listNodes.toArray()));
		System.out.println(Arrays.toString(predNodes.toArray()));
	} 

	// subGraph with a graph with nodes + succ edges
	public static void test21() {
		System.out.println("Test 21: a e i");
		System.out.println("	     e i ");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		g.addNode("i");
		
		g.addEdge("a", "b");
		g.addEdge("a", "c");
		g.addEdge("a", "d");
		g.addEdge("a", "e");
		g.addEdge("a", "i");

		String[] vowels = {"a","e","i","o","u"};
		Set<String> mySet = new HashSet<>(Arrays.asList(vowels));
		Graph h = g.subGraph(mySet);
		List<String> listNodes = h.nodes();
		List<String> succNodes = h.succ("a");
		System.out.println(Arrays.toString(listNodes.toArray()));
		System.out.println(Arrays.toString(succNodes.toArray()));
	} 

	public static void test22() {
		System.out.println("Test 22:");
		Graph g = new ListGraph();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		g.addNode("i");
		System.out.println(g.connected("a", "b"));


		// Graph noNodes = new ListGraph();
		// System.out.println(noNodes.connected("a", "b"));

		// Graph oneNode = new ListGraph();
		// oneNode.addNode("a");
		// System.out.println(oneNode.connected("a", "b"));

		Graph twoNodes = new ListGraph();
		twoNodes.addNode("a");
		twoNodes.addNode("b");
		System.out.println(twoNodes.connected("a", "b"));

		Graph twoNodesConnected = new ListGraph();
		twoNodesConnected.addNode("a");
		twoNodesConnected.addNode("b");
		twoNodesConnected.addEdge("a", "b");
		System.out.println(twoNodesConnected.connected("a", "b"));
	
		Graph twoNodesBackwards = new ListGraph();
		twoNodesBackwards.addNode("a");
		twoNodesBackwards.addNode("b");
		twoNodesBackwards.addEdge("b", "a");
		System.out.println(twoNodesBackwards.connected("a", "b"));

		Graph multipleNodes = new ListGraph();
		multipleNodes.addNode("a");
		multipleNodes.addNode("b");
		multipleNodes.addNode("c");
		multipleNodes.addNode("d");
		multipleNodes.addNode("e");
		multipleNodes.addNode("f");
		multipleNodes.addNode("g");
		multipleNodes.addNode("h");
		multipleNodes.addNode("i");
		multipleNodes.addEdge("a", "b");
		multipleNodes.addEdge("b", "c");
		multipleNodes.addEdge("c", "d");
		multipleNodes.addEdge("d", "e");
		multipleNodes.addEdge("e", "f");
		multipleNodes.addEdge("f", "g");
		multipleNodes.addEdge("g", "h");
		multipleNodes.addEdge("h", "i");
		System.out.println("------MULTIPLE NODES------");
		System.out.println(multipleNodes.connected("a", "i"));


		Graph sameNode = new ListGraph();
		sameNode.addNode("a");
		System.out.println(sameNode.connected("a", "a"));

		System.out.println("HEYYYY");

		Graph cycleOfNodes = new ListGraph();
		cycleOfNodes.addNode("a");
		cycleOfNodes.addNode("b");
		cycleOfNodes.addNode("c");
		cycleOfNodes.addNode("d");
		cycleOfNodes.addNode("e");
		cycleOfNodes.addNode("f");
		cycleOfNodes.addNode("g");
		cycleOfNodes.addNode("h");
		cycleOfNodes.addNode("i");
		cycleOfNodes.addEdge("a", "b");
		cycleOfNodes.addEdge("b", "c");
		cycleOfNodes.addEdge("c", "d");
		cycleOfNodes.addEdge("d", "e");
		cycleOfNodes.addEdge("e", "d");
		cycleOfNodes.addEdge("d", "c");
		cycleOfNodes.addEdge("c", "b");
		cycleOfNodes.addEdge("b", "a");
		System.out.println(cycleOfNodes.connected("a", "e"));
	}

	public static void test23() {
                Graph newGraph = new ListGraph();
                EdgeGraphAdapter adaptedGraph = new EdgeGraphAdapter(newGraph);
		Edge ab = new Edge("a", "b");
		Edge bc = new Edge("b", "c");
		Edge cd = new Edge("c", "d");
		Edge de = new Edge("d", "e");
		// a -> b -> c -> d
		adaptedGraph.addEdge(ab);
		adaptedGraph.addEdge(bc);
		adaptedGraph.addEdge(cd);
		boolean T0 = adaptedGraph.hasEdge(ab);
		boolean T1 = adaptedGraph.hasEdge(bc);
		boolean T2 = adaptedGraph.hasEdge(cd);
		boolean F0 = adaptedGraph.hasEdge(de);
		adaptedGraph.removeEdge(cd);
		boolean F1 = adaptedGraph.hasEdge(cd);
		boolean F2 = adaptedGraph.hasNode("d");
		adaptedGraph.addEdge(cd);
		adaptedGraph.removeEdge(bc);
		boolean T3 = adaptedGraph.hasNode("b");
		boolean T4 = adaptedGraph.hasNode("c");
		boolean F3 = adaptedGraph.hasEdge(bc);

		System.out.println("(T0, T1, T2, F0): " + T0 + " " + T1 + " " + T2 + " " + F0);
		System.out.println("(F1): " + F1);
		System.out.println("(F2): " + F2);
		System.out.println("(T3, T4): " + T3 + " " + T4);
		System.out.println("(F3): " + F3);
	} 

	public static void test24() {
                Graph newGraph = new ListGraph();
                EdgeGraphAdapter adaptedGraph = new EdgeGraphAdapter(newGraph);
		Edge xa = new Edge("x", "a");
		Edge ab = new Edge("a", "b");
		Edge bc = new Edge("b", "c");
		// x -> a -> b -> c

		adaptedGraph.addEdge(xa);
		adaptedGraph.addEdge(ab);
		adaptedGraph.addEdge(bc);

		List<Edge> allEdges = adaptedGraph.edges();
		for (int i = 0; i < allEdges.size(); i++) {
			Edge e = allEdges.get(i);
			System.out.println("Source & Destination" + " " + e.getSrc() + " -> " + e.getDst());
		}

		adaptedGraph.removeEdge(ab);

		boolean F0 = adaptedGraph.hasEdge(ab);
		List<Edge> allTheEdges = adaptedGraph.edges();
		int howManyEdges = allTheEdges.size();

		System.out.println("(F0): " + F0);
		System.out.println("How many edges: " + howManyEdges);

		for (int i = 0; i < allTheEdges.size(); i++) {
			Edge e = allTheEdges.get(i);
			System.out.println("Source & Destination" + " " + e.getSrc() + " -> " + e.getDst());
		}

	}

}


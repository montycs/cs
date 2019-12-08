public class BFS
{
	public static void main(String[] args)
	{
		Graph1<Integer> g = new Graph1<>();
		HashSet<Integer> visited = new HashSet<Integer>();

		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(2, 4, true);

		System.out.println("Graph:\n" + g.toString());

		g.getNodeCount();

		g.getEdgeCount(true);

		g.hasEdge(3, 4);

		g.hasNode(5);
	}

	public boolean hasPathDFS(Graph<Integer> g, Integer s, Integer d, HashSet<Integer> visited)
	{
		if (visited.contains(s))
			return false;

		visited.add(s);

		if (s == d)
			return true;

		for (Integer node : g.graphMap.get(s))
		{
			if (hasPathDFS(g, node, d, visited)) return true;
		}
	}
}

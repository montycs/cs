import Graph1

public class BFS
{
	public static void main(String[] args)
	{
		Graph1<Integer> g = new Graph1<>();

		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(2, 4, true);

		System.out.println("Graph:\n" + g.toString());

		g.getNodeCount();

		g.getEdgesCount(count);

		g.hasEdge(3, 4);

		g.hasNode(5);
	}
}
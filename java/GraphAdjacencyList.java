import java.util.LinkedList;

public class GraphAdjacencyList
{
	int vertices;
	LinkedList<Integer> adjListArray[];

	public GraphAdjacencyList(int vertices)
	{
		this.vertices = vertices;
		adjListArray = new LinkedList[vertices];

		for (int i = 0; i < vertices; i++)
		{
			adjListArray[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int destination)
	{
		adjListArray[source].add(destination);
		adjListArray[destination].add(source); 
	}

	public void printGraph()
	{
		System.out.println("Graph: (Adjacency List)");
		
		for (int i = 0; i < vertices; i++)
		{
			System.out.print(i);
			for (Integer x: adjListArray[i])
			{
				System.out.print("->" + x);
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		GraphAdjacencyList graph = new GraphAdjacencyList(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.printGraph();
	}
}

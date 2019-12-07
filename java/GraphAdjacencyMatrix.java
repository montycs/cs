public class GraphAdjacencyMatrix
{
	int vertices;
	int matrix[][];

	public GraphAdjacencyMatrix(int vertices)
	{
		this.vertices = vertices;
		matrix = new int[vertices][vertices];
	}

	public void addEdge(int source, int destination)
	{
		matrix[source][destination] = 1;

		matrix[destination][source] = 1;
	}

	public void printGraph()
	{
		System.out.println("Graph: (Adjacency Matrix)");
		
		for (int i = 0; i < vertices; i++)
		{
			for (int j = 0; j < vertices; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\nGraph:");

		for (int i = 0; i < vertices; i++)
		{
			System.out.print(i);

			for (int j = 0; j < vertices; j++)
			{
				if (matrix[i][j] == 1)
				{
					System.out.print("->" + j);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5);
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

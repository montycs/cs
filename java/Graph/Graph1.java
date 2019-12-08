import java.util.*;

public class Graph1<T>
{
	private HashMap<T, LinkedList<T>> graphMap = new HashMap<>();
	//int nodes = graphMap.keySet().size();

	public void addNode(T node)
	{
		graphMap.put(node, new LinkedList<T>());
	}

	public void addEdge(T source, T destination, boolean bidirectional)
	{
		if (!graphMap.containsKey(source))
			addNode(source);

		if(!graphMap.containsKey(destination))
			addNode(destination);

		graphMap.get(source).add(destination);

		if (bidirectional == true)
			graphMap.get(destination).add(source);
	}

	public void getNodeCount()
	{
		System.out.println("The graph has " + graphMap.keySet().size() + " nodes.");
	}

	// public void getNodeCount()
	// {
	// 	System.out.println("The graph has " + nodes + " nodes.");
	// }

	public void getEdgeCount(boolean bidirectional)
	{
		int count = 0;
		for (T node : graphMap.keySet())
			count += graphMap.get(node).size();

		if (bidirectional == true)
			count = count / 2;

		System.out.println("The graph has " + count + " edges.");
	}

	public boolean hasNode(T node)
	{
		if (graphMap.containsKey(node))
		{
			System.out.println("Graph contains: " + node);
			return true;
		}

		else
		{
			System.out.println("Graph does not contain: " + node);
			return false;
		}
	}

	public boolean hasEdge(T source, T destination)
	{
		if (graphMap.get(source).contains(destination))
		{
			System.out.println("Graph contains edge between " + source + " + " + destination);
			return true;
		}

		else
		{
			System.out.println("Graph does not contain edge.");
			return false;
		}
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		for (T node : graphMap.keySet())
		{
			builder.append(node.toString() + ": ");
			for (T vertex : graphMap.get(node))
			{
				builder.append(vertex.toString() + " ");
			}
			builder.append("\n");
		}
		return (builder.toString());
	}
}

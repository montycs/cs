import java.util.*;

public class Graph
{
        private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

        public static class Node
        {
                private int id;
                LinkedList<Node> adjacent = new LinkedList<Node>();
                private Node(int id)
                {
                        this.id = id;
                }
        }

        private Node getNode(int id)
        {
                Node temp = nodeLookup.get(id);
                return temp;
        }
        public void addEdge(int source, int destination)
        {
                Node s = getNode(source);
                Node d = getNode(destination);
                s.adjacent.add(d);
        }
        public boolean hasPathDFS(int source, int destination)
        {
                Node s = getNode(source);
                Node d = getNode(destination);
                HashSet<Integer> visited = new HashSet<Integer>();
                return hasPathDFS(s, d, visited);
        }
        private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited)
        {
                if (visited.contains(source.id)) return false;

                visited.add(source.id);

                if (source == destination) return true;

                for (Node child : source.adjacent)
                {
                        if (hasPathDFS(child,destination, visited)) return true;
                }
                return false;
        }
        public boolean hasPathBFS(int source, int destination)
        {
                return hasPathBFS(getNode(source), getNode(destination));
        }
        private boolean hasPathBFS(Node source, Node destination)
        {
                LinkedList<Node> nextToVisit = new LinkedList<Node>();
                HashSet<Integer> visited = new HashSet<Integer>();
                nextToVisit.add(source);
                while (!nextToVisit.isEmpty())
                {
                        Node node = nextToVisit.remove();
                        if (node == destination) return true;
                        if (visited.contains(node.id)) continue;
                        visited.add(node.id);

                        for(Node child : node.adjacent)
                        {
                                nextToVisit.add(child);
                        }
                }
                return false;
        }

	//private void 

        public static void main(String[] args) 
        {

		Node temp1 = new Node(1);
		Node temp2 = new Node(2);
		Node temp3 = new Node(3);
		Node temp4 = new Node(4);
		Node temp5 = new Node(5);
		Node temp6 = new Node(6);

                Graph tre = new Graph();
		tre.nodeLookup.put(1, temp1);
		tre.nodeLookup.put(2, temp2);
		tre.nodeLookup.put(3, temp3);
		tre.nodeLookup.put(4, temp4);
		tre.nodeLookup.put(5, temp5);
		tre.nodeLookup.put(6, temp6);

                tre.addEdge(1, 2);
		tre.addEdge(1, 3);
                tre.addEdge(2, 4);
		tre.addEdge(3, 6);
		tre.addEdge(3, 5);
		tre.addEdge(2, 4);
		tre.addEdge(2, 1);
                tre.addEdge(6, 2);
 		//tre.addEdge(3, 4);
                //tre.addEdge(1, 2);

                //System.out.println(tre.hasPathDFS(1,1));
		System.out.println(tre.hasPathDFS(1,2));
		System.out.println(tre.hasPathDFS(1,3));
		//System.out.println(tre.hasPathDFS(2,2));
		System.out.println(tre.hasPathDFS(2,1));
		System.out.println(tre.hasPathDFS(2,3));
		//System.out.println(tre.hasPathDFS(3,3));
		System.out.println(tre.hasPathDFS(3,1));
		System.out.println(tre.hasPathDFS(3,2));
		System.out.println(tre.hasPathDFS(6,4));
		System.out.println(tre.hasPathDFS(6,5));

		//Queue<Integer> q = new ArrayDequeue<>();

        }

        public static void printBFS(Graph g, int v, boolean[] discovered)
		{
			Queue<Integer> q = new ArrayDeque<>();

			discovered[v] = true;

			q.add(v);

			while (!q.isEmpty())
			{
				v = q.poll();
				System.out.print(v + " ");
				for (int u : g.nodeLookup.get(v).adjacent)
				{
					if (!discovered[u])
					{
						discovered[u] = true;
						q.add(u);
					}
				}
			}
		}
}

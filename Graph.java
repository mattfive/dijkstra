
/**
 * @author 
 * @version 
 */
public class Graph
{
    private GraphNode[] nodes;
    private double[][] edges;
    
    
    
    public Graph()
    {
      nodes = new GraphNode[17];
      edges = new double[17][17];    
    }
    
    public GraphNode getNode(int index)
    {
      return nodes[index];    
    }
    
    public void setNode(GraphNode newNode)
    {
      boolean nodeSet = false;
      while (nodeSet == false) 
          {
           for (int i = 0; i < this.nodes.length;i++) {
                                                       if (nodes[i] == null) {
                                                                              nodes[i] = newNode;
                                                                              nodeSet = true;
                                                                              break;
                                                                             }
                                                       }
          }
    }
    
     public void addEdge(int nodeStart, int nodeEnd, double distance)
    {
      if (this.edges[nodeStart][nodeEnd] == 0)
                                                {
                                                 this.edges[nodeStart][nodeEnd] = distance;
                                                 this.edges[nodeEnd][nodeStart] = distance;
                                                } else {
                                                        System.out.println("Die Strecke existiert bereits.");
                                                        }
    }
    
    public double getDistance(String locationName, String destinationName)
    {
       
       return this.edges[getIndexNode(locationName)][getIndexNode(destinationName)]; 
    }
    
    public int getIndexNode(String nodeName)
    {
    boolean nodeFound = false;
    int index = -1;
    while (nodeFound == false) {
                                for (int i = 0; i < this.nodes.length;i++) {
                                                                           if (this.nodes[i].getName() == nodeName) {
                                                                                                                     nodeFound = true;
                                                                                                                     index = i;
                                                                                                                     break;
                                                                                                                    }
                                                                           }
        
        
    }
    return index;
   }
   
 }

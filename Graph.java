
/**
 * Die Klasse "Graph" erstellt eine zweidimensionale Matrix aus Knotenpunkten der Klasse "GraphNode",
 * wodurch die Gewichte des Graphen gespeichert werden
 * @author M.Götz
 * @version 1.2.0 02.12.2015
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
    
    /**
     * Holt den der Indexzahl entsprechenden Knotenpunkt aus dem Array "nodes"
     */
    public GraphNode getNode(int index)
    {
      return nodes[index];    
    }
    
    /**
     * Fügt einen neuen Knotenpunkt im Array "nodes" hinzu
     */
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
    
    /**
     * Holt den der Indexzahl entsprechenden Knotenpunkt aus dem Array "nodes"
     */
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
    
    /**
     * Gibt das Gewicht zwischen zwei Knotenpunkten zurück, die Angaben der Knotenpunkte erfolgt über
     * den Namen als String
     */
    public double getDistance(String locationName, String destinationName)
    {
       
       return this.edges[getIndexNode(locationName)][getIndexNode(destinationName)]; 
    }
    
   /**
     * Gibt die Indexzahl eines Knotenpunktes innerhalb des Arrays "nodes" zurück, welcher über den
     * Namen im Array gesucht wird
     */
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

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Stack;

/**
 * Die Klasse "Dijkstra" berechnet mit dem Dijkstra-Algorithmus den kürzesten Weg zwischen einem Start-Knotenpunkt und einem Ziel-Knotenpunkt
 * innerhalb eines ungerichteten gewichteten Graphen und erstellt eine Zeichenkette mit den Wegpunkten, hier eine Route
 * zwischen zwei Städten in Deutschland
 * @author M.Götz 
 * @version 1.2.0 02.12.2015
 */
public class Dijkstra
{
    private Graph graph;
    private ArrayList<GraphNode> warteSchlange;
    private GraphNode node1,node2,node3,node4,node5,node6,node7,node8,node9,node10,node11,node12,node13,node14,node15,node16,node17;
    private double kleinsteEntfernung;
    private int indexKleinsteEntfernung;
    private GraphNode kuerzesterWeg;
    private Stack<GraphNode> wegStreckeStack;
    private String wegStrecke;
    
  
    public Dijkstra()
    {
     graph = new Graph();
     initialisiere();
    }

    public void initialisiere()
    {
      node1 = new GraphNode("Karlsruhe",false,145,511);
      node2 = new GraphNode("Frankfurt",false,157,421);
      node3 = new GraphNode("Hamburg",false,231,135);
      node4 = new GraphNode("Berlin",false,406,216);
      node5 = new GraphNode("Kiel",false,232,69);
      node6 = new GraphNode("Bremen",false,168,165);
      node7 = new GraphNode("Rostock",false,337,87);
      node8 = new GraphNode("Osnabrück",false,132,238);
      node9 = new GraphNode("Hannover",false,220,232);
      node10 = new GraphNode("Düsseldorf",false,52,318);
      node11 = new GraphNode("Kassel",false,201,322);
      node12 = new GraphNode("Leipzig",false,357,312);
      node13 = new GraphNode("Würzburg",false,223,445);
      node14 = new GraphNode("Nürnberg",false,295,475);
      node15 = new GraphNode("Freiburg",false,109,589);
      node16 = new GraphNode("Konstanz",false,199,619);
      node17 = new GraphNode("München",false,319,582);
      graph.setNode(node1);
      graph.setNode(node2);
      graph.setNode(node3);
      graph.setNode(node4);
      graph.setNode(node5);
      graph.setNode(node6);
      graph.setNode(node7);
      graph.setNode(node8);
      graph.setNode(node9);
      graph.setNode(node10);
      graph.setNode(node11);
      graph.setNode(node12);
      graph.setNode(node13);
      graph.setNode(node14);
      graph.setNode(node15);
      graph.setNode(node16);
      graph.setNode(node17);
      graph.addEdge(4,6,204);
      graph.addEdge(6,2,190);
      graph.addEdge(4,2,98);
      graph.addEdge(2,5,126);
      graph.addEdge(2,8,151);
      graph.addEdge(2,3,288);
      graph.addEdge(8,3,285);
      graph.addEdge(5,8,127);
      graph.addEdge(5,7,121);
      graph.addEdge(7,8,137);
      graph.addEdge(7,9,180);
      graph.addEdge(8,9,278);
      graph.addEdge(9,10,228);
      graph.addEdge(8,10,167);
      graph.addEdge(10,11,254);
      graph.addEdge(3,11,190);
      graph.addEdge(9,1,229);
      graph.addEdge(10,1,193);
      graph.addEdge(10,12,209);
      graph.addEdge(11,13,278);
      graph.addEdge(1,0,139);
      graph.addEdge(1,12,119);
      graph.addEdge(12,13,109);
      graph.addEdge(1,15,360);
      graph.addEdge(0,14,136);
      graph.addEdge(0,15,230);
      graph.addEdge(14,15,125);
      graph.addEdge(15,16,279);
      graph.addEdge(12,16,277);
      graph.addEdge(13,16,170);
      
      warteSchlange = new ArrayList<GraphNode>();
      wegStreckeStack = new Stack<GraphNode>();
           
        
    }
    
    
		
    /**
     * Berechnet mit dem Dijkstra-Algorithmus den kürzesten Weg zwischen dem Startknoten und dem Endknoten
     */
    public String berechneWeg(String startPunkt, String endPunkt)
    {
         
      boolean gefunden = false;
      
      for (int i = 0; i < 17;i++) {
          graph.getNode(i).setEntfernung(Double.MAX_VALUE);
          
      }
      
      (graph.getNode(graph.getIndexNode(startPunkt))).setEntfernung(0);
      (graph.getNode(graph.getIndexNode(startPunkt))).setMarked(true);
      
      for (int i = 0; i < 17;i++) {
       if (((graph.getDistance((graph.getNode(graph.getIndexNode(startPunkt))).getName(),(graph.getNode(i)).getName())!= 0)&& ((graph.getNode(i)).getMarked() == false))) {
                          graph.getNode(i).setEntfernung((graph.getDistance((graph.getNode(graph.getIndexNode(startPunkt))).getName(),graph.getNode(i).getName())));
                          graph.getNode(i).setMarked(true);
                          graph.getNode(i).setVorgaenger(graph.getNode(graph.getIndexNode(startPunkt)));
                          warteSchlange.add(graph.getNode(i));
                       }
      }
      
                 
      
      while (gefunden == false)   {         
                                  kleinsteEntfernung = Double.MAX_VALUE;
                                                                    
                                                                   
                                  for (int i = 0; i < warteSchlange.size();i++) {
                                         if ((warteSchlange.get(i)).getEntfernung() < kleinsteEntfernung) {
                                              kleinsteEntfernung = (warteSchlange.get(i)).getEntfernung();
                                              indexKleinsteEntfernung = i;
                                         }
                                  }
                                  
                                  if ((warteSchlange.get(indexKleinsteEntfernung)).getName().equals(endPunkt)) {
                                  
                                      kuerzesterWeg = warteSchlange.get(indexKleinsteEntfernung);
                                      gefunden = true;
                                      break;
                                  
                                  }
                                 
                                  GraphNode loeschNode = warteSchlange.get(indexKleinsteEntfernung);
                                  warteSchlange.remove(indexKleinsteEntfernung);
                            
                                  for (int i = 0; i < 17;i++) {
                                     if ((graph.getDistance(loeschNode.getName(),graph.getNode(i).getName())!= 0)&& ((graph.getNode(i)).getMarked() == false)) {
                                            graph.getNode(i).setEntfernung((graph.getDistance(loeschNode.getName(),graph.getNode(i).getName()) + loeschNode.getEntfernung()));
                                            graph.getNode(i).setVorgaenger(loeschNode);
                                            graph.getNode(i).setMarked(true);
                                            warteSchlange.add(graph.getNode(i));
                                         } else if ((graph.getDistance(loeschNode.getName(),graph.getNode(i).getName())!= 0)&& ((graph.getNode(i)).getMarked() == true))
                                           {
                                            for (int j = 0; j < warteSchlange.size();j++)
                                                 {
                                                  if ((graph.getNode(i).getName().equals((String)(warteSchlange.get(j)).getName()))) {
                                                          if ((warteSchlange.get(j)).getEntfernung() > (graph.getDistance(loeschNode.getName(),graph.getNode(i).getName()) + loeschNode.getEntfernung())) {
                                                                                                                                                       (warteSchlange.get(j)).setEntfernung((graph.getDistance(loeschNode.getName(),graph.getNode(i).getName()) + loeschNode.getEntfernung()));
                                                                                                                                                       graph.getNode(i).setVorgaenger(loeschNode);
                                                                                                                                                       //(warteSchlange.get(j)).setVorgaenger(graph.getNode(i));
                                                                                                                                                                                                                                  
                                                                                                                                                       }
                                            
                                                      }
                                            }
                                    }
                                }
      }
      
    return getStreckeUndEntfernung(kuerzesterWeg);
     
    
    }
    
    
    
    
    /**
     * Gibt den Wert der Entfernung zum Startpunkt mit einem rekursiven Aufruf, der alle Vorgänger des Knotenpunkts
     * durchläuft, zurück
     */
    public double vorgaengerEntfernungLesen(GraphNode lNode)
    {
      double entfernung = 0;
      if (lNode.getVorgaenger() != null)
                                     {
                                      entfernung = lNode.getEntfernung() + vorgaengerEntfernungLesen(lNode.getVorgaenger());
                                      } else {
                                             entfernung = entfernung + lNode.getEntfernung();
                                            }
      
      return entfernung;
              
    }
    
    
    /**
     * Gibt die kürzeste Route als Zeichenkette mit den einzelnen Wegpunkten zurück
     */
    
    public String vorgaengerNamenLesen(GraphNode lNode)
    {
      wegStrecke = "";
         
      if (lNode.getVorgaenger() != null)
                                     {
                                       wegStrecke = lNode.getName() + ", " + wegStrecke;
                                       wegStrecke = vorgaengerNamenLesen(lNode.getVorgaenger()) +  ", " + lNode.getName();
                                      } else {
                                             wegStrecke = "Die kürzeste Route verläuft über " + lNode.getName() + wegStrecke;
                                             }
      
      return wegStrecke;
                
    }
    
    
    /**
     * Gibt die kürzeste Route als Zeichenkette mit den einzelnen Wegpunkten und der Gesamtlänge in km zurück
     * 
     */
    public String getStreckeUndEntfernung(GraphNode lNode)
    {
      vorgaengerNamenLesen(lNode);
      wegStrecke = (wegStrecke + " und ist " + kuerzesterWeg.getEntfernung() + "km lang.");
      return wegStrecke;
        
    }
    
    /**
     * Gibt den Graphen zurück, der im Konstruktor initialisiert wurde
     */
    public Graph getGraph()
    {
      return graph;    
    }
    
    
    /**
     * Erstellt die Wegstrecke über einen rekursiven Aufruf, der alle Vorgänger durchläuft und diese auf einen Stack stapelt
     */
    public void erstelleWegStreckeStack(GraphNode lNode)
    {
            
      if (lNode.getVorgaenger() != null)
      {
              wegStreckeStack.push(lNode);
              lNode = lNode.getVorgaenger();
              erstelleWegStreckeStack(lNode);
      } else {
             wegStreckeStack.push(lNode);
             }
      
    }
    
    
    /**
     * Gibt die Wegstrecke als Stack zurück; diese Methode sollte erst nach der Methode "erstelleWegStreckeStack()"
     * aufgerufen werden 
     */
    public Stack<GraphNode> getWegStreckeStack()
    {
        return wegStreckeStack;
    }
    
    /**
     * Gibt den End-Knotenpunkt zurück, der in seinen Vorgängern die Wegroute des kürzesten Wegs gespeichtert hat
     */
    public GraphNode getKuerzesterWeg()
    {
        return kuerzesterWeg;
    }
    
    
    /**
     * Setzt alle wichtigen Variablen zurück und leert die entsprechenden Stacks und Arrays
     */
    public void resetDijkstra()
    {
      warteSchlange.clear();
      for (int i = 0;i < 17;i++)
            {
            graph.getNode(i).setMarked(false);            
            }
      wegStrecke="";
      kuerzesterWeg = null;
      
      while(!wegStreckeStack.isEmpty()) {
       wegStreckeStack.pop();   
        }
      
              
    }
    
}

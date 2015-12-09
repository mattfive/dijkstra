
/**
 * Die Klasse "GraphNode" erzeugt einen Knotenpunkt für Graphen.
 * 
 * @author M. Götz 
 * @version 1.2.0 02.12.2015
 */
public class GraphNode
{
    private String name;
    private boolean marked;
    private int xPos,yPos;
    private double entfernung;
    private GraphNode vorgaenger;
    
    public GraphNode()
    {
      name = "";
      marked = false;
    }
    
     public GraphNode(String nameNode,boolean nodeMarked,int nX,int nY)
    {
      name = nameNode;
      marked = nodeMarked;
      xPos = nX;
      yPos = nY;
      entfernung = Double.MAX_VALUE;
      vorgaenger = null;
    }
    
    /**
     * Gibt den Namen des Knotenpunkts zurück
     */
    public String getName()
    {
      return this.name;    
    }
    
    /**
     * Setzt den Namen eines Knotenpunkts neu
     */
    public void setName(String nName)
    {
      name = nName;    
    }
    
    
    /**
     * Gibt die X-Koordinate des Knotenpunkts zurück
     */
    public int getXPos()
    {
      return this.xPos;    
    }
    
     /**
     * Gibt die Y-Koordinate des Knotenpunkts zurück
     */
    public int getYPos()
    {
      return this.yPos;    
    }
      
     /**
     * Setzt die Variable "entfernung" mit einem angegebenen double-Parameter
     */
    public void setEntfernung(double nEntf)
    {
     entfernung = nEntf;    
    }
    
    /**
     * Gibt den Wert der Variablen "entfernung" zurück
     */
    public double getEntfernung()
    {
     return entfernung;    
    }
    
    /**
     * Setzt den Vorgänger-Knoten zum Knotenpunkt mit einem angegebenen GraphNode-Objekt
     */
    public void setVorgaenger(GraphNode nVorg)
    {
     vorgaenger = nVorg;    
    }
    
    /**
     * Gibt den Vorgänger-Knoten des Knotens zurück zurück
     */
    public GraphNode getVorgaenger()
    {
     return vorgaenger;    
    }
    
    /**
     * Setzt die Variable "marked" mit einem angegebenen boolean-Parameter
     */
    public void setMarked(boolean nMarked)
    {
     marked = nMarked;    
    }
    
    /**
     * Gibt den Wert der Variablen "marked" zurück als boolean zurück
     */
    public boolean getMarked()
    {
     return marked;    
    }
}

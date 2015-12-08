
/**
 * @author 
 * @version 
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
    
    public String getName()
    {
      return this.name;    
    }
    
    public void setName(String nName)
    {
      name = nName;    
    }
    
    
    public int getXPos()
    {
      return this.xPos;    
    }
    
    public int getYPos()
    {
      return this.yPos;    
    }
      
    public void setEntfernung(double nEntf)
    {
     entfernung = nEntf;    
    }
    
    public double getEntfernung()
    {
     return entfernung;    
    }
    
    public void setVorgaenger(GraphNode nVorg)
    {
     vorgaenger = nVorg;    
    }
    
    public GraphNode getVorgaenger()
    {
     return vorgaenger;    
    }
    
    public void setMarked(boolean nMarked)
    {
     marked = nMarked;    
    }
    
    public boolean getMarked()
    {
     return marked;    
    }
}

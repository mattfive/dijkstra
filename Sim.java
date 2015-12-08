import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Component;
import javax.swing.JComboBox;
import java.awt.TextArea;
import java.util.Stack;


public class Sim {
    private static MyPanel neuesPanel;
           
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                
            }
        });
    }

          
    public static void createAndShowGUI() {
        neuesPanel = new MyPanel();
        JFrame f = new JFrame("Routenrechner");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(neuesPanel);
        f.pack();
        f.setVisible(true);
    }
    
}
       

class MyPanel extends JPanel implements ActionListener{
    private JPanel drawPanel,textPanel,buttonPanel; 
    private JButton calcButton,resetButton;
    private int objectType, colorType;
    private int size;
    private final GraphicsConfiguration gfxConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    private JComboBox ursprungSelect,zielSelect;
    private TextArea textFeld;
    private Dijkstra neueRoute;
    private Stack<GraphNode> weg;
     
          
    public MyPanel() {
        neueRoute = new Dijkstra();
        weg = new Stack<GraphNode>();
                
        drawPanel = new JPanel(){
                                 @Override protected void paintComponent(Graphics g)
                                 {
                                  //repaint();
                                  super.paintComponent(g);
                                  g.setColor(Color.BLACK);
                                  
                                                                  
                                  g.fillOval(232,69,10,10);
                                  g.drawString("Kiel",250,80);
                                  g.fillOval(231,135,10,10);
                                  g.drawString("Hamburg",249,146);
                                  g.fillOval(168,165,10,10);
                                  g.drawString("Bremen",186,176);
                                  g.fillOval(337,87,10,10);
                                  g.drawString("Rostock",355,98);
                                  g.fillOval(132,238,10,10);
                                  g.drawString("Osnabrück",150,249);
                                  g.fillOval(220,232,10,10);
                                  g.drawString("Hannover",238,243);
                                  g.fillOval(406,216,10,10);
                                  g.drawString("Berlin",424,227);
                                  g.fillOval(52,318,10,10);
                                  g.drawString("Düsseldorf",70,329);
                                  g.fillOval(201,322,10,10);
                                  g.drawString("Kassel",219,333);
                                  g.fillOval(357,312,10,10);
                                  g.drawString("Leipzig",375,323);
                                  g.fillOval(157,421,10,10);
                                  g.drawString("Frankfurt",175,432);
                                  g.fillOval(223,445,10,10);
                                  g.drawString("Würzburg",241,456);
                                  g.fillOval(295,475,10,10);
                                  g.drawString("Nürnberg",313,486);
                                  g.fillOval(145,511,10,10);
                                  g.drawString("Karlsruhe",163,522);
                                  g.fillOval(109,589,10,10);
                                  g.drawString("Freiburg",127,600);
                                  g.fillOval(199,619,10,10);
                                  g.drawString("Konstanz",210,630);
                                  g.fillOval(319,582,10,10);
                                  g.drawString("München",337,593);
                                  
                                  
         if (!weg.isEmpty())
         {
		    GraphNode startNode;
		    GraphNode zielNode;
		    while(!weg.empty()){
				startNode = weg.peek();
				int xPos1 = startNode.getXPos()+5;
				int yPos1 = startNode.getYPos()+5;
				weg.pop();
				if (!weg.empty()) {
				zielNode = weg.peek();
				int xPos2 = zielNode.getXPos()+5;
				int yPos2 = zielNode.getYPos()+5;
				g.drawLine(xPos1,yPos1,xPos2,yPos2);
                } else {
                        break;
                       }
		        
		    }
		  }
		
                                                           
                                  
        
                                }
                              };
        
        
                                   
        buttonPanel = new JPanel();
        textPanel = new JPanel();
        setLayout(new BorderLayout());
        textFeld = new TextArea(2,80);
        textPanel.add(textFeld);
        add(textPanel,BorderLayout.PAGE_START);
        
        add(drawPanel,BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));
               
        
        ursprungSelect = new JComboBox();
        ursprungSelect.addItem("Frankfurt");
        ursprungSelect.addItem("Karlsruhe");;
        ursprungSelect.addItem("Berlin");
        ursprungSelect.addItem("Hamburg");
        ursprungSelect.addItem("Kiel");
        ursprungSelect.addItem("Bremen");
        ursprungSelect.addItem("Rostock");
        ursprungSelect.addItem("Osnabrück");
        ursprungSelect.addItem("Hannover");
        ursprungSelect.addItem("Düsseldorf");
        ursprungSelect.addItem("Kassel");
        ursprungSelect.addItem("Leipzig");
        ursprungSelect.addItem("Würzburg");
        ursprungSelect.addItem("Nürnberg");
        ursprungSelect.addItem("Freiburg");
        ursprungSelect.addItem("Konstanz");
        ursprungSelect.addItem("München");
        buttonPanel.add(ursprungSelect);
        zielSelect = new JComboBox();
        zielSelect.addItem("Frankfurt");
        zielSelect.addItem("Karlsruhe");
        zielSelect.addItem("Berlin");
        zielSelect.addItem("Hamburg");
        zielSelect.addItem("Kiel");
        zielSelect.addItem("Bremen");
        zielSelect.addItem("Rostock");
        zielSelect.addItem("Osnabrück");
        zielSelect.addItem("Hannover");
        zielSelect.addItem("Düsseldorf");
        zielSelect.addItem("Kassel");
        zielSelect.addItem("Leipzig");
        zielSelect.addItem("Würzburg");
        zielSelect.addItem("Nürnberg");
        zielSelect.addItem("Freiburg");
        zielSelect.addItem("Konstanz");
        zielSelect.addItem("München");
        buttonPanel.add(zielSelect);
        
        calcButton = new JButton("Route berechnen");
        calcButton.addActionListener(this);
        calcButton.setPreferredSize(new Dimension(150,25));
        buttonPanel.add(calcButton);
        
        resetButton = new JButton("Route zurücksetzen");
        resetButton.addActionListener(this);
        resetButton.setPreferredSize(new Dimension(150,25));
        buttonPanel.add(resetButton);
        
        add(buttonPanel,BorderLayout.PAGE_END);
        objectType = 2;
        colorType = 0;
                
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(800,800);
    }
    
      
    
    public void neuerText(String nText)
    {
      textFeld.append(nText);
          
    }
        
    public void actionPerformed(ActionEvent e){
           
      if(e.getSource() == this.calcButton){
                
        textFeld.append(neueRoute.berechneWeg((String)ursprungSelect.getSelectedItem(),(String)zielSelect.getSelectedItem()));
        neueRoute.erstelleWegStreckeStack(neueRoute.getKuerzesterWeg());
        weg = neueRoute.getWegStreckeStack();
        repaint();
        } else if (e.getSource() == this.resetButton) {
                                                      neueRoute.resetDijkstra();
                                                      textFeld.setText("");
                                                      while(!weg.isEmpty()) {
                                                             weg.pop();   
                                                             }
                                                      repaint();
                                                      }
        
    }
    
}


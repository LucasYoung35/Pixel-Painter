import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaintPanel{ 
	
	/**
	 * Constant value to store width of the panel
	 */
	public static int WIDTH = 500;
	/**
	 * Constant value to store height of the panel
	 */
	public static int HEIGHT = 580;
	/**
	 * Constant to store value for button width
	 */
	public static int BUTTON_WIDTH = 80;
	/**
	 * Constant to store value for button height
	 */
	public static int BUTTON_HEIGHT = 30;
	
	/**
	 * Canvas object that the user can draw on
	 */
	Canvas canvas;
	
	/**
	 * 
	 */
	Paint paint;
	
	/**
	 * Boolean used to keep track of whether or not user is drawing
	 * true if mouse is pressed
	 */
	boolean drawing = false;
	
     PaintPanel()  
        {  
    	//Create JFrame
        Frame frame = new Frame("Paint Panel"); 
        frame.setSize(WIDTH,HEIGHT);
        frame.setResizable(false);
        frame.setLayout(null);    
        frame.setVisible(true);
        
        //set close operation for frame
        frame.addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent we){
        		System.exit(0);
        	}
        });

        
        //Create JPanel to hold all buttons and interactive components
        Panel controlPanel=new Panel();  
        controlPanel.setBounds(0,0,WIDTH,80);    
        controlPanel.setBackground(Color.gray);  
        
        //Create JPanel for canvas
        DrawingCanvas drawingPanel = new DrawingCanvas();
        drawingPanel.setBounds(0, 80, WIDTH, HEIGHT-80);
        
        //button to clear canvas
        Button clearButton =new Button("Clear");     
        clearButton.setBounds(15,35,BUTTON_WIDTH,BUTTON_HEIGHT);   
        clearButton.setBackground(Color.white);
        
        clearButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		drawingPanel.clear();
        	}
		});
       
        //button to save image
        Button saveButton =new Button("Save");   
        saveButton.setBounds(110,35,BUTTON_WIDTH,BUTTON_HEIGHT);    
        saveButton.setBackground(Color.white);
        
        controlPanel.add(saveButton);
        controlPanel.add(clearButton);
        
        frame.add(controlPanel);  
        frame.add(drawingPanel);
                    
        }  
     
        public static void main(String args[]){  
        	new PaintPanel();  
        }

		
		
    } 
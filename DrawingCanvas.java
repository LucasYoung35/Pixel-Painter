import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingCanvas extends Canvas{

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -5763647707613596896L;
	
	Point point;
	
	public DrawingCanvas() {
		super();
		
		//add a mouse adapter to handling clicking
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				point = e.getPoint();
				drawPixel(point);
			}
			
		});
		
		//add a mouse adapter to handling dragging
		addMouseMotionListener(new MouseAdapter() {
		
			@Override
			public void mouseDragged(MouseEvent e) {
				point = e.getPoint();
				drawPixel(point);
			}
		
		});
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintComponent(g);
		
		if(point !=null) {
			
			int x = (int) point.getX();
			int y = (int) point.getY();
				
			int lowerX = x-(x%10);
			int lowerY = y-(y%10);
			
			g.fillRect(lowerX, lowerY, 10, 10);
		}
	}

	
	
	/**
	 * Clears all ink from the canvas
	 */
	public void clear() {
		point = null;
		repaint();
	}
	
	/**
	 * Draws a 10x10 pixel at a specified point
	 * @param p Point to draw pixel at
	 */
	private void drawPixel(Point p) {
		System.out.println("drawing");
		
		int x = (int) p.getX();
		int y = (int) p.getY();
			
		int lowerX = x-(x%10);
		int lowerY = y-(y%10);
		
		repaint(lowerX, lowerY, 10, 10);
	}
	

}

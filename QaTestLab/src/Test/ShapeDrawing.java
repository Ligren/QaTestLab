package Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ShapeDrawing extends Frame {
	Color colorThis;
	Shape shapeThis;
	static int xLocation;
	static int yLocation;

	public ShapeDrawing(Shape shape) {
		super("Shape");
		this.colorThis = shape.getColor();
		this.shapeThis = shape;
		prepareGUI();
	}

	private void prepareGUI() {
		setSize(1500, 400);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				dispose();
			}
		});
		setVisible(true);
		
		xLocation += 50;
		yLocation += 50;
		setLocation(xLocation, yLocation);
	}
}

@SuppressWarnings("serial")
class TriangleDrawing extends ShapeDrawing {
	int side1, side2;

	public TriangleDrawing(Color color, int side1, int side2, Shape shape) {
		super(shape);
		this.side1 = ((Triangle) shapeThis).side1; 
		this.side2 = ((Triangle) shapeThis).side2;;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Font plainFont = new Font("Serif", Font.PLAIN, 24);
		
		int x1, x2, x3, y1, y2, y3;
		x1 = 50;
		y1 = 50;
		x2= x1 + side1;
		y2 = y1;
		x3 = x2; 
		y3 = y2 + side2;
	   int[] xPoints = new int[3];
	   int[] yPoints = new int[3];
	   
       xPoints[0] = x1;
       yPoints[0] = y1;
       xPoints[1] = x2;
       yPoints[1] = y2;
       xPoints[2] = x3;
       yPoints[2] = y3;
	   
       g2.setFont(plainFont);
	   
       g2.setColor(colorThis);
       g.fillPolygon(xPoints, yPoints, 3);
	   g2.setColor(Color.BLACK);
	   g.drawPolygon(xPoints, yPoints,3);
	   g.drawString(shapeThis.toString(), 80, 300);
	   
	   }
}

@SuppressWarnings("serial")
class SquareDrawing extends ShapeDrawing {
	int side;
	public SquareDrawing(Shape shape) {
		super(shape);
		this.side = ((Square) shape).side;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Font plainFont = new Font("Serif", Font.PLAIN, 24);
		g2.setFont(plainFont);
		g2.setColor(colorThis);
		g.fillRect(35, 45, 35+side, 45+side);
		g2.setColor(Color.BLACK);
		g.drawRect(35, 45, 35+side, 45+side);
		g.drawString(shapeThis.toString(), 80, 300);
	}
}

@SuppressWarnings("serial")
class CircleDrawing extends ShapeDrawing {
	int radius;
	
	public CircleDrawing(Shape shape) {
		super(shape);
		this.radius = ((Circle) shapeThis).radius;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Font plainFont = new Font("Serif", Font.PLAIN, 24);
		g2.setFont(plainFont);
		g2.setColor(colorThis);
		g.fillOval(80, 80, radius*2, radius*2);
		g2.setColor(Color.BLACK);
		g.drawOval(80, 80, radius*2, radius*2);
		g.drawString(shapeThis.toString(), 80, 300);
	}
}

@SuppressWarnings("serial")
class TrapezeDrawing extends ShapeDrawing {
	int base1, base2, h;


	public TrapezeDrawing(Shape shape) {
		super(shape);
		this.base1 = ((Trapeze) shape).base1;
		this.base2 = ((Trapeze) shape).base2;
		this.h = ((Trapeze) shape).h;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Font plainFont = new Font("Serif", Font.PLAIN, 24);
		g2.setFont(plainFont);
		g2.setColor(colorThis);
		g.drawString(shapeThis.toString(), 80, 300);
		
		int x1, x2, x3, y1, y2, y3, x4, y4;
		x1 = 50;
		y1 = 50;
		x2 = x1 + base1;
		y2 = y1;
		x3 = x2; 
		y3 = y2 + h;
		x4 = x2 - base2; 
		y4 = y3;
		
	   int[] xPoints = new int[4];
	   int[] yPoints = new int[4];
       xPoints[0] = x1;
       yPoints[0] = y1;
       xPoints[1] = x2;
       yPoints[1] = y2;
       xPoints[2] = x3;
       yPoints[2] = y3;
       xPoints[3] = x4;
       yPoints[3] = y4;
	   
       g2.setFont(plainFont);
	   g2.setColor(colorThis);
	   g.fillPolygon(xPoints, yPoints, 4);
	   g2.setColor(Color.BLACK);
	   g.drawPolygon(xPoints, yPoints, 4);
	   g.drawString(shapeThis.toString(), 80, 300);

	}
}
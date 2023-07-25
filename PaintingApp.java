import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class PaintingApp extends Applet{
	Button cirB, rectB, ovalB, lineB, penB, eraserB;
	public void init(){
		cirB= new Button("Circle");
		rectB= new Button("Rectangle");
		ovalB= new Button("Oval");	
		lineB= new Button("Line");
		penB= new Button("Pen");
		eraserB= new Button("Eraser");
		add(cirB);
		add(rectB);
		add(ovalB);
		add(lineB);
		add(penB);
		add(eraserB);
	}
	public void paint(Graphics g) {
		int width = getSize().width;   
     		int height = getSize().height;
		g.setColor(Color.white);
     		g.fillRect(0,0, width, height);
		g.setColor(Color.black);
      		g.drawRect(0, 0, width-1, height-1);
		g.drawRect(1, 1, width-3, height-3);
		g.drawRect(2, 2, width-5, height-5);
		g.drawRect(3, 3, width-7, height-7);
		cirB.setBackground(Color.gray);
		cirB.setForeground(Color.white);
		cirB.setSize(width/7,height/9);
		cirB.setLocation(5,5);
		rectB.setSize(width/7,height/9);
		rectB.setLocation((width/7)+5,5);
		ovalB.setSize(width/7,height/9);
		ovalB.setLocation(2*(width/7)+5,5);
		lineB.setSize(width/7,height/9);
		lineB.setLocation(3*(width/7)+5,5);
		penB.setSize(width/7,height/9);
		penB.setLocation(4*(width/7)+5,5);
		eraserB.setSize(width/7,height/9);
		eraserB.setLocation(5*(width/7)+5,5);
		
	}
}
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.*;
public class PaintingApp extends Applet{
	int x1;
	int y1;
	int x2;
	int y2; 
	int x;
	int y;
	int width=0;
	int height=0;
	int tempX1;
	int tempY1;
	int eraserWidth=50;
	int eraserHeight=50;
	boolean keepX2=false;
	boolean keepY2=false;
	int rad;
	Vector <GeoShape> shapesVector = new Vector <GeoShape>();
	int j=0;
	boolean filledPressed = false;
	Button cirB, rectB, lineB, penB, eraserB, fillB;
	Button rb, gb, yb, bb, blackb;
	Color currentColor = Color.black; 
	char currentShape;
	int counter;
	Color c;
	
	public void init(){
		lineB =new Button("Line");
		lineB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentShape = 'l';
	}});
		add(lineB);
		rectB =new Button("Rectangle");
		rectB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentShape = 'r';
	}});
		add(rectB);
		cirB =new Button("Circle");
		cirB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentShape= 'c';
	}});
		add(cirB);
		rb =new Button("Red");
		rb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentColor= Color.red;
				repaint();
	}});
		add(rb);
		bb =new Button("Blue");
		bb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentColor= Color.blue;
				repaint();
				
	}});
		add(bb);
		gb =new Button("Green");
		gb.addActionListener(new ActionListener(){

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
			}
		});
		add(lineB);
		rectB =new Button("Rectangle");
		rectB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentShape = 'r';
			}
		});
		add(rectB);
		cirB =new Button("Circle");
		cirB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentShape= 'c';
			}
		});
		add(cirB);
		rb =new Button("Red");
		rb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentColor= Color.red;
				repaint();
			}
		});
		add(rb);
		bb =new Button("Blue");
		bb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentColor= Color.blue;
				repaint();
			}
		});
		add(bb);
		gb =new Button("Green");
		gb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentColor= Color.green;
				repaint();
			}
		});
		add(gb);
		yb= new Button("Yellow");
		yb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentColor= Color.yellow;
				repaint();		
			}
		});
		add(yb);
		blackb= new Button("Black");
		blackb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentColor= Color.black;
				repaint();	
			}
		});
		add(blackb);
		penB =new Button("Pen");
		penB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentShape= 'p';
				repaint();	
			}
		});
		add(penB);
		eraserB =new Button("Eraser");
		eraserB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentShape='e';
			}
		});
		add(eraserB);
		fillB =new Button("Fill");
		fillB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(filledPressed== false){
					filledPressed=true;
					fillB.setBackground(Color.gray);
				}
				else{
					filledPressed=false;
					fillB.setBackground(Color.white);
				}
				repaint();
			}
		});
		add(fillB);
		MouseListener_ m = new MouseListener_();
		MotionListener ml = new MotionListener();
		this.addMouseListener(m);
		this.addMouseMotionListener(ml);
		
	}

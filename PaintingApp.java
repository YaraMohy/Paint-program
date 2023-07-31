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
	public void paint(Graphics g){
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
		rectB.setBackground(Color.gray);
		rectB.setForeground(Color.white);
		lineB.setBackground(Color.gray);
		lineB.setForeground(Color.white);
		rb.setBackground(Color.red);
		rb.setForeground(Color.white);
		yb.setBackground(Color.yellow);
		yb.setForeground(Color.white);
		blackb.setBackground(Color.black);
		blackb.setForeground(Color.white);
		gb.setBackground(Color.green);
		gb.setForeground(Color.white);
		bb.setBackground(Color.blue);
		bb.setForeground(Color.white);
		cirB.setSize(width/9,height/10);
		cirB.setLocation(5,5);
		rectB.setSize(width/9,height/10);
		rectB.setLocation((width/9)+5,5);
		lineB.setSize(width/9,height/10);
		lineB.setLocation(2*(width/9)+5,5);
		penB.setSize(width/9,height/10);
		penB.setLocation(3*(width/9)+5,5);
		fillB.setSize(width/9,height/10);
		fillB.setLocation(4*(width/9)+5,5);
		eraserB.setSize(width/9,height/10);
		eraserB.setLocation(5*(width/9)+5,5);
		rb.setSize((width/9),height/20);
		rb.setLocation(6*(width/9)+5,5);
		yb.setSize((width/9),height/20);
		yb.setLocation(7*(width/9),5);
		gb.setSize((width/9),height/20);
		gb.setLocation(6*(width/9)+5,(height/20)+5);
		bb.setSize((width/9),(height/20)+5);
		bb.setLocation(7*(width/9),height/20);
		blackb.setSize((width/9),height/10);
		blackb.setLocation(8*(width/9)-2,5);
		float[] dash = {10,10,10};
		Graphics2D g2d = (Graphics2D) g.create();
			for (j=0; j< shapesVector.size(); j++){
				g2d.setColor(shapesVector.get(j).getColor());	
				switch(shapesVector.get(j).getShapeName()){
					case 'l':
						g2d.drawLine(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), shapesVector.get(j).getX2(), shapesVector.get(j).getY2());
						break;
					case 'r':
						g2d.drawRect(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), shapesVector.get(j).getX2(), shapesVector.get(j).getY2());	
						if(shapesVector.get(j).isFilled())
							g2d.fillRect(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), shapesVector.get(j).getX2(), shapesVector.get(j).getY2());
							break;
					case 'c':
						g2d.drawOval(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), shapesVector.get(j).getX2(), shapesVector.get(j).getY2());	
						if(shapesVector.get(j).isFilled())
							g2d.fillOval(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), shapesVector.get(j).getX2(), shapesVector.get(j).getY2());	
							break;
					case 'e':
						g2d.fillRect(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), eraserWidth, eraserHeight);		
				}
			
			}	
		g.setColor(currentColor);
	}

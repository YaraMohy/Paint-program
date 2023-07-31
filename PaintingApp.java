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
			public void actionPerformed(ActionEvent e){
				currentColor= Color.green;
				repaint();
				
	}});
		add(gb);
		yb= new Button("Yellow");
		yb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentColor= Color.yellow;
				repaint();
				
	}});
		add(yb);
		blackb= new Button("Black");
		blackb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentColor= Color.black;
				repaint();
				
	}});
		add(blackb);
		penB =new Button("Pen");
		penB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentShape= 'p';
				repaint();
				
				
	}});
		add(penB);
		eraserB =new Button("Eraser");
		eraserB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentShape='e';
				}});
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
				repaint();}
			
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
							g2d.drawLine(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), 
									shapesVector.get(j).getX2(), shapesVector.get(j).getY2());
							break;
						case 'r':
							g2d.drawRect(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), 
									shapesVector.get(j).getX2(), shapesVector.get(j).getY2());	
							if(shapesVector.get(j).isFilled())
								g2d.fillRect(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), 
									shapesVector.get(j).getX2(), shapesVector.get(j).getY2());
							break;
						case 'c':
							g2d.drawOval(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), 
									shapesVector.get(j).getX2(), shapesVector.get(j).getY2());	
							if(shapesVector.get(j).isFilled())
								g2d.fillOval(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), 
									shapesVector.get(j).getX2(), shapesVector.get(j).getY2());	
							break;
						case 'e':
							g2d.fillRect(shapesVector.get(j).getX1(), shapesVector.get(j).getY1(), eraserWidth, eraserHeight);
							
}
			
		}
				
			g.setColor(currentColor);
			
			
			}
	class MouseListener_ implements MouseListener{
		public void mousePressed(MouseEvent e){
				x1= x2 =e.getX();
				y1= y2 =e.getY();
				repaint();
		}
		public void mouseExited(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e)  {}
		public void mouseReleased(MouseEvent e)  {
			x2=e.getX();
			y2=e.getY();
			
			width= Math.abs(x2-x1);
			Graphics g=getGraphics();
			height = Math.abs(y2-y1);
			switch(currentShape){
				case 'l':
					shapesVector.add(new Line(x1, y1, x2, y2, 'l'));
					break;
				case 'r':
					x= (x1-x2) <0 ? x1 : x2;
					y= (y1-y2) <0 ? y1 : y2;
					shapesVector.add(new Rect(x1, y1, width, height, 'r', filledPressed));
					break;
				case 'c':
					x= (x1-x2) <0 ? x1 : x2;
					y= (y1-y2) <0 ? y1 : y2;
					shapesVector.add(new Circle(x1, y1, width, height, 'c', filledPressed));
					break;
			}repaint();
			
	
}}
	
	class MotionListener implements MouseMotionListener{
		
		public void mouseMoved(MouseEvent e) {
			}
		
		public void mouseDragged(MouseEvent e) {
			x2=e.getX();
			y2=e.getY();
			Graphics g=getGraphics();
			width= Math.abs(x2-x1);
			height = Math.abs(y2-y1);
							
			switch(currentShape){
				
				case 'e':
					shapesVector.add(new Rect( x2, y2,eraserWidth, eraserHeight, 'e', filledPressed));
					break;
				case 'p':
					shapesVector.add(new Line(x1, y1, x2, y2, 'l'));
					counter+=1;
					if(counter % 2 ==0){
						x1=x2;
						y1=y2;
					}
					break;
				
			}
			
			}}
	
	class GeoShape{
	protected int dim1;
	protected int x1; 
	protected int y1;
	protected int x2; 
	protected int y2;
	private char whoAmI;
	protected boolean filledPressed;
	protected Color color;
	
	public GeoShape(){
		
	}
	public GeoShape(int x1, int y1, int x2, int y2, char whoAmI, boolean filledPressed){
		
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			this.whoAmI=whoAmI;
			this.filledPressed=filledPressed;

			if(whoAmI == 'e')
				this.color =getBackground();
			else
				this.color= currentColor;
}
	public GeoShape(int x1, int y1, int x2, int y2, char whoAmI){
		
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			this.whoAmI=whoAmI;
			this.color= currentColor;
}
	boolean isFilled(){
		return filledPressed;
	}
	void setShape(char p){
		whoAmI=p;
}
	char getShape(){
		return whoAmI;
}

	void setX1(int x1){
		
			x1=x1;
		}
	void setY1(int y1){
			y1=y1;
		}
	public void setX2(int x2){
			x2=x2;
		}
	public void setY2(int Y2){
			y2=y2;
		}
	
	public void setDim(int d){
		if (d <1)
			System.out.print("SORRY NO NEGATIVE NUMBERS!");
		else
			dim1=d;
		
	}
	public int getDim(){
		return this.dim1;
	}
	int getX1(){
			return x1;
		}
	int getY1(){
			return y1;
		}
	int getX2(){
			return x2;
		}
	int getY2(){
			return y2;
		}
	public Color getColor(){
		return color;
	}
	public char getShapeName(){
		return whoAmI;
}	
}
	
	class Line extends GeoShape{
		
		
		public Line(){
		
		}
		
		public Line(int x1,int y1, int x2,int y2, char whoAmI){
			super(x1, y1, x2, y2, whoAmI);
		}}

	class Rect extends GeoShape{
		
		public Rect(){
		
		}
		
		public Rect(int x1,int y1, int x2,int y2, char whoAmI, boolean filledPressed){
			super(x1, y1, x2, y2, whoAmI, filledPressed);
		}}

	class Circle extends GeoShape{
		
		public Circle(){
		
		}
		
		public Circle(int x1,int y1, int x2,int y2, char whoAmI, boolean filledPressed){
			super(x1, y1, x2, y2, whoAmI, filledPressed);
		}
}
	
		}
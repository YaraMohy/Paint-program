# Paint-program-Team-4

This PaintingApp applet allows the user to draw various shapes and manipulate colors. The user can select different shapes to draw: Line, Rectangle and Circle.
The user can choose between a pen tool and an eraser tool. The pen draws freehand lines while the eraser erases parts of the canvas. The user can select from different colors. 


![Capture](https://github.com/YaraMohy/Paint-program-team-4/assets/139645547/5bba57ea-9d45-4fdb-842c-eb1f467d7d0c)

Class Declarations:

PaintingApp extends Applet: The main class which extends Applet. It contains the UI and logic for the paint application.

GeoShape: An abstract class representing a geometric shape. It contains properties like color, location, dimensions, etc.

Line, Rect, Circle: Subclasses of GeoShape representing the specific shapes. They inherit properties from GeoShape.
___________

Variables:

x1, y1, x2, y2: Stores the start and end coordinates of the currently drawn shape.

width, height: Stores the dimensions of the currently drawn shape.

tempX1, tempY1: Temporary coordinates used when drawing.

eraserWidth, eraserHeight: Size of the eraser tool.

keepX2, keepY2: Flags to indicate if the end coordinates should be kept.

rad: Circle radius.

shapesVector: Vector that stores all the drawn shapes.

j: Counter used to iterate through shapesVector.

filledPressed: Indicates if the fill button is pressed.

cirB, rectB, etc: Button variables for the shape buttons.

currentColor: Stores the currently selected color.

currentShape: Stores the currently selected shape - 'l' for line, 'r' for rect, etc.

counter: Counter used while drawing with the pen tool.

_________
Methods:

init(): Initializes the GUI by creating the buttons and assigning listeners.

paint(): Draws all the shapes stored in shapesVector and performs other painting tasks.

MouseListener_: Handles mouse events like click, drag, release. On release, a new GeoShape is created and added to shapesVector.

MotionListener: Handles mouse drag events. While dragging, the shape is updated and repainted.

GeoShape: Abstract class representing a shape. Contains properties and methods to manipulate a shape.

Line, Rect, Circle: Subclasses representing the specific shapes. They inherit from GeoShape.
_______________

When the user clicks and drags the mouse, a shape is drawn on the canvas based on the currently selected shape and color.

When the mouse button is released, a GeoShape object is created representing the drawn shape and added to the shapesVector.

The paint() method draws all shapes in shapesVector on the canvas.

The user can toggle the "Fill" button to fill the interior of shapes when drawing.

As the user drags the mouse while using the pen tool, the shape is continuously updated and repainted.

So in summary, this applet allows the user to:

Select shapes to draw
Choose colors
Draw shapes by clicking and dragging the mouse
Fill the interior of shapes
Use a pen tool for freehand drawing
Erase parts of the canvas
All drawn shapes are stored and repainted.

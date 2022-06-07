package day10assignment;

abstract class Shape{
    public abstract void area();
}

class Circle extends Shape{
    float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        System.out.println("Area of circle is:"+(Math.PI*(radius*radius)));
    }
}

class Cylinder extends Circle{
    float height;

    public Cylinder(float radius, float height) {
        super(radius);
        this.height = height;
    }

    @Override
    public void area() {
        System.out.println("Area of cylinder is:"+(2*Math.PI*radius*(height+radius)));
    }
}

class Square extends Shape{
    float length;

    public Square(float length) {
        this.length = length;
    }

    @Override
    public void area() {
        System.out.println("Area of square is:"+(length*length));
    }
}


class Rectangle extends Square{
    float width;

    public Rectangle(float length, float width) {
        super(length);
        this.width = width;
    }

    @Override
    public void area() {
        System.out.println("Area of rectangle is:"+(length*width));
    }
}
public class ShapeTest {
    public static void main(String[] args){
        Shape[] shapes=new Shape[4];

        shapes[0]=new Circle(3.2f);
        shapes[1]=new Cylinder(4.1f,3);
        shapes[2]=new Square(5);
        shapes[3]=new Rectangle(4,8);

        for(int i=0;i<shapes.length;i++){
            shapes[i].area();
        }
    }
}

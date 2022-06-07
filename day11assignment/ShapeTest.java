package day11assignment;

abstract class Shape{
    String color;

    public Shape(String color) {
        this.color = color;
    }

    abstract double getArea();

    abstract public String toString();
}

class Rectangle extends Shape{
    int length,width;

    public Rectangle(String color, int length, int width) {
        super(color);
        this.length = length;
        this.width = width;
    }


    @Override
    double getArea() {
        return length*width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "color='" + color + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}

class Triangle extends Shape{
    int base,height;

    public Triangle(String color, int base, int height) {
        super(color);
        this.base = base;
        this.height = height;
    }


    @Override
    double getArea() {
        return (1.0/2)*(base*height);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "color='" + color + '\'' +
                ", base=" + base +
                ", height=" + height +
                '}';
    }
}

public class ShapeTest {
    public static void main(String[] args){
        Shape obj_shape;

        obj_shape=new Rectangle("Red",7,6);
        System.out.println(obj_shape);
        System.out.println("Area of Rectangle:"+obj_shape.getArea());

        System.out.println();

        obj_shape=new Triangle("Yellow",4,9);
        System.out.println(obj_shape);
        System.out.println("Area of Triangle:"+obj_shape.getArea());
    }
}

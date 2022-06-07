package day11assignment;

class Shape1{
    public double calculateArea(int radius){
        return Math.PI*(radius*radius);
    }

    public float calculateArea(int length,int width){
        return length*width;
    }

    public float calculateArea(int length,int width,int height){
        return 2*((length*width)+(length*height)+(width*height));
    }

}

public class ShapeTest1 {
    public static void main(String args[]){
        Shape1 obj_shape=new Shape1();

        System.out.println("Circle Area:"+obj_shape.calculateArea(3));
        System.out.println("Rectangle Area:"+obj_shape.calculateArea(3,7));
        System.out.println("Rectangular Cube Area:"+obj_shape.calculateArea(4,2,8));
    }
}

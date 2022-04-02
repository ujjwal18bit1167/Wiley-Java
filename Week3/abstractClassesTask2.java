package Week3;

abstract class Shape {
    String name;
    double area;
    double perimeter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    abstract double calculateArea();

    abstract double calculatePerimeter();

    void draw() {
        System.out.println(this.name + " is drawn");
    }

}

class Rectangle extends Shape {
    double length;
    double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
        this.name = "Rectangle";

    }

    @Override
    double calculateArea() {
        setArea(length * breadth);
        return getArea();
    }

    @Override
    double calculatePerimeter() {
        setPerimeter(2 * (length + breadth));
        return getPerimeter();
    }

}

class Square extends Shape {
    double side;

    public Square(double side) {
        this.side = side;
        this.name = "Square";

    }

    @Override
    double calculateArea() {
        setArea(side * side);
        return getArea();
    }

    @Override
    double calculatePerimeter() {
        setPerimeter(4 * side);
        return getPerimeter();
    }

}

class Circle extends Shape {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
        this.name = "Circle";
    }

    @Override
    double calculateArea() {
        setArea(3.14 * radius * radius);
        return getArea();
    }

    @Override
    double calculatePerimeter() {
        setPerimeter(2 * 3.14 * radius);
        return getPerimeter();
    }

}

public class abstractClassesTask2 {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(20, 5);// here Shape (parent class 's reference)because we do not want to use
                                               // other new methods. Only
                                               // overriden methods are used
        System.out.println(rectangle.getName());
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
        rectangle.draw();
        Shape square = new Square(5);
        System.out.println(square.getName());
        System.out.println(square.calculateArea());
        System.out.println(square.calculatePerimeter());
        square.draw();

        Shape circle = new Circle(5);
        System.out.println(circle.getName());
        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
        circle.draw();

    }
}

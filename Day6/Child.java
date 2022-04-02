package Day6;

class Parent {

    public void show() {
        System.out.println("Show of parent ");
        this.display();
    }

    public void display() {
        System.out.println("Display of parent");
    }

}

public class Child extends Parent {

    public void show() {
        System.out.println("Show of child ");
        super.show();
    }

    public void display() {
        System.out.println("Display of child");
    }

    public static void main(String[] args) {
        Parent obj = new Child();
        obj.show();
    }

}
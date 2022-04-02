package basicinjection;

class Foo {
    private String name;

    public Foo() {

    }

    public Foo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Bar {
    private String name;
    private int age;
    private Foo foo;

    public Bar() {

    }

    public Bar(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public void processFooName() {
        System.out.println("Name in Injected Foo is " + foo.getName());
    }

    @Override
    public String toString() {
        return "Bar [age=" + age + ", name=" + name + "]";
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        Foo myFoo = new Foo("myFooName");
        System.out.println(myFoo.getName());
        Bar bar = new Bar("bar_Name", 10);
        bar.setFoo(myFoo);
        System.out.println(bar);
    }
}

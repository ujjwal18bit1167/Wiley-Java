package Day5;

class Calculator {

    int a;
    int b;
    int c;
    int d;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    long sum(int a, int b) {
        setA(a);
        setB(b);
        return a + b;
    }

    long sum(int a, int b, int c) {
        setA(a);
        setB(b);
        setC(c);
        return a + b + c;
    }

    long sum(int a, int b, int c, int d) {
        setA(a);
        setB(b);
        setC(c);
        setD(d);
        return a + b + c + d;
    }

}

public class CalculatorUse {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setA(10);
        c.setB(20);
        c.setC(30);
        c.setD(40);
        System.out.println(c.sum(c.getA(), c.getB(), c.getC(), c.getD()));
    }

}

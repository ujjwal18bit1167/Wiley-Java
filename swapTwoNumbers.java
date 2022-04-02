public class swapTwoNumbers{

    public static void main(String[] args)
    {
        int a = 5;
        int b = 6;
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("First number is "+a);
        System.out.println("Second number is "+b);
    }
}
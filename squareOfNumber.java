public class squareOfNumber
{

    public static long square(int a)
    {
        return (long)a * a;
    }
    public static void main(String[] args)
    {
        System.out.println(square(2147483647));
    }
}
public class checkEvenOrOdd {
    public static boolean EvenOrOdd(int a)
    {
     // return a%2==0 ? true : false;
     return a%2==0;
    }
    public static void main(String[] args) {
        if(EvenOrOdd(5))
          System.out.println("Even");
        else
           System.out.println("Odd");  
    }
}

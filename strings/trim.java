package strings;

public class trim {
    public static void main(String[] args) {

        String mystr = "   My name is Ujjwal    ";

        int n = mystr.length();
        int i = 0;
        while (mystr.charAt(i) == ' ') {
            i++;
        }
        int j = n - 1;
        while (mystr.charAt(j) == ' ') {
            j--;
        }
        // System.out.println(mystr);
        System.out.println(mystr.substring(i, j + 1));
    }
}

package strings;

public class task1 {
    public static void main(String[] args) {
        String str1 = "Tom Marvolo Riddle";
        String str2 = "I am Lord Voldemort";
        int n1 = str1.length();
        int n2 = str2.length();
        str1 = str1.replace(" ", "");
        str1.toLowerCase();
        str2 = str2.replace(" ", "");
        str2.toLowerCase();
        boolean flag = false;
        if (n1 != n2) {
            System.out.println("Not anagram...");
            flag = true;
        } else if (str1.equals(str2)) {
            System.out.println("Not anagram");
            flag = true;
        }

        else {
            int hash[] = new int[26];
            for (int i = 0; i < n1; i++) {
                hash[str1.charAt(i) - 97]++;
            }
            for (int i = 0; i < n2; i++) {
                hash[str2.charAt(i) - 97]--;
            }
            for (int i = 0; i < 26; i++) {
                if (hash[i] != 0) {
                    System.out.println("Not anagrams.");
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println("Anagrams.");

        }

    }
}

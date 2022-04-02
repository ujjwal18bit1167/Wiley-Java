import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Shivank {
    public static int maxPathSum(ArrayList<ArrayList<Integer>> arr, int i, int j, int row, int col) {
        if (j == col)
            return 0;
        if (i == row - 1)
            return arr.get(i).get(j);
        return arr.get(i).get(j)
                + Math.max(maxPathSum(arr, i + 1, j, row, col), maxPathSum(arr, i + 1, j + 1, row, col));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        String line = null;

        while ((line = br.readLine()) != null) {
            String myStrArr[] = line.split(" ");
            int n = myStrArr.length;
            ArrayList<Integer> sub = new ArrayList<>();
            for (String i : myStrArr) {
                sub.add(Integer.parseInt(i));
            }
            arr.add(sub);
            line = br.readLine();
        }
        br.close();
        int n = arr.size();
        for (ArrayList<Integer> i : arr)
            System.out.println(i);
        System.out.println(maxPathSum(arr, 0, 0, n, n));
    }
}
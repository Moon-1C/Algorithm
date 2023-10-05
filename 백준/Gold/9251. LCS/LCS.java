import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();

        int aSize = word1.length();
        int bSize = word2.length();

        int[][] arr = new int[aSize + 1][bSize + 1];

        for (int i =1; i <=aSize; i++) {
            for (int j = 1; j <=bSize; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }


            }
        }
        System.out.println(arr[aSize][bSize]);



    }


}

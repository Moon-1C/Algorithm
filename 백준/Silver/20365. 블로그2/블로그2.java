import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        String str = br.readLine();

        char first = str.charAt(0);
        char prev = first;
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == first) {
                if (prev == first) {
                    continue;
                } else {
                    prev = first;
                    count++;
                }

            } else {
                prev = 'N';
            }
        }

        if (prev != first) {
            count++;
        }

        System.out.println(count);
        




    }


}

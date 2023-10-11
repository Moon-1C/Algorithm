import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String answer = "";


        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'X') {
                count++;
                if (count == 4) {
                    answer += "AAAA";
                    count = 0;
                }
            }else {
                if (count == 0) {
                    answer += '.';
                }
                else if (count == 2) {
                    answer += "BB.";
                    count = 0;
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if (count == 0) {
        }
        else if (count == 2) {
            answer += "BB";
        } else if (count == 4) {
            answer += "AAAA";
        } else {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);





    }




}

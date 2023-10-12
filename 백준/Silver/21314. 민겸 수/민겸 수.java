import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String min = "";
        String max = "";

        int Mcount = 0;
        //max의 경우
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'M') {
                Mcount++;

                if (i == str.length() - 1) {
                    max += 1;
                    for (int j = 0; j < Mcount - 1; j++) {
                        max += 1;
                    }
                }

            } else {
                max += "5";
                for (int j = 0; j <Mcount ; j++) {
                    max += "0";
                }
                Mcount = 0;
            }

        }
        Mcount = 0;
        //min인경우
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'M') {
                Mcount++;

                if (i == str.length() - 1) {
                    min += 1;
                    for (int j = 0; j < Mcount - 1; j++) {
                        min += 0;
                    }
                }

            } else {
                if (Mcount != 0) {
                    min += 1;
                    for (int j = 0; j < Mcount - 1; j++) {
                        min += 0;
                    }

                }

                Mcount = 0;
                min += "5";
            }
        }





        System.out.println(max);
        System.out.println(min);



    }


}

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();
        long e = sc.nextLong();

        boolean[] arr = new boolean[(int)(e-s+1)];

        for (long i = 2; i *i<=e; i++) {
            long pow = i*i;
            long count=s/pow;
            if (s%pow!=0) {
                count++;
            }

            for (long j = count; pow * j <= e; j++) {
                arr[(int) ((j * pow) - s)] = true;
            }

        }
        int answer=0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                answer++;
            }
        }


        System.out.println(answer);



    }


}



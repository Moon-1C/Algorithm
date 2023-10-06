import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Long K = sc.nextLong();

        System.out.println(fun(K-1));

    }

    static long fun(Long x) {
        if (x == 0L) {
            return 0L;
        } else if (x == 1L) {
            return 1L;
        } else if (x % 2 == 0) {
           return fun(x / 2);
        } else {
            return 1 - fun(x / 2);
        }



    }


}


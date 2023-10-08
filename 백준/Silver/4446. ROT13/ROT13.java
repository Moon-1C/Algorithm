import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Character[] vowels = {'a', 'i', 'y', 'e', 'o','u'};
    static Character[] consonants = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm','f'};

    public static void main(String[] args) throws IOException {

        List<Character> vowelList = new ArrayList<>(Arrays.asList(vowels));
        List<Character> consonantsList = new ArrayList<>(Arrays.asList(consonants));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        StringBuffer sb = new StringBuffer();
        String str="";

        while ((str = br.readLine()) != null ) {


                for (int i = 0; i < str.length(); i++) {
                    char now = str.charAt(i);
                    boolean isCapital = false;
                    if (Character.isUpperCase(now)) {
                        isCapital = true;
                        now = Character.toLowerCase(now);
                    }

                    if (vowelList.contains(now)) {
                        int index = vowelList.indexOf(now);


                        now = vowelList.get((index + 3) % 6);

                    } else if (consonantsList.contains(now)) {
                        int index = consonantsList.indexOf(now);

                        now = consonantsList.get((index + 10) % 20);

                    }
                    if (isCapital) {
                        now = Character.toUpperCase(now);
                    }

                    sb.append(now);

                }
                sb.append("\n");
            }


        System.out.println(sb);






    }



}

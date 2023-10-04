import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int maxFive=input/5;
        int NoCase= -1;
        for(int i = maxFive;i>=0;i--){
            if((input-i*5)%3==0){
                int five = i ;
                int three = (input-i*5)/3;
                NoCase=0;

            System.out.println(five+three);
            break;
            }

        }
        if(NoCase ==-1)
            System.out.println(-1);

    }
}
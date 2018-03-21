import java.util.Scanner;

public class a2 {
    public static void main(String args[]){
        String x="";
        Scanner in=new Scanner(System.in);
        for(int i=1;i<=5;i++){
            x+=in.next();
        }
        System.out.println(x);
    }
}

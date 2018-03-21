import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
public class a1{
    public static void main(String args[]){
        calculate ca=new calculate();
        ca.calc();
    }
}
class calculate{
    Stack<String> stringStack=new Stack<>();
    Stack<Double> doubleStack=new Stack<>();
    String num[]=new String[100];
    String num2[]=new String[100];
    void calc(){
        Scanner in=new Scanner(System.in);
        String single="";
        int n=0;
        String prech="";
        while(true) {
            String ch = in.next();
            if (check(ch) > 0) {
                if(ch.equals("C")){
                    single="";
                    continue;
                }
                if(check(prech)<0){
                    n++;
                    num[n] = single;
                    single = "";
                }
            }
            if (ch.equals("=")) break;
            if(check(ch)<0&&check(prech)>0&&check(prech)<3){
                n++;
                num[n] = prech;
            }
            if (check(ch) < 0){
                single += ch;
            }
            prech=ch;
        }
 //       for(int j=1;j<=n;j++) System.out.println(num[j]);
        int t=0;
        for(int i=1;i<=n;i++){
            if(check(num[i])<0){
                t++;
                num2[t]=num[i];
            }
            if(check(num[i])>0){
                if(stringStack.empty()){
                    stringStack.push(num[i]);
                    continue;
                }
                if(check(num[i])>=check(stringStack.peek())){
                    while(!stringStack.empty()&&check(num[i])>=check(stringStack.peek())){
                        t++;
                        num2[t]=stringStack.peek();
                        stringStack.pop();
                    }
                    stringStack.push(num[i]);
                }else stringStack.push(num[i]);
            }
        }
        while(!stringStack.empty()){
            t++;
            num2[t]=stringStack.peek();
            stringStack.pop();
        }
        for(int i=1;i<=t;i++) System.out.println(num2[i]);

    }
    private int check(String ch){
        if(ch.equals("AC")) return 3;
        if(ch.equals("+")) return 2;
        if(ch.equals("-")) return 2;
        if(ch.equals("*")) return 1;
        if(ch.equals("/")) return 1;
        if(ch.equals("%")) return 1;
        if(ch.equals("=")) return 5;
        if(ch.equals("C")) return 4;
        return -1;
    }
}
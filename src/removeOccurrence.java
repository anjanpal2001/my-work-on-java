import java.util.*;
public class removeOccurrence {

    static  String removeA(String s, int idx  ){
        if(idx==s.length())return "";
        String smallans=removeA(s, idx+1);
        char currchaar=s.charAt(idx);
        if(currchaar!='a'){
            return currchaar+smallans;
        }else return smallans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
           System.out.println(removeA("anjan", 0));
    }

}
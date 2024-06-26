import java.util.*;
public class PossibleValidPermutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
           int[] arr =new int [n];
           for (int i=0;i<n;i++){
               arr[i]=sc.nextInt();
           }
           boolean flag=true;
            for (int i=1;i<=n;i++){
                boolean found = false;
               for(int j=0;j<n;j++){
               if(arr[j]<=i){
                   arr[j]=Integer.MAX_VALUE;
                   found = true;
                   break;
               }
               }
                if (!found) {
                    flag = false;
                    break;  // If an element <= i is not found, stop further processing.
                }
            }
            System.out.println(flag?"YES":"NO");
            }

        }
    }


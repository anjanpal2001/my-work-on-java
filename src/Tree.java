
import java.util.*;
import java.lang.*;

public class Tree
{
    public static class Node{
        int val ;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static int calculate_height(Node root){
        if(root==null||(root.left==null&&root.right==null))return 0;
        return 1+Math.max(calculate_height(root.left),calculate_height(root.right));

    }
    public static void nthLevel(Node root,int n){
        if(root==null) return ;
        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
        nthLevel(root.left,n-1);
        nthLevel(root.right, n-1);
    }
    public static void BfsTreversal_of_tree(Node root){
        Queue <Node> q=new LinkedList<>();
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
            Node temp=q.remove();
            if(temp.left!=null)q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            System.out.print(temp.val+"->");
        }
    }
    public static int Sum(Node root){
        if(root ==null) return 0;
        int result=root.val+Sum(root.left)+Sum(root.right);
        return result;
    }
    public static void display(Node root){
        if(root==null) return;
        if(root.left!=null) {
            System.out.print( root.left.val+" ");
        }
        if(root.right!=null) {
            System.out.print( root.right.val+" ");
        }
//        System.out.println();
        display(root.left);
        display(root.right);
    }
    public static Node ConstructBfs(String arr[]){
        int x=Integer.parseInt(arr[0]);
        int n=arr.length;
        Node root=new Node(x);
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(i<n){
            Node temp=q.remove();
            Node left=new Node(10);
            Node right=new Node(200);
            if(arr[i].equals("")) left=null;
            else{
                int l=Integer.parseInt(arr[i]);
                left.val=l;q.add(left);
            }
            i++;
            if(arr[i].equals(""))  right=null;
            else{
                int r=Integer.parseInt(arr[i]);
                right.val=r;
                q.add(right);

            }
            i++;
            temp.left=left;
            temp.right=right;
//            i=i+2;

        }
        return root;
    }
    public static void main (String[] args)
    {
        String []arr={
                "1","2","3","4","5","","6","","7","","","8","","","","9","","10","11","12","","","","13","14"
        };
        Node root=ConstructBfs(arr);
        System.out.println();
        System.out.println("total sum = "+Sum(root));
        System.out.println( "height of the tree is-> "+calculate_height(root));
        BfsTreversal_of_tree(root);
        System.out.println();
        int v=calculate_height(root);
        for (int i=1;i<=v+1;i++){
            System.out.print(i+"th level is-> ");
            nthLevel(root,i);
            System.out.println();
        }




    }
}

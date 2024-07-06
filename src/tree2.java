import java.util.*;
public class tree2 {
    public static Tree.Node Construct_Bfs(String arr[]) {
        int x = Integer.parseInt(arr[0]);
        int n = arr.length;
        Tree.Node root = new Tree.Node(x);
        Queue<Tree.Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < n) {
            Tree.Node temp = q.remove();
            if (i < n && !arr[i].equals("null")) {
                int l = Integer.parseInt(arr[i]);
                Tree.Node left = new Tree.Node(l);
                temp.left = left;
                q.add(left);
            } else {
                temp.left = null;
            }
            i++;
            if (i < n && !arr[i].equals("null")) {
                int r = Integer.parseInt(arr[i]);
                Tree.Node right = new Tree.Node(r);
                temp.right = right;
                q.add(right);
            } else {
                temp.right = null;
            }
            i++;
        }
        return root;
    }
    public static int calculate_height(Tree.Node root){
        if(root==null||(root.left==null&&root.right==null))return 0;
        return 1+Math.max(calculate_height(root.left),calculate_height(root.right));

    }
    public static void nthLevel(Tree.Node root, int n){
        if(root==null) return ;
        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
        nthLevel(root.left,n-1);
        nthLevel(root.right, n-1);
    }

    public static void main(String[] args) {
        String []arr={
                "1","2","3","4","5","null","6","null","7","null","null","8","null","null","null","9","null"
        };
        Tree.Node root=Construct_Bfs(arr);
        int v=calculate_height(root);
        for (int i=1;i<=v+1;i++){
            System.out.print(i+"th level is-> ");
            nthLevel(root,i);
            System.out.println();
        }
    }
}

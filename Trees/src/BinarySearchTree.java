public class BinarySearchTree {
    Node root;

    class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }
    }

    public void insert(int value){
        root=insertRecursion(root,value);
    }

    private Node insertRecursion(Node root, int value)  {
        if(root==null){
            root=new Node(value);
            return root;
        }
        else if(value<root.data){
            root.left = insertRecursion(root.left, value);
        }
        else{
            root.right = insertRecursion(root.right, value);
        }
        return root;
    }

    public void display(){
        displayRecursion(root);
    }

    private void displayRecursion(Node root){
        if(root!=null){
            //Ενδοδιατεταγμενη Διαδρομη
            displayRecursion(root.left);
            System.out.println(root.data);
            displayRecursion(root.right);
        }
    }

    public boolean search(int data){
        return searchRecursion(root,data);
    }

    private boolean searchRecursion(Node root, int data){

        if(root==null){
            return false;
        }
        else if(root.data==data){
            return true;
        }
        else if (data<root.data){
            return searchRecursion(root.left, data);
        }
        else{
            return searchRecursion(root.right, data);
        }
    }

    public void remove(int data)    {
        if(search(data)){
            removeRecursion(root, data);
        }
        else{
            System.out.println(data +" Could not be found");
        }
    }

    private Node removeRecursion(Node root, int data){
        if(root==null){
            return null;
        }
        else if(data<root.data){
            root.left = removeRecursion(root.left,data);
        }
        else if(data>root.data){
            root.right = removeRecursion(root.right,data);
        }
        else{ //node found

            //Case 1: No Child
            if(root.left==null && root.right==null){ //to node den exei paidia
                return null;
            }
            //Case 2:
            //Only One Children (right Children)
            else if(root.left==null && root.right!=null){
                return root.right;
            }
            //Only One Children (left Children)
            else if(root.right==null && root.left!=null){
                return root.left;
            }
            //Case 3: 2 Children
            else{
                root.data = minValue(root.right);
                root.right = removeRecursion(root.right, root.data);
            }
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
}

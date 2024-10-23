package mypackage;

class Node 
{
  char data;
  Node l;
  Node r;

  public Node(char data) {
      this.data = data;
      this.l = null;
      this.r = null;
  }
}

class ST {
  Node head;

  public ST(Node head) {
      this.head = head;
  }
}

public class TreeJoinTest {
  
  private static Node joinR(Node a, Node b) {
      // Recursive method to join two trees
      if (b == null) {
          return a;
      }

      if (a == null) {
          return b;
      }
      System.out.println("=====================================");
      System.out.println("TREE A\n");
      printTree(a, 0);
      System.out.println("\nTREE B Before \n");
      printTree(b, 0);
      
      b= insertT(b, a.data);
      System.out.println("\nTREE B After \n");
      printTree(b, 0);
      b.l = joinR(a.l, b.l);
      b.r = joinR(a.r, b.r);
      return b;
  }

  private static Node insertT(Node h, char x) 
  {
      // Recursive method to insert an item into the tree root
      if (h == null) 
      {
          return new Node(x);
      }
//      System.out.println("x="+x+" x="+h.data+" "+(x<h.data));
      if (x<h.data) 
      {
          // Insert into the left subtree and perform a right rotation
          h.l = insertT(h.l, x);
          h = rotR(h);
      } 
      else 
      {
          // Insert into the right subtree and perform a left rotation
          h.r = insertT(h.r, x);
          h = rotL(h);
      }
      //printTree(h, 0);
      return h;
  }
  public static Node rotR(Node h) 
  {
      // Right rotation operation
      Node x = h.l;
      h.l = x.r;
      x.r = h;
      return x;
  }

  public static Node rotL(Node h) 
  {
      // Left rotation operation
      Node x = h.r;
      h.r = x.l;
      x.l = h;
      return x;
  }
  public static void join(ST a, ST b) {
      // Public method to join the current tree with another tree
      a.head = joinR(a.head, b.head);    
  }

  // Function to print inorder traversal of the tree
  public static void inorder(Node root) {
      if (root != null) {
          inorder(root.l);
          System.out.print(root.data + " ");
          inorder(root.r);
      }
  }

  public static void printTree(Node node, int depth) {
      if (node == null) {
          printIndent(depth);
          System.out.println("null");
          return;
      }

      printIndent(depth);
      System.out.println("value: " + node.data);
      if (node.l != null || node.r != null) {
          printIndent(depth);
          System.out.println("├─ Left:");
          printTree(node.l, depth + 1);

          printIndent(depth);
          System.out.println("└─ Right:");
          printTree(node.r, depth + 1);
      }
  }
  
  private static void printIndent(int depth)
	{
		for (int i = 0; i < depth; i++)
		{
			System.out.print("    "); // Adjust the number of spaces as needed
		}
	}
  public static void main(String[] args) {
      // Create the first tree
	// Create the first tree
	  Node rootA = new Node('G');
	  rootA.l = new Node('E');
	  rootA.l.l = new Node('A');
	  rootA.r = new Node('M');
	  rootA.r.r = new Node('R');
	  rootA.r.l = new Node('I');
	  ST treeA = new ST(rootA);

	  // Create the second tree
	  Node rootB = new Node('N');
	  rootB.l = new Node('H');
	  rootB.l.l = new Node('C');
	  rootB.r = new Node('X');
	  rootB.r.l = new Node('S');
	  rootB.r.l.l = new Node('P');

      ST treeB = new ST(rootB);
     
      // Join the trees
      join(treeA, treeB);
      System.out.println("=================End================");
      System.out.println("TREE A\n");
      printTree(treeA.head, 0);
      System.out.println("\nTREE B\n");
      printTree(treeB.head, 0);
      // Print the inorder traversal of the joined tree
      //System.out.println("Inorder traversal of the joined tree:");
      //inorder(treeA.head);
  }
}

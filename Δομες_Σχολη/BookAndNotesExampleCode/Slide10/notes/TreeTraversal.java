package notes;

class TreeNode
{
	int val;
	TreeNode left, right;

	TreeNode(int value)
	{
		val = value;
		left = null;
		right = null;
	}
}

public class TreeTraversal
{
	TreeNode root;

	TreeTraversal()
	{
		root = null;
	}

	// Preorder traversal: Root, Left, Right
	void preOrder(TreeNode node)
	{
		if (node != null)
		{
			System.out.print(node.val + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	// Inorder traversal: Left, Root, Right
	void inOrder(TreeNode node)
	{
		if (node != null)
		{
			inOrder(node.left);
			System.out.print(node.val + " ");
			inOrder(node.right);
		}
	}

	// Postorder traversal: Left, Right, Root
	void postOrder(TreeNode node)
	{
		if (node != null)
		{
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.val + " ");
		}
	}

	public static void main(String[] args)
	{
		TreeTraversal tree = new TreeTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("Preorder traversal:");
		tree.preOrder(tree.root);

		System.out.println("\nInorder traversal:");
		tree.inOrder(tree.root);

		System.out.println("\nPostorder traversal:");
		tree.postOrder(tree.root);
	}
}

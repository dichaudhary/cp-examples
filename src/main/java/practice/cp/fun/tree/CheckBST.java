package practice.cp.fun.tree;

public class CheckBST {

    public static void main(String ... args) {
        BinaryNode root = new BinaryNode(10);
        root.left = new BinaryNode(7);
        root.right = new BinaryNode(39);
        root.left.right = new BinaryNode(9);
        System.out.println(isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }


    static boolean isBST(BinaryNode root)
    {
        //wrong approach
        if (null == root.left && null == root.right) {
            return true;
        } else if (null == root.left) {
            return root.data <= root.right.data;
        } else if (null == root.right) {
            return root.data >= root.left.data;
        }
        boolean result =  isBST(root.left) && isBST(root.right);
        result &= (root.data >= root.left.data) && (root.data <= root.right.data);
        return result;
    }

    static boolean isBSTUtil(BinaryNode node, int min, int max)
    {
        //tricky but right approach
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }
}


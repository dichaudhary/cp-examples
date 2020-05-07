package practice.cp.fun.recursion;

import practice.cp.fun.tree.BinaryNode;

//Lowest Common Ancestor
public class LCA {
    public static void main(String ... args) {
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
       /* root.right.left = new BinaryNode(4);
        root.right.right = new BinaryNode(6);
        root.right.left.right = new BinaryNode(5);*/
        BinaryNode node = findLCA(root, 2, 3);
        System.out.println(node.data);
    }

    public static BinaryNode findLCA(BinaryNode root, int num1, int num2) {
        if (null != root) {
            if (root.data == num1 || root.data==num2) {
                return root;
            }
            if (null != root.right ) {
                if ((root.right.data == num1 || root.right.data == num2) && findLCA(root.right, num1, num2) != null) {
                    return root.right;
                }

                if ((root.left.data == num1 || root.left.data == num2) && findLCA(root.left, num1, num2) != null) {
                    return root.left;
                }

                if (findLCA(root.left, num1, num2) == null) {
                    return findLCA(root.right, num1, num2);
                }
                return findLCA(root.left, num1, num2);
            }

        }

        return null;
    }
}

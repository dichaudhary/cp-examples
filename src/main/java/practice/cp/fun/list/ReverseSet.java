package practice.cp.fun.list;

public class ReverseSet {
    public static void main(String [] args) {
        Node head = new Node(1);
        Node ptr2;
        Node ptr = ptr2 = head;
        for (int i=2; i<=10; i++) {
           ptr.next = new Node(i);
           ptr = ptr.next;
        }
        Node newHead = head;
        int j=4;
        while (j > 1) {
            newHead = newHead.next;
            j--;
        }
        //head.next = reverse(head, 4);
        Node node = newHead;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    /*public static Node reverse(Node node, int k) {
        Node first, second, third = null;
        first = node;
        second = node.next;
        third = node.next.next;
        first.next = null;
        if (third != null) {
            while (third.next != null && k-- != 2) {
                second.next = first;
                first = second;
                second = third;
                third = third.next;
            }
            second.next = first;
            node.next = reverse(node.next, 4);
        }
    }*/

    public static Node reverse(Node node) {
        Node first, second, third = null;
        first = node;
        second = node.next;
        third = node.next.next;
        first.next = null;
        while (third.next != null) {
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }
        second.next = first;
        third.next = second;
        return third;
    }
}

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

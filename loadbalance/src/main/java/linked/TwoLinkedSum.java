package linked;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class TwoLinkedSum {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p = l1,q = l2,curr = node;
        int number = 0;
        int data1 = 0;
        int data2 = 0;
        while(p != null || q != null || number != 0){
            if(p == null){
                data1 = 0;
            } else {
                data1 = p.val;
                p = p.next;
            }
            if(q == null){
                data2 = 0;
            } else {
                data2 = q.val;
                q = q.next;
            }

            curr.next = new ListNode((data1 + data2 + number) % 10);
            curr = curr.next;
            number = (data1 + data2 + number) / 10;
        }
        return node.next;
    }



    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }



    public static void main(String[] args) {
        ListNode node1 = new TwoLinkedSum().new ListNode(2);
        ListNode node1_1 = new TwoLinkedSum().new ListNode(4);
        ListNode node1_2 = new TwoLinkedSum().new ListNode(3);
        node1.next=node1_1;
        node1_1.next=node1_2;
        ListNode node2 = new TwoLinkedSum().new ListNode(5);
        ListNode node2_1 = new TwoLinkedSum().new ListNode(6);
        ListNode node2_2 = new TwoLinkedSum().new ListNode(4);
        node2.next=node2_1;
        node2_1.next=node2_2;

       TwoLinkedSum twoLinkedSum =  new TwoLinkedSum();

        ListNode newListNode =  twoLinkedSum.addTwoNumbers(node1,node2);
        System.out.println(newListNode.val);
        System.out.println(newListNode.next.val);
        System.out.println(newListNode.next.next.val);
    }

}

package linked;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLinkedList {

    class ListNode {

        int val;
        ListNode next;

        ListNode(){}

        ListNode(int val) {
            this.val= val;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode mergeTwoLinkedList(ListNode node1,ListNode node2) {

        if (node1==null) {
            return node2;
        }else if (node2==null) {
            return node1;
        } else if (node1==null&&node2==null) {
            return null;
        } else if (node1.val<node2.val) {
            node1.next = mergeTwoLinkedList(node1.next,node2);
            return node1;
        }else {
            node2.next = mergeTwoLinkedList(node1,node2.next);
            return node2;
        }

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {

        ListNode rootNode1 = new MergeTwoLinkedList().new ListNode(1);
        ListNode node11 = new MergeTwoLinkedList().new ListNode(2);
        ListNode node12 = new MergeTwoLinkedList().new ListNode(4);

        rootNode1.next = node11;
        node11.next= node12;

        ListNode rootNode2 = new MergeTwoLinkedList().new ListNode(1);
        ListNode node21 = new MergeTwoLinkedList().new ListNode(3);
        ListNode node22 = new MergeTwoLinkedList().new ListNode(4);
        rootNode2.next = node21;
        node21.next= node22;

        MergeTwoLinkedList twoLinkedList = new MergeTwoLinkedList();
        ListNode resultListNode = twoLinkedList.mergeTwoLinkedList(rootNode1,rootNode2);
        System.out.println(resultListNode.val);
        System.out.println(resultListNode.next.val);
        System.out.println(resultListNode.next.next.val);
        System.out.println(resultListNode.next.next.next.val);
        System.out.println(resultListNode.next.next.next.next.val);
        System.out.println(resultListNode.next.next.next.next.next.val);
    }
}

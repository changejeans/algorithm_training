package week01;


//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class ReverseLinkedlist {
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }

        ListNode prev=null;
        ListNode curr=head;

        ListNode recordNode=null;
        while(curr!=null){
            recordNode=curr.next; // 把节点数据做备份，一旦反转，就获取不到该节点
            curr.next=prev; // 当前节点的指针 指向 前一个节点
            prev=curr;  // 当前节点 变更为 前一个节点
            curr=recordNode;  // 正常的循环 curr = curr.next,这里需要取 备份的节点
        }

        return prev;
    }


    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;

        ReverseLinkedlist reverseLinkedlist = new ReverseLinkedlist();
        System.out.println(reverseLinkedlist.reverseList(node).val); // 打印头结点

    }
}
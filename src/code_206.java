public class code_206 {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head = reverseList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = head;
        while (p.next != null){
            ListNode q = p.next;
            p.next = q.next;
            q.next = pre.next;
            pre.next = q;
        }
        return pre.next;
    }

}

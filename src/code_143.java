public class code_143 {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        reorderList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void reorderList(ListNode head)  {
        if (head == null || head.next == null){
            return;
        }
        ListNode slow = head,fast = head.next;
        while (fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        //反转head2
        ListNode head3 = reversalList(head2);
        ListNode head4 = head;
        while (head4 !=null && head3 !=null){
            ListNode p = head4.next, q = head3.next;
            head4.next = head3;
            head3.next = p;
            head4 = p;
            head3 = q;
        }

    }

    public static ListNode reversalList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = head;
        while (p!=null &&p.next !=null){
            ListNode q = p.next;
            p.next = q.next;
            q.next = pre.next;
            pre.next = q;
        }
        return pre.next;
    }

}

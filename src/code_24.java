import javax.swing.event.ListDataEvent;

public class code_24 {
    public static void main(String [] args){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(6);
        head1.next.next.next.next = new ListNode(7);

        ListNode ret = swapPairs( head1);
        while (ret != null){
            System.out.println(ret.val);
            ret=ret.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode ret = new ListNode(0) ;
        ret.next = head.next;
        ListNode headpre = ret;
        while (head != null && head.next!=null){
            head = swapTwoNode(head);
            headpre.next = head;
            headpre = head.next;
            head = head.next.next;
        }

        return ret.next;
    }

    public static ListNode swapTwoNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode head2 = head.next;
        head.next = head2.next;
        head2.next = head;
        return head2;
    }
}

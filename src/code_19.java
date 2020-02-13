import java.util.Arrays;

public class code_19 {
    public static void main(String [] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 6;
        ListNode ret = removeNthFromEnd( head,  n);
        while (ret != null){
            System.out.println(ret.val);
            ret=ret.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head, last = head;
        int point1 = 1;
        while (point1 <= n){
            if (last == null){
                return head;
            }
            last = last.next;
            point1++;
        }
        if (last == null){
            return head.next;
        }
        while (last.next != null){
            first = first.next;
            last = last.next;
        }
        first.next =first.next.next;
        return  head;
    }
}

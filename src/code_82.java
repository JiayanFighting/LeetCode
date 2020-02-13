import java.util.List;

public class code_82 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode ret = deleteDuplicates(head);
        while (ret!=null){
            System.out.print(ret.val+" ");
            ret = ret.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre =  new ListNode(0);
        pre.next = head;
        ListNode prehead = pre;
        ListNode p = head;
        while (p != null && pre !=null){//?
            ListNode q = p.next;
            boolean flag = false;
            while ( q != null && p.val == q.val){
                q =q.next;
                flag = true;
            }
            if (flag){
                pre.next = q;
                p = q;
            }else {
                pre = pre.next;
                p = p.next;
            }

        }
        return prehead.next;
    }


}

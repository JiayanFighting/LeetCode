public class code_86 {
    public static void main(String[] args){
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode ret = partition(head,4);
        while (ret!=null){
            System.out.print(ret.val+" ");
            ret = ret.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = pre;
        ListNode bound = pre;//-1 1 4 3 2 5 2
        while (p.next != null && p.next.val < x){
            bound = bound.next;
            p =p.next;
        }
        while (p.next != null){
            if (p.next.val < x){
                //change
                ListNode q = p.next;
                p.next = q.next;
                q.next = bound.next;
                bound.next = q;
                bound = bound.next;
            }else { // p.val >= x
                p = p.next;
            }
        }
        return pre.next;
    }


}

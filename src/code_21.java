public class code_21 {
    public static void main(String [] args){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(6);
        head1.next.next.next.next = new ListNode(7);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode ret = mergeTwoLists( head1,  head2);
        while (ret != null){
            System.out.println(ret.val);
            ret=ret.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode head = ret;
        while (l1 != null && l2 != null){
            if (l1.val<l2.val){
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null){
            head.next = l1;
        }else if (l2 != null){
            head.next = l2;
        }
        return ret.next;
    }

    // 递归
    public static ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

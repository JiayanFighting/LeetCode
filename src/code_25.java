public class code_25 {
    public static void main(String [] args){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        int k =5;
        ListNode ret = reverseKGroup( head1,k);
        while (ret != null){
            System.out.println(ret.val);
            ret=ret.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode head2 = head;
        ListNode ret = new ListNode(0) ;
        int k2 = k;
        while (head2 != null && k2>0){
            ret.next = head2;
            head2 = head2.next;
            k2--;
        }
        if (k2>0){
            return head;
        }


        ListNode headpre = ret;
        while (head != null && head.next!=null){
            head = swapKNode(head,k);
            headpre.next = head;
            headpre = head.next;
            head = head.next.next;
        }

        return ret.next;
    }

    public static ListNode swapKNode(ListNode head,int k){
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode head2 = head;
        int k2 = k;
        while (head2 != null && k2>0){
            head2 = head2.next;
            k2--;
        }
        if (k2>0){
            return head;
        }
        while (k > 1){
            ListNode node = head.next;
            head.next = node.next;
            node.next = ret.next;
            ret.next = node;
            k--;
        }
        return ret.next;
    }
}

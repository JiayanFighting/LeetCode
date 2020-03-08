public class code_25 {
    public static void main(String [] args){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
//        head1.next.next = new ListNode(3);
//        head1.next.next.next = new ListNode(4);
//        head1.next.next.next.next = new ListNode(5);
//        head1.next.next.next.next.next = new ListNode(6);
//        head1.next.next.next.next.next.next = new ListNode(7);
//        head1.next.next.next.next.next.next.next = new ListNode(8);
        int k =2;
        ListNode ret = reverseKGroup( head1,k);
        while (ret != null){
            System.out.println(ret.val);
            ret=ret.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k<=1 || head == null || head.next == null) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead,q = head;
        // 每k个翻转 然后收尾指针同时往后移
        //先走k步
        int step = 1;
        while (q !=null && step <=k){
            q = q.next;
            step ++;
        }
        boolean next = true;
        if (q == null && step <= k){
            next = false;
        }
        while (next){
            // 翻转
            ListNode p = pre.next;
            while (p.next != q){
                ListNode node = p.next;
                p.next = node.next;
                node.next = pre.next;
                pre.next = node;
            }
            // 翻转完毕 pre,q 同时往后移k步
            step = 1;
            while (step <= k && q!=null){
                q = q.next;
                pre = pre.next;
                step++;
            }
            if (q == null && step <= k){
                next = false;
            }
        }
        return preHead.next;
    }
}

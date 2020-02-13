public class code_234 {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        System.out.println(isPalindrome(head));
    }


    //边遍历边反转（反转前半段）
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        //比较
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    //先切割 再反转 再比较
    public static boolean isPalindrome2(ListNode head){
        if (head == null || head.next == null) return true;
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
            if (head4.val != head3.val){
                return false;
            }
            head4 = head4.next;
            head3 = head3.next;
        }
        return true;
    }

    public static ListNode reversalList(ListNode head){
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

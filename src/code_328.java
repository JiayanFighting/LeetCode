public class code_328 {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        ListNode ret = oddEvenList(head);
        while (ret != null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null|| head.next.next == null) return head;
        ListNode even = head.next, evenStart = head.next,odd = even.next,oddEnd = head;
        while (odd != null){
            even.next = odd.next;
            odd.next = evenStart;
            oddEnd.next = odd;
            oddEnd = odd;
            even =even.next;
            if (even !=null){
                odd = even.next;
            }else {
                odd = null;
            }
        }
        return head;
    }
}

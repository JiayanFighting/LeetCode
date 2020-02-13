public class code_203 {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode ret = removeElements(head,6);
        while (ret!=null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val)  {
        if (head == null ) return null;
        ListNode pre = new ListNode(val-1);
        pre.next = head;
        ListNode ret = pre;
        while (head !=null){
            if (head.val == val){
                pre.next = head.next;
                head = head.next;
            }else {
                pre = pre.next;
                head = head.next;
            }
        }
        return ret.next;
    }


}

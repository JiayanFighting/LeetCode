public class code_141 {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        while (head != null && fast != null && fast.next != null){
            fast = fast.next.next;
            head = head.next;
            if (fast == head){
                return true;
            }
        }
        return false;
    }


}

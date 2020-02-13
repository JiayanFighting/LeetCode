public class code_142 {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        System.out.println(detectCycle(head));
    }

    public static ListNode detectCycle(ListNode head)  {
        if (head == null || head.next == null){
            return null;
        }
        boolean flag = false;
        ListNode slow = head , fast = head;
        while (slow != null && fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                flag = true;
                break;
            }
        }
        if (flag){
            slow = head;
            while (slow !=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return null;
    }


}

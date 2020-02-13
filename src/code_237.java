public class code_237 {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        deleteNode(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void deleteNode(ListNode node)  {
        node.val = node.next.val;
        node.next = node.next.next;
    }


}

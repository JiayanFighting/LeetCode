import org.omg.PortableInterceptor.INACTIVE;

public class code_147 {
    public static void main(String[] args){

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(5);
        ListNode ret = insertionSortList(head);
        while (ret!=null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    public static ListNode insertionSortList(ListNode head)  {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode preCheck = head;
        while (preCheck.next != null){
            ListNode check = preCheck.next;
            ListNode index = head;
            //第一个
            if (check.val < index.val){
                preCheck.next = check.next;
                check.next = index;
                pre.next = check;
                head = pre.next;
                continue;
            }
            //最后一个
            if (preCheck.val <= check.val){
                preCheck = preCheck.next;
                continue;
            }
            //从第二个开始
            while (index.next != null && index.next.val < check.val){
                index = index.next;
            }
            //index x x x preCheck check next
            preCheck.next = check.next;
            check.next = index.next;
            index.next = check;
        }
        return pre.next;
    }

}

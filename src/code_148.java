public class code_148 {
    public static void main(String[] args){

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(0);
        ListNode ret = sortList(head);
        while (ret!=null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    // 归并排序
    public static ListNode sortList(ListNode head)  {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head , fast = head.next;
        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(head2);
        if (list1 == null ){
            return list2;
        }else if (list2 == null){
            return list1;
        }
        ListNode retHead = new ListNode(Integer.MIN_VALUE);
        retHead.next = list1;
        ListNode pre = retHead;
        while (list1 !=null && list2 !=null){
            if (list1.val <= list2.val){ // list1 在前面
                pre = pre.next;
                list1 = list1.next;
            }else {
                ListNode q = list2.next;
                list2.next = list1;
                pre.next = list2;
                pre = pre.next;
                list2 = q;
            }
        }
        if (list1 != null){
            pre.next = list1;
        }else {
            pre.next = list2;
        }
        return retHead.next;

    }

}

public class code_160 {
    public static void main(String[] args){

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);

        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        headA.next.next = intersect;
        headB.next.next.next = intersect;

        ListNode ret = getIntersectionNode(headA,headB);
        while (ret!=null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    //双指针
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // 将headA 收尾相连变成环，从headB出发看是否有环
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB)  {
        if (headA == null || headB == null){
            return null;
        }
        // 将headA 收尾相连变成环
        ListNode p = headA;
        while (p.next !=null){
            p =p.next;
        }
        p.next = headA;
        //从headB出发看是否有环
        ListNode ret = detectCycle(headB);
        //恢复headA
        p.next = null;
        return ret;
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

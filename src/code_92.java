import java.util.List;

public class code_92 {
    public static int num = 0;
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode ret = reverseBetween(head,1,2);
        while (ret!=null){
            System.out.print(ret.val+" ");
            ret = ret.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n){
        //1 ≤ m ≤ n ≤ 链表长度
        if (n<=m) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        // 先走n-m步
        int step = 1;
        ListNode q = head;
        while (q!=null && step <= n-m+1){
            q = q.next;
            step++;
        }
        // 同时走m步
        ListNode pre =preHead;
        step = 1;
        while (q!=null && step <m){
            q = q.next;
            pre = pre.next;
            step ++;
        }
        ListNode p = pre.next;
        while (p.next != q){
            ListNode node = p.next;
            p.next = node.next;
            node.next = pre.next;
            pre.next = node;
        }
        return preHead.next;
    }


}

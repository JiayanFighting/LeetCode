import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

public class code_61 {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode ret = rotateRight(head , 21);
        while (ret!=null){
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null||k<=0){
            return head;
        }
        ListNode p = head;
        for (int i = 1;i<=k;i++){
            if (p.next!=null){
                p = p.next;
            }else {
                p = head;
                k=i+k%i;
            }
        }
        ListNode q = head;
        if (p==q){
            return head;
        }
        while (p.next!=null){
            q=q.next;
            p=p.next;
        }
        ListNode ret = q.next;
        p.next = head;
        q.next = null;
        return ret;

    }
}

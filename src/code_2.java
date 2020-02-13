import java.util.ArrayList;
import java.util.List;

public class code_2 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println("");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result_2 = new ListNode(0);
        ListNode result = result_2;
        int add = 0 , v = 0,v1=0,v2=0;
        while (l1 != null ||  l2 != null){
            if (l1 == null){
                v1 = 0;
            }else{
                v1 = l1.val;
            }
            if (l2 == null){
                v2 = 0;
            }else{
                v2 = l2.val;
            }
            v = (v1 + v2+ add)%10 ;
            ListNode node = new ListNode(v);
            add = (v1 + v2+ add)/10;
            result.next = node;
            result = node;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2= l2.next;
            }
        }
        if (add != 0){
            result.next = new ListNode(add);
        }
        return result_2.next;
    }
}

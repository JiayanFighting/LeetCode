public class code_83 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        ListNode ret = deleteDuplicates(head);
        while (ret!=null){
            System.out.print(ret.val+" ");
            ret = ret.next;
        }

//        List<List<Integer>> res = combine(n,k);
//        for (List<Integer> list:res){
//            for (int num:list){
//                System.out.print(num+" ");
//            }
//            System.out.println();
//        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = head.next;
        ListNode pre =  head;
        while (p != null){
            if (p.val == pre.val){//删除p
                pre.next = p.next;
            }else{
                pre = pre.next;
            }
            p = p.next;

        }
        return head;
    }


}

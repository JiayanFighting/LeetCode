public class code_109 {

    public static void main(String[] args){
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(-5);
        TreeNode ret= sortedListToBST(head);
        System.out.println(ret);
    }

    //1.链表转成数组用105
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode head2 = head;
        int num = 0;
        while (head!=null){
            num ++;
            head=head.next;
        }
        int[] nums = new int[num];
        int i = 0;
        while (head2!=null){
            nums[i] = head2.val;
            i++;
            head2 = head2.next;
        }
        return sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public static TreeNode helper(int[] nums,int left,int right){
        if (left > right || left < 0 || left >= nums.length || right >= nums.length) return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }
}

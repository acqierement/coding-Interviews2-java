package listNode;

public class ListUtil {
	public static void travel(ListNode head) {
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode contruct(int[] array) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for(int num:array) {
			ListNode node = new ListNode(num);
			cur.next = node;
			cur = cur.next;
		}
		cur.next =null;
		return head.next;
	}
}

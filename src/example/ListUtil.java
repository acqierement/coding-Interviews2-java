package example;

public class ListUtil {
	
	/**
	 * 遍历链表
	 * @param head
	 */
	public static void travel(ListNode head) {
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	/**
	 * 将数组转换成链表
	 * @param array
	 * @return
	 */
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

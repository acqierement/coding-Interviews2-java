package problems;

/**
 * 25.合并两个排序的链表
 * 牛客：https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337
 * @author acqierement
 * Data: 2018年11月26日
 * Time: 下午5:23:08
 */
public class NO_25 {
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;//别忘了这一行
		}
		
		if(l1 == null) {
			cur.next = l2;
		}
		if(l2 == null) {
			cur.next = l1;
		}
		return head.next;
	}
}

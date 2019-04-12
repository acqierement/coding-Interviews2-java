package problems;

/**
 * 24.反转链表
 * LeetCode 206题
 * 牛客：https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca
 * @author acqierement
 * Data: 2018年11月26日
 * Time: 下午4:31:28
 */
public class NO_24 {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		while(cur != null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}

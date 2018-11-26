package problems;

/**
 * 23.链表中环的入口节点
 * 参考LeetCode 141题 Linked List Cycle
 * @author acqierement
 * Data: 2018年11月26日
 * Time: 下午4:06:42
 */
public class NO_23 {

	//判断是否有环，如果有，返回环内任意一个节点，如果没有，返回null
	public ListNode meetingNode(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode slow = fakeHead;
		ListNode fast = head;
		while(slow != fast) {
			if(fast == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public ListNode entryNodeOfLoop(ListNode head) {
		ListNode meetingNode = meetingNode(head);
		if(meetingNode == null) {
			return null;
		}
		
		//计算环的节点数量
		ListNode pNode1 = meetingNode.next;
		int cycleLength = 1;
		while(pNode1 != meetingNode) {
			pNode1 = pNode1.next;
			cycleLength++;
		}
		
		//找到节点入口
		pNode1 = head;
		ListNode pNode2 = head;
		//让p2先走n步，n等于cycleLength
		for(int i = cycleLength; i > 0; i--) {
			pNode2 = pNode2.next;
		}
		//两个指针同时走，相遇的节点就是入口
		while(pNode1 != pNode2) {
			pNode1 = pNode1.next;
			pNode2 = pNode2.next;
		}
		return pNode1;
	}
}

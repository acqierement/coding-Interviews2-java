package problems;

import javax.print.attribute.ResolutionSyntax;

/**
 * 链表中倒数第K个节点
 * leetcode 19题 是删除倒数第K个节点，可以参考
 * @author acqierement
 * Data: 2018年11月26日
 * Time: 上午10:27:38
 */
public class NO_22 {
	
	//找到倒数第K个节点
	public static ListNode findKthToTail(ListNode head, int k) {
		if(head == null || k <= 0) {
			return null;
		}
		ListNode pAhead = head;
		ListNode pBehind = new ListNode(0);
		pBehind.next = head;
		for(int i = 0; i < k - 1; i++) {
			if(pAhead.next != null) {
				pAhead = pAhead.next;
			}else {
				return null;
			}
		}
		while(pAhead != null) {
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
	}
	
	// 只是找到比较简单，写一下删除倒数第N个节点。因为是删除，所以我们要找到删除节点前面的那个节点
	// 也就是倒数N+1个节点
	public static ListNode deleteKthTotail(ListNode head, int n) {
		if(head == null || n <= 0) {
			return head; 
		}
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pAhead = fakeHead;//因为可能删除第一个节点，所以我们要指向fakeHead
		ListNode pBehind = fakeHead;
		for(int i = 0 ; i <= n; i++) {
			if(pAhead != null) {
				pAhead = pAhead.next;				
			}else {
				return fakeHead.next;//当N大于链表的长度，不做删除操作直接返回
			}
		}
		while(pAhead != null) {
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}
		pBehind.next = pBehind.next.next;
		return fakeHead.next;
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		ListNode head = ListUtil.contruct(array);
		ListNode headAfterDel = deleteKthTotail(head, 10);
		ListUtil.travel(headAfterDel);
	}
}

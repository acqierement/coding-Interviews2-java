package problems;

import javax.print.attribute.ResolutionSyntax;

/**
 * 链表中倒数第K个节点
 * leetcode 19题 是删除倒数第K个节点，其实就是找到倒数N+1个节点，可以参考
 * 牛客：https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a
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
	

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		ListNode head = ListUtil.contruct(array);
		ListNode headAfterDel = deleteKthTotail(head, 10);
		ListUtil.travel(headAfterDel);
	}
}

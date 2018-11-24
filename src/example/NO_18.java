package example;

import java.util.List;

/**
 * 1.删除链表的节点
 * 2.删除链表中重复的节点
 * @author acqierement
 * Data: 2018年11月24日
 * Time: 下午3:32:24
 */
public class NO_18 {
	//	leetcode 203 删除链表的节点
	public ListNode removeElements(ListNode head, int val) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode cur = fakeHead;
		
		while(cur.next != null) {
			if(cur.next.val == val) {
				cur.next = cur.next.next;
			}else {
				cur = cur.next;
			}
		}
		return fakeHead.next;
	}
	
	//leetcode 83题 删除链表中重复的节点，重复的节点只保留一个,例子：
	//{1 1 2 3 3} -> {1 2 3}
	public ListNode deleteDuplicates1(ListNode head) {
		if(head == null) {
            return null;
        }
		ListNode cur = head;
		while(cur.next != null) {
			if(cur.val == cur.next.val) {
				cur.next = cur.next.next;
			}else {
				cur = cur.next;
			}
		}
		return head;
	}
	
	//leetcode 82题 删除链表中重复的节点，重复的节点全部删除,例子：
	//{1 1 2 3 3} -> {2}
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode prev = fakeHead;
		ListNode cur = head;
		while(cur != null) {
			while(cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
            if(prev.next != cur){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;

		}
		return fakeHead.next;
	}

	

	public static void main(String[] args) {
		
	}
}

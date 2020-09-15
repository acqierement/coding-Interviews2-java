package problems;

/**
 * 52.两个链表的第一个公共节点
 * 牛客：https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46
 * @author acqierement
 * Data: 2018年12月3日
 * Time: 上午10:52:00
 */
public class NO_52 {
    /*

     */

    /**
     * 解法一：
     * 求出两个链表的长度，如果长链表比短链表多n个，就让长的链表往前走n步，
     * 这样两个链表就在同一起跑线了，就是离公共节点的距离会相等，让两个链表同时往前走，
     * 就会同时到达公共节点，这时返回这个节点即可。
     *
     * 解法二：
     * A的结尾接到B的前面，B的结尾接到A的前面。所以都会遍历A+B,
     * 如果没有交集，最后会同时遍历到结尾null，
     * 如果有交集，会在同一时间遍历到相同的节点
     */

    // 解法一 时间复杂度O(m+n+max(m,n))
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);
        ListNode pLong = pHead1;
        ListNode pShort = pHead2;
        int lenDif = length1 - length2;
        if (length2 > length1) {
            pLong = pHead2;
            pShort = pHead1;
            lenDif = length2 - length1;
        }
        for (int i = 0; i < lenDif; i++) {
            pLong = pLong.next;
        }
        while (pLong != pShort) {
            pLong = pLong.next;
            pShort = pShort.next;
        }
        return pLong;
    }

    private int getListLength(ListNode pHead1) {
        int len = 0;
        while (pHead1 != null) {
            len++;
            pHead1 = pHead1.next;
        }
        return len;

    }

    // 解法二，代码就简单多了，时间复杂度也第一点 时间复杂度O(n+m),
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            while (nodeA != headB) {
                nodeA = nodeA == null ? headA : nodeA.next;
                nodeB = nodeB == null ? headB : nodeB.next;
            }
            return nodeA;
        }

    }
}

package problems;

/**
 * 35.复杂链表的复制
 * 这题主要就是分三步
 * 牛客：https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba
 * @author acqierement
 * Data: 2018年11月28日
 * Time: 下午5:01:50
 */
public class NO_35 {
    public static RandomListNode Clone(RandomListNode pHead){
        cloneNode(pHead);
        connectSiblingNodes(pHead);
        return reconnectNodes(pHead);
    }
    
    private static void cloneNode(RandomListNode pHead) {
    	RandomListNode cur = pHead;
    	RandomListNode clone;
    	while(cur != null) {
    		RandomListNode nextTemp = cur.next;
    		clone = new RandomListNode(cur.label);
    		cur.next = clone;
    		clone.next = nextTemp;
    		cur = nextTemp;
    	}
    }
    
    private static void connectSiblingNodes(RandomListNode pHead) {
    	while(pHead != null) {
    		RandomListNode pClone = pHead.next;
    		pClone.random = pHead.random == null ? null : pHead.random.next;
    		pHead = pClone.next;
    	}
    }

	private static RandomListNode reconnectNodes(RandomListNode pHead) {
        if(pHead == null) return pHead;
		RandomListNode curHead = pHead;
		RandomListNode cloneHead = pHead.next;
		RandomListNode curClone = pHead.next;
		while(curHead != null) {
			curHead.next = curClone.next;
			curHead = curHead.next;
			if(curHead == null) {
				curClone.next = null;
				break;
			}
			curClone.next = curHead.next;
			curClone = curClone.next;
		}
		return cloneHead;
	}
    
	
	public static void main(String[] args) {
		RandomListNode root = new RandomListNode(1);
		RandomListNode root2 = new RandomListNode(2);
		RandomListNode root3 = new RandomListNode(3);
		root3.next = null;
		root.next = root2;
		root2.next = root3;
		root.random = root3;
		root2.random = root;
		root3.random = root2;
		RandomListNode cur = root;
//		cloneNode(root);
		RandomListNode clone = Clone(root);
//		
//		while(cur != null) {
//			System.out.println(cur.label);
//			cur = cur.random;
//		}
		while(clone != null) {
			System.out.println(clone.label);
			clone = clone.next;
		}
	}

}

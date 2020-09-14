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
    public static RandomListNode Clone(RandomListNode head){
		// 给每一个节点复制一个兄弟节点，排在当前节点后面
		copySiblingNode(head);
		// 给复制的节点设置random
		connectRandom(head);
		// 拆分两个节点
		return split(head);
    }

	public static void copySiblingNode(RandomListNode node) {
		while (node != null) {
			RandomListNode nextTemp = node.next;
			RandomListNode copyNode = new RandomListNode(node.val);
			node.next = copyNode;
			copyNode.next = nextTemp;
			node = nextTemp;
		}
	}

	public static void connectRandom(RandomListNode node) {
		while (node != null) {
			node.next.random = node.random == null ? null : node.random.next;
			node = node.next.next;
		}
	}

	public static RandomListNode split(RandomListNode node) {
		if (node == null) {
			return null;
		}
		RandomListNode copyHead = node.next;
		while (node != null) {
			RandomListNode copyNode = node.next;
			node.next = node.next.next;
			copyNode.next = copyNode.next == null ? null : copyNode.next.next;
			node = node.next;
		}
		return copyHead;
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
		while(clone != null) {
			System.out.println(clone.val);
			clone = clone.next;
		}
	}


}

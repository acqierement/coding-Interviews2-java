package problems;


/**
 * 66.构建乘积数组
 * 牛客：https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204
 * @author acqierement
 * Data: 2018年12月6日
 * Time: 下午4:31:36
 */
public class NO_66 {
	// 可以看一下书上那么二维数组的图，这里是通过对角线（灰色的1）来把矩阵划分成两个三角形。
	// 整个过程看着书上那个二维矩阵会清楚很多
    public int[] multiply(int[] A) {
    	int[] B = new int[A.length];
    	B[0] = 1;
    	// 构建左下部分的那个三角形。
    	for(int i = 1; i < B.length; i++) {
    		B[i] = A[i - 1] * B[i - 1];
    	}
    	// 这里就没必要单独构建右上部分的三角形了，直接得到答案
    	int temp = 1;
    	for(int i = B.length - 2; i >= 0; i--) {
    		temp *= A[i + 1];
    		B[i] *= temp;
    	}
    	return B;
    }
}

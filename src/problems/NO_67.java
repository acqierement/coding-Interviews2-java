package problems;

/**
 * 67.把字符串转换成整数
 * 牛客：https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202
 * LeetCode：8. String to Integer (atoi) LeetCode的题目不一样 输入"4193 with words" 会输出 4193，但是牛客会输出0
 * @author acqierement
 * Data: 2018年12月6日
 * Time: 下午8:11:55
 */
public class NO_67 {
    public int StrToInt(String str) {
        if(str == null || str.length() <= 0){
            return 0;
        }
        int sign = 1, index = 0;
        long sum = 0;
        // 跳过空格
        while(index < str.length() && str.charAt(index) == ' ') {
        	index++;
        }
        if(index >= str.length()){
            return 0;
        }
        // 第一个字符
        if(str.charAt(index) == '-') {
        	sign = -1;
        	index++;
        }else if(str.charAt(index) == '+') {
//        	sign = 1;
        	index++;
        }
        for(int i = index; i < str.length(); i++) {
        	char c = str.charAt(i);
        	if(c <= '9' && c >= '0') {
        		sum = sum * 10 + (c - '0');
        	}else {
        		return 0;
        	}
        	
           	if(sign * sum > Integer.MAX_VALUE) {
        		sum = Integer.MIN_VALUE;
        		break;
        	}
        	if(sign * sum < Integer.MIN_VALUE) {
        		sum = Integer.MIN_VALUE;
        		break;
        	}
//        	我们的sum是long类型的，所以可以用前面的方法判断溢出，如果用int可以用下面的这个判断
//			if (sum > Integer.MAX_VALUE || (sum == Integer.MAX_VALUE / 10 && (c - '0') > 7)) {
//				if (sign == 1)
//					return Integer.MAX_VALUE;
//				else
//					return Integer.MIN_VALUE;
//			}
        }       
        return (int) (sum * sign);
    }
}

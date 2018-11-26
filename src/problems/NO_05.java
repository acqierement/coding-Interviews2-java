package problems;


/**
 * 替换空格
 * @author acqierement
 * Data: 2018年11月18日
 * Time: 下午3:08:49
 */
public class NO_05 {
	

	public static String replaceBlank(StringBuffer str) {
		
		int strLength = str.length();
		int numbersOfBlank = 0;
		for (int i = 0; i < strLength; i++) {
			if (str.charAt(i) == ' ') {
				numbersOfBlank++;
			}
		}
		
		if (numbersOfBlank == 0) {
			return str.toString();
		}
		
		int newLength = strLength + numbersOfBlank * 2;
		str.setLength(newLength);
		
		int indexOfStr = strLength - 1;
		int indexOfNew = newLength - 1;
		while (indexOfStr >= 0 && indexOfNew > indexOfStr) {
			if(str.charAt(indexOfStr) != ' ') {
				str.setCharAt(indexOfNew--, str.charAt(indexOfStr)); 
			}else {
				str.setCharAt(indexOfNew--,	'0');
				str.setCharAt(indexOfNew--,	'2');
				str.setCharAt(indexOfNew--,	'%');
			}
			indexOfStr--;
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("we").append(' ').append("very").append(' ').append("happy");
		String replaceString = replaceBlank(sb);
		System.out.println(replaceString);//we%20very%20happy

	}

}

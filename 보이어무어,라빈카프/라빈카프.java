
public class 라빈카프 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String parent= "dsafdfafssdfdfa";
		String pattern = "fdfa";
		int power = 1;
		int count =0;
		long parenthash = 0;
		long patternhash = 0;
		for(int i=0;i<=parent.length()-pattern.length();i++) {
			if(i==0) { // 해쉬설정 및 초기 값 설정
				
				for(int j=0;j<pattern.length();j++) {
					parenthash = parenthash+parent.charAt(pattern.length()-1-j)*power;
					patternhash = patternhash + pattern.charAt(pattern.length()-1-j)*power;
					if(j < pattern.length()-1) {
						power = power * 2;
					}
				}
			}
			else {
				parenthash = 2 * (parenthash - (parent.charAt(i-1)*power)) + parent.charAt(pattern.length()-1+i);
			}
			
			if(parenthash==patternhash) {
			
				boolean flag = true;
				
				for(int j=0;j<pattern.length();j++) {
					if(parent.charAt(i+j) != pattern.charAt(j)) {
						flag =false;
						break;
					}
				}
				
				if(flag) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}

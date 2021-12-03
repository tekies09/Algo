
public class 보이어무어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String parent= "dsafdfafssdfdfa";
		String pattern = "fdfa";
		int count=0;
		int parentcursor;
		int patterncursor;
		int[] skip = new int[Character.MAX_VALUE+1]; // 알파벳 개수만큼 스킵테이블만들기~
		
		for(parentcursor = 0 ; parentcursor<= Character.MAX_VALUE;parentcursor++) skip[parentcursor] = pattern.length(); //길이만큼 초기화
		for(parentcursor = 0 ; parentcursor<  pattern.length()-1; parentcursor++)  skip[pattern.charAt(parentcursor)] = pattern.length()-parentcursor-1;
		
		
		while(parentcursor < parent.length()) {
			patterncursor =  pattern.length()-1;
			while(parent.charAt(parentcursor)==pattern.charAt(patterncursor)) {
				if(patterncursor ==0) {
					count++;
					break;
				}
				patterncursor--;
				parentcursor--;
			}
			
			parentcursor += (skip[parent.charAt(parentcursor)]> pattern.length()-patterncursor) ? skip[parent.charAt(parentcursor)] : pattern.length()-patterncursor;
		}
		System.out.println(count);
	}

}

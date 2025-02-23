import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			boolean hasmo = false; // 규칙 1 : 모음이 하나 이상 반드시 있어야 함을 체크하기 위한 변수
			char[] moem = {'a','e','i','u','o'}; // 모음을 체크하기 위해 미리 선언
			int seqcount=0; // 규칙 2 : 3연속의 모음, 자음을 체크하기 위한 변수
			boolean sameduple = false; // 규칙 3 : 같은 문자가 연속을 체크하기 위한 변수
			if(str.equals("end")) {
				break;
			}
			
			sb.append("<"+str+"> "); // 출력 포맷에 맡게 만듬
			
			char[] strchar = str.toCharArray(); // 한글자씩 확인하기위해 배열로 변환
			
			for(int i=0;i<str.length();i++) {
				boolean ismo = false; // 각 글자가 모음인지 확인하기 위한 변수
				for(int j=0;j<5;j++) {
					if(strchar[i]==moem[j]) { // 모음 이면
						hasmo = true;
						ismo = true;
						if(seqcount<0) { // 모음 일때는 seqcount가 양수로 올라감
							seqcount=0;
						}
						seqcount++;
					}
				}
				if(!ismo) { // 자음 이면
					if(seqcount>0) { // 자음 일때는 seqcount가 음수로 내려감
						seqcount=0;
					}
					seqcount--;
				}
				
				if(i+1<str.length()) { // 같은 문자가 연속으로 오는지 판단
					if(strchar[i]!='e'&&strchar[i]!='o') {
						if(strchar[i]==strchar[i+1]) {
							sameduple = true;
						}
					}
				}
				
				if(Math.abs(seqcount)>2||sameduple) { // 한 글자의 검증이 끝났을 때 이미 규칙에 어긋나면 탈출
					break;
				}
			}
			
			if(Math.abs(seqcount)<3&&!sameduple&&hasmo) { // 모든 규칙에 부합하면
				sb.append("is acceptable.\n");
			}
			else {
				sb.append("is not acceptable.\n"); // 규칙에 어긋나면
			}
			
		}
		System.out.println(sb);
	}

}
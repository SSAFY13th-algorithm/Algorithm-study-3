package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {

	static int L,C;
	static char[] characters, res;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // L개를 뽑아 비밀번호 생성
		C = Integer.parseInt(st.nextToken()); // 총 C개의 문자가 존재
		characters = new char[C]; // 문자 배열
		res = new char[L]; // 비밀번호 배열
		isSelected = new boolean[C]; // 선택 처리를 위한 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			characters[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(characters); // 알파벳 오름차순을 위한 정렬
		
		permutation(0,0);
	}

	
	public static void permutation(int cnt, int start) {
		if(cnt==L) {
			boolean ismoem=false;
			int jaem=0;
			for(char a:res) { // 자음과 모음 조건을 파악
				if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u') {
					ismoem=true; // 최소 1개의 모음이 있으면 true
				}
				else {
					jaem++; // 자음은 최소 2개이상이 필요하므로 개수 체크
				}
			}
			if(ismoem&&jaem>=2) { // 1개 이상의 모음, 2개 이상의 자음인 경우 출력
				for(char a:res) {
					System.out.print(a);
				}
				System.out.println();
			}
			
			return;
		}
		
		for(int i=start;i<C;i++) { // 중복방지를 위해 start부터 탐색
			if(isSelected[i])
				continue;
			
			isSelected[i] = true; // 선택 처리
			res[cnt] = characters[i];
			permutation(cnt + 1, i+1);
			isSelected[i] = false; // 원상복구
		}
	}
}

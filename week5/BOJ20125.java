package week5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20125 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		char[][] cookie = new char[num][num];
		for (int i = 0; i < num; i++) {
			cookie[i] = br.readLine().toCharArray(); // 입력의 각 칸에서 찾기 위해 한줄씩 받아서 char형 이중배열로 변환
		}

		int heartx = 0, hearty = 0;
		boolean findheart = false;
		for (int i = 0; i < num; i++) { // 배열을 0,0에서 찾아가며 쿠키가 처음 올라가 있는 곳을 찾음 -> 그곳이 쿠키의 머리이고 한칸 아래가 심장
			for (int j = 0; j < num; j++) {
				if (cookie[i][j] == '*') {
					findheart = true;
					heartx = j;
					hearty = i + 1;
				}
			}
			if (findheart) {
				break;
			}
		}
		int larm = 0, rarm = 0, lleg = 0, rleg = 0, back = 0;
		
		for(int i=0;i<heartx;i++) { // 심장과 같은 행이면서 심장의 왼쪽
			if(cookie[hearty][i]=='*') {
				larm++;
			}
		}
		
		for(int i=heartx+1;i<num;i++) { // 심장과 같은 행이면서 심장의 오른쪽
			if(cookie[hearty][i]=='*') {
				rarm++;
			}
		}
		
		for(int i=hearty+1;i<num;i++) { // 심장과 같은 열이면서 심장의 아래쪽
			if(cookie[i][heartx]=='*') {
				back++;
			}
		}
		
		for(int i=hearty+1;i<num;i++) { // 심장의 남서쪽 칸들
			for(int j=0;j<heartx;j++) {
				if(cookie[i][j]=='*') {
					lleg++;
				}
			}
		}
		
		for(int i=hearty+1;i<num;i++) { // 심장의 동남쪽 칸들
			for(int j=heartx+1;j<num;j++) {
				if(cookie[i][j]=='*') {
					rleg++;
				}
			}
		}
		
		System.out.println((hearty+1) +" "+(heartx+1)+"\n"+larm+" "+rarm+" "+back+" "+lleg+" "+rleg);
	}

}

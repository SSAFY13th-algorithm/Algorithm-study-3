package week5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(st.nextToken())+1;
		boolean[] onoff = new boolean[num]; // 스위치 온 오프를 boolean 타입 배열로 선언하여 관리

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < num; i++) {
			int chk = Integer.parseInt(st.nextToken());
			if (chk == 1)
				onoff[i] = true;
		}

		int peoplenum = Integer.parseInt(br.readLine());

		for (int i = 0; i < peoplenum; i++) {
			st = new StringTokenizer(br.readLine());

			int sex = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());

			if (sex == 1) { // 성별이 남자인 경우
				int count = 1;
				while (idx * count < num) { // 인덱스가 범위를 넘을 때 까지
					onoff[idx * count] = !onoff[idx * count]; // 곱하면서 스위치를 조작
					count++;
				}
			}

			else { // 성별이 여자인 경우 지정한 인덱스의 스위치 기준 대칭인 곳의 스위치를 조작
				int count = 1;
				onoff[idx] = !onoff[idx]; // 지정 위치는 무조건 조작
				while (true) {
					if (idx - count >= 1 && idx + count < num) { // 인덱스 범위 판단
						if (onoff[idx - count] == onoff[idx + count]) { // 대칭인지 판단하여 스위치 조작
							onoff[idx - count] = !onoff[idx - count];
							onoff[idx + count] = !onoff[idx + count];
						} else { // 대칭이 아닌 경우 break
							break;
						}
					} else {
						break;
					}
					count++;
				}

			}
		}

		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 1; i < num; i++) { // 출력 포맷에 맞게 수정
			if(onoff[i]) {
				sb.append("1 ");
			}
			else {
				sb.append("0 ");
			}
			count++;
			
			if(count==20) {
				sb.append("\n");
				count=0;
			}
		}
		
		System.out.println(sb);

	}

}

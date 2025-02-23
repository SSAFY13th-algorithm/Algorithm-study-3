import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(st.nextToken())+1;
		boolean[] onoff = new boolean[num];

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

			if (sex == 1) {
				int count = 1;
				while (idx * count < num) {
					onoff[idx * count] = !onoff[idx * count];
					count++;
				}
			}

			else {
				int count = 1;
				onoff[idx] = !onoff[idx];
				while (true) {
					if (idx - count >= 1 && idx + count < num) {
						if (onoff[idx - count] == onoff[idx + count]) {
							onoff[idx - count] = !onoff[idx - count];
							onoff[idx + count] = !onoff[idx + count];
						} else {
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
		for (int i = 1; i < num; i++) {
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

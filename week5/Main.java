package week5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		HashMap<String, Integer> hash = new HashMap<>(); // 한 번 게임한 플레이어와는 다시 하지 않기 때문에 해시맵 사용

		for (int i = 0; i < num; i++) {
			hash.put(br.readLine(), null);
		}

		int length = hash.size();

		switch (game) { // 게임에 필요한 인원은 2,3,4 이지만 임스가 참여하기 때문에 1,2,3으로 나눔
		case "Y":
			System.out.println(length / 1);
			break;
		case "F":
			System.out.println(length / 2);
			break;
		case "O":
			System.out.println(length / 3);
			break;
		}
	}

}
package week5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1205 {
	
	public static class rank { // 변수들을 저장하기 위한 클래스
        int score;
        int index;

        public rank(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int taesoo = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		if(N==0) { // 랭킹이 비어있는경우 무조건 1등이기 때문에 처리
			sb.append("1");
		}
		else {
			LinkedList<rank> list = new LinkedList<>(); // 랭크 타입의 리스트 생성
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(new rank(Integer.parseInt(st.nextToken()),i));
			}
			rank r = new rank(taesoo,N); // 태수는 항상 마지막에 넣음
			list.add(r);
			list.sort(new Comparator<rank>() { // 리스트를 스코어 기준 내림차순으로 정렬
				@Override
				public int compare(rank o1, rank o2) {
					return o2.score-o1.score;
				}
			});
			
			if(list.indexOf(r)+1>P) { // 태수의 등수가 랭킹범위 밖인 경우
				sb.append("-1");
			}
			else {
				for(int i=0;i<=list.indexOf(r);i++) { // 태수의 등수가 랭킹범위 안인 경우
					if(list.get(i).score==r.score) { // 태수와 동점이 있는지 찾아서
						sb.append(list.indexOf(list.get(i))+1); // 태수는 동점인 경우 가장 후순위이기 때문에 가장 앞의 등수 출력
                        break;
					}
				}
			}
		}
		
		System.out.println(sb);
		
		
	}

}

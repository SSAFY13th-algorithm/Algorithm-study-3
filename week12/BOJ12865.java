import java.io.*;
import java.util.*;

public class BOJ12865 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		
		for (int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			weight[i] = w;
			value[i] = v;
		}
		
		int[][] result = new int[N+1][K+1];
		
		for (int i=1; i<N+1; i++) {
			for (int w=1; w<K+1; w++) {
				if (weight[i] <= w) {
					result[i][w] = Math.max(result[i-1][w], result[i-1][w-weight[i]]+value[i]);
				} else {
					result[i][w] = result[i-1][w];
				}
			}
		}
		
		System.out.println(result[N][K]);
	}
}
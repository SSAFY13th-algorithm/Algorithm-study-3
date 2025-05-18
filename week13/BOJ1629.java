import java.io.*;
import java.util.*;

public class BOJ1629 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		System.out.println(modPow(A, B, C));
	}
	
	// mod 연산의 성질 활용
	static long modPow(int a, int b, int m) {
	    if (b == 0) return 1;
	    long half = modPow(a, b / 2, m);
	    long result = (half * half) % m;  
	    if (b % 2 == 1) {                 
	        result = (result * a) % m;
	    }
	    return result;
	}
}
package week15;

import java.io.*;
import java.util.*;

public class BOJ14719 {
	
	static int[] height;
	static int n,m,result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        height = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
        	height[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] left = new int[m]; // 각 위치의 왼쪽 벽 높이
        int[] right = new int[m]; // 각 위치의 오른쪽 벽 높이
        
        left[0]=height[0];
        for(int i=1;i<m;i++) { // 왼쪽 벽 높이 계산
        	left[i] = Math.max(left[i-1], height[i]);
        }
        right[m-1]=height[m-1];
        for(int i=m-2;i>=0;i--) { // 오른쪽 벽 높이 계산
        	right[i] = Math.max(right[i+1], height[i]);
        }
        
        for(int i=0;i<m;i++) { // 두 벽 중 낮은 곳으로 각 위치의 물 양 계산
        	int water = Math.min(left[i], right[i]) - height[i];
        	if(water>0)
        		result+=water;
        }
        
        System.out.println(result);
    }

}


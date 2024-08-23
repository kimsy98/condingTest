
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 문제 핵심 포인트
 * 최단 거리를 구하는게 아니라 갈 수 있는지 확인하는 거이므로
 * 맨하턴 거리가 20캔*50 =1000이 넘지 않는다면 갈 수 있으므로 1로 변환 그밖에는 INF입력 후 플로이드워셜진행
 * @author SSAFY
 *
 */
public class Main{
	
	static int store;
	static int[][] dist;
	static int[][] arr;
	static StringTokenizer st;
	static int INF=Integer.MAX_VALUE/2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int test_case;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		test_case = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= test_case; tc++) {
			
			store = Integer.parseInt(br.readLine());
			dist = new int[store+2][store+2];
			arr = new int[store+2][2];
			for (int i = 0; i < store+2; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());//x 좌표
				arr[i][1] = Integer.parseInt(st.nextToken());//y 좌표
				
			}

			for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist[i].length; j++) {
					if(i==j)continue;//자기는 패스
					int sum =Math.abs(arr[i][0]-arr[j][0])+Math.abs(arr[i][1]-arr[j][1]);//맨하턴 거리
					if(sum<=1000)dist[i][j] = 1;//1000보다 작으면 갈 수 있으므로 1
					else dist[i][j] = INF;
					
					
				}
			}

			
			
			for (int k = 0; k < dist.length; k++) {
				for (int i = 0; i < dist.length; i++) {
					if(k==i)continue;
					for (int j = 0; j < dist[i].length; j++) {
						if(k==j||i==j)continue;
						if(dist[i][j]>dist[i][k]+dist[k][j]) {
							dist[i][j] = dist[i][k]+dist[k][j];
						}
					}
				}
			}
			

			if(dist[0][store+1]!=INF) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
			

		}
		

	}

}

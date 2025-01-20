import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] gear = new int[4][8];
		
		for(int i =0; i<4; i++) {
			String gearStatus = br.readLine();
			for(int j=0; j<8;j++) {
				gear[i][j] = Integer.parseInt(String.valueOf(gearStatus.charAt(j)));				
			}
			
		}
		
		int rotate = Integer.parseInt(br.readLine());
		int[] gearPos = new int[4];
		for(int i =0; i<rotate; i++) {
			st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			gearPos[gearNum] = dir;
			int l = gear[gearNum][6];
			int r = gear[gearNum][2];
//			int prevGearPos = dir;
			for(int j=gearNum+1 ; j<=3;j++) {
				if(gearPos[j-1]!=0&&r!=gear[j][6]) {
					gearPos[j] = gearPos[j-1]*-1;
					r = gear[j][2];
				}else {
					gearPos[j] = 0;
				}
			}
			for(int j=gearNum-1 ; j>=0;j--) {
				if(gearPos[j+1]!=0&&l!=gear[j][2]) {
					gearPos[j] = gearPos[j+1]*-1;
					l = gear[j][6];
				}else {
					gearPos[j] = 0;
				}
			}
			
			for(int k =0; k<4; k++) {
				
				if(gearPos[k]==1) {
					int prev = gear[k][0];
					int now =  gear[k][1];
					for(int m=1;m<=7; m++) {
						now = gear[k][m];
						gear[k][m] = prev;
						prev = now;
						
					}
					gear[k][0] = prev;
				}else if(gearPos[k]==-1){
					int prev = gear[k][7];
					int now =  gear[k][6];
					for(int m=6;m>=0; m--) {
						now = gear[k][m];
						gear[k][m] = prev;
						prev = now;
						
					}
					gear[k][7] = prev;
				}
			}
			
		}
		int size = 1;
		int answer = 0;
		for(int i =0; i<gear.length; i++) {
			answer+= gear[i][0]*size;
			size*=2;
		}
		
		System.out.println(answer);
	}

}
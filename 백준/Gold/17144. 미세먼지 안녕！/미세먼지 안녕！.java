import java.io.*;
import java.util.*;

public class Main {
	static int R, C, T;
	static int[][] map;
	static int airUp, airDown; 
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		airUp = -1; 

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (airUp == -1) {
						airUp = i; 
					} else {
						airDown = i; 
					}
				}
			}
		}


		for (int t = 0; t < T; t++) {
			spread(); 
			AirClean(); 
		}
		
		

		System.out.println(getTotalDust()); 
	}


	static void spread() {
	    int[][] tempMap = new int[R][C]; 

	    for (int i = 0; i < R; i++) {
	        for (int j = 0; j < C; j++) {
	            if (map[i][j] > 0) { 
	                int spreadAmount = map[i][j] / 5; 
	                int spreadCount = 0; 

	                for (int d = 0; d < 4; d++) { 
	                    int ni = i + di[d];
	                    int nj = j + dj[d];

	                    if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != -1) {
	                        tempMap[ni][nj] += spreadAmount; 
	                        spreadCount++; 
	                    }
	                }

	                tempMap[i][j] += map[i][j] - (spreadAmount * spreadCount); 
	            }
	        }
	    }

	    for (int i = 0; i < R; i++) { 
	        for (int j = 0; j < C; j++) {
	            map[i][j] = tempMap[i][j];
	        }
	    }
	}

	
	static void AirClean() {
	    for (int i = airUp - 1; i > 0; i--) {
	        map[i][0] = map[i - 1][0]; 
	    }
	    for (int i = 0; i < C - 1; i++) {
	        map[0][i] = map[0][i + 1]; 
	    }
	    for (int i = 0; i < airUp; i++) {
	        map[i][C - 1] = map[i + 1][C - 1]; 
	    }
	    for (int i = C - 1; i > 1; i--) {
	        map[airUp][i] = map[airUp][i - 1]; 
	    }
	    map[airUp][1] = 0; 

	    
	    for (int i = airDown + 1; i < R - 1; i++) {
	        map[i][0] = map[i + 1][0]; 
	    }
	    for (int i = 0; i < C - 1; i++) {
	        map[R - 1][i] = map[R - 1][i + 1]; 
	    }
	    for (int i = R - 1; i > airDown; i--) {
	        map[i][C - 1] = map[i - 1][C - 1]; 
	    }
	    for (int i = C - 1; i > 1; i--) {
	        map[airDown][i] = map[airDown][i - 1]; 
	    }
	    map[airDown][1] = 0; 

	   
	    map[airUp][0] = -1;
	    map[airDown][0] = -1;
	}


	
	static int getTotalDust() {
		int totalDust = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) { 
					totalDust += map[i][j]; 
				}
			}
		}

		return totalDust;
	}
}

package coin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sum = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

        System.out.println(dp(sum, coins));

        br.close();
    }

    public static int dp(int sum, int[] coins){
        int[] ans = new int[sum+1];
        Arrays.fill(ans, 0);
        ans[0] = 1;

        for(int i=0; i<coins.length; i++){
            for(int j=0; j<ans.length; j++){
                if(j>=coins[i]) {
                    ans[j] += ans[j - coins[i]];
                }
            }
        }
        return ans[sum];
    }
}

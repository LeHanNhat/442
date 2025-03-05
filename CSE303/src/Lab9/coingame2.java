package Lab9;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coingame2 {
	static InputReader rd = new InputReader(System.in);
	static int[][] caches;
	static int[] coins;
	static int[] sums;

	public static void main(String[] args) {

		int n = rd.nextInt();
		coins = new int[n];
		sums = new int[n];
		caches = new int[n][n];

		for (int i = 0; i < n; i++) {
			coins[i] = rd.nextInt();
		}

		sums[0] = coins[0];
		for (int i = 1; i < n; i++) {
			sums[i] = sums[i - 1] + coins[i];
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				caches[i][j] = -1;
			}
		}

		int ans = solve(0, n - 1);
		System.out.println(ans);

	}

	static int getSum(int i, int j) {
		return sums[j] - (i > 0 ? sums[i - 1] : 0);
	}

	static int solve(int i, int j) {
		if (i == j)
			return coins[i];
		if (caches[i][j] != -1)
			return caches[i][j];

		caches[i][j] = Math.max(getSum(i + 1, j) - solve(i + 1, j) + coins[i],
				getSum(i, j - 1) - solve(i, j - 1) + coins[j]);
		return caches[i][j];
	}
}

class InputReader {
	StringTokenizer tokenizer;
	BufferedReader reader;
	String token;
	String temp;

	public InputReader(InputStream stream) {
		tokenizer = null;
		reader = new BufferedReader(new InputStreamReader(stream));
	}

	public InputReader(FileInputStream stream) {
		tokenizer = null;
		reader = new BufferedReader(new InputStreamReader(stream));
	}

	public String nextLine() throws IOException {
		return reader.readLine();
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				if (temp != null) {
					tokenizer = new StringTokenizer(temp);
					temp = null;
				} else {
					tokenizer = new StringTokenizer(reader.readLine());
				}
			} catch (IOException e) {
			}
		}
		return tokenizer.nextToken();
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}
}
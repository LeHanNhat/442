
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class EIMIN {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        TreeSet<Integer> numbers = new TreeSet<>();

        int n = reader.nextInt();
        int k = reader.nextInt();

        for (int i = 0; i < n; i++) {
            numbers.add(reader.nextInt());
        }

        int total = 0;
        for (int i = 0; i < k; i++) {
            if (numbers.isEmpty()) {
                stringBuilder.append(0).append("\n");
            } else {
                int min = numbers.pollFirst() - total;
                total += min;
                min = (min < 0) ? 0 : min;
                stringBuilder.append(min).append("\n");
            }
        }

        System.out.println(stringBuilder.toString());
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

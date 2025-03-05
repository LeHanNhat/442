import java.util.*;
import java.io.*;

public class EIPAGES2 {
    public static void main(String[] args) {
       
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> pages = new ArrayList<Integer>();
        int n = ni();
        

        for (int i = 0; i < n; i++) {
            pages.add(ni());
        }

        Collections.sort(pages);

        for (int i = 0; i < n; i++) {
            if (pages.get(i) == 0)
                continue;
            String text = pages.get(i) + "-";
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (pages.get(j) == 0)
                    continue;
                if (pages.get(j) == pages.get(i) + count) {
                    count++;
                    pages.set(j, 0);
                } else if (pages.get(j) > pages.get(i) + count) {
                    break;
                }
            }
            if (count < 3) {
                sb.append(pages.get(i)).append(" ");
                if (count == 2)
                    sb.append(pages.get(i) + 1).append(" ");
            } else {
                sb.append(text).append(pages.get(i)+ count - 1).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
    static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}


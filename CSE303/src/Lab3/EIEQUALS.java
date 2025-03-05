package Lab3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

public class EIEQUALS {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int n = ni();
		int k = ni();
		int[] ai = new int[n];
		int[] bi = new int[n];
		Hashtable<Integer, Integer> map = new Hashtable<>();
		for (int i = 0; i < n; i++) {
			ai[i] = ni();
		}
		for (int i = 0; i < n; i++) {
			bi[i] = ni();
		}

		int total = Math.abs(IntStream.of(ai).sum() - IntStream.of(bi).sum());
		Arrays.sort(ai);
		Arrays.sort(bi);
		if (total > k) {
			System.out.println("NO");
		} else {
			int i = 0;
			int j = 0;
			int count = 0;
			while (i < n && j < n) {
				if (ai[i] == bi[j]) {
					i++;
					j++;
				} else if (ai[i] < bi[j]) {
					i++;
					count++;
				} else {
					j++;
				}
			}
			if (count > 1) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}

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

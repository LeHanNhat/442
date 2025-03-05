package lan6;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class EIAPPLEBOX {
	public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();

        int nTestcase = ni();
        for (int t = 0; t < nTestcase; t++) {
            int n = ni();
            long a = nl();
            long p = nl();

            long[] nums = new long[n];
            nums[0] = (a * a) % p;
            for (int i = 1; i < n; i++) {
                nums[i] = (nums[i - 1] * a) % p;
            }
            count = 0;
            nums = mergeSort(nums, 0, n - 1);
            sb.append(count).append('\n');
        }
        System.out.println(sb.toString());
    }

    static long count;

    private static long[] mergeSort(long[] nums, int left, int right) {
        if (left == right) {
            return new long[] { nums[left] };
        }

        int mid = (left + right) / 2;
        long[] l = mergeSort(nums, left, mid);
        long[] r = mergeSort(nums, mid + 1, right);

        return merge(l, r);
    }

    private static long[] merge(long[] l, long[] r) {
        long[] result = new long[l.length + r.length];
        int i = 0, j = 0, k = 0;

        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                result[k++] = l[i++];
            } else {
                result[k++] = r[j++];
                count += (l.length - i);
            }
        }

        while (i < l.length) {
            result[k++] = l[i++];
        }

        while (j < r.length) {
            result[k++] = r[j++];
        }

        return result;
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

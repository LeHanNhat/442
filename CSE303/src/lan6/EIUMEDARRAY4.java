package lan6;

import java.io.*;
import java.util.*;

public class EIUMEDARRAY4 {
	public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();

        int nTestcase = ni();
        for (int t = 0; t < nTestcase; t++) {
            int n = ni();
            long a = ni();
            int p = ni();
            int kth = ni();

            long[] nums = new long[n];
            nums[0] = (a * a) % p;
            for (int i = 1; i < n; i++) {
                nums[i] = (nums[i - 1] * a) % p;
            }

            shuffle(nums);
            sb.append(kthSmallestElement(nums, 0, n - 1, kth)).append('\n');
        }
        System.out.println(sb.toString());
    }

    static long kthSmallestElement(long[] array, int low, int high, int k) {
        int[] pivotIndices = partition(array, low, high);

        if (k < pivotIndices[0] + 1) {
            return kthSmallestElement(array, low, pivotIndices[0] - 1, k);
        } else if (k > pivotIndices[1] + 1) {
            return kthSmallestElement(array, pivotIndices[1] + 1, high, k);
        } else {
            return array[pivotIndices[0]];
        }
    }

    static int[] partition(long[] array, int low, int high) {
        long pivot = array[low];
        int lt = low;
        int gt = high;
        int i = low;

        while (i <= gt) {
            if (array[i] < pivot) {
                swap(array, i, lt);
                i++;
                lt++;
            } else if (array[i] > pivot) {
                swap(array, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        return new int[] { lt, gt };
    }

    static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void shuffle(long[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            swap(array, i, index);
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

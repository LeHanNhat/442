package lan6;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

public class QS {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int n = ni();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i =0;i < n; i ++) {
			list.add(ni());
			
		}
		quicksort(list, 0, list.size() - 1);

        
        for (int value : list) {
            System.out.print(value + " ");
        }
		 
	        
	    }

	public static void quicksort(ArrayList<Integer> list, int low, int high) {
		if (low < high) {
			int pIndex = partition(list, low, high);
			quicksort(list, low, pIndex - 1);
			quicksort(list, pIndex + 1, high);
		}
	}

	public static int partition(ArrayList<Integer> list, int low, int high) {
		int p = list.get(high);
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (list.get(j) <= p) {
				i++;
				int temp = list.get(i);
				list.set(i,list.get(j))  ;
				list.set(j,temp)  ;
				
			}
		}

		int temp = list.get(i+1);
		list.set(i+1,list.get(high)); 
		list.set(high,temp)  ;
		return i + 1;
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
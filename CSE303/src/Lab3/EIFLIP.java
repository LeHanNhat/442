package Lab3;

import java.io.*;
import java.util.*;

public class EIFLIP {
	static StringBuffer sb = new StringBuffer();
	 public static void main(String[] args) {
	        
	        StringBuilder stringBuilder = new StringBuilder();
	        int n = ni();

	        for (int t = 0; t < n; t++) {
	        	ArrayList<Position> positions = new ArrayList<>();

	            for (int i = 0; i < 3; i++) {
	                String line = ns();
	                for (int j = 0; j < 3; j++) {
	                    if (line.charAt(j) == '*')
	                        positions.add(new Position(i, j));
	                }
	            }

	            int count = 0;
	            boolean flag = false;
	            for (int i = 1; i <= 512; i++) {
	                String binary = integerToBinary(i);
	                String[] parts = binary.split("");

	                boolean[][] newMatrix = { { false, false, false }, { false, false, false },
	                        { false, false, false } };

	                for (String part : parts) {
	                    if (part.equals("0"))
	                        continue;
	                    int unit = Integer.parseInt(part);
	                    newMatrix = clickCell(newMatrix, unit);

	                    for (int row = 0; row < 3; row++) {
	                        for (int col = 0; col < 3; col++) {
	                            if (newMatrix[row][col]) {
	                                Position position = new Position(row, col);
	                                if (positions.contains(position)) {
	                                    count++;
	                                    flag = true;
	                                } else {
	                                    count = 0;
	                                    flag = false;
	                                }
	                            }
	                        }
	                    }
	                }

	            }
	            if (flag) {
	                stringBuilder.append(count).append('\n');
	                count = 0;
	                flag = false;
	            }

	        }
	        System.out.println(stringBuilder.toString());
	    }

	    public static String integerToBinary(int n) {
	        String binary = Integer.toBinaryString(n);
	        while (binary.length() < 9) {
	            binary = "0" + binary;
	        }
	        return binary;
	    }

	    public static boolean[][] clickCell(boolean[][] maxtrix, int unit) {
	        int row = unit / 3;
	        int col = unit == 1 ? 0 : unit % 3;

	        maxtrix[row][col] = !maxtrix[row][col];
	        toggle(maxtrix, row - 1, col); // Top
	        toggle(maxtrix, row + 1, col); // Bottom
	        toggle(maxtrix, row, col - 1); // Left
	        toggle(maxtrix, row, col + 1); // Right

	        return maxtrix;
	    }

	    private static void toggle(boolean[][] matrix, int row, int col) {
	        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
	            matrix[row][col] = !matrix[row][col];
	        }
	    }
	static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "[row=" + row + ", col=" + col + "]";
        }

        @Override
        public boolean equals(Object obj) {
            Position position = (EIFLIP.Position) obj;
            if (this.col == position.col && position.row == this.row)
                return true;
            return false;
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

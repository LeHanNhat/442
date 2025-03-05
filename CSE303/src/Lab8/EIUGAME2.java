package Lab8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;



public class EIUGAME2 {

	 static InputReader reader;
	    static StringBuffer sb = new StringBuffer();

	    public static void main(String[] args) throws IOException {
	        reader = new InputReader(System.in);
	        
	       
	        int columns= reader.nextInt();
	        int rows = reader.nextInt();
	      

	        long[][] matrix = new long[columns][rows];
	        long[][] way = new long[columns][rows];

	        for (int colum = 0; colum < columns; colum++) {
	            for (int row = 0; row < rows; row++) {
	                matrix[colum][row] = reader.nextLong();
	                way[colum][row] = 1;
	            }
	        }

	        long[][] value = new long[columns][rows];
	        value[0][0] = matrix[0][0];
	        long mod = (long) (Math.pow(10, 7));
	     
	        for (int colum = 0; colum < columns; colum++) {
	            for (int row = 0; row < rows; row++) {
	                long val = matrix[colum][row];

	                if (row == 0 && colum != 0) {
	                    value[colum][row] = value[colum - 1][row] + val;
	                    way[colum][row] = way[colum - 1][row];
	                    
	                }

	                if (row != 0 && colum == 0) {
	                    value[colum][row] = value[colum][row - 1] + val;
	                    way[colum][row] = way[colum][row - 1];
	                } 
	                
	                if (row != 0 && colum != 0) {
	                	
	                	if(value[ colum - 1][row]  > value[colum][row - 1] ) {	
	                		 value[colum][row] = value[colum - 1][row] + val ;
	                		 way[colum][row] = way[colum - 1][row];
	                	}else
	                	
	                	if(value[colum - 1][row]  < value[colum][ row - 1]) {	
	                		 value[colum][row] = value[colum][row - 1] + val ;
	                		 way[colum][row] = way[colum][row - 1];
	                	}
	                	
	                	else 
	                		//(value[Math.max(0, colum - 1)][row] == value[colum][Math.max(0, row - 1)] ) 
	                		{
	                		
	                		 value[colum][row] = value[colum][ row - 1] + val ;
	                		 
	                		 long input = way[colum-1][row] + way[colum][row - 1];
	                		 if(way[colum][row - 1] + value[colum][ row - 1] > mod) {
	                			 
	                			 input = (long) ((way[colum-1][ row] + value[colum][row - 1])% mod);
	                		 }
	                		 way[colum][row] = input;
	                		
	  
	                	}   
	                }
	             
	            }
	        }
	        
	       // long[][] matrix = new long[columns][rows];

	        for (int colum = 0; colum < columns; colum++) {
	            for (int row = 0; row < rows; row++) {
	                sb.append(value[colum][row]+" ");
	            }
	            sb.append("\n");
	        }
	        
	        for (int colum = 0; colum < columns; colum++) {
	            for (int row = 0; row < rows; row++) {
	                sb.append(way[colum][row]+" ");
	            }
	            sb.append("\n");
	        }
	        
	        
	        System.out.println(value[columns-1][rows-1] +" "+way[columns-1][rows-1]);
	      

	    }

	    static class InputReader {
	        private byte[] inbuf = new byte[2 << 23];
	        public int lenbuf = 0, ptrbuf = 0;
	        public InputStream is;

	        public InputReader(InputStream stream) throws IOException {

	            inbuf = new byte[2 << 23];
	            lenbuf = 0;
	            ptrbuf = 0;
	            is = System.in;
	            lenbuf = is.read(inbuf);
	        }

	        public InputReader(FileInputStream stream) throws IOException {
	            inbuf = new byte[2 << 23];
	            lenbuf = 0;
	            ptrbuf = 0;
	            is = stream;
	            lenbuf = is.read(inbuf);
	        }

	        public boolean hasNext() throws IOException {
	            if (skip() >= 0) {
	                ptrbuf--;
	                return true;
	            }
	            return false;
	        }

	        public String nextLine() throws IOException {
	            int b = skip();
	            StringBuilder sb = new StringBuilder();
	            while (!isSpaceChar(b) && b != ' ') { // when nextLine, ()
	                sb.appendCodePoint(b);
	                b = readByte();
	            }
	            return sb.toString();
	        }

	        public String next() {
	            int b = skip();
	            StringBuilder sb = new StringBuilder();
	            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b
	                                        // != ' ')
	                sb.appendCodePoint(b);
	                b = readByte();
	            }
	            return sb.toString();
	        }

	        private int readByte() {
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

	        private boolean isSpaceChar(int c) {
	            return !(c >= 33 && c <= 126);
	        }

	        private double nextDouble() {
	            return Double.parseDouble(next());
	        }

	        public Character nextChar() {
	            return skip() >= 0 ? (char) skip() : null;
	        }

	        private int skip() {
	            int b;
	            while ((b = readByte()) != -1 && isSpaceChar(b))
	                ;
	            return b;
	        }

	        public int nextInt() {
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

	        public long nextLong() {
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

	}
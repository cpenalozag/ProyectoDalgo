import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * @author c.penaloza
 * @author jd.gonzaleza
 */

/**
 * Problema A
 */
public class ProblemaA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
	      
	      // Comienzo solucion -------------------------------------------------------
	   
	      /*
	      int n      = sc.nextInt();        // read input as integer
	      long k     = sc.nextLong();       // read input as long
	      double d   = sc.nextDouble();     // read input as double
	      String str = sc.next();           // read input as String
	      String s   = sc.nextLine();       // read whole line as String

	      out.println(result);                    // print via PrintWriter
	      */

	      // Fin solución ------------------------------------------------------------
	      out.close();
	   }

	     

	   //-----------PrintWriter para output más rápido---------------------------------
	   public static PrintWriter out;
	      
	   //-----------MyScanner class para input más rápido------------------------------
	   public static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
	   //--------------------------------------------------------

}

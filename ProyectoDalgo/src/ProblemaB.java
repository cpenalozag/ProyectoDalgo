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
 * Problema B
 */
public class ProblemaB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
	      
	      // Comienzo solucion -------------------------------------------------------
	   
	      int n = sc.nextInt();
	      int[] p = new int[n];
	      
	      for (int i=0; i<n; i++){
	    	  p[i]=sc.nextInt();
	      }


	      out.println();

	      // Fin solución ------------------------------------------------------------
	      out.close();
	   }

	/**
	 * Predicado verdadero si se puede construir el entero a con las sumas de p1 y pj
	 * @param a entero estudiado
	 * @param j indice de p hasta el cual se sumará
	 * @param p arreglo de participaciones
	 * @return true si es construible, false de lo contrario
	 */
	private static boolean construible (int a, int j, int[] p){
		int i=0,suma=0;
		while(i<j){
			suma+=p[i];
			if (suma>=a) return true;
			i++;
		}
		return false;
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

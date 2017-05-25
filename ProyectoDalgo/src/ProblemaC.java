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
 * Problema C
 */
public class ProblemaC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
	      
	      // Comienzo solucion -------------------------------------------------------
	      String s   = sc.nextLine();
	      String[] input = s.split(" = ");
	      String iz = input[0];
	      String[] izq = procesarInput(iz);
	      String de = input [1];
	      String[] der = procesarInput(de);
	     
	     der.clone();

	      // Fin solución ------------------------------------------------------------
	      out.close();
	   }
	
	private static String[] procesarInput(String input){
		String[] resp;
		if (input.contains("+")) resp=input.split("[\\s+]+");
		else if (input.contains("-")) resp=input.split("[\\s-]+");
		else{
			resp = new String[1];
			resp[0] = input;
		}
		return resp;
	}

	
	public static void printCombinations(String str){
	    printCombinations(str, 0, str.length()-1);
	}

	public static void printCombinations(String str,int k,int n){
	    if(k == n)
	        System.out.println(str);
	    else {
	        for(int i=k;i<=n;i++){
	            String tmp=modifyString(str,i,k);
	            printCombinations(tmp,k+1,n);
	            modifyString(str,i,k);
	        }
	    }
	}

	public static String modifyString(String str,int x,int y){

	            // for swapping characters inside a string 
	    char arr[]=str.toCharArray();
	    char t= arr[x];
	    arr[x]=arr[y];
	    arr[y]=t;

	    String s= new String(arr);
	    return s;   
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

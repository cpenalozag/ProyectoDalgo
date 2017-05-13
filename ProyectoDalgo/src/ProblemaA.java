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

		Integer n = sc.nextInt();

		while(n!=null)
		{
			int[] a = new int[n];
			for (int i=0;i<n;i++){
				a[i]=i+1;
			}
			int nr = sc.nextInt();
			for (int i=0;i<nr;i++){
				int p = sc.nextInt();
				int q = sc.nextInt();
				int k = sc.nextInt();
			}
		}

		out.println();
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

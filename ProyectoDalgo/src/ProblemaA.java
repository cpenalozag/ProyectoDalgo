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
		System.out.println("Dimension del arreglo");
		Integer n = sc.nextInt();
		int a[] = new int[n];
		String arr = "";
		for(int i = 0; i<n ;i++){
			a[i] = i+1;
			arr += a[i]+" ";
		}
		System.out.println("Arreglo");
		System.out.println(arr);
		System.out.println("número de rotaciones");
		int nr = sc.nextInt();
		System.out.println("rotaciones");
		String arrResp = "";
		int temp[] = a.clone();
		int rot = 0;
		while(nr != 0){
			int p = sc.nextInt();
			int q = sc.nextInt();
			int k = sc.nextInt();

			for(int i = p ; i<q; i++){
				if(p==0){
					rot = (i+k) %(q-p);
					temp[rot] = a[i];
				}else if(p !=0){
					if(k<0){
						rot = p+((i-k) % (q-p));
						temp[rot]= a[i];
					}else{
						rot = p+((i+k-1)%(q-p));
						temp[rot]= a[i];
					}
				}
			}
			a = temp.clone();
			
			nr=nr-1;
		}
		for(int i = 0; i<n;i++){
			arrResp+= a[i]+" ";
		}

		System.out.println(arrResp);
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

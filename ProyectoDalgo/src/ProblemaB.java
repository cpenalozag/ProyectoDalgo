import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author c.penaloza Carlos Peñaloza 201531973
 * @author jd.gonzaleza Juan Diego González 201531418
 */

/**
 * Problema B
 */
public class ProblemaB {

	/**
	 * @param args
	 */
	private static boolean resp[];
	private static int[] p;
	private static double respuesta;
	private static int n;
	public static void main(String[] args) throws IOException {
//
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));

		// Comienzo solucion -------------------------------------------------------
		resp = new boolean[0];
		 p = new int[0] ;
		String s;

		LinkedList<String> resultados = new LinkedList<>();
		while(!(s = sc.nextLine()).equals("")){
			String[] x = s.split(" ");
			
			if(x.length ==1){
				 n= Integer.parseInt(x[0]);
				 p = new int[n];
			}
			else{
				for (int i=0; i<x.length; i++){
					p[i]=Integer.parseInt(x[i]);
				}
				resp = new boolean[101];
				for(int k=0; k<=n-1; k++){
					for(int l = 100; l>=0; l--){
						construible(l, k);
					}
				}

				for(int i = 51; i<100; i++){
					if(resp[i] == true){
						respuesta = 100*(p[n-1]/(double)i);
						System.out.println(p[n-1]+ "/" + i);
						break;
					}


				}
				resultados.add(Math.round(respuesta* 100.00)/100.00+"");
			}
		}
		for(String r: resultados){
			out.println(r);
		}
		// Fin solución ------------------------------------------------------------
		out.close();
	}


	private static void construible (int a, int j){
		if(j==0){
			resp[a]= (a==p[p.length-1]);
		}else if(p[(j+p.length-1)%p.length]<=a){
			resp[a]= resp[a]|| resp[(a-p[(j+p.length-1)%p.length])];
		}
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
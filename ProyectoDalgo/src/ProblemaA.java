
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * @author c.penaloza Carlos Peñaloza 201531973
 * @author jd.gonzaleza Juan Diego González	201531418
 */

/**
 * Problema A
 */
public class ProblemaA {

	/**
	 * @param args
	 */
private static int[] a  ;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		
		
		// Comienzo solucion -------------------------------------------------------

		String s;
		LinkedList<String> respuesta = new LinkedList<>();
		
		while(!(s= sc.nextLine()).equals("")){
			int n = Integer.parseInt(s);
			a = new int[n];
			for(int i = 0;i<n; i++){
				
				a[i]= i+1;
			}

				int nr = Integer.parseInt(sc.nextLine());
				String arrResp = "";

				while(nr != 0){
					String[] x = sc.nextLine().split(" ");
					int p = Integer.parseInt(x[0]);
					int q = Integer.parseInt(x[1]);
					int k = Integer.parseInt(x[2]);

					if(k>0 ){
						if(p<q){
							reverso(a, p, (q-1)-(k%(q-p)));
							reverso(a, q-(k%(q-p)), q-1);
							reverso(a, p, q-1); 
						}
					}
					else{
						if(p<q){
							reverso(a, p, p+(Math.abs(k)%(q-p)-1));
							reverso(a, p+(Math.abs(k)%(q-p)), q-1);
							reverso(a, p, q-1);
						}
					}
					nr=nr-1;
				}
				for(int i = 0; i<n;i++){
					arrResp+= a[i]+" ";
				}
				respuesta.add(arrResp);
			
		}
		for(String r: respuesta){
			out.println(r);
		}
		// Fin solución ------------------------------------------------------------
		out.close();
	}


	// método ayudante//

	static void reverso(int arr[], int in, int fin){
		int aux;
		while(in < fin){
			aux = arr[in];
			arr[in] = arr[fin];
			arr[fin] = aux;
			in++;
			fin--;
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

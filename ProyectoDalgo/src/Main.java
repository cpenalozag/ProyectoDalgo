import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/**
 * @author c.penaloza
 * @author jd.gonzaleza
 */

/**
 * Problema C
 */
public class Main {

	final static String DERECHA = "der";
	final static String IZQUIERDA = "izq";
	static int[] firmas = new int [10];
	static String primeros = "";
	static String letras = "";
	static boolean resuelto = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));


		// Comienzo solucion -------------------------------------------------------
		
		String s   = sc.nextLine();
		String[] input = s.split("[\\=]");
		String iz = input[0];

		String[] izq = procesarInput(iz,IZQUIERDA);

		String de = input [1];
		String[] der = procesarInput(de.substring(1, de.length()),DERECHA);

		String[] elems = new String[2];
		elems[0]=izq[0]+der[0];
		elems[1]=izq[1]+der[1];

		letras=letrasUnicas(izq, der);
		firmas=calcularFirmas(letras, elems);
		primeros=primerosCaracteres(izq, der);

		solucionar();
		if(!resuelto) out.println("**********");

		// Fin solución ------------------------------------------------------------
		out.close();
	}


	private static String letrasUnicas(String[] izq, String[] der){
		String letras = "";
		for (String str: izq){
			str.trim();
			for (char c: str.toCharArray()){
				if (!letras.contains(c+"")&&c!=','&&c!=' ')letras+=c+"";
			}
		}
		for (String str: der){
			str.trim();
			for (char c: str.toCharArray()){
				if (!letras.contains(c+"")&&c!=','&&c!=' ')letras+=c+"";
			}
		}
		return letras;
	}

	private static String primerosCaracteres(String[] izq, String[] der){
		String prims = "";
		String iz = izq[0]+izq[1];
		String[] piz = iz.split(",");
		String de = der[0]+der[1];
		String[] pde = de.split(",");

		for (String s: piz){
			if (!prims.contains(s.charAt(0)+"")) prims+=s.charAt(0);
		}
		for (String s: pde){
			if (!prims.contains(s.charAt(0)+"")) prims+=s.charAt(0);
		}
		return prims;
	}

	private static String[] procesarInput(String input, String lado){
		String[] resp = new String[2];
		resp[0]="";resp[1]="";

		if (input.contains("+")||input.contains("-")){
			String[] partes =input.split("[\\s+-]+");

			boolean[] signos = new boolean[partes.length-1];

			boolean finMenos=false;
			int m=0,n=0,k=0;
			while (k<partes.length){
				int iMa=input.indexOf("+", m), iMe=input.indexOf("-", n);
				if (iMa==-1) break;
				if (iMe==-1) {
					finMenos=true;
					break;
				}

				if (iMa<iMe ){
					signos[k++]=true;
					m=iMa+1;
				}
				else{
					k++;
					n=iMe+1;
				}
			}	

			if (finMenos){
				while (k<partes.length-1){
					signos[k]=true;
					k++;
				}
			}

			switch(lado){
			case DERECHA:
				resp[1]=partes[0]+",";
				for (int i = 0;i<partes.length-1;i++){
					if (signos[i]==false) resp[0]+=partes[i+1]+",";
					else resp[1]+=partes[i+1]+",";
				}
				break;
			case IZQUIERDA:
				resp[0]=partes[0]+",";
				for (int i = 0;i<partes.length-1;i++){
					if (signos[i]==false) resp[1]+=partes[i+1]+",";
					else resp[0]+=partes[i+1]+",";
				}
				break;
			}

		}
		else{
			if (lado==IZQUIERDA) resp[0] = input;
			else resp[1] = input;
		}
		return resp;
	}

	private static long encontrarFirma(char c, String[] elems){
		String[] sumar = elems[0].split(",");
		String[] restar = elems[1].split(",");

		Long total = (long) 0;
		for (String s: sumar){
			if (!s.contains(""+c)) continue;
			else {
				s=s.replaceAll("[^"+c+"]", "0");
				s=s.replaceAll(c+"", "1");
				long valor = Long.parseLong(s);
				total += valor;
			}
		}
		for (String s: restar){
			if (!s.contains(""+c)) continue;
			else {
				s=s.replaceAll("[^"+c+"]", "0");
				s=s.replaceAll(c+"", "1");
				long valor = Long.parseLong(s);
				total -= valor;
			}
		}

		return total;
	}

	private static int[] calcularFirmas(String letras, String[] elems){
		int i = 0;
		int[] firmas = new int[10];
		for (char c: letras.toCharArray()){
			firmas[i]=(int)encontrarFirma(c, elems);
			i++;
		}
		return firmas;
	}

	private static void permutar(java.util.List<Integer> arr, int k){
		for(int i = k; i < arr.size(); i++){
			java.util.Collections.swap(arr, i, k);
			if (!resuelto){
				permutar(arr, k+1);
			}
			java.util.Collections.swap(arr, k, i);
		}
		if (k == arr.size() -1){
			if (esRespuesta(arr)){
				resuelto=true;
				out.println(respuesta(arr));
				return;
			}
		}
	}

	private static void solucionar(){
		List<Integer> numeros = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		permutar(numeros, 0);
	}

	private static boolean esRespuesta(java.util.List<Integer> digitos){
		int[] firm = firmas;
		String prim = primeros;
		String let = letras;
		int resp = 0;
		for (int i=0;i<10;i++){
			resp+=digitos.get(i)*firmas[i];
		}
		if (resp==0) {
			for (char c: primeros.toCharArray()){
				if (digitos.get(letras.indexOf(c+""))==0){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private static String respuesta(java.util.List<Integer> digitos){
		String[] respuesta = new String[10];
		String resp = "";
		for (char c: letras.toCharArray()){
			int indice = letras.indexOf(c);
			int digito = digitos.get(indice);
			respuesta[digito]=c+"";
		}
		for (String d: respuesta){
			if(d==null){
				resp+="*";
			}
			else resp+=d;
		}
		return resp;
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

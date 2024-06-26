//package pkgA;

import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/
public class A {
	static int balik (int nilai) {
		if (nilai < 10) {
			nilai *= 10;
		}
		else {
			int a = nilai/10;
			int b = nilai%10;
			nilai = b*10+a;
		}
		return nilai;
	}
	static class Data{
		int nilai, baliknya;
		Data (int nilai) {
			this.nilai = nilai;
		}
	}
	static void solve() {
		int n = ni();
		Data[] arr = new Data[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Data(ni());
			arr[i].baliknya = balik(arr[i].nilai);
		}
		Arrays.sort(arr, new Comparator<Data>(){
			public int compare (Data a, Data b) {
				return a.baliknya - b.baliknya;
			}});
		for (int i = 0; i < n; i++) out.println(arr[i].nilai);
    }    
 
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        //int t = ni();
        int t = 1;
        while (t-- > 0) solve(); 
        err.println("Time elapsed : " + (System.currentTimeMillis() - time) / 1000F + " s.");
        err.close(); out.close();
    }
 
	static int[] radixSort(int[] f){ return radixSort(f, f.length); }
	static int[] radixSort(int[] f, int n)
	{
		int[] to = new int[n];
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(f[i]&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[f[i]&0xffff]++] = f[i];
			int[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(f[i]>>>16)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[f[i]>>>16]++] = f[i];
			int[] d = f; f = to;to = d;
		}
		return f;
	}
 
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static PrintWriter err = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.err)));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token;
        
    static String ns() {
        while (token == null || !token.hasMoreTokens()) {
            try {
                token = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return token.nextToken();
    }
    static char nc() {
        return Character.valueOf(ns().charAt(0));
    }
    static int ni() {
        return Integer.parseInt(ns());
    }
    static double nd() {
        return Double.parseDouble(ns());
    }
    static long nl() {
        return Long.parseLong(ns());
    }
}

// Collections Arrays Math
// Vector HashSet TreeSet HashMap TreeMap ArrayDeque 

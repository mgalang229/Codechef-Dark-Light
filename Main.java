import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*

there are 4 levels: 1, 2, 3, 4

levels 1 to 3 correspond to ON
level 4 corresponds to OFF

K = initial state of the torch (either ON = 1 or OFF = 0)

N = no. of changes made

initial state: ON with 4 changes
1 2 3 4
(1+4)%4 = 1
(2+4)%4 = 2
(3+4)%4 = 3

inference -> should go back itself

initial state: OFF with 5 changes
1 2 3 4
(4+5)%4 = 2

inference -> valid answer always exists

*/

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int n = fs.nextInt(), k = fs.nextInt();
			String[] ans = new String[] {"Off", "On", "On", "On"};
			int afterChanges = (k + n) % 4;
			if(k == 1) {
				boolean valid = true;
				for(int level = 1; level <= 3; level++) {
					if((level + n) % 4 != level) {
						valid = false;
						break;
					}
				}
				if(valid) {
					out.println(ans[afterChanges]);
				}
				else {
					out.println("Ambiguous");
				}
			}
			else {
				out.println(ans[afterChanges]);
			}
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

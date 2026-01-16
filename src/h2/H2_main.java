package h2;


public class H2_main {
	
	private static long [] cache = new long [1000];
	
	public static void main (String [] args) {
		benchmark (40);
	}
	public static void benchmark (int n ) {
		long start, end ;
		
		start = System.nanoTime();
        long res1 = fibonacci(n);
        end = System.nanoTime();
        System.out.println("fibonacci (rekursiv): " + res1);
        System.out.println("Elapsed nanoseconds (fibonacci): " + (end - start));
        
        
        start = System.nanoTime();
        long res2 = fibonacciCached(n);
        end = System.nanoTime();
        System.out.println("fibonacciCached: " + res2);
        System.out.println("Elapsed nanoseconds (fibonacciCached): " + (end - start));

        start = System.nanoTime();
        long res3 = fibonacciIterativ(n);
        end = System.nanoTime();
        System.out.println("fibonacciIterativ: " + res3);
        System.out.println("Elapsed nanoseconds (fibonacciIterativ): " + (end - start));
	}
        public static long fibonacci(int n) {
            if (n == 1 || n == 2) {
                return 1;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

        // (b) Rekursiv mit Cache
        public static long fibonacciCached(int n) {
            if (n == 1 || n == 2) {
                return 1;
            }

            if (cache[n] != 0) {
                return cache[n];
            }

            cache[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
            return cache[n];
        }

        // (c) Iterative Fibonacci
        public static long fibonacciIterativ(int n) {
            if (n == 1 || n == 2) {
                return 1;
            }

            long a = 1;
            long b = 1;
            long c = 0;

            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }

            return c;
        }
    }


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
	

	//vectori in care stocam rezultatele operatiilor efectuate
	static Vector<Integer> square ;	
	static Vector<Integer> prime ;
	static Vector<Integer> fib ;
	static Vector<Integer> fact ;

	
	//coada in care stocam evenimentele
	static ArrayBlockingQueue<El_Q> myQueue;

	//nr evenimente per fisier
	static int nr_even;
	static ExecutorService ese;
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		
		square = new Vector<Integer>();	
		prime = new Vector<Integer>();
		fib = new Vector<Integer>();
		fact = new Vector<Integer>();
		
		int nr_files = args.length - 2;
		ese = Executors.newFixedThreadPool(2);
		
		//dimensiunea cozii
		int Q_dim=Integer.parseInt(args[0]);
		myQueue =new ArrayBlockingQueue<El_Q>(Q_dim);
		
		
		
		nr_even = Integer.parseInt(args[1]);
		
		Thread threads[] = new Thread[nr_files];
			
		for(int i=2;i<nr_files+2;i++)
		{
			int aux=i-2;
			threads[aux] = new Thread(new Producer(ese,args[i]));
		}
			
		for (int i = 0; i < nr_files; i++)
			threads[i].start();	
		
		for (int i = 0; i < nr_files; i++)
			threads[i].join();
			 			

		
		ese.shutdown();
		
		ese.awaitTermination(1, TimeUnit.SECONDS);
		
		
		PrintWriter PW1 = new PrintWriter ("PRIME.out");
		PrintWriter PW2 = new PrintWriter ("FACT.out");
		PrintWriter PW3 = new PrintWriter ("SQUARE.out");
		PrintWriter PW4 = new PrintWriter ("FIB.out"); 
		
		
	
		Collections.sort(prime);
	
		for(int i=0;i<prime.size();i++)
			PW1.println (prime.get(i));
	   
	    
	    Collections.sort(fact);
	    
	   
		for(int i=0;i<fact.size();i++)
			PW2.println (fact.get(i));
	    
	    
	    
	    Collections.sort(square);
	    
	    
		for(int i=0;i<square.size();i++)
			PW3.println (square.get(i));
	   
	    
	    Collections.sort(fib);
	    

		for(int i=0;i<fib.size();i++)
			PW4.println (fib.get(i));
	   
		
	    PW1.close ();
	    PW2.close ();
	    PW3.close ();
	    PW4.close ();

	}
}

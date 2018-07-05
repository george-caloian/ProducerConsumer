import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;


class Producer implements Runnable
{
	
	ExecutorService ese;
	String fileName;
	
	BufferedReader br = null;
	FileReader fr = null;
	
	public Producer(ExecutorService ese,String fileName)
	{
		this.ese = ese;
		this.fileName = fileName;	
	}


	public void run()
	{	
		
			try 
			{
				
				fr = new FileReader(fileName);
				br = new BufferedReader(fr);
				
				String CurrLine;
				
				br=new BufferedReader(new FileReader(fileName));
				
				for(int i=0;i< Main.nr_even;i++)
				{					
					//citesc fiecare linie(coresp unui eveniment)
					CurrLine = br.readLine();

					//impart dupa virgula
					StringTokenizer elem = new StringTokenizer(CurrLine,",");
					
					//disting campurile
					int time= Integer.parseInt(elem.nextToken());
					String opr = elem.nextToken();
					int numb = Integer.parseInt(elem.nextToken());
						
					El_Q obj = new El_Q(opr,numb);
					
					Thread.sleep(time);	
					
					Main.myQueue.put(obj);
					
					El_Q buffer2 = new El_Q();
					
					
					buffer2=Main.myQueue.take();

					//in functie de tipul operatiei folosesc workerul
					//care efectueaza acel tip de operatie
					
					if( (buffer2.oper).equals("PRIME"))
						this.ese.submit(new ConsumerPR(buffer2));
					
					if( (buffer2.oper).equals("FACT"))
						this.ese.submit(new ConsumerFA(buffer2));
					
					if( (buffer2.oper).equals("SQUARE"))
						this.ese.submit(new ConsumerSQ(buffer2));
						
					
					if( (buffer2.oper).equals("FIB"))
						this.ese.submit(new ConsumerFI(buffer2));
						
					
				}
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
	}
}

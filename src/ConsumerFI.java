
//Workerul ce rezolva evenimentele de tip FIB

class ConsumerFI implements Runnable
{
	El_Q buffer = new El_Q();
	int id;

	ConsumerFI(El_Q buffer)
	{
		this.buffer = buffer;
	}

	ConsumerFI(){}

	public void run()
	{

		int n=buffer.number;
		boolean ok=true;
		int rez=1;
		int f1=0;
		int f2=1;
		while(ok)
		{
			if(f1+f2<=n)
			{
				int aux=f1;
				f1=f2;
				f2=f1+aux;
				rez = rez+1;
			}
			else ok=false;
		}

		Main.fib.add(rez);
			
		}
		
	

}

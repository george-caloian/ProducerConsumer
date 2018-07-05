
//Workerul ce rezolva evenimentele de tip PRIME

class ConsumerPR implements Runnable
{
	El_Q buffer = new El_Q();
	int id;

	ConsumerPR(El_Q buffer)
	{
		this.buffer = buffer;
	}

	ConsumerPR(){}

	public void run()
	{

		int n=buffer.number;
		
		for(int i=n;i>1;i--)
		{
			boolean ok=true;
			for(int j=2;j<=Math.sqrt(i);j++)
				if(i%j==0)
					ok=false;
			if(ok==true)
			{
				Main.prime.add(i);
				break;
			}
				
		}

	
		}
		
	

}

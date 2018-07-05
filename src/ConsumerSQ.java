
//Workerul ce rezolva evenimentele de tip SQUARE

class ConsumerSQ implements Runnable
{
	El_Q buffer = new El_Q();
	int id;

	ConsumerSQ(El_Q buffer)
	{
		this.buffer = buffer;
	}

	ConsumerSQ(){}

	public void run()
	{

		int n=buffer.number;
		boolean ok=true;
		int rez=1;
		while(ok)
		{
			if(rez*rez<=n)
				rez++;
			else
			{
				ok=false;
				rez=rez-1;
			}
		}

		Main.square.add(rez);
			
	}
		
	

}

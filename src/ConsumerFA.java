
//Workerul ce rezolva evenimentele de tip FACT

class ConsumerFA implements Runnable
{
	El_Q buffer = new El_Q();
	

	ConsumerFA(El_Q buffer)
	{
		this.buffer = buffer;
	}

	ConsumerFA(){}

	public void run()
	{

		int n=buffer.number;
		boolean ok=true;
		int rez=1;
		int faux=1;
		while(ok)
		{
			if(rez<=n)
			{
				faux++;
				rez=rez*faux;
			}
			else
			{
				ok=false;
				faux =faux-1;
			}
		}

		Main.fact.add(faux);
			
		}
		
	

}

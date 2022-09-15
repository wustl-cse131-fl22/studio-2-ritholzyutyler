package studio2;

public class Pi {

	public static void main(String[] args) 
	{
		double angle;
		double hyp;
		double dart;
		int in;
		int out;
		for (int x = 0; x <= 500; x++)
		{
			angle = Math.random() * 90;
			hyp = 1/(Math.sin(Math.toRadians(angle)));
			dart = Math.random() * hyp;
			if(dart < 1)
			{
				in++;
			}
			else
			{
				out++;
			}
		}
		
	}

}

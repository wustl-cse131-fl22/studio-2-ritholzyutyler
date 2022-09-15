package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your starting amount");
		int startAmount = in.nextInt();
		System.out.println("Enter your win chance as a decimal");
		double winChance = in.nextDouble();
		System.out.println("Enter your win limit");
		int winLimit = in.nextInt();
		System.out.println("Enter how many days you go");
		int totalSimulations = in.nextInt();
		int currentAmount = startAmount;
		int plays = 0;
		String winlose;
		int ruin = 0;
		
		for(int x = totalSimulations; x > 0; x--) 
		{
			//System.out.println("Simulation day: " + (totalSimulations - x + 1));
			while (currentAmount > 0 && currentAmount < winLimit) 
			{
				if (Math.random() <= winChance ) {
					currentAmount++;
					plays++;
				}
				else {
					currentAmount--;
					plays++;
				}
				
			}	
			if(currentAmount == 0) {
				winlose = "lose";
				ruin++;
					
			}
			else {
				winlose = "win";
			}
			currentAmount = startAmount;
			System.out.println("Simulation " + (totalSimulations - x + 1 ) + ": " + plays + " " + winlose);
			plays = 0;
		}
		double expectedRuin;
		double alpha = (1-winChance)/winChance;
		if (winChance == .5) {
			expectedRuin = (1-((double)startAmount/winLimit));
		}
		else {
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
		}
		System.out.println("Expected Ruin: " + expectedRuin);
		System.out.println("Ruin from simulation: " + ((double)ruin)/totalSimulations);
		

	}

}

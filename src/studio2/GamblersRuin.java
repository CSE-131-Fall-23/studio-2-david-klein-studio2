package studio2;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class GamblersRuin {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your start amount: ");
		int startAmount = input.nextInt();
		System.out.println("Please enter your win chance: ");
		double winChance = input.nextDouble();
		System.out.println("Please enter your win limit: ");
		double winLimit = input.nextDouble();
		int plays1 = 1;
		System.out.println("How many days would you like to play?");
		int totalSimulations = input.nextInt();
		double a = (1-winChance)/winChance;
		double expectedRuin;
		double losses = 0;
		int newAmount;
		if(winChance ==0.5) {
			expectedRuin = 1-(startAmount/winLimit);
		}
		else {
			expectedRuin = (Math.pow(a,startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a,  winLimit));
		}
		for(int i=0; i<=totalSimulations; i++) {
			newAmount = startAmount;
			int plays=plays1;
			String winOrLose = "";
			while(newAmount>0 && newAmount<winLimit) {
				double result = Math.random();
				if(result<=winChance) {
					newAmount+=1;
					plays++;
				}
				else {
					newAmount-=1;
					plays++;
				}
			}
			if(newAmount<=0) {
				winOrLose = "LOSE";
				losses++;
			}
			else if(newAmount>=winLimit) {
				winOrLose = "WIN";
			}
			System.out.println("SIMULATION "+ i+ ": "+plays +" "+ winOrLose);
		}
		System.out.println("Losses: "+ (int)losses + " Simulations: "+ totalSimulations);
		System.out.println("Ruin Rate from Simulations: "+ losses/totalSimulations + " Expected Ruin Rate: " + expectedRuin);
		
	}
	
}
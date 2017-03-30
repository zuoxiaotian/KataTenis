package com.xiaotian.main;

import java.util.Scanner;

import com.xiaotian.main.Player.Status;

public class Game {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Set set = new Set(new Player(), new Player());
		while(true){
			System.out.println("Which one wins this point?(1 for player1 and 2 for player2)");
			int i = sc.nextInt();
			if (i == 1){
				set.player1WinPoint();
			}else if(i == 2){
				set.player2WinPoint();
			}

			System.out.println("\tPlayer1\t\tPlayer2" );
			System.out.println("Game : \t" + set.getPlayer1().getSetPoint() + "\t - \t" + set.getPlayer2().getSetPoint());
			System.out.println("Set  : \t" 
					+ (set.getPlayer1().getStatus() == Status.NORMAL?set.getPlayer1().getPoint():set.getPlayer1().getStatus())+ "\t - \t" + 
					(set.getPlayer2().getStatus() == Status.NORMAL?set.getPlayer2().getPoint():set.getPlayer2().getStatus()));
			System.out.println();
			
		}
		
	}
}

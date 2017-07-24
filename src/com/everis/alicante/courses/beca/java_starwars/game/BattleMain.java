package com.everis.alicante.courses.beca.java_starwars.game;

import java.io.IOException;
import java.util.Scanner;

import com.everis.alicante.courses.beca.java_starwars.game.controller.BattleController;
import com.everis.alicante.courses.beca.java_starwars.game.controller.BattleControllerImpl;

public class BattleMain {
	
	private static BattleController controller;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		controller = new BattleControllerImpl();
		startApp();

	}

	private static void startApp() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("********************************************************************");
		System.out.println("Welcome to the Battle of the Star Wars, choose an option:");
		System.out.println("1: Add a battle participant");
		System.out.println("2: Delete a battle participant");
		System.out.println("3: List all the battle participants");
		System.out.println("4: List the Rebel battle participants");
		System.out.println("5: List the Empire battle participants");
		System.out.println("6: PLAY!");
		
		
		Scanner in = new Scanner(System.in);
		Integer option = in.nextInt();
		
		System.out.println("You have chosen the option " + option);
		
		switch (option) {
		case 1:	
			controller.addBP();			
			break;
		case 2:			
			controller.deleteBP();			
			break;
		case 3:			
			controller.listBP();	
			break;
		case 4:			
			controller.listRebels();	
			break;
		case 5:			
			controller.listEmpire();		
			break;
		case 6:			
			controller.play();	
			break;
		default:
			System.out.println("Error!");
			break;
		}
		
		startApp();
	}
	

	
	

}

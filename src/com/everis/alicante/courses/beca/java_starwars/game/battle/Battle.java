package com.everis.alicante.courses.beca.java_starwars.game.battle;

import java.util.List;

import com.everis.alicante.courses.beca.java_starwars.game.abstractclasses.BattleParticipant;

public class Battle {

	public void fight(List<BattleParticipant> empires, List<BattleParticipant> rebels) {
		Integer countEmpire = 0;
		Integer countRebel = 0;
		
		Double fighter1;
		Double fighter2;

	for(BattleParticipant bpEmpire : empires) {
		for(BattleParticipant bpRebel: rebels) {
	
			fighter1 = bpEmpire.getHp()+(bpEmpire.getPower()*Math.random()*100);
			fighter2 = bpRebel.getHp()+(bpRebel.getPower()*Math.random()*100);


			if (fighter1 > fighter2) {
				countEmpire++;
				
			} else {
				countRebel++;
				
			}
			
		}
			
		}
	
	if (countEmpire > countRebel) {
		System.out.println("Empire Winner");
		System.out.println("Empire Battle Won: " + countEmpire);
		System.out.println("Rebel Battle Won: "+ countRebel);
	}	else if  (countEmpire < countRebel) {
		System.out.println("Rebel Winner");
		System.out.println("Empire Battle Won: " + countEmpire);
		System.out.println("Rebel Battle Won: "+ countRebel);
	} else {
		System.out.println("DRAW");
		System.out.println("Empire Battle Won: " + countEmpire);
		System.out.println("Rebel Battle Won: "+ countRebel);
		
	}
		
		
	}


}

package com.everis.alicante.courses.beca.java_starwars.game.domain;

import com.everis.alicante.courses.beca.java_starwars.game.abstractclasses.AirMachine;
import com.everis.alicante.courses.beca.java_starwars.game.utils.FactionEnum;

public class TFighter extends AirMachine{

	public TFighter(String id, String participantName, Integer hp, Integer power, FactionEnum faction) {
		super();
		this.setId(id);
		this.setParticipantName(participantName);
		this.setHp(hp);
		this.setPower(power);
		this.setFaction(faction);
		
	}
}

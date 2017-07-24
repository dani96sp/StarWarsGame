package com.everis.alicante.courses.beca.java_starwars.game.domain;

import com.everis.alicante.courses.beca.java_starwars.game.abstractclasses.AirMachine;
import com.everis.alicante.courses.beca.java_starwars.game.utils.FactionEnum;

public class XWing extends AirMachine{

	public XWing(String id, String participantName, Integer hp, Integer power, FactionEnum faction) {
		super();
		this.setId(id);
		this.setParticipantName(participantName);
		this.setHp(hp);
		this.setPower(power);
		this.setFaction(faction);
		
	}
}

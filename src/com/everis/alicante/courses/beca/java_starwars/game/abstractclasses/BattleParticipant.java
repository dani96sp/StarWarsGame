package com.everis.alicante.courses.beca.java_starwars.game.abstractclasses;

import com.everis.alicante.courses.beca.java_starwars.game.utils.FactionEnum;

public abstract class BattleParticipant {

	private String id;
	private String participantName;
	private Integer hp;
	private Integer power;
	private FactionEnum faction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public Integer getHp() {
		return hp;
	}

	protected void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getPower() {
		return power;
	}

	protected void setPower(Integer power) {
		this.power = power;
	}

	public FactionEnum getFaction() {
		return faction;
	}

	protected void setFaction(FactionEnum faction) {
		this.faction = faction;
	}

	public String convertToFormatTxt() {

		String str = "";
		str = str.concat(this.id);
		str = str.concat(";");
		str = str.concat(this.participantName);
		str = str.concat(";");
		str = str.concat(String.valueOf(this.hp));
		str = str.concat(";");
		str = str.concat(String.valueOf(this.power));
		str = str.concat(";");
		str = str.concat(String.valueOf(getFaction()));
		
		
		return str;
	
	}
	
}

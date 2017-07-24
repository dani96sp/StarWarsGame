package com.everis.alicante.courses.beca.java_starwars.game.dao.impl;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.beca.java_starwars.game.abstractclasses.BattleParticipant;

public interface BattleParticipantDAO {

	Map<String, BattleParticipant> readBP() throws IOException;

	void createBP(BattleParticipant bp) throws IOException;

	void deleteBP(String nameParticipant);

}

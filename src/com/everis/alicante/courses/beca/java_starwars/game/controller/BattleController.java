package com.everis.alicante.courses.beca.java_starwars.game.controller;

import java.io.IOException;

public interface BattleController {

	void addBP();

	void deleteBP();

	void listBP() throws IOException;

	void listRebels() throws IOException;

	void listEmpire() throws IOException;

	void play() throws IOException;

}

package com.everis.alicante.courses.beca.java_starwars.game.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import com.everis.alicante.courses.beca.java_starwars.game.abstractclasses.BattleParticipant;
import com.everis.alicante.courses.beca.java_starwars.game.domain.ATAT;
import com.everis.alicante.courses.beca.java_starwars.game.domain.Destructor;
import com.everis.alicante.courses.beca.java_starwars.game.domain.Jedi;
import com.everis.alicante.courses.beca.java_starwars.game.domain.Sith;
import com.everis.alicante.courses.beca.java_starwars.game.domain.TFighter;
import com.everis.alicante.courses.beca.java_starwars.game.domain.XWing;
import com.everis.alicante.courses.beca.java_starwars.game.utils.FactionEnum;

public class BattleParticipantDAOImpl implements BattleParticipantDAO {

	@Override
	public Map<String, BattleParticipant> readBP() throws IOException {

Map<String, BattleParticipant> bp = new TreeMap<String, BattleParticipant>();

		String line;

		File file = new File("src/resources/BP.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		while ((line = buffer.readLine()) != null) {

			if (!line.contains("PARTICIPANT_NAME") || line.isEmpty()) {

				String[] temp = line.split(";");

				if (line.contains("SITH")) {
					BattleParticipant bpTemp = new Sith(temp[0], temp[1], Integer.parseInt(temp[2]),
							Integer.parseInt(temp[3]), FactionEnum.EMPIRE);
					bp.put(bpTemp.getId(), bpTemp);
				}
				if (line.contains("JEDI")) {
					BattleParticipant bpTemp = new Jedi(temp[0], temp[1], Integer.parseInt(temp[2]),
							Integer.parseInt(temp[3]), FactionEnum.REBEL);
					bp.put(bpTemp.getId(), bpTemp);
				}
				if (line.contains("ATAT")) {
					BattleParticipant bpTemp = new ATAT(temp[0], temp[1], Integer.parseInt(temp[2]),
							Integer.parseInt(temp[3]), FactionEnum.EMPIRE);
					bp.put(bpTemp.getId(), bpTemp);
				}
				if (line.contains("DESTRUCTOR")) {
					BattleParticipant bpTemp = new Destructor(temp[0], temp[1], Integer.parseInt(temp[2]),
							Integer.parseInt(temp[3]), FactionEnum.REBEL);
					bp.put(bpTemp.getId(), bpTemp);
				}
				if (line.contains("TFIGHTER")) {
					BattleParticipant bpTemp = new TFighter(temp[0], temp[1], Integer.parseInt(temp[2]),
							Integer.parseInt(temp[3]), FactionEnum.EMPIRE);
					bp.put(bpTemp.getId(), bpTemp);
				}
				if (line.contains("XWING")) {
					BattleParticipant bpTemp = new XWing(temp[0], temp[1], Integer.parseInt(temp[2]),
							Integer.parseInt(temp[3]), FactionEnum.REBEL);
					bp.put(bpTemp.getId(), bpTemp);
				}

			}

			
		}

		reader.close();

		return bp;

	}

	@Override
	public void createBP(BattleParticipant bp) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("src/resources/BP.txt");
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter buffer = new BufferedWriter(writer);

		buffer.newLine();
		buffer.write(bp.convertToFormatTxt());

		buffer.close();

	}

	@Override
	public void deleteBP(String nameParticipant) {
		// TODO Auto-generated method stub

	}

}

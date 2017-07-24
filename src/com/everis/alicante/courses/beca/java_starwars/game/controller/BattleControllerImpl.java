package com.everis.alicante.courses.beca.java_starwars.game.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.everis.alicante.courses.beca.java_starwars.game.abstractclasses.BattleParticipant;
import com.everis.alicante.courses.beca.java_starwars.game.battle.Battle;
import com.everis.alicante.courses.beca.java_starwars.game.dao.impl.BattleParticipantDAO;
import com.everis.alicante.courses.beca.java_starwars.game.dao.impl.BattleParticipantDAOImpl;
import com.everis.alicante.courses.beca.java_starwars.game.domain.ATAT;
import com.everis.alicante.courses.beca.java_starwars.game.domain.Destructor;
import com.everis.alicante.courses.beca.java_starwars.game.domain.Jedi;
import com.everis.alicante.courses.beca.java_starwars.game.domain.Sith;
import com.everis.alicante.courses.beca.java_starwars.game.domain.TFighter;
import com.everis.alicante.courses.beca.java_starwars.game.domain.XWing;
import com.everis.alicante.courses.beca.java_starwars.game.utils.FactionEnum;

public class BattleControllerImpl implements BattleController {

	@Override
	public void addBP() {
		// TODO Auto-generated method stub

		System.out.println("Insert the name of the battle participant");
		Scanner in = new Scanner(System.in);
		String nameParticipant = in.nextLine();
		int idRandom = (int) (Math.random() * 25 + 1);
		String idBP = nameParticipant + String.valueOf(idRandom);

		System.out.println("Choose your battle participant:");
		System.out.println("                               ");
		System.out.println("EMPIRE                    REBEL");
		System.out.println("                               ");
		System.out.println("WARRIOR                 WARRIOR");
		System.out.println("1. SITH                 2. JEDI");
		System.out.println("                               ");
		System.out.println("EARTH MACHINE     EARTH MACHINE");
		System.out.println("3. ATAT           4. DESTRUCTOR");
		System.out.println("                               ");
		System.out.println("AIR MACHINE         AIR MACHINE");
		System.out.println("5. T-FIGHTER        6. X-WING  ");

		Scanner in2 = new Scanner(System.in);
		Integer option = in2.nextInt();
		BattleParticipant bp;

		switch (option) {
		case 1:
			bp = new Sith(idBP, nameParticipant, 300, 300, FactionEnum.EMPIRE);
			break;
		case 2:
			bp = new Jedi(idBP, nameParticipant, 300, 300, FactionEnum.REBEL);
			break;
		case 3:
			bp = new ATAT(idBP, nameParticipant, 500, 500, FactionEnum.EMPIRE);
			break;
		case 4:
			bp = new Destructor(idBP, nameParticipant, 500, 500, FactionEnum.REBEL);
			break;
		case 5:
			bp = new TFighter(idBP, nameParticipant, 700, 700, FactionEnum.EMPIRE);
			break;
		case 6:
			bp = new XWing(idBP, nameParticipant, 700, 700, FactionEnum.REBEL);
			break;
		default:
			System.out.println("ERROR! NOT VALID OPTION");
			break;
		}

	}

	@Override
	public void deleteBP() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listBP() throws IOException {
		// TODO Auto-generated method stub

		BattleParticipantDAO daoBp = new BattleParticipantDAOImpl();

		Map<String, BattleParticipant> bp = daoBp.readBP();

		Collection<BattleParticipant> collection = bp.values();

		collection.stream().forEach(a -> System.out.println(a.convertToFormatTxt()));;

//		for (Iterator<BattleParticipant> iterator = collection.iterator(); iterator.hasNext();) {
//			BattleParticipant bps = (BattleParticipant) iterator.next();
//
//			System.out.println(bps.convertToFormatTxt());
//		}

	}

	@Override
	public void listRebels() throws IOException {
		// TODO Auto-generated method stub
		BattleParticipantDAO daoBp = new BattleParticipantDAOImpl();

		Map<String, BattleParticipant> bp = daoBp.readBP();
		;

		Collection<BattleParticipant> collection = bp.values();

		collection.stream().filter(a -> a.getFaction().name().equals("REBEL")).forEach(a -> System.out.println(a.convertToFormatTxt()));;
		
//		for (Iterator<BattleParticipant> iterator = collection.iterator(); iterator.hasNext();) {
//			BattleParticipant bps = (BattleParticipant) iterator.next();
//
//			if (bps.getFaction().name().equals("REBEL")) {
//
//				System.out.println(bps.convertToFormatTxt());
//
//			}
//		}
	}

	@Override
	public void listEmpire() throws IOException {
		// TODO Auto-generated method stub

		BattleParticipantDAO daoBp = new BattleParticipantDAOImpl();

		Map<String, BattleParticipant> bp = daoBp.readBP();
		;

		Collection<BattleParticipant> collection = bp.values();

		collection.stream().filter(a -> a.getFaction().name().equals("EMPIRE")).forEach(a -> System.out.println(a.convertToFormatTxt()));;

//		for (Iterator<BattleParticipant> iterator = collection.iterator(); iterator.hasNext();) {
//			BattleParticipant bps = (BattleParticipant) iterator.next();
//
//			if (bps.getFaction().name().equals("EMPIRE")) {
//
//				System.out.println(bps.convertToFormatTxt());
//			}
//		}

	}

	@Override
	public void play() throws IOException {
		// TODO Auto-generated method stub
		List<BattleParticipant> rebels = listRebelsList();
        List<BattleParticipant> empires = listEmpireList();
        Battle battle = new Battle();
        battle.fight(empires, rebels);
	}
	
	private List<BattleParticipant> listRebelsList() throws IOException{

		List<BattleParticipant> bps = new ArrayList<>();

		String linea;

		File file = new File("src/resources/BP.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		while ((linea = buffer.readLine()) != null) {

			if (linea.contains("JEDI")) {

				BattleParticipant bpTemp = new Jedi(null, null, 300, 300, FactionEnum.REBEL);

				String[] temp = linea.split(";");

				bpTemp.setId(temp[0]);
				bpTemp.setParticipantName(temp[1]);

				bps.add(bpTemp);

			} else if (linea.contains("DESTRUCTOR")) {
				BattleParticipant bpTemp = new Destructor(null, null, 500, 500, FactionEnum.REBEL);

				String[] temp = linea.split(";");

				bpTemp.setId(temp[0]);
				bpTemp.setParticipantName(temp[1]);

				bps.add(bpTemp);
			} else if (linea.contains("XWING")) {
				BattleParticipant bpTemp = new XWing(null, null, 700, 700, FactionEnum.REBEL);

				String[] temp = linea.split(";");

				bpTemp.setId(temp[0]);
				bpTemp.setParticipantName(temp[1]);

				bps.add(bpTemp);
			}

		}

		reader.close();

		return bps;

	}
	
	private List<BattleParticipant> listEmpireList() throws IOException{

		List<BattleParticipant> bps = new ArrayList<>();

		String linea;

		File file = new File("src/resources/BP.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		while ((linea = buffer.readLine()) != null) {

			if (linea.contains("SITH")) {

				BattleParticipant bpTemp = new Sith(null, null, 300, 300, FactionEnum.EMPIRE);

				String[] temp = linea.split(";");

				bpTemp.setId(temp[0]);
				bpTemp.setParticipantName(temp[1]);

				bps.add(bpTemp);

			} else if (linea.contains("ATAT")) {
				BattleParticipant bpTemp = new ATAT(null, null, 500, 500, FactionEnum.EMPIRE);

				String[] temp = linea.split(";");

				bpTemp.setId(temp[0]);
				bpTemp.setParticipantName(temp[1]);

				bps.add(bpTemp);
			} else if (linea.contains("TFIGHTER")) {
				BattleParticipant bpTemp = new TFighter(null, null, 500, 500, FactionEnum.EMPIRE);

				String[] temp = linea.split(";");

				bpTemp.setId(temp[0]);
				bpTemp.setParticipantName(temp[1]);

				bps.add(bpTemp);
			}

		}

		reader.close();

		return bps;

	}
	
	
}

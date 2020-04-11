package hu.ak_akademia.hangman;

import java.util.Random;

public class RandomWordGenerator {

//a konstansok elnevezési konvenciója szerint mind nagybetű
	private static final String[] ALL_WORDS = { "pénztárca", "fűzfa", "oroszlán", "laptop", "java", "metódus",
			"fluxuskondenzátor", "Földközi-tenger", "Klapka György", "selyemsonka", "cipőfűző", "selyemmajom",
			"termosztát", "fridzsider", "lépcsőház", "asszertív emberi jog", "Zalahárshegyzöce", "Csikóstőttős",
			"vesztettél" };

	public String generate() {
//		CMND+ALT+I-vel ezeket egy sorba is lehet akár rakni
		Random random = new Random();
		int randomIndex = random.nextInt(ALL_WORDS.length);
		String randomWord = ALL_WORDS[randomIndex];
		return randomWord;
	}

}

package hu.ak_akademia.hangman;

import java.util.Scanner;

public class UserInputManager {

	private static final String HUNGARIAN_ALPHABET = "abcdefghijklmnopqrstuvwxyzöüóőúéáűí".toUpperCase();
	private Scanner scanner = new Scanner(System.in);

	public String readStringFromUser(String message) {
		String userInput;
		do {
			System.out.print(message);
			userInput = scanner.nextLine();
			if (!isValid(userInput)) {
				System.out.println(Messages.getMismatchMessage());
			}
		} while (!isValid(userInput));
		return userInput;
	}

	private boolean isValid(String userInput) {
		for (int i = 0; i < userInput.length(); i++) {
			String letter = Character.toString(userInput.charAt(i));
			if (isLetter(userInput)) {
				return HUNGARIAN_ALPHABET.contains(letter);
			} else if (isAttemptToSolve(userInput)) {
				return HUNGARIAN_ALPHABET.contains(letter) || letter.equals(" ") || letter.equals("-");
			}
		}
		return false;
	}

	public boolean isAttemptToSolve(String userInput) {
		return userInput.length() > 1;
	}

	public boolean isLetter(String userInput) {
		return userInput.length() == 1;
	}
}

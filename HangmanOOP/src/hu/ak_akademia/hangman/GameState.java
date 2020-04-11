package hu.ak_akademia.hangman;

public class GameState {

	private int mistakes;
	private String[] mismatchingLetter = new String[10];
	private WordToSolve wordToSolve;
	private StatusOfGame status = StatusOfGame.GAME_IN_PROGRESS;
	private String solution;

	public GameState(String solution) {
		this.solution = solution;
		wordToSolve = new WordToSolve(solution);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(wordToSolve).append("\n");
		builder.append("Rossz betűk: ").append(getMMLettersAsString()).append("\n");
		builder.append("Életek: ").append(10 - mistakes).append("\n");
		return builder.toString();
	}

	private String getMMLettersAsString() {
		StringBuilder builder = new StringBuilder();
		String separator = "";

		for (int i = 0; i < mistakes; i++) {
			builder.append(separator);
			builder.append(mismatchingLetter[i]);
			separator = ", ";
		}

		return builder.toString();
	}

	public boolean isInSolution(String letter) {
		for (int i = 0; i < solution.length(); i++) {
			if (solution.charAt(i) == letter.charAt(0)) {
				return true;
			}
		}
		return false;
	}

	public void revealLetter(String letter) {
		wordToSolve.reveal(letter);
	}

	public boolean isGameOver() {
		return isWon() || isLost();
	}

	public boolean isLost() {
		return status.equals(StatusOfGame.GAME_LOST);
	}

	public boolean isWon() {
		return status.equals(StatusOfGame.GAME_WON);
	}

	public boolean storeMistake(String guess) {
		if (isInArray(mismatchingLetter, guess)) {
			return true;
		} else {
			mismatchingLetter[mistakes] = guess;
			mistakes++;
			return false;
		}
	}

	private boolean isInArray(String[] arrayToSearchIn, String elementToSearchFor) {
		for (String element : arrayToSearchIn) {
			if (element != null && element.equalsIgnoreCase(elementToSearchFor)) {
				return true;
			}
		}
		return false;
	}

	public void update() {
		if (mistakes >= 10) {
			status = StatusOfGame.GAME_LOST;
		}
		if (wordToSolve.isSolved()) {
			status = StatusOfGame.GAME_WON;
		}
	}

	public void setStatus(StatusOfGame status) {
		this.status = status;
	}
}

package hu.ak_akademia.hangman;

public class WordToSolve {

	private String solution;
	private String partialSolution = "";

	public WordToSolve(String solution) {
		this.solution = solution;
		for (int i = 0; i < solution.length(); i++) {
			if (solution.charAt(i) == '-' || solution.charAt(i) == ' ') {
				partialSolution += solution.charAt(i) + " ";

			} else {
				partialSolution += "_ ";
			}
		}
	}

	@Override
	public String toString() {
		return partialSolution;
	}

	public void reveal(String letter) {
		StringBuilder newPartialSolution = new StringBuilder(partialSolution);
		for (int matchingLetterIndex = 0; matchingLetterIndex < solution.length(); matchingLetterIndex++) {
			if (Character.toLowerCase(solution.charAt(matchingLetterIndex)) == Character
					.toLowerCase(letter.charAt(0))) {
				newPartialSolution.replace((matchingLetterIndex * 2), (matchingLetterIndex * 2 + 1), letter);
			}
		}
		partialSolution = newPartialSolution.toString();
	}

	public boolean isSolved() {
		return !partialSolution.contains("_");
	}
}

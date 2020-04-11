package hu.ak_akademia.hangman;

public class HangManController {

	public static void main(String[] args) {
		new HangManController().run();
	}

	private void run() {
		RandomWordGenerator generator = new RandomWordGenerator();
		String solution = generator.generate();
		GameState gameState = new GameState(solution);
		UserInputManager in = new UserInputManager();

		System.out.println(Messages.getWelcomeMessage());

		do {
			System.out.println(gameState);
			String guess = in.readStringFromUser(Messages.getUserInputMessage());

			if (in.isLetter(guess)) {
				if (gameState.isInSolution(guess)) {
					gameState.revealLetter(guess);
				} else {
					if (gameState.storeMistake(guess)) {
						System.out.println(Messages.getOopsIDidItAgain());
					}
				}
			} else if (in.isAttemptToSolve(guess)) {
				if (guess.equalsIgnoreCase(solution)) {
					gameState.setStatus(StatusOfGame.GAME_WON);
				} else {
					gameState.setStatus(StatusOfGame.GAME_LOST);

				}
			}
			gameState.update();
		} while (!gameState.isGameOver());
		if (gameState.isWon()) {
			System.out.println(Messages.getWinMessage());
		}
		if (gameState.isLost()) {
			System.out.println(Messages.getLoseMessage());
			System.out.println("Szó: " + solution);
		}
		System.out.println(Messages.getGoodbyeMessage());
	}

}

package business;

import persistence.RulesTicTacToe;

public class ControlTicTacToe {
	
	public static void setLevel(int level) {
		RulesTicTacToe.setLevel(level);
	}
	
	public static void startMach() {
		RulesTicTacToe.startMach();
	}
	
	public static boolean isValidMove(int i, int j) {
		if(RulesTicTacToe.isValidMove(i,j)){
			RulesTicTacToe.mark(i, j);
			return true;
		}else return false;
	}
	
	public static char[][] getTable(){
		return RulesTicTacToe.getTable();
	}

	public static boolean isGameOver() {
		return RulesTicTacToe.isGameOver();
	}
	
	public static boolean isDraw() {
		return RulesTicTacToe.isDraw();
	}

	public static boolean isWon() {
		return RulesTicTacToe.isWon();
	}

	public static boolean isMach() {
		return RulesTicTacToe.isMach();
	}

	public static char getTurn() {
		return RulesTicTacToe.getTurn();
	}
}

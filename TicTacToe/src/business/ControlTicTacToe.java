package business;

import persistence.RulesTicTacToe;

public class ControlTicTacToe {
	
	public static void setLevel(int level) {
		RulesTicTacToe.setLevel(level);
	}

	public static char[][] getTable(){
		return RulesTicTacToe.getTable();
	}
	
	public static void startMach() {
		RulesTicTacToe.startMach();
	}
}

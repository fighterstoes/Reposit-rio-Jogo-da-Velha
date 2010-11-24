package persistence;

import java.util.Random;

public class RulesTicTacToe {
	private static char[][] table = new char[3][3];
	private static boolean draw, won, mach;
	private static char turn;
	private static int level, n;

	public static boolean isDraw() {
		return draw;
	}

	public static void setLevel(int level) {
		RulesTicTacToe.level = level;
	}

	public static boolean isWon() {
		return won;
	}

	public static boolean isMach() {
		return mach;
	}

	public static char getTurn() {
		return turn;
	}

	public static char[][] getTable() {
		return table;
	}

	public static void startMach() {
		draw=false; won=false; mach=true; turn='o'; n = 0;
		for(int k=0;k<3;k++){ //limpar tabuleiro
			for(int j=0;j<3;j++){table[k][j]=' ';}}
	}
}

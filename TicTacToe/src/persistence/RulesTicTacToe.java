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

	public static void abortMach() {
		mach=false;
	}

	public static char[][] getTable() {
		return table;
	}

	public static void changeTurn() {
		if(turn=='o') turn='x';
		else turn='o';
	}

	public static void startMach() {
		draw=false; won=false; mach=true; turn='o'; n = 0;
		for(int k=0;k<3;k++){ //limpar tabuleiro
			for(int j=0;j<3;j++){table[k][j]=' ';}}
	}

	public static boolean isValidMove( int i, int j){
		if (table[i][j]==' ')	return true;
		else return false;
	}

	public static boolean isDrawn(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(table[i][j]==' ') return false;
			}}
		return true;
	}

	public static boolean isWinner(){
		for(int i=0;i<3;i++){
			if(((table[i][0]!=' ')&&(table[i][0]==table[i][1])&&(table[i][0]==table[i][2])&&(table[i][1]==table[i][2]))|| //linhas
					((table[0][i]!=' ')&&(table[0][i]==table[1][i])&&(table[0][i]==table[2][i])&&(table[1][i]==table[2][i]))) return true; //colunas
		}

		if(((table[0][0]!=' ')&&(table[0][0]==table[1][1])&&(table[1][1]==table[2][2])&&(table[0][0]==table[2][2]))|| //diagonal principal
				((table[0][2]!=' ')&&(table[0][2]==table[1][1])&&(table[1][1]==table[2][0])&&(table[0][2]==table[2][0])))return true; //diagonal principal
		else return false;
	}

	public static boolean isGameOver() {
		if(draw||won)return true;
		else return false;
	}

	public static void mark(int i, int j){
		table[i][j]=turn;
		changeTurn();
		won = RulesTicTacToe.isWinner();
		draw = RulesTicTacToe.isDrawn();
		n++;
	}

}

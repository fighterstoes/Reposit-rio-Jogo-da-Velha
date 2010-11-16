package controle;

import entidade.RegrasDoJogoDaVelha;

public class Jogo {
	private static char[][] tabuleiro = new char[3][3];
	private static boolean velhou, ganhou, partida;
	private static char vez;
	
	public static void incioPartida() {
		velhou=false; ganhou=false; partida=true; vez='o';
		for(int k=0;k<3;k++){ //limpar tabuleiro
			for(int j=0;j<3;j++){tabuleiro[k][j]=' ';}}
	}
	
	public static void trocaVez() {
		if(vez=='o') vez='x';
		else vez='o';
	}

	public static boolean jogadaValida(int i, int j) {
		if(RegrasDoJogoDaVelha.jogadaValida(tabuleiro, i,j)){
			tabuleiro[i][j]=vez;
			trocaVez();
			ganhou = RegrasDoJogoDaVelha.ganhou(tabuleiro);
			velhou = RegrasDoJogoDaVelha.velhou(tabuleiro);
			return true;
		}else return false;
	}

	public static void abortaJogo() {
		partida=false;
	}

	public static boolean jogoAcabou() {
		if(velhou||ganhou)return true;
		else return false;
	}
	
	public static void jogaRobo() {
		int[] jr = RegrasDoJogoDaVelha.jogadaRobo(tabuleiro);
		tabuleiro[jr[0]][jr[1]]=vez;
		trocaVez();
	}

	public static char[][] getTabuleiro() {
		return tabuleiro;
	}

	public static boolean isVelhou() {
		return velhou;
	}

	public static boolean isGanhou() {
		return ganhou;
	}

	public static boolean isPartida() {
		return partida;
	}

	public static char getVez() {
		return vez;
	}
}

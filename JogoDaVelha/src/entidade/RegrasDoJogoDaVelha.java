package entidade;

import java.util.Random;

public class RegrasDoJogoDaVelha {

	public static boolean jogadaValida(char[][] t, int i, int j){
		if (t[i][j]==' ')	return true;
		else return false;
	}

	public static boolean ganhou(char[][] t){
		for(int i=0;i<3;i++){
			if(((t[i][0]!=' ')&&(t[i][0]==t[i][1])&&(t[i][0]==t[i][2])&&(t[i][1]==t[i][2]))|| //linhas
			   ((t[0][i]!=' ')&&(t[0][i]==t[1][i])&&(t[0][i]==t[2][i])&&(t[1][i]==t[2][i]))) return true; //colunas
		}

		if(((t[0][0]!=' ')&&(t[0][0]==t[1][1])&&(t[1][1]==t[2][2])&&(t[0][0]==t[2][2]))|| //diagonal principal
				((t[0][2]!=' ')&&(t[0][2]==t[1][1])&&(t[1][1]==t[2][0])&&(t[0][2]==t[2][0])))return true; //diagonal principal
		else return false;
	}

	public static boolean velhou(char[][] t){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(t[i][j]==' ') return false;
			}}
		return true;
	}

	public static int[] jogadaRobo(char[][] t) {
		int[] jr = new int[2];
		Random rnd = new Random();
		boolean achou=false;
		while(!achou){
			jr[0] = rnd.nextInt(3);
			jr[1] = rnd.nextInt(3);
			achou = jogadaValida(t, jr[0], jr[1]);
		}
		return jr;
	}
}

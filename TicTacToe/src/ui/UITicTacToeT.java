package ui;

import java.util.Scanner;

import business.ControlTicTacToe;

public class UITicTacToeT {

	public static void startGameTP(){
		Scanner sc = new Scanner(System.in);;
		do{
			ControlTicTacToe.startMach();
			while(!ControlTicTacToe.isGameOver()){
				writeTable();
				readMoveT();
				verifyStatus();
			}
			System.out.println("Deseja jogar outra partida? 0 = não\n");
		}while(sc.nextInt()!=0);
		System.exit(0);
	}

	static void writeTable(){
		char[][] table = new char[3][3];
		table = ControlTicTacToe.getTable();
		System.out.println("    0 . 1 . 2 ");
		for(int i=0;i<3;i++){
			System.out.printf(i+". ");
			for(int j=0;j<3;j++){
				if(i!=2)
					if((table[i][j]==' ')) System.out.printf("___");
					else System.out.printf("_"+table[i][j]+"_");
				else
					if((table[i][j]==' ')) System.out.printf("   ");
					else System.out.printf(" "+table[i][j]+" ");
				if(j!=2)System.out.printf("|");
				else System.out.println();
			}
		}
		System.out.println();
	}

	static void readMoveT(){
		System.out.println("Jogador "+ControlTicTacToe.getTurn());
		Scanner sc = new Scanner(System.in);
		int i,j;
		boolean ok;
		do{
			System.out.printf(" linha:");
			i = sc.nextInt();
			System.out.printf(" coluna:");
			j = sc.nextInt();
			ok = ControlTicTacToe.isValidMove(i,j);
			if(!ok) System.out.println("Posição Ocupada");
		}while(!ok);
	}

	private static void verifyStatus(){
		if (ControlTicTacToe.isWon()){System.out.println("\t"+(ControlTicTacToe.getTurn()=='o'?'X':'O')+" ganhou!\n");}
		else if (ControlTicTacToe.isDraw()){System.out.println("Ops! Velhou...\n");}
		if(ControlTicTacToe.isWon()||ControlTicTacToe.isDraw()) writeTable();
	}

	public static void startGameTR() {
		Scanner sc = new Scanner(System.in);
		do{
			ControlTicTacToe.startMach();
			writeTable();
			System.out.println("Deseja jogar outra partida? 0 = não");
		}while(sc.nextInt()!=0);
		System.exit(0); 
	}

}

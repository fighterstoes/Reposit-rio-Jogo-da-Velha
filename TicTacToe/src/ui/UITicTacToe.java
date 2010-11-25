package ui;

import java.util.Scanner;

import javax.swing.JOptionPane;

import business.ControlTicTacToe;

public class UITicTacToe {

	private static char iu;
	private static char op;
	private static int lv;

	public static void main(String[] args) {
		if(args.length==0){
			args= new String[1];
			args[0]="";}

		args[0].toLowerCase();
		switch (args[0].length()){
		case 0: case 1:
			if((args[0].length()==0)||(args[0].equals("t"))) {
				iu='t';
				System.out.println("Modo Texto Ativado");
				selectOponentT();
				System.out.println("* A qualquer momento durante o jogo você pode entrar uma posição inválida p/ abortar a partida\n");
			}else if (args[0].equals("g")){
				iu='g';
				JOptionPane.showMessageDialog(null, "Tic Tac Toes");
				selectOponentG();
			}else {
				System.err.println("argumento invalido");
				System.exit(0);
			}
			break;

		case 2: 
			iu= (((args[0].charAt(0)=='t')||(args[0].charAt(0)=='g'))?args[0].charAt(0):' ');
			op= (((args[0].charAt(1)=='p')||(args[0].charAt(1)=='c'))?args[0].charAt(1):' ');
			if((iu==' ')||(op==' ')){
				System.err.println("argumento invalido");
				System.exit(0);
			}break;
		default: System.err.println("argumento invalido");
		System.exit(0);
		break;
		}
		
		boolean jogar = true;
		do{
			if(iu=='t'){ 
				if(op=='p'){
					System.out.println("Bom jogo para vocês (^.^)v ");
					UITicTacToeT.startGameTP();
				}else{ 
					System.out.println("Boa Sorte contra nossa lógica (^.~) ");
					do{
						System.out.println("Qual nivel? Fácil = 0 , Impossivel = 1");
						Scanner sc = new Scanner(System.in);
						lv = sc.nextInt();
					}while(lv>1);
					ControlTicTacToe.setLevel(lv);
					UITicTacToeT.startGameTR();}
				selectOponentT();
			}else{
				if(op=='c') JOptionPane.showMessageDialog(null,"Boa Sorte contra nossa lógica (^.~) ");
				else JOptionPane.showMessageDialog(null, "Bom jogo para vocês (^.^)v ");
				
				JOptionPane.showMessageDialog(null,"Futura implementação");
				selectOponentG();
			}
			jogar = (op!=' '?true:false);
		}while(jogar);
		
	}

	private static void selectOponentG() {
		op=' ';
		do{
			int opi = JOptionPane.showConfirmDialog(null, "Yes - Robô \n No - Player2 \n Cancel - Sair", "Quem é seu oponente?",1);
			if(!optionSelected(opi)) JOptionPane.showMessageDialog(null,"Clique em uma opção válida");
		}while((op!='c')&&(op!='p'));
	}

	private static void selectOponentT() {
		op=' ';
		do{
			System.out.println("Quem é seu oponente? 0 - Computador; 1 - Player2; 2 - Sair ");
			Scanner sc = new Scanner(System.in);
			int opi = sc.nextInt();
			if(!optionSelected(opi)) System.out.println("\tEntre uma opção de adversario válida\n");
		}while((op!='c')&&(op!='p'));
		
	}

	private static boolean optionSelected(int opi) {
		switch (opi){
		case 0: op ='c'; return true; 
		case 1: op='p'; return true; 
		case 2: System.exit(0); break;
		}
		return false;
	}
}




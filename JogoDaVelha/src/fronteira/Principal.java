package fronteira;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {

	private static char iu;
	private static char op;

	public static void main(String[] args) {
		if(args.length==0){
			args= new String[1];
			args[0]="";}

		args[0].toLowerCase();
		switch (args[0].length()){
		case 0: case 1:
			if((args[0].length()==0)||(args[0].equals("t"))) {
				iu='t'; System.out.println("Modo Texto Ativado");
				op=' ';
				do{
					System.out.println("Quem é seu oponente? 1 = Computador 2 = Jogador2 [3 = Sair] ");
					Scanner sc = new Scanner(System.in);
					int opi = sc.nextInt();
					switch (opi){
					case 1: System.out.println("Boa Sorte contra nossa lógica (^.~) "); op ='c'; break;
					case 2: System.out.println("Bom jogo para vocês (^.^)v "); op='p'; break;
					case 3: System.exit(0); break;
					default: System.out.println("\tEntre uma opção de adversario válida\n");break;
					}
				}while((op!='c')&&(op!='p'));
				System.out.println("* A qualquer momento durante o jogo você pode entrar uma posição inválida p/ abortar a partida\n");
				if(op=='p') IUJogodaVelhaT.iniciaJogoTP();
				else IUJogodaVelhaT.iniciaJogoTR();
			}else if (args[0].equals("g")){
				iu='g';
				JOptionPane.showMessageDialog(null, "Tic Tac Toes");
				do{
					int opi = JOptionPane.showConfirmDialog(null, "Outro Jogador - Yes \n Máquina - No", "Quem é seu oponente?",1);
					switch (opi){
					case 1: JOptionPane.showMessageDialog(null,"Boa Sorte contra nossa lógica (^.~) "); op ='c'; break;
					case 0: JOptionPane.showMessageDialog(null,"Bom jogo para vocês (^.^)v "); op='p'; break;
					case 2: System.exit(0); break;
					default: JOptionPane.showMessageDialog(null,"Clique em uma opção válida");break;
					}
				}while((op!='c')&&(op!='p'));
				if(op=='p')IUJogoDaVelhaG.iniciaJogoGP();
				else JOptionPane.showMessageDialog(null,"Futura implementação");
			}else {
				System.err.println("argumento invalido");
				System.exit(0);
			}break;

		case 2: 
			iu= (((args[0].charAt(0)=='t')||(args[0].charAt(0)=='g'))?args[0].charAt(0):' ');
			op= (((args[0].charAt(1)=='p')||(args[0].charAt(1)=='c'))?args[0].charAt(1):' ');
			if((iu==' ')||(op==' ')){
				System.err.println("argumento invalido");
				System.exit(0);
			}else{
				if(iu=='t'){ System.out.println("Modo Texto Ativado");
				if(op=='p'){System.out.println("Bom jogo para vocês (^.^)v ");
				IUJogodaVelhaT.iniciaJogoTP();}
				else{ System.out.println("Boa Sorte contra nossa lógica (^.~) ");
				IUJogodaVelhaT.iniciaJogoTR();}
				}else{
					JOptionPane.showMessageDialog(null, "Tic Tac Toes");
					if(op=='c'){
						JOptionPane.showMessageDialog(null,"Boa Sorte contra nossa lógica (^.~) ");
						JOptionPane.showMessageDialog(null,"Futura implementação");
					}else{
						JOptionPane.showMessageDialog(null, "Bom jogo para vocês (^.^)v ");
						IUJogoDaVelhaG.iniciaJogoGP();}
				}
			}
			break;
		default: System.err.println("argumento invalido");
		System.exit(0);
		break;
		}
	}
}

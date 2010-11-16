package fronteira;

import java.util.Scanner;

import controle.Jogo;

public class IUJogodaVelhaT {

	public static void iniciaJogoTP(){
		Scanner sc = new Scanner(System.in);;
		do{
			Jogo.incioPartida();
			while(!Jogo.jogoAcabou()){
				escreverTabuleiro();
				lerJogadaT();
				if(!Jogo.isPartida())break; //abortou partida 
				verificarStatus();
			}
			System.out.println("Deseja jogar outra partida? 0 = não\n");
		}while(sc.nextInt()!=0);
		System.exit(0);
	}

	static void escreverTabuleiro(){
		char[][] tabuleiro = new char[3][3];
		tabuleiro = Jogo.getTabuleiro();
		System.out.println("    0 . 1 . 2 ");
		for(int i=0;i<3;i++){
			System.out.printf(i+". ");
			for(int j=0;j<3;j++){
				if(i!=2)
					if((tabuleiro[i][j]==' ')) System.out.printf("___");
					else System.out.printf("_"+tabuleiro[i][j]+"_");
				else
					if((tabuleiro[i][j]==' ')) System.out.printf("   ");
					else System.out.printf(" "+tabuleiro[i][j]+" ");
				if(j!=2)System.out.printf("|");
				else System.out.println();
			}
		}
		System.out.println();
	}

	static void lerJogadaT(){
		System.out.println("Jogador "+Jogo.getVez());
		Scanner sc = new Scanner(System.in);
		int i,j;
		boolean valeu;
		do{
			System.out.printf(" linha:");
			i = sc.nextInt();
			System.out.printf(" coluna:");
			j = sc.nextInt();
			if(!desejaAbortar(i,j)){
				valeu = Jogo.jogadaValida(i,j);
				if(!valeu) System.out.println("Posição Ocupada");
			}else break;
		}while(!valeu);
	}

	private static void verificarStatus(){
		if (Jogo.isGanhou()){System.out.println("\t"+(Jogo.getVez()=='o'?'X':'O')+" ganhou!\n");}
		else if (Jogo.isVelhou()){System.out.println("Ops! Velhou...\n");}
		if(Jogo.isGanhou()||Jogo.isVelhou()) escreverTabuleiro();
	}

	static boolean desejaAbortar(int i, int j){
		Scanner sc = new Scanner(System.in);
		if((i>2)||(i<0)||(j>2)||(j<0)){
			System.out.println("Digitou uma posição invalida\nDeseja Abortar a partida? 0 = Sim");
			if(0==sc.nextInt()){Jogo.abortaJogo(); return true;}
		}return false;
	}

	public static void iniciaJogoTR() {
		Scanner sc = new Scanner(System.in);
		do{
			Jogo.incioPartida();
			boolean roboJoga;
			System.out.println("Quer ser o jogador o (bola) ? 0 = Sim \n Se não, qualquer outro número p/ ser o jogador x (xis)");
			if(sc.nextInt()!=0)Jogo.trocaVez();
			System.out.println("Você é:"+ String.valueOf(Jogo.getVez()).toUpperCase());
			System.out.println("Quer jogar primeiro? 0 == Sim \n Se entrar com qual quer outro número, eu começo (*-*)");
			roboJoga = ((sc.nextInt()==0)?false:true);
			if(roboJoga) Jogo.trocaVez();
			while(!Jogo.jogoAcabou()){
				escreverTabuleiro();
				if (roboJoga){
					jogadaRobo(); roboJoga=false;}
				else{
					lerJogadaT(); 
					if(!Jogo.isPartida())break; 
					roboJoga=true;
				}
				verificarStatus();
			}
			System.out.println("Deseja jogar outra partida? 0 = não");
		}while(sc.nextInt()!=0);
		System.exit(0); 
	}

	private static void jogadaRobo() {
		System.out.println("Jogador Máquina "+Jogo.getVez());
		Jogo.jogaRobo();
	}

}

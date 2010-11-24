package ui;

import javax.swing.JOptionPane;

public class UITicTacToe {
	private static char iu;

	public static void main(String[] args) {
		if(args.length==0){
			args= new String[1];
			args[0]="";}

		args[0].toLowerCase();
		switch (args[0].length()){
		case 0: case 1:
			if((args[0].length()==0)||(args[0].equals("t"))) {
				iu='t'; System.out.println("Modo Texto Ativado");
				
			}else if (args[0].equals("g")){
				iu='g';
				JOptionPane.showMessageDialog(null, "Tic Tac Toes");
			}else {
				System.err.println("argumento invalido");
				System.exit(0);
			}break;

		case 2: 
			iu= (((args[0].charAt(0)=='t')||(args[0].charAt(0)=='g'))?args[0].charAt(0):' ');
			if(iu==' '){
				System.err.println("argumento invalido");
				System.exit(0);
			}			break;
		default: System.err.println("argumento invalido");
		System.exit(0);
		break;
		}
	}

}

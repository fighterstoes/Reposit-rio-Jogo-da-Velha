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

	public static void robotMove() {
		switch (level) {
		case 0:
			int[] jr = new int[2];
			Random rnd = new Random();
			boolean found=false;
			while(!found){
				jr[0] = rnd.nextInt(3);
				jr[1] = rnd.nextInt(3);
				found = isValidMove(jr[0], jr[1]);
			}
			mark(jr[0], jr[1]);
			break;
		case 1:
			boolean marked = false;
			/* 1. Win: If the player has two in a row, play the third to get three in a row.
			   2. Block: If the opponent has two in a row, play the third to block them.
			   3. Fork: Create an opportunity where you can win in two ways.
			   4. Block opponent's fork:
			 * Option 1: Create two in a row to force the opponent into defending, as long as it doesn't result in them creating a fork or winning. 
			 * For example, if "X" has a corner, "O" has the center, and "X" has the opposite corner as well, "O" must not play a corner in order to win.
			 * (Playing a corner in this scenario creates a fork for "X" to win.)
			 * Option 2: If there is a configuration where the opponent can fork, block that fork.
			   5. Center: Play the center.
			   6. Opposite corner: If the opponent is in the corner, play a center of that row or column.
			   7. Empty corner: Play in a corner square.
			   8. Empty side: Play in a middle square on any of the 4 sides. */
			switch (n) {
			case 0: if(isValidMove(1,1))mark(1, 1); break;
			case 1:
				if(isValidMove(1,1))mark(1, 1);
				else
					if(!isValidMove(0,0)){
						if(isValidMove(0,1)) mark(0, 1);
						else if(isValidMove(1,0)) mark(1, 0);
					}else
						if(!isValidMove(0,2)){
							if(isValidMove(0,1)) mark(0, 1);
							else if(isValidMove(1,2)) mark(1, 2);
						}else
							if(!isValidMove(2,0)){
								if(isValidMove(1,0)) mark(1, 0);
								else if(isValidMove(2,1)) mark(2, 1);
							}else
								if(!isValidMove(2,2)){
									if(isValidMove(1,2)) mark(1, 2);
									else if(isValidMove(2,1)) mark(2, 1);
								}else
									if(isValidMove(2,0))mark(2, 0);
									else
										if(isValidMove(2,2))mark(2, 2);
										else
											if(isValidMove(0,0))mark(0, 0);
											else 
												if(isValidMove(0,2))mark(0, 2);
				break;
			case 2: 
				if((!isValidMove(0,0))&&(table[0][0]==turn)){
					if(isValidMove(0,2)) mark(0, 2);
					else if(isValidMove(2,0)) mark(2, 0);
				}else
					if((!isValidMove(0,2))&&(table[0][2]==turn)){
						if(isValidMove(0,0)) mark(0, 0);
						else if(isValidMove(2,0)) mark(2, 0);
					}else
						if((!isValidMove(2,0))&&(table[2][0]==turn)){
							if(isValidMove(0,0)) mark(0, 0);
							else if(isValidMove(2,2)) mark(2, 2);
						}else
							if((!isValidMove(2,2))&&(table[2][2]==turn)){
								if(isValidMove(0,2)) mark(0, 2);
								else if(isValidMove(2,0)) mark(2, 0);
							}else 
								if(!isValidMove(0,0)){
									if(isValidMove(0,1)) mark(0, 1);
									else if(isValidMove(1,0)) mark(1, 0);
								}else
									if(!isValidMove(0,2)){
										if(isValidMove(0,1)) mark(0, 1);
										else if(isValidMove(1,2)) mark(1, 2);
									}else
										if(!isValidMove(2,0)){
											if(isValidMove(1,0)) mark(1, 0);
											else if(isValidMove(2,1)) mark(2, 1);
										}else
											if(!isValidMove(2,2)){
												if(isValidMove(1,2)) mark(1, 2);
												else if(isValidMove(2,1)) mark(2, 1);
											}else
												if(isValidMove(2,0))mark(2, 0);
												else
													if(isValidMove(2,2))mark(2, 2);
													else
														if(isValidMove(0,0))mark(0, 0);
														else 
															if(isValidMove(0,2))mark(0, 2);
				break;
			case 3: case 5: case 7:
				changeTurn();
				for(int i=0;i<3;i++){
					if((table[i][0]!=' ')&&(table[i][0]==turn)){
						if ((table[i][0]==table[i][1])&&(isValidMove(i, 2))){changeTurn(); mark(i,2); marked=true; break;}
						else if ((table[i][0]==table[i][2])&&(isValidMove(i, 1))){changeTurn(); mark(i,1); marked=true; break;}
					}else if((table[i][1]!=' ')&&(table[i][1]==turn)&&(table[i][1]==table[i][2])&&(isValidMove(i, 0))){changeTurn(); mark(i,0); marked=true; break;}//linhas
					else if((table[0][i]!=' ')&&(table[0][1]==turn)){
						if ((table[0][i]==table[1][i])&&(isValidMove(2, i))){changeTurn(); mark(2,i); marked=true; break;}
						else if ((table[0][i]==table[2][i])&&(isValidMove(1, i))){changeTurn(); mark(1,i); marked=true; break;}
					}else if((table[1][i]!=' ')&&(table[1][i]==turn)&&(table[1][i]==table[2][i])&&(isValidMove(0, i))){changeTurn(); mark(0,i); marked=true; break;}//colunas
				}
				if(!marked){
					if((table[0][0]!=' ')&&(table[0][0]==turn)){
						if((table[0][0]==table[1][1])&&(isValidMove(2, 2))){changeTurn();mark(2, 2);marked=true;}
						else if((table[0][0]==table[2][2])&&(isValidMove(1, 1))){changeTurn();mark(1, 1);marked=true;}
					}else if((table[1][1]!=' ')&&(table[1][1]==turn)&&(table[1][1]==table[2][2])&&(isValidMove(0, 0))){changeTurn();mark(0, 0);marked=true;} //diagonal principal
					else if((table[0][2]!=' ')&&(table[0][2]==turn)){
						if((table[0][2]==table[1][1])&&(isValidMove(2, 0))){changeTurn();mark(2, 0);marked=true;}
						else if((table[0][2]==table[2][0])&&(isValidMove(1, 1))){changeTurn();mark(1, 1);marked=true;}
					}else if((table[1][1]!=' ')&&(table[1][1]==turn)&&(table[1][1]==table[2][0])&&(isValidMove(0, 2))){changeTurn();mark(0, 2);marked=true;} //diagonal secundadria
					if(!marked){
						changeTurn();
						midleOrConer();
					}
				}
				break;
			case 4: case 6: case 8:
				for(int i=0;i<3;i++){
					if((table[i][0]!=' ')&&(table[i][0]==turn)){
						if ((table[i][0]==table[i][1])&&(isValidMove(i, 2))){ mark(i,2); marked=true; break;}
						else if ((table[i][0]==table[i][2])&&(isValidMove(i, 1))){ mark(i,1); marked=true; break;}
					}else if((table[i][1]!=' ')&&(table[i][1]==turn)&&(table[i][1]==table[i][2])&&(isValidMove(i, 0))){ mark(i,0); marked=true; break;}//linhas
					if((table[0][i]!=' ')&&(table[0][1]==turn)){
						if ((table[0][i]==table[1][i])&&(isValidMove(2, i))){ mark(2,i); marked=true; break;}
						else if ((table[0][i]==table[2][i])&&(isValidMove(1, i))){ mark(1,i); marked=true; break;}
					}else if((table[1][i]!=' ')&&(table[1][i]==turn)&&(table[1][i]==table[2][i])&&(isValidMove(0, i))){ mark(0,i); marked=true; break;}//colunas
				}

				if(!marked){
					if((table[0][0]!=' ')&&(table[0][0]==turn)){
						if((table[0][0]==table[1][1])&&(isValidMove(2, 2))){mark(2, 2);marked=true;}
						else if((table[0][0]==table[2][2])&&(isValidMove(1, 1))){mark(1, 1);marked=true;}
					}else if((table[1][1]!=' ')&&(table[1][1]==turn)&&(table[1][1]==table[2][2])&&(isValidMove(0, 0))){mark(0, 0);marked=true;} //diagonal principal
					else if((table[0][2]!=' ')&&(table[0][2]==turn)){
						if((table[0][2]==table[1][1])&&(isValidMove(2, 0))){mark(2, 0);marked=true;}
						else if((table[0][2]==table[2][0])&&(isValidMove(1, 1))){mark(1, 1);marked=true;}
					}else if((table[1][1]!=' ')&&(table[1][1]==turn)&&(table[1][1]==table[2][0])&&(isValidMove(0, 2))){mark(0, 2);marked=true;} //diagonal secundadria
					if(!marked){
						midleOrConer();
					}
				}
				break;

			default:
				break;
			}
			break;
		default:
			break;
		}
	}

	private static void midleOrConer() {
		boolean marked = false;
		if((!isValidMove(0,0))&&(table[0][0]==turn))
			if(isValidMove(0,2)){ mark(0, 2); marked=true;}
			else if(isValidMove(2,0)){ mark(2, 0); marked=true;}

		if((!isValidMove(0,2))&&(table[0][2]==turn)&&(!marked))
			if(isValidMove(0,0)){ mark(0, 0); marked=true;}
			else if(isValidMove(2,0)){ mark(2, 0); marked=true;}

		if((!isValidMove(2,0))&&(table[2][0]==turn)&&(!marked))
			if(isValidMove(0,0)){ mark(0, 0); marked=true;}
			else if(isValidMove(2,2)){ mark(2, 2); marked=true;}

		if((!isValidMove(2,2))&&(table[2][2]==turn)&&(!marked))
			if(isValidMove(0,2)){ mark(0, 2); marked=true;}
			else if(isValidMove(2,0)){ mark(2, 0); marked=true;}

		if((!isValidMove(0,0))&&(!marked))
			if(isValidMove(0,1)){ mark(0, 1); marked=true;}
			else if(isValidMove(1,0)){ mark(1, 0); marked=true;}

		if((!isValidMove(0,2))&&(!marked))
			if(isValidMove(0,1)){ mark(0, 1); marked=true;}
			else if(isValidMove(1,2)){ mark(1, 2); marked=true;}

		if((!isValidMove(2,0))&&(!marked))
			if(isValidMove(1,0)){ mark(1, 0); marked=true;}
			else if(isValidMove(2,1)){ mark(2, 1); marked=true;}

		if((!isValidMove(2,2))&&(!marked))
			if(isValidMove(1,2)){ mark(1, 2); marked=true;}
			else if(isValidMove(2,1)){ mark(2, 1); marked=true;}

		if(!marked){
			if(isValidMove(2,0))mark(2, 0);
			else
				if(isValidMove(2,2))mark(2, 2);
				else
					if(isValidMove(0,0))mark(0, 0);
					else 
						if(isValidMove(0,2))mark(0, 2);
		}

		
	}




}

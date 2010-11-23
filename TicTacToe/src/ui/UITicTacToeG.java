package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import persistence.RulesTicTacToe;




public class UITicTacToeG extends JFrame implements ActionListener{
	  	 JButton casas[][]= new JButton[3][3];  
	     ImageIcon o = new ImageIcon("o.png");  
	     ImageIcon x = new ImageIcon("x.png");  
	    
	     UITicTacToeG() {
  
	        setTitle("Jogo da Velha");  
	        setSize(250,120);  
	        setLocation(450,350);
	        setResizable(false);
	        setVisible(true);
	        //getContentPane().setBackground(new Color(0,1,2));
	        getContentPane().setLayout(new FlowLayout());
	       
	        for(int i=0;i<3;i++)
	        	for(int j=0;j<3;j++){
	        		casas[i][j]= new JButton(o);
	        		casas[i][j].setText(Integer.toString(i)+Integer.toString(j));
	        		casas[i][j].setVisible(true);
	        		casas[i][j].setContentAreaFilled(false);
	                casas[i][j].addActionListener(this);
	                getContentPane().add(casas[i][j]);
	                }  
	     }  
	    
	     public void actionPerformed(ActionEvent e)  
	     {  
	    	 //RegrasDoJogoDaVelha.marcou()
//	        aux.setText(b2.getText());  
	//        b2.setText(b1.getText());  
	  //      b1.setText(aux.getText());  
	     }  
	    
	public static void iniciaJogoGP(){
		JFrame tabuleiro = new UITicTacToeG();
		
	}

}

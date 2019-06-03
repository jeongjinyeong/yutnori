package controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import model.*;
import view.*;

public class Controller implements ActionListener{
	
	private model.Board board;
	private MainFrame mainboard;
	private StartPage startpage;
	String[] yutname = {"./img/back_doe.png", "./img/doe.png", "./img/gae.png", "./img/gul.png", "./img/yoot.png", "./img/moe.png"}; 
	
	
	public Controller() {
		mainboard = new MainFrame(this);
		board = new model.Board();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==mainboard.buttonThrowYut) {
			String throwResult = yutname[model.Yut.throwYut()];//³ª´©±â
	//		board.setIndex(throwResult);
			mainboard.lblResultThrowYut.setIcon(new ImageIcon(throwResult));
		}
		
		for(int i=0; i<6; i++) {
			if(e.getSource()==mainboard.throwBtns[i]) {
				String throwResult = yutname[i];
				mainboard.lblResultThrowYut.setIcon(new ImageIcon(throwResult));
			}
		}
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				if(e.getSource()==mainboard.pbtn[i][j]) {
					
				}
			}
		}
//		if(e.getSource()==startpage.startGame) {
//			System.out.println("aaa");
//			new EventThrow();
//		}
	}
}		
		
		
		


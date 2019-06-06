package controller;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import model.*;
import view.*;

public class Controller implements ActionListener{
	
	private model.Board board;
	private model.Game game;
	private MainFrame mainboard;
	private StartPage startpage;
	String[] yutname = {"./img/back_doe.png", "./img/doe.png", "./img/gae.png", "./img/gul.png", "./img/yoot.png", "./img/moe.png"}; 
	

	
	public Controller() {
		startpage = new StartPage(this);
		mainboard = new MainFrame(this);
		game = new Game();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int player_num = 0;
		int horse_num = 0;
		if(e.getSource()==startpage.playerCombo) {
			String temp_player = startpage.playerCombo.getSelectedItem().toString();
			System.out.println(player_num);
			player_num = temp_player.charAt(0) - '0';
			game.setMaxPlayer(player_num);
		}
		if(e.getSource()==startpage.horseCombo) {
			String temp_horse = startpage.horseCombo.getSelectedItem().toString();
			horse_num = temp_horse.charAt(0) - '0';
			game.setMaxHorse(horse_num);
			System.out.println(horse_num);
		}
		if(e.getSource()==startpage.startGame) {
			mainboard.createPlayerSet(player_num, horse_num);
			System.out.println("aaa");
			startpage.setVisible(false);
			startpage.dispose();
			mainboard.setVisible(true);
		}
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
		
	}		
		

	public static void main(String[] args) {
		new Controller();
	}
}	
		


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
	int[] click_cnt;
	int turn;
	
	public Controller() {
		startpage = new StartPage(this);
		mainboard = new MainFrame(this);
		game = new Game();
		turn = 0;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int player_num = 0;
		int horse_num = 0;
		int yut = 0;
		if(e.getSource()==startpage.playerCombo) {
			String temp_player = startpage.playerCombo.getSelectedItem().toString();
			System.out.println(player_num);
			player_num = temp_player.charAt(0) - '0';
			game.setPlayer(player_num);
		}
		
		if(e.getSource()==startpage.horseCombo) {
			String temp_horse = startpage.horseCombo.getSelectedItem().toString();
			horse_num = temp_horse.charAt(0) - '0';
			game.setMaxHorse(horse_num);
		}
		
		if(e.getSource()==startpage.startGame) {
			mainboard.createPlayerSet(player_num, horse_num);
			System.out.println("aaa");
			startpage.setVisible(false);
			startpage.dispose();
			mainboard.setVisible(true);
		}
		
		if(e.getSource()==mainboard.buttonThrowYut) {
			yut = model.Yut.throwYut();
			String throwResult = yutname[yut];//나누기
	//		board.setIndex(throwResult);
			mainboard.lblResultThrowYut.setIcon(new ImageIcon(throwResult));
		}
		
		for(int i=0; i<6; i++) {
			if(e.getSource()==mainboard.throwBtns[i]) {
				yut = i;
				String throwResult = yutname[yut];
				mainboard.lblResultThrowYut.setIcon(new ImageIcon(throwResult));
				
			}
		}
	
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				if(e.getSource() == mainboard.pbtn[i][j]) {
					game.location(turn);
					System.out.println(game.get_location_i().size());
					System.out.println(game.get_location_i().get(0));
					System.out.println(game.get_location_j().get(0));
					for(int k=0; k<game.get_location_i().size(); k++) {
						System.out.println("hi");
						if(i==game.get_location_i().get(k) && j == game.get_location_j().get(k)) {
							game.destination(i, j, yut);
							for(int m=0; m<game.get_destination_i().size(); m++) {
								int x = game.get_destination_i().get(m);
								int y = game.get_destination_j().get(m);
								mainboard.pbtn[x][y].setText("여기로 올수 있음");
							}
						}
						
						if(i==game.get_destination_i().get(k) && j==game.get_destination_j().get(k)) {
							game.move(i, j, turn);
							for (int n=0; n<game.get_location_i().size(); n++) {
								int x = game.get_location_i().get(n);
								int y = game.get_location_j().get(n);
								mainboard.pbtn[x][y].setText("말 여기있음");
								turn = game.turn(turn);
							}
						}
					}
					
					
				}
			}
		
		}		
	}		

	public static void main(String[] args) {
		new Controller();
	}
}	
		


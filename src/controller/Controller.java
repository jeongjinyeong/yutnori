package controller;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import model.*;
import view.*;
import java.util.Arrays;

public class Controller implements ActionListener{
	
	private model.Board board;
	private model.Game game;
	private MainFrame mainboard;
	private StartPage startpage;
	String[] yutname = {"./img/back_doe.png", "./img/doe.png", "./img/gae.png", "./img/gul.png", "./img/yoot.png", "./img/moe.png"}; 
	private int turn;
	private int player_num = 0;
	private int horse_num = 0;
	private int play_game = 0;
	private int selected = 0;
	public Controller() {
		startpage = new StartPage(this);
		game = new Game();
		turn = 0;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int yut = 0;
		if(play_game==0) {
			if(e.getSource()==startpage.playerCombo) {
				String temp_player = startpage.playerCombo.getSelectedItem().toString();
				player_num = temp_player.charAt(0) - '0';
			}
			
			if(e.getSource()==startpage.horseCombo) {
				String temp_horse = startpage.horseCombo.getSelectedItem().toString();
				horse_num = temp_horse.charAt(0) - '0';
			}
			
			if(e.getSource()==startpage.startGame) {
				game.setPlayer(player_num);
				game.setMaxHorse(horse_num);

				mainboard = new MainFrame(this);
				mainboard.createPlayerSet(player_num, horse_num);
				startpage.setVisible(false);
				startpage.dispose();
				mainboard.setVisible(true);
				play_game = 1;
			}
		}	
		else if(play_game == 1) {
			for(int i=0; i<player_num; i++) {
				if(e.getSource()==mainboard.btnPlayerWait[i]) {
					game.move(6, 6, turn);
					show_now_Mals();
				}
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
						show_now_Mals();
						//테스트
						System.out.println(game.get_location_i().size());
						System.out.println(game.get_location_i().get(0));
						System.out.println(game.get_location_j().get(0));
						
						for(int k=0; k<game.get_location_i().size(); k++) {
							System.out.println("hi");
							if(i==game.get_location_i().get(k) && j == game.get_location_j().get(k) && selected%2 == 0) {
								game.destination(i, j, yut);
								show_possible_Mals();
								selected++;
							}
							else if(i==game.get_location_i().get(k) && j == game.get_location_j().get(k) && selected%2 == 1) {
								show_now_Mals();
								selected++;
							}
							for(int m=0; m<game.get_destination_i().size(); m++) {
								if(i==game.get_destination_i().get(m) && j==game.get_destination_j().get(m) && selected%2 == 1) {
									game.move(i, j, turn);
									selected= 0;
									show_now_Mals();
									turn = game.turn(turn);
								}
							}	
						}
					}
				}
			}		
		}		
	}
	public void show_possible_Mals() {
		for(int m=0; m<game.get_destination_i().size(); m++) {
			int x = game.get_destination_i().get(m);
			int y = game.get_destination_j().get(m);
			mainboard.pbtn[x][y].setText("여기로 올수 있음");
		}
	}
		

	public void show_now_Mals() {
		for(int i=0; i<player_num; i++) {
			game.location(i);
			for(int j=0; j<game.get_location_i().size(); j++) {
				int x = game.get_location_i().get(j);
				int y = game.get_location_j().get(j);
				mainboard.pbtn[x][y].setText("말 여기있음");
			}
		}
	}

	public static void main(String[] args) {
		new Controller();
	}
}	
		


package controller;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import model.*;
import view.*;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class Controller implements ActionListener{
	
	private model.Game game;
	private MainFrame mainboard;
	private StartPage startpage;
	private ResultPage resultpage;
	String[] yut_name = {"ï¿½ï¿½ï¿½ï¿½", "ï¿½ï¿½", "ï¿½ï¿½", "ï¿½ï¿½", "ï¿½ï¿½", "ï¿½ï¿½"};
	String yut_string = "";
	String[] yut_img_name = {"./img/back_doe.png", "./img/doe.png", "./img/gae.png", "./img/gul.png", "./img/yoot.png", "./img/moe.png"}; 
	private int turn;
	private int player_num = 2;
	private int horse_num = 2;
	private int play_game = 0;
	private int selected = 0;
	private int game_winner = 0;
	private int temp_idx_i = 0;
	private int temp_idx_j = 0;
	
	LineBorder red = new LineBorder(Color.RED,3);
	public Controller() {
		startpage = new StartPage(this);
		game = new Game();
		turn = 0;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Integer> yut = new ArrayList();
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

					game.move(turn, null, 6, 6);
					show_now_Mals();
				}
			}
			
			if(e.getSource()==mainboard.ramdomThrowYutBtn) {
				yut.add(model.Yut.throwYut());
				for(int i=0; i<yut.size(); i++) {
				
					String throwResult = yut_img_name[yut.get(i)];//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
			//		board.setIndex(throwResult);
					mainboard.resultYutImageLbl.setIcon(new ImageIcon(throwResult));
					yut_string = yut_string + yut_name[yut.get(i)];
				}
				mainboard.resultYutTextLbl.setText(yut_string);
			}
			for(int i=0; i<6; i++) {
				if(e.getSource()==mainboard.testThrowYutBtns[i]) {
					yut.add(i);
					for(int j=0; j<yut.size(); j++) {
						String throwResult = yut_img_name[yut.get(j)];
						mainboard.resultYutImageLbl.setIcon(new ImageIcon(throwResult));
						yut_string = yut_string + yut_name[i];
					}
					mainboard.resultYutTextLbl.setText(yut_string);
				}
			}
		
			for(int i=0; i<7; i++) {
				for(int j=0; j<7; j++) {
					if(e.getSource() == mainboard.pbtn[i][j]) {
						game.location(turn);
						show_now_Mals();
						//ï¿½×½ï¿½Æ®
						System.out.println(game.get_location_i().size());
						System.out.println(game.get_location_i().get(0));
						System.out.println(game.get_location_j().get(0));
						
						for(int k=0; k<game.get_location_i().size(); k++) {
							System.out.println("hi");
							if(i==game.get_location_i().get(k) && j == game.get_location_j().get(k) && selected%2 == 0) {
								show_now_Mals();
								game.destination(i, j, yut);
								temp_idx_i = i;
								temp_idx_j = j;
								show_possible_Mals();
								selected++;
							}
							else if(selected %2 == 1) {
								for(int m=0; m<game.get_destination_i().size(); m++) {
									if(i==game.get_destination_i().get(m) && j==game.get_destination_j().get(m) && selected%2 == 1) {
										
										game.move(turn, game.getHorseSet(temp_idx_i, temp_idx_j), i, j);
										selected= 0;
										show_now_Mals();
										turn = game.turn(turn);
										yut_string = "";
										break;
									}
								}
							}
							else if(i==game.get_location_i().get(k) && j == game.get_location_j().get(k) && selected%2 == 1) {
								
								show_now_Mals();
								game.destination(i, j, yut);
								temp_idx_i = i;
								temp_idx_j = j;
								show_possible_Mals();
								selected = 1;
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
			mainboard.pbtn[x][y].setBorder(red);
		}
	}
		

	public void show_now_Mals() {
		for(int i=0; i<player_num; i++) {
			game.location(i);
			for(int j=0; j<game.get_location_i().size(); j++) {
				int x = game.get_location_i().get(j);
				int y = game.get_location_j().get(j);
				mainboard.pbtn[x][y].setText("¤¾¤·");
				mainboard.pbtn[x][y].setBorder(UIManager.getBorder("Button.border"));
			}
		}
	}
	
//	public void end_game(int turn) {
//		if(game.get_game_status() == 1) {
//			game_winner = turn;
//			mainboard.setVisible(false);
//			mainboard.dispose();
//			play_game = 2;
//			resultpage = new ResultPage(this, turn);
//			
//		}
//	}

	public static void main(String[] args) {
		new Controller();
	}
}	
		

 

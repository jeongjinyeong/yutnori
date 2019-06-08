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
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Controller implements ActionListener {

	private model.Game game;
	private MainPage mainpage;
	private StartPage startpage;
	private ResultPage resultpage;

	String[] yut_name = { "빽도", "도", "개", "걸", "윷", "모" };
	String[] yut_img_name = { "./img/back_doe.png", "./img/doe.png", "./img/gae.png", "./img/gul.png", "./img/yoot.png",
			"./img/moe.png" };
	LineBorder red = new LineBorder(Color.RED, 3);
	LineBorder yellow = new LineBorder(Color.YELLOW, 3);
	EmptyBorder blank = new EmptyBorder(5, 3, 5, 3);

	private String yut_string;
	private int turn;
	private boolean init_throw;
	private boolean selected;
	private int player_num;
	private int horse_num;
	private int play_game;
	private int game_winner;
	private int temp_idx_i;
	private int temp_idx_j;
	private int throw_chance;
	private int[] end_mal;
	private HorseSet[][] horseBoard;
	private ArrayList<Integer> yut;

	public Controller() {
		yut_string = "";
		game_winner = 0;
		selected = false;
		play_game = 0;
		player_num = 2;
		horse_num = 2;
		throw_chance = 1;
		temp_idx_i = 0;
		temp_idx_j = 0;
		yut = new ArrayList<Integer>();
		init_throw = false;
		startpage = new StartPage(this);
		game = new Game();
		end_mal = new int[2];
		turn = 0;
		horseBoard = new HorseSet[7][7];
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// StartPage
		if (play_game == 0) {
			if (e.getSource() == startpage.playerCombo) {
				String temp_player = startpage.playerCombo.getSelectedItem().toString();
				player_num = temp_player.charAt(0) - '0';
			}

			if (e.getSource() == startpage.horseCombo) {
				String temp_horse = startpage.horseCombo.getSelectedItem().toString();
				horse_num = temp_horse.charAt(0) - '0';
			}

			if (e.getSource() == startpage.startGame) {
				game.setPlayer(player_num, horse_num);
				game.setMaxPlayer(player_num);
				game.setMaxHorse(horse_num);

				end_mal = new int[player_num];
				mainpage = new MainPage(this);
				mainpage.createPlayerSet(player_num, horse_num);
				startpage.setVisible(false);
				startpage.dispose();
				mainpage.setVisible(true);
				play_game = 1;
				mainpage.nowTurnlbl.setText(Integer.toString(turn));
			}
		}

		// mainpage
		else if (play_game == 1) {

			// ���� �� ������ ��ư
			if (e.getSource() == mainpage.ramdomThrowYutBtn && throw_chance > 0) {
				throw_chance--;
				init_throw = true;
				int yut_result = model.Yut.throwYut();
				yut.add(yut_result);

				if (yut_result == 4 || yut_result == 5) {
					throw_chance++;
				}

				show_yut();
				String throwResult = yut_img_name[yut.get(yut.size() - 1)];
				mainpage.resultYutImageLbl.setIcon(new ImageIcon(throwResult));
			}


			for (int i = 0; i < 6; i++) {
				if (e.getSource() == mainpage.testThrowYutBtns[i] && throw_chance > 0) {
					throw_chance--;
					init_throw = true;

					yut.add(i);

					if (i == 4 || i == 5) {
						throw_chance++;
					}

					show_yut();
					String throwResult = yut_img_name[yut.get(yut.size() - 1)];
					mainpage.resultYutImageLbl.setIcon(new ImageIcon(throwResult));
					break;
				}
			}


			for (int i = 0; i < player_num; i++) {
				if (e.getSource() == mainpage.btnPlayerWait[turn] && yut.size() > 0 && init_throw == true
						&& game.getRemainHorse(turn) > 0 && selected == false) {
					// HorseSet horseset = new HorseSet(turn, new Horse(turn));
					if(game.destination(-1, -1, yut) == 0) {
						yut.clear();
						throw_chance = 1;
						break;
					}
					show_possible_Mals();
					selected = true;
				}
			}


			OUT: for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if (e.getSource() == mainpage.pbtn[i][j] && init_throw == true) {


						if (selected == false && yut.size() > 0) {

							for (int k = 0; k < game.get_location_i().size(); k++) {

								if (i == game.get_location_i().get(k) && j == game.get_location_j().get(k)) {

									selected = true;
									show_now_Mals();
									game.destination(i, j, yut);
									temp_idx_i = i;
									temp_idx_j = j;
									show_possible_Mals();
									break OUT;
								}
							}
						}
						else if(selected == false && yut.size()<1) {
							show_player_horses();
						}

						if (selected == true) {

							for (int m = 0; m < game.get_destination_i().size(); m++) {

								if (i == game.get_destination_i().get(m) && j == game.get_destination_j().get(m)) {
									int used_yut = game.get_yut().get(m);
									yut.remove(new Integer(used_yut));
									show_yut();
									selected = false;

									if (game.move(turn, game.getHorseSet(temp_idx_i, temp_idx_j), i, j) == 1) {
										throw_chance++;
									}

									game.location(turn);
									game.destination(i, j, yut);

									for (int c = 0; c < player_num; c++) {
										mainpage.btnPlayerWait[c].setIcon(
												new ImageIcon("./img/" + c + "_" + game.getRemainHorse(c) + ".png"));

									}
									show_now_Mals();

									if (check_turn()) {
										this.turn = game.turn(turn);
										turn_change();
									} else {
										show_player_horses();
									}
									break OUT;
								}
							}

							selected = false;
							show_now_Mals();
							break OUT;
						}
					}

				}
			}
			
			

			if (e.getSource() == mainpage.finishBtn) {
				for (int m = 0; m < game.get_destination_i().size(); m++) {
					if (7 == game.get_destination_i().get(m) && 7 == game.get_destination_j().get(m)) {
						if (game.getHorseSet(temp_idx_i, temp_idx_j) != null) {

							int used_yut = game.get_yut().get(m);
							yut.remove(new Integer(used_yut));
							show_yut();
							end_mal[turn] += game.getHorseSet(temp_idx_i, temp_idx_j).getHorses().size();
							game.move(turn, game.getHorseSet(temp_idx_i, temp_idx_j), 7, 7);
							selected = false;
							check_game(end_mal[turn], turn);
							game.location(turn);
							mainpage.lblplayerFin[turn]
									.setIcon(new ImageIcon("./img/" + turn + "_" + end_mal[turn] + ".png"));
							show_now_Mals();
							mainpage.finishBtn.setBorder(blank);

							if (check_turn()) {
								this.turn = game.turn(turn);
								turn_change();
								break;
							}

						}
					}
				}
			}

		}

		else if (play_game == 2) {
			if (e.getSource() == resultpage.restart) {
				resultpage.setVisible(false);
				resultpage.dispose();
				new Controller();
			}
			if (e.getSource() == resultpage.close) {
				System.exit(0);
			}
		}
	}


	public void show_yut() {
		yut_string = "";
		for (int i = 0; i < yut.size(); i++) {
			if (yut.size() > 0) {
				yut_string = yut_string + yut_name[yut.get(i)];
			}
		}
		mainpage.resultYutTextLbl.setText(yut_string);
	}


	public void turn_change() {
		game.location(turn);
		show_now_Mals();
		show_player_horses();
		mainpage.nowTurnlbl.setText(Integer.toString(turn));
		show_yut();
		init_throw = false;
		throw_chance = 1;
		yut_string = "";
		selected = false;
		yut = new ArrayList<Integer>();
		temp_idx_i = 0;
		temp_idx_j = 0;
		mainpage.resultYutImageLbl.setIcon(null);
	}


	public boolean check_turn() {
		if (throw_chance < 1 && yut.size() < 1) {
			return true;
		} else
			return false;
	}


	public void check_game(int check_mal, int turn) {
		if (check_mal == horse_num) {
			end_game(turn);
		}
	}


	public void end_game(int turn) {
		game_winner = turn;
		mainpage.setVisible(false);
		mainpage.dispose();
		play_game = 2;
		resultpage = new ResultPage(this, turn);

	}

	// ���� ���� �÷��̾��� ���� ��ġ �˷���
	public void show_player_horses() {
		for (int m = 0; m < game.get_location_i().size(); m++) {
			int x = game.get_location_i().get(m);
			int y = game.get_location_j().get(m);
			mainpage.pbtn[x][y].setBorder(yellow);
		}
	}


	public void show_possible_Mals() {
		for (int m = 0; m < game.get_destination_i().size(); m++) {
			int x = game.get_destination_i().get(m);
			int y = game.get_destination_j().get(m);
			if (x < 7 && y < 7) {
				mainpage.pbtn[x][y].setBorder(red);
			}
			if (x == 7 && y == 7) {
				mainpage.finishBtn.setBorder(red);
			}
		}
	}


	public void show_now_Mals() {
		horseBoard = game.getBoard();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				mainpage.pbtn[i][j].setBorder(blank);
				if (horseBoard[i][j] != null) {
					int x = horseBoard[i][j].get_i();
					int y = horseBoard[i][j].get_j();
					int player_num = horseBoard[i][j].getPlayer();
					int horse_num = horseBoard[i][j].getHorses().size();
					mainpage.pbtn[i][j].setIcon(new ImageIcon("./img/" + player_num + "_" + horse_num + ".png"));
				}

				else {
					mainpage.pbtn[i][j].setIcon(null);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Controller();
	}
}

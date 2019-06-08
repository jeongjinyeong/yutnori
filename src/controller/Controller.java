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
import javax.swing.UIManager;

public class Controller implements ActionListener{
   
   private model.Game game;
   private MainFrame mainboard;
   private StartPage startpage;

   private ResultPage resultpage;
   String[] yut_name = {"О©╫О©╫О©╫О©╫", "О©╫О©╫", "О©╫О©╫", "О©╫О©╫", "О©╫О©╫", "О©╫О©╫"};
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
   private HorseSet[][] horseBoard;
   ArrayList<Integer> yut = new ArrayList<Integer>();
   private int throw_chance = 1;
   private int move_chance = 1;
   private int init_throw_cnt = 1;
   
   LineBorder red = new LineBorder(Color.RED,3);
   EmptyBorder blank = new EmptyBorder(5, 3, 5, 3);
   
   public Controller() {
      startpage = new StartPage(this);
      game = new Game();
      turn = 0;
      horseBoard = new HorseSet[7][7];
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
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
            game.setMaxPlayer(player_num);
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
            if(e.getSource()==mainboard.btnPlayerWait[i] && move_chance != 0) {
               //HorseSet horseset = new HorseSet(turn, new Horse(turn));
               game.destination(-1, -1, yut);
               show_possible_Mals();
            }
         }
         
         
         
         if(e.getSource()==mainboard.ramdomThrowYutBtn && throw_chance > 0) {
            int yut_result = model.Yut.throwYut();
            move_chance++;
            yut.add(yut_result);
            
            if(yut_result == 4 || yut_result == 5) {
               throw_chance ++;
            }
            else {
               throw_chance --;
            }
            
            for(int i=0; i<yut.size(); i++) {
            
               String throwResult = yut_img_name[yut.get(i)];//О©╫О©╫О©╫О©╫О©╫О©╫
               mainboard.resultYutImageLbl.setIcon(new ImageIcon(throwResult));
               yut_string = yut_string + ' ' +  yut_name[yut.get(i)];
            }
            mainboard.resultYutTextLbl.setText(yut_string);
         }
         
         
         
         for(int i=0; i<6; i++) {
            if(e.getSource()==mainboard.testThrowYutBtns[i] && throw_chance > 0) {
               move_chance++;
               yut.add(i);
               if(i == 4 || i == 5) {
                  throw_chance ++;
               }
               else {
                  throw_chance --;
               }
               
               for(int j=0; j<yut.size(); j++) {
                  String throwResult = yut_img_name[yut.get(j)];
                  mainboard.resultYutImageLbl.setIcon(new ImageIcon(throwResult));
                  yut_string = yut_string + ' ' + yut_name[i];
               }
               mainboard.resultYutTextLbl.setText(yut_string);
            }
         }
         
         OUT:
         for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
               if(e.getSource() == mainboard.pbtn[i][j]) {
                  game.location(turn);
                  show_now_Mals();

                  
                  for(int k=0; k<game.get_location_i().size(); k++) {
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
                           if(i==game.get_destination_i().get(m) && j==game.get_destination_j().get(m) && selected%2 == 1){
                              move_chance--;
                              if(game.move(turn, game.getHorseSet(temp_idx_i, temp_idx_j), i, j)==1) {
                                 throw_chance++;
                                 move_chance++;
                              }
                              
                              //ео Ёя╠Х
                              if(throw_chance < 1 && move_chance < 1) {
                                 selected= 0;
                                 show_now_Mals();
                                 throw_chance = 1;
                                 turn = game.turn(turn);
                                 yut_string = "";
                                 break OUT;
                              }
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
      horseBoard = game.getBoard();
      for(int i=0; i<7; i++) {
         for(int j=0; j<7; j++) {
            mainboard.pbtn[i][j].setBorder(blank);
            if(horseBoard[i][j] != null) {
               int x = horseBoard[i][j].get_i();
               int y = horseBoard[i][j].get_j();
               int player_num = horseBoard[i][j].getPlayer();
               int horse_num = horseBoard[i][j].getHorses().size();
               mainboard.pbtn[i][j].setIcon(new ImageIcon("./img/"+player_num+"_"+horse_num+".png"));
            }
            
            else {
               mainboard.pbtn[i][j].setIcon(null);
            }
         }
      }
   }
   
//   public void end_game(int turn) {
//      if(game.get_game_status() == 1) {
//         game_winner = turn;
//         mainboard.setVisible(false);
//         mainboard.dispose();
//         play_game = 2;
//         resultpage = new ResultPage(this, turn);
//         
//      }
//   }

   public static void main(String[] args) {
      new Controller();
   }
}   
      

 
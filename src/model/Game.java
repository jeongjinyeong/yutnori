package model;

import java.util.ArrayList;

public class Game {
   private int maxPlayer;
   private int maxHorse;
   private ArrayList<Player> player = new ArrayList<Player>();
   
   private Player tempPlayer;
//   private int[] yut = new int[6];
   
   private HorseSet[][] board = new HorseSet[7][7];
   private HorseSet horseSet;
   
   private ArrayList<Integer> location_i = new ArrayList<Integer>();
   private ArrayList<Integer> location_j = new ArrayList<Integer>();
   private ArrayList<Integer> destination_i = new ArrayList<Integer>();
   private ArrayList<Integer> destination_j = new ArrayList<Integer>();
   
   public Game() {}

   public void setPlayer(int maxPlayer) {
      for(int p=0; p<maxPlayer; p++) {
         player.add(new Player(p));
      }
   }

   public void setMaxHorse(int maxHorse) {
      this.maxHorse = maxHorse;
   }
   
   public void setMaxPlayer(int maxPlayer) {
	   this.maxPlayer = maxPlayer;
   }
   
   public int turn(int player) {
      return (player++)%maxPlayer;
   }
   
   public void location(int player) {
      //player의 horseSets를 탐색해서 각 horseSet의 인덱스 값을 저장.
      location_i.clear();
      location_j.clear();
      for(int i=0; i<this.player.get(player).getHorseSets().size(); i++) {
         location_i.add(this.player.get(player).getHorseSets().get(i).get_i());
         location_j.add(this.player.get(player).getHorseSets().get(i).get_j());
      }
   }

   public void destination(int index_i, int index_j, ArrayList<Integer> yut) {
      //location으로 얻은 horseSet들의 index값 중에 하나를 선택해 move의 매개변수로 전달
      //매개변수로 들어온 index값에 대해 이동 가능 지점 반환
      destination_i.clear();
      destination_j.clear();
      for(int y=0; y<yut.size(); y++) {
    	  if(yut.get(y)!=0) {
			  if(index_i == -1) {
				  index_i = 6;
				  index_j = 6;
				  for(int i=0; i<yut.get(y); i++) {
				        if(index_i>0) {
				           if(index_i==4)
				              index_i--;
				           index_i--;
				        }
				        else {
				           if(index_j==4)
				              index_j--;
				           index_j--;
				        }
				  }
		      }
			  else if(index_j == 6 && index_i > 0) {
			     for(int i=0; i<yut.get(y); i++) {
			        if(index_i>0) {
			           if(index_i==4)
			              index_i--;
			           index_i--;
			        }
			        else {
			           if(index_j==4)
			              index_j--;
			           index_j--;
			        }
			     }
			  }
			  else if((index_i == 0 && index_j == 6) || (index_i == 1 && index_j == 5) || (index_i == 2 && index_j == 4) || (index_i == 4 && index_j == 2) || (index_i == 5 && index_j == 1)) {
			     for(int i=0; i<yut.get(y); i++) {
			        if(index_i<6) {
			           index_i++;
			           index_j--;
			        }
			        else {
			           if(index_j==2) {
			              index_j++;
			           }
			           index_j++;
			        }
			     }
			  }
			  else if(index_i == 0 && index_j > 0) {
			     for(int i=0; i<yut.get(y); i++) {
			        if(index_j>0) {
			           if(index_j==4)
			              index_j--;
			           index_j--;
			        }
			        else {
			           if(index_i==2)
			              index_i++;
			           index_i++;
			        }
			     }
			  }
			  else if((index_i == 0 && index_j == 0) || (index_i == 1 && index_j == 1) || (index_i == 2 && index_j == 2) || (index_i == 3 && index_j == 3) || (index_i == 4 && index_j == 4) || (index_i == 5 && index_j == 5)) {
			     for(int i=0; i<yut.get(y); i++) {
			        index_i++;
			        index_j++;
			     }
			  }
			  else if(index_j == 0 && index_i < 6) {
			     for(int i=0; i<yut.get(y); i++) {
			        if(index_i<6) {
			           if(index_i==2)
			              index_i++;
			           index_i++;
			        }
			        else {
			           if(index_j==2)
			              index_j++;
			           index_j++;
			        }
			     }
			  }
			  else {
			     for(int i=0; i<yut.get(y); i++) {
			        if(index_j==2)
			           index_j++;
			        index_j++;
			     }
			  }
    	  }
    	  else {
    		  //빽도 처리
    	  }
          destination_i.add(index_i);
          destination_j.add(index_j);
      }
   }
   
   
   public int move(int player, HorseSet horseSet, int destination_i, int destination_j) { //horseSet은 움직일 말을 매개변수로 전달, destination은 이동할 지점의 index
       int chance = 0;
	   if(horseSet == null) {
         horseSet = new HorseSet(player);
         horseSet.putHorse(new Horse(player));
         this.player.get(player).getHorseSets().add(horseSet);
      }
      
      tempPlayer = this.player.get(horseSet.getPlayer()); //매개변수 horseSet의 player == 현재 턴의 플레이어
      this.horseSet = board[destination_i][destination_j]; //이동할 지점 저장
      if(this.horseSet == null) {
         this.horseSet = new HorseSet(player);
         this.horseSet.setIndex(destination_i,  destination_j);
      }
      
	  //상대방 말이 있는 경우 상대 player의 horseSets를 업데이트해줘야 한다.
      if(this.horseSet.getPlayer()!=horseSet.getPlayer()) {
    	  this.player.get(this.horseSet.getPlayer()).getHorseSets().remove(this.horseSet);
    	  chance++;
      }
      
      //board상에서 destination으로 horseSet 복사
      this.horseSet.newHorse(horseSet);
      board[destination_i][destination_j] = this.horseSet;
      
      //board상에서 기존 위치의 horseSet 제거
      if(horseSet.get_i()!=-1)
    	  board[horseSet.get_i()][horseSet.get_j()] = null;
      
      //player의 horseSets 업데이트(horseSet 이동)
      tempPlayer.getHorseSets().remove(horseSet);
      tempPlayer.getHorseSets().add(this.horseSet);
      
      return chance;
      
      //tempPlayer.getHorseSets().set(tempPlayer.getHorseSets().indexOf(horseSet), this.horseSet);
//      //플레이어의 horseSets배열에서 현재 매개변수로 들어온 horseSet의 값 변경
//      for(int i=0; i<tempPlayer.getHorseSets().size(); i++) {
//         if(tempPlayer.getHorseSets().get(i)!=horseSet)
//            //index가 같은 horseSet이 존재한다면 하나로 합쳐준다.0
//            if(tempPlayer.getHorseSets().get(i).get_i()==horseSet.get_i()&&tempPlayer.getHorseSets().get(i).get_j()==horseSet.get_j()) {
//               tempPlayer.getHorseSets().get(i).newHorse(horseSet);
//            }
//      }
      
      //현재 턴의 player의 horseSets배열 업데이트
//      tempPlayer.getHorseSets().set(tempPlayer.getHorseSets().indexOf(horseSet), this.horseSet);
//      for(int i=0; i<tempPlayer.getHorseSets().size(); i++) {
//         for(int j=0; j<tempPlayer.getHorseSets().size(); j++) {
//            if(tempPlayer.getHorseSets().get(i).get_i()==tempPlayer.getHorseSets().get(j).get_i()&&tempPlayer.getHorseSets().get(i).get_j()==tempPlayer.getHorseSets().get(j).get_j()) {
//               tempPlayer.getHorseSets().get(i).newHorse(tempPlayer.getHorseSets().get(j));
//               tempPlayer.getHorseSets().remove(tempPlayer.getHorseSets().get(j));
//            }
//         }
//      }
      
      //상대방 말이 destination에 있는 경우 해당 player의 horseSets배열 업데이트
      
      //board 상에서 기존 위치에 남아 있는 말 제거
//      this.player.get(horseSet.getPlayer()).getHorseSets().remove(horseSet);
      //말이 새로 출발하는 경우 현재 턴의 player의 horseNum을 하나 줄여줘야 한다.
   }
   
   public HorseSet[][] getBoard(){
	   return board;
   }
   
   public HorseSet getHorseSet(int index_i, int index_j) {
      return board[index_i][index_j];
   }
   
   public ArrayList<Integer> get_location_i(){
      return location_i;
   }
   
   public ArrayList<Integer> get_location_j(){
      return location_j;
   }
   
   public ArrayList<Integer> get_destination_i(){
      return destination_i;
   }
   
   public ArrayList<Integer> get_destination_j(){
      return destination_j;
   }
}
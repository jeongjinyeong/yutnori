//package model;
//
//
//public class Board {
////	private ArrayList<FootHold> board ;
//	private FootHold[][] board;
//	
//	public Board() {
//		board = new FootHold[7][7];
//	}
//	
//	public void initBoard() {
//		board[0][0] = new FootHold();
//		board[0][1] = new FootHold(board[0][0]);
//		board[0][2] = new FootHold(board[0][1]);
//		board[0][4] = new FootHold(board[0][2]);
//		board[0][5] = new FootHold(board[0][4]);
//		board[0][6] = new FootHold(board[0][5]);
//		
//		for(int j=0; j<board[0].length; j++) {
//			if(j==0) {
//				board[0][j] = new FootHold();
//			}
//			else {
//				if(j!=3) {
//					if(j==4) {
//						board[0][j] = new FootHold(board[0][j-2]);
//					}
//					else {
//						board[0][j] = new FootHold(board[0][j-1]);
//					}				
//				}
//			}
//		}
//		for(int i=1; i<board.length; i++) {
//			if(i!=3) {
//				if(i==4) {
//					board[i][6] = new FootHold(board[i-2][6]);
//				}
//				else {
//					board[i][6] = new FootHold(board[i-1][6]);
//				}
//			}
//		}
//		for(int j=board[6].length-1; j>0; j--) {
//			if(j!=4) {
//				if(j==3) {
//					board[6][j-1] = new FootHold(board[6][j+1]);
//				}
//				else {
//					board[6][j-1] = new FootHold(board[6][j]);
//				}				
//			}
//		}
//		for(int i=board.length-1; i>1; i--) {
//			if(i!=4) {
//				if(i==3) {
//					board[i-1][0] = new FootHold(board[i+1][0]);
//				}
//				else {
//					board[i-1][0] = new FootHold(board[i][0]);
//				}
//			}
//		}
//		board[1][0].setNextFootHold(board[0][0]);
//		
//		for(int i=board.length-1; i>2; i--) {
//			board[i-1][i-1] = new FootHold(board[i][i]);
//		}
//		board[1][1].setNextFootHold(board[0][0]);
//		
//		for(int j=1, i = board.length-1; j<board.length-1; j++) {
//			if(i-j!=3) {
//				board[i-j][j] = new FootHold(board[i-(j-1)][j-1]);					
//			}
//		}
//		board[2][4].setNextFootHold(board[3][3]);
//	}
//
////	public static void main(String[] args) {
////		Board board = new Board();
////		board.initBoard();
////		for(int i=0; i<board.board.length; i++) {
////			for(int j=0; j<board.board.length; j++) {
////				System.out.print(board.board[i][j]);
////			}
////			System.out.print('\n');
////		}
////	}
//}
//

package model;

import java.util.ArrayList;

public class Game {
//	private ArrayList<FootHold> board ;
	private int maxPlayer;
	private int maxHorse;
	private ArrayList<Player> player = new ArrayList<Player>();
//	private int[] yut = new int[6];
	
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
	
	public int turn(int player) {
		return (player++)%maxPlayer;
	}
	
	public void location(Player player) {
		//player의 horseSets를 탐색해서 각 horseSet의 인덱스 값을 저장.
		location_i.clear();
		location_j.clear();
		for(int i=0; i<player.getHorseSets().size(); i++) {
			location_i.add(player.getHorseSets().get(i).get_i());
			location_j.add(player.getHorseSets().get(i).get_j());
		}
	}

	public void destination(int index_i, int index_j, ArrayList<Integer> yut) {
		//location으로 얻은 horseSet들의 index값 중에 하나를 선택해 move의 매개변수로 전달
		//매개변수로 들어온 index값에 대해 이동 가능 지점 반환
		destination_i.clear();
		destination_j.clear();
		for(int y=0; y<yut.size(); y++) {
			if(index_j == 6 && index_i > 0) {
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
			else if(index_i == 0 && index_j == 6) {
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
			else if(index_i == 0 && index_j == 0) {
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
			else
				for(int i=0; i<yut.get(y); i++) {
					if(index_j==2)
						index_j++;
					index_j++;
				}
			destination_i.add(index_i);
			destination_j.add(index_j);
		}
	}
	
	public void move(int index_i, int index_j, int player) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j].get_i()==index_i && board[i][j].get_j()==index_j) {
					horseSet = board[i][j];
					if(this.player.get(player).getPlayer()==horseSet.getPlayer()) {
						
					}
					else {
						
					}
						
				}
				else {
					this.player.get(player).getHorseSets().
				}
			}
		}
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

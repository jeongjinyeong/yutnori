package model;


public class Board {
//	private ArrayList<FootHold> board ;
	public FootHold[][] board;
	
	public Board() {
		board = new FootHold[7][7];
	}
	
	public void initBoard() {
		System.out.println("Hei");
		board[0][0] = new FootHold();
		board[0][1] = new FootHold(board[0][0]);
		board[0][2] = new FootHold(board[0][1]);
		board[0][4] = new FootHold(board[0][2]);
		board[0][5] = new FootHold(board[0][4]);
		board[0][6] = new FootHold(board[0][5]);
		
		for(int j=0; j<board[0].length; j++) {
			if(j==0) {
				board[0][j] = new FootHold();
			}
			else {
				if(j!=3) {
					if(j==4) {
						board[0][j] = new FootHold(board[0][j-2]);
					}
					else {
						board[0][j] = new FootHold(board[0][j-1]);
					}				
				}
			}
		}
		for(int i=1; i<board.length; i++) {
			if(i!=3) {
				if(i==4) {
					board[i][6] = new FootHold(board[i-2][6]);
				}
				else {
					board[i][6] = new FootHold(board[i-1][6]);
				}
			}
		}
		for(int j=board[6].length-1; j>0; j--) {
			if(j!=4) {
				if(j==3) {
					board[6][j-1] = new FootHold(board[6][j+1]);
				}
				else {
					board[6][j-1] = new FootHold(board[6][j]);
				}				
			}
		}
		for(int i=board.length-1; i>1; i--) {
			if(i!=4) {
				if(i==3) {
					board[i-1][0] = new FootHold(board[i+1][0]);
				}
				else {
					board[i-1][0] = new FootHold(board[i][0]);
				}
			}
		}
		board[1][0].setNextFootHold(board[0][0]);
		
		for(int i=board.length-1; i>2; i--) {
			board[i-1][i-1] = new FootHold(board[i][i]);
		}
		//board[1][1].setNextFootHold(board[0][0]);
		
		for(int j=1, i = board.length-1; j<board.length-1; j++) {
			if(i-j!=3) {
				board[i-j][j] = new FootHold(board[i-(j-1)][j-1]);					
			}
		}
		board[2][4].setNextFootHold(board[3][3]);
	}

//	public static void main(String[] args) {
//		Board board = new Board();
//		board.initBoard();
//		for(int i=0; i<board.board.length; i++) {
//			for(int j=0; j<board.board.length; j++) {
//				System.out.print(board.board[i][j]);
//			}
//			System.out.print('\n');
//		}
//	}
}


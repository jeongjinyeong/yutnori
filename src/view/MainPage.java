package view;
import controller.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	public JPanel mainPage;
	public JButton ramdomThrowYutBtn; //랜덤윷던지기 버튼
	public JButton[] testThrowYutBtns; //도개결윷모 던지기 버튼 배열
	public JLabel resultYutImageLbl; //결과 이미지
	public JLabel resultYutTextLbl; //결과 이미지
	public JButton[][] pbtn; //보드 버튼 배열
	public JPanel[] players; //플레이어 시작버튼
	public JButton[] btnPlayerWait;
	public JButton finishBtn;
	public JLabel[] lblplayerFin;
	public JLabel nowTurnlbl;
	private Controller control; 
	/**
	 * Create the frame.
	 */

	public MainPage(Controller controller) {
		
		control = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1070, 750);
		mainPage = new JPanel();
		mainPage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPage);
		mainPage.setLayout(null);
		
		JPanel panelBoard = createBoard();
		panelBoard.setBounds(204, 73, 619, 580);
		mainPage.add(panelBoard);

		JPanel panelThrowBtnSet = createThrowSet();
		panelThrowBtnSet.setBounds(837, 255, 200, 187);
		mainPage.add(panelThrowBtnSet);
										
		JLabel lblHeadLine = new JLabel("윷놀이");
		lblHeadLine.setFont(new Font("굴림", Font.BOLD, 21));
		lblHeadLine.setBounds(15, 12, 100, 54);
		mainPage.add(lblHeadLine);
					
		JLabel lblTurnText = new JLabel("현재 턴 ");
		lblTurnText.setFont(new Font("굴림", Font.BOLD, 21));
		lblTurnText.setBounds(200, 12, 100, 64);
		mainPage.add(lblTurnText);
		
		nowTurnlbl = new JLabel("");
		nowTurnlbl.setFont(new Font("굴림", Font.BOLD, 21));
		nowTurnlbl.setBounds(280, 12, 100, 64);
		mainPage.add(nowTurnlbl);
		
		resultYutImageLbl = new JLabel();
		resultYutImageLbl.setBounds(837, 73, 200, 173);
		mainPage.add(resultYutImageLbl);
		
		JLabel yutResult = new JLabel("윷 결과 : ");
		yutResult.setBounds(837, 400, 200, 173);
		mainPage.add(yutResult);
		
	    resultYutTextLbl = new JLabel("");
	    resultYutTextLbl.setBounds(890, 400, 150, 173);
	    mainPage.add(resultYutTextLbl);

	    finishBtn = new JButton();
	    finishBtn.setBounds(825, 565, 80, 80); 
	    mainPage.add(finishBtn);
	    finishBtn.addActionListener(control);
	    finishBtn.setContentAreaFilled(false);
	}

	public JPanel createBoard() {
		
		JPanel panelBoard = new JPanel();
		panelBoard.setLayout(null);
		pbtn = new JButton[7][7];
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				int offset = 0;
				int x = 0, y =0 ;
				pbtn[i][j] = new JButton();
				if( i == 6 && j ==6) { //start 버튼
					pbtn[i][j].setBounds(510, 490, 80, 80); 
					panelBoard.add(pbtn[i][j]);
				}
				if( i == 0 && j==6) {// 1시방향 버튼 
					pbtn[i][j].setBounds(510, 5, 80, 80);
					panelBoard.add(pbtn[i][j]);
				}
				if( i == 0 && j ==0) {
					pbtn[i][j].setBounds(23, 5, 80, 80);
					panelBoard.add(pbtn[i][j]);
				}
				if( i == 6 && j== 0) {
					pbtn[i][j].setBounds(23, 486, 80, 80);
					panelBoard.add(pbtn[i][j]);
				}
				
				if( j==6 || j==0) { //겉에 세로 
					if(j ==6) {
						x =526;
						y= 400;
					}else{
						x =40;
						y= 400;
					}
					if( i == 4 || i ==5) {
						offset = 5-i;
						pbtn[i][j].setBounds(x , y - (89*offset), 45, 45); //왼쪽 세로 줄 
						panelBoard.add(pbtn[i][j]);
					}
					if( i == 1 || i ==2) {
						offset = 4-i;
						pbtn[i][j].setBounds(x , y - (89*offset), 45, 45); //왼쪽 세로 줄 
						panelBoard.add(pbtn[i][j]);
					}
				}

				if( i==0 || i==6) { //겉에 가로 
					if(i==0) {
						x = 150;
						y= 21;
					}else {
						x = 150;
						y = 507;
					}
					if( j ==1 || j ==2) {
						offset = j-1;
						pbtn[i][j].setBounds(x + (89*offset), y, 45, 45); //위쪽 줄 
						panelBoard.add(pbtn[i][j]);
					}
					if( j ==4 || j ==5) {
						offset = j-2;
						pbtn[i][j].setBounds(x + (89*offset), y, 45, 45); //위쪽 줄 
						panelBoard.add(pbtn[i][j]);
					}
				}
				if( i == 3 && j==3) { //센터
					pbtn[i][j].setBounds(265, 247, 80, 80);
					panelBoard.add(pbtn[i][j]);
				}
				if( j ==1 ) { //센터 왼쪽부터 한줄
					if( i ==1) {
						offset = 0;
						pbtn[i][j].setBounds(126, 107+ (315*offset), 45, 45);
						panelBoard.add(pbtn[i][j]);
					}
					if (i ==5) {
						offset = 1;
						pbtn[i][j].setBounds(126, 107+ (315*offset), 45, 45);
						panelBoard.add(pbtn[i][j]);
					}

				}
				if( j ==2 ) { //센터 왼쪽부터 한줄
					if( i ==2) {
						offset = 0;
						pbtn[i][j].setBounds(197, 180+ (170*offset), 45, 45);
						panelBoard.add(pbtn[i][j]);
					}
					if (i ==4) {
						offset = 1;
						pbtn[i][j].setBounds(197, 180+ (170*offset), 45, 45);
						panelBoard.add(pbtn[i][j]);
					}

				}
				if( j ==4 ) { //센터 왼쪽부터 한줄
					if( i ==2) {
						offset = 0;
						pbtn[i][j].setBounds(370, 180+ (170*offset), 45, 45);
						panelBoard.add(pbtn[i][j]);
					}
					if (i ==4) {
						offset = 1;
						pbtn[i][j].setBounds(370, 180+ (170*offset), 45, 45);
						panelBoard.add(pbtn[i][j]);
					}

				}
				if( j ==5 ) { //센터 왼쪽부터 한줄
					if( i ==1) {
						offset = 0;
						pbtn[i][j].setBounds(441, 107+ (315*offset), 45, 45);
						panelBoard.add(pbtn[i][j]);
					}
					if (i ==5) {
						offset = 1;
						pbtn[i][j].setBounds(441, 107+ (315*offset), 45, 45);
						panelBoard.add(pbtn[i][j]);
					}
				}
				pbtn[i][j].addActionListener(control);
				pbtn[i][j].setContentAreaFilled(false);
			}
		}

		JLabel lblBoard = new JLabel("");
		lblBoard.setIcon(new ImageIcon("./img/board.PNG"));
		lblBoard.setBounds(0, 0, 605, 568);
		panelBoard.add(lblBoard);
		
		return panelBoard;
	}
	public JPanel createThrowSet() {
		
		JPanel panelBtnSetOfThrow = new JPanel();
		panelBtnSetOfThrow.setLayout(null);
		testThrowYutBtns = new JButton[6];
		String[] throwString = {"빽도","도","개","걸","윷","모"};
		ramdomThrowYutBtn = new JButton("윷 던지기");
		ramdomThrowYutBtn.setBounds(0, 0, 186, 54);
		panelBtnSetOfThrow.add(ramdomThrowYutBtn);
		ramdomThrowYutBtn.setBackground(UIManager.getColor("Button.focus"));
		ramdomThrowYutBtn.setFont(new Font("굴림", Font.BOLD, 30));
		ramdomThrowYutBtn.addActionListener(control);
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				testThrowYutBtns[(i*2)+j] = new JButton(throwString[(i*2)+j]);
				testThrowYutBtns[(i*2)+j].setBounds(0 + (j*106), 70 + (i*40 ), 80, 27);
				panelBtnSetOfThrow.add(testThrowYutBtns[(i*2)+j]);
				testThrowYutBtns[(i*2)+j].addActionListener(control);
			}
		}
		

		return panelBtnSetOfThrow;
		
	}

	public void createPlayerSet(int player_num, int horse_num) {
		JPanel panelPlayerSet = new JPanel();
		panelPlayerSet.setLayout(null);
		players = new JPanel[player_num];
		btnPlayerWait = new JButton[player_num];
		lblplayerFin = new JLabel[player_num];
		for(int i=0; i< player_num; i++) {
			players[i] = new JPanel();
			players[i].setBounds(0, 12+(116*i), 183, 104);
			panelPlayerSet.add(players[i]);
			players[i].setLayout(null);
			
			JLabel lblPlayer = new JLabel("player"+i);
			lblPlayer.setBounds(5, 9, 62, 18);
			players[i].add(lblPlayer);
			
			btnPlayerWait[i] = new JButton();
			btnPlayerWait[i].setBounds(5, 25, 88, 67);
			btnPlayerWait[i].setIcon(new ImageIcon("./img/"+i+"_"+horse_num+".png"));
			players[i].add(btnPlayerWait[i]);
			btnPlayerWait[i].addActionListener(control);
			btnPlayerWait[i].setContentAreaFilled(false);


			lblplayerFin[i] = new JLabel("");
			lblplayerFin[i].setBounds(99, 28, 70, 64);
			players[i].add(lblplayerFin[i]);
		}

		panelPlayerSet.setBounds(4, 80, 186, 512);
		mainPage.add(panelPlayerSet);


		
	}
	
	
}


 



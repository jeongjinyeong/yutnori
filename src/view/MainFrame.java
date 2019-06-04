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
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	public JPanel contentPane;
	public JButton buttonThrowYut; //랜덤윷던지기 버튼
	public JLabel lblResultThrowYut; //결과 이미지
	public JButton[][] pbtn; //보드 버튼 배열
	public JButton[] throwBtns; //도개결윷모 던지기 버튼 배열
	private Controller control; 
	/**
	 * Create the frame.
	 */

	public MainFrame(Controller controller) {
		control = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBoard = createBoard();
		panelBoard.setBounds(204, 73, 619, 580);
		contentPane.add(panelBoard);

		JPanel panelPlayerSet = createPlayerSet();
		panelPlayerSet.setBounds(4, 80, 186, 512);
		contentPane.add(panelPlayerSet);

		JPanel panelThrowBtnSet = createThrowSet();
		panelThrowBtnSet.setBounds(837, 255, 200, 187);
		contentPane.add(panelThrowBtnSet);
										
		JLabel lblHeadLine = new JLabel("윷놀이");
		lblHeadLine.setFont(new Font("굴림", Font.BOLD, 21));
		lblHeadLine.setBounds(15, 12, 133, 64);
		contentPane.add(lblHeadLine);
										
		lblResultThrowYut = new JLabel();
		lblResultThrowYut.setBounds(837, 73, 200, 173);
		contentPane.add(lblResultThrowYut);
		this.setVisible(true);
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
						offset = i-4;
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
		throwBtns = new JButton[6];
		String[] throwString = {"빽도","도","개","걸","윷","모"};
		buttonThrowYut = new JButton("윷 던지기");
		buttonThrowYut.setBounds(0, 0, 186, 54);
		panelBtnSetOfThrow.add(buttonThrowYut);
		buttonThrowYut.setBackground(UIManager.getColor("Button.focus"));
		buttonThrowYut.setFont(new Font("굴림", Font.BOLD, 30));
		buttonThrowYut.addActionListener(control);
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				throwBtns[(i*2)+j] = new JButton(throwString[(i*2)+j]);
				throwBtns[(i*2)+j].setBounds(0 + (j*106), 70 + (i*40 ), 80, 27);
				panelBtnSetOfThrow.add(throwBtns[(i*2)+j]);
				throwBtns[(i*2)+j].addActionListener(control);
			}
		}
		

		return panelBtnSetOfThrow;
		
	}
	public JPanel createPlayerSet() {
		JPanel panelPlayerSet = new JPanel();
		panelPlayerSet.setLayout(null);
		
		JPanel panelPlayer1 = new JPanel();
		panelPlayer1.setBounds(0, 12, 183, 104);
		panelPlayerSet.add(panelPlayer1);
		panelPlayer1.setLayout(null);
		
		JLabel lblPlayer1 = new JLabel("player1");
		lblPlayer1.setBounds(5, 9, 62, 18);
		panelPlayer1.add(lblPlayer1);
		
		JButton btnPlayer1wait = new JButton("player1Wait");
		btnPlayer1wait.setBounds(5, 25, 88, 67);
		panelPlayer1.add(btnPlayer1wait);
		
		JLabel lblplayer1Fin = new JLabel("player2Fin");
		lblplayer1Fin.setBounds(99, 28, 70, 64);
		panelPlayer1.add(lblplayer1Fin);
		
		JPanel panelPlayer2 = new JPanel();
		panelPlayer2.setBounds(0, 128, 183, 104);
		panelPlayerSet.add(panelPlayer2);
		panelPlayer2.setLayout(null);
		
		JLabel lblPlayer2 = new JLabel("player2");
		lblPlayer2.setBounds(5, 9, 62, 18);
		panelPlayer2.add(lblPlayer2);
		
		JButton btnPlayer2wait = new JButton("player2Wait");
		btnPlayer2wait.setBounds(5, 25, 88, 67);
		panelPlayer2.add(btnPlayer2wait);
		
		JLabel lblplayer2Fin = new JLabel("player2Fin");
		lblplayer2Fin.setBounds(99, 28, 70, 64);
		panelPlayer2.add(lblplayer2Fin);
		
		JPanel panelPlayer3 = new JPanel();
		panelPlayer3.setBounds(0, 254, 183, 104);
		panelPlayerSet.add(panelPlayer3);
		panelPlayer3.setLayout(null);
		
		JLabel lblPlayer3 = new JLabel("player3");
		lblPlayer3.setBounds(5, 9, 62, 18);
		panelPlayer3.add(lblPlayer3);
		
		JButton btnPlayer3wait = new JButton("player3Wait");
		btnPlayer3wait.setBounds(5, 25, 88, 67);
		panelPlayer3.add(btnPlayer3wait);
		
		JLabel lblplayer3Fin = new JLabel("player3Fin");
		lblplayer3Fin.setBounds(99, 28, 70, 64);
		panelPlayer3.add(lblplayer3Fin);
		
		JPanel panelPlayer4 = new JPanel();
		panelPlayer4.setBounds(0, 385, 183, 104);
		panelPlayerSet.add(panelPlayer4);
		panelPlayer4.setLayout(null);
		
		JLabel lblPlayer4 = new JLabel("player4");
		lblPlayer4.setBounds(5, 9, 62, 18);
		panelPlayer4.add(lblPlayer4);
		
		JButton btnPlayer4wait = new JButton("player4Wait");
		btnPlayer4wait.setBounds(5, 25, 88, 67);
		panelPlayer4.add(btnPlayer4wait);
		
		JLabel lblplayer4Fin = new JLabel("player4Fin");
		lblplayer4Fin.setBounds(99, 28, 70, 64);
		panelPlayer4.add(lblplayer4Fin);
		
		return panelPlayerSet;
		
	}
}


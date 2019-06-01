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

	private JPanel contentPane;
	public JButton buttonThrowYut;
	public JLabel lblResultThrowYut;
	
	private EventThrow event; 
	/**
	 * Create the frame.
	 */
	
	/*원래  여기 main문 있고 MainFrame mainframe = new MainFrame() 이렇게 되있고
	mainframe.setvisible(True) 이런식으로 해서 실행됬거든??
	근데 컨트롤러 클래스에서 mainboard = new MainFrame(this); 이거 해줬으까 생성자를
	여기 밑에있는 식으로 바꿨는데 () 괄호안에 EventThrow eventthrow넣어서
	생성자는 문제없ㄴㄴ데  MainFrame mainframe = new MainFrame()여기가 에러뜨는거 괄호안에 파라미터없다고
	그래서 저 괄호안에 event넣어도보고 넣었더니 그걸 static으로 바꾸라해서 static이 뭔진 모르겠는데 위에 private EventThrow event;를
	도 private static EventThrow event; 으로 해보고 별지랄 다했는데도 안되서
	그냥 이 클래스 안에있는 main문 없애고 훼이크 클래스(startpage) 만들어서 거기다 메인문 넣고
	new EventThrow()해서 eventthrow 생성자 실행하고, 그러면 eventthrow 생성자에서
	mainboard = new MainFrame(this); 이거 해주니까 
	MainFrame생성자 밑에서 this.setVisible(true)해서 판 보여주는거까진 됬는데
	여전히 마우스 이벤트 못받아줘가지고
	걍 여기서 ㅈㅈ침
	*/
	public MainFrame(EventThrow eventthrow) {
		event = eventthrow;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 700);
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
										
		JLabel lblHeadLine = new JLabel("\uC737\uB180\uC774");
		lblHeadLine.setFont(new Font("µ¸¿ò", Font.BOLD, 21));
		lblHeadLine.setBounds(15, 12, 133, 64);
		contentPane.add(lblHeadLine);
										
		JLabel lblResultThrowYut = new JLabel("");
		lblResultThrowYut.setIcon(new ImageIcon(eventthrow.chooseMal()));
				
		lblResultThrowYut.setBounds(837, 73, 200, 173);
		contentPane.add(lblResultThrowYut);
		this.setVisible(true);
	}
	

	public JPanel createBoard() {
		
		JPanel panelBoard = new JPanel();
		panelBoard.setLayout(null);
		

		
		JButton btn0 = new JButton("");
		btn0.setBounds(514, 489, 80, 74);
		panelBoard.add(btn0);
		
		JButton btn1 = new JButton("");
		btn1.setBounds(524, 398, 45, 45);
		panelBoard.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.setBounds(524, 307, 45, 45);
		panelBoard.add(btn2);
				
		JButton btn3 = new JButton("");
		btn3.setBounds(524, 220, 45, 45);
		panelBoard.add(btn3);		
		
		JButton btn4 = new JButton("");
		btn4.setBounds(524, 125, 45, 45);
		panelBoard.add(btn4);

		JButton btn5 = new JButton("");
		btn5.setBounds(502, 12, 80, 74);
		panelBoard.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setBounds(415, 27, 45, 45);
		panelBoard.add(btn6);		
		
		JButton btn7 = new JButton("");
		btn7.setBounds(325, 27, 45, 45);
		panelBoard.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setBounds(241, 27, 45, 45);
		panelBoard.add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.setBounds(148, 27, 45, 45);
		panelBoard.add(btn9);
		
		JButton btn10 = new JButton("");
		btn10.setBounds(26, 12, 80, 74);
		panelBoard.add(btn10);

		JButton btn11 = new JButton("");
		btn11.setBounds(35, 125, 45, 45);
		panelBoard.add(btn11);

		JButton btn12 = new JButton("");
		btn12.setBounds(35, 220, 45, 45);
		panelBoard.add(btn12);
		
		JButton btn13 = new JButton("");
		btn13.setBounds(35, 307, 45, 45);
		panelBoard.add(btn13);
		
		JButton btn14 = new JButton("");
		btn14.setBounds(35, 398, 45, 45);
		panelBoard.add(btn14);
		
		JButton btn15 = new JButton("");
		btn15.setBounds(14, 486, 80, 74);
		panelBoard.add(btn15);
		
		JButton btn16 = new JButton("");
		btn16.setBounds(153, 501, 45, 45);
		panelBoard.add(btn16);
		
		JButton btn17 = new JButton("");
		btn17.setBounds(241, 504, 45, 45);
		panelBoard.add(btn17);
		
		JButton btn18 = new JButton("");
		btn18.setBounds(325, 504, 45, 45);
		panelBoard.add(btn18);
		
		JButton btn19 = new JButton("");
		btn19.setBounds(415, 504, 45, 45);
		panelBoard.add(btn19);
		
		JButton btn20 = new JButton("");
		btn20.setBounds(263, 251, 80, 74);
		panelBoard.add(btn20);
		
		JButton btn21 = new JButton("");
		btn21.setBounds(441, 107, 45, 45);
		panelBoard.add(btn21);
		
		JButton btn22 = new JButton("");
		btn22.setBounds(371, 182, 45, 45);
		panelBoard.add(btn22);

		JButton btn23 = new JButton("");
		btn23.setBounds(126, 107, 45, 45);
		panelBoard.add(btn23);

		JButton btn24 = new JButton("");
		btn24.setBounds(199, 182, 45, 45);
		panelBoard.add(btn24);
		
		JButton btn25 = new JButton("");
		btn25.setBounds(188, 355, 45, 45);
		panelBoard.add(btn25);
		
		JButton btn26 = new JButton("");
		btn26.setBounds(126, 414, 45, 45);
		panelBoard.add(btn26);

		JButton btn27 = new JButton("");
		btn27.setBounds(371, 344, 45, 45);
		panelBoard.add(btn27);

		JButton btn28 = new JButton("");
		btn28.setBounds(441, 414, 45, 45);
		panelBoard.add(btn28);
		
		
		JLabel lblBoard = new JLabel("");
		lblBoard.setIcon(new ImageIcon("./img/board.PNG"));
		lblBoard.setBounds(0, 0, 605, 568);
		panelBoard.add(lblBoard);
		
		return panelBoard;
	}
	public JPanel createThrowSet() {
		
		JPanel panelBtnSetOfThrow = new JPanel();
		panelBtnSetOfThrow.setLayout(null);
		
		JButton buttonThrowYut = new JButton("윷 던지기");
		buttonThrowYut.setBounds(0, 0, 186, 54);
		panelBtnSetOfThrow.add(buttonThrowYut);
		buttonThrowYut.setBackground(UIManager.getColor("Button.focus"));
		buttonThrowYut.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
		buttonThrowYut.addActionListener(event);
		
		JButton buttonDo = new JButton("도");
		buttonDo.setBounds(0, 70, 80, 27);
		panelBtnSetOfThrow.add(buttonDo);
		
		JButton buttonGe = new JButton("개");
		buttonGe.setBounds(106, 70, 80, 27);
		panelBtnSetOfThrow.add(buttonGe);
		
		JButton buttonGul = new JButton("걸");
		buttonGul.setBounds(0, 110, 80, 27);
		panelBtnSetOfThrow.add(buttonGul);
		
		JButton buttonYoot = new JButton("윷");
		buttonYoot.setBounds(106, 110, 80, 27);
		panelBtnSetOfThrow.add(buttonYoot);
		
		JButton buttonMo = new JButton("모");
		buttonMo.setBounds(0, 150, 80, 27);
		panelBtnSetOfThrow.add(buttonMo);
		
		JButton buttonBackDo = new JButton("백도");
		buttonBackDo.setBounds(106, 150, 80, 27);
		panelBtnSetOfThrow.add(buttonBackDo);
		
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


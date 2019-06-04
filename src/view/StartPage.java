package view;
import controller.Controller;


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

/**
 * Launch the application.
 */
public class StartPage extends JFrame{
	
	public JPanel startPane;
	public JButton[] playerNum;
	public JButton[] malNum;
	public JButton startGame;
	private Controller control;
	
	public StartPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		startPane = new JPanel();
		startPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(startPane);
		startPane.setLayout(null);
		createPlayerNum();
		createMalNum();
		createStartGame();

		
		this.setVisible(true);
	}
	
	
	public void createPlayerNum() {

		JLabel label = new JLabel("�����ο�");
		label.setBounds(50, 83, 62, 18);
		startPane.add(label);
		String[] player_num = {"2��","3��","4��"};
		playerNum = new JButton[3];
		for(int i=0; i<3; i++) {
			playerNum[i] = new JButton(player_num[i]);
			playerNum[i].setBounds(165+(i*85), 67, 55, 50);
			startPane.add(playerNum[i]);
		}		

		
	}

	public void createMalNum() {
		
		JLabel label_1 = new JLabel("�� ����");
		label_1.setBounds(50, 168, 62, 18);
		startPane.add(label_1);

		String[] mal_num = {"2��","3��","4��","5��"};
		malNum = new JButton[4];
		
		for(int i=0; i<4; i++) {
			malNum[i] = new JButton(mal_num[i]);
			malNum[i].setBounds(126+(i*80), 139, 55, 50);
			startPane.add(malNum[i]);
			malNum[i].addActionListener(event);
		}

		
	}
	
	public void createStartGame() {
		
		
		JButton btnNewButton = new JButton("���ӽ���");
		btnNewButton.setBounds(152, 217, 204, 39);
		startPane.add(btnNewButton);

		JLabel label_2 = new JLabel("������");
		label_2.setBounds(230, 24, 74, 18);
		startPane.add(label_2);
		
	}	
	public static void main(String[] args) {
			new StartPage();
		}
}

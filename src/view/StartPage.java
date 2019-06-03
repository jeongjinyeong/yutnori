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
		setBounds(100, 100, 1070, 750);
		startPane = new JPanel();
		startPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(startPane);
		startPane.setLayout(null);

		JPanel panelPlayerNumSet = createPlayerNum();
		panelPlayerNumSet.setBounds(4, 80, 186, 512);
		startPane.add(panelPlayerNumSet);

		JPanel panelMalNumSet = createMalNum();
		panelMalNumSet.setBounds(537, 155, 100, 87);
		startPane.add(panelMalNumSet);

		JPanel panelStartGame = createStartGame();
		panelStartGame.setBounds(837, 73, 200, 173);
		startPane.add(panelStartGame);
		
		JLabel lblHeadLine = new JLabel("시작화면");
		lblHeadLine.setFont(new Font("굴림", Font.BOLD, 21));
		lblHeadLine.setBounds(15, 12, 133, 64);
		startPane.add(lblHeadLine);
		
		this.setVisible(true);
	}
	
	
	public JPanel createPlayerNum() {
			
		JPanel panelPlayerNum = new JPanel();
		panelPlayerNum.setLayout(null);
		String[] player_num = {"2명","3명","4명"};
		playerNum = new JButton[3];
		for(int i=0; i<3; i++) {
			playerNum[i] = new JButton(player_num[i]);
			playerNum[i].setBounds(0+(i*106), 70+(i*40), 80, 27);
			panelPlayerNum.add(playerNum[i]);
			playerNum[i].addActionListener(control);
		}		
		return panelPlayerNum;
		
	}

	public JPanel createMalNum() {
		
		JPanel panelMalNum = new JPanel();
		panelMalNum.setLayout(null);
		String[] mal_num = {"2명","3명","4명","5명"};
		malNum = new JButton[4];
		
		for(int i=0; i<4; i++) {
			malNum[i] = new JButton(mal_num[i]);
			malNum[i].setBounds(0+(i*207), 70+(i*140), 180, 127);
			panelMalNum.add(malNum[i]);
			malNum[i].addActionListener(control);
		}
		
		return panelMalNum;
		
	}
	
	public JPanel createStartGame() {
		
		JPanel panelStartGame = new JPanel();
		panelStartGame.setLayout(null);
		startGame = new JButton("시작하기");
		
		startGame.setBounds(12, 19, 62, 18);
		panelStartGame.add(startGame);
		startGame.addActionListener(control);
		
		
		return panelStartGame;
		
	}	
	public static void main(String[] args) {
			System.out.println("게임시작");
			new EventThrow();//
		}
}

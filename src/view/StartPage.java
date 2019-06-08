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
import javax.swing.JComboBox;
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
	public JComboBox playerCombo;
	public JComboBox horseCombo;
	public StartPage(Controller controller) {
		control = controller;
		String[] playerStringSet = {"2명","3명","4명"};
		String[] horseStringSet = {"2개","3개","4개","5개"};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 500, 360);
		startPane = new JPanel();
		startPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(startPane);
		startPane.setLayout(null);
		JLabel label_2 = new JLabel("윷놀이");
		label_2.setBounds(230, 24, 74, 18);
		startPane.add(label_2);
		JLabel label = new JLabel("시작인원");
		label.setBounds(150, 83, 62, 18);
		startPane.add(label);
		JLabel label_1 = new JLabel("말 갯수");
		label_1.setBounds(150, 168, 62, 18);
		startPane.add(label_1);


		playerCombo= new JComboBox(playerStringSet);
		playerCombo.setBounds(250, 83, 100, 30);
		startPane.add(playerCombo);
		horseCombo= new JComboBox(horseStringSet);
		horseCombo.setBounds(250, 159, 100, 30);
		startPane.add(horseCombo);
		playerCombo.addActionListener(control);
		horseCombo.addActionListener(control);
		
		
		playerCombo.getSelectedItem().toString();
		horseCombo.getSelectedItem().toString(); 
		
		startGame = new JButton("게임시작");
		startGame.setBounds(152, 217, 204, 39);
		startPane.add(startGame);
		startGame.addActionListener(control);

		this.setVisible(true);
	}
	
	
}

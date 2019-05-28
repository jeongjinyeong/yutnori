package view;

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

public class game extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game frame = new game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 922);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC737\uB180\uC774");
		lblNewLabel.setFont(new Font("µ¸¿ò", Font.BOLD, 21));
		lblNewLabel.setBounds(406, 27, 133, 64);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(15, 143, 62, 18);
		contentPane.add(label);
		
		JButton button = new JButton("\uB358\uC9C0\uAE30");
		button.setBackground(UIManager.getColor("Button.focus"));
		button.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
		button.setBounds(729, 625, 213, 64);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\workspace\\Yutnori\\img\\board.PNG"));
		
				label_1.setBounds(216, 130, 554, 498);
				contentPane.add(label_1);
				
				JLabel lblPlayer = new JLabel("player1");
				lblPlayer.setBounds(0, 172, 190, 156);
				contentPane.add(lblPlayer);
				
				JLabel lblPlayer_1 = new JLabel("player2");
				lblPlayer_1.setBounds(0, 399, 190, 156);
				contentPane.add(lblPlayer_1);
				
				JLabel lblPlayer_2 = new JLabel("player3");
				lblPlayer_2.setBounds(729, 172, 190, 156);
				contentPane.add(lblPlayer_2);
				
				JLabel lblPlayer_3 = new JLabel("player4");
				lblPlayer_3.setBounds(739, 333, 190, 156);
				contentPane.add(lblPlayer_3);
				
				JLabel lblNewLabel_2 = new JLabel("New label");
				lblNewLabel_2.setIcon(new ImageIcon("C:\\workspace\\Yutnori\\img\\front.png"));
				lblNewLabel_2.setBounds(347, 625, 90, 224);
				contentPane.add(lblNewLabel_2);
				
				JLabel label_2 = new JLabel("New label");
				label_2.setIcon(new ImageIcon("C:\\workspace\\Yutnori\\img\\backdo.png"));
				label_2.setBounds(470, 625, 90, 224);
				contentPane.add(label_2);
				
				JLabel label_3 = new JLabel("New label");
				label_3.setIcon(new ImageIcon("C:\\workspace\\Yutnori\\img\\front.png"));
				label_3.setBounds(588, 625, 90, 224);
				contentPane.add(label_3);
				
				JLabel label_4 = new JLabel("New label");
				label_4.setIcon(new ImageIcon("C:\\workspace\\Yutnori\\img\\front.png"));
				label_4.setBounds(226, 625, 90, 224);
				contentPane.add(label_4);
	}
}




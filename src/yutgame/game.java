package yutgame;

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
		setBounds(100, 100, 882, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC737\uB180\uC774");
		lblNewLabel.setFont(new Font("µ¸¿ò", Font.BOLD, 21));
		lblNewLabel.setBounds(26, 12, 133, 64);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(15, 143, 62, 18);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\workspace\\Yutnori\\img\\do.PNG"));
		lblNewLabel_1.setBounds(583, 77, 171, 252);
		contentPane.add(lblNewLabel_1);
		
		JButton button = new JButton("\uB358\uC9C0\uAE30");
		button.setBackground(UIManager.getColor("Button.focus"));
		button.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
		button.setBounds(522, 349, 285, 64);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setBounds(442, 476, 45, 52);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\workspace\\Yutnori\\img\\board.PNG"));
		
				label_1.setBounds(25, 88, 476, 448);
				contentPane.add(label_1);
	}

}




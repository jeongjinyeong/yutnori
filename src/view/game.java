package view;
import model.Yut;
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
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC737\uB180\uC774");
		lblNewLabel.setFont(new Font("µ¸¿ò", Font.BOLD, 21));
		lblNewLabel.setBounds(15, 12, 133, 64);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(15, 143, 62, 18);
		contentPane.add(label);
		
		JButton button = new JButton("\uB358\uC9C0\uAE30");
		button.setBackground(UIManager.getColor("Button.focus"));
		button.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
		button.setBounds(733, 358, 213, 64);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("./img/board.PNG"));
		
				label_1.setBounds(219, 82, 486, 466);
				contentPane.add(label_1);
				
				JLabel lblPlayer_1 = new JLabel("player1");
				lblPlayer_1.setBounds(15, 50, 200, 120);
				contentPane.add(lblPlayer_1);
				
				JLabel lblPlayer_2 = new JLabel("player2");
				lblPlayer_2.setBounds(15, 170, 200, 120);
				contentPane.add(lblPlayer_2);
				
				JLabel lblPlayer_3 = new JLabel("player3");
				lblPlayer_3.setBounds(15, 290, 200, 120);
				contentPane.add(lblPlayer_3);
				
				JLabel lblPlayer_4 = new JLabel("player4");
				lblPlayer_4.setBounds(15, 410, 200, 120);
				contentPane.add(lblPlayer_4);
				
				JButton button_1 = new JButton("도");
				button_1.setBounds(733, 429, 105, 27);
				contentPane.add(button_1);
				
				JButton button_2 = new JButton("개");
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button_2.setBounds(841, 429, 105, 27);
				contentPane.add(button_2);
				
				JButton btnNewButton = new JButton("걸");
				btnNewButton.setBounds(733, 467, 105, 27);
				contentPane.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("윷");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_1.setBounds(841, 467, 105, 27);
				contentPane.add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("모");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_2.setBounds(733, 500, 105, 27);
				contentPane.add(btnNewButton_2);
				
				JButton btnNewButton_3 = new JButton("백도");
				btnNewButton_3.setBounds(841, 500, 105, 27);
				contentPane.add(btnNewButton_3);
				
				JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setIcon(new ImageIcon("./img/mo.PNG"));
				lblNewLabel_1.setBounds(733, 92, 213, 230);
				contentPane.add(lblNewLabel_1);
	}
}


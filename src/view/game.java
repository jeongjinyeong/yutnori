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
		setBounds(100, 100, 1070, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_28 = new JButton("New button");
		button_28.setBounds(566, 424, 45, 45);
		contentPane.add(button_28);
		
		JButton button_24 = new JButton("New button");
		button_24.setBounds(386, 245, 45, 45);
		contentPane.add(button_24);
		
		JButton button_25 = new JButton("New button");
		button_25.setBounds(326, 175, 45, 45);
		contentPane.add(button_25);
		
		JButton button_22 = new JButton("New button");
		button_22.setBounds(631, 175, 45, 45);
		contentPane.add(button_22);
		
		JButton button_26 = new JButton("New button");
		button_26.setBounds(398, 410, 45, 45);
		contentPane.add(button_26);
		
		JButton button_29 = new JButton("New button");
		button_29.setBounds(631, 485, 45, 45);
		contentPane.add(button_29);
		
		JButton button_27 = new JButton("New button");
		button_27.setBounds(326, 485, 45, 45);
		contentPane.add(button_27);
		
		JButton button_23 = new JButton("New button");
		button_23.setBounds(566, 245, 45, 45);
		contentPane.add(button_23);
		
		JButton button_15 = new JButton("New button");
		button_15.setBounds(239, 290, 45, 45);
		contentPane.add(button_15);
		
		JButton button_17 = new JButton("New button");
		button_17.setBounds(239, 467, 45, 45);
		contentPane.add(button_17);
		
		JButton button_19 = new JButton("New button");
		button_19.setBounds(441, 571, 45, 45);
		contentPane.add(button_19);
		
		JButton button_16 = new JButton("New button");
		button_16.setBounds(239, 377, 45, 45);
		contentPane.add(button_16);
		
		JButton button_20 = new JButton("New button");
		button_20.setBounds(526, 571, 45, 45);
		contentPane.add(button_20);
		
		JButton button_18 = new JButton("New button");
		button_18.setBounds(347, 571, 45, 45);
		contentPane.add(button_18);
		
		JButton button_21 = new JButton("New button");
		button_21.setBounds(615, 571, 45, 45);
		contentPane.add(button_21);
		
		JButton button_14 = new JButton("New button");
		button_14.setBounds(239, 197, 45, 45);
		contentPane.add(button_14);
		
		JButton button_12 = new JButton("New button");
		button_12.setBounds(526, 88, 45, 45);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("New button");
		button_13.setBounds(441, 88, 45, 45);
		contentPane.add(button_13);
		
		JButton button_11 = new JButton("New button");
		button_11.setBounds(347, 88, 45, 45);
		contentPane.add(button_11);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(615, 88, 45, 45);
		contentPane.add(button_10);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(218, 556, 80, 74);
		contentPane.add(button_9);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(218, 73, 80, 74);
		contentPane.add(button_8);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(469, 313, 80, 74);
		contentPane.add(button_7);
		btnNewButton_5.setBounds(722, 458, 45, 45);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(704, 556, 80, 74);
		contentPane.add(btnNewButton_4);
		
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
		button.setBounds(838, 345, 200, 54);
		contentPane.add(button);
				
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
				button_1.setBounds(848, 410, 80, 27);
				contentPane.add(button_1);
				
				JButton button_2 = new JButton("개");
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button_2.setBounds(942, 410, 80, 27);
				contentPane.add(button_2);
				
				JButton btnNewButton = new JButton("걸");
				btnNewButton.setBounds(848, 442, 80, 27);
				contentPane.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("윷");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_1.setBounds(942, 442, 80, 27);
				contentPane.add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("모");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_2.setBounds(848, 476, 80, 27);
				contentPane.add(btnNewButton_2);
				
				JButton btnNewButton_3 = new JButton("백도");
				btnNewButton_3.setBounds(942, 476, 80, 27);
				contentPane.add(btnNewButton_3);
				
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon("C:\\workspace\\yutnori\\img\\moe.png"));
				lblNewLabel_1.setBounds(838, 110, 200, 173);
				contentPane.add(lblNewLabel_1);
						
						JButton button_3 = new JButton("New button");
						button_3.setBounds(722, 377, 45, 45);
						contentPane.add(button_3);
						
						JButton button_4 = new JButton("New button");
						button_4.setBounds(722, 285, 45, 45);
						contentPane.add(button_4);
								
								JButton button_5 = new JButton("New button");
								button_5.setBounds(722, 197, 45, 45);
								contentPane.add(button_5);
										
										JButton button_6 = new JButton("New button");
										button_6.setBounds(704, 73, 80, 74);
										contentPane.add(button_6);
										
										JLabel label_1 = new JLabel("");
										label_1.setIcon(new ImageIcon("C:\\workspace\\yutnori\\img\\board.PNG"));
										
												label_1.setBounds(198, 60, 625, 581);
												contentPane.add(label_1);
	}
}


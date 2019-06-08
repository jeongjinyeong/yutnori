package view;
import controller.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;


public class ResultPage extends JFrame {
	// 버튼이 눌러지면 만들어지는 새 창을 정의한 클래스
	public JButton restart;
	public JButton close;
	private Controller control;
	
	
	
	public ResultPage(Controller controller, int num) {
		control = controller;
        setTitle("결과");
        setBounds(500, 400, 300, 200);
        JPanel dialog = new JPanel();
		dialog.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(dialog);
		dialog.setLayout(null);
        setContentPane(dialog);
        
        JLabel NewLabel = new JLabel("Player"+num+"이 이겼습니다.");
        NewLabel.setBounds(100, 20, 200, 30);
        dialog.add(NewLabel);
        
        restart = new JButton("재시작");
        restart.setBounds(60, 60, 80, 50);
        restart.addActionListener(control);
        dialog.add(restart);
        
        close = new JButton("종료");
        close.setBounds(160, 60, 80, 50);
        dialog.add(close);
        close.addActionListener(control);
        
        setResizable(false);
        setVisible(true);
	}
}
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import model.Yut;
import view.MainFrame;

public class EventThrow implements ActionListener{
	
	private MainFrame mainboard;
	String[] yutname = {"./img/back_doe.png", "./img/doe.png", "./img/gae.png", "./img/gul.png", "./img/yoot.png", "./img/moe.png"}; 
	public EventThrow() {
		mainboard = new MainFrame(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==mainboard.buttonThrowYut) {
			String throwResult = yutname[model.Yut.throwYut()];
			mainboard.lblResultThrowYut.setIcon(new ImageIcon(throwResult));
		}
		for(int i=0; i<6; i++) {
			if(e.getSource()==mainboard.throwBtns[i]) {
				String throwResult = yutname[i];
				mainboard.lblResultThrowYut.setIcon(new ImageIcon(throwResult));
			}
		}
	}		
}

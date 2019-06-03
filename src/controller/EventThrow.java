package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import model.*;
import view.MainFrame;

public class EventThrow implements ActionListener{
	
	private MainFrame mainboard;
	
	public EventThrow() {
		// TODO Auto-generated constructor stub
		mainboard = new MainFrame(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mainboard.buttonThrowYut) {
			String throwResult = chooseMal();
			System.out.println(throwResult);
			mainboard.lblResultThrowYut.setIcon(new ImageIcon(throwResult));
		}
	}
	
	public String chooseMal() {
		
		int throwyut_results;
		Yut yut = new Yut();
		String result = "";
		throwyut_results = yut.throwYut();
		switch(throwyut_results) {
			case 0:
				result = "./img/doe.png";
				break;
			case 1:
				result = "./img/gae.png";
				break;
			case 2:
				result = "./img/gul.png";
				break;
			case 3:
				result = "./img/yoot.png";
				break;
			case 4:
				result = "./img/moe.png";
				break;
			case 5:
				result = "./img/back_doe.png";
				break;
		}
		return result;
	}

	
}

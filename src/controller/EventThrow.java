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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mainboard.buttonThrowYut) {
			System.out.println("???");
			mainboard.lblResultThrowYut.setIcon(new ImageIcon(chooseMal()));
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
			case 1:
				result = "./img/gae.png";
			case 2:
				result = "./img/gul.png";
			case 3:
				result = "./img/yoot.png";
			case 4:
				result = "./img/moe.png";
			case 5:
				result = "./img/back_do.png";
		}
		return result;
	}

	
}

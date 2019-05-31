package model;
import java.util.Random;


public class Yut {
	private int state;
	public Yut() {
		state = -1;
	}
	public int throwYut() {
		Random random = new Random();
		float ran_num = random.nextFloat();
		if(ran_num<=0.1152) {
			state = 0; //도
		}
		else if(ran_num>0.1152 && ran_num<=0.4608) {
			state = 1; //개
		}
		else if(ran_num>0.4608 && ran_num<=0.8064) {
			state = 2; //걸
		}
		else if(ran_num>0.8064 && ran_num<=0.936) {
			state = 3; //윷
		}
		else if(ran_num>0.936 && ran_num<=0.9616) {
			state = 4; //모
		}
		else if(ran_num>0.9616 && ran_num<=1) {
			state = 5;  //백도
		} 
		
		return state;
	}
	public int throwDo() {
		state = 0;
		return state;
	}
	public int throwGe() {
		state = 1;
		return state;
	}
	public int throwGul() {
		state = 2;
		return state;
	}
	public int throwYoot() {
		state = 3;
		return state;
	}
	public int throwMo() {
		state = 40;
		return state;
	}
	public int throwBackDo() {
		state = 5;
		return state;
	}
}
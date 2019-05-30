package model;
import java.util.Random;


public class Yut {
	int state;
	
	public int throwYut() {
		Random random = new Random();
		float ran_num = random.nextFloat();
		if(ran_num<=0.1152) {
			state = 0;
		}
		else if(ran_num>0.1152 && ran_num<=0.4608) {
			state = 1;
		}
		else if(ran_num>0.4608 && ran_num<=0.8064) {
			state = 2;
		}
		else if(ran_num>0.8064 && ran_num<=0.936) {
			state = 3;
		}
		else if(ran_num>0.936 && ran_num<=0.9616) {
			state = 4;
		}
		else if(ran_num>0.9616 && ran_num<=1) {
			state = 5;
		}
		
		return state;
	}
}
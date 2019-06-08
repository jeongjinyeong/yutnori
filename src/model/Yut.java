package model;
import java.util.Random;


public class Yut {
	public static final int BACK_DOE = 0;
	public static final int DOE = 1;
	public static final int GAE = 2;
	public static final int GUL = 3;
	public static final int YOOT = 4;
	public static final int MOE = 5;
	public Yut() {
	
	}
	public static int throwYut() {
		Random random = new Random();
		float ran_num = random.nextFloat();
		
		if(ran_num<=0.1152) {
			return DOE;
		}
		else if(ran_num>0.1152 && ran_num<=0.4608) {
			return GAE;
		}
		else if(ran_num>0.4608 && ran_num<=0.8064) {
			return GUL;
		}
		else if(ran_num>0.8064 && ran_num<=0.936) {
			return YOOT;
		}
		else if(ran_num>0.936 && ran_num<=0.9616) {
			return MOE;
		}
		else{
			return BACK_DOE; 
		} 
		
	}
	public int throwDoe() {
		return DOE;
	}
	public int throwGe() {
		return GAE;
	}
	public int throwGul() {
		return GUL;
	}
	public int throwYoot() {
		return YOOT;
	}
	public int throwMoe() {
		return MOE;
	}
	public int throwBackDoe() {
		return BACK_DOE;
	}
}
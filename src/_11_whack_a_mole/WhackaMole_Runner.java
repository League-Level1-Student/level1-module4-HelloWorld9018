package _11_whack_a_mole;

import java.util.Random;

public class WhackaMole_Runner {
public static void main(String[] args) {
	WhackaMole mole = new WhackaMole();


		int ran = new Random().nextInt(9);	
	mole.makeButtons(ran);


	
}
}

package pc.virtual.hardware;

import java.awt.AWTException;

public class Main {
	public static void main(String[] args) throws AWTException {
		vKeyboard vK = new vKeyboard();
		//vK.keyBoardLightRolls(10, 200);
		//vK.demo_a_girl_selling_matches();
		//
		//vK.openTaskmgr();
		//vK.openRunner();
		//vK.inputString("cd D:\\ && D:",200);
		//vK.cmdRunner("cd D:\\ && D:");
		//vK.powershellRunner("date");
		//
		System.out.println("Hello,Human.");
		vK.openCalcToC("999*666-2333");
	}
}

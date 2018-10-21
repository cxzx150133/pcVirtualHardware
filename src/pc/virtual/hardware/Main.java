package pc.virtual.hardware;

import java.awt.AWTException;

public class Main {
  public static void main(String[] args) throws AWTException {
    vKeyboard vK = new vKeyboard();
    vMouse vM = new vMouse();
    System.out.println("Hello,Human.");
    vK.openCalcToC("999*666-2333");
  }
}

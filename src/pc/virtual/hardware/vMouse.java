package pc.virtual.hardware;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.util.Scanner;

public class vMouse {
	private final int DELAY_MS = 1;
	public int getX() throws AWTException {
    return (int)java.awt.MouseInfo.getPointerInfo().getLocation().x;
	}
	public int getY() throws AWTException {
    return (int)java.awt.MouseInfo.getPointerInfo().getLocation().y;
	}
	public void toX(int x) throws AWTException {
	  Robot r = new Robot();
    r.mouseMove(x, getY());
	}
	public void toY(int y) throws AWTException {
	  Robot r = new Robot();
    r.mouseMove(getX(), y);
	}
	public void toXY(int x,int y) throws AWTException {
    Robot r = new Robot();
    r.mouseMove(x, y);
	}
	public void startPlayBall(int num,int x_max,int y_max) {
    int x = 1, y = 1;
    int now = 0;//0~(,),1~(+,+),2~(+,-),3~(-,+),4~(-,-)
		System.out.printf("Ready to start,Estimated time consuming: %.1f s.\n",num*(x_max+y_max)*DELAY_MS/1000.0);
		if (num*(x_max+y_max)*DELAY_MS/1000.0>30) {
			Scanner input = new Scanner(System.in);
			System.out.print("Estimated time consuming exceed the security threshold(30s),Do you want to continue?[Y,n]");
			if (!input.next().equalsIgnoreCase("Y")) {
				System.out.println("The operation is terminated by the user and the program exits.");
				return;
			}
		}
		System.out.println("Start running. Press Ctrl+C to stop running.");
		try {
			Robot r = new Robot();
			for(int i=1;i<num*(x_max+y_max);++i) {
				switch(now) {
					case 0:++x;++y;now=1;break;
					case 1:++x;++y;break;
					case 2:++x;--y;break;
					case 3:--x;++y;break;
					case 4:--x;--y;break;
				}
				r.mouseMove(x, y);
				r.delay(DELAY_MS);
				if (x==1&&y==1)now=1;
				else if (x==x_max&&y==y_max)now=4;
				else if(x==1&&now==3)now=1;
				else if(x==1&&now==4)now=2;
				else if(y==1&&now==2)now=1;
				else if(y==1&&now==4)now=3;
				else if(x==x_max&&now==1)now=3;
				else if(x==x_max&&now==2)now=4;
				else if(y==y_max&&now==1)now=2;
				else if(y==y_max&&now==3)now=4;
			}
		} catch (AWTException e) {
			System.out.println("AWT ERROR");
		}
	}
	public void startPlayBall(int num) {
    startPlayBall(num,getScreenWidth(),getScreenHeight());
	}
  public static int getScreenWidth() {
    return (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
  }
  public static int getScreenHeight() {
    return (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
  }
  public static void test() throws AWTException {
    vMouse m = new vMouse();
    System.out.printf("The mouse coordinates: (%d,%d)\n",m.getX(),m.getY());
    System.out.printf("Screen resolution: %dx%d\n",m.getScreenWidth(),m.getScreenHeight());
    m.startPlayBall(3);
  }
}
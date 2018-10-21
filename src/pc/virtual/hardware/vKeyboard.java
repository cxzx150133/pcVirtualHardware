package pc.virtual.hardware;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class vKeyboard {
  public void keyPressAndRelease(int keycode) throws AWTException {
    Robot r = new Robot();
    r.keyPress(keycode);
    r.keyRelease(keycode);
  }
  
  private boolean isOneKey(char ch) {
    if (Character.isWhitespace(ch)||Character.isLowerCase(ch)||Character.isDigit(ch)) {
      return true;
    } else if (Character.isUpperCase(ch)){
      return false;
    } else {
      switch (ch) {
        case '`':case '-':case '=':
        case '[':case ']':case '\\':
        case ';':case '\'':
        case ',':case '.':case '/':
          return true;
      }
      return false;
    }
  }
  private int charToKey(char ch) {
    switch (ch) {
      case '~' : ch='`'; break;
      case '!' : ch='1'; break;
      case '@' : ch='2'; break;
      case '#' : ch='3'; break;
      case '$' : ch='4'; break;
      case '%' : ch='5'; break;
      case '^' : ch='6'; break;
      case '&' : ch='7'; break;
      case '*' : ch='8'; break;
      case '(' : ch='9'; break;
      case ')' : ch='0'; break;
      case '_' : ch='-'; break;
      case '+' : ch='='; break;
      case '{' : ch='['; break;
      case '}' : ch=']'; break;
      case '|' : ch='\\';break;
      case ':' : ch=';'; break;
      case '"' : ch='\'';break;
      case '<' : ch=','; break;
      case '>' : ch='.'; break;
      case '?' : ch='/'; break;
      default :
    }
    return KeyEvent.getExtendedKeyCodeForChar(ch);
  }
  private int randnum(int min,int max) {
    return (int) (Math.random() * (max-min+1))+min;
  }
  public void inputChar(char ch,int delay_ms) throws AWTException {
    Robot r = new Robot();
    if (isOneKey(ch)) {
      keyPressAndRelease(charToKey(ch));
    } else {
      r.keyPress(KeyEvent.VK_SHIFT);
      keyPressAndRelease(charToKey(ch));
      r.keyRelease(KeyEvent.VK_SHIFT);
    }
    r.delay(delay_ms);
  }
  public void inputString(String s,int delay_ms) throws AWTException {
    char[] con = s.toCharArray();
    for (char c:con) {
      inputChar(c,delay_ms);
    }
  }
  public void inputString(String s,int delay_ms_min,int delay_ms_max) throws AWTException {
    char[] con = s.toCharArray();
    for (char c:con) {
      inputChar(c,randnum(delay_ms_min, delay_ms_max));
    }
  }
  public void test() throws AWTException {
    for (char i=' ';i<='~';++i) {
      inputChar(i,20);
      inputChar(',', 20);
      System.out.print(Character.toString(i)+',');
      // ,!,",#,$,%,&,',(,),*,+,,,-,.,/,0,1,2,3,4,5,6,7,8,9,:,;,<,=,>,?,@,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,[,\,],^,_,`,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,{,|,},~,
    }
    System.out.println();
  }
  public void keyBoardLightRolls(int num,int delay_ms) throws AWTException {
    Robot r = new Robot();
    for(int i = 1;i<=num*2;++i) {
      keyPressAndRelease(KeyEvent.VK_NUM_LOCK);
      r.delay(delay_ms);
      keyPressAndRelease(KeyEvent.VK_CAPS_LOCK);
      r.delay(delay_ms);
      keyPressAndRelease(KeyEvent.VK_SCROLL_LOCK);
      r.delay(delay_ms);
    }
  }
  public void demo_a_girl_selling_matches() throws AWTException {
    String content = 
        "Once upon a time a little girl tried to make a living by selling matches in the "+
        "street. It was New Year's Eve and the snowed streets were deserted. From brightly "+
        "lit windows came the tinkle of laughter and the sound of singing. People were "+
        "getting ready to bring in the new year. But the poor little match seller sat "+
        "sadly beside the fountain. Her ragged dress and worn shawl did not keep out the "+
        "cold and she tried to keep her bare feet from touching the frozen ground. She "+
        "hadn't sold one box of matches all day and she was frightened to go home, for "+
        "her father would certainly be angry. It wouldn't be much warmer anyway, in the "+
        "draughty attic that was her home. The little girl's fingers were stiff with cold. "+
        "If only she could light a match! But what would her father say at such a waste. "+
        "Falteringly she took out a match and lit it. What a nice warm flame! The little "+
        "match seller cupped her hand over it, and as she did so, she magically saw in its "+
        "light a big brightly burning stove. She held out her hands to the heat, but just "+
        "then the match went out and the vision faded. The night seemed blacker than before "+
        "and it was getting colder. A shiver ran through the little girl's thin body. After "+
        "hesitating for a long time, she struck another match on the wall, and this time, "+
        "the glimmer turned the wall into a great sheet of crystal. Beyond that stood a fine "+
        "table laden with food and lit by a candlestick. Holding out her arms towards the "+
        "plates, the little match seller seemed to pass through the glass, but then the match "+
        "went out and the magic faded. Poor thing: in just a few seconds she had caught a "+
        "glimpse of everything that life had denied her: warmth and good things to eat. "+
        "Her eyes filled with tears and she lifted her gaze to the lit windows, praying that "+
        "she too might know a little of such happiness. She lit the third match and an even "+
        "more wonderful thing happened. There stood a Christmas tree hung with hundreds "+
        "of candles, glittering with tinsel and coloured balls. \"Oh, how lovely!\" exclaimed "+
        "the little match seller, holding up the match. Then, the match burned her finger "+
        "and flickered out. The light from the Christmas candles rose higher and higher. "+
        "Then one of the lights fell, leaving a trail behind it. \"Someone is dying,\" "+
        "murmured the little girl, as she remembered her beloved Granny who used to "+
        "say: \"When a star falls, a heart stops beating!\" Scarcely aware of what she was "+
        "doing, the little match seller lit another match. This time, she saw her grandmother. "+
        "A cold day dawned and a pale sun shone on the fountain and the icy road. Close by "+
        "lay the lifeless body of a little girl surrounded by spent matches. \"Poor little "+
        "thing!\" Exclaimed the passersby. She was trying to keep warm. ";
    Robot r = new Robot();
    r.delay(2*1000);
    inputString(content, 100, 200);
  }
  public void openTaskmgr() throws AWTException {
    Robot r = new Robot();
    r.keyPress(KeyEvent.VK_CONTROL);
    r.keyPress(KeyEvent.VK_SHIFT);
    r.keyPress(KeyEvent.VK_ESCAPE);
    r.keyRelease(KeyEvent.VK_CONTROL);
    r.keyRelease(KeyEvent.VK_SHIFT);
    r.keyRelease(KeyEvent.VK_ESCAPE);
  }
  public void openRunner() throws AWTException {
    Robot r = new Robot();
    r.keyPress(KeyEvent.VK_WINDOWS);
    r.keyPress(KeyEvent.VK_R);
    r.keyRelease(KeyEvent.VK_WINDOWS);
    r.keyRelease(KeyEvent.VK_R);
  }
  public void cmdRunner(String s) throws AWTException {
    Robot r = new Robot();
    int load_ms = 300;
    int delay_ms = 200;
    openRunner();
    r.delay(load_ms);
    inputString("cmd", delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
    r.delay(load_ms);
    
    inputString(s, delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
  }
  public void cmdRunner(String s,int load_ms) throws AWTException {
    Robot r = new Robot();
    int delay_ms = 200;
    openRunner();
    r.delay(load_ms);
    inputString("cmd", delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
    r.delay(load_ms);
    
    inputString(s, delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
  }
  public void cmdRunner(String s,int load_ms,int delay_ms) throws AWTException {
    Robot r = new Robot();
    openRunner();
    r.delay(load_ms);
    inputString("cmd", delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
    r.delay(load_ms);
    
    inputString(s, delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
  }

  public void powershellRunner(String s) throws AWTException {
    Robot r = new Robot();
    int load_ms = 300;
    int delay_ms = 200;
    openRunner();
    r.delay(load_ms);
    inputString("powershell", delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
    r.delay(load_ms);
    
    inputString(s, delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
  }
  public void powershellRunner(String s,int load_ms) throws AWTException {
    Robot r = new Robot();
    int delay_ms = 200;
    openRunner();
    r.delay(load_ms);
    inputString("powershell", delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
    r.delay(load_ms);
    
    inputString(s, delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
  }
  public void powershellRunner(String s,int load_ms,int delay_ms) throws AWTException {
    Robot r = new Robot();
    openRunner();
    r.delay(load_ms);
    inputString("powershell", delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
    r.delay(load_ms);
    
    inputString(s, delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
  }
  
  public void openCalc() throws AWTException {
    int load_ms = 300;
    int delay_ms = 200;
    Robot r = new Robot();
    
    openRunner();
    r.delay(load_ms);
    inputString("calc", delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
  }
  public void openCalc(int type) throws AWTException {
    int load_ms = 600;
    int delay_ms = 200;
    Robot r = new Robot();
    
    openRunner();
    r.delay(load_ms);
    inputString("calc", delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
    switch(type) {
      case 1:type=KeyEvent.VK_1;break;
      case 2:type=KeyEvent.VK_2;break;
      case 3:type=KeyEvent.VK_3;break;
    }
    r.delay(load_ms);
    r.keyPress(KeyEvent.VK_ALT);
    r.keyPress(type);
    r.keyRelease(KeyEvent.VK_ALT);
    r.keyRelease(type);
  }
  public void openCalcToC(String s) throws AWTException {
    int load_ms = 600;
    int delay_ms = 200;
    Robot r = new Robot();
    
    openRunner();
    r.delay(load_ms);
    inputString("calc", delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);

    r.delay(load_ms);
    inputString(s, delay_ms);
    keyPressAndRelease(KeyEvent.VK_ENTER);
  }
}

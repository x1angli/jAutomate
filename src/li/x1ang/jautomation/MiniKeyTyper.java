package li.x1ang.jautomation;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * @author x1ang.li
 * 
 * This Java Class is used to automatically iterate through all coupon codes within specified range.
 * One day, I got a coupon code for a merchant. But the paper on which the code is printed was damaged,
 * thus there was one digit illegible. To solve the problem, I wrote this Java Class. It works like
 * a brute-force password cracker by trying all possible combinations within the range. Since most
 * coupon code input box are segmented, it mimics the keyboard actions by automatically put in the
 * code.
 *
 */
public class MiniKeyTyper {
    private final String PREFIX = "f384";
    private final String SUFFIX = "764663c81d1";
    private final int BREAK_TIME = 4 * 1000; // You need to take a break between each iteration to do something like clicking the "Confirm" button and suppress error messages.    

    private Robot robot;
    
    public MiniKeyTyper() throws AWTException {
        robot = new Robot();
    }

    public void run() {
        System.out.println("I am running");
        robot.delay(3000);
        for (int i=0; i<=9; i++) {
            string code_i = PREFIX + i + SUFFIX
            System.out.println("We are about to type the code:" + code_i);
            type(code_i);
            robot.delay(BREAK_TIME);
        }
        System.out.println("I am finished running.");
    }
    
    private void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            
            // keycode handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123)
                code = code - 32;
                
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }

    public static void main(String[] args) {
        MiniKeyTyper main;
        try {
            main = new MiniKeyTyper();
            main.run();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}

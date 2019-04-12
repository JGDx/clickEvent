import java.awt.*;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static long oldTime=System.currentTimeMillis();
    public static long newTime=System.currentTimeMillis();
    public static void main(String[] args) {
        //启动线程
        new Thread(new Thread1()).start();
    }
    //鼠标点击事件
    public static void click(){
        Robot robot=null;
        try{
            robot=new Robot();
        }catch(AWTException e){
            e.printStackTrace();
        }
        robot.mouseMove(1000,0);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mouseMove(500,0);
    }
    //线程控制鼠标点击间隔
    private static class Thread1 implements Runnable{
        @Override
        public void run(){
            synchronized (Main.class){
                while(true){
                    newTime=System.currentTimeMillis();
                    if((newTime-60000)>oldTime){
                        click();
                        oldTime=newTime;
                    }
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}

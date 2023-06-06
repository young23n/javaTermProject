/*
 * @todo 게임 진행화면 배경음, 배경화면 구현, 현재 점수 출력제어, 배경음
 *  */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class playScreen extends JFrame{
    Toolkit imageTool = Toolkit.getDefaultToolkit();
    Image bird = imageTool.getImage("resource/Images/characterSprite/BirdMiddle.png");
    Image backgroundImage = imageTool.getImage("resource/Images/BackGround.png");
    Image buffImg;
    Graphics buffG;
    int birdY = 120;//더블 버퍼링 구현

    public playScreen(){
        setTitle("test");
        setResizable(false);

        Container c = getContentPane();
        runnable run = new runnable();

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {//클릭시 상승
                birdY -= 15;
            }
        });



        setSize(144,256);
        setVisible(true); // 프레임 보이기;
        run.start();

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(backgroundImage,0,0,this);
        g.drawImage(bird, 30,birdY,this);

    }
    class runnable extends Thread{
        @Override
        public void run() {// 중력구현 ,파이프 전진
            try{
                while(true){
                    birdY += 1;
                    repaint();
                    Thread.sleep(25);
                }
            }catch(Exception e){
                return;
            }
        }
    }
}

/*
 * @todo 파이프 출력 후 상태확인 -> pipe 스프라이트를 3가지 형태에 맞게 추가 ,수정
 *  */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class playScreen extends JFrame{
    Toolkit imageTool = Toolkit.getDefaultToolkit();
    Image bird = imageTool.getImage("resource/Images/characterSprite/BirdMiddle.png");
    Image background_sky = imageTool.getImage("resource/Images/BackGround.png");
    Image background_ground = imageTool.getImage("resource/Images/background_ground.png");
    Image pipeDown = imageTool.getImage("resource/Images/PipeImages/pipeDown.png");
    Image pipeUp = imageTool.getImage("resource/Images/PipeImages/pipeUp.png");
    Image buffImg;
    Graphics buffG;
    int birdY = 120;//더블 버퍼링 구현

    //위아래 한 세트의 3종류의 파이프 장애물 구현

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
        buffImg = createImage(getWidth(),getHeight());//버퍼링 이미지
        buffG = buffImg.getGraphics();
        update(g);

    }
    public void update(Graphics g){
        buffG.clearRect(0,0,144,256);//버퍼링 이미지 초기화
        //버퍼링에 그리기
        buffG.drawImage(background_sky,0,0,this);
        buffG.drawImage(background_ground,0,200,this);
        buffG.drawImage(pipeDown,50,40,this);
        buffG.drawImage(bird, 30,birdY,this);
        //버퍼링에 그린 것을 출력
        g.drawImage(buffImg,0,0,this);
        repaint();
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

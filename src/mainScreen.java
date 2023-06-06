/*
 * @todo 메인 화면 버튼으로 플레이화면, 점수화면 접근 구현
 * @todo 배경구현
 * */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mainScreen extends JFrame{
    ImageIcon startIcon = new ImageIcon("resource/Images/ButtonImages/startButton.png");
    ImageIcon scoreIcon = new ImageIcon("resource/Images/ButtonImages/scoreButton.png");
    ImageIcon backgroundIcon = new ImageIcon("resource/Images/BackGround.png");
    ImageIcon TitleIcon = new ImageIcon("resource/Images/TitleImage/FlappyBirdTitle.png");
    JPanel panel = new DrawBackground();
    public mainScreen(){
        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);//창의 크기 변경을 불가능하게 함
        setContentPane(panel);
        Container c = getContentPane();
        c.setLayout(null);

        JButton startB = new JButton(startIcon);
        JButton scoreB = new JButton(scoreIcon);
        // 이미지만 나오도록 버튼을 투명하게 설정
        startB.setBorderPainted(false);
        scoreB.setBorderPainted(false);
        startB.setContentAreaFilled(false);
        scoreB.setContentAreaFilled(false);
        startB.setFocusPainted(false);
        scoreB.setFocusPainted(false);

        //이미지 형식에 맞게 설정
        startB.setSize(52,29);
        scoreB.setSize(52,29);
        startB.setLocation(70, 310);
        scoreB.setLocation(150, 310);
        startB.addMouseListener(new MouseAdapter() {//게임화면으로 바꾸기
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        scoreB.addMouseListener(new MouseAdapter() {//점수 화면으로 바꾸기
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        c.add(startB);
        c.add(scoreB);

        setSize(144, 256);
        setVisible(true);
    }
    public class DrawBackground extends JPanel{
        public void paintComponent(Graphics g){
            g.drawImage(backgroundIcon.getImage(),0,0,this);
            g.drawImage(TitleIcon.getImage(), 92,100,this);
        }
    }

    class playSound extends Thread{

    }
}


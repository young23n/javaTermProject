/*
 *
 * @todo 스코어 화면 기능 폐기, 최고 점수 한개만 playScreen에 출력예정
 * @todo 폐기된 기능에 따라 버튼 수정, 프레임 size 크기 변경에 따른 스프라이트 위치 수정, ImageIcon -> Image로 수정
 * */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mainScreen extends JFrame{
    Toolkit imageTool = Toolkit.getDefaultToolkit();
    ImageIcon startButtonImage = new ImageIcon("resource/Images/ButtonImages/startButton.png");
    Image backgroundImage = imageTool.getImage("resource/Images/BackGround.png");
    Image TitleImage = imageTool.getImage("resource/Images/TitleImage/FlappyBirdTitle.png");

    JPanel panel = new DrawBackground();
    public mainScreen(){
        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);//창의 크기 변경을 불가능하게 함
        setContentPane(panel);
        Container c = getContentPane();
        c.setLayout(null);

        JButton startB = new JButton(startButtonImage);
        // 이미지만 나오도록 버튼을 투명하게 설정
        startB.setBorderPainted(false);
        startB.setContentAreaFilled(false);
        startB.setFocusPainted(false);

        //이미지 형식에 맞게 설정
        startB.setSize(52,29);
        startB.setLocation(40, 140);
        startB.addMouseListener(new MouseAdapter() {//게임화면으로 바꾸기
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        c.add(startB);

        setSize(144, 256);
        setVisible(true);
    }
    public class DrawBackground extends JPanel{
        public void paintComponent(Graphics g){
            g.drawImage(backgroundImage,0,0,this);
            g.drawImage(TitleImage, 22,50,this);
        }
    }
}


/*
 * @todo 메인 화면 버튼으로 플레이화면, 점수화면 접근 구현
 * */
import javax.swing.*;
import java.awt.*;

public class mainScreen extends JFrame{
    public mainScreen(){
        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);//창의 크기 변경을 불가능하게 함
        setLocationRelativeTo(null);//창이 가운데 나게함
        Container c = getContentPane();

        ImageIcon startIcon = new ImageIcon("resource/Images/ButtonImage/startButton.png");
        ImageIcon scoreIcon = new ImageIcon("resource/Images/ButtonImage/scoreButton.png");


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
        startB.setLocation(70, 120);
        scoreB.setLocation(150, 120);
        c.add(startB);
        c.add(scoreB);

        setSize(288, 255);
        setVisible(true);
    }

}

/*
 * @todo 메인 화면 버튼으로 플레이화면, 점수화면 접근 구현
 * */
import javax.swing.*;
import java.awt.*;

public class mainScreen extends JFrame{
    public mainScreen(){
        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(null);

        JButton jb = new JButton("test");
        JButton jb2 = new JButton("test2");
        jb.setLocation(200, 300);
        jb.setLocation(300, 300);
        c.add(jb);
        c.add(jb2);

        setSize(400, 600);
        setVisible(true);
    }

}

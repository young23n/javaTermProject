/*
 * @todo 점수 이미지 추가, 점수 증가 메커니즘 구현, one.png 해상도 변경
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class playScreen extends JFrame{
    Toolkit imageTool = Toolkit.getDefaultToolkit();
    Image birdImage = imageTool.getImage("resource/Images/characterSprite/BirdMiddle.png");
    Image background_sky = imageTool.getImage("resource/Images/BackGround.png");
    Image background_ground = imageTool.getImage("resource/Images/background_ground.png");
    Image getReadyTitle = imageTool.getImage("resource/Images/TitleImage/getReadyTitle.png");
    Image pipeDown = imageTool.getImage("resource/Images/PipeImages/pipeDown.png");
    Image pipeUp = imageTool.getImage("resource/Images/PipeImages/pipeUp.png");
    Image buffImg;
    Graphics buffG;
    boolean runCheck = false;//클릭시 run.start()가 한번만 호출되도록 확인
    int[] randomIndex(){ // 랜덤으로 인덱스 번호를 선택
        int[] random= new int[3];
        for(int i =0; i < 3;i++){
            random[i] = (int)(Math.random()*3);
            for(int j = 0; j < i; j++){
                if(random[i] == random[j]){
                    i--;
                }
            }
        }
        return random;
    }
    int[] index = randomIndex();
    int posX[] = {80, 180, 280};
    int score = 0;

    //위아래 한 세트의 3종류의 파이프 장애물 구현 gameObject 배열 생성해서 초기값 입력
    // 1 2 3 순으로 중단, 상단, 하단 장애물
    gameObject[] pipeUpSide = {
            new gameObject(posX[index[0]],-60,26,160,pipeUp),
            new gameObject(posX[index[1]],-100,26,160,pipeUp),
            new gameObject(posX[index[2]],-40,26,160,pipeUp),

            };
    gameObject[] pipeDownSide = {
            new gameObject(posX[index[0]],150,26,160,pipeDown),
            new gameObject(posX[index[1]],110,26,160,pipeDown),
            new gameObject(posX[index[2]],170,26,160,pipeDown),

            };

    gameObject titleObjectReady = new gameObject(30, 70,0,0,getReadyTitle);
    gameObject bird = new gameObject(30,120,12,17,birdImage);

    //점수 이미지
    scoreObject score1place = new scoreObject(120,40);
    scoreObject score2place = new scoreObject(100,40);

    public playScreen(){
        setTitle("test");
        setResizable(false);
        setSize(144,256);
        setVisible(true); // 프레임 보이기;

        Container c = getContentPane();
        runnable run = new runnable();

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {//클릭시 bird 상승 & 게임 진행
                if(runCheck == false){
                    run.start();
                    titleObjectReady.x = 300;// 타이틀 숨기기
                    runCheck = true;
                }
                bird.y -= 15;
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        buffImg = createImage(getWidth(),getHeight());//버퍼링 이미지
        buffG = buffImg.getGraphics();
        update(g); //호출

    }
    public void update(Graphics g){
        buffG.clearRect(0,0,144,256);//버퍼링 이미지 초기화
        //버퍼링에 그리기
        buffG.drawImage(background_sky,0,0,this);

        buffG.drawImage(pipeDown,pipeDownSide[0].x,pipeDownSide[0].y,this); //이미지는 하나만 사용하기에 개인으로 주지않음 좌표는 개개인
        buffG.drawImage(pipeDown,pipeDownSide[1].x,pipeDownSide[1].y,this);
        buffG.drawImage(pipeDown,pipeDownSide[2].x,pipeDownSide[2].y,this);

        buffG.drawImage(background_ground,0,200,this);

        buffG.drawImage(pipeUp,pipeUpSide[0].x,pipeUpSide[0].y,this);
        buffG.drawImage(pipeUp,pipeUpSide[1].x,pipeUpSide[1].y,this);
        buffG.drawImage(pipeUp,pipeUpSide[2].x,pipeUpSide[2].y,this);

        buffG.drawImage(score1place.getImage(), score1place.x, score1place.y,this);
        buffG.drawImage(score2place.getImage(), score2place.x, score2place.y,this);

        buffG.drawImage(getReadyTitle,titleObjectReady.x, titleObjectReady.y, this); //ready 타이틀 띄우기
        buffG.drawImage(birdImage, bird.x,bird.y,this);
        //버퍼링에 그린 것을 출력
        g.drawImage(buffImg,0,0,this);
        repaint();
    }

    class runnable extends Thread{
        @Override
        public void run() {// 중력구현 ,파이프 전진
            try{
                while(true){
                    bird.y += 1; //중력
                    pipeUpSide[0].move();// 파이프 움직임
                    pipeDownSide[0].move();
                    pipeUpSide[1].move();// 파이프 움직임
                    pipeDownSide[1].move();
                    pipeUpSide[2].move();// 파이프 움직임
                    pipeDownSide[2].move();
                    //위쪽 파이프 하나만 검사해서 맵밖으로 넘어가면 앞으로 재배치
                    if(pipeUpSide[0].x == -26){
                        pipeUpSide[0].relocation();
                        pipeDownSide[0].relocation();
                    }
                    if(pipeUpSide[1].x == -26){
                        pipeUpSide[1].relocation();
                        pipeDownSide[1].relocation();
                    }
                    if(pipeUpSide[2].x == -26){
                        pipeUpSide[2].relocation();
                        pipeDownSide[2].relocation();
                    }
                    if(pipeUpSide[0].x == bird.x){
                        score++;
                    }
                    if(pipeUpSide[1].x == bird.x){
                        score++;

                    }
                    if(pipeUpSide[2].x == bird.x){
                        score++;
                    }
                    score1place.getScore(score);
                    score1place.setScore1place();
                    score2place.getScore(score);
                    score2place.setScore2place();
                    repaint();
                    Thread.sleep(19);
                }
            }catch(Exception e){
                return;
            }
        }
    }
}

import java.awt.*;

public class scoreObject extends gameObject{
    Toolkit imageTool = Toolkit.getDefaultToolkit();
    Image[] scoreImages = {
            imageTool.getImage("resource/Images/NumberImages/zero.png"),
            imageTool.getImage("resource/Images/NumberImages/one.png"),
            imageTool.getImage("resource/Images/NumberImages/two.png"),
            imageTool.getImage("resource/Images/NumberImages/three.png"),
            imageTool.getImage("resource/Images/NumberImages/four.png"),
            imageTool.getImage("resource/Images/NumberImages/five.png"),
            imageTool.getImage("resource/Images/NumberImages/six.png"),
            imageTool.getImage("resource/Images/NumberImages/seven.png"),
            imageTool.getImage("resource/Images/NumberImages/eight.png"),
            imageTool.getImage("resource/Images/NumberImages/nine.png"),
    };
    int score;
    scoreObject(int x, int y){
        this.x = x;
        this.y = y;
        img = scoreImages[0];
    }

    void getScore(int score){
        this.score = score;
    }
    Image getImage(){return img;}
    void setScore1place(){
        if(score % 10 == 0){img = scoreImages[0];}
        else if(score % 10 == 1){img = scoreImages[1];}
        else if(score % 10 == 2){img = scoreImages[2];}
        else if(score % 10 == 3){img = scoreImages[3];}
        else if(score % 10 == 4){img = scoreImages[4];}
        else if(score % 10 == 5){img = scoreImages[5];}
        else if(score % 10 == 6){img = scoreImages[6];}
        else if(score % 10 == 7){img = scoreImages[7];}
        else if(score % 10 == 8){img = scoreImages[8];}
        else if(score % 10 == 9){img = scoreImages[9];}
    }
    void setScore2place(){
        if(score / 10 == 1){img = scoreImages[1];}
        else if(score / 10 == 2){img = scoreImages[2];}
        else if(score / 10 == 3){img = scoreImages[3];}
        else if(score / 10 == 4){img = scoreImages[4];}
        else if(score / 10 == 5){img = scoreImages[5];}
        else if(score / 10 == 6){img = scoreImages[6];}
        else if(score / 10 == 7){img = scoreImages[7];}
        else if(score / 10 == 8){img = scoreImages[8];}
        else if(score / 10 == 9){img = scoreImages[9];}
    }
}

/*
* @todo game object 관리, 충돌 관리
* */
import java.awt.*;

public class gameObject {

        int x;
        int y;
        int high;
        int width;
        Image img;
        gameObject(int x, int y, int high, int width, Image img){
            this.x = x;
            this.y = y;
            this.high = high;
            this.width = width;
            this.img = img;
        }
    /**
     * 반복적인 호출을 통해 파이프 개체를 움직이는 용도
     */
         void move(){
             x -= 1;
         }

    /**
     * pipe가 맵 밖으로 이동시 장애물 재배치를 랜덤으로 해주는 함수
     */
    void relocation(){
        x = 283;
    }


}


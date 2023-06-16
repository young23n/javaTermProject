// object 충돌 관리및 패배조건 반환
public class gameOver extends gameObject {
    boolean gameoverCheck = false;
    /**
     * 충돌 감지 메서드
     * @param bird 새
     * @param pipe 파이프
     */
    void objectCrash(gameObject bird, gameObject pipe){
        if((((bird.x <= pipe.x && pipe.x <= bird.x + bird.width) || (bird.x <= pipe.x + pipe.width && pipe.x + pipe.width <= bird.x + bird.width)) // x범위 pipe사이에 새 값이 들어올 때
                && ((pipe.y <= bird.y && bird.y <= pipe.y + pipe.high) || (pipe.y <= bird.y + bird.high && bird.y + bird.high <= pipe.y + pipe.high))) // Y 범위
                || bird.y > 188) { // 땅에 붙었을 때
            gameoverCheck = true;

            /**
             * 기존에 true false 반환을 통해 했는데 작동이 pipe의 마지막 인덱스만 작동을 함
             * 변경된 값을 저장 후 전달하니 모두 작동됨 스레드와 연관된 것 같은데 이유를 잘 모르겠음
             **/
        }
    }
}

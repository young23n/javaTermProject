import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

    }
    public class mainScreen{}// 실행시 메인화면,버튼을 통한 플레이화면 랭킹화면 진입 가능, 배경음, 타이틀 객체 애니메이션 제어
    public class scoreScreen{}//점수 화면 1-3등 기록 플레이 할 때 기록 저장(파일 입출력으로 기록 저장(저장은 게임오버 시))
    public class playScreen{} // 게임 진행화면 배경음, 배경화면 구현, 현재 점수 출력제어
    public class pipe {} // 플레이시 생성되는 장애물 고정된 한 세트(위 아래 2개 객체)가 랜덤으로 츨력, 캐릭터와 충돌 감지
    public class userCharactor{} // 캐릭터 생성, 캐릭터 이미지, 캐릭터가 받는 중력, 클릭시 점프 구현
    public class gameOver{} // 패배조건 달성시 화면 구현 playScreen 위에 띄울 화면 구현, 현재 점수 저장
    public class run{}// 실행
}
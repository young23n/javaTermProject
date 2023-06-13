import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/*
* @todo 메인, 플레이 배경음, 클릭시 점프 소리, 게임오버 소리
*
* */
public class Sound {
    private Clip clip;
    private Clip wingClip;
    AudioInputStream audioStream;
    File MAIN_BACKGROUND = new File("resource/sounds/MainScreenSound.wav");
    File PLAY_BACKGOUND = new File("resource/sounds/playScreenSound.wav");
    private File WING = new File("resource/sounds/wingSound.wav");
    File GAME_OVER = new File("resource/sounds/gameOverSound.wav");

    /**
     * 배경음 재생
     */
    public void loadSound(File file, boolean checkLoop){
        try{
            clip = AudioSystem.getClip();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioStream);
            if(checkLoop){clip.loop(1000);}
            else{
                clip.start();
            }
        }catch(LineUnavailableException e){e.printStackTrace();}
        catch(UnsupportedAudioFileException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
    }

    /**
     * 날개 사운드 분리한 이유는 반복성이 너무 짙어서 다른 사운드에 영향을 많이 줌
     */
    public void setWingSound(){
        try{
            wingClip = AudioSystem.getClip();
            audioStream = AudioSystem.getAudioInputStream(WING);
            wingClip.open(audioStream);
        }catch(LineUnavailableException e){e.printStackTrace();}
            catch(UnsupportedAudioFileException e){e.printStackTrace();}
            catch(IOException e){e.printStackTrace();}
    }
    public void playWingSound(){
        wingClip.setFramePosition(0);
        wingClip.start();
    }
    public void stopSound(){
        clip.stop();
    }
}

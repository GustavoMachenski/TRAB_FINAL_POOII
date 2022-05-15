package util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import modelo.Musica;


public class ClassPlayer {
    List<Musica> musicas;
    int cont = 0;
    Clip clip;
    long clipTimePosition = 0;
    boolean repetirPlaylist = false;
    boolean repetirMusica = false;
    
    public ClassPlayer(List<Musica> musicas) {
        this.musicas = musicas;
    }
    
    public String getMusicName(){
        return musicas.get(cont).getNome();
    }
    
    public void setRepetirPlaylist(Boolean repetir){
        this.repetirPlaylist = repetir;
    }
    
    public void setRepetirMusica(Boolean repetir){
        this.repetirMusica = repetir;
    }
    
    public Boolean getRepetirPlaylist(){
        return this.repetirPlaylist;
    }
    
    public Boolean getRepetirMusica(){
        return this.repetirPlaylist;
    }
     
    public void playMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        if (clipTimePosition ==0) {
            File musicPath = new File(musicas.get(cont).getCaminho());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            this.clip = clip;
            clip.open(audioInput);
            clip.start();
        } else {
            File musicPath = new File(musicas.get(cont).getCaminho());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            this.clip = clip;
            clip.open(audioInput);
            clip.setMicrosecondPosition(clipTimePosition);
            clip.start();
            clipTimePosition = 0;
        }
        
    }
    public void pauseMusic(){
        clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();
    }
    
    public void passMusic(){
        try {
            cont++;
            this.clip.stop();
            if((cont>musicas.size() - 1) & (this.repetirPlaylist)){
                cont =0;
                playMusic();
            } else {
                playMusic();
            }
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void returnMusic(){
        try {
            cont--;
            this.clip.stop();
            if((cont < 0) & (this.repetirPlaylist)){
                cont = musicas.size()-1;
                playMusic();
            } else {
                playMusic();
            }
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void iniciar(){
        for(int i=0; i<this.musicas.size(); i++){
            try {
                playMusic();
                while(!clip.isRunning()){
                    cont++;
                }
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void aleatorio(){
        Collections.shuffle(this.musicas);
    }
    
    public void exit(){
        this.clip.stop();
    }
    
    
    
    
}



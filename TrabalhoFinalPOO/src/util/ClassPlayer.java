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
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import modelo.Musica;
import visao.TelaPlayer;

public class ClassPlayer {

    List<Musica> musicas;
    int cont = 0;
    Clip clip;
    long clipTimePosition = 0;
    boolean repetirPlaylist = false;
    boolean repetirMusica = false;
    boolean pause = false;
    boolean btRETPAS = false;
    TelaPlayer frame;

    public ClassPlayer(List<Musica> musicas, TelaPlayer frame) {
        this.musicas = musicas;
        this.frame = frame;
    }

    public String getMusicName() {
        return musicas.get(cont).getNomeCompleto();
    }

    public void setRepetirPlaylist(Boolean repetir) {
        this.repetirPlaylist = repetir;
    }

    public void setRepetirMusica(Boolean repetir) {
        this.repetirMusica = repetir;
    }

    public Boolean getRepetirPlaylist() {
        return this.repetirPlaylist;
    }

    public Boolean getRepetirMusica() {
        return this.repetirMusica;
    }

    public void playMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (clipTimePosition == 0) {
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
        this.clip.addLineListener(event -> {
            if ((event.getType() == LineEvent.Type.STOP) && (!this.pause) &&(!this.btRETPAS)) {              
                    this.passMusic();
            }
        });
        this.pause = false;
        this.btRETPAS = false;
        frame.setNomeMusica(getMusicName());
    }

    public void pauseMusic() {
        clipTimePosition = clip.getMicrosecondPosition();
        this.pause = true;
        clip.stop();
    }

    public void passMusic() {
        this.btRETPAS = true;
        try {

            if (this.repetirMusica) {
                this.clip.stop();
                playMusic();
            } else {
                cont++;
                if ((cont > musicas.size() - 1) & (this.repetirPlaylist)) {
                    cont = 0;
                    this.clip.stop();
                    playMusic();
                } else {
                    if ((cont > musicas.size() - 1) & (!this.repetirPlaylist)) {
                        cont = 0;
                        this.frame.dispose();

                    } else {
                        this.clip.stop();
                        playMusic();
                    }
                }
            }
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void returnMusic() {
        this.btRETPAS = true;
        try {
            if (this.repetirMusica) {
                this.clip.stop();
                playMusic();
            } else {
                cont--;
                if ((cont < 0) & (this.repetirPlaylist)) {
                    cont = musicas.size() - 1;
                    this.clip.stop();
                    playMusic();
                } else {
                    if ((cont < 0) & (!this.repetirPlaylist)) {
                        cont = musicas.size() - 1;
                        this.frame.dispose();
                    } else {
                        this.clip.stop();
                        playMusic();
                    }
                }
            }
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void aleatorio() {
        this.btRETPAS = true;
        this.clip.stop();
        Collections.shuffle(this.musicas);
    }

    public void exit() {
        this.btRETPAS = true;
        this.clip.stop();
    }

}


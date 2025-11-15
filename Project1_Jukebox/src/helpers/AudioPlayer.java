package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
	private ArrayList<String> songs;
	private Clip currentSong;
	
	public AudioPlayer(String songList) {
		songs = new ArrayList<>();
		getSongData(songList);
	}
	
	//Plays MP3 and Midis
	private Clip getAudioClip(String path) {
		InputStream url = getClass().getResourceAsStream(path);
		AudioInputStream audio;
		
		try {
			audio = AudioSystem.getAudioInputStream(url);
			AudioInputStream ais = audio;
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED,
				baseFormat.getSampleRate(),
				16,
				baseFormat.getChannels(),
				baseFormat.getChannels() * 2,
				baseFormat.getSampleRate(),
				false
			);
			
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			Clip audioClip = AudioSystem.getClip();
			audioClip.open(dais);
			return audioClip;
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//Plays WAV files only
	private Clip getWavClip(String path) {
		URL url = getClass().getResource(path + ".wav");
		AudioInputStream audio;
		
		try {
			audio = AudioSystem.getAudioInputStream(url);
			Clip audioClip = AudioSystem.getClip();
			audioClip.open(audio);
			return audioClip;
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Clip playSong(short id) {
		//Variables for splitting the file
		String fileParts[] = songs.get(id).split("\\.");
		String extension = fileParts[1];
		Clip clip;
		
		//Plays a song based on the audio file
		if(extension != "wav") {
			clip = getAudioClip(fileParts[0] + "." + extension);//(folderName, songName, "." + extension);			
		} else {
			clip = getWavClip(fileParts[0]);
		}
		if(clip != null) {
			clip.start();
			//clip.loop(99);
		}
		
		currentSong = clip;
		return clip;
	}
	
	public void playTunes() {
		stopMusic();
		for(short i = 0; i < songs.size(); i++) {
			Clip current = playSong(i);
			String songParts[] = songs.get(i).substring(1).split("/");
			String currentSong = songParts[1];
			System.out.println("Playing song: " + currentSong);
			while(current.getMicrosecondLength() != current.getMicrosecondPosition()) {
				//Waiting loop
			}
		}
	}
	
	public void loopMusic(short id) {
		stopMusic();
		Clip current = playSong(id);
		current.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stopMusic() {
		if(currentSong != null) {
			currentSong.stop();			
		}
	}
	
	private void getSongData(String filePath) {
		try {
			//Reads in the information from the file
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = br.readLine();
			while(line != null) {
				songs.add("/songs/" + line);
				line = br.readLine();
			}
			System.out.println("Finished loading songs!");
			System.out.println("--------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public short getTrackSize() {
		return (short) songs.size();
	}
}
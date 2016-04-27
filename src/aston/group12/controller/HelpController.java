package aston.group12.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class HelpController extends AbstractController implements Initializable {
	
	@FXML
	private MediaView videoView;
	
	
	@FXML
	public void onBackBtn(ActionEvent action) {
		Stage stage = (Stage) videoView.getScene().getWindow();
		loadScreen(stage, "mainmenu.fxml");
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MediaPlayer mp = new MediaPlayer(new Media(getClass().getResource("/resources/video.mp4").toString()));
		videoView.setMediaPlayer(mp);
		videoView.getMediaPlayer().play();
		
	}

}
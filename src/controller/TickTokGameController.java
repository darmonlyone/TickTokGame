package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import model.design_patterns.singleton.FastClickGame;
import model.design_patterns.iterator.NormalTimeCounter;
import model.design_patterns.iterator.TimeBoard;

public class TickTokGameController {
    @FXML
    private Pane main;

    @FXML
    private Pane gameclick;

    @FXML
    private ImageView light;

    @FXML
    private Button butClick;

    @FXML
    private Pane result;

    @FXML
    private Label resultLabel;

    @FXML
    private FlowPane historyPane;

    private Pane defaltHistoryPane;
    private FastClickGame fastClickGame;

    @FXML
    private void initialize() {
        changePage(main);
        fastClickGame = FastClickGame.getInstance();
        defaltHistoryPane = (Pane) historyPane.getChildren().get(0);
    }

    private void changePage(Pane pane){
        main.setVisible(false);
        gameclick.setVisible(false);
        result.setVisible(false);
        pane.setVisible(true);
    }

    @FXML
    void gameclickAction(ActionEvent event) {
        fastClickGame.click(e-> {
            changePage(result);
            resultLabel.setText(String.format("%.3f",fastClickGame.getPlayTime()));
            setHistory();
        });
    }

    @FXML
    void playFastClick(ActionEvent event) {
        fastClickGame.ready();
        changePage(gameclick);
        lightOff();
        clickAble();
        fastClickGame.run(e->{
            lightOn();
            clickAble();
        });
    }

    private void clickAble(){
        if (fastClickGame.isClickAble())
            butClick.setText("Click!!");
        else butClick.setText("");
        butClick.setDisable(!fastClickGame.isClickAble());
    }

    private void setHistory(){

        fastClickGame.setTimeCounter(new NormalTimeCounter());
        TimeBoard timeBoard = new TimeBoard();
        timeBoard.setTimeCounter(fastClickGame.getTimeCounter());
        historyPane.getChildren().clear();

        for (double times: timeBoard){
            Pane pane = new Pane();
            pane.setStyle(defaltHistoryPane.getStyle());
            pane.setMaxSize(defaltHistoryPane.getWidth(),defaltHistoryPane.getMaxHeight());
            pane.setPrefSize(defaltHistoryPane.getWidth(),defaltHistoryPane.getPrefHeight());

            Label label = new Label(String.format("%.3f",times));
            label.setLayoutX(24);
            label.setLayoutY(13);
            label.setFont(new Font(14));
            label.setPrefSize(120,20);

            Label second = new Label("Second");
            second.setLayoutX(151);
            second.setLayoutY(13);
            second.setFont(new Font(14));

            pane.getChildren().addAll(label, second);

            historyPane.getChildren().add(pane);
        }

    }

    private void lightOff(){
        light.setImage(new Image("assert/image/lightOff.jpg",200,200,true,true));
    }

    private void lightOn(){
        light.setImage(new Image("assert/image/lightOn.jpg",200,200,true,true));
    }

    @FXML
    void mainMenu(ActionEvent event) {
        fastClickGame.main();
        changePage(main);
    }

    @FXML
    void tryagain(ActionEvent event) {
        fastClickGame.tryAgain();
        playFastClick(event);
    }

}

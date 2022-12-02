package com.example.snake_n_ladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public final int tileSize=40;
    public final int height=10;
    public final int width=10;
    public final int yLine=430;
    int diceValue;
    Label randResult;
    Group tileGroup=new Group();
    Player playerOne , playerTwo;
    boolean gameStart=true, turnOnePlayer=true,turnTwoPlayer=false;
    public Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+80);
        root.getChildren().addAll(tileGroup);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile=new Tile(tileSize,tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                tileGroup.getChildren().addAll(tile);
            }
        }
        //add Labels

        randResult=new Label("Start the GAME");
        randResult.setTranslateX(198);
        randResult.setTranslateY(yLine-30);


        //add Buttons

        Button player1Button=new Button("Player 1");
        player1Button.setTranslateX(20);
        player1Button.setTranslateY(yLine);
        player1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart && turnOnePlayer)
                {
                    getDiceValue();
                    playerOne.movePlayer(diceValue);
                    randResult.setText(Integer.toString(diceValue));
                    playerOne.playerAtSnakeOrLadder();
                    turnOnePlayer=false;
                    turnTwoPlayer=true;
                }

            }
        });

        Button player2Button=new Button("Player 2");
        player2Button.setTranslateX(320);
        player2Button.setTranslateY(yLine);
        player2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart && turnTwoPlayer)
                {
                    getDiceValue();
                    playerTwo.movePlayer(diceValue);
                    randResult.setText(Integer.toString(diceValue));
                    playerTwo.playerAtSnakeOrLadder();
                    turnTwoPlayer=false;
                    turnOnePlayer=true;

                }

            }
        });

        Button gameButton=new Button("Start");
        gameButton.setTranslateX(180);
        gameButton.setTranslateY(yLine);

        playerOne=new Player(tileSize, Color.BLACK);
        playerTwo=new Player(tileSize-10,Color.WHITE);

        Image img=new Image("C:\\Users\\Eksdee Sama\\IdeaProjects\\Snake n  Ladder\\src\\main\\SnakeNLadder.png");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitHeight(tileSize*height);
        boardImage.setFitWidth(tileSize*width);

        tileGroup.getChildren().addAll(boardImage,player1Button,
                gameButton,player2Button ,randResult,
                playerOne.getGamePiece(),playerTwo.getGamePiece());

        return root;
    }
    private void getDiceValue()
    {
        diceValue=(int)(Math.random()*6+1);
    }
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());

        stage.setTitle("Sanke and Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
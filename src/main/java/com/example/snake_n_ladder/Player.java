package com.example.snake_n_ladder;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle gamePiece;
    int xPos , yPos , currentPiecePosition;
    static gameBoard gBoard=new gameBoard();
    Player(int tileSize, Color pieceColor)
    {
        this.currentPiecePosition=1;
        this.xPos=gBoard.getXValue(currentPiecePosition);
        this.yPos=gBoard.getYValue(currentPiecePosition);

        gamePiece=new Circle(tileSize/2);
        gamePiece.setFill(pieceColor);
        gamePiece.setTranslateX(this.xPos);
        gamePiece.setTranslateY(this.yPos);
    }
    public void playerAtSnakeOrLadder()
    {
        int newPos=gameBoard.playerPositionAtSnakeOrLadder(this.currentPiecePosition);
        if(newPos != -1)
        {
             this.currentPiecePosition=newPos;
             translatePlayer();
        }
    }
    public void movePlayer(int diceValue)
    {
        if(currentPiecePosition+diceValue<=100){
            currentPiecePosition+=diceValue;
            translatePlayer();
        }
    }
    private void translatePlayer()
    {
        this.xPos=gBoard.getXValue(this.currentPiecePosition);
        this.yPos=gBoard.getYValue(this.currentPiecePosition);

        TranslateTransition animate=new TranslateTransition(Duration.millis(1000),this.gamePiece);
        animate.setToX(this.xPos);
        animate.setToY(this.yPos);
        animate.play();

        //gamePiece.setTranslateX(this.xPos);
        //gamePiece.setTranslateY(this.yPos);

    }
    public Circle getGamePiece()
    {
        return this.gamePiece;
    }
}

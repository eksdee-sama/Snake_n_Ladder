package com.example.snake_n_ladder;

import javafx.util.*;

import java.util.ArrayList;


public class gameBoard {
    static int tileSize=40;
    static int height=10;
    static int width=10;
    static ArrayList<Pair<Integer,Integer>> posCoordinates;
    static ArrayList<Integer> snakeLadderPosition;

    public int getXValue(int getPosition)
    {
        return posCoordinates.get(getPosition).getKey();
    }
    public int getYValue(int getPosition)
    {
        return posCoordinates.get(getPosition).getValue();
    }
    public gameBoard(){
        setPosCoordinates();
        populatePosCoordinates();
    }
    private static void setPosCoordinates()
    {
        posCoordinates=new ArrayList<>();
        int xTilePos,yTilsePos,number=0;
        posCoordinates.add(new Pair<Integer,Integer>(0,0));
        for(int i=height-1;i>=0;i--)
        {
            for(int j=width-1;j>=0;j--)
            {
                if(i%2==1)
                    xTilePos=tileSize*width - (tileSize/2 + j*tileSize);
                else
                    xTilePos=tileSize/2 + j*tileSize;
                yTilsePos=tileSize/2 + i*tileSize;
                posCoordinates.add(new Pair<Integer,Integer>(xTilePos,yTilsePos));
            }
        }
        for (int i = 0; i <posCoordinates.size() ; i++) {
            System.out.println(i+" "+posCoordinates.get(i).getKey()+" "+posCoordinates.get(i).getValue());

        }
    }
    private static void populatePosCoordinates()
    {
        snakeLadderPosition=new ArrayList<Integer>();
        for (int i = 0; i < 102 ; i++) {
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(5,26);
        snakeLadderPosition.set(12,71);
        snakeLadderPosition.set(19,40);
        snakeLadderPosition.set(27,6);
        snakeLadderPosition.set(28,54);
        snakeLadderPosition.set(36,76);
        snakeLadderPosition.set(43,9);
        snakeLadderPosition.set(50,11);
        snakeLadderPosition.set(55,34);
        snakeLadderPosition.set(50,79);
        snakeLadderPosition.set(66,87);
        snakeLadderPosition.set(72,91);
        snakeLadderPosition.set(88,51);
        snakeLadderPosition.set(94,48);
        snakeLadderPosition.set(98,3);
    }
    public static int playerPositionAtSnakeOrLadder(int piecePosition)
    {
        if(piecePosition!=snakeLadderPosition.get(piecePosition))
            return snakeLadderPosition.get(piecePosition);
        return -1;
    }


    public static void main(String[] args) {
        setPosCoordinates();
    }
}

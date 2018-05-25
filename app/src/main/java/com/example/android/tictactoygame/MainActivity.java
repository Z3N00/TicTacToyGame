package com.example.android.tictactoygame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view) {
        Button buttonSelected= (Button) view;

//        buttonSelected.setText("zeno");

        int CellID = 0;

        switch (buttonSelected.getId()){

            case R.id.button1 :
                CellID=1;
                break;

            case R.id.button2 :
                CellID=2;
                break;

            case R.id.button3 :
                CellID=3;
                break;

            case R.id.button4 :
                CellID=4;
                break;

            case R.id.button5 :
                CellID=5;
                break;

            case R.id.button6 :
                CellID=6;
                break;

            case R.id.button7 :
                CellID=7;
                break;

            case R.id.button8 :
                CellID=8;
                break;

            case R.id.button9 :
                CellID=9;
                break;
        }
        PlayGame(CellID,buttonSelected);
    }

    int activePlayer= 1; //1 - first player , 2 - second player
    ArrayList<Integer> Player1=new ArrayList<Integer>(); //hold player 1 data
    ArrayList<Integer> Player2=new ArrayList<Integer>(); //hold player 2 data

    void PlayGame(int CellID,Button buttonSelected){

        Log.d("Player",String.valueOf(CellID));
        Log.d("ButtonText",buttonSelected.getText().toString());
        Log.d("ButtonColour",buttonSelected.getBackground().toString());

        if(activePlayer==1){
            buttonSelected.setText("X");
            buttonSelected.setBackgroundColor(Color.GREEN );
            Player1.add(CellID);
            activePlayer=2;

            AutoPlay();

        }else if (activePlayer==2){
            buttonSelected.setText("0");
            buttonSelected.setBackgroundColor(Color.YELLOW);
           Player2.add(CellID);
            activePlayer=1;
        }
        buttonSelected.setEnabled(false);

        CheckWinner();
    }

    void CheckWinner(){
        int Winner=-1;

        //row 1
        if (Player1.contains(1)&&Player1.contains(2)&&Player1.contains(3)){
            Winner=1;
        }
        if (Player2.contains(1)&&Player2.contains(2)&&Player2.contains(3)){
            Winner=2;
        }
        //row 2
        if (Player1.contains(4)&&Player1.contains(5)&&Player1.contains(6)){
            Winner=1;
        }
        if (Player2.contains(4)&&Player2.contains(5)&&Player2.contains(6)){
            Winner=2;
        }
        //row 3
        if (Player1.contains(7)&&Player1.contains(8)&&Player1.contains(9)){
            Winner=1;
        }
        if (Player2.contains(7)&&Player2.contains(8)&&Player2.contains(9)){
            Winner=2;
        }


        //col 1
        if (Player1.contains(1)&&Player1.contains(4)&&Player1.contains(7)){
            Winner=1;
        }
        if (Player2.contains(1)&&Player2.contains(4)&&Player2.contains(7)){
            Winner=2;
        }
        //col 2
        if (Player1.contains(2)&&Player1.contains(5)&&Player1.contains(8)){
            Winner=1;
        }
        if (Player2.contains(2)&&Player2.contains(5)&&Player2.contains(8)){
            Winner=2;
        }
        //col 3
        if (Player1.contains(3)&&Player1.contains(6)&&Player1.contains(9)){
            Winner=1;
        }
        if (Player2.contains(3)&&Player2.contains(6)&&Player2.contains(9)){
            Winner=2;
        }

        //diagonal 1
        if (Player1.contains(1)&&Player1.contains(5)&&Player1.contains(9)){
            Winner=1;
        }
        if (Player2.contains(1)&&Player2.contains(5)&&Player2.contains(9)){
            Winner=2;
        }
        //col 2
        if (Player1.contains(3)&&Player1.contains(5)&&Player1.contains(7)){
            Winner=1;
        }
        if (Player2.contains(3)&&Player2.contains(5)&&Player2.contains(7)){
            Winner=2;
        }

        if(Winner!=-1){
            // we have winner
        }
        if(Winner==1){
            Toast.makeText(this,"Player 1 is Winner",Toast.LENGTH_SHORT).show();
        }
        else if(Winner==2){
            Toast.makeText(this,"Player 2 is Winner",Toast.LENGTH_SHORT).show();
        }
    }


    void AutoPlay(){
        ArrayList<Integer> emptyCell=new ArrayList<Integer>(); //all unselected cell

        //find empty cell

        for(int CellID = 1;CellID<10;CellID++){
            if(!(Player1.contains(CellID)||(Player2.contains(CellID)))){
                emptyCell.add(CellID);
            }
        }

        Random random=new Random();
        int randomIndex=random.nextInt(emptyCell.size()-0)+0;  // if size =3 , select (0,1,2)
        int CellID=emptyCell.get(randomIndex);

        Button buttonSelected;

        switch (CellID){

            case 1 :
                buttonSelected=findViewById(R.id.button1);
                break;

            case 2 :
               buttonSelected=findViewById(R.id.button2);
                break;

            case 3 :
                buttonSelected=findViewById(R.id.button3);
                break;

            case 4 :
                buttonSelected=findViewById(R.id.button4);
                break;

            case 5 :
                buttonSelected=findViewById(R.id.button5);
                break;

            case 6 :
                buttonSelected=findViewById(R.id.button6);
                break;

            case 7 :
               buttonSelected=findViewById(R.id.button7);
                break;

            case 8 :
               buttonSelected=findViewById(R.id.button8);
                break;

            case 9 :
                buttonSelected=findViewById(R.id.button9);
                break;

            default:
                buttonSelected=findViewById(R.id.button1);
        }

        PlayGame(CellID,buttonSelected);
    }
}

package com.imeja.dice;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button Roll;
ImageView dice;
TextView outcomes;
EditText gaze;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Roll= findViewById(R.id.button);
        dice=findViewById(R.id.imageView);
        outcomes= findViewById(R.id.result);
        gaze=findViewById(R.id.pred);
        Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                dice.startAnimation(animation);

                new CountDownTimer(1000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        change();

                    }
                }.start();



            }
        });
    }

    private void change() {
        Random random= new Random();
        int rollResult= random.nextInt(6)+1;
        outcomes.setText(""+rollResult);
        int cc= Integer.parseInt(gaze.getText().toString());
        if (rollResult==(cc)){
            Toast.makeText(this, "waaaauuu!!!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "You have lost, Try Again", Toast.LENGTH_SHORT).show();
        }
        switch(rollResult){
            case 1:
                dice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                dice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dice.setImageResource(R.drawable.dice3);
                break;  
            case 4:
                dice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dice.setImageResource(R.drawable.dice6);
                break;
            default:
                Toast.makeText(MainActivity.this, "Role again", Toast.LENGTH_SHORT).show();
                break;
        }
        final MediaPlayer mp= MediaPlayer.create(this,R.raw.try1);

    }
}

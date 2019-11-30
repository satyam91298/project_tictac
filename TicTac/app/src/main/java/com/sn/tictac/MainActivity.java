package com.sn.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    boolean gameActive=true;
    int activeplayer=0;

    int[] games={2,2,2,2,2,2,2,2,2};
    int[][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view){

            ImageView img = (ImageView) view;
            int tapped = Integer.parseInt(img.getTag().toString());

            if (games[tapped] == 2) {
                if (games[tapped] == 2) {
                    games[tapped] = activeplayer;
                    img.setTranslationY(-1000f);
                    if (activeplayer == 0) {
                        img.setImageResource(R.drawable.x);
                        activeplayer = 1;
                        TextView status = findViewById(R.id.status);
                        status.setText("O's Turn");
                    } else {
                        img.setImageResource(R.drawable.o);
                        activeplayer = 0;
                        TextView status = findViewById(R.id.status);
                        status.setText("X's Turn");
                    }
                    img.animate().translationYBy(1000f).setDuration(300);
                }
                for (int[] winpostion : winpos) {
                    if (games[winpostion[0]] == games[winpostion[1]] && games[winpostion[1]] == games[winpostion[2]]
                            && games[winpostion[0]] != 2) {
                        String winner;
                        if (games[winpostion[0]] == 0) {
                            winner = "X Has Won";
                        } else {
                            winner = "0 Has Won";


                        }

                        TextView status = findViewById(R.id.status);
                        status.setText(winner);
                        gamereset(view);


                    }


                }
            } else if (games[tapped] != 2) {
                TextView stat = findViewById(R.id.status);
                stat.setText("play Again");

            }

        }

    public void gamereset(View view){
        gameActive=true;
        activeplayer=0;
        for(int i=0;i<games.length;i++)
        {
            games[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);




    }
    public void sn(View view)
    {
        gamereset(view);
        TextView  status=findViewById(R.id.status);
        status.setText("Tap to play");
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

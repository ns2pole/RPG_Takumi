package com.example.rpg;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.content.Intent;

import com.example.rpg.Calc.Error.Finish;
import com.example.rpg.Calc.Monsters.Gorlem;
import com.example.rpg.Calc.Monsters.MetalSlime;
import com.example.rpg.Calc.Person2;

public class

MainActivity extends AppCompatActivity {
    public static Person2 p = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            p = new Person2("takumi","dannsei",new MetalSlime(),new Gorlem());
        } catch (Finish e) {
            throw new RuntimeException(e);
        }



        int imageSize = getResources().getDimensionPixelSize(R.dimen.image_size);
        int margin = getResources().getDimensionPixelSize(R.dimen.image_margin);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        int[][] map = new RpgMap().map;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                Drawable myImageDrawable = null;
                if (map[i][j] == 3) {
                    myImageDrawable = getResources().getDrawable(R.drawable.ocean, null);
                } else if (map[i][j] == 6) {
                    myImageDrawable = getResources().getDrawable(R.drawable.store, null);
                } else {
                    myImageDrawable = getResources().getDrawable(R.drawable.glass, null);
                }
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                layoutParams.width = imageSize;
                layoutParams.height = imageSize;
                layoutParams.setMargins(margin, margin, margin, margin);
                ImageView imageView = new ImageView(this);
                imageView.setImageDrawable(myImageDrawable);
                imageView.setLayoutParams(layoutParams);
                gridLayout.addView(imageView);
            }
        }


        Button myButton = findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
    }

        private void test() {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }


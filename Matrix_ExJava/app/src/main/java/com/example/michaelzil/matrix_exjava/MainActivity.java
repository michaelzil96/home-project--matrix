package com.example.michaelzil.matrix_exjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button diagonalsButton;
    private Button borderButton;
    private Button downPartButton;
    private Button upperPartButton;

    private LinearLayout matrixLayout;

    int numOfRows = 3;
    LinearLayout[] linLayoutRows = new LinearLayout[numOfRows];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matrixLayout = (LinearLayout) findViewById(R.id.matrixLayout);


        // creating ll array as number of rows.

        for (int i = 0; i < numOfRows; i++) {
            linLayoutRows[i] = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.CENTER;
            linLayoutRows[i].setLayoutParams(layoutParams); // importent!!! remember it
            matrixLayout.addView(linLayoutRows[i]);
        }

        // creating a TextView array with 9 cells
        int textViewCount = 9;
        final TextView[] textViewArray = new TextView[textViewCount];
        for (int i = 0; i < textViewCount; i++) {
            textViewArray[i] = new TextView(this);
        }

        for (int j = 0; j < 9; j += 3) {
            for (int i = 0; i < 3; i++) {
                textViewArray[j + i].setWidth(250);
                textViewArray[j + i].setHeight(250);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_style, getTheme()));
                linLayoutRows[j / 3].addView(textViewArray[j + i]);
            }
        }




        diagonalsButton = (Button) findViewById(R.id.diagonalsButton);

        diagonalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(250);
                        textViewArray[j + i].setHeight(250);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_style, getTheme()));
                        //for the first diagonal
                        if(j/3 == i) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.colored_cell_style, getTheme()));
                        }
                        //for the second diagonal
                        if(j/3 + i == 2) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.colored_cell_style, getTheme()));
                        }
                    }
                }

            }
        });

        borderButton = (Button) findViewById(R.id.borderButton);

        borderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(250);
                        textViewArray[j + i].setHeight(250);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_style, getTheme()));

                        if(j == 0 || j/3 == 2 || i == 0 || i == 2) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.colored_cell_style, getTheme()));
                        }
                    }
                }

            }
        });


        upperPartButton = (Button) findViewById(R.id.upperPartButton);

        upperPartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(250);
                        textViewArray[j + i].setHeight(250);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_style, getTheme()));
                        //for the first diagonal
                        if(j/3 == i) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.colored_cell_style, getTheme()));
                        }
                        // all the cells that's their column i index is bigger then the column index j
                        if(i > j/3){
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.colored_cell_style, getTheme()));
                        }
                    }
                }

            }
        });

        downPartButton = (Button) findViewById(R.id.downPartButton);

        downPartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(250);
                        textViewArray[j + i].setHeight(250);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_style, getTheme()));
                        //for the first diagonal
                        if(j/3 == i) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.colored_cell_style, getTheme()));
                        }
                        // all the cells that's their row j index is bigger then the column index i
                        if(j/3 > i){
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.colored_cell_style, getTheme()));
                        }
                    }
                }

            }
        });

    }
}






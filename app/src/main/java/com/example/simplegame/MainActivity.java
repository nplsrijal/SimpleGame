package com.example.simplegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btnplay;
    private TextView output;
    int countwon=0;
    int countloss=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btnplay=findViewById(R.id.btnplay);

        output=findViewById(R.id.output);

        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Random rand = new Random();


                int firstnum =Integer.parseInt(btn1.getText().toString());

                int outvalue =Integer.parseInt(output.getText().toString());

                if(firstnum-outvalue >=0){
                    int random = (int)(Math.random() * 100 + 1);
                    int random1 = rand.nextInt(100);

                    int sum=outvalue+1;
                    btn1.setText(""+random);
                    btn2.setText(""+random1);

                    output.setText(""+sum);
                    countwon =countwon +1;
                }else{

                    int sum=outvalue-1;
                    countloss=countloss+1;
                    output.setText(""+sum);

                }

                if(outvalue ==10){
                    int count=countwon-1;
                    output.setText("Point Decreased: "+countloss + "\n" + " Point Increment:"+ count);
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btnplay.setVisibility(View.VISIBLE);

                }





            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int firstnum =Integer.parseInt(btn2.getText().toString());

                int outvalue =Integer.parseInt(output.getText().toString());

                if(firstnum-outvalue >=0){
                    int random = (int)(Math.random() * 100 + 1);
                    int random1 = rand.nextInt(100);
                    int sum=outvalue+1;
                    btn2.setText(""+random);
                    btn1.setText(""+random1);
                    countwon =countwon +1;

                    output.setText(""+sum);
                }else{

                    int sum=outvalue-1;
                    countloss=countloss+1;
                    output.setText(""+sum);

                }
                if(outvalue ==10){
                    int count=countwon-1;
                    output.setText("Point Decreased: "+countloss + "\n" + " Point Increment:"+ count);
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btnplay.setVisibility(View.VISIBLE);
                }





            }
        });
        btnplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);


            }
        });
    }
}

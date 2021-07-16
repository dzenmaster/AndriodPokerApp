package com.example.myapplication5;

import android.os.Bundle;

import com.example.myapplication5.ui.main.MyView;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.RadioGroup;
import android.widget.RadioButton;


import com.example.myapplication5.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private double[][] m_currPD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_currPD = new double[][]
        {  //   1      2      3      4      5      6      7     8
            {74.36, 21.27, 17.81, 15.84,  11.47,   8.61,   5.44, 11.92}, //raise
            {100.1, 52.19, 41.41, 23.36,  18.11,  15.25,   9.66, 11.92}, //limp
            {100.1, 83.11, 65.01, 31.23,  24.74,  21.88,  13.88, 11.92}  // 0
        };


        calcDP();

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        RadioGroup rgAction = (RadioGroup) findViewById(R.id.rgAction);
        rgAction.check(R.id.radioButton0);

        RadioGroup rgStakeSize = (RadioGroup) findViewById(R.id.rgStakeSize);
        rgStakeSize.check(R.id.rb25bb);

        RadioGroup rgPos = (RadioGroup) findViewById(R.id.RadioPos);
        rgPos.check(R.id.radioButton1);

        // This overrides the radiogroup onCheckListener
        rgPos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton curAction = (RadioButton) findViewById(rgAction.getCheckedRadioButtonId());
                RadioButton curStSz = (RadioButton) findViewById(rgStakeSize.getCheckedRadioButtonId());
                //RadioButton curGame = (RadioButton) findViewById(rgGame.getCheckedRadioButtonId());
                switch (checkedId) {
                    case R.id.radioButton1:
                     //   tv.setText("BB " + curStrb.getText());
                        calcChart("BB", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                        break;
                    case R.id.radioButton2:
                        calcChart("SB", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                   //     tv.setText("SB " + curStrb.getText());
                        break;
                    case R.id.radioButton3:
                        calcChart("Button", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                    //    tv.setText("Button " + curStrb.getText());
                        break;
                    case R.id.radioButton4:
                        calcChart("4", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                     //   tv.setText("4 " + curStrb.getText());
                        break;
                    case R.id.radioButton5:
                        calcChart("5", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                      //  tv.setText("5 " + curStrb.getText());
                        break;
                    case R.id.radioButton6:
                        calcChart("6", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                       // tv.setText("6 " + curStrb.getText());
                        break;
                    case R.id.radioButton7:
                        calcChart("7", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                       // tv.setText("7 " + curStrb.getText());
                        break;
                    case R.id.radioButton8:
                        calcChart("8", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                        //tv.setText("8 " + curStrb.getText());
                        break;
                }
            }
        });

        // This overrides the radiogroup onCheckListener
        rgAction.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton curPosrb =(RadioButton) findViewById(rgPos.getCheckedRadioButtonId());
                RadioButton curStSz = (RadioButton) findViewById(rgStakeSize.getCheckedRadioButtonId());

                switch (checkedId) {
                    case R.id.radioButton0:
                        //tv.setText("0 " + curPosrb.getText());
                        calcChart(String.valueOf(curPosrb.getText()), "0", String.valueOf(curStSz.getText()));
                        break;
                    case R.id.radioButtonLimp:
                        //tv.setText("Limp " + curPosrb.getText());
                        calcChart(String.valueOf(curPosrb.getText()), "Limp", String.valueOf(curStSz.getText()));
                        break;
                    case R.id.radioButtonRaise:
                        //tv.setText("Raise " + curPosrb.getText());
                        calcChart(String.valueOf(curPosrb.getText()), "Raise", String.valueOf(curStSz.getText()));
                        break;
                    case R.id.radioButtonPush:
                        //tv.setText("Raise " + curPosrb.getText());
                        calcChart(String.valueOf(curPosrb.getText()), "Push", String.valueOf(curStSz.getText()));
                        break;
                }
            }
        });

        rgStakeSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton curPosrb =(RadioButton) findViewById(rgPos.getCheckedRadioButtonId());
                RadioButton curAction = (RadioButton) findViewById(rgAction.getCheckedRadioButtonId());

                switch (checkedId) {
                    case R.id.rb40bb:
                        calcChart(String.valueOf(curPosrb.getText()), String.valueOf(curAction.getText()),"40 BB");
                        break;
                    case R.id.rb25bb:
                        calcChart(String.valueOf(curPosrb.getText()), String.valueOf(curAction.getText()),"25 BB");
                        break;
                    case R.id.rb20bb:
                        calcChart(String.valueOf(curPosrb.getText()), String.valueOf(curAction.getText()),"20 BB");
                        break;
                    case R.id.rb15bb:
                        calcChart(String.valueOf(curPosrb.getText()), String.valueOf(curAction.getText()),"15 BB");
                        break;
                    case R.id.rb10bb:
                        calcChart(String.valueOf(curPosrb.getText()), String.valueOf(curAction.getText()),"10 BB");
                        break;
                    case R.id.rb5bb:
                        calcChart(String.valueOf(curPosrb.getText()), String.valueOf(curAction.getText()),"5 BB");
                        break;
                }
            }
        });


    }

    protected void calcDP() {
        //m_currPD
    }

    protected void calcChart(String pos, String  stake, String  stakeSz) {
        //TextView tv = (TextView) findViewById(R.id.textViewResult);
        //tv.setText("Position " + pos + " Stake "+ stake);

        MyView mv = (MyView) findViewById(R.id.view);
        mv.setCurrChart(1);//to 1 player
        int[][] tDiff = new int[][]
                {
                        // A  K   Q   J  10   9   8   7   6   5   4   3   2
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 }, // A
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //J
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //9
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //7
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //6
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //5
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 }
                };
        int[][] tPush = new int[][]
                {
                        // A  K   Q   J  10   9   8   7   6   5   4   3   2
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 }, // A
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //J
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //9
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //7
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //6
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },  //5
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 },
                        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 }
                };

        mv.setCurrDiff(tDiff);
        mv.setCurrPush(tPush);

        if (stake.equals("Raise")){
            if (pos.equals("BB")) {
                mv.setCurrChart(150); //to 1 players 50 diap
                mv.setCurrPrc(m_currPD[0][0]);
                tDiff[6][11]=1;tDiff[6][12]=1;
                tDiff[7][11]=1;tDiff[7][12]=1;
                tDiff[8][12]=1;
                tDiff[10][12]=1;
                tDiff[11][12]=1;


                tDiff[9][3]=1;tDiff[9][6]=1;tDiff[9][7]=1;
                tDiff[10][3]=1;tDiff[10][8]=1;tDiff[10][9]=1;
                tDiff[11][2]=1; tDiff[11][3]=1;
                tDiff[12][2]=1;//Q2o

                if (stakeSz.equals("40 BB")) {

                }
                else{
                    tDiff[8][3]=1;tDiff[8][4]=1;
                }

                mv.setCurrDiff(tDiff);

                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1; tPush[0][6] = 1;  tPush[0][7] = 1;   tPush[0][8] = 1;   tPush[0][9] = 1; tPush[0][10] = 1;tPush[0][11] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1; tPush[4][5] = 1;
                    tPush[5][0] = 1;  tPush[5][5] = 1;
                    tPush[6][0] = 1;       tPush[6][6] = 1;
                                              tPush[7][7] = 1;
                                                   tPush[8][8] = 1;
                                                        tPush[9][9] = 1;
                                                            tPush[10][10] = 1;
                                                                 tPush[11][11] = 1;
                                                                    tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1; tPush[0][6] = 1;  tPush[0][7] = 1;      tPush[0][9] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1; tPush[4][5] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    tPush[11][11] = 1;
                    tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1; tPush[4][5] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    tPush[11][11] = 1;
                    tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1; tPush[4][5] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    tPush[11][11] = 1;
                    tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }

            }
            else if (pos.equals("SB")) {
                mv.setCurrChart(150); //to 1 players 50 diap
                mv.setCurrPrc(m_currPD[0][1]);
                tDiff[1][6]=1;tDiff[1][7]=1;
                tDiff[2][5]=1;//Q9s
                tDiff[3][5]=1;//J9s
                tDiff[3][4]=1;//JTs
                tDiff[4][5]=1;tDiff[4][6]=1;
                tDiff[5][6]=1;//98s

                tDiff[3][2]=1;//JQo

                tDiff[5][0]=1;
                tDiff[6][0]=1;tDiff[6][7]=1;

                tDiff[4][1]=1;//KTo
                tDiff[7][0]=1;tDiff[7][8]=1;
                tDiff[8][0]=1;tDiff[8][9]=1;
                tDiff[9][0]=1;
                tDiff[11][11]=1;//33
                tDiff[12][12]=1;

                if (stakeSz.equals("40 BB")) {
                    tDiff[1][8]=1;
                    tDiff[5][7]=1;//97s
                    tDiff[9][10]=1;
                }
                else{
                    tDiff[2][6]=1;
                }
                mv.setCurrDiff(tDiff);


                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1; tPush[0][6] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    tPush[11][11] = 1;
                    tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][0] = 1;                                  tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;tPush[2][4] = 1;
                                                                       tPush[3][3] = 1;tPush[3][4] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("Button")) {
                mv.setCurrChart(150); //to 1 players 50 diap
                mv.setCurrPrc(m_currPD[0][2]);
                tDiff[0][10]=1;tDiff[0][11]=1;tDiff[0][12]=1;
                tDiff[1][6]=1;tDiff[1][7]=1;
                tDiff[2][4]=1;tDiff[2][5]=1;
                tDiff[3][2]=1; tDiff[3][4]=1;tDiff[3][5]=1;
                tDiff[4][1]=1; tDiff[4][5]=1;
                 tDiff[5][6]=1;
                tDiff[6][7]=1;

                tDiff[10][10]=1;//44

                tDiff[6][0]=1;//A8o
                tDiff[7][0]=1;//A7o
                if (stakeSz.equals("40 BB")) {
                    tDiff[1][8]=1;
                    tDiff[2][6]=1;
                    tDiff[3][6]=1;
                    tDiff[4][6]=1;
                    tDiff[5][0]=1; tDiff[5][7]=1;
                    tDiff[7][8]=1;
                    tDiff[8][9]=1;
                    tDiff[11][11]=1;//33
                    tDiff[12][12]=1;
                }
                else {

                }
                mv.setCurrDiff(tDiff);

                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;tPush[1][3] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1;tPush[2][3] = 1;
                    tPush[3][0] = 1;                                  tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("4")) {
                mv.setCurrChart(250); //to 1 players 50 diap
                mv.setCurrPrc(m_currPD[0][3]);

                tDiff[3][4]=1;
                tDiff[5][0]=1;
                tDiff[6][0]=1;

                if (stakeSz.equals("40 BB")) {
                    tDiff[0][10]=1;tDiff[0][11]=1;tDiff[0][12]=1;
                    tDiff[1][6]=1;tDiff[1][7]=1;
                    tDiff[2][5]=1;
                    tDiff[3][5]=1;
                    tDiff[4][5]=1;tDiff[4][6]=1;
                    tDiff[5][6]=1;
                    tDiff[6][7]=1;
                    tDiff[7][8]=1;
                    tDiff[8][9]=1;
                    tDiff[9][10]=1;
                    tDiff[9][9]=1;//55
                    tDiff[10][10]=1;//44
                    tDiff[11][11]=1;//33
                    tDiff[12][12]=1;
                }
                else{
                    tDiff[0][7]=1;tDiff[0][8]=1;tDiff[0][9]=1;
                    tDiff[1][5]=1;
                    tDiff[3][1]=1;
                    tDiff[4][0]=1;
                }


                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][0] = 1;                                  tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("5")) {
                mv.setCurrChart(250); //to 1 players 50 diap
                mv.setCurrPrc(m_currPD[0][4]);
                tDiff[0][7]=1;

                tDiff[2][4]=1;
                tDiff[3][4]=1;

                tDiff[4][0]=1;//ATo

                if (stakeSz.equals("40 BB")) {
                    tDiff[0][9]=1;
                    tDiff[1][5]=1;
                    tDiff[4][5]=1;
                    tDiff[8][8]=1;//66
                    tDiff[9][9]=1;//55
                }
                else{
                    tDiff[0][6]=1;
                }
                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("6")) {
                mv.setCurrChart(250); //to 1 players 50 diap
                mv.setCurrPrc(m_currPD[0][5]);
                tDiff[1][3]=1;
                tDiff[2][3]=1;

                tDiff[4][0]=1;

                if (stakeSz.equals("40 BB")) {
                    tDiff[1][4]=1;
                    tDiff[2][4]=1;
                    tDiff[3][0]=1; tDiff[3][4]=1;
                    tDiff[7][7]=1;//77
                    tDiff[8][8]=1;
                }
                else{
                    tDiff[0][5]=1;
                }

                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3 ] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("7")) {
                mv.setCurrChart(250); //to 1 players 50 diap
                mv.setCurrPrc(m_currPD[0][6]);

                tDiff[0][4]=1;
                tDiff[1][2]=1;tDiff[1][3]=1;
                tDiff[2][3]=1;

                tDiff[6][6]=1;


                if (stakeSz.equals("40 BB")) {
                    tDiff[0][5]=1;
                    tDiff[3][4]=1;
                    tDiff[7][7]=1;
                }
                else{

                }

                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3 ] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("8")) {
                mv.setCurrChart(4); //to 4 players
                mv.setCurrPrc(m_currPD[0][7]);
                tDiff[0][6]=1;tDiff[0][7]=1;tDiff[0][8]=1;tDiff[0][9]=1;tDiff[0][10]=1;tDiff[0][11]=1; //A8-3s
                tDiff[1][5]=1;//K9s
                tDiff[2][5]=1;//Q9s
                tDiff[3][5]=1;//J9s
                tDiff[4][5]=1;//T9s
                tDiff[5][6]=1;//98s
                tDiff[7][7] = 1;//77
                tDiff[8][8]=1;//66
                tDiff[9][9]=1;//55
                mv.setCurrDiff(tDiff);
            }
        }
        else if (stake.equals("Limp")){
            if (pos.equals("BB")) {
                mv.setCurrPrc(m_currPD[1][0]);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                                                     tPush[2][2] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("SB")) {
                mv.setCurrChart(3); //to 3 players
                mv.setCurrPrc(m_currPD[1][1]);

                tDiff[1][11]=1;tDiff[1][12]=1;
                tDiff[2][10]=1;tDiff[2][11]=1;tDiff[2][12]=1;
                tDiff[3][9]=1;tDiff[3][10]=1;tDiff[3][11]=1;
                tDiff[5][9]=1;
                tDiff[6][9]=1;
                tDiff[7][4]=1;
                tDiff[8][1]=1;
                tDiff[7][10]=1;
                tDiff[8][10]=1;

                tDiff[9][0]=1;tDiff[9][1]=1; tDiff[9][10]=1;
                tDiff[10][0]=1;tDiff[10][1]=1;
                tDiff[10][11]=1;
                tDiff[11][0]=1;
                tDiff[12][0]=1; tDiff[12][12]=1;
                if (stakeSz.equals("40 BB")) {
                    tDiff[2][9]=1;
                    tDiff[9][11]=1;
                }
                else{
                    tDiff[4][9]=1;



                }
                mv.setCurrDiff(tDiff);

                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                                                                                        tPush[4][4] = 1;tPush[4][5] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    tPush[11][11] = 1;
                    tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    tPush[11][11] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1;
                                                                                        tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("Button")) {
                mv.setCurrChart(3); //to 3 players
                mv.setCurrPrc(m_currPD[1][2]);
                tDiff[1][11]=1; tDiff[1][12]=1;
                tDiff[2][10]=1;


                tDiff[5][2]=1;  tDiff[5][3]=1; tDiff[5][4]=1;
                tDiff[6][1]=1; tDiff[6][2]=1;tDiff[6][3]=1;
                tDiff[7][1]=1; tDiff[7][8]=1;
                tDiff[8][9]=1;


                tDiff[10][0]=1;
                tDiff[11][0]=1; tDiff[11][11]=1;
                tDiff[12][0]=1;

                if (stakeSz.equals("40 BB")) {
                    tDiff[3][8]=1;
                    tDiff[4][8]=1;
                    tDiff[5][8]=1;
                    tDiff[6][8]=1;
                    tDiff[9][0]=1;
                    tDiff[12][12]=1;
                }
                else{
                    tDiff[1][10]=1;
                    tDiff[2][8]=1;tDiff[2][9]=1;
                    tDiff[4][7]=1;
                }

                mv.setCurrDiff(tDiff);

                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                                                                                        tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;tPush[2][3] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("4")) {
                mv.setCurrChart(3); //to 3 players
                mv.setCurrPrc(m_currPD[1][3]);


                tDiff[3][6]=1;
                tDiff[4][2]=1; tDiff[4][3]=1; tDiff[4][6]=1;
                tDiff[5][1]=1; tDiff[5][6]=1;
                tDiff[6][7]=1;


                tDiff[9][9]=1;
                tDiff[10][10]=1;


                if (stakeSz.equals("40 BB")) {
                    tDiff[0][12]=1;
                    tDiff[1][8]=1;tDiff[1][9]=1;
                    tDiff[2][7]=1;
                    tDiff[7][8]=1;
                    tDiff[8][9]=1;
                    tDiff[9][10]=1;
                    tDiff[11][11]=1;
                    tDiff[12][12]=1;
                }
                else{
                    tDiff[0][10]=1;tDiff[0][11]=1;
                    tDiff[7][0]=1;
                }

                mv.setCurrDiff(tDiff);


                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                       tPush[3][3] = 1;
                                                                                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                                                      tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;
                                                                                      tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("5")) {
                mv.setCurrChart(4); //to 4 players
                mv.setCurrPrc(m_currPD[1][4]);

                tDiff[0][10]=1;
                tDiff[1][6]=1;tDiff[1][7]=1;
                tDiff[4][1]=1; tDiff[4][2]=1;
                tDiff[5][6]=1;
                tDiff[8][8]=1;


                if (stakeSz.equals("40 BB")) {
                    tDiff[4][6]=1;
                    tDiff[9][9]=1;
                    tDiff[10][10]=1;
                }
                else{
                    tDiff[5][0]=1;
                }
                mv.setCurrDiff(tDiff);

                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("6")) {
                mv.setCurrChart(4); //to 4 players
                mv.setCurrPrc(m_currPD[1][5]);

                tDiff[0][7]=1;tDiff[0][9]=1;
                tDiff[3][1]=1;tDiff[3][2]=1;tDiff[3][5]=1;
                tDiff[4][1]=1;tDiff[4][5]=1;
                tDiff[5][6]=1;
                tDiff[8][8]=1;


                if (stakeSz.equals("40 BB")) {
                    tDiff[4][0]=1;
                    tDiff[9][9]=1;
                }
                else{

                }
                mv.setCurrDiff(tDiff);

                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                       tPush[3][3] = 1;
                                                                                       tPush[4][4] = 1;
                                    tPush[5][5] = 1;

                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                                                      tPush[2][2] = 1;
                                                                       tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("7")) {
                mv.setCurrChart(4); //to 4 players
                mv.setCurrPrc(m_currPD[1][6]);
                tDiff[0][5]=1;tDiff[0][6]=1;tDiff[0][7]=1;
                tDiff[1][5]=1;
                tDiff[3][4]=1;
                tDiff[4][5]=1;
                tDiff[7][7]=1;


                if (stakeSz.equals("40 BB")){
                    tDiff[0][8]=1;
                    tDiff[3][5]=1;
                    tDiff[8][8]=1;
                }
                else{

                }

                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;
                                                                                      tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                                                      tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                                                    tPush[2][2] = 1;
                                                                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                                                     tPush[2][2] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("8")) {
                mv.setCurrChart(4); //to 4 players
                mv.setCurrPrc(m_currPD[1][7]);
                tDiff[0][6]=1;tDiff[0][7]=1;tDiff[0][8]=1;tDiff[0][9]=1;tDiff[0][10]=1;tDiff[0][11]=1; //A8-3s
                tDiff[1][5]=1;//K9s
                tDiff[2][5]=1;//Q9s
                tDiff[3][5]=1;//J9s
                tDiff[4][5]=1;//T9s
                tDiff[5][6]=1;//98s
                tDiff[7][7] = 1;//77
                tDiff[8][8]=1;//66
                tDiff[9][9]=1;//55
                mv.setCurrDiff(tDiff);
            }
        }
        else if (stake.equals("0")){
            if (pos.equals("BB")) {
                mv.setCurrPrc(m_currPD[2][0]);
            }
            else if (pos.equals("SB")) {
                mv.setCurrPrc(m_currPD[2][1]);
                tDiff[7][12]=1;
                tDiff[8][11]=1;tDiff[8][12]=1;
                tDiff[9][11]=1;tDiff[9][12]=1;
                tDiff[10][11]=1;tDiff[10][12]=1;
                tDiff[11][12]=1;

                tDiff[9][5]=1;//95o
                tDiff[10][4]=1; tDiff[10][5]=1;tDiff[10][9]=1;
                tDiff[11][4]=1; tDiff[11][5]=1;
                tDiff[12][3]=1; tDiff[12][4]=1;

                if (stakeSz.equals("40 BB")) {

                }
                else {
                    tDiff[11][3]=1;
                    tDiff[9][6]=1;
                }

                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1; tPush[1][5] = 1;tPush[1][6] = 1; tPush[1][7] = 1; tPush[1][8] = 1;tPush[1][9] = 1; tPush[1][10] = 1; tPush[1][11] = 1;tPush[1][12] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;tPush[2][6] = 1; tPush[2][7] = 1; tPush[2][8] = 1;tPush[2][9] = 1; tPush[2][10] = 1; tPush[2][11] = 1;tPush[2][12] = 1;
                    tPush[3][0] = 1; tPush[3][1] = 1; tPush[3][2] = 1; tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;tPush[3][6] = 1; tPush[3][7] = 1; tPush[3][8] = 1;tPush[3][9] = 1; tPush[3][10] = 1; tPush[3][11] = 1;
                    tPush[4][0] = 1; tPush[4][1] = 1; tPush[4][2] = 1; tPush[4][3] = 1; tPush[4][4] = 1; tPush[4][5] = 1;tPush[4][6] = 1; tPush[4][7] = 1; tPush[4][8] = 1;tPush[4][9] = 1; tPush[4][10] = 1;
                    tPush[5][0] = 1; tPush[5][1] = 1; tPush[5][2] = 1; tPush[5][3] = 1; tPush[5][4] = 1; tPush[5][5] = 1;tPush[5][6] = 1; tPush[5][7] = 1; tPush[5][8] = 1;tPush[5][9] = 1;
                    tPush[6][0] = 1; tPush[6][1] = 1; tPush[6][2] = 1; tPush[6][3] = 1; tPush[6][4] = 1; tPush[6][5] = 1;tPush[6][6] = 1; tPush[6][7] = 1; tPush[6][8] = 1;tPush[6][9] = 1;
                    tPush[7][0] = 1; tPush[7][1] = 1; tPush[7][2] = 1;                                   tPush[7][5] = 1;tPush[7][6] = 1; tPush[7][7] = 1; tPush[7][8] = 1;tPush[7][9] = 1; tPush[7][10] = 1;
                    tPush[8][0] = 1; tPush[8][1] = 1; tPush[8][2] = 1;                                                                    tPush[8][7] = 1; tPush[8][8] = 1;tPush[8][9] = 1; tPush[8][10] = 1;
                    tPush[9][0] = 1; tPush[9][1] = 1;                                                                                                                      tPush[9][9] = 1; tPush[9][10] = 1; tPush[9][11] = 1;
                    tPush[10][0] = 1;tPush[10][1]= 1;                                                                                                                                       tPush[10][10]= 1;
                    tPush[11][0] = 1;tPush[11][1]= 1;                                                                                                                                                         tPush[11][11] = 1;
                    tPush[12][0] = 1;tPush[12][1]= 1;                                                                                                                                                                          tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1; tPush[1][5] = 1;tPush[1][6] = 1; tPush[1][7] = 1; tPush[1][8] = 1;tPush[1][9] = 1; tPush[1][10] = 1; tPush[1][11] = 1;tPush[1][12] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;tPush[2][6] = 1; tPush[2][7] = 1; tPush[2][8] = 1;tPush[2][9] = 1;
                    tPush[3][0] = 1; tPush[3][1] = 1; tPush[3][2] = 1; tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;tPush[3][6] = 1; tPush[3][7] = 1;
                    tPush[4][0] = 1; tPush[4][1] = 1; tPush[4][2] = 1; tPush[4][3] = 1; tPush[4][4] = 1; tPush[4][5] = 1;tPush[4][6] = 1; tPush[4][7] = 1;tPush[4][8] = 1;
                    tPush[5][0] = 1; tPush[5][1] = 1; tPush[5][2] = 1; tPush[5][3] = 1; tPush[5][4] = 1; tPush[5][5] = 1;tPush[5][6] = 1; tPush[5][7] = 1;tPush[5][8] = 1;
                    tPush[6][0] = 1; tPush[6][1] = 1;                                                                    tPush[6][6] = 1; tPush[6][7] = 1;tPush[6][8] = 1;
                    tPush[7][0] = 1; tPush[7][1] = 1;                                                                                     tPush[7][7] = 1;tPush[7][8] = 1;tPush[7][9] = 1;
                    tPush[8][0] = 1; tPush[8][1] = 1;                                                                                                     tPush[8][8] = 1;tPush[8][9] = 1;
                    tPush[9][0] = 1;                                                                                                                                      tPush[9][9] = 1; tPush[9][10] = 1;
                    tPush[10][0] = 1;                                                                                                                                                      tPush[10][10] = 1;
                    tPush[11][0] = 1;                                                                                                                                                                        tPush[11][11] = 1;
                    tPush[12][0] = 1;                                                                                                                                                                                          tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1; tPush[1][5] = 1;tPush[1][6] = 1; tPush[1][7] = 1; tPush[1][8] = 1;tPush[1][9] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;tPush[2][6] = 1;
                    tPush[3][0] = 1; tPush[3][1] = 1; tPush[3][2] = 1; tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;tPush[3][6] = 1;
                    tPush[4][0] = 1; tPush[4][1] = 1; tPush[4][2] = 1; tPush[4][3] = 1; tPush[4][4] = 1; tPush[4][5] = 1;tPush[4][6] = 1; tPush[4][7] = 1;
                    tPush[5][0] = 1; tPush[5][1] = 1;                                                    tPush[5][5] = 1;tPush[5][6] = 1; tPush[5][7] = 1;
                    tPush[6][0] = 1;                                                                                     tPush[6][6] = 1; tPush[6][7] = 1;
                    tPush[7][0] = 1;                                                                                                      tPush[7][7] = 1;tPush[7][8] = 1;
                    tPush[8][0] = 1;                                                                                                                      tPush[8][8] = 1;
                    tPush[9][0] = 1;                                                                                                                                      tPush[9][9] = 1;
                    tPush[10][0] = 1;                                                                                                                                                     tPush[10][10] = 1;
                    tPush[11][0] = 1;                                                                                                                                                                       tPush[11][11] = 1;
                    tPush[12][0] = 1;                                                                                                                                                                                         tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;tPush[1][3] = 1; tPush[1][4] = 1; tPush[1][5] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1;tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;
                    tPush[3][0] = 1; tPush[3][1] = 1; tPush[3][2] = 1;tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;
                    tPush[4][0] = 1; tPush[4][1] = 1;                                  tPush[4][4] = 1; tPush[4][5] = 1; tPush[4][6] = 1;
                    tPush[5][0] = 1;                                                                    tPush[5][5] = 1; tPush[5][6] = 1;
                    tPush[6][0] = 1;                               tPush[6][6] = 1;
                    tPush[7][0] = 1;                                      tPush[7][7] = 1;
                    tPush[8][0] = 1;                                           tPush[8][8] = 1;
                    tPush[9][0] = 1;                                                 tPush[9][9] = 1;
                    tPush[10][0] = 1;                                                    tPush[10][10] = 1;
                    tPush[11][0] = 1;                                                           tPush[11][11] = 1;
                    tPush[12][0] = 1;                                                                 tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }

            }
            else if (pos.equals("Button")) {
                mv.setCurrChart(2); //to 2 players
                mv.setCurrPrc(m_currPD[2][2]);

                tDiff[3][12]=1;
                tDiff[4][11]=1;tDiff[4][12]=1;
                tDiff[7][2]=1;tDiff[7][3]=1;tDiff[7][4]=1;tDiff[7][5]=1;tDiff[7][6]=1;
                tDiff[8][1]=1;tDiff[8][2]=1;tDiff[8][3]=1;tDiff[8][4]=1;

                tDiff[9][1]=1;tDiff[9][2]=1;tDiff[9][3]=1;
                tDiff[10][1]=1;tDiff[10][2]=1;
                tDiff[11][1]=1;tDiff[11][2]=1;
                tDiff[12][1]=1;//K2o

                if (stakeSz.equals("40 BB")) {

                    tDiff[8][10]=1;
                }
                else{
                    tDiff[1][11]=1; tDiff[1][12]=1;
                    tDiff[2][10]=1; tDiff[2][11]=1; tDiff[2][12]=1;
                    tDiff[3][9]=1; tDiff[3][10]=1; tDiff[3][11]=1;
                    tDiff[4][8]=1;tDiff[4][9]=1;tDiff[4][10]=1;
                    tDiff[5][9]=1;
                    tDiff[6][2]=1;tDiff[6][3]=1;tDiff[6][4]=1;tDiff[6][5]=1; tDiff[6][9]=1;
                    tDiff[7][1]=1; tDiff[7][9]=1;
                    tDiff[8][9]=1;
                    tDiff[9][10]=1;
                }

                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1; tPush[1][5] = 1;tPush[1][6] = 1; tPush[1][7] = 1; tPush[1][8] = 1;tPush[1][9] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;tPush[2][6] = 1;
                    tPush[3][0] = 1; tPush[3][1] = 1; tPush[3][2] = 1; tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;tPush[3][6] = 1;
                    tPush[4][0] = 1; tPush[4][1] = 1; tPush[4][2] = 1; tPush[4][3] = 1; tPush[4][4] = 1; tPush[4][5] = 1;tPush[4][6] = 1;
                    tPush[5][0] = 1;                                                                     tPush[5][5] = 1;tPush[5][6] = 1; tPush[5][7] = 1;
                    tPush[6][0] = 1;                                                                                     tPush[6][6] = 1; tPush[6][7] = 1;
                    tPush[7][0] = 1;                                                                                                      tPush[7][7] = 1;
                    tPush[8][0] = 1;                                                                                                                       tPush[8][8] = 1;
                    tPush[9][0] = 1;                                                                                                                                        tPush[9][9] = 1;
                    tPush[10][0] = 1;                                                                                                                                                      tPush[10][10] = 1;
                    tPush[11][0] = 1;                                                                                                                                                                       tPush[11][11] = 1;
                    tPush[12][0] = 1;                                                                                                                                                                                         tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1; tPush[1][5] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;
                    tPush[3][0] = 1; tPush[3][1] = 1;                  tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1; tPush[4][5] = 1;
                    tPush[5][0] = 1;                                                                     tPush[5][5] = 1;tPush[5][6] = 1;
                    tPush[6][0] = 1;                                                                                     tPush[6][6] = 1;
                    tPush[7][0] = 1;                                                                                                     tPush[7][7] = 1;
                    tPush[8][0] = 1;                                                                                                                     tPush[8][8] = 1;
                    tPush[9][0] = 1;         tPush[9][9] = 1;
                    tPush[10][0] = 1;          tPush[10][10] = 1;
                    tPush[11][0] = 1;            tPush[11][11] = 1;
                                                   tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1;                 tPush[0][9] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1;
                    tPush[5][0] = 1;                                                                     tPush[5][5] = 1;
                                                                                                                          tPush[6][6] = 1;
                                                                                                                                          tPush[7][7] = 1;
                                                                                                                                                          tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    tPush[11][11] = 1;
                    tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;tPush[2][3] = 1;
                    tPush[3][0] = 1;                                  tPush[3][3] = 1;
                    tPush[4][0] = 1;                                                   tPush[4][4] = 1;
                                                                                                        tPush[5][5] = 1;
                                                                                                           tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    tPush[8][8] = 1;
                    tPush[9][9] = 1;
                    tPush[10][10] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("4")) {
                mv.setCurrChart(2); //to 2 players
                mv.setCurrPrc(m_currPD[2][3]);


                tDiff[3][7]=1;
                tDiff[4][7]=1;
                tDiff[5][6]=1;tDiff[5][7]=1;
                tDiff[6][1]=1; tDiff[6][7]=1;



                tDiff[11][11]=1;//33
                tDiff[12][12]=1;//22
                if (stakeSz.equals("40 BB")) {
                    tDiff[1][10]=1;tDiff[1][11]=1;tDiff[1][12]=1;
                    tDiff[2][8]=1;tDiff[2][9]=1;tDiff[2][10]=1;
                    tDiff[3][8]=1;
                    tDiff[6][8]=1;
                    tDiff[7][8]=1;
                    tDiff[8][9]=1;
                    tDiff[9][10]=1;
                    tDiff[5][3]=1;tDiff[5][4]=1;
                    tDiff[10][0]=1;
                }
                else{
                    tDiff[5][2]=1;
                }
                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1; tPush[1][5] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;
                    tPush[3][0] = 1; tPush[3][1] = 1; tPush[3][2] = 1; tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1; tPush[4][5] = 1;tPush[4][6] = 1;
                    tPush[5][0] = 1;                                                                     tPush[5][5] = 1;tPush[5][6] = 1;
                    tPush[6][0] = 1;                                                                                     tPush[6][6] = 1;
                    tPush[7][0] = 1;                                                                                                    tPush[7][7] = 1;
                                                                                                                                                         tPush[8][8] = 1;
                    tPush[9][0] = 1;                                                                                                                                      tPush[9][9] = 1;
                                                                                                                                                                                          tPush[10][10] = 1;
                                                                                                                                                                                                            tPush[11][11] = 1;
                                                                                                                                                                                                                              tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1;                tPush[0][9] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1;
                                                                                                        tPush[5][5] = 1;
                                                                                                                        tPush[6][6] = 1;
                                                   tPush[7][7] = 1;
                                                        tPush[8][8] = 1;
                                                             tPush[9][9] = 1;
                                                                  tPush[10][10] = 1;
                                                                     tPush[11][11] = 1;
                                                                           tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1;
                                                                                       tPush[4][4] = 1;
                                                                                                        tPush[5][5] = 1;
                       tPush[6][6] = 1;
                            tPush[7][7] = 1;

                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                     tPush[3][3] = 1;
                                                                                 tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("5")) {
                mv.setCurrChart(2); //to 2 players
                mv.setCurrPrc(m_currPD[2][4]);
                tDiff[1][8] = 1;tDiff[1][9] = 1;
                tDiff[2][7] = 1;
                tDiff[3][6] = 1;
                tDiff[4][6] = 1;
                tDiff[5][1]=1; tDiff[5][6] = 1;tDiff[5][7] = 1;
                tDiff[6][7] = 1;

                //tDiff[9][9]=1;//55 not shark

                if (stakeSz.equals("40 BB")) {
                    tDiff[1][10] = 1;
                    tDiff[3][7] = 1;
                    tDiff[4][7] = 1;
                    tDiff[7][0] = 1; tDiff[7][8] = 1;

                    tDiff[10][10] = 1;//44
                    tDiff[11][11] = 1;
                    tDiff[12][12] = 1;
                }
                else{

                }
                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1; tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1; tPush[1][5] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1; tPush[2][5] = 1;
                    tPush[3][0] = 1; tPush[3][1] = 1;                  tPush[3][3] = 1; tPush[3][4] = 1; tPush[3][5] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1; tPush[4][5] = 1;
                    tPush[5][0] = 1;                                                                     tPush[5][5] = 1;
                                                                                                                          tPush[6][6] = 1;
                                         tPush[7][7] = 1;
                                                tPush[8][8] = 1;
                                                       tPush[9][9] = 1;
                                                             tPush[10][10] = 1;
                                                                     tPush[11][11] = 1;
                                                                            tPush[12][12] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1;
                                                                                        tPush[4][4] = 1;
                                                                                                      tPush[5][5] = 1;
                                                                                                                    tPush[6][6] = 1;
                                                                                                                                  tPush[7][7] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;
                                                                                       tPush[4][4] = 1;
                                                                                                        tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                 tPush[2][2] = 1;
                                                         tPush[3][3] = 1;
                                                              tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("6")) {
                mv.setCurrChart(3); //to 3 players
                mv.setCurrPrc(m_currPD[2][5]);

                tDiff[2][6]=1;
                tDiff[3][6]=1;
                tDiff[4][2]=1;tDiff[4][3]=1;tDiff[4][6]=1;
                tDiff[5][6]=1;
                tDiff[6][0]=1;
                tDiff[9][9]=1;//55


                if (stakeSz.equals("40 BB")){
                    tDiff[0][12]=1;
                    tDiff[4][1]=1;
                    tDiff[5][7]=1;
                    tDiff[6][7]=1;
                    tDiff[10][10]=1;//44
                }
                else{

                }
                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1;  tPush[0][9] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                    tPush[4][0] = 1;                                                    tPush[4][4] = 1;
                                           tPush[5][5] = 1;
                                                  tPush[6][6] = 1;
                                                      tPush[7][7] = 1;
                                                             tPush[8][8] = 1;
                                                                   tPush[9][9] = 1;
                                                                          tPush[10][10] = 1;

                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                       tPush[3][3] = 1;
                               tPush[4][4] = 1;
                                       tPush[5][5] = 1;
                                               tPush[6][6] = 1;



                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                       tPush[3][3] = 1;
                                                                                       tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("7")) {
                mv.setCurrChart(4); //to 4 players
                mv.setCurrPrc(m_currPD[2][6]);
                tDiff[0][7]=1;tDiff[0][8]=1;tDiff[0][9]=1;tDiff[0][10]=1;
                tDiff[1][6]=1;
                tDiff[2][5]=1;tDiff[2][6]=1;
                tDiff[3][5]=1;
                tDiff[4][5]=1;

                tDiff[8][8]=1;//66

                if (stakeSz.equals("40 BB")){
                    tDiff[0][11]=1;tDiff[0][12]=1;
                    tDiff[1][7]=1;
                    tDiff[3][6]=1;
                    tDiff[4][6]=1;
                    tDiff[5][6]=1;
                    tDiff[9][9]=1;//55
                }
                else{
                    tDiff[3][2]=1;
                    tDiff[5][0]=1;
                }


                mv.setCurrDiff(tDiff);
                if (stakeSz.equals("5 BB")) {
                    tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 3; tPush[0][5] = 2; tPush[0][6] = 2; tPush[0][7] = 2; tPush[0][8] = 2; tPush[0][9] = 2; tPush[0][10] = 2; tPush[0][11] = 2; tPush[0][12] = 2;
                    tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 2; tPush[1][4] = 2; tPush[1][5] = 2; tPush[1][6] = 2; tPush[1][7] = 1; tPush[1][8] = 1; tPush[1][9] = -1; tPush[1][10] = -1;
                    tPush[2][0] = 3; tPush[2][1] = 2; tPush[2][2] = 3; tPush[2][3] = 2; tPush[2][4] = 2; tPush[2][5] = 2; tPush[2][6] =-1;
                    tPush[3][0] = 3; tPush[3][1] = 2; tPush[3][2] = 2; tPush[3][3] = 3; tPush[3][4] = 2; tPush[3][5] = 1; tPush[3][6] =-1;
                    tPush[4][0] = 3; tPush[4][1] = 2; tPush[4][2] = 1; tPush[4][3] =-1; tPush[4][4] = 3; tPush[4][5] = 1; tPush[4][6] =-1;
                    tPush[5][0] = 2; tPush[5][1] =-1;                      tPush[5][5] = 3;tPush[5][6] =-1;
                    tPush[6][0] = 2;                         tPush[6][6] = 3;
                    tPush[7][0] = 2;                              tPush[7][7] = 3;
                    tPush[8][0] =-1;tPush[8][8] = 2;
                    tPush[9][0] = 1;tPush[9][9] = 2;
                    tPush[10][0]=-1;tPush[10][10] = 2;
                    tPush[11][0]=-1;tPush[11][11] = 2;
                    tPush[12][12] = 2;
                    mv.setCurrPush(tPush);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                                              tPush[4][4] = 1;
                                                  tPush[5][5] = 1;
                                                     tPush[6][6] = 1;
                                                           tPush[7][7] = 1;

                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;
                                                                                    tPush[4][4] = 1;
                                                                                                   tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                                                      tPush[2][2] = 1;
                                                                       tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("8")) {
                mv.setCurrChart(4); //to 4 players

                mv.setCurrPrc(m_currPD[2][7]);
                tDiff[0][6] = 1;
                tDiff[0][7] = 1;
                tDiff[0][8] = 1;
                tDiff[0][9] = 1;
                tDiff[0][10] = 1;

                tDiff[1][5] = 1;//K9s
                tDiff[2][5] = 1;//Q9s
                tDiff[3][5] = 1;//J9s
                tDiff[4][5] = 1;//T9s

                tDiff[7][7] = 1;//77
                tDiff[8][8] = 1;//66


                if (stakeSz.equals("40 BB")){
                    tDiff[0][11] = 1; //A8-3s
                    tDiff[5][6] = 1;//98s
                    tDiff[9][9] = 1;//55
                }
                else{
                    tDiff[1][5] = 1;//K8s
                }

                mv.setCurrDiff(tDiff);

                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1;
                                                                                      tPush[4][4] = 1;
                                                                                                       tPush[5][5] = 1;
                                                                                                                        tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;
                                                                                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                                                      tPush[2][2] = 1;
                                                                       tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                                                      tPush[2][2] = 1;
                    mv.setCurrPush(tPush);
                }
            }
        }
        else if (stake.equals("Push")){
            if (pos.equals("BB")) {
                mv.setCurrPrc(-1);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1; tPush[2][1] = 1; tPush[2][2] = 1;
                    tPush[3][0] = 1;                                  tPush[3][3] = 1;
                    tPush[4][0] = 1;                                                   tPush[4][4] = 1;
                    tPush[5][0] = 1;                                                                   tPush[5][5] = 1;
                                                                                                                         tPush[6][6] = 1;
                     tPush[7][7] = 1;
                     tPush[8][8] = 1;
                     tPush[9][9] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][0] = 1;                                  tPush[3][3] = 1;
                                                                       tPush[4][4] = 1;
                                                                                       tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                      tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("SB")) {
                mv.setCurrPrc(-1);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][0] = 1;                                  tPush[3][3] = 1;
                    tPush[4][0] = 1;                                                   tPush[4][4] = 1;
                                                                                       tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    tPush[7][7] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                              tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;

                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                                                      tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;

                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("Button")) {
                mv.setCurrPrc(-1);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][0] = 1;                                  tPush[3][3] = 1;
                                                                       tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                                     tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("4")) {
                mv.setCurrPrc(-1);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                      tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    tPush[6][6] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                                      tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("5")) {
                mv.setCurrPrc(-1);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("6")) {
                mv.setCurrPrc(-1);
                if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("7")) {
                mv.setCurrPrc(-1);
               if (stakeSz.equals("10 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    tPush[4][4] = 1;
                    tPush[5][5] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("15 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("20 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    tPush[3][3] = 1;
                    mv.setCurrPush(tPush);
                }
                else if (stakeSz.equals("25 BB")) {
                    tPush[0][0] = 1; tPush[0][1] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][2] = 1;
                    mv.setCurrPush(tPush);
                }
            }
            else if (pos.equals("8")) {
                mv.setCurrPrc(-1);
            }
        }

        mv.invalidate();
    }
}
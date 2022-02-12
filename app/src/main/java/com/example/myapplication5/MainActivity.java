package com.example.myapplication5;

import android.os.Bundle;

import com.example.myapplication5.ui.main.MyView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
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

                RadioButton ActionLimp = (RadioButton) findViewById(R.id.radioButtonLimp);
                ActionLimp.setVisibility(View.VISIBLE);
                RadioButton ActionRaise = (RadioButton) findViewById(R.id.radioButtonRaise);
                ActionRaise.setVisibility(View.GONE);
                RadioButton ActionPush = (RadioButton) findViewById(R.id.radioButtonPush);
                ActionPush.setVisibility(View.VISIBLE);


                RadioButton Action0 = (RadioButton) findViewById(R.id.radioButton0);
                Action0.setVisibility(View.VISIBLE);
                RadioButton ActionR0x3 = (RadioButton) findViewById(R.id.radioButtonR0x3);
                ActionR0x3.setVisibility(View.GONE);
                RadioButton ActionL0 = (RadioButton) findViewById(R.id.radioButtonL0);
                ActionL0.setVisibility(View.GONE);
                RadioButton ActionRPush = (RadioButton) findViewById(R.id.radioButtonRPush);
                ActionRPush.setVisibility(View.VISIBLE);
                RadioButton ActionR0 = (RadioButton) findViewById(R.id.rbR0);
                ActionR0.setVisibility(View.VISIBLE);
                RadioButton ActionR1 = (RadioButton) findViewById(R.id.rbR1);
                ActionR1.setVisibility(View.VISIBLE);
                RadioButton ActionR2 = (RadioButton) findViewById(R.id.rbR2);
                ActionR2.setVisibility(View.GONE);
                RadioButton ActionR3 = (RadioButton) findViewById(R.id.rbR3);
                ActionR3.setVisibility(View.GONE);
                RadioButton ActionR4 = (RadioButton) findViewById(R.id.rbR4);
                ActionR4.setVisibility(View.GONE);
                RadioButton ActionR5 = (RadioButton) findViewById(R.id.rbR5);
                ActionR5.setVisibility(View.GONE);
                RadioButton ActionR01 = (RadioButton) findViewById(R.id.rbR01);
                ActionR01.setVisibility(View.GONE);
                RadioButton ActionR02 = (RadioButton) findViewById(R.id.rbR02);
                ActionR02.setVisibility(View.GONE);
                RadioButton ActionR12 = (RadioButton) findViewById(R.id.rbR12);
                ActionR12.setVisibility(View.GONE);
                RadioButton ActionR04 = (RadioButton) findViewById(R.id.rbR04);
                ActionR04.setVisibility(View.GONE);
                RadioButton ActionR03 = (RadioButton) findViewById(R.id.rbR03);
                ActionR03.setVisibility(View.GONE);
                RadioButton ActionR13 = (RadioButton) findViewById(R.id.rbR13);
                ActionR13.setVisibility(View.GONE);
                RadioButton ActionR23 = (RadioButton) findViewById(R.id.rbR23);
                ActionR23.setVisibility(View.GONE);
                RadioButton ActionR14 = (RadioButton) findViewById(R.id.rbR14);
                ActionR14.setVisibility(View.GONE);
                RadioButton ActionR24 = (RadioButton) findViewById(R.id.rbR24);
                ActionR24.setVisibility(View.GONE);
                RadioButton ActionR34 = (RadioButton) findViewById(R.id.rbR34);
                ActionR34.setVisibility(View.GONE);
                RadioButton Actionx3x3 = (RadioButton) findViewById(R.id.rbx3x3);
                Actionx3x3.setVisibility(View.GONE);
                RadioButton ActionLimpx3 = (RadioButton) findViewById(R.id.rbLimpx3);
                ActionLimpx3.setVisibility(View.GONE);
                RadioButton ActionRx3BB = (RadioButton) findViewById(R.id.rbRx3BB);
                ActionRx3BB.setVisibility(View.GONE);
                RadioButton ActionRx3SB = (RadioButton) findViewById(R.id.rbRx3SB);
                ActionRx3SB.setVisibility(View.GONE);
                RadioButton ActionRx3BTN = (RadioButton) findViewById(R.id.rbRx3BTN);
                ActionRx3BTN.setVisibility(View.GONE);
                RadioButton ActionRx3CO = (RadioButton) findViewById(R.id.rbRx3CO);
                ActionRx3CO.setVisibility(View.GONE);
                RadioButton ActionRx3HJ = (RadioButton) findViewById(R.id.rbRx3HJ);
                ActionRx3HJ.setVisibility(View.GONE);
                //RadioButton curGame = (RadioButton) findViewById(rgGame.getCheckedRadioButtonId());
                switch (checkedId) {
                    case R.id.radioButton1:
                     //   tv.setText("BB " + curStrb.getText());
                        Action0.setVisibility(View.GONE);
                        ActionLimp.setVisibility(View.GONE);
                        ActionR0x3.setVisibility(View.VISIBLE);
                        ActionL0.setVisibility(View.VISIBLE);
                        ActionR2.setVisibility(View.VISIBLE);
                        ActionR3.setVisibility(View.VISIBLE);
                        ActionR4.setVisibility(View.VISIBLE);
                        ActionR5.setVisibility(View.VISIBLE);
                        ActionR0.setVisibility(View.GONE);
                        ActionRPush.setVisibility(View.GONE);
                        ActionR01.setVisibility(View.VISIBLE);
                        ActionR02.setVisibility(View.VISIBLE);
                        ActionR12.setVisibility(View.VISIBLE);
                        ActionR03.setVisibility(View.VISIBLE);
                        ActionR13.setVisibility(View.VISIBLE);
                        ActionR23.setVisibility(View.VISIBLE);
                        ActionR04.setVisibility(View.VISIBLE);
                        ActionR14.setVisibility(View.VISIBLE);
                        ActionR24.setVisibility(View.VISIBLE);
                        ActionR34.setVisibility(View.VISIBLE);
                        calcChart("BB", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                        break;
                    case R.id.radioButton2:
                        Actionx3x3.setVisibility(View.VISIBLE);
                        ActionLimpx3.setVisibility(View.VISIBLE);
                        ActionR2.setVisibility(View.VISIBLE);
                        ActionR3.setVisibility(View.VISIBLE);
                        ActionR4.setVisibility(View.VISIBLE);
                        ActionR01.setVisibility(View.VISIBLE);
                        ActionR02.setVisibility(View.VISIBLE);
                        ActionR12.setVisibility(View.VISIBLE);
                        ActionR03.setVisibility(View.VISIBLE);
                        ActionR13.setVisibility(View.VISIBLE);
                        ActionR23.setVisibility(View.VISIBLE);
                        calcChart("SB", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                   //     tv.setText("SB " + curStrb.getText());
                        break;
                    case R.id.radioButton3:
                        ActionRx3BB.setVisibility(View.VISIBLE);
                        ActionRx3SB.setVisibility(View.VISIBLE);
                        ActionR2.setVisibility(View.VISIBLE);
                        ActionR3.setVisibility(View.VISIBLE);
                        ActionR01.setVisibility(View.VISIBLE);
                        ActionR02.setVisibility(View.VISIBLE);
                        ActionR12.setVisibility(View.VISIBLE);
                        calcChart("Button", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                    //    tv.setText("Button " + curStrb.getText());
                        break;
                    case R.id.radioButton4:
                        ActionRx3BB.setVisibility(View.VISIBLE);
                        ActionRx3SB.setVisibility(View.VISIBLE);
                        ActionRx3BTN.setVisibility(View.VISIBLE);
                        ActionR2.setVisibility(View.VISIBLE);
                        ActionR01.setVisibility(View.VISIBLE);
                        calcChart("4", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                     //   tv.setText("4 " + curStrb.getText());
                        break;
                    case R.id.radioButton5:
                        ActionRx3BB.setVisibility(View.VISIBLE);
                        ActionRx3SB.setVisibility(View.VISIBLE);
                        ActionRx3BTN.setVisibility(View.VISIBLE);
                        ActionRx3CO.setVisibility(View.VISIBLE);
                        calcChart("5", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                      //  tv.setText("5 " + curStrb.getText());
                        break;
                    case R.id.radioButton6:
                        ActionRx3BB.setVisibility(View.VISIBLE);
                        ActionRx3SB.setVisibility(View.VISIBLE);
                        ActionRx3BTN.setVisibility(View.VISIBLE);
                        ActionRx3CO.setVisibility(View.VISIBLE);
                        ActionRx3HJ.setVisibility(View.VISIBLE);
                        calcChart("6", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                       // tv.setText("6 " + curStrb.getText());
                        break;
                    case R.id.radioButton7:
                        ActionR0.setVisibility(View.GONE);
                        ActionR1.setVisibility(View.GONE);
                        ActionRaise.setVisibility(View.VISIBLE);
                        calcChart("7", String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
                       // tv.setText("7 " + curStrb.getText());
                        break;
                    case R.id.radioButton8:
                        ActionR0.setVisibility(View.GONE);
                        ActionR1.setVisibility(View.GONE);
                        ActionPush.setVisibility(View.GONE);

                        ActionLimp.setVisibility(View.GONE);
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

                RadioButton curAction = (RadioButton) findViewById(checkedId);
                calcChart(String.valueOf(curPosrb.getText()), String.valueOf(curAction.getText()), String.valueOf(curStSz.getText()));
            }
        });

        rgStakeSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton curPosrb =(RadioButton) findViewById(rgPos.getCheckedRadioButtonId());
                RadioButton curAction = (RadioButton) findViewById(rgAction.getCheckedRadioButtonId());

                RadioButton curStake = (RadioButton) findViewById(checkedId);
                calcChart(String.valueOf(curPosrb.getText()), String.valueOf(curAction.getText()),String.valueOf(curStake.getText()));
            }
        });


    }

    protected void calcDP() {
        //m_currPD
    }

    protected void raiseAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
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

            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {

            }
            else{
                tDiff[8][3]=1;tDiff[8][4]=1;
            }

            mv.setCurrDiff(tDiff);

            if (tCurrStake<=12) {
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
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18)) {
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
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
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
            else if (tCurrStake > 22) {
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

            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
                tDiff[1][8]=1;
                tDiff[5][7]=1;//97s
                tDiff[9][10]=1;
            }
            else{
                tDiff[2][6]=1;
            }
            mv.setCurrDiff(tDiff);


            if (tCurrStake<=12) {
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
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18)) {
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
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
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
            else if (tCurrStake > 22) {
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
            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
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

            if (tCurrStake<=12) {
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
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18)) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                tPush[6][6] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                tPush[6][6] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake > 22) {
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

            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
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
            if (tCurrStake<=12) {
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
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18)) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                tPush[6][6] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake > 22) {
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

            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
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
            if(tCurrStake<=12) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                tPush[6][6] = 1;
                tPush[7][7] = 1;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18)) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake > 22) {
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

            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
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
            if (tCurrStake<=12) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3 ] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                tPush[6][6] = 1;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18)) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;
                tPush[2][2] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake > 22) {
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





            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
                tDiff[0][5]=1;
                tDiff[3][4]=1;
                tDiff[7][7]=1;
                tDiff[6][6]=1;
                tDiff[2][3]=1;
            }
            else if(stakeSz.equals("30 BB")){
                tDiff[6][6]=1;
                tDiff[2][3]=1;
            }
            else{

            }
            mv.setCurrDiff(tDiff);
            //+ pushes
            tPush[0][0] = 3;
            if (tCurrStake < 51) {
                tPush[0][1] = 3; //AKs
                tPush[1][1] = 3; //KK
            }
            if (tCurrStake < 41)
                tPush[1][0] = 3; //AKo
            if (tCurrStake < 31)
                tPush[2][2] = 3; //QQ
            if (tCurrStake < 26)
                tPush[3][3] = 3; //JJ
            if (tCurrStake < 21)
                tPush[0][2] = 3; //AQs
            if (tCurrStake < 16)
                tPush[4][4] = 3; //TT
            if (tCurrStake < 13) {
                tPush[2][0] = 3; //AQo
                tPush[5][5] = 3; //99
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            if (tCurrStake < 9)
                tPush[0][3] = 2; //AJs
            if (tCurrStake < 7)  //6
                tPush[0][3] = 3; //AJs
            if (tCurrStake < 5) { //4
                tPush[0][4] = 2; //ATs
                tPush[6][6] = 3; //88
                tPush[3][0] = 3; //AJo
            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("8")) {
        }
    }

    protected void limpAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull ) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("BB")) {
            mv.setCurrPrc(m_currPD[1][0]);
            if (tCurrStake <= 12) {
                tPush[0][0] = 1; tPush[0][1] = 1;tPush[0][2] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1;
                tPush[2][2] = 1;
                tPush[3][3] = 1;
                tPush[4][4] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18)) {
                tPush[0][0] = 1; tPush[0][1] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1;
                tPush[2][2] = 1;
                tPush[3][3] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 1; tPush[0][1] = 1;
                tPush[1][0] = 1; tPush[1][1] = 1;
                tPush[2][2] = 1;
                tPush[3][3] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake > 22) {
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

            if (tCurrStake <= 5) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 3;tPush[0][5] = 3; tPush[0][6] = 3; tPush[0][7] = 3;tPush[0][8] = 3; tPush[0][9] = 3;tPush[0][10] = 2;tPush[0][11] = 2;tPush[0][12] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 3; tPush[1][4] = 2;tPush[1][5] = 2;
                tPush[2][0] = 3; tPush[2][1] = 3; tPush[2][2] = 3; tPush[2][3] = 2; tPush[2][4] = 2;tPush[2][5] = 1;
                tPush[3][0] = 3; tPush[3][1] = 2; tPush[3][2] = 1; tPush[3][3] = 3; tPush[3][4] = 2;
                tPush[4][0] = 3;                                                    tPush[4][4] = 3;tPush[4][5] = 1;
                tPush[5][0] = 3; tPush[5][5] = 3;
                tPush[6][0] = 3 ;tPush[6][6] = 3;
                tPush[7][0] = 2; tPush[7][7] = 3;
                tPush[8][0] = 2;tPush[8][8] = 3;
                tPush[9][0] = 2;tPush[9][9] = 3;
                tPush[10][0] = 2; tPush[10][10] = 3;
                tPush[11][11] = 3;
                tPush[12][12] = 2;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if (tCurrStake <= 12) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 3;tPush[0][5] = 3; tPush[0][6] = 3; tPush[0][7] = 3;tPush[0][8] = 2; tPush[0][9] = 3;tPush[0][10] = 2;tPush[0][11] = 2;tPush[0][12] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 3; tPush[1][4] = 3;tPush[1][5] = 1;
                tPush[2][0] = 3; tPush[2][1] = 3; tPush[2][2] = 3; tPush[2][3] = 3; tPush[2][4] = 3;tPush[2][5] = 2;
                tPush[3][0] = 3; tPush[3][1] = 1;                  tPush[3][3] = 3; tPush[3][4] = 3;tPush[3][5] = 2;
                tPush[4][0] = 3;                                                    tPush[4][4] = 3;tPush[4][5] = 2;
                tPush[5][0] = 3; tPush[5][5] = 3;
                tPush[6][0] = 1; tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 3;
                tPush[9][9] = 3;
                tPush[10][10] = 3;
                tPush[11][11] = 3;
                tPush[12][12] = 2;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18))  {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 3;tPush[0][5] = 2; tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][9] = 1;tPush[0][10] = 1;tPush[0][11] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 3; tPush[1][4] = 3;tPush[1][5] = 2;
                tPush[2][0] = 3; tPush[2][1] = 3; tPush[2][2] = 3; tPush[2][3] = 3; tPush[2][4] = 3;tPush[2][5] = 2;
                tPush[3][0] = 3;                                   tPush[3][3] = 3; tPush[3][4] = 2;tPush[3][5] = 1;
                tPush[4][0] = 2;                                                    tPush[4][4] = 3;tPush[4][5] = 1;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 3;
                tPush[9][9] = 3;
                tPush[10][10] = 3;
                tPush[11][11] = 3;
                tPush[12][12] = 2;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 2;tPush[0][5] = 1; tPush[0][6] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 3; tPush[1][4] = 3;
                tPush[2][0] = 3; tPush[2][0] = 2; tPush[2][2] = 3; tPush[2][3] = 3; tPush[2][4] = 2;
                tPush[3][0] = 3;                                   tPush[3][3] = 3; tPush[3][4] = 2;
                tPush[4][0] = 1;                                                    tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 2;
                tPush[9][9] = 2;
                tPush[10][10] = 2;
                tPush[11][11] = 2;
                tPush[12][12] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 26) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 3; tPush[1][4] = 2;
                tPush[2][0] = 3;                  tPush[2][2] = 3; tPush[2][3] = 2; tPush[2][4] = 1;
                tPush[3][0] = 2;                                   tPush[3][3] = 3; tPush[3][4] = 1;
                tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 1;
                tPush[8][8] = 1;
                tPush[9][9] = 1;
                tPush[10][10] = 1;
                tPush[11][11] = 1;
                tPush[12][12] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 31) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 2; tPush[0][4] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 2; tPush[1][4] = 1;
                tPush[2][0] = 3;                  tPush[2][2] = 3; tPush[2][3] = 1; tPush[2][4] = 1;
                tPush[3][0] = 1;                                   tPush[3][3] = 3;
                tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 1;
                tPush[7][7] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 41) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 2; tPush[0][3] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 1; tPush[1][3] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 3;
                                                                  tPush[3][3] = 3;
                tPush[4][4] = 2;
                tPush[5][5] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 51) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3;
                         tPush[2][2] = 3;
                         tPush[3][3] = 2;
                tPush[4][4] = 1;

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

            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
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
            if (tCurrStake <= 5) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 3;tPush[0][4] = 3;tPush[0][5] = 3;tPush[0][6] = 3;tPush[0][7] = 2;tPush[0][8] = 2;tPush[0][9] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 3;tPush[1][4] = 2;
                tPush[2][0] = 3; tPush[2][1] = 2; tPush[2][2] = 3;tPush[2][3] = 2;
                tPush[3][0] = 3;                                  tPush[3][3] = 3;
                tPush[4][0] = 3;                                                  tPush[4][4] = 3;
                tPush[5][0] = 2;                                                          tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 3;
                tPush[9][9] = 3;
                tPush[10][10] = 2;
                tPush[11][11] = 2;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if (tCurrStake <= 12) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 3;tPush[0][4] = 3;tPush[0][5] = 3;tPush[0][6] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 3;tPush[1][4] = 3;tPush[1][5] = 1;
                tPush[2][0] = 3; tPush[2][1] = 3; tPush[2][2] = 3;tPush[2][3] = 3;tPush[2][4] = 2;
                tPush[3][0] = 3;                                  tPush[3][3] = 3;tPush[3][4] = 2;
                tPush[4][0] = 3;                                                  tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 3;
                tPush[9][9] = 3;
                tPush[10][10] = 2;
                tPush[11][11] = 1;
                tPush[12][12] = 1;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18))  {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 3;tPush[0][4] = 3;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 3;tPush[1][4] = 3;
                tPush[2][0] = 3; tPush[2][1] = 1; tPush[2][2] = 3;tPush[2][3] = 3;tPush[2][4] = 1;
                tPush[3][0] = 3;                                  tPush[3][3] = 3;tPush[3][4] = 1;
                tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 2;
                tPush[9][9] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 3;tPush[0][4] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 3;tPush[1][4] = 2;
                tPush[2][0] = 3;                  tPush[2][2] = 3;tPush[2][3] = 3;tPush[2][4] = 1;
                tPush[3][0] = 1;                                  tPush[3][3] = 3;tPush[3][4] = 1;
                tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 26) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 2;tPush[1][4] = 1;
                tPush[2][0] = 3;                  tPush[2][2] = 3;tPush[2][3] = 1;
                tPush[3][3] = 3;
                tPush[4][4] = 3;
                tPush[5][5] = 2;
                tPush[6][6] = 1;
                mv.setCurrPush(tPush);
            }


            else if (tCurrStake < 31) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 2;tPush[1][3] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 3;
                tPush[3][3] = 3;
                tPush[4][4] = 3;
                tPush[5][5] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 51) {
                tPush[0][0] = 3; tPush[0][1] = 3;
                tPush[1][0] = 2; tPush[1][1] = 3;
                tPush[2][2] = 3;
                tPush[3][3] = 1;
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


            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
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

            if (tCurrStake <= 5) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 3;tPush[0][4] = 3;tPush[0][5] = 3;tPush[0][6] = 1;tPush[0][7] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 2;tPush[1][4] = 1;
                tPush[2][0] = 3; tPush[2][1] = 1; tPush[2][2] = 3;tPush[2][3] = 1;
                tPush[3][0] = 3;                                  tPush[3][3] = 3;
                tPush[4][0] = 3;                                                  tPush[4][4] = 3;
                tPush[5][0] = 1;                                                                  tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 3;
                tPush[9][9] = 3;
                tPush[10][10] = 1;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if (tCurrStake <= 12) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 3;tPush[0][4] = 3;tPush[0][5] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 3;tPush[1][4] = 2;tPush[1][5] = 1;
                tPush[2][0] = 3; tPush[2][1] = 2; tPush[2][2] = 3;tPush[2][3] = 2;tPush[2][4] = 1;
                tPush[3][0] = 3;                                  tPush[3][3] = 3;tPush[3][4] = 1;
                tPush[4][0] = 1;                                                  tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 3;
                tPush[9][9] = 3;
                tPush[10][10] = 1;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18))  {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 2;tPush[0][4] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 2;tPush[1][3] = 2;tPush[1][4] = 2;
                tPush[2][0] = 2; tPush[2][1] = 1; tPush[2][2] = 3;tPush[2][3] = 2;tPush[2][4] = 1;
                tPush[3][0] = 1;                                  tPush[3][3] = 3;tPush[3][4] = 1;
                tPush[4][4] = 3;
                tPush[5][5] = 2;
                tPush[6][6] = 2;
                tPush[7][7] = 2;
                tPush[8][8] = 1;
                tPush[9][9] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 2;tPush[1][3] = 2;tPush[1][4] = 1;
                tPush[2][0] = 3;                  tPush[2][2] = 3;tPush[2][3] = 1;tPush[2][4] = 1;
                                                                  tPush[3][3] = 3;tPush[3][4] = 1;
                tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 26) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 1; tPush[1][4] = 1;
                tPush[2][0] = 2;                  tPush[2][2] = 3;
                tPush[3][3] = 3;
                tPush[4][4] = 3;
                tPush[5][5] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 31) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 1;tPush[1][3] = 1;
                tPush[2][0] = 1; tPush[2][2] = 3;
                tPush[3][3] = 3;
                tPush[4][4] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 51) {
                tPush[0][0] = 3; tPush[0][1] = 2;
                tPush[1][0] = 2; tPush[1][1] = 3;
                tPush[2][2] = 1;
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


            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
                tDiff[4][6]=1;
                tDiff[9][9]=1;
                tDiff[10][10]=1;
            }
            else{
                tDiff[5][0]=1;
            }
            mv.setCurrDiff(tDiff);
            if (tCurrStake <= 5) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 2;tPush[0][5] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 1;
                tPush[2][0] = 3; tPush[2][1] = 1; tPush[2][2] = 3;
                tPush[3][0] = 2;                                   tPush[3][3] = 3;
                tPush[4][0] = 1; tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 3;
                tPush[9][9] = 1;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if (tCurrStake <= 12) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 3; tPush[1][4] = 1;
                tPush[2][0] = 3; tPush[2][1] = 1; tPush[2][2] = 3; tPush[2][3] = 3; tPush[2][4] = 1;
                tPush[3][0] = 1;                                   tPush[3][3] = 3; tPush[3][4] = 1;
                tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[8][8] = 3;
                tPush[9][9] = 1;
                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18))  {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 3;tPush[0][4] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 3;tPush[1][4] = 2;
                tPush[2][0] = 3;                  tPush[2][2] = 3;tPush[2][3] = 2;tPush[2][4] = 1;
                tPush[3][0] = 1;                                  tPush[3][3] = 3;tPush[3][4] = 1;
                tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 2;
                tPush[7][7] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 1;tPush[1][4] = 1;
                tPush[2][0] = 3;                  tPush[2][2] = 3;tPush[2][3] = 1;
                tPush[3][3] = 3;
                tPush[4][4] = 3;
                tPush[5][5] = 1;
                tPush[6][6] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 26) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][2] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][2] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 3;
                tPush[3][3] = 3;
                tPush[4][4] = 1;
                tPush[5][5] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 31) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 1;
                                                  tPush[2][2] = 3;
                tPush[3][3] = 3;
                tPush[4][4] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 51) {
                tPush[0][0] = 3; tPush[0][1] = 2;
                tPush[1][0] = 2; tPush[1][1] = 3;
                tPush[2][2] = 1;
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


            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
                tDiff[4][0]=1;
                tDiff[9][9]=1;
            }
            else{

            }
            mv.setCurrDiff(tDiff);

            if (tCurrStake <= 5) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 2; tPush[0][5] = 1;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 2;
                tPush[2][0] = 3;                  tPush[2][2] = 3;
                tPush[3][0] = 2;                                   tPush[3][3] = 3;
                tPush[4][0] = 1;                                                   tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 2;
                tPush[8][8] = 2;
                tPush[9][9] = 1;

                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if (tCurrStake <= 12) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3; tPush[0][3] = 3; tPush[0][4] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3; tPush[1][3] = 3; tPush[1][4] = 2;
                tPush[2][0] = 3; tPush[2][1] = 2; tPush[2][2] = 3; tPush[2][3] = 1; tPush[2][4] = 1;
                tPush[3][0] = 2;                                   tPush[3][3] = 3; tPush[3][4] = 1;
                tPush[4][4] = 3;
                tPush[5][5] = 3;
                tPush[6][6] = 3;
                tPush[7][7] = 2;
                tPush[8][8] = 2;
                tPush[9][9] = 2;

                mv.setCurrPush(tPush);
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            else if ((tCurrStake > 12)&&(tCurrStake < 18))  {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;tPush[0][3] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 2;
                tPush[2][0] = 2;                  tPush[2][2] = 3;tPush[2][3] = 1;
                tPush[3][3] = 3;
                tPush[4][4] = 3;
                tPush[5][5] = 2;
                tPush[6][6] = 1;
                tPush[7][7] = 1;
                mv.setCurrPush(tPush);
            }
            else if ((tCurrStake > 17)&&(tCurrStake < 23)) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 3;tPush[1][3] = 1;
                tPush[2][0] = 1;                  tPush[2][2] = 3;
                tPush[3][3] = 3;
                tPush[4][4] = 2;
                tPush[5][5] = 2;
                tPush[6][6] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 26) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 3;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 1; tPush[1][3] = 1;
                tPush[2][2] = 3;
                tPush[3][3] = 3;
                tPush[4][4] = 2;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 31) {
                tPush[0][0] = 3; tPush[0][1] = 3; tPush[0][2] = 2;
                tPush[1][0] = 3; tPush[1][1] = 3; tPush[1][2] = 1;
                tPush[2][2] = 3;
                tPush[3][3] = 2;
                tPush[4][4] = 1;
                mv.setCurrPush(tPush);
            }
            else if (tCurrStake < 51) {
                tPush[0][0] = 3; tPush[0][1] = 3;
                tPush[1][0] = 3; tPush[1][1] = 3;
                tPush[2][2] = 2;
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
            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
                tDiff[0][8]=1;
                tDiff[3][5]=1;
                tDiff[8][8]=1;
            }
            mv.setCurrDiff(tDiff);

            //+ pushes
            tPush[0][0] = 3;
            if (tCurrStake < 51)
                tPush[1][1] = 3; //KK
            if (tCurrStake < 41)
                tPush[0][1] = 3; //AKs
            if (tCurrStake < 31) {
                tPush[1][0] = 3; //AKo
                tPush[2][2] = 2; //QQ
            }
            if (tCurrStake < 26)
                tPush[2][2] = 3; //QQ
            if (tCurrStake < 21)
                tPush[3][3] = 3; //JJ
            if (tCurrStake < 13) {
                tPush[0][2] = 3; //AQs
                tPush[4][4] = 3; //TT
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
            if (tCurrStake < 9) {
                tPush[0][3] = 3; //AJs
                tPush[5][5] = 3; //99
                tPush[6][6] = 3; //88
                tPush[2][0] = 3; //AQo
            }
            if (tCurrStake < 6)  //5
                tPush[3][0] = 2; //AJo
            mv.setCurrPush(tPush);
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
            if (tCurrStake <= 12) {
                mv.setCurrPrc(-1);
                mv.setCurrDiff(tNull);
            }
        }
    }

    protected void foldAction_2p(MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        mv.setCurrPrc(m_currPD[2][1]);
        tDiff[7][12]=1;
        tDiff[8][11]=1; tDiff[8][12]=1;
        tDiff[9][11]=1; tDiff[9][12]=1;
        tDiff[10][11]=1; tDiff[10][12]=1;
        tDiff[11][12]=1;
        tDiff[9][5]=1;//95o
        tDiff[10][4]=1; tDiff[10][5]=1;tDiff[10][9]=1;
        tDiff[11][4]=1; tDiff[11][5]=1;
        tDiff[12][3]=1; tDiff[12][4]=1;
        if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
        }
        else {
            tDiff[11][3]=1;
            tDiff[9][6]=1;
        }

        mv.setCurrDiff(tDiff);
        if (stakeSz.equals("2 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,2},
                    {3,3,3,3,3,3,3,3,3,3,3,2,2},
                    {3,3,3,3,3,3,3,3,3,3,3,2,2},
                    {3,3,3,3,3,3,2,2,2,2,3,2,2},
                    {3,3,3,3,3,3,2,2,2,2,2,3,2},
                    {3,3,3,3,3,2,2,2,2,2,2,2,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("3 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,2},
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,3,3,3,3,3,2,2,2,2},
                    {3,3,3,3,3,3,2,3,3,2,2,2,2},
                    {3,3,3,3,3,2,2,2,3,2,2,2,2},
                    {3,3,3,3,2,2,2,2,2,3,2,2,2},
                    {3,3,3,3,2,2,2,2,2,2,3,2,1},
                    {3,3,3,3,2,2,2,1,-1,-1,0,3,-1},
                    {3,3,3,2,2,2,1,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
            else if (stakeSz.equals("4 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,3,3,3,2},
                            {3,3,3,3,3,3,3,3,3,2,2,2,2},
                            {3,3,3,3,3,3,3,3,2,2,2,2,2},
                            {3,3,3,3,3,3,3,2,2,2,2,2,1},
                            {3,3,3,3,2,2,2,3,2,2,2,1,0},
                            {3,3,3,2,2,2,2,2,3,2,2,1,0},
                            {3,3,3,2,2,2,2,2,1,3,2,1,0},
                            {3,3,3,2,2,2,-1,-1,0,-1,3,-1,0},
                            {3,3,3,2,2,1,0,0,0,0,0,3,0},
                            {3,3,2,2,2,-1,0,0,0,0,0,0,3},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("5 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,3,2,2,2},
                            {3,3,3,3,3,3,3,3,2,2,2,2,2},
                            {3,3,3,3,3,3,3,2,2,2,2,2,1},
                            {3,3,3,3,3,2,3,2,2,2,2,-1,-1},
                            {3,3,3,3,2,2,2,3,2,2,2,-1,0},
                            {3,3,3,2,2,2,2,2,3,2,2,-1,0},
                            {3,3,3,2,2,2,1,-1,-1,3,2,1,0},
                            {3,3,3,2,2,-1,0,0,0,0,3,-1,0},
                            {3,3,2,2,1,0,0,0,0,0,0,3,0},
                            {3,3,2,2,1,0,0,0,0,0,0,0,3},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("6 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,3,3,3,2},
                            {3,3,3,3,3,3,3,3,2,2,2,2,2},
                            {3,3,3,3,3,3,3,2,2,2,2,2,2},
                            {3,3,3,3,3,3,2,2,2,2,1,1,-1},
                            {3,3,3,3,2,2,3,2,2,2,1,-1,0},
                            {3,3,3,2,2,2,2,3,2,2,1,-1,0},
                            {3,3,3,2,2,2,1,1,3,2,1,-1,0},
                            {3,3,2,2,1,-1,-1,-1,-1,3,2,-1,0},
                            {3,3,2,2,1,0,0,0,0,0,3,-1,0},
                            {3,3,2,2,-1,0,0,0,0,0,0,3,0},
                            {3,3,2,2,-1,0,0,0,0,0,0,0,3},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
            else if (stakeSz.equals("7 BB")) { // 0
                int[][] tPush2 = new int[][] {
                        {3,3,3,3,3,3,3,3,3,3,3,3,3},
                        {3,3,3,3,3,3,3,3,3,3,3,3,3},
                        {3,3,3,3,3,3,3,3,3,3,3,3,2},
                        {3,3,3,3,3,3,3,3,2,2,2,2,2},
                        {3,3,3,3,3,3,2,2,2,2,2,1,1},
                        {3,3,3,3,2,3,2,2,2,2,-1,-1,-1},
                        {3,3,3,2,2,2,3,2,2,2,-1,-1,0},
                        {3,3,3,2,2,2,1,3,2,2,1,-1,0},
                        {3,3,2,2,1,-1,-1,-1,3,2,1,-1,0},
                        {3,3,2,2,-1,0,0,-1,-1,3,2,-1,-1},
                        {3,3,2,2,-1,0,0,0,0,0,3,-1,0},
                        {3,3,2,1,0,0,0,0,0,0,0,3,0},
                        {3,3,2,-1,0,0,0,0,0,0,0,0,3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (stakeSz.equals("8 BB")) { // 0
                int[][] tPush2 = new int[][] {
                        {3,3,3,3,3,3,3,3,3,3,3,3,3},
                        {3,3,3,3,3,3,3,3,3,3,3,3,3},
                        {3,3,3,3,3,3,3,3,3,2,2,2,2},
                        {3,3,3,3,3,3,3,2,2,2,2,2,2},
                        {3,3,3,3,3,3,2,2,2,1,1,1,-1},
                        {3,3,3,2,2,3,2,2,2,1,-1,-1,-1},
                        {3,3,3,2,2,2,3,2,2,1,-1,0,0},
                        {3,3,2,2,2,1,1,3,2,2,-1,-1,0},
                        {3,3,2,2,-1,-1,-1,-1,3,2,1,-1,0},
                        {3,3,2,1,0,0,0,-1,-1,3,1,-1,-1},
                        {3,3,2,-1,0,0,0,0,0,0,3,-1,0},
                        {3,3,2,-1,0,0,0,0,0,0,0,3,0},
                        {3,2,2,-1,0,0,0,0,0,0,0,0,3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (stakeSz.equals("9 BB")) { // 0
                int[][] tPush2 = new int[][] {
                        {3,3,3,3,3,3,3,3,3,3,3,3,3},
                        {3,3,3,3,3,3,3,3,3,3,3,3,3},
                        {3,3,3,3,3,3,3,3,3,2,2,2,2},
                        {3,3,3,3,3,3,3,2,2,2,2,1,1},
                        {3,3,3,3,3,3,2,2,2,1,-1,-1,-1},
                        {3,3,3,2,2,3,2,2,1,1,-1,-1,0},
                        {3,3,3,2,2,1,3,2,2,1,-1,0,0},
                        {3,3,2,2,1,-1,-1,3,2,1,-1,-1,0},
                        {3,3,2,-1,-1,-1,-1,-1,3,2,1,-1,0},
                        {3,3,2,-1,0,0,0,0,-1,3,1,-1,0},
                        {3,3,2,-1,0,0,0,0,0,0,3,-1,0},
                        {3,3,2,-1,0,0,0,0,0,0,0,3,0},
                        {3,2,1,0,0,0,0,0,0,0,0,0,3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        else if (stakeSz.equals("10 BB")) {
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,3,3,2,2,2,2,1,1,-1},
                    {3,3,3,3,3,2,2,2,1,-1,-1,-1,-1},
                    {3,3,3,2,2,3,2,2,1,-1,-1,-1,0},
                    {3,3,2,2,1,1,3,2,1,1,-1,0,0},
                    {3,3,2,1,-1,-1,-1,3,2,1,-1,0,0},
                    {3,3,2,-1,-1,-1,-1,-1,3,1,-1,-1,0},
                    {3,3,2,-1,0,0,0,0,-1,3,1,-1,0},
                    {3,2,1,-1,0,0,0,0,0,0,3,-1,0},
                    {3,2,1,0,0,0,0,0,0,0,0,3,0},
                    {3,2,-1,0,0,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("11 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,2,2,2,2,2,2},
                    {3,3,3,3,3,2,2,2,1,1,1,-1,-1},
                    {3,3,3,2,3,2,2,2,1,-1,-1,-1,-1},
                    {3,3,3,2,2,3,2,2,1,-1,-1,-1,0},
                    {3,3,2,2,1,1,3,2,1,-1,-1,0,0},
                    {3,3,2,-1,-1,-1,-1,3,2,1,-1,0,0},
                    {3,3,1,-1,0,-1,-1,-1,3,1,-1,-1,0},
                    {3,2,1,-1,0,0,0,0,-1,3,1,-1,0},
                    {3,2,1,0,0,0,0,0,0,0,3,-1,0},
                    {3,2,-1,0,0,0,0,0,0,0,0,3,0},
                    {3,2,-1,0,0,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("12 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,3,3,2,2,2,2,2,1,1},
                    {3,3,3,3,3,2,2,2,1,1,-1,-1,-1},
                    {3,3,3,2,3,2,2,1,1,-1,-1,-1,-1},
                    {3,3,2,2,1,3,2,1,1,-1,-1,-1,0},
                    {3,3,2,1,-1,-1,3,2,1,-1,-1,0,0},
                    {3,3,1,-1,-1,-1,-1,3,1,1,-1,0,0},
                    {3,2,1,0,0,0,-1,-1,3,1,-1,-1,0},
                    {3,2,-1,0,0,0,0,0,-1,3,1,-1,0},
                    {3,2,-1,0,0,0,0,0,0,0,3,-1,0},
                    {3,2,-1,0,0,0,0,0,0,0,0,3,0},
                    {3,2,-1,0,0,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("13 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,3,3,2,2,2,2,1,1,1},
                    {3,3,3,3,3,2,2,1,-1,-1,-1,-1,-1},
                    {3,3,3,2,3,2,2,1,-1,-1,-1,-1,0},
                    {3,3,2,2,1,3,2,1,1,-1,-1,0,0},
                    {3,3,2,-1,-1,-1,3,1,1,-1,-1,0,0},
                    {3,2,1,-1,-1,-1,-1,3,1,-1,-1,0,0},
                    {3,2,-1,0,0,0,-1,-1,3,1,-1,-1,0},
                    {3,2,-1,0,0,0,0,0,-1,3,-1,-1,0},
                    {3,2,-1,0,0,0,0,0,0,0,3,-1,0},
                    {3,2,-1,0,0,0,0,0,0,0,0,3,0},
                    {3,2,0,0,0,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("14 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,3,2,2,2,1,1,1,1,-1},
                    {3,3,3,3,2,2,2,1,-1,-1,-1,-1,-1},
                    {3,3,2,2,3,2,2,1,-1,-1,-1,-1,0},
                    {3,3,2,1,1,3,2,1,-1,-1,0,0,0},
                    {3,2,1,-1,-1,-1,3,1,1,-1,-1,0,0},
                    {3,2,-1,-1,-1,-1,-1,3,1,-1,-1,0,0},
                    {3,2,-1,0,0,0,-1,-1,3,1,-1,-1,0},
                    {3,2,-1,0,0,0,0,0,0,3,-1,-1,0},
                    {3,2,-1,0,0,0,0,0,0,0,3,-1,0},
                    {3,1,0,0,0,0,0,0,0,0,0,3,0},
                    {3,1,0,0,0,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("15 BB")) {
            int[][] tPush2 = new int[][] {
                    {3,3, 3,3,3,3,3,3,3,3,3,3,3},
                    {3,3, 3,3,3,3,3,2,2,2,2,2,2},
                    {3,3, 3,3,3,2,2,1,1,1,1,1,-1},
                    {3,3, 2,3,2,2,1,1,-1,-1,-1,-1,-1},
                    {3,3, 2,2,3,2,1,1,-1,-1,-1,0,0},
                    {3,3, 2,1,1,3,1,1,-1,-1,0,0,0},
                    {3,2, 1,-1,-1,-1,3,1,1,-1,-1,0,0},
                    {3,2,-1,-1,-1,-1,-1,3,1,-1,-1,0,0},
                    {3,2,-1,0,0,0,-1,-1,3,1,-1,-1,0},
                    {3,2,-1,0,0,0,0,0,0,3,-1,-1,0},
                    {3,1,0,0,0,0,0,0,0,0,3,0,0},
                    {3,1,0,0,0,0,0,0,0,0,0,3,0},
                    {3,1,0,0,0,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("16 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,2,2,2,2,2,1,1,1},
                    {3,3,3,2,2,2,1,1,-1,-1,-1,-1,-1},
                    {3,3,2,3,2,1,1,-1,-1,-1,-1,-1,-1},
                    {3,3,2,1,3,2,1,-1,-1,-1,-1,-1,0},
                    {3,2,1,-1,-1,3,1,1,-1,-1,0,0,0},
                    {3,2,-1,-1,-1,-1,3,1,-1,-1,-1,0,0},
                    {3,1,-1,0,-1,-1,-1,3,1,-1,-1,0,0},
                    {3,1,-1,0,0,0,-1,-1,3,-1,-1,-1,0},
                    {3,-1,0,0,0,0,0,0,-1,3,-1,-1,0},
                    {2,-1,0,0,0,0,0,0,0,0,3,-1,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,3,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("17 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,2,2,2,2,1,1,1,1},
                    {3,3,3,2,2,2,1,-1,-1,-1,-1,-1,-1},
                    {3,3,2,3,2,1,1,-1,-1,-1,-1,-1,0},
                    {3,3,2,1,3,1,1,-1,-1,-1,-1,0,0},
                    {3,2,-1,-1,-1,3,1,-1,-1,-1,0,0,0},
                    {3,1,-1,-1,-1,-1,3,1,-1,-1,-1,0,0},
                    {3,1,0,0,0,-1,-1,3,-1,-1,-1,0,0},
                    {3,-1,0,0,0,0,0,-1,3,-1,-1,0,0},
                    {3,-1,0,0,0,0,0,0,0,3,-1,-1,0},
                    {2,-1,0,0,0,0,0,0,0,0,3,-1,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,3,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("18 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,2},
                    {3,3,3,3,3,2,2,2,1,1,1,1,-1},
                    {3,3,3,2,2,1,1,-1,-1,-1,-1,-1,-1},
                    {3,3,2,3,2,1,-1,-1,-1,-1,-1,-1,0},
                    {3,2,1,1,3,1,1,-1,-1,-1,-1,0,0},
                    {3,2,-1,-1,-1,3,1,-1,-1,-1,0,0,0},
                    {3,1,-1,-1,-1,-1,3,-1,-1,-1,0,0,0},
                    {3,-1,0,0,0,-1,-1,3,-1,-1,-1,0,0},
                    {2,-1,0,0,0,0,0,-1,3,-1,-1,0,0},
                    {2,-1,0,0,0,0,0,0,0,3,-1,-1,0},
                    {2,-1,0,0,0,0,0,0,0,0,3,0,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,2,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("19 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,3,2,2,1,1,1,1,-1,-1},
                    {3,3,3,2,2,1,1,-1,-1,-1,-1,-1,-1},
                    {3,2,2,3,2,1,-1,-1,-1,-1,-1,0,0},
                    {3,2,1,1,3,1,1,-1,-1,-1,-1,0,0},
                    {3,1,-1,-1,-1,3,1,-1,-1,-1,0,0,0},
                    {3,1,-1,-1,-1,-1,3,-1,-1,-1,0,0,0},
                    {3,-1,0,0,0,-1,-1,3,-1,-1,-1,0,0},
                    {2,-1,0,0,0,0,0,-1,3,-1,-1,0,0},
                    {2,-1,0,0,0,0,0,0,0,3,-1,-1,0},
                    {2,-1,0,0,0,0,0,0,0,0,3,0,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,2,0},
                    {2,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("20 BB")) {
                    /*tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
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
                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,2,2,2,2},
                    {3,3,3,3,2,2,1,1,1,1,-1,-1,-1},
                    {3,3,3,2,2,1,-1,-1,-1,-1,-1,-1,-1},
                    {3,2,1,3,1,1,-1,-1,-1,-1,-1,0,0},
                    {3,2,1,-1,3,1,-1,-1,-1,0,0,0,0},
                    {3,1,-1,-1,-1,3,-1,-1,-1,-1,0,0,0},
                    {3,-1,-1,-1,-1,-1,3,-1,-1,-1,0,0,0},
                    {2,-1,0,0,0,0,-1,3,-1,-1,-1,0,0},
                    {2,-1,0,0,0,0,0,0,3,-1,-1,0,0},
                    {2,-1,0,0,0,0,0,0,0,3,-1,-1,0},
                    {2,-1,0,0,0,0,0,0,0,0,3,0,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,2,0},
                    {2,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("21 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,2,2,1,1,1,-1,-1,-1,-1},
                    {3,3,3,2,1,1,-1,-1,-1,-1,-1,-1,0},
                    {3,2,1,3,1,1,-1,-1,-1,-1,-1,0,0},
                    {3,2,-1,-1,3,1,-1,-1,-1,-1,-1,0,0},
                    {3,1,-1,-1,-1,3,1,-1,-1,-1,0,0,0},
                    {3,-1,-1,-1,-1,-1,3,-1,-1,-1,0,0,0},
                    {2,-1,0,0,0,-1,-1,3,-1,-1,-1,0,0},
                    {2,-1,0,0,0,0,0,-1,3,-1,-1,0,0},
                    {2,-1,0,0,0,0,0,0,0,3,-1,-1,0},
                    {2,-1,0,0,0,0,0,0,0,0,3,0,0},
                    {2,0,0,0,0,0,0,0,0,0,0,2,0},
                    {2,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("22 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,2,1,1,1,1,1,1,1,-1},
                    {3,2,3,2,1,1,1,-1,-1,-1,-1,0,0},
                    {3,2,1,3,1,1,1,-1,-1,-1,0,0,0},
                    {3,2,1,1,3,1,1,1,-1,0,0,0,0},
                    {3,1,-1,-1,-1,3,1,1,-1,-1,0,0,0},
                    {3,1,0,0,-1,-1,3,1,1,-1,0,0,0},
                    {2,-1,0,0,0,0,-1,3,1,-1,0,0,0},
                    {2,-1,0,0,0,0,0,0,3,1,-1,0,0},
                    {2,-1,0,0,0,0,0,0,0,3,-1,0,0},
                    {2,0,0,0,0,0,0,0,0,0,3,0,0},
                    {2,0,0,0,0,0,0,0,0,0,0,2,0},
                    {1,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);

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

    protected void foldAction_3p(MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
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

        if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {

            tDiff[8][10]=1;
        }
        else{
            tDiff[1][12]=1;
            tDiff[2][9]=1; tDiff[2][10]=1; tDiff[2][11]=1; tDiff[2][12]=1; //Q
            tDiff[3][8]=1; tDiff[3][9]=1; tDiff[3][10]=1; tDiff[3][11]=1;
            tDiff[4][8]=1;tDiff[4][9]=1;tDiff[4][10]=1;
            tDiff[5][3]=1; tDiff[5][8]=1;tDiff[5][9]=1;
            tDiff[6][2]=1;tDiff[6][3]=1;tDiff[6][4]=1;tDiff[6][5]=1; tDiff[6][9]=1;
            tDiff[7][1]=1; tDiff[7][9]=1;
            tDiff[8][9]=1;
            tDiff[9][10]=1;
        }

        mv.setCurrDiff(tDiff);
        if (stakeSz.equals("2 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,3,2,3,3,2,2,2,2,2},
                    {3,3,3,2,2,2,2,3,2,2,2,2,-1},
                    {3,3,3,2,2,2,2,2,3,2,2,2,1},
                    {3,3,2,2,2,2,2,2,2,3,2,2,1},
                    {3,3,2,2,2,1,1,-1,1,1,3,2,-1},
                    {3,3,2,2,2,-1,0,0,0,0,0,3,0},
                    {3,3,2,2,2,-1,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("3 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,2},
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,3,3,3,2,2,2,2,2,2},
                    {3,3,3,3,3,3,2,2,2,2,2,2,1},
                    {3,3,3,2,2,3,2,2,2,2,1,-1,0},
                    {3,3,2,2,2,2,3,2,2,2,-1,0,0},
                    {3,3,2,2,2,2,2,3,2,2,-1,0,0},
                    {3,3,2,2,2,1,-1,-1,3,2,-1,0,0},
                    {3,2,2,2,-1,0,0,0,0,3,1,0,0},
                    {3,2,2,1,0,0,0,0,0,0,3,0,0},
                    {3,2,2,1,0,0,0,0,0,0,0,3,0},
                    {3,2,2,-1,0,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("4 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,3,3,3,2,2,2,2,2,2},
                    {3,3,3,3,3,3,2,2,2,2,2,2,1},
                    {3,3,3,2,3,2,2,2,2,1,1,-1,0},
                    {3,3,2,2,2,3,2,2,2,-1,0,0,0},
                    {3,3,2,2,2,2,3,2,2,-1,0,0,0},
                    {3,2,2,2,1,-1,-1,3,2,-1,0,0,0},
                    {3,2,2,1,-1,0,0,0,3,-1,0,0,0},
                    {3,2,2,-1,0,0,0,0,0,3,0,0,0},
                    {3,2,2,0,0,0,0,0,0,0,3,0,0},
                    {3,2,1,0,0,0,0,0,0,0,0,3,0},
                    {3,2,-1,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("5 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,2,2,2,2},
                    {3,3,3,3,3,3,2,2,2,2,2,2,2},
                    {3,3,3,3,3,2,2,2,2,2,1,-1,-1},
                    {3,3,3,2,3,2,2,2,1,-1,0,0,0},
                    {3,3,2,2,2,3,2,2,1,-1,0,0,0},
                    {3,2,2,2,1,1,3,2,1,0,0,0,0},
                    {3,2,2,1,-1,0,0,3,1,-1,0,0,0},
                    {3,2,2,0,0,0,0,0,3,-1,0,0,0},
                    {3,2,1,0,0,0,0,0,0,3,0,0,0},
                    {3,2,-1,0,0,0,0,0,0,0,3,0,0},
                    {3,2,-1,0,0,0,0,0,0,0,0,3,0},
                    {3,2,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("6 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,2,2,2,2,2,2},
                    {3,3,3,3,3,2,2,2,2,2,2,1,1},
                    {3,3,3,3,2,2,2,2,1,-1,-1,-1,0},
                    {3,3,2,2,3,2,2,2,-1,0,0,0,0},
                    {3,3,2,2,2,3,2,1,-1,0,0,0,0},
                    {3,2,2,1,-1,-1,3,2,-1,-1,0,0,0},
                    {3,2,1,-1,0,0,0,3,1,-1,0,0,0},
                    {3,2,1,0,0,0,0,0,3,-1,0,0,0},
                    {3,2,-1,0,0,0,0,0,0,3,-1,0,0},
                    {3,2,0,0,0,0,0,0,0,0,3,0,0},
                    {3,2,0,0,0,0,0,0,0,0,0,3,0},
                    {2,1,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("7 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,2,2,2,2,2,2},
                    {3,3,3,3,3,2,2,2,2,2,1,-1,-1},
                    {3,3,3,3,2,2,2,1,-1,-1,-1,0,0},
                    {3,3,2,2,3,2,2,1,-1,0,0,0,0},
                    {3,3,2,2,1,3,2,1,-1,0,0,0,0},
                    {3,2,1,-1,-1,-1,3,1,-1,-1,0,0,0},
                    {3,2,-1,0,0,0,0,3,1,-1,0,0,0},
                    {3,2,-1,0,0,0,0,0,3,-1,0,0,0},
                    {3,2,0,0,0,0,0,0,0,3,-1,0,0},
                    {3,1,0,0,0,0,0,0,0,0,3,0,0},
                    {3,1,0,0,0,0,0,0,0,0,0,3,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("8 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,2,2,2,2,2,2,2},
                    {3,3,3,3,2,2,2,1,1,1,-1,-1,-1},
                    {3,3,2,3,2,2,2,1,-1,-1,0,0,0},
                    {3,3,2,2,3,2,2,1,-1,0,0,0,0},
                    {3,2,2,1,-1,3,2,1,-1,0,0,0,0},
                    {3,2,-1,-1,0,-1,3,1,-1,0,0,0,0},
                    {3,2,0,0,0,0,0,3,1,-1,0,0,0},
                    {3,2,0,0,0,0,0,0,3,-1,0,0,0},
                    {3,1,0,0,0,0,0,0,0,3,-1,0,0},
                    {3,-1,0,0,0,0,0,0,0,0,3,0,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,3,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("9 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,2,2,2,2,2,1,1},
                    {3,3,3,3,2,2,2,1,-1,-1,-1,-1,0},
                    {3,3,2,3,2,2,1,-1,-1,0,0,0,0},
                    {3,3,2,2,3,2,1,-1,-1,0,0,0,0},
                    {3,2,1,-1,-1,3,1,1,-1,0,0,0,0},
                    {3,2,-1,0,0,0,3,1,-1,0,0,0,0},
                    {3,1,0,0,0,0,0,3,1,-1,0,0,0},
                    {3,1,0,0,0,0,0,0,3,-1,0,0,0},
                    {3,-1,0,0,0,0,0,0,0,3,-1,0,0},
                    {3,-1,0,0,0,0,0,0,0,0,3,0,0},
                    {2,-1,0,0,0,0,0,0,0,0,0,3,0},
                    {2,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("10 BB")) {
                    /*tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
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
                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,2,2,2,2,1,1,-1},
                    {3,3,3,3,2,2,1,-1,-1,-1,-1,0,0},
                    {3,3,2,3,2,2,1,-1,-1,0,0,0,0},
                    {3,3,2,1,3,2,1,-1,-1,0,0,0,0},
                    {3,2,-1,-1,-1,3,1,-1,-1,0,0,0,0},
                    {3,1,0,0,0,-1,3,1,-1,-1,0,0,0},
                    {3,1,0,0,0,0,0,3,-1,-1,0,0,0},
                    {3,-1,0,0,0,0,0,0,3,-1,0,0,0},
                    {3,-1,0,0,0,0,0,0,0,3,-1,0,0},
                    {2,0,0,0,0,0,0,0,0,0,3,0,0},
                    {2,0,0,0,0,0,0,0,0,0,0,3,0},
                    {2,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("11 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,2},
                    {3,3,3,3,3,2,2,2,1,1,1,-1,-1},
                    {3,3,3,2,2,2,1,-1,-1,-1,-1,0,0},
                    {3,3,2,3,2,1,1,-1,0,0,0,0,0},
                    {3,2,1,1,3,2,1,-1,-1,0,0,0,0},
                    {3,2,-1,-1,-1,3,1,-1,-1,0,0,0,0},
                    {3,-1,0,0,0,0,3,1,-1,-1,0,0,0},
                    {3,-1,0,0,0,0,0,3,-1,-1,0,0,0},
                    {2,-1,0,0,0,0,0,0,3,-1,0,0,0},
                    {2,0,0,0,0,0,0,0,0,3,-1,0,0},
                    {2,0,0,0,0,0,0,0,0,0,3,0,0},
                    {2,0,0,0,0,0,0,0,0,0,0,3,0},
                    {2,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("12 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,3,2,1,1,1,1,-1,-1,-1},
                    {3,3,3,2,2,1,-1,-1,-1,-1,-1,0,0},
                    {3,2,2,3,2,1,-1,-1,0,0,0,0,0},
                    {3,2,1,1,3,1,1,-1,-1,0,0,0,0},
                    {3,1,-1,-1,-1,3,1,-1,-1,0,0,0,0},
                    {3,-1,0,0,0,0,3,1,-1,-1,0,0,0},
                    {2,-1,0,0,0,0,0,3,-1,-1,0,0,0},
                    {2,0,0,0,0,0,0,0,3,-1,0,0,0},
                    {2,0,0,0,0,0,0,0,0,3,-1,0,0},
                    {2,0,0,0,0,0,0,0,0,0,3,0,0},
                    {2,0,0,0,0,0,0,0,0,0,0,2,0},
                    {2,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("13 BB")) { // 0

            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,2,2,1,1,1,-1,-1,-1,-1},
                    {3,3,3,2,2,1,-1,-1,-1,-1,0,0,0},
                    {3,2,1,3,2,1,-1,-1,0,0,0,0,0},
                    {3,2,1,-1,3,1,-1,-1,0,0,0,0,0},
                    {3,-1,-1,-1,-1,3,1,-1,-1,0,0,0,0},
                    {3,-1,0,0,0,0,3,-1,-1,0,0,0,0},
                    {2,0,0,0,0,0,0,3,-1,-1,0,0,0},
                    {2,0,0,0,0,0,0,0,3,-1,0,0,0},
                    {2,0,0,0,0,0,0,0,0,3,-1,0,0},
                    {2,0,0,0,0,0,0,0,0,0,3,0,0},
                    {2,0,0,0,0,0,0,0,0,0,0,2,0},
                    {2,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("14 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,2,1,1,-1,-1,-1,-1,-1,-1},
                    {3,2,3,2,2,1,-1,-1,-1,0,0,0,0},
                    {3,2,1,3,2,1,-1,-1,0,0,0,0,0},
                    {3,2,-1,-1,3,1,-1,-1,0,0,0,0,0},
                    {3,-1,0,-1,-1,3,1,-1,-1,0,0,0,0},
                    {3,0,0,0,0,0,3,-1,-1,0,0,0,0},
                    {2,0,0,0,0,0,0,3,-1,-1,0,0,0},
                    {2,0,0,0,0,0,0,0,3,-1,0,0,0},
                    {2,0,0,0,0,0,0,0,0,3,-1,0,0},
                    {2,0,0,0,0,0,0,0,0,0,3,0,0},
                    {1,0,0,0,0,0,0,0,0,0,0,2,0},
                    {1,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("15 BB")) {

            int[][] tPush2 = new int[][] {
                    {3, 3, 3, 3, 3,3, 3, 2, 2, 2, 2,2,2},
                    {3, 3, 3, 2, 2,1, 1,-1,-1,-1,-1,0,0},
                    {3, 2, 3, 2, 1,1,-1,-1,-1, 0, 0,0,0},
                    {3, 2, 1, 3, 1,1,-1,-1, 0, 0, 0,0,0},
                    {3, 1,-1,-1, 3,1,-1,-1, 0, 0, 0,0,0},
                    {3,-1, 0, 0,-1,3, 1,-1,-1, 0, 0,0,0},
                    {2, 0, 0, 0, 0,0, 3,-1,-1, 0, 0,0,0},
                    {2, 0, 0, 0, 0,0, 0, 3,-1,-1, 0,0,0},
                    {2, 0, 0, 0, 0,0, 0, 0, 3,-1, 0,0,0},
                    {2, 0, 0, 0, 0,0, 0, 0, 0, 3,-1,0,0},
                    {1, 0, 0, 0, 0,0, 0, 0, 0, 0, 3,0,0},
                    {1, 0, 0, 0, 0,0, 0, 0, 0, 0, 0,2,0},
                    {1, 0, 0, 0, 0,0, 0, 0, 0, 0, 0,0,2},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("16 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,2,2,2,2,2,1,1},
                    {3,3,2,2,1,-1,-1,-1,-1,-1,-1,0,0},
                    {3,2,3,1,1,-1,-1,-1,-1,0,0,0,0},
                    {3,1,-1,3,1,-1,-1,-1,0,0,0,0,0},
                    {3,-1,-1,-1,3,1,-1,-1,0,0,0,0,0},
                    {2,0,0,0,-1,3,-1,-1,-1,0,0,0,0},
                    {2,0,0,0,0,0,3,-1,-1,0,0,0,0},
                    {1,0,0,0,0,0,0,3,-1,0,0,0,0},
                    {1,0,0,0,0,0,0,0,3,-1,0,0,0},
                    {1,0,0,0,0,0,0,0,0,3,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("17 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,2,2,2,2,1,1,1},
                    {3,3,2,2,1,-1,-1,-1,-1,-1,0,0,0},
                    {3,2,3,1,1,-1,-1,-1,-1,0,0,0,0},
                    {3,1,-1,3,1,-1,-1,-1,0,0,0,0,0},
                    {3,-1,-1,-1,3,1,-1,-1,0,0,0,0,0},
                    {2,0,0,-1,-1,3,-1,-1,-1,0,0,0,0},
                    {2,0,0,0,0,0,3,-1,-1,0,0,0,0},
                    {1,0,0,0,0,0,0,3,-1,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,3,-1,0,0,0},
                    {1,0,0,0,0,0,0,0,0,2,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("18 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,2,2,2,1,1,1,1,1},
                    {3,3,2,2,1,-1,-1,-1,-1,-1,0,0,0},
                    {3,2,3,1,1,-1,-1,-1,0,0,0,0,0},
                    {3,1,-1,3,1,-1,-1,-1,0,0,0,0,0},
                    {3,-1,-1,-1,3,-1,-1,-1,0,0,0,0,0},
                    {2,0,0,0,-1,3,-1,-1,0,0,0,0,0},
                    {1,0,0,0,0,0,3,-1,-1,0,0,0,0},
                    {1,0,0,0,0,0,0,3,-1,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,3,-1,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,1,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("19 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,2,2,2,1,1,1,1,-1},
                    {3,3,2,1,1,-1,-1,-1,0,0,0,0,0},
                    {3,1,3,1,-1,-1,-1,0,0,0,0,0,0},
                    {3,-1,-1,3,-1,-1,-1,0,0,0,0,0,0},
                    {3,-1,-1,-1,3,-1,-1,0,0,0,0,0,0},
                    {2,0,0,0,0,3,-1,-1,0,0,0,0,0},
                    {1,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {1,0,0,0,0,0,0,3,-1,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,3,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,1,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("20 BB")) {
                    /*tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1;                 tPush[0][9] = 1;
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
                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,2,2,1,1,1,1,-1,-1},
                    {3,3,2,1,1,-1,-1,-1,-1,-1,0,0,0},
                    {3,1,3,1,1,-1,-1,-1,-1,0,0,0,0},
                    {3,-1,-1,3,1,-1,-1,-1,0,0,0,0,0},
                    {2,-1,-1,-1,3,-1,-1,-1,0,0,0,0,0},
                    {2,0,0,0,-1,3,-1,-1,-1,0,0,0,0},
                    {1,0,0,0,0,0,3,-1,-1,0,0,0,0},
                    {-1,0,0,0,0,0,0,3,-1,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,2,-1,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,1,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);
        }
                else if (stakeSz.equals("21 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,2,1,1,-1,1,-1,-1,-1},
                            {3,3,2,1,-1,-1,-1,-1,-1,0,0,0,0},
                            {3,1,3,1,-1,-1,-1,0,0,0,0,0,0},
                            {3,-1,-1,3,1,-1,-1,0,0,0,0,0,0},
                            {2,-1,-1,-1,3,-1,-1,-1,0,0,0,0,0},
                            {1,0,0,0,0,3,-1,-1,0,0,0,0,0},
                            {1,0,0,0,0,0,3,-1,-1,0,0,0,0},
                            {-1,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,2,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,1,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,1,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,-1},
                    };
                    mv.setCurrPush(tPush2);

                }
                else if (stakeSz.equals("22 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,2,1,1,1,1,1,1,1},
                            {3,3,2,1,1,-1,-1,-1,-1,0,0,0,0},
                            {3,1,3,1,1,-1,-1,0,0,0,0,0,0},
                            {3,1,-1,3,1,1,-1,0,0,0,0,0,0},
                            {2,-1,-1,-1,3,1,-1,-1,0,0,0,0,0},
                            {1,0,0,0,0,3,-1,-1,0,0,0,0,0},
                            {1,0,0,0,0,0,3,-1,0,0,0,0,0},
                            {-1,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,2,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,1,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,1},
                    };
                    mv.setCurrPush(tPush2);

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
    protected void foldAction_4p(MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        mv.setCurrChart(2); //to 2 players
        mv.setCurrPrc(m_currPD[2][3]);

        tDiff[3][7]=1;
        tDiff[4][7]=1;
        tDiff[5][6]=1;tDiff[5][7]=1;
        tDiff[6][1]=1; tDiff[6][7]=1;

        tDiff[11][11]=1;//33
        tDiff[12][12]=1;//22
        if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
            tDiff[1][10]=1;tDiff[1][11]=1;tDiff[1][12]=1;
            tDiff[2][7]=1; tDiff[2][8]=1;tDiff[2][9]=1;tDiff[2][10]=1;
            tDiff[3][7]=1;tDiff[3][8]=1;
            tDiff[4][7]=1;
            tDiff[5][7]=1;
            tDiff[6][8]=1;
            tDiff[7][8]=1;
            tDiff[8][9]=1;
            tDiff[9][10]=1;
            tDiff[5][3]=1;tDiff[5][4]=1;
            tDiff[10][0]=1;
        }
        else{
            tDiff[1][9]=1;
            tDiff[2][7]=1;
            tDiff[3][7]=0;
            tDiff[4][7]=0;
            tDiff[5][7]=0;
            tDiff[5][2]=1;
        }
        mv.setCurrDiff(tDiff);
        if (stakeSz.equals("2 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,2,2},
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,3,3,3,2,2,2,2,2,2},
                    {3,3,3,2,2,2,3,2,2,2,2,2,2},
                    {3,3,2,2,2,2,2,3,2,2,2,2,-1},
                    {3,3,2,2,2,2,2,2,3,2,2,2,1},
                    {3,3,2,2,2,2,2,2,2,3,2,2,2},
                    {3,2,2,2,2,-1,-1,-1,1,1,3,2,1},
                    {3,2,2,2,1,0,0,0,0,0,0,3,-1},
                    {3,2,2,2,-1,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
                else if (stakeSz.equals("3 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,3,2,2,2},
                            {3,3,3,3,3,3,2,2,2,2,2,2,2},
                            {3,3,3,3,3,3,2,2,2,2,2,2,2},
                            {3,3,3,2,3,2,2,2,2,2,1,1,-1},
                            {3,3,2,2,2,3,2,2,2,2,-1,0,0},
                            {3,2,2,2,2,2,3,2,2,2,-1,0,0},
                            {3,2,2,2,2,1,1,3,2,2,-1,0,0},
                            {3,2,2,1,-1,-1,-1,-1,3,2,-1,0,0},
                            {3,2,2,-1,0,0,0,0,0,3,1,0,0},
                            {3,2,2,0,0,0,0,0,0,0,3,0,0},
                            {3,2,1,0,0,0,0,0,0,0,0,3,0},
                            {3,2,-1,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("4 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,2,2,2,2,2,2},
                            {3,3,3,3,3,2,2,2,2,2,2,2,1},
                            {3,3,3,3,3,2,2,2,2,2,1,-1,0},
                            {3,3,2,2,3,2,2,2,2,-1,0,0,0},
                            {3,2,2,2,2,3,2,2,1,0,0,0,0},
                            {3,2,2,2,1,1,3,2,1,0,0,0,0},
                            {3,2,2,-1,-1,0,0,3,1,0,0,0,0},
                            {3,2,1,0,0,0,0,0,3,-1,0,0,0},
                            {3,2,-1,0,0,0,0,0,0,3,0,0,0},
                            {3,2,-1,0,0,0,0,0,0,0,3,0,0},
                            {2,2,0,0,0,0,0,0,0,0,0,2,0},
                            {2,1,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("5 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,2,2,2,2,2,2,2},
                            {3,3,3,3,3,2,2,2,2,2,1,1,-1},
                            {3,3,2,3,2,2,2,2,1,-1,-1,0,0},
                            {3,3,2,2,3,2,2,2,-1,0,0,0,0},
                            {3,2,2,2,1,3,2,1,-1,0,0,0,0},
                            {3,2,2,-1,-1,-1,3,1,-1,0,0,0,0},
                            {3,2,-1,0,0,0,0,3,-1,0,0,0,0},
                            {3,2,-1,0,0,0,0,0,3,-1,0,0,0},
                            {3,2,0,0,0,0,0,0,0,3,0,0,0},
                            {2,1,0,0,0,0,0,0,0,0,3,0,0},
                            {2,-1,0,0,0,0,0,0,0,0,0,2,0},
                            {2,-1,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("6 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,2},
                            {3,3,3,3,3,2,2,2,2,2,2,2,1},
                            {3,3,3,3,2,2,2,2,1,1,-1,-1,0},
                            {3,3,2,3,2,2,2,1,-1,0,0,0,0},
                            {3,2,2,2,3,2,2,-1,-1,0,0,0,0},
                            {3,2,2,1,-1,3,2,1,-1,0,0,0,0},
                            {3,2,-1,-1,0,0,3,1,-1,0,0,0,0},
                            {3,2,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,1,0,0,0,0,0,0,3,-1,0,0,0},
                            {2,-1,0,0,0,0,0,0,0,3,0,0,0},
                            {2,-1,0,0,0,0,0,0,0,0,3,0,0},
                            {2,0,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("7 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,2},
                            {3,3,3,3,3,2,2,2,2,2,1,1,-1},
                            {3,3,3,2,2,2,2,-1,-1,-1,-1,0,0},
                            {3,3,2,3,2,2,1,-1,0,0,0,0,0},
                            {3,2,2,2,3,2,1,-1,0,0,0,0,0},
                            {3,2,-1,-1,-1,3,1,-1,-1,0,0,0,0},
                            {3,1,0,0,0,0,3,1,-1,0,0,0,0},
                            {3,1,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,-1,0,0,0,0,0,0,3,-1,0,0,0},
                            {2,-1,0,0,0,0,0,0,0,3,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,3,0,0},
                            {2,0,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("8 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,2,2,2},
                            {3,3,3,3,3,2,2,2,2,1,1,-1,-1},
                            {3,3,3,2,2,2,1,-1,-1,-1,0,0,0},
                            {3,2,2,3,2,2,1,-1,0,0,0,0,0},
                            {3,2,2,1,3,2,1,-1,0,0,0,0,0},
                            {3,2,-1,-1,-1,3,1,-1,-1,0,0,0,0},
                            {3,-1,0,0,0,0,3,1,-1,0,0,0,0},
                            {2,-1,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,0,3,-1,0,0,0},
                            {2,0,0,0,0,0,0,0,0,3,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,3,0,0},
                            {2,0,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("9 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,2,2,2},
                            {3,3,3,3,3,2,2,1,1,1,-1,-1,-1},
                            {3,3,3,2,2,2,-1,-1,-1,0,0,0,0},
                            {3,2,2,3,2,1,-1,-1,0,0,0,0,0},
                            {3,2,1,1,3,2,1,-1,0,0,0,0,0},
                            {3,1,-1,0,-1,3,1,-1,-1,0,0,0,0},
                            {3,-1,0,0,0,0,3,-1,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,0,3,-1,0,0,0},
                            {2,0,0,0,0,0,0,0,0,3,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,3,0,0},
                            {2,0,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
        else if (stakeSz.equals("10 BB")) {
                   /* tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
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
                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,2,2,1,1,-1,-1,-1,-1,0},
                    {3,3,3,2,2,1,-1,-1,-1,0,0,0,0},
                    {3,2,1,3,2,1,-1,-1,0,0,0,0,0},
                    {3,2,-1,-1,3,1,-1,-1,0,0,0,0,0},
                    {3,-1,0,0,-1,3,1,-1,0,0,0,0,0},
                    {3,0,0,0,0,0,3,-1,-1,0,0,0,0},
                    {2,0,0,0,0,0,0,3,-1,0,0,0,0},
                    {2,0,0,0,0,0,0,0,3,-1,0,0,0},
                    {2,0,0,0,0,0,0,0,0,3,0,0,0},
                    {2,0,0,0,0,0,0,0,0,0,3,0,0},
                    {1,0,0,0,0,0,0,0,0,0,0,2,0},
                    {1,0,0,0,0,0,0,0,0,0,0,0,2},
            };

            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
                else if (stakeSz.equals("11 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,2,2,2,2,2,2},
                            {3,3,3,2,2,1,-1,-1,-1,-1,-1,0,0},
                            {3,2,3,2,2,1,-1,-1,0,0,0,0,0},
                            {3,2,1,3,2,1,-1,-1,0,0,0,0,0},
                            {3,1,-1,-1,3,1,-1,-1,0,0,0,0,0},
                            {3,-1,0,0,0,3,-1,-1,0,0,0,0,0},
                            {2,0,0,0,0,0,3,-1,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,0,3,-1,0,0,0},
                            {2,0,0,0,0,0,0,0,0,3,0,0,0},
                            {1,0,0,0,0,0,0,0,0,0,2,0,0},
                            {1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("12 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,2,2,2,2,2,2},
                            {3,3,3,2,2,1,-1,-1,-1,-1,0,0,0},
                            {3,2,3,2,2,-1,-1,0,0,0,0,0,0},
                            {3,2,-1,3,2,1,-1,-1,0,0,0,0,0},
                            {3,1,-1,-1,3,1,-1,-1,0,0,0,0,0},
                            {2,0,0,0,0,3,-1,-1,0,0,0,0,0},
                            {2,0,0,0,0,0,3,-1,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {1,0,0,0,0,0,0,0,3,-1,0,0,0},
                            {1,0,0,0,0,0,0,0,0,3,0,0,0},
                            {1,0,0,0,0,0,0,0,0,0,2,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("13 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,2,2,2,2,2,1,1},
                            {3,3,3,2,2,1,-1,-1,-1,-1,0,0,0},
                            {3,2,3,2,1,-1,-1,0,0,0,0,0,0},
                            {3,1,-1,3,1,-1,-1,0,0,0,0,0,0},
                            {3,-1,-1,-1,3,1,-1,-1,0,0,0,0,0},
                            {2,0,0,0,0,3,-1,-1,0,0,0,0,0},
                            {2,0,0,0,0,0,3,-1,-1,0,0,0,0},
                            {1,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,3,0,0,0,0},
                            {1,0,0,0,0,0,0,0,0,3,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,0,1},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("14 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,2,2,2,2,1,1,1},
                            {3,3,2,2,1,-1,-1,-1,-1,0,0,0,0},
                            {3,2,3,1,1,-1,-1,0,0,0,0,0,0},
                            {3,1,-1,3,1,-1,-1,0,0,0,0,0,0},
                            {3,-1,-1,-1,3,-1,-1,-1,0,0,0,0,0},
                            {2,0,0,0,0,3,-1,-1,0,0,0,0,0},
                            {2,0,0,0,0,0,3,-1,0,0,0,0,0},
                            {1,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,3,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,1},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
        else if (stakeSz.equals("15 BB")) {
            int[][] tPush2 = new int[][] {
                    { 3, 3, 3, 3,3, 2, 2, 2, 1,1,1,1,1},
                    { 3, 3, 2, 2,1,-1,-1,-1, 0,0,0,0,0},
                    { 3, 2, 3, 1,1,-1,-1, 0, 0,0,0,0,0},
                    { 3, 1,-1, 3,1,-1,-1, 0, 0,0,0,0,0},
                    { 3,-1,-1,-1,3,-1,-1, 0, 0,0,0,0,0},
                    { 2, 0, 0, 0,0, 3,-1,-1, 0,0,0,0,0},
                    { 1, 0, 0, 0,0, 0, 3,-1, 0,0,0,0,0},
                    { 1, 0, 0, 0,0, 0, 0, 3,-1,0,0,0,0},
                    {-1, 0, 0, 0,0, 0, 0, 0, 3,0,0,0,0},
                    {-1, 0, 0, 0,0, 0, 0, 0, 0,2,0,0,0},
                    {-1, 0, 0, 0,0, 0, 0, 0, 0,0,2,0,0},
                    {-1, 0, 0, 0,0, 0, 0, 0, 0,0,0,1,0},
                    { 0, 0, 0, 0,0, 0, 0, 0, 0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("16 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,2,2,1,1,-1,-1,-1,-1,-1},
                    {3,3,2,1,1,-1,-1,-1,-1,0,0,0,0},
                    {3,1,3,1,1,-1,-1,0,0,0,0,0,0},
                    {3,-1,-1,3,1,-1,-1,0,0,0,0,0,0},
                    {2,-1,-1,-1,3,-1,-1,-1,0,0,0,0,0},
                    {1,0,0,0,0,3,-1,-1,0,0,0,0,0},
                    {-1,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,3,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("17 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,2,2,1,-1,-1,-1,-1,-1,-1},
                    {3,3,2,1,1,-1,-1,-1,-1,0,0,0,0},
                    {3,1,3,1,1,-1,-1,0,0,0,0,0,0},
                    {3,-1,-1,3,1,-1,-1,0,0,0,0,0,0},
                    {2,-1,-1,-1,3,-1,-1,-1,0,0,0,0,0},
                    {1,0,0,0,0,3,-1,-1,0,0,0,0,0},
                    {-1,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,3,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("18 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,2,1,1,-1,-1,-1,-1,-1,-1},
                    {3,3,2,1,1,-1,-1,-1,-1,0,0,0,0},
                    {3,1,3,1,-1,-1,-1,0,0,0,0,0,0},
                    {2,-1,-1,3,1,-1,-1,0,0,0,0,0,0},
                    {2,-1,-1,-1,3,-1,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,3,-1,-1,0,0,0,0,0},
                    {-1,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("19 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,2,1,-1,-1,-1,-1,-1,-1,-1},
                    {3,3,1,1,-1,-1,-1,-1,0,0,0,0,0},
                    {3,-1,3,1,-1,-1,-1,0,0,0,0,0,0},
                    {2,-1,-1,3,-1,-1,-1,0,0,0,0,0,0},
                    {1,-1,-1,-1,3,-1,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("20 BB")) {
                    /*tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1;
                                                                                       tPush[4][4] = 1;
                                                                                                        tPush[5][5] = 1;
                       tPush[6][6] = 1;
                            tPush[7][7] = 1;

                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,2,1,-1,-1,-1,-1,-1,-1,-1},
                    {3,3,1,1,-1,-1,-1,-1,0,0,0,0,0},
                    {3,-1,3,-1,-1,-1,-1,0,0,0,0,0,0},
                    {2,-1,-1,3,-1,-1,-1,0,0,0,0,0,0},
                    {1,-1,-1,-1,3,-1,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,-1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("21 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,-1,-1,-1,-1,-1,-1,-1,-1},
                    {3,3,1,-1,-1,-1,-1,-1,0,0,0,0,0},
                    {3,-1,3,-1,-1,-1,-1,0,0,0,0,0,0},
                    {2,-1,-1,3,-1,-1,-1,0,0,0,0,0,0},
                    {1,-1,-1,-1,3,-1,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("22 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,1,-1,-1,-1,-1,-1,-1,-1},
                    {3,3,1,1,1,-1,-1,-1,0,0,0,0,0},
                    {3,1,3,1,1,-1,-1,0,0,0,0,0,0},
                    {2,-1,-1,3,1,-1,-1,0,0,0,0,0,0},
                    {1,0,0,-1,3,-1,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);

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
    protected void foldAction_5p(MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {

        mv.setCurrChart(2); //to 2 players
        mv.setCurrPrc(m_currPD[2][4]);
        //tDiff[1][8] = 1;tDiff[1][9] = 1;
        tDiff[2][6] = 1;
        //tDiff[3][6] = 1;
        //tDiff[4][6] = 1;
        tDiff[4][2] = 1;tDiff[4][3] = 1;
        tDiff[5][1]=1; /*tDiff[5][6] = 1;tDiff[5][7] = 1;*/
        //tDiff[6][7] = 1;

        //tDiff[9][9]=1;//55 not shark
        tDiff[10][10]=1; //44

        if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
            tDiff[1][10] = 1;
            tDiff[3][7] = 1;
            tDiff[4][7] = 1;
            tDiff[7][0] = 1; tDiff[7][8] = 1;

            tDiff[10][10] = 1;//44
            tDiff[11][11] = 1;
            tDiff[12][12] = 1;
        }
        else{
            tDiff[7][0] = 1;
        }
        mv.setCurrDiff(tDiff);
        if (stakeSz.equals("2 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,2,2,2},
                    {3,3,3,3,3,3,3,3,2,2,2,2,2},
                    {3,3,3,3,3,3,3,2,2,2,2,2,2},
                    {3,3,3,3,2,3,3,2,2,2,2,2,2},
                    {3,3,2,2,2,2,3,2,2,2,2,2,2},
                    {3,3,2,2,2,2,2,3,2,2,2,2,1},
                    {3,3,2,2,2,2,2,2,3,2,2,2,1},
                    {3,2,2,2,2,2,2,2,2,3,2,2,2},
                    {3,2,2,2,2,-1,-1,-1,1,2,3,2,1},
                    {3,2,2,2,1,0,0,0,0,-1,0,3,-1},
                    {3,2,2,2,-1,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
                else if (stakeSz.equals("3 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,3},
                            {3,3,3,3,3,3,3,3,3,2,2,2,2},
                            {3,3,3,3,3,3,2,2,2,2,2,2,2},
                            {3,3,3,3,3,3,2,2,2,2,2,2,2},
                            {3,3,3,2,3,2,2,2,2,2,2,2,2},
                            {3,3,2,2,2,3,2,2,2,2,2,2,2},
                            {3,2,2,2,2,2,3,2,2,2,2,1,1},
                            {3,2,2,2,2,2,2,3,2,2,2,2,-1},
                            {3,2,2,2,2,2,2,2,3,2,2,2,1},
                            {3,2,2,2,1,1,1,1,2,3,2,2,1},
                            {3,2,2,2,1,-1,-1,-1,-1,1,3,2,1},
                            {3,2,2,1,-1,0,0,0,0,-1,0,3,-1},
                            {3,2,2,1,-1,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("4 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,2},
                            {3,3,3,3,3,3,2,2,2,2,2,2,2},
                            {3,3,3,3,3,2,2,2,2,2,2,1,-1},
                            {3,3,2,3,2,2,2,2,1,1,-1,0,0},
                            {3,3,2,2,3,2,2,2,1,0,0,0,0},
                            {3,2,2,2,2,3,2,2,-1,0,0,0,0},
                            {3,2,2,1,-1,-1,3,2,-1,0,0,0,0},
                            {3,2,-1,0,0,0,0,3,1,0,0,0,0},
                            {2,2,-1,0,0,0,0,0,3,-1,0,0,0},
                            {2,2,0,0,0,0,0,0,0,3,0,0,0},
                            {2,1,0,0,0,0,0,0,0,0,3,0,0},
                            {2,-1,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("5 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,2,2},
                            {3,3,3,3,3,2,2,2,2,2,2,2,1},
                            {3,3,3,3,2,2,2,2,2,1,-1,-1,0},
                            {3,3,2,3,2,2,2,1,-1,0,0,0,0},
                            {3,2,2,2,3,2,2,1,0,0,0,0,0},
                            {3,2,2,1,-1,3,2,1,0,0,0,0,0},
                            {3,2,-1,0,0,0,3,1,-1,0,0,0,0},
                            {2,2,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,1,0,0,0,0,0,0,3,0,0,0,0},
                            {2,-1,0,0,0,0,0,0,0,3,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,3,0,0},
                            {2,0,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("6 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,2,2,2,2,2},
                            {3,3,3,3,3,2,2,2,2,2,1,1,-1},
                            {3,3,3,2,2,2,2,-1,-1,-1,0,0,0},
                            {3,2,2,3,2,2,1,-1,0,0,0,0,0},
                            {3,2,2,2,3,2,1,-1,0,0,0,0,0},
                            {3,2,-1,-1,-1,3,1,-1,0,0,0,0,0},
                            {2,1,0,0,0,0,3,-1,-1,0,0,0,0},
                            {2,-1,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,-1,0,0,0,0,0,0,3,0,0,0,0},
                            {2,0,0,0,0,0,0,0,0,3,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,2,0,0},
                            {2,0,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("7 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,2,2,2,2,2},
                            {3,3,3,3,2,2,2,2,1,1,-1,-1,-1},
                            {3,3,3,2,2,2,1,-1,-1,0,0,0,0},
                            {3,2,2,3,2,2,-1,-1,0,0,0,0,0},
                            {3,2,1,1,3,2,1,-1,0,0,0,0,0},
                            {3,1,-1,0,0,3,1,-1,0,0,0,0,0},
                            {2,-1,0,0,0,0,3,-1,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,0,3,0,0,0,0},
                            {2,0,0,0,0,0,0,0,0,3,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,2,0,0},
                            {2,0,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("8 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,2,2,2,2,2,2},
                            {3,3,3,2,2,2,1,1,1,-1,-1,-1,0},
                            {3,2,3,2,2,1,-1,-1,0,0,0,0,0},
                            {3,2,2,3,2,1,-1,-1,0,0,0,0,0},
                            {3,2,1,-1,3,2,1,-1,0,0,0,0,0},
                            {3,-1,0,0,0,3,1,-1,0,0,0,0,0},
                            {2,0,0,0,0,0,3,-1,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,0,0,0,0,0,0,0,3,-1,0,0,0},
                            {2,0,0,0,0,0,0,0,0,3,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,2,0,0},
                            {1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {1,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("9 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,2,2,2,2,2,2},
                            {3,3,3,2,2,2,-1,-1,-1,-1,0,0,0},
                            {3,2,3,2,2,1,-1,0,0,0,0,0,0},
                            {3,2,1,3,2,1,-1,0,0,0,0,0,0},
                            {3,1,-1,-1,3,1,-1,-1,0,0,0,0,0},
                            {3,-1,0,0,0,3,-1,-1,0,0,0,0,0},
                            {2,0,0,0,0,0,3,-1,0,0,0,0,0},
                            {2,0,0,0,0,0,0,3,-1,0,0,0,0},
                            {1,0,0,0,0,0,0,0,3,0,0,0,0},
                            {1,0,0,0,0,0,0,0,0,3,0,0,0},
                            {1,0,0,0,0,0,0,0,0,0,2,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
        else if (stakeSz.equals("10 BB")) {
                   /* tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1; tPush[0][6] = 1; tPush[0][7] = 1; tPush[0][8] = 1;tPush[0][9] = 1; tPush[0][10] = 1; tPush[0][11] = 1;tPush[0][12] = 1;
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
                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,2,2,2,2,2,2,1},
                    {3,3,3,2,2,1,-1,-1,-1,-1,0,0,0},
                    {3,2,3,2,2,-1,-1,0,0,0,0,0,0},
                    {3,2,-1,3,2,-1,-1,0,0,0,0,0,0},
                    {3,1,-1,-1,3,1,-1,0,0,0,0,0,0},
                    {2,0,0,0,0,3,-1,-1,0,0,0,0,0},
                    {2,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {1,0,0,0,0,0,0,3,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,3,0,0,0,0},
                    {1,0,0,0,0,0,0,0,0,3,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("11 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,2,2,2,2,2,1,1},
                    {3,3,2,2,2,-1,-1,-1,-1,0,0,0,0},
                    {3,2,3,2,1,-1,-1,0,0,0,0,0,0},
                    {3,1,-1,3,1,-1,-1,0,0,0,0,0,0},
                    {3,-1,-1,-1,3,-1,-1,0,0,0,0,0,0},
                    {2,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {2,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {1,0,0,0,0,0,0,3,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,3,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("12 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,2,2,2,1,1,1,1,-1},
                    {3,3,2,2,1,-1,-1,-1,0,0,0,0,0},
                    {3,2,3,1,1,-1,-1,0,0,0,0,0,0},
                    {3,1,-1,3,1,-1,-1,0,0,0,0,0,0},
                    {3,-1,0,-1,3,-1,-1,0,0,0,0,0,0},
                    {2,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {1,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,3,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,3,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,2,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("13 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,2,2,1,1,1,1,-1,-1},
                    {3,3,2,2,1,-1,-1,-1,0,0,0,0,0},
                    {3,2,3,1,1,-1,0,0,0,0,0,0,0},
                    {3,-1,-1,3,1,-1,-1,0,0,0,0,0,0},
                    {2,-1,0,-1,3,-1,-1,0,0,0,0,0,0},
                    {1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,3,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,3,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,2,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("14 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,2,1,1,-1,1,-1,-1,-1},
                    {3,3,2,1,1,-1,-1,0,0,0,0,0,0},
                    {3,1,3,1,1,-1,-1,0,0,0,0,0,0},
                    {3,-1,-1,3,1,-1,-1,0,0,0,0,0,0},
                    {2,-1,0,-1,3,-1,-1,0,0,0,0,0,0},
                    {1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,0,3,-1,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,3,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("15 BB")) {

            int[][] tPush2 = new int[][] {
                    { 3, 3, 3, 3,2, 2, 1, 1,-1,1,-1,-1,-1},
                    { 3, 3, 2, 1,1,-1,-1, 0,0,0,0,0,0},
                    { 3, 1, 3, 1,1,-1,-1, 0,0,0,0,0,0},
                    { 3,-1,-1, 3,1,-1,-1, 0,0,0,0,0,0},
                    { 2, 0, 0,-1,3,-1,-1, 0,0,0,0,0,0},
                    { 1, 0, 0, 0,0, 3,-1, 0,0,0,0,0,0},
                    {-1, 0, 0, 0,0, 0, 3,-1,0,0,0,0,0},
                    { 0, 0, 0, 0,0, 0, 0, 3,0,0,0,0,0},
                    { 0, 0, 0, 0,0, 0, 0, 0,2,0,0,0,0},
                    { 0, 0, 0, 0,0, 0, 0, 0,0,2,0,0,0},
                    { 0, 0, 0, 0,0, 0, 0, 0,0,0,1,0,0},
                    { 0, 0, 0, 0,0, 0, 0, 0,0,0,0,1,0},
                    { 0, 0, 0, 0,0, 0, 0,0, 0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("16 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,2,-1,-1,-1,-1,-1,-1,-1,0},
                    {3,3,2,1,-1,-1,-1,0,0,0,0,0,0},
                    {3,-1,3,1,-1,-1,0,0,0,0,0,0,0},
                    {2,-1,-1,3,-1,-1,-1,0,0,0,0,0,0},
                    {1,0,0,0,3,-1,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("17 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,-1,-1,-1,-1,-1,-1,0,0},
                    {3,3,1,1,-1,-1,-1,-1,0,0,0,0,0},
                    {3,-1,3,1,-1,-1,-1,0,0,0,0,0,0},
                    {2,-1,-1,3,-1,-1,-1,0,0,0,0,0,0},
                    {-1,0,0,-1,3,-1,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("18 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,-1,-1,-1,-1,-1,-1,-1,-1},
                    {3,3,1,-1,-1,-1,-1,0,0,0,0,0,0},
                    {3,-1,3,-1,-1,-1,0,0,0,0,0,0,0},
                    {1,-1,-1,3,-1,-1,0,0,0,0,0,0,0},
                    {-1,0,0,0,3,-1,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("19 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,-1,-1,-1,0,-1,0,0,0},
                    {3,3,1,-1,-1,-1,0,0,0,0,0,0,0},
                    {2,-1,3,-1,-1,-1,0,0,0,0,0,0,0},
                    {1,-1,0,3,-1,-1,0,0,0,0,0,0,0},
                    {-1,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("20 BB")) {
                    /*tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1;tPush[1][3] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;
                                                                                       tPush[4][4] = 1;
                                                                                                        tPush[5][5] = 1;
                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,2,2,-1,-1,-1,-1,0,-1,-1,0,0},
                    {3,3,1,-1,-1,-1,-1,0,0,0,0,0,0},
                    {2,-1,3,-1,-1,-1,-1,0,0,0,0,0,0},
                    {1,-1,-1,3,-1,-1,0,0,0,0,0,0,0},
                    {-1,-1,-1,0,3,-1,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,2,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("21 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,1,-1,-1,-1,-1,0,-1,-1,0,0},
                    {3,3,1,-1,-1,-1,-1,0,0,0,0,0,0},
                    {2,-1,3,-1,-1,-1,-1,0,0,0,0,0,0},
                    {-1,-1,-1,3,-1,-1,0,0,0,0,0,0,0},
                    {-1,-1,-1,-1,3,-1,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,2,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);

        }
        else if (stakeSz.equals("22 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,2,1,1,-1,-1,0,0,-1,0,0,0},
                    {3,3,1,1,1,-1,-1,0,0,0,0,0,0},
                    {2,-1,3,1,1,-1,0,0,0,0,0,0,0},
                    {1,-1,-1,3,1,-1,0,0,0,0,0,0,0},
                    {0,-1,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,2,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);

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
    protected void foldAction_6p(MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        mv.setCurrChart(3); //to 3 players
        mv.setCurrPrc(m_currPD[2][5]);

        //tDiff[2][6]=1;
        //tDiff[3][6]=1;
        tDiff[4][2]=1;tDiff[4][3]=1;//tDiff[4][6]=1;
        //tDiff[5][6]=1;
        tDiff[6][0]=1;
        tDiff[9][9]=1;//55


        if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
            tDiff[0][12]=1;
            tDiff[4][1]=1;
            tDiff[5][7]=1;
            tDiff[6][7]=1;
            tDiff[10][10]=1;//44
        }
        else{
            tDiff[1][7]=1;
            tDiff[5][0]=1;
            tDiff[4][1]=1;

        }
        mv.setCurrDiff(tDiff);
        if (stakeSz.equals("2 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,3,3,2,2},
                    {3,3,3,3,3,3,3,2,2,2,2,2,2},
                    {3,3,3,3,3,3,3,2,2,2,2,2,2},
                    {3,3,3,3,3,3,2,2,2,2,2,2,2},
                    {3,3,2,2,2,3,2,2,2,2,2,2,2},
                    {3,2,2,2,2,2,3,2,2,2,2,2,1},
                    {3,2,2,2,2,2,2,3,2,2,2,2,-1},
                    {3,2,2,2,2,2,2,2,3,2,2,2,1},
                    {3,2,2,2,-1,1,1,2,2,3,2,2,2},
                    {3,2,2,2,-1,0,0,0,-1,1,3,2,1},
                    {3,2,2,1,0,0,0,0,0,0,0,3,-1},
                    {3,2,2,-1,0,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
                else if (stakeSz.equals("3 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,3,3,3,3,2},
                            {3,3,3,3,3,3,2,2,2,2,2,2,2},
                            {3,3,3,3,3,2,2,2,2,2,2,2,1},
                            {3,3,2,3,2,2,2,2,2,1,1,-1,-1},
                            {3,2,2,2,3,2,2,2,2,-1,-1,0,0},
                            {3,2,2,2,2,3,2,2,2,-1,0,0,0},
                            {3,2,2,1,1,1,3,2,2,-1,0,0,0},
                            {2,2,-1,-1,0,0,0,3,2,1,0,0,0},
                            {2,2,-1,0,0,0,0,0,3,1,0,0,0},
                            {2,2,0,0,0,0,0,0,0,3,-1,0,0},
                            {2,1,0,0,0,0,0,0,0,0,3,0,0},
                            {2,-1,0,0,0,0,0,0,0,0,0,2,0},
                            {2,-1,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("4 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,2,2,2,2,2},
                            {3,3,3,3,3,2,2,2,2,2,2,2,1},
                            {3,3,3,2,2,2,2,2,2,1,-1,-1,0},
                            {3,2,2,3,2,2,2,1,-1,0,0,0,0},
                            {3,2,2,2,3,2,2,1,0,0,0,0,0},
                            {3,2,2,1,-1,3,2,1,0,0,0,0,0},
                            {2,1,-1,0,0,0,3,1,0,0,0,0,0},
                            {2,1,0,0,0,0,0,3,-1,0,0,0,0},
                            {2,-1,0,0,0,0,0,0,3,0,0,0,0},
                            {2,-1,0,0,0,0,0,0,0,3,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,2,0,0},
                            {2,0,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("5 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,2,2,2,2,2,2},
                            {3,3,3,3,2,2,2,2,2,1,1,-1,-1},
                            {3,2,3,2,2,2,2,-1,-1,0,0,0,0},
                            {3,2,2,3,2,2,1,-1,0,0,0,0,0},
                            {3,2,2,1,3,2,1,-1,0,0,0,0,0},
                            {2,2,-1,0,0,3,1,-1,0,0,0,0,0},
                            {2,-1,0,0,0,0,3,-1,0,0,0,0,0},
                            {2,-1,0,0,0,0,0,3,0,0,0,0,0},
                            {2,0,0,0,0,0,0,0,3,0,0,0,0},
                            {2,0,0,0,0,0,0,0,0,3,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,2,0,0},
                            {1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {1,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("6 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,2,2,2,2,2,2,2},
                            {3,3,3,2,2,2,2,1,1,-1,-1,0,0},
                            {3,2,3,2,2,2,-1,0,0,0,0,0,0},
                            {3,2,2,3,2,2,-1,0,0,0,0,0,0},
                            {3,2,1,-1,3,2,-1,0,0,0,0,0,0},
                            {2,-1,0,0,0,3,-1,0,0,0,0,0,0},
                            {2,0,0,0,0,0,3,-1,0,0,0,0,0},
                            {2,0,0,0,0,0,0,3,0,0,0,0,0},
                            {1,0,0,0,0,0,0,0,3,0,0,0,0},
                            {2,0,0,0,0,0,0,0,0,2,0,0,0},
                            {1,0,0,0,0,0,0,0,0,0,2,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("7 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,2,2,2,2,2,2,2,2},
                            {3,3,3,2,2,2,1,-1,-1,-1,0,0,0},
                            {3,2,3,2,2,1,-1,0,0,0,0,0,0},
                            {3,2,1,3,2,1,-1,0,0,0,0,0,0},
                            {3,1,-1,-1,3,1,-1,0,0,0,0,0,0},
                            {2,0,0,0,0,3,-1,0,0,0,0,0,0},
                            {2,0,0,0,0,0,3,-1,0,0,0,0,0},
                            {1,0,0,0,0,0,0,3,0,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,3,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,2,0,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("8 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,2,2,2,2,2,2,1,1},
                            {3,3,2,2,2,1,-1,-1,0,0,0,0,0},
                            {3,2,3,2,2,-1,0,0,0,0,0,0,0},
                            {3,1,-1,3,2,-1,-1,0,0,0,0,0,0},
                            {2,-1,0,0,3,-1,-1,0,0,0,0,0,0},
                            {2,0,0,0,0,3,-1,0,0,0,0,0,0},
                            {1,0,0,0,0,0,3,-1,0,0,0,0,0},
                            {-1,0,0,0,0,0,0,3,0,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,2,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,2,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,2,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,1},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("9 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,2,2,2,1,1,1,-1,-1},
                            {3,3,2,2,2,-1,-1,0,0,0,0,0,0},
                            {3,2,3,2,1,-1,0,0,0,0,0,0,0},
                            {3,-1,-1,3,1,-1,-1,0,0,0,0,0,0},
                            {2,-1,0,0,3,-1,-1,0,0,0,0,0,0},
                            {1,0,0,0,0,3,-1,0,0,0,0,0,0},
                            {-1,0,0,0,0,0,3,-1,0,0,0,0,0},
                            {-1,0,0,0,0,0,0,3,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,2,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,2,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,2,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,1,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,1},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
        else if (stakeSz.equals("10 BB")) {
                    /*tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1; tPush[0][5] = 1;tPush[0][6] = 1;  tPush[0][9] = 1;
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

                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,2,1,1,-1,1,-1,-1,-1},
                    {3,3,2,2,1,-1,-1,0,0,0,0,0,0},
                    {3,1,3,1,1,-1,0,0,0,0,0,0,0},
                    {3,-1,-1,3,1,-1,-1,0,0,0,0,0,0},
                    {2,0,0,0,3,-1,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,3,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("11 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,2,1,1,-1,-1,-1,-1,-1,-1},
                    {3,3,2,1,1,-1,0,0,0,0,0,0,0},
                    {3,1,3,1,1,-1,0,0,0,0,0,0,0},
                    {2,-1,-1,3,1,-1,0,0,0,0,0,0,0},
                    {2,0,0,0,3,-1,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("12 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,2,1,-1,-1,-1,-1,-1,-1,0},
                    {3,3,2,1,1,-1,0,0,0,0,0,0,0},
                    {3,-1,3,1,1,-1,0,0,0,0,0,0,0},
                    {2,-1,0,3,1,-1,0,0,0,0,0,0,0},
                    {1,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("13 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,2,-1,-1,-1,-1,-1,-1,0,0},
                    {3,3,2,1,1,-1,0,0,0,0,0,0,0},
                    {3,-1,3,1,-1,-1,0,0,0,0,0,0,0},
                    {2,-1,0,3,-1,-1,0,0,0,0,0,0,0},
                    {-1,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("14 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,-1,-1,-1,0,-1,-1,0,0},
                    {3,3,1,1,-1,-1,0,0,0,0,0,0,0},
                    {3,-1,3,1,-1,-1,0,0,0,0,0,0,0},
                    {2,0,0,3,-1,-1,0,0,0,0,0,0,0},
                    {-1,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("15 BB")) {
            int[][] tPush2 = new int[][] {
                    { 3, 3,3,2, 1,-1,-1,0,0,-1,0,0,0},
                    { 3, 3,1,1,-1,-1,0,0,0,0,0,0,0},
                    { 2,-1,3,1,-1,-1,0,0,0,0,0,0,0},
                    { 1, 0,0,3,-1,-1,0,0,0,0,0,0,0},
                    {-1, 0,0,0, 3,-1,0,0,0,0,0,0,0},
                    { 0,0,0,0,0,3,0,0,0,0,0,0,0},
                    { 0,0,0,0,0,0,2,0,0,0,0,0,0},
                    { 0,0,0,0,0,0,0,1,0,0,0,0,0},
                    { 0,0,0,0,0,0,0,0,1,0,0,0,0},
                    { 0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    { 0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    { 0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    { 0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
        }
                else if (stakeSz.equals("16 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,2,1,-1,-1,-1,0,0,-1,0,0,0},
                            {3,3,1,-1,-1,-1,0,0,0,0,0,0,0},
                            {2,-1,3,-1,-1,-1,0,0,0,0,0,0,0},
                            {-1,0,0,3,-1,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,3,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,2,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,1,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,-1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
                else if (stakeSz.equals("17 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,2,1,-1,-1,-1,0,0,-1,-1,0,0},
                            {3,3,-1,-1,-1,-1,0,0,0,0,0,0,0},
                            {2,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,0,0,3,-1,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,3,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,2,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,1,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,-1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
                else if (stakeSz.equals("18 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,2,1,-1,-1,0,0,0,-1,-1,0,0},
                            {3,3,-1,-1,-1,-1,0,0,0,0,0,0,0},
                            {1,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,-1,0,3,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,3,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,2,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,-1,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,-1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
                else if (stakeSz.equals("19 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,2,-1,-1,-1,0,0,0,-1,0,0,0},
                            {3,3,-1,-1,-1,0,0,0,0,0,0,0,0},
                            {1,0,3,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,0,0,3,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,2,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,-1,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,-1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
        else if (stakeSz.equals("20 BB")) {
                   /* tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                       tPush[3][3] = 1;
                                                                                       tPush[4][4] = 1;
                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,2,-1,-1,-1,-1,0,0,-1,-1,-1,0},
                    {3,3,-1,-1,-1,-1,0,0,0,0,0,0,0},
                    {1,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                    {-1,-1,0,3,-1,0,0,0,0,0,0,0,0},
                    {0,0,0,0,2,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,-1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
        }
                else if (stakeSz.equals("21 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,1,-1,-1,0,0,0,0,-1,0,0,0},
                            {3,3,-1,-1,-1,0,0,0,0,0,0,0,0},
                            {1,0,3,-1,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,3,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,2,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,-1,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
                else if (stakeSz.equals("22 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,1,1,-1,-1,0,0,0,-1,-1,-1,0},
                            {2,3,1,1,-1,0,0,0,0,0,0,0,0},
                            {1,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,0,0,3,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,2,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,-1,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
        else if (stakeSz.equals("25 BB")) {
            tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
            tPush[1][0] = 1; tPush[1][1] = 1;
            tPush[2][2] = 1;
            tPush[3][3] = 1;
            mv.setCurrPush(tPush);
        }
    }
    protected void foldAction_7p(MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        mv.setCurrChart(4); //to 4 players
        mv.setCurrPrc(m_currPD[2][6]);
        tDiff[0][7]=1;tDiff[0][8]=1;tDiff[0][9]=1;tDiff[0][10]=1;
        //tDiff[1][6]=1;
        tDiff[2][5]=1;//tDiff[2][6]=1;
        tDiff[3][5]=1;
        tDiff[4][5]=1;

        tDiff[8][8]=1;//66

        if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
            tDiff[0][11]=1;tDiff[0][12]=1;
            tDiff[1][7]=1;
            tDiff[3][6]=1;
            tDiff[4][6]=1;
            tDiff[5][6]=1;
            tDiff[9][9]=1;//55
        }
        else{
        //    tDiff[0][11]=1;
            tDiff[3][2]=1;
            //tDiff[5][0]=1;
        }


        mv.setCurrDiff(tDiff);
        if (stakeSz.equals("2 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,3,3,3,3,3,3,3},
                    {3,3,3,3,3,3,3,3,3,2,2,2,2},
                    {3,3,3,3,3,3,2,2,2,2,2,2,2},
                    {3,3,3,3,3,3,2,2,2,2,2,2,2},
                    {3,3,3,2,3,3,2,2,2,2,2,2,2},
                    {3,2,2,2,2,3,2,2,2,2,2,2,1},
                    {3,2,2,2,2,2,3,2,2,2,2,1,-1},
                    {3,2,2,2,2,2,2,3,2,2,2,1,0},
                    {3,2,2,1,1,2,2,2,3,2,2,2,-1},
                    {3,2,2,1,0,0,-1,-1,2,3,2,2,1},
                    {3,2,2,-1,0,0,0,0,0,-1,3,2,-1},
                    {3,2,1,0,0,0,0,0,0,0,0,3,-1},
                    {2,2,-1,0,0,0,0,0,0,0,0,0,3},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
                else if (stakeSz.equals("3 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,3,3,2,3,2,2,2},
                            {3,3,3,3,3,2,2,2,2,2,2,2,2},
                            {3,3,3,3,2,2,2,2,2,2,1,1,-1},
                            {3,2,2,3,2,2,2,2,1,-1,-1,0,0},
                            {3,2,2,2,3,2,2,2,-1,0,0,0,0},
                            {3,2,2,2,2,3,2,2,1,0,0,0,0},
                            {2,2,1,-1,-1,-1,3,2,1,0,0,0,0},
                            {2,2,0,0,0,0,0,3,1,-1,0,0,0},
                            {2,1,0,0,0,0,0,0,3,-1,0,0,0},
                            {2,-1,0,0,0,0,0,0,0,3,-1,0,0},
                            {2,-1,0,0,0,0,0,0,0,0,2,0,0},
                            {2,0,0,0,0,0,0,0,0,0,0,2,0},
                            {2,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("4 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,3,2,2,2,2,2,2,2},
                            {3,3,3,2,2,2,2,2,2,2,1,-1,-1},
                            {3,2,3,2,2,2,2,-1,-1,-1,0,0,0},
                            {3,2,2,3,2,2,1,-1,0,0,0,0,0},
                            {3,2,2,2,3,2,1,-1,0,0,0,0,0},
                            {2,1,-1,0,0,3,1,-1,0,0,0,0,0},
                            {2,-1,0,0,0,0,3,-1,0,0,0,0,0},
                            {2,0,0,0,0,0,0,3,0,0,0,0,0},
                            {2,0,0,0,0,0,0,0,3,0,0,0,0},
                            {2,0,0,0,0,0,0,0,0,2,0,0,0},
                            {2,0,0,0,0,0,0,0,0,0,2,0,0},
                            {1,0,0,0,0,0,0,0,0,0,0,2,0},
                            {-1,0,0,0,0,0,0,0,0,0,0,0,2},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("5 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                                    // A  K   Q   J  10   9   8   7   6   5   4   3   2
                                    {3,  3,  3,  3,  3,  2,  2,  2,  2,  2,  2,  2,  2 }, // A
                                    {3,  3,  3,  2,  2,  2,  2,  1,  1, -1, -1,  0,  0 },
                                    {3,  2,  3,  2,  2,  2, -1,  0,  0,  0,  0,  0,  0 },
                                    {3,  2,  2,  3,  2,  1, -1,  0,  0,  0,  0,  0,  0 },  //J
                                    {3,  2,  1, -1,  3,  1, -1,  0,  0,  0,  0,  0,  0 },
                                    {2, -1,  0,  0,  0,  3, -1,  0,  0,  0,  0,  0,  0 },  //9
                                    {2,  0,  0,  0,  0,  0,  3,  0,  0,  0,  0,  0,  0 },
                                    {2,  0,  0,  0,  0,  0,  0,  3,  0,  0,  0,  0,  0 },  //7
                                    {-1, 0,  0,  0,  0,  0,  0,  0,  2,  0,  0,  0,  0 },  //6
                                    {1,  0,  0,  0,  0,  0,  0,  0,  0,  2,  0,  0,  0 },  //5
                                    {-1, 0,  0,  0,  0,  0,  0,  0,  0,  0,  2,  0,  0 },
                                    {-1, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  2,  0 },
                                    {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  2 }     };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("6 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,2,2,2,2,2,2,2,1},
                            {3,3,2,2,2,2,-1,-1,-1,0,0,0,0},
                            {3,2,3,2,2,1,-1,0,0,0,0,0,0},
                            {3,2,-1,3,2,-1,0,0,0,0,0,0,0},
                            {2,1,-1,0,3,1,-1,0,0,0,0,0,0},
                            {2,0,0,0,0,3,-1,0,0,0,0,0,0},
                            {1,0,0,0,0,0,3,0,0,0,0,0,0},
                            {-1,0,0,0,0,0,0,3,0,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,2,0,0,0,0},
                            {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,2,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,2,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,1},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("7 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,3,2,2,2,1,2,1,1,-1},
                            {3,3,2,2,2,1,-1,-1,0,0,0,0,0},
                            {3,2,3,2,2,-1,0,0,0,0,0,0,0},
                            {3,1,-1,3,2,-1,0,0,0,0,0,0,0},
                            {2,-1,0,0,3,-1,-1,0,0,0,0,0,0},
                            {1,0,0,0,0,3,-1,0,0,0,0,0,0},
                            {-1,0,0,0,0,0,3,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,3,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,2,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,2,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,2,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,2,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,1},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("8 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,2,2,1,1,-1,1,-1,-1,-1},
                            {3,3,2,2,2,-1,0,0,0,0,0,0,0},
                            {3,1,3,2,1,-1,0,0,0,0,0,0,0},
                            {2,-1,-1,3,1,-1,0,0,0,0,0,0,0},
                            {2,0,0,0,3,-1,0,0,0,0,0,0,0},
                            {-1,0,0,0,0,3,-1,0,0,0,0,0,0},
                            {0,0,0,0,0,0,3,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,2,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,2,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,2,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,2,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,1,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,-1},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("9 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,3,2,1,1,-1,-1,-1,-1,-1,0},
                            {3,3,2,2,1,-1,0,0,0,0,0,0,0},
                            {3,1,3,1,1,-1,0,0,0,0,0,0,0},
                            {2,-1,0,3,1,-1,0,0,0,0,0,0,0},
                            {1,0,0,0,3,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,3,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,3,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,2,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,2,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,-1},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
        else if (stakeSz.equals("10 BB")) {
                    /*tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1; tPush[0][3] = 1; tPush[0][4] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1; tPush[1][2] = 1; tPush[1][3] = 1; tPush[1][4] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1; tPush[2][3] = 1; tPush[2][4] = 1;
                    tPush[3][0] = 1;                                   tPush[3][3] = 1; tPush[3][4] = 1;
                                              tPush[4][4] = 1;
                                                  tPush[5][5] = 1;
                                                     tPush[6][6] = 1;
                                                           tPush[7][7] = 1;

                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,2,1,-1,-1,0,-1,-1,-1,0},
                    {3,3,2,1,1,-1,0,0,0,0,0,0,0},
                    {3,-1,3,1,1,-1,0,0,0,0,0,0,0},
                    {2,0,0,3,1,-1,0,0,0,0,0,0,0},
                    {-1,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
                else if (stakeSz.equals("11 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,2,1,-1,-1,-1,0,-1,-1,0,0},
                            {3,3,2,1,1,-1,0,0,0,0,0,0,0},
                            {3,-1,3,1,1,-1,0,0,0,0,0,0,0},
                            {1,0,0,3,-1,-1,0,0,0,0,0,0,0},
                            {-1,0,0,0,3,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,3,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,2,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,2,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,1,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("12 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,3,2,1,-1,-1,0,0,-1,0,0,0},
                            {3,3,1,1,-1,-1,0,0,0,0,0,0,0},
                            {2,-1,3,-1,-1,-1,0,0,0,0,0,0,0},
                            {1,0,0,3,-1,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,3,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,3,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,2,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("13 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,-1,-1,0,0,-1,0,0,0},
                    {3,3,1,1,-1,-1,0,0,0,0,0,0,0},
                    {2,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                    {-1,0,0,3,-1,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,2,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,-1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
                else if (stakeSz.equals("14 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,2,1,-1,-1,0,0,0,-1,0,0,0},
                            {3,3,1,-1,-1,-1,0,0,0,0,0,0,0},
                            {2,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,0,0,3,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,3,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,2,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,1,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,-1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);
                    mv.setCurrDiff(tNull);
                    mv.setCurrPrc(-1);
                }
        else if (stakeSz.equals("15 BB")) {
            int[][] tPush2 = new int[][] {
                    { 3,3,2,1,-1,-1,0,0,0,-1,0,0,0},
                    { 3,3,1,-1,-1,0,0,0,0,0,0,0,0},
                    { 2,0,3,-1,-1,0,0,0,0,0,0,0,0},
                    {-1,0,0,3,-1,0,0,0,0,0,0,0,0},
                    { 0,0,0,0, 3,0,0,0,0,0,0,0,0},
                    { 0,0,0,0, 0,2,0,0,0,0,0,0,0},
                    { 0,0,0,0, 0,0,1,0,0,0,0,0,0},
                    { 0,0,0,0, 0,0,0,-1,0,0,0,0,0},
                    { 0,0,0,0, 0,0,0,0,-1,0,0,0,0},
                    { 0,0,0,0, 0,0,0,0,0,-1,0,0,0},
                    { 0,0,0,0, 0,0,0,0,0,0,0,0,0},
                    { 0,0,0,0, 0,0,0,0,0,0,0,0,0},
                    { 0,0,0,0, 0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
        }
                else if (stakeSz.equals("16 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,2,1,-1,-1,-1,-1,0,-1,-1,-1,-1},
                            {2,3,1,-1,-1,0,0,0,0,0,0,0,0},
                            {1,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,0,0,3,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,2,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
                else if (stakeSz.equals("17 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,3,2,-1,-1,0,0,0,0,-1,-1,0,0},
                            {2,3,-1,-1,-1,0,0,0,0,0,0,0,0},
                            {1,0,3,-1,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,3,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,2,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
                else if (stakeSz.equals("18 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,2,1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                            {2,3,-1,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,-1,0,3,-1,0,0,0,0,0,0,0,0},
                            {-1,0,0,0,2,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
                else if (stakeSz.equals("19 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,2,1,-1,-1,-1,0,0,0,-1,-1,-1,0},
                            {2,3,-1,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                            {-1,0,0,2,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
        else if (stakeSz.equals("20 BB")) {
                    /*tPush[0][0] = 1; tPush[0][1] = 1; tPush[0][2] = 1;
                    tPush[1][0] = 1; tPush[1][1] = 1;
                    tPush[2][0] = 1;                  tPush[2][2] = 1;
                                                                      tPush[3][3] = 1;
                    mv.setCurrPush(tPush);*/
            int[][] tPush2 = new int[][] {
                    {3,2,1,-1,-1,0,0,0,0,0,0,0,0},
                    {2,3,-1,-1,0,0,0,0,0,0,0,0,0},
                    {-1,0,3,-1,0,0,0,0,0,0,0,0,0},
                    {0,0,0,2,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };

            mv.setCurrPush(tPush2);
            ;
        }
                else if (stakeSz.equals("21 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,2,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                            {2,3,-1,-1,0,0,0,0,0,0,0,0,0},
                            {-1,0,3,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,2,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,-1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
                else if (stakeSz.equals("22 BB")) { // 0
                    int[][] tPush2 = new int[][] {
                            {3,2,1,-1,-1,0,0,0,0,-1,-1,0,0},
                            {2,3,-1,-1,0,0,0,0,0,0,0,0,0},
                            {-1,0,3,-1,0,0,0,0,0,0,0,0,0},
                            {0,0,0,2,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,-1,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    };
                    mv.setCurrPush(tPush2);

                }
        else if (stakeSz.equals("25 BB")) {
            tPush[0][0] = 1; tPush[0][1] = 1;
            tPush[1][0] = 1; tPush[1][1] = 1;
            tPush[2][2] = 1;
            tPush[3][3] = 1;
            mv.setCurrPush(tPush);
        }
    }

    protected void foldAction_8p(MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        mv.setCurrChart(4); //to 4 players
        mv.setCurrPrc(m_currPD[2][6]);

        tDiff[0][7]=1;
        tDiff[0][8]=1;
        tDiff[0][9]=1;
        tDiff[8][8]=1;
        tDiff[3][1]=1;
        tDiff[3][2]=1;
        mv.setCurrDiff(tDiff);
        if (stakeSz.equals("2 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,3,2,2,2,2,2,2,2},
                    {3,3,3,2,2,2,2,2,2,2,1,-1,-1},
                    {3,2,3,2,2,2,2,-1,-1,-1,0,0,0},
                    {3,2,2,3,2,2,1,-1,0,0,0,0,0},
                    {3,2,2,2,3,2,1,-1,0,0,0,0,0},
                    {2,1,-1,0,0,3,1,-1,0,0,0,0,0},
                    {2,-1,0,0,0,0,3,-1,0,0,0,0,0},
                    {2,0,0,0,0,0,0,3,0,0,0,0,0},
                    {2,0,0,0,0,0,0,0,3,0,0,0,0},
                    {2,0,0,0,0,0,0,0,0,2,0,0,0},
                    {2,0,0,0,0,0,0,0,0,0,2,0,0},
                    {1,0,0,0,0,0,0,0,0,0,0,2,0},
                    {-1,0,0,0,0,0,0,0,0,0,0,0,2},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("3 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    // A  K   Q   J  10   9   8   7   6   5   4   3   2
                    {3,  3,  3,  3,  3,  2,  2,  2,  2,  2,  2,  2,  2 }, // A
                    {3,  3,  3,  2,  2,  2,  2,  1,  1, -1, -1,  0,  0 },
                    {3,  2,  3,  2,  2,  2, -1,  0,  0,  0,  0,  0,  0 },
                    {3,  2,  2,  3,  2,  1, -1,  0,  0,  0,  0,  0,  0 },  //J
                    {3,  2,  1, -1,  3,  1, -1,  0,  0,  0,  0,  0,  0 },
                    {2, -1,  0,  0,  0,  3, -1,  0,  0,  0,  0,  0,  0 },  //9
                    {2,  0,  0,  0,  0,  0,  3,  0,  0,  0,  0,  0,  0 },
                    {2,  0,  0,  0,  0,  0,  0,  3,  0,  0,  0,  0,  0 },  //7
                    {-1, 0,  0,  0,  0,  0,  0,  0,  2,  0,  0,  0,  0 },  //6
                    {1,  0,  0,  0,  0,  0,  0,  0,  0,  2,  0,  0,  0 },  //5
                    {-1, 0,  0,  0,  0,  0,  0,  0,  0,  0,  2,  0,  0 },
                    {-1, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  2,  0 },
                    {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  2 }     };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("4 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,2,2,2,2,2,2,2,1},
                    {3,3,2,2,2,2,-1,-1,-1,0,0,0,0},
                    {3,2,3,2,2,1,-1,0,0,0,0,0,0},
                    {3,2,-1,3,2,-1,0,0,0,0,0,0,0},
                    {2,1,-1,0,3,1,-1,0,0,0,0,0,0},
                    {2,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {1,0,0,0,0,0,3,0,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,3,0,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,2,0,0,0,0},
                    {-1,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,2,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,2,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("5 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,3,2,2,2,1,2,1,1,-1},
                    {3,3,2,2,2,1,-1,-1,0,0,0,0,0},
                    {3,2,3,2,2,-1,0,0,0,0,0,0,0},
                    {3,1,-1,3,2,-1,0,0,0,0,0,0,0},
                    {2,-1,0,0,3,-1,-1,0,0,0,0,0,0},
                    {1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {-1,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,3,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,2,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,2,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("6 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,2,2,1,1,-1,1,-1,-1,-1},
                    {3,3,2,2,2,-1,0,0,0,0,0,0,0},
                    {3,1,3,2,1,-1,0,0,0,0,0,0,0},
                    {2,-1,-1,3,1,-1,0,0,0,0,0,0,0},
                    {2,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {-1,0,0,0,0,3,-1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,2,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,2,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("7 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,2,1,1,-1,-1,-1,-1,-1,0},
                    {3,3,2,2,1,-1,0,0,0,0,0,0,0},
                    {3,1,3,1,1,-1,0,0,0,0,0,0,0},
                    {2,-1,0,3,1,-1,0,0,0,0,0,0,0},
                    {1,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,2,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,-1},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("8 BB")) {
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,2,1,-1,-1,0,-1,-1,-1,0},
                    {3,3,2,1,1,-1,0,0,0,0,0,0,0},
                    {3,-1,3,1,1,-1,0,0,0,0,0,0,0},
                    {2,0,0,3,1,-1,0,0,0,0,0,0,0},
                    {-1,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,3,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("9 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,-1,-1,-1,0,-1,-1,0,0},
                    {3,3,2,1,1,-1,0,0,0,0,0,0,0},
                    {3,-1,3,1,1,-1,0,0,0,0,0,0,0},
                    {1,0,0,3,-1,-1,0,0,0,0,0,0,0},
                    {-1,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,2,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,-1,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("10 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,-1,-1,0,0,-1,0,0,0},
                    {3,3,1,1,-1,-1,0,0,0,0,0,0,0},
                    {2,-1,3,-1,-1,-1,0,0,0,0,0,0,0},
                    {1,0,0,3,-1,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("11 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,2,1,-1,-1,0,0,-1,0,0,0},
                    {3,3,1,1,-1,-1,0,0,0,0,0,0,0},
                    {2,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                    {-1,0,0,3,-1,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,2,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,-1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,-1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("12 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,2,1,-1,-1,0,0,0,-1,0,0,0},
                    {3,3,1,-1,-1,-1,0,0,0,0,0,0,0},
                    {2,-1,3,-1,-1,0,0,0,0,0,0,0,0},
                    {-1,0,0,3,-1,0,0,0,0,0,0,0,0},
                    {0,0,0,0,3,-1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,2,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,-1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,-1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,-1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (stakeSz.equals("13 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,0,0,0,0,0,0,0,0,0},
                    {3,3,3,0,0,0,0,0,0,0,0,0,0},
                    {3,0,3,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,3,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,3,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,3,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("14 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,3,0,0,0,0,0,0,0,0,0},
                    {3,3,0,0,0,0,0,0,0,0,0,0,0},
                    {3,0,3,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,3,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,3,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
        }
        else if (stakeSz.equals("15 BB")) { // 0
            int[][] tPush2 = new int[][] {
                    {3,3,3,0,0,0,0,0,0,0,0,0,0},
                    {3,3,0,0,0,0,0,0,0,0,0,0,0},
                    {3,0,3,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,3,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,3,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0},
            };
            mv.setCurrPush(tPush2);
        }

    }


    protected void foldAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        if (pos.equals("BB")) {
            mv.setCurrPrc(m_currPD[2][0]); // 100%
        }
        else if (pos.equals("SB")) {
            foldAction_2p(mv, tDiff, tPush , stakeSz, tNull);
        }
        else if (pos.equals("Button")) {
            foldAction_3p(mv, tDiff, tPush , stakeSz, tNull);
        }
        else if (pos.equals("4")) {
            foldAction_4p(mv, tDiff, tPush , stakeSz, tNull);
        }
        else if (pos.equals("5")) {
            foldAction_5p(mv, tDiff, tPush , stakeSz, tNull);
        }
        else if (pos.equals("6")) {
            foldAction_6p(mv, tDiff, tPush , stakeSz, tNull);
        }
        else if (pos.equals("7")) {
            foldAction_7p(mv, tDiff, tPush , stakeSz, tNull);
        }
        else if (pos.equals("8")) {
            foldAction_8p(mv, tDiff, tPush , stakeSz, tNull);
        /*    mv.setCurrChart(1);
            mv.setCurrPush(tNull);
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
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


            if ((stakeSz.equals("40 BB"))||(stakeSz.equals("50 BB"))||(stakeSz.equals("100 BB"))) {
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
            }*/
        }
    }
    protected void pushAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            if (tCurrStake<41) {//40
                tPush[2][2] = -1; //QQ
            }
            if (tCurrStake<31) {//30
                tPush[2][2] = 2; //QQ
                tPush[0][1] = 1;//AKs
                tPush[1][0] = 1;//AKo
                tPush[3][3] = 1; //JJ
                tPush[0][2] = -1;//AQs
                tPush[0][3] = -1;//AJs
                tPush[0][4] = -1;//ATs
                tPush[4][4] = -1; //TT
                tPush[5][5] = -1; //99
                tPush[6][6] = -1; //88
                tPush[7][7] = -1; //77
                tPush[2][0] = -1;//AQo
                tPush[3][0] = -1;//AJo
            }
            if (tCurrStake<21) {//20
                tPush[2][2] = 3; //QQ
                tPush[0][1] = 2; //AKs
                tPush[1][0] = 2; //AKo
                tPush[3][3] = 2; //JJ
                tPush[4][4] = 2; //TT
                tPush[5][5] = 1; //99
                tPush[6][6] = 1; //88
                tPush[0][2] = 1; //AQs
                tPush[0][3] = 1; //AJs
                tPush[2][0] = 1; //AQo
                tPush[0][4] = -1; //ATs
                tPush[0][5] = -1; //A9s
                tPush[7][7] = -1; //77
                tPush[8][8] = -1; //66
                tPush[3][0] = -1; //AJo
                tPush[4][0] = -1; //ATo
            }
            if (tCurrStake<19) {//18
                tPush[0][2] = 2; //AQs
                tPush[2][0] = 2; //AQo
                tPush[5][5] = 2; //99
                tPush[0][4] = 1; //ATs
                tPush[7][7] = 1; //77
                tPush[3][0] = 1; //AJo
                tPush[0][6] = -1; //A8s
                tPush[1][2] = -1; //KQs
                tPush[5][0] = -1; //A9o
            }
            if (tCurrStake<17) {//16
                tPush[0][3] = 2; //AJs
                tPush[6][6] = 2; //88
                tPush[8][8] = 1; //66
                tPush[4][0] = 1; //ATo
                tPush[0][7] = -1; //A7s
                tPush[9][9] = -1; //55
                tPush[6][0] = -1; //A8o
                tPush[1][3] = -1; //KJs
                tPush[2][1] = -1; //KQo
            }
            if (tCurrStake<15) {//14
                tPush[0][1] = 3; //AKs
                tPush[1][0] = 3; //AKo

                tPush[0][4] = 2; //ATs
                tPush[7][7] = 2; //77
                tPush[8][8] = 2; //66
                tPush[3][0] = 2; //AJo

                tPush[5][0] = 1; //A9o
                tPush[0][5] = 1; //A9s
                tPush[0][6] = 1; //A8s
                tPush[9][9] = 1; //55

                tPush[0][8] = -1; //A6s
                tPush[0][9] = -1; //A5s
                tPush[0][10] = -1; //A4s
                tPush[0][11] = -1; //A3s
                tPush[0][12] = -1; //A2s
                tPush[1][4] = -1; //KTs
                tPush[1][5] = -1; //K9s
                tPush[10][10] = -1; //44
                tPush[3][1] = -1; //KJo
                tPush[4][1] = -1; //KTo
                tPush[7][0] = -1; //A7o
                tPush[8][0] = -1; //A6o
            }
            if (tCurrStake<13) {//12
                tPush[3][3] = 3; //JJ

                tPush[0][5] = 2; //A9s
                tPush[9][9] = 2; //55
                tPush[4][0] = 2; //ATo

                tPush[1][2] = 1; //KQs
                tPush[1][3] = 1; //KJs
                tPush[0][7] = 1; //A7s
                tPush[10][10] = 1; //44
                tPush[6][0] = 1; //A8o

                tPush[1][6] = -1; //K8s
                tPush[2][3] = -1; //QJs
                tPush[2][4] = -1; //QTs
                tPush[9][0] = -1; //A5o
                tPush[10][0] = -1; //A4o
                tPush[11][0] = -1; //A3o
                tPush[5][1] = -1; //K9o
            }
            if (tCurrStake<11) {//10
                tPush[0][2] = 3; //AQs
                tPush[4][4] = 3; //TT

                tPush[0][6] = 2; //A8s
                tPush[0][7] = 2; //A7s
                tPush[1][2] = 2; //KQs
                tPush[10][10] = 2; //44
                tPush[5][0] = 2; //A9o
                tPush[6][0] = 2; //A8o


                tPush[0][8] = 1; //A6s
                tPush[0][9] = 1; //A5s
                tPush[0][10] = 1; //A4s
                tPush[0][11] = 1; //A3s
                tPush[0][12] = 1; //A2s
                tPush[1][4] = 1; //KTs
                tPush[11][11] = 1; //33
                tPush[7][0] = 1; //A7o
                tPush[2][1] = 1; //KQo
                tPush[3][1] = 1; //KJo

                tPush[1][7] = -1; //K7s
                tPush[1][8] = -1; //K6s
                tPush[1][9] = -1; //K5s
                tPush[2][5] = -1; //Q9s
                tPush[3][4] = -1; //JTs
                tPush[12][0] = -1; //A2o
                tPush[6][1] = -1; //K8o
                tPush[3][2] = -1; //QJo
                tPush[4][2] = -1; //QTo
            }
            if (tCurrStake<9) {//8
                tPush[0][3] = 3; //AJs
                tPush[5][5] = 3; //99
                tPush[6][6] = 3; //88
                tPush[2][0] = 3; //AQo

                tPush[0][8] = 2; //A6s
                tPush[0][9] = 2; //A5s
                tPush[0][10] = 2; //A4s
                tPush[0][11] = 2; //A3s
                tPush[0][12] = 2; //A2s
                tPush[1][3] = 2; //KJs
                tPush[1][4] = 2; //KTs
                tPush[2][3] = 2; //QJs
                tPush[11][11] = 2; //33
                tPush[7][0] = 2; //A7o
                tPush[8][0] = 2; //A6o
                tPush[9][0] = 2; //A5o
                tPush[2][1] = 2; //KQo
                tPush[3][1] = 2; //KJo

                tPush[1][5] = 1; //K9s
                tPush[1][6] = 1; //K8s

                tPush[2][4] = 1; //QTs
                tPush[12][12] = 1; //22

                tPush[10][0] = 1; //A4o
                tPush[11][0] = 1; //A3o
                tPush[12][0] = 1; //A2o
                tPush[4][1] = 1; //KTo
                tPush[5][1] = 1; //K9o
                tPush[3][2] = 1; //QJo

                tPush[1][10] = -1; //K4s
                tPush[1][11] = -1; //K3s
                tPush[1][12] = -1; //K2s
                tPush[2][6] = -1; //Q8s
                tPush[2][7] = -1; //Q7s
                tPush[2][8] = -1; //Q6s
                tPush[3][5] = -1; //J9s
                tPush[3][6] = -1; //J8s
                tPush[4][5] = -1; //T9s

                tPush[7][1] = -1; //K7o
                tPush[8][1] = -1; //K6o
                tPush[9][1] = -1; //K5o
                tPush[10][1] = -1; //K4o
                tPush[5][2] = -1; //Q9o
                tPush[6][2] = -1; //Q8o
                tPush[4][3] = -1; //JTo
            }
            if (tCurrStake<7) {//6
                tPush[0][4] = 3; //ATs
                tPush[0][5] = 3; //A9s
                tPush[1][2] = 3; //KQs
                tPush[7][7] = 3; //77
                tPush[8][8] = 3; //66
                tPush[9][9] = 3; //55
                tPush[10][10] = 3; //44
                tPush[3][0] = 3;//AJo
                tPush[4][0] = 3;//ATo

                tPush[1][5] = 2; //K9s
                tPush[1][6] = 2; //K8s
                tPush[1][7] = 2; //K7s
                tPush[1][8] = 2; //K6s
                tPush[1][9] = 2; //K5s
                tPush[1][10] = 2; //K4s
                tPush[12][12] = 2; //22
                tPush[2][4] = 2; //QTs
                tPush[2][5] = 2; //Q9s
                tPush[2][6] = 2; //Q8s
                tPush[3][4] = 2; //JTs
                tPush[3][5] = 2; //J9s
                tPush[10][0] = 2; //A4o
                tPush[11][0] = 2; //A3o
                tPush[12][0] = 2; //A2o
                tPush[4][1] = 2; //KTo
                tPush[5][1] = 2; //K9o
                tPush[6][1] = 2; //K8o
                tPush[3][2] = 2; //QJo
                tPush[4][2] = 2; //QTo
                tPush[4][3] = 2; //JTo

                tPush[2][7] = 1; //Q7s
                tPush[2][8] = 1; //Q6s
                tPush[3][6] = 1; //J8s
                tPush[4][5] = 1; //T9s
                tPush[7][1] = 1; //K7o
                tPush[8][1] = 1; //K6o
                tPush[9][1] = 1; //K5o
                tPush[10][1] = 1; //K4o
                tPush[4][2] = 1; //QTo
                tPush[5][2] = 1; //Q9o
                tPush[11][1] = 1; //K3o
                tPush[12][1] = 1; //K2o

                tPush[2][9] = -1; //Q5s
                tPush[2][10] = -1; //Q4s
                tPush[2][11] = -1; //Q3s
                tPush[2][12] = -1; //Q2s
                tPush[3][7] = -1; //J7s
                tPush[3][8] = -1; //J6s
                tPush[3][9] = -1; //J5s
                tPush[3][10] = -1; //J4s
                tPush[4][6] = -1; //T8s
                tPush[4][7] = -1; //T7s
                tPush[4][8] = -1; //T6s
                tPush[5][6] = -1; //98s
                tPush[5][7] = -1; //97s
                tPush[6][7] = -1; //87s
                tPush[7][2] = -1; //Q7o
                tPush[8][2] = -1; //Q6o
                tPush[9][2] = -1; //Q5o
                tPush[10][2] = -1; //Q4o
                tPush[11][2] = -1; //Q3o
                tPush[5][3] = -1; //J9o
                tPush[6][3] = -1; //J8o
                tPush[7][3] = -1; //J7o
                tPush[5][4] = -1; //T9o
                tPush[6][4] = -1; //T8o
            }
            if (tCurrStake==5) {
                tPush = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2},
                        {3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 1},
                        {3, 3, 2, 3, 3, 2, 2, 2, 1, 1, 1,-1,-1},
                        {3, 2, 2, 2, 3, 2, 2, 2, 1,-1,-1,-1,-1},
                        {3, 2, 2, 2, 2, 3, 2, 2, 1,-1, 0, 0, 0},
                        {3, 2, 2, 1, 1,-1, 3, 2, 1, 0, 0, 0, 0},
                        {3, 2, 1,-1,-1,-1,-1, 3, 2, 0, 0, 0, 0},
                        {2, 2, 1,-1,-1, 0, 0, 0, 3, 1, 0, 0, 0},
                        {2, 2, 1,-1, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {2, 2,-1,-1, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {2, 2,-1,-1, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {2, 2,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
            }
            if (tCurrStake==4) {
                tPush = new int[][]{
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2}, //T
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2},
                            {3, 3, 2, 2, 3, 3, 3, 3, 3, 3, 2, 2, 2},
                            {3, 3, 2, 2, 2, 2, 3, 3, 3, 3, 3, 2, 0},
                            {3, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 2, 1},
                            {3, 2, 2, 2, 1,-1, 1, 2, 2, 3, 3, 3, 1},
                            {3, 2, 2, 2,-1,-1, 0, 0, 0, 2, 3, 2, 2},
                            {3, 2, 2, 2,-1,-1, 0, 0, 0, 0, 0, 3, 0},
                            {3, 2, 2, 1,-1, 0, 0, 0, 0, 0, 0, 0, 3},
                };
            }
            if (tCurrStake==3) {
                tPush = new int[][]{
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                            {3, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3},
                };
            }
            if (tCurrStake==2) {
                tPush = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                };
            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            if (tCurrStake<41) {//40
                tPush[2][2] = -1; //QQ
            }
            if (tCurrStake<31) {//30
                tPush[2][2] = 1; //QQ
                tPush[0][1] = -1;//AKs
                tPush[1][0] = -1;//AKo
                tPush[3][3] = -1; //JJ
            }
            if (tCurrStake<26) {//25
                tPush[2][2] = 2; //QQ
                tPush[4][4] = -1; //TT
            }
            if (tCurrStake<23) {//22
                tPush[0][1] = 2;//AKs
                tPush[1][0] = 1;//AKo
                tPush[3][3] = 2; //JJ
                tPush[0][2] = -1;//AQs
                tPush[4][4] = 1; //TT
                tPush[2][0] = -1;//AQo
                tPush[5][5] = -1; //99
            }
            if (tCurrStake<19) {//18
                tPush[0][2] = 1;//AQs
                tPush[0][3] = -1;//AJs
                tPush[6][6] = -1; //88
            }
            if (tCurrStake<17) {//16
                tPush[2][2] = 3; //QQ
                tPush[1][0] = 2;//AKo
                tPush[4][4] = 2; //TT
                tPush[2][0] = 1;//AQo
                tPush[5][5] = 1; //99
                tPush[0][4] = -1;//ATs
                tPush[7][7] = -1; //77
                tPush[3][0] = -1;//AJo
            }
            if (tCurrStake<15) {//14
                tPush[0][1] = 3;//AKs
                tPush[1][0] = 3;//AKo
                tPush[5][5] = 2; //99
                tPush[0][2] = 2;//AQs
                tPush[2][0] = 2;//AQo
                tPush[6][6] = 1; //88
                tPush[0][3] = 1;//AJs
                tPush[3][0] = 1;//AJo
                tPush[0][5] = -1;//A9s
                tPush[8][8] = -1; //66
                tPush[4][0] = -1;//ATo
            }
            if (tCurrStake<13) {//12
                tPush[1][0] = 2;//AKo
                tPush[3][3] = 3; //JJ
                tPush[6][6] = 2; //88
                tPush[0][3] = 2;//AJs
                tPush[0][4] = 1;//ATs
                tPush[4][0] = 1;//ATo
                tPush[7][7] = 1; //77
                tPush[8][8] = 1; //66

            }
            if (tCurrStake<11) {//10
                tPush[1][0] = 3;//AKo
                tPush[4][4] = 3; //TT
                tPush[3][0] = 2;//AJo
                tPush[0][4] = 2;//ATs
                tPush[4][0] = 2;//ATo
                tPush[7][7] = 2; //77
                tPush[0][5] = 1;//A9s
                tPush[0][6] = -1;//A8s
                tPush[1][2] = -1;//KQs
                tPush[9][9] = -1; //55
                tPush[5][0] = -1;//A9o
            }
            if (tCurrStake<9) {//8
                tPush[0][2] = 3;//AQs
                tPush[5][5] = 3; //99
                tPush[0][5] = 2;//A9s
                tPush[0][6] = 2;//A8s
                tPush[8][8] = 2; //66
                tPush[9][9] = 2; //55
                tPush[5][0] = 2;//A9o
                tPush[0][7] = 1;//A7s
                tPush[1][2] = 1;//KQs
                tPush[0][8] = -1;//A6s
                tPush[0][9] = -1;//A5s
                tPush[0][10] = -1;//A4s
                tPush[1][3] = -1;//KJs
                tPush[1][4] = -1;//KTs
                tPush[2][1] = -1;//KQo
                tPush[3][1] = -1;//KJo
                tPush[6][0] = -1;//A8o
                tPush[7][0] = -1;//A7o
            }
            if (tCurrStake<7) {//6
                tPush[0][3] = 3;//AJs
                tPush[6][6] = 3; //88
                tPush[7][7] = 3; //77
                tPush[2][0] = 3;//AQo
                tPush[0][7] = 2;//A7s
                tPush[0][8] = 2;//A6s
                tPush[0][9] = 2;//A5s
                tPush[1][2] = 2;//KQs
                tPush[1][3] = 2;//KJs
                tPush[1][4] = 2;//KTs
                tPush[2][1] = 2;//KQo
                tPush[10][10] = 2; //44
                tPush[6][0] = 2;//A8o
                tPush[0][10] = 1;//A4s
                tPush[0][11] = 1;//A3s
                tPush[0][12] = 1;//A2s
                tPush[1][5] = 1;//K9s
                tPush[2][3] = 1;//QJs
                tPush[3][1] = 1;//KJo
                tPush[4][1] = 1;//KTo
                tPush[7][0] = 1;//A7o
                tPush[1][6] = -1;//K8s
                tPush[2][4] = -1;//QTs
                tPush[11][11] = -1; //33
                tPush[5][1] = -1;//K9o
                tPush[8][0] = -1;//A6o
                tPush[9][0] = -1;//A5o
                tPush[10][0] = -1;//A4o
                tPush[11][0] = -1;//A3o
            }
            if (tCurrStake<5) {//4
                tPush[0][4] = 3;//ATs
                tPush[0][5] = 3;//A9s
                tPush[0][6] = 3;//A8s
                tPush[0][7] = 3;//A7s
                tPush[1][2] = 3;//KQs
                tPush[1][3] = 3;//KJs
                tPush[8][8] = 3; //66
                tPush[9][9] = 3; //55
                tPush[10][10] = 3; //44
                tPush[2][1] = 3;//KQo
                tPush[3][0] = 3;//AJo
                tPush[4][0] = 3;//ATo
                tPush[5][0] = 3;//A9o
                tPush[1][5] = 2;//K9s
                tPush[1][6] = 2;//K8s
                tPush[1][7] = 2;//K7s
                tPush[1][8] = 2;//K6s
                tPush[1][9] = 2;//K5s
                tPush[2][3] = 2;//QJs
                tPush[2][4] = 2;//QTs
                tPush[2][5] = 2;//Q9s
                tPush[3][4] = 2;//JTs
                tPush[11][11] = 2; //33
                tPush[12][12] = 2; //22
                tPush[3][1] = 2;//KJo
                tPush[4][1] = 2;//KTo
                tPush[5][1] = 2;//K9o
                tPush[6][1] = 2;//K8o
                tPush[7][0] = 2;//A7o
                tPush[8][0] = 2;//A6o
                tPush[9][0] = 2;//A5o
                tPush[10][0] = 2;//A4o
                tPush[11][0] = 2;//A3o
                tPush[12][0] = 2;//A2o
                tPush[1][10] = 1;//K4s
                tPush[1][11] = 1;//K3s
                tPush[2][6] = 1;//Q8s
                tPush[3][5] = 1;//J9s
                tPush[4][5] = 1;//T9s
                tPush[7][1] = 1;//K7o
                tPush[3][2] = 1;//QJo
                tPush[4][2] = 1;//QTo
                tPush[5][2] = 1;//Q9o
                tPush[4][3] = 1;//JTo
                tPush[1][12] = -1;//K2s
                tPush[2][7] = -1;//Q7s
                tPush[8][1] = -1;//K6o
            }
            if (tCurrStake==3) {
                tPush = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2},
                        {3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2},
                        {3, 3, 3, 3, 3, 3, 2, 2, 2, 0, 0, 0, 0},
                        {3, 3, 2, 2, 3, 3, 2, 2, 0, 0, 0, 0, 0},
                        {3, 2, 2, 2, 2, 3, 2, 2, 0, 0, 0, 0, 0},
                        {3, 2, 2, 2, 0, 0, 3, 2, 0, 0, 0, 0, 0},
                        {3, 2, 2, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {2, 2, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {2, 2, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                };
            }
            if (tCurrStake==2) {
                tPush = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2},
                        {3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 0, 0},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 0, 0, 0},
                        {3, 3, 2, 2, 2, 2, 3, 3, 3, 2, 0, 0, 0},
                        {3, 3, 2, 2, 2, 2, 2, 3, 3, 2, 0, 0, 0},
                        {3, 2, 2, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0},
                        {3, 2, 2, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            if (tCurrStake<26) {//25
                tPush[2][2] = 1; //QQ
            }
            if (tCurrStake<23) {//22
                tPush[0][1] = 1;//AKs
                tPush[2][2] = 2; //QQ
                tPush[1][0] = -1;//AKo
                tPush[3][3] = 1; //JJ
                tPush[4][4] = -1; //TT
            }
            //20 same
            if (tCurrStake<19) {//18
                tPush[0][2] = -1;//AQs
            }
            if (tCurrStake<17) {//16
                tPush[2][2] = 3; //QQ
                tPush[1][0] = 1;//AKo
                tPush[4][4] = 1; //TT
            }
            if (tCurrStake<15) {//14
                tPush[0][1] = 3;//AKs
                tPush[1][0] = 2;//AKo
                tPush[3][3] = 2; //JJ
                tPush[0][2] = 1;//AQs
                tPush[5][5] = 1; //99
                tPush[0][3] = -1;//AJs
                tPush[6][6] = -1; //88
                tPush[2][0] = -1;//AQo
            }
            if (tCurrStake<13) {//12
                tPush[4][4] = 2; //TT
                tPush[0][3] = 1;//AJs
                tPush[6][6] = 1; //88
                tPush[2][0] = 1;//AQo
                tPush[0][4] = -1;//ATs
                tPush[7][7] = -1; //77
                tPush[3][0] = -1;//AJo
            }
            if (tCurrStake<11) {//10
                tPush[3][3] = 3; //JJ
                tPush[1][0] = 3;//AKo
                tPush[0][2] = 2;//AQs
                tPush[5][5] = 2; //99
                tPush[0][4] = 1;//ATs
                tPush[3][0] = 1;//AJo
                tPush[4][0] = -1;//ATo
            }
            if (tCurrStake<9) {//8
                tPush[4][4] = 3; //TT
                tPush[0][3] = 2;//AJs
                tPush[6][6] = 2; //88
                tPush[2][0] = 2;//AQo
                tPush[0][5] = 1;//A9s
                tPush[7][7] = 1; //77
                tPush[8][8] = 1; //66
                tPush[4][0] = 1;//ATo
            }
            if (tCurrStake<7) {//6
                tPush[0][2] = 3;//AQs
                tPush[5][5] = 3; //99
                tPush[6][6] = 3; //88
                tPush[2][0] = 3;//AQo
                tPush[0][4] = 2;//ATs
                tPush[0][5] = 2;//A9s
                tPush[7][7] = 2; //77
                tPush[8][8] = 2; //66
                tPush[3][0] = 2;//AJo
                tPush[4][0] = 2;//ATo
                tPush[0][6] = 1;//A8s
                tPush[5][0] = 1;//A9o
                tPush[0][7] = -1;//A7s
                tPush[1][2] = 1;//KQs
                tPush[1][3] = -1;//KJs
                tPush[2][1] = -1;//KQo

            }
            if (tCurrStake<5) {//4
                tPush[0][3] = 3;//AJs
                tPush[0][4] = 3;//ATs
                tPush[7][7] = 3; //77
                tPush[3][0] = 3;//AJo
                tPush[0][6] = 2;//A8s
                tPush[0][7] = 2;//A7s
                tPush[0][8] = 2;//A6s
                tPush[0][9] = 2;//A5s
                tPush[1][2] = 2;//KQs
                tPush[1][3] = 2;//KJs
                tPush[1][4] = 2;//KTs
                tPush[9][9] = 2; //55
                tPush[2][1] = 2;//KQo
                tPush[5][0] = 2;//A9o
                tPush[6][0] = 2;//A8o
                tPush[0][10] = 1;//A4s
                tPush[0][11] = 1;//A3s
                tPush[7][0] = 1;//A7o
                tPush[3][1] = 1;//KJo
                tPush[0][12] = -1;//A2s
                tPush[1][5] = -1;//K9s
                tPush[2][3] = -1;//QJs
                tPush[8][0] = -1;//A6o
                tPush[4][1] = -1;//KTo

            }
            if (tCurrStake<3) {//2
                tPush[1][2] = 3;//KQs
                tPush[0][10] = 2;//A4s
                tPush[1][5] = 2;//K9s
                tPush[2][3] = 2;//QJs
                tPush[2][4] = 2;//QTs
                tPush[3][4] = 2;//JTs
                tPush[3][1] = 2;//KJo
                tPush[4][1] = 2;//KTo
                tPush[3][2] = 2;//QJo
                tPush[9][9] = 0; //55
                tPush[7][0] = 0;//A7o
                tPush[0][11] = 0;//A3s
                tPush[8][0] = 0;//A6o
                tPush[0][12] = 0;//A2s
            }

            mv.setCurrPush(tPush);
        }
        else if (pos.equals("4")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            if (tCurrStake<23) {//22
                tPush[2][2] = 1; //QQ
            }
            if (tCurrStake<21) {//20
                tPush[0][1] = -1; //AKs
                tPush[3][3] = -1; //JJ
            }
            if (tCurrStake<19) {//18
                tPush[2][2] = 2; //QQ
            }
            if (tCurrStake<17) {//16
                tPush[2][2] = 3; //QQ
                tPush[0][1] = 2; //AKs
                tPush[1][0] = -1; //AKo
                tPush[3][3] = -1; //jj
                tPush[4][4] = -1; //tt
            }
            if (tCurrStake<15) {//14
                tPush[0][1] = 3; //AKs
                tPush[1][0] = 1; //AKo
                tPush[3][3] = 1; //jj
                tPush[0][2] = -1; //AQs
                tPush[2][0] = -1; //AQo
                tPush[5][5] = -1; //99
            }
            if (tCurrStake<13) {//12
                tPush[1][0] = 2; //AKo
                tPush[3][3] = 2; //jj
                tPush[0][2] = 1; //AQs
                tPush[4][4] = 1; //tt
                tPush[0][3] = -1; //AJs

            }
            if (tCurrStake<11) {//10
                tPush[1][0] = 3; //AKo
                tPush[3][3] = 3; //jj
                tPush[4][4] = 2; //tt
                tPush[5][5] = 1; //99
                tPush[6][6] = -1; //88
                tPush[0][4] = -1; //ATs
                tPush[3][0] = -1; //AJo
            }
            if (tCurrStake<9) {//8
                tPush[4][4] = 3; //tt
                tPush[0][2] = 2; //AQs
                tPush[5][5] = 2; //99
                tPush[0][3] = 1; //AJs
                tPush[2][0] = 1; //AQo
                tPush[7][7] = -1; //77
                tPush[0][5] = -1; //A9s
                tPush[4][0] = -1; //ATo
            }
            if (tCurrStake<7) {//6
                tPush[0][2] = 3; //AQs
                tPush[2][0] = 3; //AQo
                tPush[5][5] = 3; //99
                tPush[0][3] = 2; //AJs
                tPush[0][4] = 2; //ATs
                tPush[6][6] = 2; //88
                tPush[3][0] = 2; //AJo
                tPush[0][5] = 1; //A9s
                tPush[7][7] = 1; //77
                tPush[4][0] = 1; //ATo
                tPush[0][6] = -1; //A8s
                tPush[8][8] = -1; //66
            }
            if (tCurrStake<5) {//4
                tPush[6][6] = 3; //88
                tPush[7][7] = 3; //77
                tPush[0][3] = 3; //AJs
                tPush[0][4] = 3; //ATs
                tPush[3][0] = 3; //AJo
                tPush[0][5] = 2; //A9s
                tPush[0][6] = 2; //A8s
                tPush[7][7] = 2; //77
                tPush[8][8] = 2; //66
                tPush[4][0] = 2; //ATo
                tPush[0][7] = 1; //A7s
                tPush[1][2] = 2; //KQs
                tPush[1][3] = 1; //KJs
                tPush[1][4] = 1; //KTs
                tPush[9][9] = 1; //55
                tPush[5][0] = 1; //A9o
                tPush[6][0] = 1; //A8o
                //tPush[9][9] = -1; //55
                tPush[0][8] = -1; //A6s
                tPush[0][9] = -1; //A5s
                tPush[0][10] = -1; //A4s
                tPush[2][1] = -1; //KQo
                tPush[3][1] = -1; //KJo
            }
            if (tCurrStake<3) {//2
                tPush[0][7] = 2; //A7s
                tPush[1][3] = 2; //KJs
                tPush[1][4] = 2; //KTs
                tPush[2][3] = 2; //QJs
                tPush[2][4] = 2; //QTs
                tPush[2][1] = 2; //KQo
                tPush[3][1] = 2; //KJo
                tPush[0][8] = 1; //A6s
                tPush[0][9] = 1; //A5s
                tPush[1][5] = 1; //K9s
                tPush[4][1] = 1; //KTo
                tPush[3][4] = -1; //JTs

            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("5")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            if (tCurrStake<21) //20
                tPush[2][2] = 1; //QQ
            if (tCurrStake<18) //17
                tPush[2][2] = 3; //QQ
            if (tCurrStake<16) { //15
                tPush[0][1] = 2;//AKs
                tPush[1][0] = 1;//AKo
                tPush[3][3] = 1;//jj
            }
            if (tCurrStake<14) { //13
                tPush[0][1] = 3;//AKs
            }
            if (tCurrStake<12) { //11
                tPush[3][3] = 3;//jj
                tPush[1][0] = 2;//AKo
                tPush[0][2] = 1;//AQs
                tPush[4][4] = 1;//TT
            }
            if (tCurrStake<10) { //9
                tPush[1][0] = 3;//AKo
                tPush[0][2] = 2;//AQs
                tPush[4][4] = 2;//TT
                tPush[5][5] = 1;//99
                tPush[2][0] = 1;//AQo
            }
            if (tCurrStake<8) { //7
                tPush[0][2] = 3;//AQs
                tPush[4][4] = 3;//TT
                tPush[0][3] = 2;//AJs
                tPush[2][0] = 2;//AQo
                tPush[5][5] = 2;//99
                tPush[6][6] = 2;//88
                tPush[0][4] = 1;//ATs
                tPush[3][0] = 1;//AJo
            }
            if (tCurrStake<6) { //5
                tPush[0][3] = 3;//AJs
                tPush[2][0] = 3;//AQo
                tPush[5][5] = 3;//99
                tPush[6][6] = 3;//88
                tPush[0][4] = 2;//ATs
                tPush[7][7] = 2;//77
                tPush[3][0] = 2;//AJo
                tPush[4][0] = 2;//ATo
                tPush[8][8] = 1;//66
                tPush[0][5] = 1;//A9s
                tPush[0][6] = 1;//A8s
            }
            if (tCurrStake<4) { //3
                tPush[0][4] = 3;//ATs
                tPush[3][0] = 3;//AJo
                tPush[4][0] = 3;//ATo
                tPush[0][5] = 2;//A9s
                tPush[0][6] = 2;//A8s
                tPush[0][7] = 2;//A7s
                tPush[0][8] = 1;//A6s
                tPush[0][9] = 1;//A5s
                tPush[0][10] = 1;//A4s
                tPush[0][11] = 1;//A3s
                tPush[1][2] = 2;//KQs
                tPush[1][3] = 2;//KJs
                tPush[1][4] = 2;//KTs
                tPush[1][5] = 1;//K9s
                tPush[2][3] = 1;//QJs
                tPush[8][8] = 2;//66
                tPush[5][0] = 2;//A9o
                tPush[2][1] = 2;//KQo
                tPush[6][0] = 1;//A8o
                tPush[3][1] = 1;//KJo
                tPush[4][1] = 1;//KTo
            }

            mv.setCurrPush(tPush);
        }
        else if (pos.equals("6")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK


            if (tCurrStake<17)
                tPush[2][2] = 1; //QQ
            if (tCurrStake<15) {
                tPush[2][2] = 3; //QQ
            }
            if (tCurrStake<13) {
                tPush[0][1] = 3; //AKs
                tPush[1][0] = 1; //AKo
                tPush[3][3] = 1; //JJ
            }
            if (tCurrStake<11) {//10

                tPush[1][0] = 3; //AKo
                tPush[3][3] = 3; //JJ
                tPush[4][4] = 1; //TT
            }
            if (tCurrStake<9){//8
                tPush[0][2] = 1; //AQs
                tPush[4][4] = 3; //TT
            }
            if (tCurrStake<7){//6
                tPush[0][2] = 3; //AQs
                tPush[5][5] = 3; //99
                tPush[2][0] = 3; //AQo
                tPush[0][3] = 1; //AJs
            }
            if (tCurrStake<6){ //5
                tPush[0][3] = 3; //AJs
                tPush[6][6] = 3; //88
                tPush[7][7] = 1; //77
                tPush[0][4] = 1; //ATs
                tPush[3][0] = 1; //AJo
                tPush[4][0] = 1; //ATo
            }
            if (tCurrStake<5) { //4
                tPush[0][5] = 1; //A9s
                tPush[0][6] = 1; //A8s
                tPush[1][2] = 3; //KQs
                tPush[1][3] = 1; //KJs
                tPush[2][1] = 1; //KQo
                tPush[3][0] = 3; //AJo
                tPush[5][0] = 1; //A9o
            }
            if (tCurrStake<4) { //3
                tPush[7][7] = 3; //77
                tPush[4][0] = 3; //ATo
                tPush[1][2] = 3; //KQs
                tPush[0][4] = 3; //ATs
                tPush[0][7] = 1; //A7s
                tPush[0][8] = 1; //A6s
                tPush[6][0] = 1; //A8o
                tPush[1][4] = 1; //KTs
                tPush[3][1] = 1; //KJo
                tPush[8][8] = 1; //66
            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("7")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            if (tCurrStake<17)
                tPush[2][2] = 3; //QQ
            if (tCurrStake<15){
                tPush[0][1] = 3; //AKs
            }
            if (tCurrStake<13){
                tPush[3][3] = 3; //JJ
                tPush[1][0] = 3; //AKo
            }
            if (tCurrStake<11){
                tPush[4][4] = 3; //TT
            }
            if (tCurrStake<9){
                tPush[5][5] = 3; //99
                tPush[0][2] = 3; //AQs
                tPush[2][0] = 3; //AQo
            }
            if (tCurrStake<6){
                tPush[6][6] = 3;
                tPush[7][7] = 3;
                tPush[0][3] = 3;
                tPush[0][4] = 3;
                tPush[3][0] = 3;
            }
            if (tCurrStake<4){
                tPush[1][2] = 3;
            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("8")) {
            mv.setCurrPrc(-1);
        }
    }

    protected void rPushAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }


        if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            if (tCurrStake < 31) {
                tPush[0][1] = 3; //AKs
                tPush[0][2] = 3; //AQs
                tPush[0][3] = 3; //AJs
                tPush[0][4] = 3; //ATs

                tPush[2][2] = 3; //QQ
                tPush[3][3] = 3; //JJ
                tPush[4][4] = 3; //TT
                tPush[5][5] = 3; //99
                tPush[6][6] = 3; //88

                tPush[1][0] = 3; //AKo
                tPush[2][0] = 3; //AQo
                tPush[3][0] = 3; //AJo
            }
            if (tCurrStake < 26) {
                tPush[7][7] = 3; //77
                tPush[4][0] = 3; //ATo
            }
            if (tCurrStake<21){
                tPush[0][5] = 3; //A9s
                tPush[8][8] = 3; //66
                tPush[9][9] = 3; //55
            }
            if (tCurrStake<16){
                tPush[0][6] = 3; //A8s
                tPush[0][7] = 3; //A7s
                tPush[1][2] = 3; //KQs
                tPush[10][10] = 3; //44
                tPush[11][11] = 2; //33
                tPush[5][0] = 3; //A9o
                tPush[6][0] = 3; //A8o
            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            if (tCurrStake < 31) {
                tPush[0][1] = 3; //AKs
                tPush[0][2] = 3; //AQs
                tPush[0][3] = 2; //AJs

                tPush[2][2] = 3; //QQ
                tPush[3][3] = 3; //JJ
                tPush[4][4] = 3; //TT
                tPush[5][5] = 3; //99
                tPush[6][6] = 3; //88

                tPush[1][0] = 3; //AKo
                tPush[2][0] = 3; //AQo
            }
            if (tCurrStake < 26) {
                tPush[7][7] = 3; //77
                tPush[8][8] = 3; //66

                tPush[0][3] = 3; //AJs
                tPush[0][4] = 2; //ATs
                tPush[0][5] = 2; //A9s

                tPush[3][0] = 3; //AJo
                tPush[4][0] = 2; //ATo
            }
            if (tCurrStake<21){
                tPush[9][9] = 3; //55
                tPush[0][4] = 3; //ATs
                tPush[0][6] = 2; //A8s
                tPush[5][0] = 2; //A9o
            }
            if (tCurrStake<16){
                tPush[10][10] = 3; //44
                tPush[0][5] = 3; //A9s
                tPush[0][6] = 3; //A8s
                tPush[0][7] = 2; //A7s
                tPush[4][0] = 3; //ATo
                tPush[5][0] = 3; //A9o
                tPush[6][0] = 2; //A8o
                tPush[1][2] = 3; //KQo
            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("4")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            tPush[2][2] = 3; //QQ
            tPush[0][1] = 3; //AKs
            if (tCurrStake < 26) {
                tPush[0][2] = 3; //AQs
                tPush[0][3] = 1; //AJs
                tPush[3][3] = 3; //JJ
                tPush[4][4] = 3; //TT
                tPush[5][5] = 3; //99
                tPush[6][6] = 2; //88
                tPush[1][0] = 3; //AKo
                tPush[2][0] = 1; //AQo
            }
            if (tCurrStake<21){
                tPush[0][3] = 2; //AJs
                tPush[6][6] = 3; //88
                tPush[7][7] = 3; //77
                tPush[2][0] = 3; //AQo
                tPush[3][0] = 1; //AJo
            }
            if (tCurrStake<16){
                tPush[0][3] = 3; //AJs
                tPush[0][4] = 3; //ATs
                tPush[0][5] = 1; //A9s
                tPush[8][8] = 3; //66
                tPush[9][9] = 3; //55
                tPush[3][0] = 3; //AJo
                tPush[4][0] = 2; //ATo

            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("5")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            tPush[2][2] = 3; //QQ
            tPush[0][1] = 3; //AKs
            if (tCurrStake < 26) {
                tPush[0][2] = 1; //AQs
                tPush[1][0] = 2; //AKo
                tPush[3][3] = 3; //JJ
                tPush[4][4] = 3; //TT
                tPush[5][5] = 1; //99
            }
            if (tCurrStake<21){
                tPush[0][2] = 3; //AQs
                tPush[5][5] = 3; //99
                tPush[6][6] = 1; //88
                tPush[7][7] = 1; //77
                tPush[1][0] = 3; //AKo
                tPush[2][0] = 3; //AQo
            }
            if (tCurrStake<16){
                tPush[0][3] = 3; //AJs
                tPush[0][4] = 2; //ATs
                tPush[6][6] = 3; //88
                tPush[7][7] = 3; //77
                tPush[8][8] = 3; //66
                tPush[3][0] = 2; //AJo
            }
            mv.setCurrPush(tPush);

        }
        else if (pos.equals("6")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            tPush[2][2] = 3; //QQ
            tPush[0][1] = 3; //AKs
            if (tCurrStake < 26) {
                tPush[1][0] = 2; //AKo
                tPush[3][3] = 3; //JJ
                tPush[4][4] = 1; //TT
            }
            if (tCurrStake<21){
                tPush[1][0] = 3; //AKo
                tPush[0][2] = 2; //AQs
                tPush[4][4] = 3; //TT
                tPush[5][5] = 1; //99
                tPush[6][6] = 1; //88
                tPush[2][0] = 1; //AQo
            }
            if (tCurrStake<16){
                tPush[0][2] = 3; //AQs
                tPush[0][3] = 2; //AJs
                tPush[5][5] = 3; //99
                tPush[6][6] = 2; //88
                tPush[7][7] = 1; //77
                tPush[2][0] = 3; //AQo
                tPush[3][0] = 2; //AJo
            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("7")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            tPush[2][2] = 3; //QQ
            tPush[0][1] = 3; //AKs
            if (tCurrStake < 26) {
                tPush[1][0] = 3; //AKo
                tPush[3][3] = 3; //JJ
                tPush[4][4] = 2; //TT
                tPush[0][2] = 1; //AQs
            }
            if (tCurrStake<21){
                tPush[2][0] = 1; //AQo
            }
            if (tCurrStake<16){
                tPush[0][2] = 3; //AQs
                tPush[0][3] = 1; //AJs
                tPush[2][0] = 3; //AQo
                tPush[4][4] = 3; //TT
                tPush[5][5] = 3; //99
                tPush[6][6] = 3; //88
            }
            mv.setCurrPush(tPush);
        }
        else if (pos.equals("8")) {
            mv.setCurrPrc(-1);
            tPush[0][0] = 3; //AA
            tPush[1][1] = 3; //KK
            if (tCurrStake < 26) {
                tPush[0][1] = 2; //AKs
                tPush[2][2] = 2; //QQ
                tPush[1][0] = 1; //AKo
                tPush[3][3] = 1; //JJ
            }
            if (tCurrStake<21){
                tPush[1][0] = 2; //AKo
                tPush[2][2] = 3; //QQ
                tPush[4][4] = 1; //TT
            }
            if (tCurrStake<16){
                tPush[0][1] = 3; //AKs
                tPush[0][2] = 2; //AQs
                tPush[2][0] = 1; //AQo
                tPush[3][3] = 2; //JJ
                tPush[4][4] = 2; //TT
                tPush[5][5] = 1; //99
            }
            mv.setCurrPush(tPush);
        }
    }

    protected void r0Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake<=4) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake<=6) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake<=8) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake<=10) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake<=12) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 2, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>10)&&(tCurrStake<13)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>8)&&(tCurrStake<11)) {//10
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 0},
                        {3, 3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>6)&&(tCurrStake<9)) {//8
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else {//6
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("4")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>9)&&(tCurrStake<13)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("5")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake==40)||(tCurrStake==50)) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>9)&&(tCurrStake<13)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else//9
            {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("6")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>9)&&(tCurrStake<13)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r1Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake<=4) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 0, 0, 0, 3, 3, 3, 3, 3},
                };
                mv.setCurrPush(tPush2);
            }
            else if (tCurrStake<=6) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
            }
            else if (tCurrStake<=8) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
            }
            else if (tCurrStake<=10) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 2, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 3, 3, 2, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
            }
            else if (tCurrStake<=12) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 3, 3, 2, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
            }
            mv.setCurrDiff(tNull);
            mv.setCurrPrc(-1);
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>9)&&(tCurrStake<=12)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 2, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 3, 2, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 2, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>9)&&(tCurrStake<=12)) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("4")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>9)&&(tCurrStake<13)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("5")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake<13)) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("6")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>9)&&(tCurrStake<13)) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {2, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else {//9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r2Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>10)&&(tCurrStake<=12)) {//12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>8)&&(tCurrStake<=10)) {//10
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>6)&&(tCurrStake<=8)) {//8
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else  {//6
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 2, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>10)&&(tCurrStake<=12)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>8)&&(tCurrStake<=10)) { //10
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else  { //8
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>10)&&(tCurrStake<=12)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>8)&&(tCurrStake<=10)) { //10
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>6)&&(tCurrStake<=8)) { //8
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else  { //6
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("4")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>10)&&(tCurrStake<=12)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>8)&&(tCurrStake<=10)) { //10
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>6)&&(tCurrStake<=8)) { //8
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //6
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r3Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>9)&&(tCurrStake<=12)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>9)&&(tCurrStake<=12)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>9)&&(tCurrStake<=12)) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }

    }

    protected void r4Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>9)&&(tCurrStake<=12)) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else {//9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake==50) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake==40) {
                int[][] tDiff2 = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tNull);
                mv.setCurrDiff(tDiff2);
                mv.setCurrPrc(-1);
            }
            else if ((tCurrStake>9)&&(tCurrStake<=12)) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r5Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>9)&&(tCurrStake<=12)) { //12
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void rx3bbAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {3, 1, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {3, 1, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        if (pos.equals("4")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 2, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("5")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {3, 3, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {3, 3, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("6")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void rx3sbAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("4")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 1, 0, 1, 1, 0, 0},
                        {3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 1, 0, 1, 1, 0, 0},
                        {3, 3, 3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("5")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 0, 0, 1, 0, 0, 0},
                        {3, 3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {3, 3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("6")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {3, 3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {3, 3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }
    protected void rx3btnAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("4")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 2, 1, 1, 1, 1, 1, 1, 0, 0},
                        {3, 1, 3, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("5")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 0, 0, 1, 1, 1, 0},
                        {3, 3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
                        {3, 3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("6")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void rx3coAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("5")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 0, 0, 0, 1, 1, 0, 0},
                        {3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0},
                        {3, 3, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("6")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 25) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                        {3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                        {3, 3, 3, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void rx3hjAction(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }

        if (pos.equals("6")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                        {3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                        {3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r01Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake > 20)&&(tCurrStake < 30)) {//25 icm
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake > 15)&&(tCurrStake < 21)) {//20 icm
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake > 10)&&(tCurrStake < 16)) {//15 icm
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 3, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake > 5)&&(tCurrStake < 11)) {//10 icm
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 1},
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 3, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 3, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if (tCurrStake < 6) {//5 icm
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 3, 2, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {3, 1, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1},
                        {2, 0, 0, 0, 0, 0, 0, 1, 1, 3, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 3, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 3, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake>15)&&(tCurrStake<30)) { // 25-20bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake>10)&&(tCurrStake<16)) { // 15bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if (tCurrStake<11) { // 10bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 0},
                        {3, 3, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake > 15)&&(tCurrStake < 29)) {
                int[][] tPush2 = new int[][]{ //25bb
                        {3, 3, 3, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{ //15bb
                        {3, 3, 3, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                        {3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("4")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake < 30)&&(tCurrStake > 20)) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //20
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r02Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake > 15)&&(tCurrStake < 30)) { //25 bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //15 bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake > 15)&&(tCurrStake < 30)) { //25 bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { // 15bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake > 15)&&(tCurrStake < 30)) { //25 bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //15
                int[][] tPush2 = new int[][]{
                        {3, 3, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                        {3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r12Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake > 15)&&(tCurrStake < 30)) { //25 bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //15
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 1, 3, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake > 15)&&(tCurrStake < 30)) { //25 bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else { //15 bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("Button")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake > 15)&&(tCurrStake < 30)) { //25 bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else  { //15 bb
                int[][] tPush2 = new int[][]{
                        {3, 3, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }
    protected void r03Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r13Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }
    protected void r23Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
        else if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0},
                        {3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r04Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r14Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r24Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r34Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 30) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void limpx3Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 11) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 1, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 18) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 2, 1, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void x3x3Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("SB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 16) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 0, 0},
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 21) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 26) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void r0x3Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if (tCurrStake < 11) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {3, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 1, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            else if (tCurrStake < 18) {
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                        {3, 3, 1, 3, 3, 3, 1, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 1, 3, 3, 2, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                        {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void limp0Action(String pos, MyView mv, int[][] tDiff, int[][] tPush ,String  stakeSz, int[][] tNull) {
        int tCurrStake = 100;
        if (stakeSz.length()>3) {
            try {
                String tStr = stakeSz.substring(0, stakeSz.length() - 3);
                tCurrStake = Integer.parseInt(tStr);
            } catch (NumberFormatException ex) {
                return;
            }
        }
        else{
            return;
        }
        if (pos.equals("BB")) {
            mv.setCurrPrc(-1);
            if ((tCurrStake > 15)&&(tCurrStake < 18)) { //17
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake > 13)&&(tCurrStake < 16)) { //15
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake > 11)&&(tCurrStake < 14)) { //13
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 1},
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake > 9)&&(tCurrStake < 12)) { //11
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake > 7)&&(tCurrStake < 10)) { //9
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake > 5)&&(tCurrStake < 8)) { //7
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 3, 2, 1, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 3, 2, 1, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 2, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1},
                        {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if ((tCurrStake > 3)&&(tCurrStake < 6)) { //5
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 2, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 1, 1},
                        {3, 3, 2, 1, 1, 3, 3, 3, 3, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 3, 3, 3, 3, 2, 2, 1},
                        {3, 3, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 2},
                        {3, 3, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3},
                        {3, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3},
                        {3, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3},
                        {3, 2, 1, 1, 1, 1, 1, 1, 1, 3, 2, 3, 3},
                        {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if (tCurrStake == 3) { //3
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        {3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1},
                        {3, 3, 3, 3, 2, 3, 3, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 1, 1, 3, 2, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {3, 3, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 3, 2, 3, 1},
                        {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
            if (tCurrStake == 2) { //2
                int[][] tPush2 = new int[][]{
                        {3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1},
                        {3, 3, 3, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                };
                mv.setCurrPush(tPush2);
                mv.setCurrDiff(tNull);
                mv.setCurrPrc(-1);
            }
        }
    }

    protected void calcChart(String pos, String  stake, String  stakeSz) {

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

        int[][] tNull = new int[][]
                {       // A  K   Q   J  10   9   8   7   6   5   4   3   2
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
            raiseAction(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("Limp")){
            limpAction(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("0")){
            foldAction(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("Push")){
            pushAction(pos, mv, tDiff,tPush, stakeSz);
        }
        else if (stake.equals("RPush")){
            rPushAction(pos, mv, tDiff,tPush, stakeSz);
        }
        else if (stake.equals("R0")){
            r0Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R1")){
            r1Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R2")){
            r2Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R3")){
            r3Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R4")){
            r4Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R5")){
            r5Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("Rx3BB")){
            rx3bbAction(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("Rx3SB")){
            rx3sbAction(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("Rx3BTN")){
            rx3btnAction(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("Rx3CO")){
            rx3coAction(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("Rx3HJ")){
            rx3hjAction(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R01")){
            r01Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R02")){
            r02Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R12")){
            r12Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R03")){
            r03Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R13")){
            r13Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R23")){
            r23Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R04")){
            r04Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R14")){
            r14Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R24")){
            r24Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R34")){
            r34Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("x3x3")){
            x3x3Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("Limp x3")){
            limpx3Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("R0 x3")){
            r0x3Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        else if (stake.equals("Limp0")){
            limp0Action(pos, mv, tDiff,tPush, stakeSz, tNull);
        }
        mv.setCurrAct(stake);
        mv.setCurrStake(stakeSz);
        mv.setCurrPos(pos);

        mv.invalidate();
    }
}
package com.example.myapplication5.ui.main;

import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;


public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private double[][] m_prc;
    private double[][] m_prc2;
    private double[][] m_prc3;
    private double[][] m_prc4;
    private double[][] m_prc1_50;
    private double[][] m_prc2_50;
    private int[][] m_diff;
    private int[][] m_push;
    private double m_currPrc;
    private int m_currChart;

    public void setCurrPrc(double a_prc){
        m_currPrc = a_prc;
    }
    public void setCurrChart(int c){
        m_currChart = c;
    }
    public void setCurrDiff(int[][] d){
        m_diff = d;
    }
    public void setCurrPush(int[][] p){
        m_push = p;
    }
    public double[][] getBaseTable()  {return m_prc;}


    private void init(Context context) {
        //do stuff that was in your original constructor...
        m_currChart = 1;
        m_prc = new double[][]
    {
// A    K     Q     J     10     9     8     7     6     5     4     3      2
{0.45, 3.47, 3.77, 4.52, 5.73, 8.14, 10.1, 11.6, 14.5, 14.8, 17.5, 19.0, 22.9}, // A
{5.43,  0.9, 6.94,  8.9, 10.4, 16.0, 18.7, 22.6, 26.4, 29.1, 33.0, 34.5, 39.5},
{6.64, 11.3, 1.36, 14.2, 17.2, 20.2, 27.9, 33.3, 36.3, 38.9, 40.1, 45.9, 48.1},
{7.84, 13.9, 19.9, 1.81, 22.3, 27.6, 34.8, 39.2, 48.4, 49.6, 52.6, 54.4, 58.1}, //J
{ 9.8, 16.9, 23.8, 30.9, 2.26, 35.1, 39.8, 46.5, 53.2, 60.2, 60.5, 64.1, 65.6},
{12.5, 21.1, 30.0, 38.6, 42.8, 2.71, 46.2, 52.9, 57.8, 63.8, 69.8, 71.3, 75.0}, //9
{15.7, 27.3, 36.0, 44.6, 51.4, 54.1, 3.17, 57.5, 62.6, 67.7, 74.7, 78.9, 81.0},
{18.4, 31.8, 41.9, 50.5, 57.2, 62.3, 66.5, 4.22, 64.4, 70.1, 76.2, 82.2, 87.0}, //7
{22.0, 34.2, 45.6, 56.3, 61.4, 67.4, 72.2, 75.9,  8.6, 72.5, 76.5, 84.6, 89.1}, //6
{24.7, 37.7, 49.3, 59.9, 69.5, 73.5, 77.4, 80.7, 83.1, 13.0, 78.6, 83.4, 89.4}, //5
{26.1, 41.0, 52.3, 63.5, 71.0, 79.8, 84.3, 86.7, 88.8, 87.9, 25.2, 85.8, 91.6},
{28.8, 43.7, 55.4, 65.3, 74.4, 81.9, 90.3, 92.5, 93.4, 94.6, 95.5, 36.8, 93.7},
{32.7, 47.8, 59.0, 68.6, 78.3, 85.5, 91.3, 96.4, 98.2, 97.3, 99.1,  100, 46.9}
    };

        m_prc2 = new double[][]
        {
            { 0.452,  3.017,  3.771,  4.977,  5.581, 8.748, 11.161, 13.122, 17.044, 15.837, 18.552, 20.513, 24.133 },
            { 4.676,  0.905,  5.279,  7.240,  8.446, 13.424, 20.211, 22.926, 25.038, 28.356, 31.523, 35.143, 39.668 },
            { 6.486,  9.653,  1.357, 10.860, 12.821, 17.345, 24.736, 31.222, 34.842, 39.367, 41.478, 44.646, 48.265 },
            { 8.145, 12.519, 16.742,  1.810, 14.630, 20.814, 28.054, 38.160, 44.344, 47.964, 52.187, 55.204, 58.974 },
            {10.558, 14.329, 19.457, 23.831, 2.262,  24.434, 30.920, 39.970, 47.662, 55.505, 59.879, 62.594, 65.008 },
            {15.535, 22.624, 27.753, 33.333, 36.048,  2.715, 34.540, 41.176, 50.377, 59.578, 69.231, 71.041, 73.454 },
            {18.250, 30.166, 37.858, 40.875, 44.042, 47.360,  3.469, 42.685, 50.679, 60.483, 70.739, 79.789, 80.392 },
            {21.719, 34.238, 45.551, 51.885, 53.997, 56.863, 58.673,  6.938, 50.980, 60.181, 69.532, 79.487, 86.124 },
            {26.848, 39.065, 49.170, 61.388, 64.404, 66.817, 68.929, 68.024, 11.614, 59.276, 67.119, 75.566, 82.805 },
            {25.943, 42.383, 53.092, 63.499, 73.152, 75.264, 77.376, 79.186, 74.359, 19.910, 64.706, 72.247, 81.599 },
            {29.261, 46.456, 57.768, 70.437, 78.281, 85.822, 87.934, 87.029, 84.917, 82.504, 30.618, 80.090, 84.012 },
            {32.428, 50.075, 62.293, 71.946, 81.297, 88.839, 94.570, 93.665, 91.855, 90.045, 92.760, 43.137, 89.140 },
            {36.953, 54.902, 65.913, 76.471, 83.710, 90.950, 95.475, 99.095, 97.285, 96.380, 98.190,100.000, 55.958 }
        };

        m_prc3 = new double[][]
        {
            {  0.452,  2.564,  3.318,  4.525,  5.581,  9.804, 12.670, 15.083, 16.440, 15.686, 19.155, 20.664, 23.379 },
            {  4.223,  0.905,  4.827,  6.787,  7.391, 12.971, 20.362, 21.870, 23.982, 27.149, 31.373, 34.389, 37.858 },
            {  6.486,  9.201,  1.357,  7.089,  9.502, 15.385, 22.172, 29.261, 33.786, 37.557, 39.970, 45.098, 46.908 },
            {  8.296, 12.368, 13.876,  1.810, 11.463, 17.647, 23.680, 33.484, 42.986, 45.701, 47.662, 52.187, 57.617 },
            { 11.161, 14.781, 17.345, 20.060,  2.262, 18.854, 24.736, 34.087, 44.495, 53.695, 57.315, 58.824, 62.293 },
            { 18.552, 23.077, 26.848, 28.959, 30.166,  3.017, 25.943, 34.691, 45.400, 55.807, 63.499, 68.627, 70.437 },
            { 21.569, 32.278, 38.763, 39.668, 42.685, 44.193,  5.279, 34.992, 44.796, 53.394, 61.991, 73.756, 77.979 },
            { 25.641, 37.255, 48.567, 50.980, 51.885, 55.505, 54.600, 10.256, 43.288, 50.075, 60.784, 71.644, 82.504 },
            { 31.071, 41.780, 53.092, 64.404, 66.516, 67.421, 65.611, 63.198, 16.139, 48.869, 60.030, 69.834, 80.392 },
            { 28.054, 46.606, 58.522, 69.532, 77.677, 78.884, 76.772, 74.962, 73.454, 24.434, 57.014, 64.706, 74.057 },
            { 33.183, 49.774, 61.689, 72.549, 81.297, 88.235, 86.425, 85.520, 83.409, 80.090, 36.350, 70.136, 79.186 },
            { 35.897, 56.712, 68.326, 75.867, 84.615, 90.045, 94.570, 93.665, 90.950, 89.140, 91.855, 47.360, 83.710 },
            { 40.875, 59.729, 71.342, 82.202, 87.330, 92.760, 96.380, 99.095, 98.190, 95.475, 97.285,100.000, 60.483 }
        };

        m_prc4 = new double[][] {
            {  0.452,  2.564,  2.866,  4.827,  5.430, 10.106, 12.217, 15.385, 17.798, 15.988, 17.496, 19.306, 21.569 },
            {  4.525,  0.905,  3.620,  5.128,  6.938, 12.519, 19.005, 21.267, 22.775, 24.887, 29.563, 32.278, 35.596 },
            {  6.335,  8.296, 1.357,   6.637,  8.597, 15.083, 20.965, 29.261, 31.976, 35.294, 36.199, 42.685, 45.400 },
            {  9.502, 11.011, 13.424,  1.810,  9.804, 15.686, 22.172, 29.864, 39.970, 43.891, 46.908, 47.964, 53.997 },
            { 11.916, 14.781, 17.195, 18.703,  2.262, 16.290, 21.870, 30.468, 41.478, 49.472, 53.695, 56.410, 59.879 },
            { 20.211, 24.585, 25.792, 28.959, 28.054,  3.318, 22.474, 31.674, 41.176, 49.774, 61.086, 63.801, 68.627 },
            { 23.680, 34.992, 38.311, 42.383, 40.875, 43.590,  7.391, 30.166, 37.406, 47.662, 59.578, 69.532, 72.851 },
            { 27.149, 39.668, 50.679, 56.109, 53.394, 52.489, 51.584, 13.876, 35.897, 46.606, 57.617, 68.929, 78.281 },
            { 33.183, 46.305, 57.315, 68.326, 67.421, 66.516, 64.706, 62.896, 20.664, 45.098, 55.204, 63.499, 74.962 },
            { 31.373, 49.170, 60.784, 71.342, 79.186, 80.995, 77.677, 73.756, 72.247, 26.244, 48.265, 59.276, 69.231 },
            { 34.087, 54.902, 65.611, 75.867, 82.805, 89.140, 87.330, 84.615, 81.900, 76.772, 38.763, 63.198, 72.549 },
            { 37.104, 58.974, 70.437, 80.090, 85.520, 91.855, 95.475, 92.760, 90.950, 86.425, 90.045, 47.360, 77.979 },
            { 44.796, 61.991, 74.661, 83.710, 88.235, 93.665, 97.285,100.000, 98.190, 94.570, 96.380, 99.095, 58.069 }
        };



        m_prc1_50 = new double[][] {
            { 0.452,  2.564,  3.771,  4.525,  5.732,  8.296,  9.351, 11.765, 14.630, 14.932, 18.100, 18.401, 18.703 },
            { 3.469,  0.905,  8.597,  9.653, 12.066, 17.496, 21.569, 25.943, 28.658, 30.317, 32.127, 34.238, 34.540 },
            { 5.430, 11.463,  1.357, 17.798, 19.910, 27.451, 30.618, 36.048, 38.462, 40.573, 42.081, 43.288, 45.098 },
            { 6.637, 14.329, 23.379,  1.810, 27.149, 31.825, 36.350, 43.590, 48.416, 49.321, 50.528, 53.846, 55.656 },
            { 7.994, 17.195, 28.356, 33.032,  2.262, 35.747, 41.780, 48.115, 52.036, 59.276, 59.879, 60.784, 64.103 },
            {10.558, 22.474, 33.937, 39.367, 44.495,  4.223, 44.796, 49.020, 54.148, 60.181, 67.119, 70.136, 74.359 },
            {12.971, 29.563, 38.160, 46.908, 51.735, 57.466,  7.089, 48.718, 53.544, 58.974, 66.516, 78.582, 78.884 },
            {15.837, 31.523, 46.003, 55.354, 61.689, 65.309, 63.801,  9.050, 50.830, 57.768, 62.896, 74.962, 83.710 },
            {19.608, 35.445, 47.813, 62.594, 69.834, 74.057, 73.152, 68.929, 13.424, 53.243, 59.578, 66.817, 78.281 },
            {20.814, 37.255, 50.226, 66.214, 80.694, 83.409, 81.599, 77.979, 71.342, 16.290, 54.449, 60.483, 70.437 },
            {24.284, 40.271, 52.941, 68.024, 82.504, 90.950, 89.140, 86.425, 79.789, 75.867, 21.267, 64.404, 74.661 },
            {25.189, 41.478, 56.561, 72.247, 85.520, 91.855, 96.380, 95.475, 90.045, 84.615, 88.235, 25.641, 77.074 },
            {26.848, 42.986, 58.673, 76.772, 87.330, 93.665, 99.095,100.000, 98.190, 92.760, 94.570, 97.285, 30.015 }
        };

        m_prc2_50 = new double[][] {
            { 0.452,  2.564,  2.866,  4.525,  5.732,  7.692,  9.653, 11.463, 14.630, 14.027, 17.044, 18.100, 19.306 },
            { 3.771,  0.905,  7.391,  8.899, 10.860, 14.932, 20.814, 23.680, 28.356, 29.864, 32.428, 34.540, 35.747 },
            { 5.430, 10.558,  1.357, 11.161, 14.329, 20.513, 28.658, 34.842, 35.143, 39.970, 40.875, 42.685, 44.796 },
            { 7.089, 13.725, 19.005,  1.810, 17.345, 23.379, 30.166, 39.668, 44.495, 45.098, 49.623, 50.226, 52.338 },
            { 8.597, 16.742, 22.172, 26.697,  2.262, 24.887, 30.468, 40.271, 44.193, 52.036, 52.640, 55.958, 60.181 },
            {12.368, 25.792, 33.333, 36.953, 38.160,  4.223, 32.127, 39.367, 41.478, 49.925, 62.896, 64.103, 67.722 },
            {15.837, 34.238, 43.891, 47.210, 49.321, 48.416,  6.184, 35.445, 40.573, 45.400, 55.656, 70.739, 71.946 },
            {20.211, 39.065, 55.354, 66.817, 63.801, 61.086, 54.449,  9.351, 36.048, 41.176, 50.528, 62.594, 77.074 },
            {24.585, 42.383, 57.768, 75.867, 73.756, 70.437, 65.913, 56.863, 12.821, 37.255, 42.986, 51.735, 67.421 },
            {23.077, 46.305, 65.008, 76.772, 85.219, 81.599, 78.884, 69.532, 58.673, 17.798, 62.293, 74.962, 88.235 },
            {28.054, 51.433, 68.627, 80.694, 87.934, 92.760, 90.045, 82.504, 71.644, 61.991, 21.267, 47.511, 59.879 },
            {29.563, 53.544, 72.851, 84.314, 89.140, 94.570, 98.190, 93.665, 83.409, 74.661, 79.789, 27.149, 67.119 },
            {31.825, 59.578, 77.979, 87.029, 91.855, 97.285, 99.095,100.000, 96.380, 86.124, 90.950, 95.475, 30.920 }
        };
        m_diff = new int[][]
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

        m_push = new int[][]
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

        m_currPrc=100;
    }



    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Paint paint=new Paint();
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#FFFFFF"));

        //canvas.drawCircle(x, y, radius, paint);
        //canvas.drawText(String.format("%d,%d", 111,333),2,2,paint);
        //Paint.FontMetrics fm = paint.getFontMetrics();
        //canvas.drawText(String.format("%f,%f,%f,%f,%f", fm.ascent,fm.bottom,fm.descent,fm.leading,fm.top), 35,35,paint);
        float szItem =(getHeight()-20)/14;
        float h = szItem*13;
        float fSize = szItem - 4;
        paint.setTextSize(fSize);

        float w = getWidth();
        float lp = (w-(h+szItem))/2;
        canvas.drawRect(lp+szItem/2,10+szItem, lp+h+szItem/2, h+10+szItem, paint);

        paint.setTextAlign(Paint.Align.CENTER);
        // рисуем текст в точке (150,525)
        canvas.drawText("A", lp+szItem,8+fSize, paint);
        canvas.drawText("K", lp+2*szItem,8+fSize, paint);
        canvas.drawText("Q", lp+3*szItem,8+fSize, paint);
        canvas.drawText("J", lp+4*szItem,8+fSize, paint);
        canvas.drawText("T", lp+5*szItem,8+fSize, paint);
        canvas.drawText("9", lp+6*szItem,8+fSize, paint);
        canvas.drawText("8", lp+7*szItem,8+fSize, paint);
        canvas.drawText("7", lp+8*szItem,8+fSize, paint);
        canvas.drawText("6", lp+9*szItem,8+fSize, paint);
        canvas.drawText("5", lp+10*szItem,8+fSize, paint);
        canvas.drawText("4", lp+11*szItem,8+fSize, paint);
        canvas.drawText("3", lp+12*szItem,8+fSize, paint);
        canvas.drawText("2", lp+13*szItem,8+fSize, paint);

        canvas.drawText("A", lp, 2*szItem, paint);
        canvas.drawText("K", lp, 3*szItem, paint);
        canvas.drawText("Q", lp, 4*szItem, paint);
        canvas.drawText("J", lp, 5*szItem, paint);
        canvas.drawText("T", lp, 6*szItem, paint);
        canvas.drawText("9", lp, 7*szItem, paint);
        canvas.drawText("8", lp, 8*szItem, paint);
        canvas.drawText("7", lp, 9*szItem, paint);
        canvas.drawText("6", lp, 10*szItem, paint);
        canvas.drawText("5", lp, 11*szItem, paint);
        canvas.drawText("4", lp,12*szItem, paint);
        canvas.drawText("3", lp,13*szItem, paint);
        canvas.drawText("2", lp,14*szItem, paint);

        //canvas.drawText(String.valueOf(m_currPrc), 90,8+fSize, paint);

        paint.setColor(Color.parseColor("#007F00"));
        double prcToThr=0;
        for (int i=0;i<13;++i) {
            for (int j=0;j<13;++j) {
                boolean needToDraw=false;
                if (m_currChart==1) {
                    prcToThr = m_currPrc - m_prc[i][j];
                    if (m_prc[i][j] < m_currPrc) {
                        needToDraw = true;
                    }
                }
                else
                if (m_currChart==2) {
                    prcToThr = m_currPrc - m_prc2[i][j];
                    if (m_prc2[i][j] < m_currPrc) {
                        needToDraw = true;
                    }
                }
                else
                if (m_currChart==3) {
                    prcToThr = m_currPrc - m_prc3[i][j];
                    if (m_prc3[i][j] < m_currPrc) {
                        needToDraw = true;
                    }
                }
                else
                if (m_currChart==4) {
                    prcToThr = m_currPrc - m_prc4[i][j];
                    if (m_prc4[i][j] < m_currPrc) {
                        needToDraw = true;
                    }
                }
                else
                if (m_currChart==150) {
                    prcToThr = m_currPrc - m_prc1_50[i][j];
                    if (m_prc1_50[i][j] < m_currPrc) {
                        needToDraw = true;
                    }
                }
                else
                if (m_currChart==250) {
                    prcToThr = m_currPrc - m_prc2_50[i][j];
                    if (m_prc2_50[i][j] < m_currPrc) {
                        needToDraw = true;
                    }
                }
                if(  ((needToDraw)&&(m_diff[i][j]==0)) ||
                        ((!needToDraw)&&(m_diff[i][j]==1)) ) {

                    canvas.drawRect(lp + szItem / 2 + szItem * j, 10 + szItem + szItem * i, lp + szItem / 2 + szItem + szItem * j, 10 + szItem + szItem + szItem * i, paint);
                }

                if (m_diff[i][j]==1) {
                 /*   paint.setColor(Color.parseColor("#BF0000"));
                    canvas.drawCircle(((lp + szItem / 2 + szItem * j)+(lp + szItem / 2 + szItem + szItem * j))/2,
                            ((10 + szItem + szItem * i) +(10 + szItem + szItem + szItem * i))/2,
                            10,
                            paint);
                    paint.setColor(Color.parseColor("#007F00"));*/
                }
                if (m_push[i][j]==3) {
                    paint.setColor(Color.parseColor("#92D050"));
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(7);
                    canvas.drawRect(lp + szItem / 2 + szItem * j+5, 10 + szItem + szItem * i+5, lp + szItem / 2 + szItem + szItem * j-5, 10 + szItem + szItem + szItem * i-5, paint);
                    paint.setStrokeWidth(1);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.parseColor("#007F00"));
                }
                if (m_push[i][j]==2) {
                    paint.setColor(Color.parseColor("#C6E0B4"));
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(7);
                    canvas.drawRect(lp + szItem / 2 + szItem * j+5, 10 + szItem + szItem * i+5, lp + szItem / 2 + szItem + szItem * j-5, 10 + szItem + szItem + szItem * i-5, paint);
                    paint.setStrokeWidth(1);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.parseColor("#007F00"));
                }
                if (m_push[i][j]==1) {
                    paint.setColor(Color.parseColor("#FFF2CC"));
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(7);
                    canvas.drawRect(lp + szItem / 2 + szItem * j+5, 10 + szItem + szItem * i+5, lp + szItem / 2 + szItem + szItem * j-5, 10 + szItem + szItem + szItem * i-5, paint);
                    paint.setStrokeWidth(1);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.parseColor("#007F00"));
                }
                if (m_push[i][j]==-1) {
                    paint.setColor(Color.parseColor("#F8CBAD"));
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(7);
                    canvas.drawRect(lp + szItem / 2 + szItem * j+5, 10 + szItem + szItem * i+5, lp + szItem / 2 + szItem + szItem * j-5, 10 + szItem + szItem + szItem * i-5, paint);
                    paint.setStrokeWidth(1);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.parseColor("#007F00"));
                }

            }

        }
        paint.setColor(Color.parseColor("#000000"));
        for (int i=0;i<12;++i) {
            canvas.drawLine( lp + szItem / 2 + szItem + szItem*i,10 + szItem,lp + szItem / 2 + szItem + szItem*i , 10 + szItem  + szItem*13, paint);
            canvas.drawLine( lp + szItem / 2,10 + szItem*2 + szItem*i,lp + szItem / 2 + szItem*13 ,  10 + szItem*2 + szItem*i, paint);
        }
    }
};

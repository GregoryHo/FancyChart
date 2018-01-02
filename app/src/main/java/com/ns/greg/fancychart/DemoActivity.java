package com.ns.greg.fancychart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.ns.greg.fancy_chart.chart.FancyLineChart;
import com.ns.greg.fancy_chart.chart.FancyPieChart;
import com.ns.greg.fancy_chart.data.PieChartDataSet;
import com.ns.greg.fancychart.line.FloatChartData;
import com.ns.greg.fancychart.line.IntegerChartData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/8/28
 */

public class DemoActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_demo);
    lineDemo1();
    lineDemo2();
    pieDemo1();
  }

  private void lineDemo1() {
    List<Float> dataList = new ArrayList<>(10);
    for (int i = 1; i <= 10; i++) {
      dataList.add(0.02f * i);
    }

    FancyLineChart lineChart = findViewById(R.id.line_chart_1);
    lineChart.setChartData(new FloatChartData("Very Long Title", dataList))
        .setChartBackgroundColor(Color.parseColor("#1A000000"))
        .setMargin(Utils.convertDpToPixel(20f, getApplicationContext()))
        .setTitleColor(Color.DKGRAY)
        .setDataColors(getResources().getColor(R.color.green),
            getResources().getColor(R.color.yellow), getResources().getColor(R.color.red))
        .setDataColorGradients(0.35f, 0.7f, 1f)
        .setPointColor(getResources().getColor(R.color.colorPrimaryDark))
        .setPointRadius(Utils.convertDpToPixel(4f, getApplicationContext()))
        .setXAxisTextSize(Utils.convertSpToPixel(12f, getApplicationContext()))
        .setYAxisTextSize(Utils.convertSpToPixel(12f, getApplicationContext()))
        .invalidate();
  }

  private void lineDemo2() {
    List<Float> dataList = new ArrayList<>(10);
    for (int i = 1; i <= 10; i++) {
      dataList.add(5f);
    }

    FancyLineChart lineChart = findViewById(R.id.line_chart_2);
    lineChart.setChartData(new IntegerChartData("Title" /* or null */, dataList))
        .setMargin(Utils.convertDpToPixel(20f, getApplicationContext()))
        .setChartBackgroundColor(Color.parseColor("#1A000000"))
        .setXAxisLineColor(Color.GRAY)
        .setYAxisLineColor(Color.GRAY)
        .setXAxisLabelColor(Color.BLACK)
        .setYAxisLabelColor(Color.BLACK)
        .setDataColors(getResources().getColor(R.color.colorPrimary))
        .setPointRadius(Utils.convertDpToPixel(2f, getApplicationContext()))
        .invalidate();
  }

  private void pieDemo1() {
    List<Float> dataList = new ArrayList<>(4);
    for (int i = 1; i <= 4; i++) {
      dataList.add(i * 5f);
    }

    FancyPieChart pieChart = findViewById(R.id.pie_chart_1);
    pieChart.setChartData(new PieChartDataSet("SweetPie", dataList))
        .setMargin(Utils.convertDpToPixel(20f, getApplicationContext()))
        .setChartBackgroundColor(Color.WHITE)
        .setPieRatio(0.2f, 0.2f, 0.3f, 0.3f)
        .setPieColors(Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN)
        .invalidate();
  }

  @Override protected void onResume() {
    super.onResume();
  }
}

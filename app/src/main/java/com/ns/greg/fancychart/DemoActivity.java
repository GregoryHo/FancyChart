package com.ns.greg.fancychart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.ns.greg.fancy_chart.Utils;
import com.ns.greg.fancy_chart.chart.FancyLineChart;
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
    demo1();
    demo2();
  }

  private void demo1() {
    List<Float> dataList = new ArrayList<>();
    for (int i = 1; i <= 31; i++) {
      dataList.add((float) i);
    }

    FancyLineChart lineChart = (FancyLineChart) findViewById(R.id.line_chart_1);
    lineChart.setChartData(new DemoChartData("TITLE", dataList))
        .setChartBackgroundColor(Color.parseColor("#1A000000"))
        .setMargin(Utils.convertDpToPixel(20f, getApplicationContext()))
        .setTitleColor(Color.DKGRAY)
        .setDataColors(new int[] {
            getResources().getColor(R.color.green), getResources().getColor(R.color.yellow),
            getResources().getColor(R.color.red)
        })
        .setDataColorGradients(new float[] { 0.35f, 0.7f, 1f })
        .setPointColor(getResources().getColor(R.color.colorPrimaryDark))
        .setPointRadius(Utils.convertDpToPixel(4f, getApplicationContext()))
        .setXAxisTextSize(Utils.convertSpToPixel(12f, getApplicationContext()))
        .setYAxisTextSize(Utils.convertSpToPixel(12f, getApplicationContext()))
        .invalidate();
  }

  private void demo2() {
    List<Float> dataList = new ArrayList<>();
    for (int i = 1; i <= 24; i++) {
      dataList.add((float) i * 3);
    }

    FancyLineChart lineChart = (FancyLineChart) findViewById(R.id.line_chart_2);
    lineChart.setChartData(new DemoChartData("" /* or null */, dataList))
        .setMargin(Utils.convertDpToPixel(20f, getApplicationContext()))
        .setChartBackgroundColor(Color.parseColor("#1A000000"))
        .setXAxisLineColor(Color.GRAY)
        .setYAxisLineColor(Color.GRAY)
        .setXAxisLabelColor(Color.BLACK)
        .setYAxisLabelColor(Color.BLACK)
        .setDataColors(new int[] { getResources().getColor(R.color.colorPrimary) })
        .setPointRadius(0f)
        .invalidate();
  }

  @Override protected void onResume() {
    super.onResume();
  }
}

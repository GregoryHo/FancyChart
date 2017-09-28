package com.ns.greg.fancychart;

import com.ns.greg.fancy_chart.data.LineChartDataSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/8/28
 */

public class DemoChartData extends LineChartDataSet {

  DemoChartData(String title, List<Float> dataList) {
    super(title, dataList);
    setXAxis();
    setYAxis();
  }

  private void setXAxis() {
    List<String> xAxis = new ArrayList<>();
    for (int i = 1; i <= 31; i++) {
      if (i % 4 == 0 || i == 1) {
        xAxis.add("0" + i + "PM");
      }
    }

    setXAxisLabels(xAxis);
  }

  private void setYAxis() {
    String[] yAxis =
        getYAxisValueWithDeltaAsInteger(new float[] { getMinValue(), getMaxValue() }, 6, true);
    setYAxisLabels(yAxis);
  }

  private String[] getYAxisValueWithDeltaAsInteger(float[] values, int length, boolean isNegative) {
    String[] yAxisLabels = new String[length];
    float[] min_max = values.clone();
    float delta = (min_max[1] - min_max[0]);
    int rate;
    if (delta != 0) {
      rate = (int) Math.ceil(delta / (length - 2));
    } else {
      rate = 1;
    }

    String minValue;
    if (!isNegative && (int) (min_max[0] - rate) <= 0) {
      minValue = "0";
      min_max[0] = rate;
    } else {
      minValue = Integer.toString((int) (min_max[0] - rate));
    }

    yAxisLabels[length - 1] = minValue;
    int space = length - 2;
    for (int count = space; count >= 0; count--) {
      yAxisLabels[count] = Integer.toString((int) (min_max[0] + ((space - count) * rate)));
    }

    return yAxisLabels;
  }
}

package com.ns.greg.fancychart;

import com.ns.greg.fancy_chart.data.LineChartDataSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/9/28
 */

public class FloatChartData extends LineChartDataSet {

  FloatChartData(String title, List<Float> dataList) {
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
    String[] yAxis = getYAxisValueAsFloat(new float[] { getMinValue(), getMaxValue() }, 6, false);
    setYAxisLabels(yAxis);
  }

  private String[] getYAxisValueAsFloat(float[] values, int length, boolean isNegative) {
    String[] yAxisLabels = new String[length];
    float[] min_max = values.clone();
    float delta = (min_max[1] - min_max[0]);
    float rate;
    float minRate = 0.01f;
    if (delta != 0) {
      rate = (float) (decimalFormat(2, delta / (length - 2), true) + minRate);
    } else {
      rate = minRate;
    }

    String minValue;
    if (!isNegative && min_max[0] - rate < 0) {
      minValue = "0.00";
      min_max[0] = rate;
    } else {
      double value = decimalFormat(2, (min_max[0] - rate), true);
      minValue = value == 0 ? "0.00" : Double.toString(value);
    }

    yAxisLabels[length - 1] = minValue;
    int space = length - 2;
    for (int count = space; count >= 0; count--) {
      yAxisLabels[count] =
          Double.toString(decimalFormat(2, (min_max[0] + ((space - count) * rate)), true));
    }

    return yAxisLabels;
  }

  double decimalFormat(int digits, double value, boolean round) {
    int divider = (int) Math.pow(10, digits);
    if (round) {
      return Math.rint(value * divider) / divider;
    } else {
      return Math.floor(value * divider) / divider;
    }
  }
}

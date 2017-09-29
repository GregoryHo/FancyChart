package com.ns.greg.fancy_chart.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/8/28
 */

public abstract class LineChartDataSet extends BaseDataSet {

  private final List<String> xAxisLabels = new ArrayList<>();
  private final List<String> yAxisLabels = new ArrayList<>();

  public LineChartDataSet(String title, List<Float> dataList) {
    super(title, dataList);
  }

  protected void setXAxisLabels(List<String> labels) {
    if (labels != null) {
      xAxisLabels.clear();
      xAxisLabels.addAll(labels);
    }
  }

  protected void setXAxisLabels(String[] labels) {
    if (labels != null) {
      xAxisLabels.clear();
      xAxisLabels.addAll(Arrays.asList(labels));
    }
  }

  protected void setYAxisLabels(List<String> labels) {
    if (labels != null) {
      yAxisLabels.clear();
      yAxisLabels.addAll(labels);
    }
  }

  protected void setYAxisLabels(String[] labels) {
    if (labels != null) {
      yAxisLabels.clear();
      yAxisLabels.addAll(Arrays.asList(labels));
      int length = labels.length;
      if (length > 1) {
        float[] values = new float[2];
        values[0] = Float.parseFloat(labels[length - 1]);
        values[1] = Float.parseFloat(labels[0]);
        setChartMinAndMax(values);
      }
    }
  }

  public List<String> getXAxisLabels() {
    return xAxisLabels;
  }

  public List<String> getYAxisLabels() {
    return yAxisLabels;
  }
}

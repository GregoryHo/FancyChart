package com.ns.greg.fancy_chart.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import com.ns.greg.fancy_chart.data.LineChartDataSet;
import com.ns.greg.fancy_chart.interfacies.LineFeaturesProvider;
import com.ns.greg.fancy_chart.renderer.LineRenderer;

/**
 * @author Gregory
 * @since 2017/8/28
 */

public class FancyLineChart extends BaseChart<LineRenderer>
    implements LineFeaturesProvider<FancyLineChart> {

  public FancyLineChart(Context context) {
    this(context, null);
  }

  public FancyLineChart(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public FancyLineChart(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
  }

  @Override protected LineRenderer rendererImp() {
    return new LineRenderer();
  }

  @Override public FancyLineChart setChartData(LineChartDataSet dataSet) {
    getRenderer().setChartData(dataSet);
    return this;
  }

  @Override public FancyLineChart setMargin(float margin) {
    getRenderer().setMargin(margin);
    return this;
  }

  @Override public FancyLineChart setChartBackgroundColor(@ColorInt int color) {
    getRenderer().setChartBackgroundColor(color);
    return this;
  }


  @Override public FancyLineChart setTitleTextSize(float size) {
    getRenderer().setTitleTextSize(size);
    return this;
  }

  @Override public FancyLineChart setTitleColor(@ColorInt int color) {
    getRenderer().setTitleColor(color);
    return this;
  }

  @Override public FancyLineChart setPointRadius(float radius) {
    getRenderer().setPointRadius(radius);
    return this;
  }

  @Override public FancyLineChart setPointColor(@ColorInt int color) {
    getRenderer().setPointColor(color);
    return this;
  }

  @Override public FancyLineChart setLineColor(@ColorInt int color) {
    getRenderer().setLineColor(color);
    return this;
  }

  @Override public FancyLineChart setXAxisTextSize(float textSize) {
    getRenderer().setXAxisTextSize(textSize);
    return this;
  }

  @Override public FancyLineChart setXAxisLabelColor(@ColorInt int color) {
    getRenderer().setXAxisLabelColor(color);
    return this;
  }

  @Override public FancyLineChart setXAxisLineColor(@ColorInt int color) {
    getRenderer().setXAxisLineColor(color);
    return this;
  }

  @Override public FancyLineChart setYAxisTextSize(float textSize) {
    getRenderer().setYAxisTextSize(textSize);
    return this;
  }

  @Override public FancyLineChart setYAxisLabelColor(@ColorInt int color) {
    getRenderer().setYAxisLabelColor(color);
    return this;
  }

  @Override public FancyLineChart setYAxisLineColor(@ColorInt int color) {
    getRenderer().setYAxisLineColor(color);
    return this;
  }

  @Override public FancyLineChart setDataColors(@ColorInt int[] colors) {
    getRenderer().setDataColors(colors);
    return this;
  }

  @Override public FancyLineChart setDataColorGradients(float[] gradients) {
    getRenderer().setDataColorGradients(gradients);
    return this;
  }
}

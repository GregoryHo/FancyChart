package com.ns.greg.fancy_chart.chart;

import android.content.Context;
import android.util.AttributeSet;
import com.ns.greg.fancy_chart.data.PieChartDataSet;
import com.ns.greg.fancy_chart.interfacies.PieFeatureProvider;
import com.ns.greg.fancy_chart.renderer.PieRenderer;

/**
 * @author Gregory
 * @since 2018/1/2
 */

public class FancyPieChart extends BaseChart<PieRenderer>
    implements PieFeatureProvider<FancyPieChart> {

  public FancyPieChart(Context context) {
    this(context, null);
  }

  public FancyPieChart(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public FancyPieChart(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override protected PieRenderer rendererImp() {
    return new PieRenderer();
  }

  @Override public FancyPieChart setTitleTextSize(float size) {
    getRenderer().setTitleTextSize(size);
    return this;
  }

  @Override public FancyPieChart setTitleColor(int color) {
    getRenderer().setTitleColor(color);
    return this;
  }

  @Override public FancyPieChart setChartData(PieChartDataSet data) {
    getRenderer().setChartData(data);
    return this;
  }

  @Override public FancyPieChart setMargin(float margin) {
    getRenderer().setMargin(margin);
    return this;
  }

  @Override public FancyPieChart setChartBackgroundColor(int color) {
    getRenderer().setChartBackgroundColor(color);
    return this;
  }

  @Override public FancyPieChart setPieRatio(float... ratios) {
    getRenderer().setPieRatio(ratios);
    return this;
  }

  @Override public FancyPieChart setPieColors(int... colors) {
    getRenderer().setPieColors(colors);
    return this;
  }
}

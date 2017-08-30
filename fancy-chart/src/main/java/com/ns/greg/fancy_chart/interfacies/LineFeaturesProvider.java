package com.ns.greg.fancy_chart.interfacies;

import android.support.annotation.ColorInt;
import com.ns.greg.fancy_chart.data.LineChartDataSet;

/**
 * @author Gregory
 * @since 2017/8/30
 */

public interface LineFeaturesProvider<T> extends BaseFeaturesProvider<T, LineChartDataSet> {

  T setTitleTextSize(float size);

  T setTitleColor(@ColorInt int color);

  T setPointRadius(float radius);

  T setPointColor(@ColorInt int color);

  T setLineColor(@ColorInt int color);

  T setXAxisTextSize(float size);

  T setXAxisLabelColor(@ColorInt int color);

  T setXAxisLineColor(@ColorInt int color);

  T setYAxisTextSize(float size);

  T setYAxisLabelColor(@ColorInt int color);

  T setYAxisLineColor(@ColorInt int color);

  T setDataColors(@ColorInt int[] colors);

  T setDataColorGradients(float[] gradients);
}

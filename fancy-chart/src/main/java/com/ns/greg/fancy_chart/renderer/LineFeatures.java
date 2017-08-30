package com.ns.greg.fancy_chart.renderer;

import android.support.annotation.ColorInt;

/**
 * @author Gregory
 * @since 2017/8/30
 */

interface LineFeatures {

  void setTitleTextSize(float size);

  void setTitleColor(@ColorInt int color);

  void setPointRadius(float radius);

  void setPointColor(@ColorInt int color);

  void setLineColor(@ColorInt int color);

  void setXAxisTextSize(float size);

  void setYAxisTextSize(float size);

  void setXAxisLineColor(@ColorInt int color);

  void setYAxisLineColor(@ColorInt int color);

  void setXAxisLabelColor(@ColorInt int color);

  void setYAxisLabelColor(@ColorInt int color);

  void setDataColors(@ColorInt int[] colors);

  void setDataColorGradients(float[] gradients);
}

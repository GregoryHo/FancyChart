package com.ns.greg.fancy_chart.renderer;

import android.support.annotation.ColorInt;

/**
 * @author Gregory
 * @since 2018/1/2
 */

interface PieFeatures {

  void setPieRatio(float... ratios);

  void setPieColors(@ColorInt int... colors);
}

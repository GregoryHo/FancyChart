package com.ns.greg.fancy_chart.interfacies;

import android.support.annotation.ColorInt;
import com.ns.greg.fancy_chart.data.PieChartDataSet;

/**
 * @author Gregory
 * @since 2018/1/2
 */

public interface PieFeatureProvider<T> extends BaseFeaturesProvider<T, PieChartDataSet> {

  T setPieRatio(float... ratios);

  T setPieColors(@ColorInt int... colors);
}

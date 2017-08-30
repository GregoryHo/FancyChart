package com.ns.greg.fancy_chart.interfacies;

import android.support.annotation.ColorInt;
import com.ns.greg.fancy_chart.data.BaseDataSet;

/**
 * @author Gregory
 * @since 2017/8/30
 */

public interface BaseFeaturesProvider<T, U extends BaseDataSet> {

  T setChartData(U data);

  T setMargin(float margin);

  T setChartBackgroundColor(@ColorInt int color);
}

package com.ns.greg.fancy_chart.renderer;

import android.support.annotation.ColorInt;
import com.ns.greg.fancy_chart.data.BaseDataSet;

/**
 * @author Gregory
 * @since 2017/8/30
 */

interface BaseFeatures<T extends BaseDataSet> {

  void setTitleTextSize(float size);

  void setTitleColor(@ColorInt int color);

  void setChartData(T data);

  void setMargin(float margin);

  void setChartBackgroundColor(@ColorInt int color);
}

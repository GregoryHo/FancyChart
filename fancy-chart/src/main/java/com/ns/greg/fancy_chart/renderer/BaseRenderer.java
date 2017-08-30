package com.ns.greg.fancy_chart.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import com.ns.greg.fancy_chart.data.BaseDataSet;

/**
 * @author Gregory
 * @since 2017/8/28
 */

public abstract class BaseRenderer<T extends BaseDataSet> implements BaseFeatures<T> {

  private T dataSet;
  private int left;
  private int top;
  private int right;
  private int bottom;
  private int margin;
  private int color = Color.TRANSPARENT;

  public abstract void onDraw(Canvas canvas);

  @Override public void setChartData(T dataSet) {
    this.dataSet = dataSet;
  }

  @Override public void setMargin(float margin) {
    this.margin = (int) margin;
  }

  @Override public void setChartBackgroundColor(@ColorInt int color) {
    this.color = color;
  }

  public void onLayout(int left, int top, int right, int bottom) {
    this.left = left;
    this.top = top;
    this.right = right;
    this.bottom = bottom;
  }

  T getChartData() {
    return dataSet;
  }

  int getChartColor() {
    return color;
  }

  /*--------------------------------
   * View
   *-------------------------------*/

  public int getLeft() {
    return left;
  }

  public int getTop() {
    return top;
  }

  public int getRight() {
    return right;
  }

  public int getBottom() {
    return bottom;
  }

  public int getViewWidth() {
    return right - left;
  }

  public int getViewHeight() {
    return bottom - top;
  }

  /*--------------------------------
   * Chart
   *-------------------------------*/

  public int getChartLeft() {
    return left + margin;
  }

  public int getChartRight() {
    return right - margin;
  }

  public int getChartTop() {
    return top + margin;
  }

  public int getChartBottom() {
    return bottom - margin;
  }
}

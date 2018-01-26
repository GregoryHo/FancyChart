package com.ns.greg.fancy_chart.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ns.greg.fancy_chart.data.PieChartDataSet;
import com.ns.greg.fancy_chart.utils.MeasureUtils;

/**
 * @author Gregory
 * @since 2018/1/2
 */

public class PieRenderer extends BaseRenderer<PieChartDataSet> implements PieFeatures {

  /*--------------------------------
  * Paint
  *-------------------------------*/
  private final Paint titlePaint;
  private final Paint piesPaint;
  private final Paint labelsPaint;

  /*--------------------------------
   * Padding, Font , Chart size... etc
   *-------------------------------*/
  private final Rect titleFontRect = new Rect();
  private float pieChartTop;
  private float radius;

  /*--------------------------------
   * Chart feature
   *-------------------------------*/
  private float[] ratios = new float[] { 1 };
  private int[] colors = new int[] { Color.BLACK };

  public PieRenderer() {
    // [TITLE]
    titlePaint = new Paint();
    titlePaint.setColor(Color.RED);
    titlePaint.setAntiAlias(true);
    titlePaint.setTextSize(40f);
    // [PIE]
    piesPaint = new Paint();
    piesPaint.setAntiAlias(true);
    // [LABELS]
    labelsPaint = new Paint();
    labelsPaint.setAntiAlias(true);
    labelsPaint.setTextSize(30f);
  }

  @Override public void setPieRatio(float... ratios) {
    this.ratios = ratios;
  }

  @Override public void setPieColors(int... colors) {
    this.colors = colors;
  }

  @Override public void setTitleTextSize(float size) {
    titlePaint.setTextSize(size);
  }

  @Override public void setTitleColor(int color) {
    titlePaint.setColor(color);
  }

  @Override protected void calculateChartSize() {
    pieChartTop = getChartTop();
    // Title
    String title = getChartData().getTitle();
    if (title != null) {
      titleFontRect.set(MeasureUtils.getTextBound(title, titlePaint));
    }

    float offset = titleFontRect.height() * 1.5f;
    pieChartTop += offset;
    radius = getChartBottom() - pieChartTop;
  }

  @Override protected void drawChart(Canvas canvas) {
    canvas.drawColor(getChartColor());
    drawTitle(canvas);
    drawCircles(canvas);
  }

  private void drawTitle(Canvas canvas) {
    float centerX = getCenter(getChartLeft(), getChartRight());
    canvas.drawText(getChartData().getTitle(), centerX - titleFontRect.width() / 2,
        getChartTop() + (titleFontRect.height() / 2), titlePaint);
  }

  private float getCenter(float start, float end) {
    // start + ((end - start) / 2)
    return start * 0.5f + end * 0.5f;
  }

  private void drawCircles(Canvas canvas) {
    float centerX = getCenter(getChartLeft(), getChartRight());
    float centerY = getCenter(pieChartTop, getChartBottom());
    float halfRadius = radius * 0.5f;
    RectF rectf = new RectF(centerX - halfRadius, centerY - halfRadius, centerX + halfRadius,
        centerY + halfRadius);
    int size = getChartData().getDataListSize();
    int colorSize = colors.length;
    if (colorSize > 1 && size != colorSize) {
      throw new IllegalArgumentException(
          "The color size is > 1, but not match to the data counts.");
    }

    // -90
    //  ^
    //  |
    //  |
    //  * ---> 0
    float startAngle = -90f;
    //DecimalFormat decimalFormat = new DecimalFormat("#.##");
    for (int i = 0; i < size; i++) {
      piesPaint.setColor(colors[i]);
      float ratio = ratios[i];
      float endAngle = 360f * ratio;
      canvas.drawArc(rectf, startAngle, endAngle, true, piesPaint);
      startAngle += endAngle;
    }
  }
}

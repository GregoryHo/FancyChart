package com.ns.greg.fancy_chart.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import com.ns.greg.fancy_chart.data.LineChartDataSet;
import com.ns.greg.fancy_chart.utils.MeasureUtils;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/8/28
 */

public class LineRenderer extends BaseRenderer<LineChartDataSet> implements LineFeatures {

  /*--------------------------------
   * Paint
   *-------------------------------*/
  private final Paint titlePaint;
  private final Paint yAxisLabelsPaint;
  private final Paint xAxisLabelsPaint;
  private final Paint yAxisLinePaint;
  private final Paint xAxisLinePaint;
  private final Paint linePaint;
  private final Paint pointPaint;
  private final Paint pathPaint;
  private final Path path = new Path();

  /*--------------------------------
   * Padding, Font , Chart size... etc
   *-------------------------------*/
  private final float padding = 6f;
  private Rect yAxisFontRect = new Rect();
  private Rect titleFontRect = new Rect();
  private float yAxisWidth;
  private float yAxisHeight;
  private float lineChartLeft;
  private float lineChartRight;
  private float lineChartTop;
  private float lineChartBottom;

  /*--------------------------------
   * Chart feature
   *-------------------------------*/
  private float pointRadius = 9f;
  private int[] dataColors;
  private float[] gradients;

  public LineRenderer() {
    // [TITLE]
    titlePaint = new Paint();
    titlePaint.setColor(Color.RED);
    titlePaint.setAntiAlias(true);
    titlePaint.setTextSize(40f);
    // [Y-AXIS LABELS]
    yAxisLabelsPaint = new Paint();
    yAxisLabelsPaint.setColor(Color.BLACK);
    yAxisLabelsPaint.setAntiAlias(true);
    yAxisLabelsPaint.setTextSize(30f);
    // [Y-AXIS LINE]
    yAxisLinePaint = new Paint();
    yAxisLinePaint.setColor(Color.GRAY);
    yAxisLinePaint.setAntiAlias(true);
    yAxisLinePaint.setStrokeWidth(2);
    // [X-AXIS LABELS]
    xAxisLabelsPaint = new Paint();
    xAxisLabelsPaint.setColor(Color.BLACK);
    xAxisLabelsPaint.setAntiAlias(true);
    xAxisLabelsPaint.setTextSize(30f);
    // [X-AXIS LINE]
    xAxisLinePaint = new Paint();
    xAxisLinePaint.setColor(Color.GRAY);
    xAxisLinePaint.setAntiAlias(true);
    xAxisLinePaint.setStrokeWidth(2);
    // [LINE]
    linePaint = new Paint();
    linePaint.setColor(Color.BLUE);
    linePaint.setStrokeWidth(2);
    linePaint.setAntiAlias(true);
    // [POINT]
    pointPaint = new Paint();
    pointPaint.setColor(Color.RED);
    pointPaint.setStrokeWidth(1f);
    pointPaint.setAntiAlias(true);
    pathPaint = new Paint();
    pathPaint.setAntiAlias(true);
  }

  @Override public void setPointRadius(float radius) {
    this.pointRadius = radius;
  }

  @Override public void setPointColor(int color) {
    pointPaint.setColor(color);
  }

  @Override public void setLineColor(int color) {
    linePaint.setColor(color);
  }

  @Override public void setXAxisTextSize(float textSize) {
    xAxisLabelsPaint.setTextSize(textSize);
  }

  @Override public void setYAxisTextSize(float textSize) {
    yAxisLabelsPaint.setTextSize(textSize);
  }

  @Override public void setXAxisLineColor(int color) {
    xAxisLinePaint.setColor(color);
  }

  @Override public void setYAxisLineColor(int color) {
    yAxisLinePaint.setColor(color);
  }

  @Override public void setXAxisLabelColor(int color) {
    xAxisLabelsPaint.setColor(color);
  }

  @Override public void setYAxisLabelColor(int color) {
    yAxisLabelsPaint.setColor(color);
  }

  @Override public void setDataColors(int... colors) {
    this.dataColors = colors;
  }

  @Override public void setDataColorGradients(float... gradients) {
    this.gradients = gradients;
  }

  @Override public void setTitleTextSize(float size) {
    titlePaint.setTextSize(size);
  }

  @Override public void setTitleColor(int color) {
    titlePaint.setColor(color);
  }

  @Override protected void calculateChartSize() {
    calLeftAndTop();
    calRightAndBottom();
  }

  private void calLeftAndTop() {
    List<String> yAxis = getChartData().getYAxisLabels();
    lineChartLeft = getChartLeft();
    lineChartTop = getChartTop();
    yAxisWidth = getChartLeft();
    if (yAxis.isEmpty()) {
      return;
    }

    float maxYAxisTxtWidth = Float.MIN_VALUE;
    for (String txt : yAxis) {
      float txtWidth = xAxisLabelsPaint.measureText(txt);
      if (txtWidth > maxYAxisTxtWidth) {
        maxYAxisTxtWidth = txtWidth;
      }
    }

    // Y-axis labels
    yAxisFontRect = MeasureUtils.getTextBound("0", yAxisLabelsPaint);
    yAxisWidth += maxYAxisTxtWidth;
    lineChartLeft += maxYAxisTxtWidth;
    lineChartLeft += yAxisFontRect.width() * 1.5f;
    lineChartTop += (yAxisFontRect.height() * 0.5f);
    // Title
    String title = getChartData().getTitle();
    if (title != null) {
      titleFontRect = MeasureUtils.getTextBound(title, titlePaint);
    }

    lineChartTop += titleFontRect.height() * 1.5f;
  }

  private void calRightAndBottom() {
    List<String> xAxis = getChartData().getXAxisLabels();
    lineChartRight = getChartRight();
    lineChartBottom = getChartBottom();
    if (xAxis.isEmpty()) {
      return;
    }

    float maxXAXisTxtWidth = Float.MIN_VALUE;
    for (String txt : xAxis) {
      float txtWidth = xAxisLabelsPaint.measureText(txt);
      if (txtWidth > maxXAXisTxtWidth) {
        maxXAXisTxtWidth = txtWidth;
      }
    }

    Rect xAxisFontSize = MeasureUtils.getTextBound("0", xAxisLabelsPaint);
    lineChartRight -= xAxisFontSize.width();
    lineChartBottom -= xAxisFontSize.height() * 2f;
  }

  private float getLineChartWidth() {
    return lineChartRight - lineChartLeft;
  }

  private float getLineChartHeight() {
    return lineChartBottom - lineChartTop;
  }

  private float getValueRate() {
    return getLineChartHeight() / getChartData().getDeltaValue();
  }

  @Override protected void drawChart(Canvas canvas) {
    canvas.drawColor(getChartColor());
    drawYAxis(canvas);
    drawXAxis(canvas);
    drawPath(canvas);
    drawPoint(canvas);
    drawTitle(canvas);
  }

  private void drawYAxis(Canvas canvas) {
    List<String> yAxis = getChartData().getYAxisLabels();
    if (yAxis.isEmpty()) {
      return;
    }

    int size = yAxis.size();
    yAxisHeight = getLineChartHeight() / (size - 1);
    // The start x and end x for y-Axis horizontal line
    float lineStartX = lineChartLeft - padding;
    float lineEndX = lineChartRight + padding;
    for (int i = 0; i < size; i++) {
      String label = yAxis.get(i);
      float labelWidth = yAxisLabelsPaint.measureText(label);
      float delta = yAxisHeight * i;
      float lineStartY = lineChartTop + delta;
      float labelStartY = lineStartY + (yAxisFontRect.height() * 0.5f);
      canvas.drawText(label, yAxisWidth - labelWidth, labelStartY, yAxisLabelsPaint);
      canvas.drawLine(lineStartX, lineStartY, lineEndX, lineStartY, yAxisLinePaint);
    }
  }

  private void drawXAxis(Canvas canvas) {
    List<String> xAxis = getChartData().getXAxisLabels();
    if (xAxis.isEmpty()) {
      return;
    }

    int size = xAxis.size();
    float xAxisWidth = getLineChartWidth() / (xAxis.size() - 1);
    // The start y and end y for x-Axis vertical line
    float lineStartY = lineChartTop - padding;
    float lineEndY = lineChartBottom + padding;
    for (int i = 0; i < size; i++) {
      String label = xAxis.get(i);
      float labelWidth = xAxisLabelsPaint.measureText(label);
      float delta = xAxisWidth * i;
      float lineStartX = lineChartLeft + delta;
      float labelStartX = lineStartX - (labelWidth * 0.5f);
      canvas.drawText(label, labelStartX, getChartBottom(), xAxisLabelsPaint);
      canvas.drawLine(lineStartX, lineStartY, lineStartX, lineEndY, xAxisLinePaint);
    }
  }

  private void drawPoint(Canvas canvas) {
    int size = getChartData().getDataListSize();
    float rate = getValueRate();
    float chartHeight = lineChartBottom;
    if (size == 1) {
      float value = getChartData().getValue(0);
      float y = chartHeight - (rate * value);
      canvas.drawCircle(lineChartLeft, y, pointRadius, pointPaint);
    } else if (size > 1) {
      float pointWidth = getLineChartWidth() / (size - 1);
      for (int i = 0; i <= size - 2; i++) {
        float value1 = getChartData().getValue(i);
        float value2 = getChartData().getValue(i + 1);
        float x1 = lineChartLeft + (pointWidth * i);
        float x2 = lineChartLeft + (pointWidth * (i + 1));
        float y1 = chartHeight - (rate * value1);
        float y2 = chartHeight - (rate * value2);
        canvas.drawLine(x1, y1, x2, y2, linePaint);
        canvas.drawCircle(x1, y1, pointRadius, pointPaint);
        canvas.drawCircle(x2, y2, pointRadius, pointPaint);
      }
    }
  }

  private void drawPath(Canvas canvas) {
    int size = getChartData().getDataListSize();
    if (size == 1) {
      return;
    }

    float rate = getValueRate();
    float chartHeight = lineChartBottom;
    float pointWidth = getLineChartWidth() / (size - 1);
    float endY = lineChartBottom;
    for (int i = 0; i <= size - 2; i++) {
      float value1 = getChartData().getValue(i);
      float value2 = getChartData().getValue(i + 1);
      float x1 = lineChartLeft + (pointWidth * i);
      float x2 = lineChartLeft + (pointWidth * (i + 1));
      float y1 = chartHeight - (rate * value1);
      float y2 = chartHeight - (rate * value2);
      setPath(x1, y1, x2, y2);
      endY = Math.min(endY, y1);
      endY = Math.min(endY, y2);
    }

    if (dataColors != null) {
      int colorLength = dataColors.length;
      if (colorLength > 1) {
        if (gradients == null) {
          float gradient = 1f / colorLength;
          gradients = new float[colorLength];
          for (int i = 0; i < colorLength; i++) {
            gradients[i] = gradient * (i + 1);
          }
        }

        LinearGradient linearGradient =
            new LinearGradient(lineChartLeft, lineChartBottom, lineChartLeft, endY, dataColors,
                gradients, Shader.TileMode.CLAMP);
        pathPaint.setShader(linearGradient);
      } else {
        pathPaint.setColor(dataColors[0]);
      }
    } else {
      pathPaint.setColor(Color.TRANSPARENT);
    }

    canvas.drawPath(path, pathPaint);
    path.reset();
  }

  private void setPath(float x1, float y1, float x2, float y2) {
    path.moveTo(x1, lineChartBottom);
    path.lineTo(x1, y1);
    path.lineTo(x2, y2);
    path.lineTo(x2, lineChartBottom);
  }

  private void drawTitle(Canvas canvas) {
    int titleWidth = titleFontRect.width();
    if (titleWidth > 0) {
      float offset = titleWidth > yAxisWidth * 2 ? yAxisWidth : (titleWidth / 2);
      canvas.drawText(getChartData().getTitle(), lineChartLeft - offset,
          getChartTop() + (titleFontRect.height() / 2), titlePaint);
    }
  }
}

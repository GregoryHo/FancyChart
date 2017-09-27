package com.ns.greg.fancy_chart.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.ns.greg.fancy_chart.renderer.BaseRenderer;

/**
 * @author Gregory
 * @since 2017/8/28
 */

public abstract class BaseChart<T extends BaseRenderer> extends View {

  private final T renderer;

  public BaseChart(Context context) {
    this(context, null);
  }

  public BaseChart(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public BaseChart(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    renderer = rendererImp();
  }

  protected abstract T rendererImp();

  public T getRenderer() {
    return renderer;
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    int defaultSize = 150;
    setMeasuredDimension(
        Math.max(getSuggestedMinimumWidth(), resolveSize(defaultSize, widthMeasureSpec)),
        Math.max(getSuggestedMinimumHeight(), resolveSize(defaultSize, heightMeasureSpec)));
  }

  @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    renderer.onLayout(left, top, right, bottom);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    renderer.onDraw(canvas);
  }
}

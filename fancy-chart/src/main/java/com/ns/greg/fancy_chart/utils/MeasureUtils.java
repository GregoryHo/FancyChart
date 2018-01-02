package com.ns.greg.fancy_chart.utils;

import android.graphics.Paint;
import android.graphics.Rect;

/**
 * @author Gregory
 * @since 2018/1/2
 */

public class MeasureUtils {

  public static Rect getTextBound(String string, Paint paint) {
    Rect rect = new Rect();
    paint.getTextBounds(string, 0, string.length(), rect);
    return rect;
  }
}

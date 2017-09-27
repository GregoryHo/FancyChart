package com.ns.greg.fancychart;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author Gregory
 * @since 2017/8/28
 */

public class Utils {

  /**
   * Returns the screen density
   * <p>
   * 120dpi = 0.75
   * 160dpi = 1 (default)
   * 240dpi = 1.5
   * 320dpi = 2
   * 400dpi = 2.5
   *
   * @param context application context
   * @return Device density
   */
  public static float getDensity(Context context) {
    DisplayMetrics metrics = context.getResources().getDisplayMetrics();
    return metrics.density;
  }

  /**
   * Returns the screen ScaledDensity
   *
   * @param context application context
   * @return Device scaled density
   */
  public static float getScaledDensity(Context context) {
    DisplayMetrics metrics = context.getResources().getDisplayMetrics();
    return metrics.scaledDensity;
  }

  /**
   * Coverts px to dp.
   *
   * @param px pixel
   * @param context application context
   * @return dp
   */
  public static int convertPixelToDp(float px, Context context) {
    return (int) (px / getDensity(context) + 0.5f);
  }

  /**
   * Coverts dp to px.
   *
   * @param dp dp
   * @param context application context
   * @return pixel
   */
  public static int convertDpToPixel(float dp, Context context) {
    return (int) (dp * getDensity(context) + 0.5f);
  }

  /**
   * Converts px to sp.
   *
   * @param px pixel
   * @param context application context
   * @return sp
   */
  public static int convertPixelToSp(float px, Context context) {
    return (int) (px / getScaledDensity(context) + 0.5f);
  }

  /**
   * Converts sp to px.
   *
   * @param dp sp
   * @param context application context
   * @return dp
   */
  public static int convertSpToPixel(float dp, Context context) {
    return (int) (dp * getScaledDensity(context) + 0.5d);
  }
}

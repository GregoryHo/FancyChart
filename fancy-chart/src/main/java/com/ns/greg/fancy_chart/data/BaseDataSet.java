package com.ns.greg.fancy_chart.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/8/28
 */

public abstract class BaseDataSet {

  private final String title;
  private final List<Float> dataList = new ArrayList<>();
  private final float[] minAndMax = new float[2];

  BaseDataSet(String title, List<Float> list) {
    this.title = title;
    if (list != null) {
      this.dataList.addAll(list);
      findDataMinAndMax();
    }
  }

  /**
   * Finds minimize and maximum value in data dataList
   */
  private void findDataMinAndMax() {
    float[] values = new float[] { Float.MAX_VALUE, Float.MIN_VALUE };
    int size = getDataListSize();
    if (size == 0 || size == 1) {
      return;
    }
    for (int i = 0; i < size; i++) {
      float value = getData(i);
      values[0] = value < values[0] ? value : values[0];
      values[1] = value > values[1] ? value : values[1];
    }
    minAndMax[0] = values[0];
    minAndMax[1] = values[1];
  }

  public void updateDataList(List<Float> list) {
    if (list == null || list.isEmpty()) {
      return;
    }

    synchronized (BaseDataSet.class) {
      dataList.clear();
      dataList.addAll(list);
    }
  }

  public int getDataListSize() {
    return dataList.size();
  }

  public float getData(int index) {
    return dataList.get(index);
  }

  public float getMinValue() {
    return minAndMax[0];
  }

  public float getMaxValue() {
    return minAndMax[1];
  }

  public float getDeltaValue() {
    return minAndMax[1] - minAndMax[0] + 1;
  }

  public String getTitle() {
    return title;
  }
}

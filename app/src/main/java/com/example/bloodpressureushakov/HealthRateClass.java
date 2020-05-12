package com.example.bloodpressureushakov;

import java.util.ArrayList;
import java.util.List;

public class HealthRateClass {
    List<int[]> list = new ArrayList<int[]>();

    public void addData(int weigth, int stepCount) {
        int[] data = new int[] {weigth, stepCount};
        list.add(data);
    }

}

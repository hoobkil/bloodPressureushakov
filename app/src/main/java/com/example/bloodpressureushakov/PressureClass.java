package com.example.bloodpressureushakov;

import java.util.Date;
import java.util.HashMap;

public class PressureClass {
    HashMap<Date, int[]> pressureData = new HashMap<>();
    public static void main(String[] args) {

    }

    public void addData(Date date, int highPressure, int lowPressure, int pulse, int tach){
        int[] arr = new int[4];
        arr[0] = highPressure;
        arr[1] = lowPressure;
        arr[2] = pulse;
        arr[3] = tach;
        pressureData.put(date, arr);
    }

}

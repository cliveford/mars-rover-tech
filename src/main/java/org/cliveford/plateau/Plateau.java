package org.cliveford.plateau;


public class Plateau {

    String plateauName;
    int xAxis;
    int yAxis;

    public Plateau(String name, int xAxisMax, int yAxisMax) {
        plateauName = name;
        xAxis = xAxisMax;
        yAxis = yAxisMax;

    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() { return yAxis; }

    public String getPlateauName() { return plateauName; }
}

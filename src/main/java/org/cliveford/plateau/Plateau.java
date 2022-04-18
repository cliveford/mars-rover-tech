package org.cliveford.plateau;


public class Plateau {

    private final String PLATEAUNAME;
    private final int XAXIS;
    private final int YAXIS;

    public Plateau(String name, int xAxisMax, int yAxisMax) {
        PLATEAUNAME = name;
        XAXIS = xAxisMax;
        YAXIS = yAxisMax;

    }

    public String getPlateauName() { return PLATEAUNAME; }

    public int getXAxis() {
        return XAXIS;
    }

    public int getYAxis() { return YAXIS; }

}

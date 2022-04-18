package org.cliveford.rover;

public class Rover {

    private final String ROVERNAME;
    private final String ROVERTYPE;
    private final int XCOORDINATE;
    private final int YCOORDINATE;
    private final String ROVERDIRECTION;

    public Rover(String name, String type, int xAxis, int yAxis, String direction) {

        ROVERNAME = name;
        ROVERTYPE = type;
        XCOORDINATE = xAxis;
        YCOORDINATE = yAxis;
        ROVERDIRECTION = direction;

    }


    public String getName() {
        return ROVERNAME;
    }

    public String getType() {
        return ROVERTYPE;
    }

    public int getXCoordinate() {
        return XCOORDINATE;
    }

    public int getYCoordinate() {
        return YCOORDINATE;
    }

    public String getDirection() {
        return ROVERDIRECTION;
    }


}

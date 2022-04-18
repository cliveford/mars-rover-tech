package org.cliveford.rover;

public class Rover {

    String roverName;
    String roverType;
    int xCoordinate;
    int yCoordinate;
    String roverDirection;

    public Rover(String name, String type, int xAxis, int yAxis, String direction) {

        roverName = name;
        roverType = type;
        xCoordinate = xAxis;
        yCoordinate = yAxis;
        roverDirection = direction;

    }


    public String getName() {
        return roverName;
    }

    public String getType() {
        return roverType;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public String getDirection() {
        return roverDirection;
    }


}

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

    public String moveRover(String inputMovement) {


        for (int iLetter = 0; iLetter < inputMovement.length(); iLetter++) {
            if (inputMovement.charAt(iLetter) == 'L') {
                if (getDirection() == "N") {
                    setDirection("W");
                } else if (getDirection() == "W") {
                    setDirection("S");
                } else if (getDirection() == "S") {
                    setDirection("E");
                } else if (getDirection() == "E") {
                    setDirection("N");
                }
            }
            if (inputMovement.charAt(iLetter) == 'R') {
                if (getDirection() == "N") {
                    setDirection("E");
                } else if (getDirection() == "W") {
                    setDirection("N");
                } else if (getDirection() == "S") {
                    setDirection("W");
                } else if (getDirection() == "E") {
                    setDirection("S");
                }
            }
            if (inputMovement.charAt(iLetter) == 'M') {
                if (getDirection() == "N") {
                    if (getYCoordinate() == 10) {
                        return "Hey! You have reached the edge!!!";
                    } else {
                        setYCoordinate(1);
                    }
                }
                if (getDirection() == "E") {
                    if (getXCoordinate() == 10) {
                        return "Hey! You have reached the edge!!!";
                    } else {
                        setXCoordinate(1);
                    }
                }
                if (getDirection() == "S") {
                    if (getYCoordinate() == 0) {
                        return "Hey! You have reached the edge!!!";
                    } else {
                        setYCoordinate(-1);
                    }
                }
                if (getDirection() == "W") {
                    if (getXCoordinate() == 0) {
                        return "Hey! You have reached the edge!!!";
                    } else {
                        setXCoordinate(-1);
                    }
                }
            }
        }
        String newLocation = getXCoordinate() + " " + getYCoordinate() + " " + getDirection();
        return newLocation;

    }

    private void setXCoordinate(int value) {
        xCoordinate += value;
        System.out.println("x : " + xCoordinate);
    }

    private void setYCoordinate(int value) {
        yCoordinate += value;
        System.out.println("y : " + yCoordinate);
    }

    private void setDirection(String direction) {
        roverDirection = direction;
        System.out.println("direction : " + roverDirection);
    }
}

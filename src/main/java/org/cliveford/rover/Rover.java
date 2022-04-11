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

    private void setXCoordinate(int value) {
        xCoordinate += value;
    }

    private void setYCoordinate(int value) {
        yCoordinate += value;
    }

    private void setDirection(String direction) {
        roverDirection = direction;
    }

    public String moveRover(String inputMovement) {

        for (int iLetter = 0; iLetter < inputMovement.length(); iLetter++) {
            if (inputMovement.charAt(iLetter) == 'L') {
                switch (getDirection()) {
                    case "N" -> setDirection("W");
                    case "W" -> setDirection("S");
                    case "S" -> setDirection("E");
                    case "E" -> setDirection("N");
                }
            }
            if (inputMovement.charAt(iLetter) == 'R') {
                switch (getDirection()) {
                    case "N" -> setDirection("E");
                    case "W" -> setDirection("N");
                    case "S" -> setDirection("W");
                    case "E" -> setDirection("S");
                }
            }
            if (inputMovement.charAt(iLetter) == 'M') {
                String message = "Hey! You have reached the edge!!!";
                if (getDirection().equals("N")) {
                    if (getYCoordinate() == 10) return message;
                    else setYCoordinate(1);
                }
                if (getDirection().equals("E")) {
                    if (getXCoordinate() == 10) return message;
                    else setXCoordinate(1);
                }
                if (getDirection().equals("S")) {
                    if (getYCoordinate() == 0) return message;
                    else setYCoordinate(-1);
                }
                if (getDirection().equals("W")) {
                    if (getXCoordinate() == 0) return message;
                    else setXCoordinate(-1);
                }
            }
        }
        return getXCoordinate() + " " + getYCoordinate() + " " + getDirection();

    }

}

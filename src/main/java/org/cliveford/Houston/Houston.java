package org.cliveford.Houston;

import org.cliveford.plateau.Plateau;
import org.cliveford.rover.Rover;

import java.util.HashMap;
import java.util.Map;

public class Houston {

    static Map<String, Map<String, Integer>> plateaus = new HashMap<>();
    static Map<String, Map<String, Object>> rovers = new HashMap<>();


    private static Map<String, Integer> getPlateauMap(String name) {
        return plateaus.get(name);
    }

    private static Map<String, Object> getRoverMap(String name) {
        return rovers.get(name);
    }

    public static void addPlateauToPlateausMap(Plateau plateau) {
        String xAxisBoundary = "xAxisBoundary";
        String yAxisBoundary = "yAxisBoundary";
        Map<String, Integer> map = new HashMap<>();
        map.put(xAxisBoundary, plateau.getXAxis());
        map.put(yAxisBoundary, plateau.getYAxis());
        plateaus.put(plateau.getPlateauName(), map);

    }

    public static void addRoverToRoversMap(Rover rover) {
        String type = "type";
        String xAxis = "xAxis";
        String yAxis = "yAxis";
        String direction = "direction";
        Map<String, Object> map = new HashMap<>();
        map.put(type, rover.getType());
        map.put(xAxis, rover.getXCoordinate());
        map.put(yAxis, rover.getYCoordinate());
        map.put(direction, rover.getDirection());
        rovers.put(rover.getName(), map);
    }

    public static boolean collisionDetection(String axis, String currentRover) {
        Map<String, Object> roverMap = getRoverMap(currentRover);

        int otherAxisValue = 0;
        int axisValue = 0;
        // declare & initialise other axis to enable exact location tracking
        String otherAxis;
        if (axis.equals("xAxis")) otherAxis = "yAxis";
        else otherAxis = "xAxis";

        // loop through all rover positions to check for potential collisions
        for (var otherRovers : rovers.entrySet()) {
            // exclude checking rover position for current rover
            if (!otherRovers.getKey().equals(currentRover)) {
                // need to check where other rovers are on plateau
                // loop through other rover keys
                for (var otherRover : otherRovers.getValue().entrySet()) {
                    // capture values for other rover positions
                    if (otherRover.getKey().equals(otherAxis)) otherAxisValue = (int) otherRover.getValue();
                    if (otherRover.getKey().equals(axis)) axisValue = (int) otherRover.getValue();
                }

                if ("N".equals(roverMap.get("direction")) || "E".equals(roverMap.get("direction"))) {
                    if ((int) roverMap.get(axis) + 1 == axisValue && roverMap.get(otherAxis).equals(otherAxisValue)) {
                        return true;
                    }
                }
                if ("S".equals(roverMap.get("direction")) || "W".equals(roverMap.get("direction"))) {
                    if ((int) roverMap.get(axis) - 1 == axisValue && roverMap.get(otherAxis).equals(otherAxisValue)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static String updateRoverPosition(String currentPlateau, String currentRover, String inputMovement) {

        Map<String, Object> roverMap = getRoverMap(currentRover);
        Map<String, Integer> plateauMap = getPlateauMap(currentPlateau);
        int incrementPosition;
        int decrementPosition;

        for (int iLetter = 0; iLetter < inputMovement.length(); iLetter++) {
            if (inputMovement.charAt(iLetter) == 'L') {
                Object direction = roverMap.get("direction");
                if ("N".equals(direction)) roverMap.replace("direction", "W");
                else if ("W".equals(direction)) roverMap.replace("direction", "S");
                else if ("S".equals(direction)) roverMap.replace("direction", "E");
                else if ("E".equals(direction)) roverMap.replace("direction", "N");
            }
            if (inputMovement.charAt(iLetter) == 'R') {
                Object direction = roverMap.get("direction");
                if ("N".equals(direction)) roverMap.replace("direction", "E");
                else if ("W".equals(direction)) roverMap.replace("direction", "N");
                else if ("S".equals(direction)) roverMap.replace("direction", "W");
                else if ("E".equals(direction)) roverMap.replace("direction", "S");
            }
            if (inputMovement.charAt(iLetter) == 'M') {
                String message = "- Hey! You have reached the edge!!!";
                String collisionWarning = "Collision Warning!! - last move aborted!";
                if (roverMap.get("direction").equals("N")) {
                    if (roverMap.get("yAxis") == plateauMap.get("yAxisBoundary")) {
                        return roverMap.get("xAxis") + " " + roverMap.get("yAxis") + " " + roverMap.get("direction") + " " + message;
                    }
                    if (collisionDetection("yAxis", currentRover)) {
                        return roverMap.get("xAxis") + " " + roverMap.get("yAxis") + " " + roverMap.get("direction") + " " + collisionWarning;
                    }
                    incrementPosition = (int) roverMap.get("yAxis");
                    incrementPosition++;
                    roverMap.replace("yAxis", incrementPosition);
                }
                if (roverMap.get("direction").equals("E")) {
                    if (roverMap.get("xAxis") == plateauMap.get("xAxisBoundary")) {
                        return roverMap.get("xAxis") + " " + roverMap.get("yAxis") + " " + roverMap.get("direction") + " " + message;
                    }
                    if (collisionDetection("xAxis", currentRover)) {
                        return roverMap.get("xAxis") + " " + roverMap.get("yAxis") + " " + roverMap.get("direction") + " " + collisionWarning;
                    }
                    incrementPosition = (int) roverMap.get("xAxis");
                    incrementPosition++;
                    roverMap.replace("xAxis", incrementPosition);

                }
                if (roverMap.get("direction").equals("S")) {
                    if (roverMap.get("yAxis").equals(0)) {
                        return roverMap.get("xAxis") + " " + roverMap.get("yAxis") + " " + roverMap.get("direction") + " " + message;
                    }
                    if (collisionDetection("yAxis", currentRover)) {
                        return roverMap.get("xAxis") + " " + roverMap.get("yAxis") + " " + roverMap.get("direction") + " " + collisionWarning;
                    }
                    decrementPosition = (int) roverMap.get("yAxis");
                    decrementPosition--;
                    roverMap.replace("yAxis", decrementPosition);

                }
                if (roverMap.get("direction").equals("W")) {
                    if (roverMap.get("xAxis").equals(0)) {
                        return roverMap.get("xAxis") + " " + roverMap.get("yAxis") + " " + roverMap.get("direction") + " " + message;
                    }
                    if (collisionDetection("xAxis", currentRover)) {
                        return roverMap.get("xAxis") + " " + roverMap.get("yAxis") + " " + roverMap.get("direction") + " " + collisionWarning;
                    }
                    decrementPosition = (int) roverMap.get("xAxis");
                    decrementPosition--;
                    roverMap.replace("xAxis", decrementPosition);
                }
            }
        }
        return roverMap.get("xAxis") + " " + roverMap.get("yAxis") + " " + roverMap.get("direction");

    }

}

package org.cliveford.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void checkRoverInitialisesInstanceWithCorrectParameters() {
        Rover rover = new Rover("woof", "hover", 1, 2, "N");
        String roverNameExpected = "woof";
        String roverTypeExpected = "hover";
        int xDropPointExpected = 1;
        int yDropPointExpected = 2;
        String facingExpected = "N";
        String name = rover.getName();
        String type = rover.getType();
        int xCoordinate = rover.getXCoordinate();
        int yCoordinate = rover.getYCoordinate();
        String direction = rover.getDirection();
        assertEquals(roverNameExpected, name);
        assertEquals(roverTypeExpected, type);
        assertEquals(xDropPointExpected, xCoordinate);
        assertEquals(yDropPointExpected, yCoordinate);
        assertEquals(facingExpected, direction);
    }

    @Test
    void checkInputMovesRoverAndReturnsNewCoordinates() {
        Rover rover = new Rover("woof", "hover", 1, 2, "N");
        String inputMovement = "LMLMLMLMM";
        String expectedCoordinates = "1 3 N";
        String newCoordinates = rover.moveRover(inputMovement);
        assertEquals(expectedCoordinates, newCoordinates);
    }

    @Test
    void checkInputMovesRoverAndReturnsCorrectCoordinates() {
        Rover rover = new Rover("fido", "wheelie", 3, 3, "E");
        String inputMovement = "MMRMMRMRRM";
        String expectedCoordinates = "5 1 E";
        String newCoordinates = rover.moveRover(inputMovement);
        assertEquals(expectedCoordinates, newCoordinates);
    }

    @Test
    void checkRoverCannotMoveBeyondBoundary() {
        Rover rover = new Rover("fido", "wheelie", 0, 0, "N");
        String inputMovement = "MMMMMMMMMMMMMMM";
        String expectedMessage = "Hey! You have reached the edge!!!";
        String actualMessage = rover.moveRover(inputMovement);
        assertEquals(expectedMessage, actualMessage);
    }
}

package org.cliveford.Houston;

import org.cliveford.plateau.Plateau;
import org.cliveford.rover.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoustonTest {

    Rover rover;
    Rover secondRover;
    Plateau plateau;

    @BeforeEach
    void setup() {
        rover = new Rover("woof", "hover", 1, 2, "N");
        secondRover = new Rover("fido", "wheelie", 3, 3, "E");
        plateau = new Plateau("chilly", 10, 10);
        Houston.addPlateauToPlateausMap(plateau);
        Houston.addRoverToRoversMap(rover);
        Houston.addRoverToRoversMap(secondRover);
        }


    @Test
    @DisplayName("check user input moves rover and returns correct coordinates")
    void checkInputMovesRoverAndReturnsCorrectNewCoordinates() {
        String inputMovement = "LMLMLMLMM";
        String expectedCoordinates = "1 3 N";
        String newCoordinates = Houston.updateRoverPosition("chilly", "woof", inputMovement);
        assertEquals(expectedCoordinates, newCoordinates);
    }

    @Test
    @DisplayName("check different user input moves rover and returns correct coordinates")
    void checkInputMovesRoverAndReturnsCorrectCoordinates() {
        String inputMovement = "MMRMMRMRRM";
        String expectedCoordinates = "5 1 E";
        String newCoordinates = Houston.updateRoverPosition("chilly", "fido", inputMovement);
        assertEquals(expectedCoordinates, newCoordinates);
    }

    @Test
    @DisplayName("check rover cannot move past x axis outer boundary")
    void checkRoverCantPassXAxisOuterBoundary() {
        String inputMovement = "RMMMMMMMMMMMMMM";
        String expectedMessage = "10 2 E - Hey! You have reached the edge!!!";
        String actualMessage = Houston.updateRoverPosition("chilly", "woof", inputMovement);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("check rover cannot move past x axis inner boundary")
    void checkRoverCantPassXAxisInnerBoundary() {
        String inputMovement = "LMMMMMMMMMMMMMM";
        String expectedMessage = "0 2 W - Hey! You have reached the edge!!!";
        String actualMessage = Houston.updateRoverPosition("chilly", "woof", inputMovement);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("check rover cannot move past y axis outer boundary")
    void checkRoverCantPassYAxisOuterBoundary() {
        String inputMovement = "MMMMMMMMMMMMMMMMM";
        String expectedMessage = "1 10 N - Hey! You have reached the edge!!!";
        String actualMessage = Houston.updateRoverPosition("chilly", "woof", inputMovement);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("check rover cannot move past y axis inner boundary")
    void checkRoverCantPassYAxisInnerBoundary() {
        String inputMovement = "LLMMMMMMMMMMMMMMMMM";
        String expectedMessage = "1 0 S - Hey! You have reached the edge!!!";
        String actualMessage = Houston.updateRoverPosition("chilly", "woof", inputMovement);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("check collision detection works when rover is moving north")
    void checkIfCollisionDetectedWhenRoverMovesNorth() {
        String inputMovement = "RMMLM";
        String expectedMessage = "3 2 N Collision Warning!! - last move aborted!";
        String actualMessage = Houston.updateRoverPosition("chilly", "woof", inputMovement);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("check collision detection works when rover is moving east")
    void checkIfCollisionDetectedWhenRoverMovesEast() {
        String inputMovement = "MRMMMMM";
        String expectedMessage = "2 3 E Collision Warning!! - last move aborted!";
        String actualMessage = Houston.updateRoverPosition("chilly", "woof", inputMovement);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("check collision detection works when rover is moving south")
    void checkIfCollisionDetectedWhenRoverMovesSouth() {
        String inputMovement = "LLMMLM";
        String expectedMessage = "1 3 S Collision Warning!! - last move aborted!";
        String actualMessage = Houston.updateRoverPosition("chilly", "fido", inputMovement);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("check collision detection works when rover is moving west")
    void checkIfCollisionDetectedWhenRoverMovesWest() {
        String inputMovement = "RMRMMM";
        String expectedMessage = "2 2 W Collision Warning!! - last move aborted!";
        String actualMessage = Houston.updateRoverPosition("chilly", "fido", inputMovement);
        assertEquals(expectedMessage, actualMessage);
    }
}

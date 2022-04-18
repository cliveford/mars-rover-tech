package org.cliveford;


import org.cliveford.Houston.Houston;
import org.cliveford.plateau.Plateau;
import org.cliveford.rover.Rover;

import java.util.Scanner;



public class App {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean plateauCreated = false;
        boolean roverCreated = false;
        String currentPlateau = "";
        String currentRover;
        while (!exit) {
            if (!plateauCreated) {
                System.out.println("Welcome to the Melody Mars Mission");
                System.out.println("To create a Plateau enter 1 ");
            } else {
                if (roverCreated) {
                    System.out.println("To create another Rover enter 2 ");
                    System.out.println("To defend your Rover from incoming comets enter 3 ");
                    System.out.println("To move your Rover enter 4 ");
                } else {
                    System.out.println("To create a Rover enter 2 ");
                }
            }
            System.out.println("To exit programme enter exit ");
            System.out.print("Enter choice : ");
            String choice = scanner.next();

            switch (choice) {
                case "1" -> {
                    String name;
                    int xCoord;
                    int yCoord;
                    System.out.print("Enter Plateau name: ");
                    name = scanner.next();
                    name += scanner.nextLine();
                    System.out.print("Enter maximum X coordinate: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println(ANSI_RED_BACKGROUND + "Houston we have a problem - please enter an Integer" + ANSI_RESET);
                        System.out.print("Enter maximum X coordinate: ");
                        scanner.next();
                        if (scanner.hasNextInt()) {
                            break;
                        }
                    }
                    xCoord = scanner.nextInt();
                    System.out.print("Enter maximum Y coordinate: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println(ANSI_RED_BACKGROUND + "Houston we have a problem - please enter an Integer" + ANSI_RESET);
                        System.out.print("Enter maximum Y coordinate: ");
                        scanner.next();
                        if (scanner.hasNextInt()) {
                            break;
                        }
                    }
                    yCoord = scanner.nextInt();
                    Plateau plateau = new Plateau(name, xCoord, yCoord);
                    plateauCreated = true;
                    Houston.addPlateauToPlateausMap(plateau);
                    currentPlateau = name;
                    System.out.println("Your Plateau has been created");
                    System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + "Plateau " + currentPlateau + " size = " + plateau.getXAxis() + " x " + plateau.getYAxis() + ANSI_RESET);

                }
                case "2" -> {
                    if (!plateauCreated) {
                        System.out.println(ANSI_RED_BACKGROUND + "Houston we have a problem - create Plateau first" + ANSI_RESET);
                        break;
                    }
                    String name;
                    String type;
                    int xCoord;
                    int yCoord;
                    String direction;
                    System.out.print("Enter Rover name: ");
                    name = scanner.next();
                    name += scanner.nextLine();
                    System.out.print("Enter Rover type - wheelie or hover: ");
                    type = scanner.next();
                    type += scanner.nextLine();
                    System.out.println("Enter Rover landing points and direction");
                    System.out.print("Enter X Coordinate : ");
                    while (!scanner.hasNextInt()) {
                        System.out.println(ANSI_RED_BACKGROUND + "Houston we have a problem - please enter an Integer" + ANSI_RESET);
                        System.out.print("Enter X coordinate: ");
                        scanner.next();
                        if (scanner.hasNextInt()) {
                            break;
                        }
                    }
                    xCoord = scanner.nextInt();
                    System.out.print("Enter Y Coordinate : ");
                    while (!scanner.hasNextInt()) {
                        System.out.println(ANSI_RED_BACKGROUND + "Houston we have a problem - please enter an Integer" + ANSI_RESET);
                        System.out.print("Enter Y coordinate: ");
                        scanner.next();
                        if (scanner.hasNextInt()) {
                            break;
                        }
                    }
                    yCoord = scanner.nextInt();
                    System.out.print("Enter Rover direction - must be N E S or W: ");
                    direction = scanner.next();
                    direction += scanner.nextLine();
                    Rover rover = new Rover(name, type, xCoord, yCoord, direction);
                    roverCreated = true;
                    Houston.addRoverToRoversMap(rover);
                    System.out.println("Your Rover has landed safely on Mars!!");
                    System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + "Rover status: " + rover.getName() + "'s current location: " + rover.getXCoordinate() + " " + rover.getYCoordinate() + " " + rover.getDirection() + ANSI_RESET);

                }
                case "3" -> {
                    try {
                        Runtime.getRuntime().exec("explorer https://cliveford.eu.pythonanywhere.com/rock/");
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                case "4" -> {
                    if (!roverCreated) {
                        System.out.println(ANSI_RED_BACKGROUND + "Houston we have a problem - create Rover first" + ANSI_RESET);
                        break;
                    }
                    String instruction;
                    String newLocation;
                    String name;
                    System.out.print("Enter the Rover's name that you wish to move: ");
                    name = scanner.next();
                    name += scanner.nextLine();
                    currentRover = name;
                    System.out.println("Instructions to move your rover - ");
                    System.out.println("L = rotate left 90 degrees, R = rotate right 90 degrees, M = move forward 1 grid point");
                    System.out.println("Example instruction: LMMMRMRMLMM");
                    System.out.print("Enter instruction: ");
                    instruction = scanner.next();
                    instruction += scanner.nextLine();
                    newLocation =  Houston.updateRoverPosition(currentPlateau, currentRover, instruction);
                    System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +currentRover + "'s new location on " + currentPlateau + " = " +  newLocation + ANSI_RESET);
                }
                case "exit" -> {
                    System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + "I hope you enjoyed your Mars experience - Next time try Uranus - Goodbye!" + ANSI_RESET);
                    exit = true;
                }
                default -> System.out.println(ANSI_RED_BACKGROUND + "What happens here then ?????" + ANSI_RESET);
            }
        }
        scanner.close();


    }

}

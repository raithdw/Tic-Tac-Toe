package tictactoe;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in); // static scanner to use in this class
    public static void main(String[] args) {
        String whiteSpace = " " + " " + " " + " "+ " "+ " "+ " "+ " "+ " "; // declaring 9 whitespace String to fill the array with
        String[] arrWhitespace = whiteSpace.split(""); // splitting the String into 1d array
        String[][] arrayGameGrid = new String[3][5]; // creating 2d array form 1d array of whitespaces
        int k = 0;
        for (int i = 0; i < arrayGameGrid.length; i++) {
            for (int j = 0; j < arrayGameGrid[0].length; j++) {
                if (j == 0 || j == 4) {
                    arrayGameGrid[i][j] = "|";
                } else {
                    arrayGameGrid[i][j] = arrWhitespace[k];
                    k++;
                }
            }
        }
        int countX = 0;
        int countO = 0;
        printGameGrid(arrayGameGrid); // printing blank game grid
        while(true) {
            for (String[] strings : arrayGameGrid) {
                for (int j = 0; j < arrayGameGrid[0].length; j++) {
                    if ("X".equals(strings[j])) {
                        countX++;
                    } else if ("O".equals(strings[j])) {
                        countO++;
                    }
                }
            }
            coordinatesForX(arrayGameGrid); // entering coordinates for player X
            if (("X".equals(arrayGameGrid[0][1]) && "X".equals(arrayGameGrid[0][2]) && "X".equals(arrayGameGrid[0][3])) ||
                    ("X".equals(arrayGameGrid[0][1]) && "X".equals(arrayGameGrid[1][1]) && "X".equals(arrayGameGrid[2][1])) ||
                    ("X".equals(arrayGameGrid[0][1]) && "X".equals(arrayGameGrid[1][2]) && "X".equals(arrayGameGrid[2][3])) ||
                    ("X".equals(arrayGameGrid[0][2]) && "X".equals(arrayGameGrid[1][2]) && "X".equals(arrayGameGrid[2][2])) ||
                    ("X".equals(arrayGameGrid[0][3]) && "X".equals(arrayGameGrid[1][3]) && "X".equals(arrayGameGrid[2][3])) ||
                    ("X".equals(arrayGameGrid[1][1]) && "X".equals(arrayGameGrid[1][2]) && "X".equals(arrayGameGrid[1][3])) ||
                    ("X".equals(arrayGameGrid[2][1]) && "X".equals(arrayGameGrid[2][2]) && "X".equals(arrayGameGrid[2][3])) ||
                    ("X".equals(arrayGameGrid[2][1]) && "X".equals(arrayGameGrid[1][2]) && "X".equals(arrayGameGrid[0][3]))) {
                System.out.println("X wins");
                break;
            }
            if (countO + countX == 20) {
                System.out.println("Draw");
                break;
            }
            coordinatesForO(arrayGameGrid); // entering coordinates for player O
            if (("O".equals(arrayGameGrid[0][1]) && "O".equals(arrayGameGrid[0][2]) && "O".equals(arrayGameGrid[0][3])) ||
                    ("O".equals(arrayGameGrid[0][1]) && "O".equals(arrayGameGrid[1][1]) && "O".equals(arrayGameGrid[2][1])) ||
                    ("O".equals(arrayGameGrid[0][1]) && "O".equals(arrayGameGrid[1][2]) && "O".equals(arrayGameGrid[2][3])) ||
                    ("O".equals(arrayGameGrid[0][2]) && "O".equals(arrayGameGrid[1][2]) && "O".equals(arrayGameGrid[2][2])) ||
                    ("O".equals(arrayGameGrid[0][3]) && "O".equals(arrayGameGrid[1][3]) && "O".equals(arrayGameGrid[2][3])) ||
                    ("O".equals(arrayGameGrid[1][1]) && "O".equals(arrayGameGrid[1][2]) && "O".equals(arrayGameGrid[1][3])) ||
                    ("O".equals(arrayGameGrid[2][1]) && "O".equals(arrayGameGrid[2][2]) && "O".equals(arrayGameGrid[2][3])) ||
                    ("O".equals(arrayGameGrid[2][1]) && "O".equals(arrayGameGrid[1][2]) && "O".equals(arrayGameGrid[0][3]))) {
                System.out.println("O wins");
                break;
            }

        }
    }

    public static void printGameGrid (String[][] gameGrid) {
        System.out.println("---------");
        for (String[] strings : gameGrid) {
            for (int j = 0; j < gameGrid[0].length; j++) {
                if (j != gameGrid[0].length - 1) {
                    System.out.print(strings[j] + " ");
                } else {
                    System.out.print(strings[j]);
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public static void coordinatesForX(String[][] gameGrid) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            int line;
            int column;
            String[] inputCoordinates = input.nextLine().split(" ");
            String sLine = inputCoordinates[0];
            String sColumn = inputCoordinates[1];
            if (sLine.matches("[0-9]+") && sColumn.matches("[0-9]+")) {
                line = Integer.parseInt(sLine);
                column = Integer.parseInt(sColumn);
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (line < 1 || line > 3 || column < 1 || column > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (" ".equals(gameGrid[line - 1][column])) {
                gameGrid[line - 1][column] = "X";
                printGameGrid(gameGrid);
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    public static void coordinatesForO(String[][] gameGrid) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            int line;
            int column;
            String[] inputCoordinates = input.nextLine().split(" ");
            String sLine = inputCoordinates[0];
            String sColumn = inputCoordinates[1];
            if (sLine.matches("[0-9]+") && sColumn.matches("[0-9]+")) {
                line = Integer.parseInt(sLine);
                column = Integer.parseInt(sColumn);
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (line < 1 || line > 3 || column < 1 || column > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (" ".equals(gameGrid[line - 1][column])) {
                gameGrid[line - 1][column] = "O";
                printGameGrid(gameGrid);
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }
}


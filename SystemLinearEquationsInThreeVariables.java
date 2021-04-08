import java.util.Scanner;
import java.util.Arrays;

public class SystemLinearEquationsInThreeVariables {
    int[][] systemOfEquations;

    //try running the program and seeing how it works
    //
    //note that at the end 2 arrays are printed, those were for my previous testing purposes

    //gets user's input and accordingly updates systemOfEquations
    private void UserInput() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\n ----New Problem----\n");
        int amountOfEquations = 0;
        //asking for the number of equations
        while (amountOfEquations <= 0) {
            System.out.print("How many linear equations are in your system of equations? ");
            amountOfEquations = userInput.nextInt();
            if (amountOfEquations <= 0) {
                System.out.println("That is not a viable input.\n");
            }
        }
        systemOfEquations = new int[amountOfEquations][4];
        System.out.println("There will be " + amountOfEquations + " equations in your system of linear equations.\n");
        //ask for the number of variables
        for (int i = 0; i < amountOfEquations; i++) {
            int numVariables = 0;
            System.out.println("Equation " + (i + 1));
            while (numVariables != 1 && numVariables != 2 && numVariables != 3) {
                System.out.println("How many variables do you want for this equation? Note, there is a limit of at least one variable and at most 3 variables. ");
                numVariables = userInput.nextInt();
                if (numVariables != 1 && numVariables != 2 && numVariables != 3) {
                    System.out.println("That is not a valid input.\n");
                } else {
                    System.out.println("You will have " + numVariables + " variables in this equation.");
                }
            }
            //asking what the variables will be
            switch (numVariables) {
                case 1:
                    System.out.print("Please input the two coefficients of this linear equation.\n ");
                    break;
                case 2:
                    System.out.print("Please input the three coefficients of this linear equation.\n ");
                    break;
                case 3:
                    System.out.print("Please input the four coefficients of this linear equation.\n ");
                    break;
            }
            for (int x = 0; x < numVariables + 1; x++) {
                systemOfEquations[i][x] = userInput.nextInt();
            }
        }
    }

    //driver function
    private void Solve() {
        UserInput();
        System.out.println(Arrays.toString(systemOfEquations[0]) + " " + Arrays.toString(systemOfEquations[1]));
    }

    public static void main(String[] args) {
        SystemLinearEquationsInThreeVariables problem1 = new SystemLinearEquationsInThreeVariables();
        problem1.Solve();
    }
}
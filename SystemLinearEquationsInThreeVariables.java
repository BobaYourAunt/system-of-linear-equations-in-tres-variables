
import java.util.Scanner;
import java.util.Arrays;

/*
equations are represented as int[] of length 4

expressions are represented as int[] of length 4

systems of equations are represented as int[][]
 */

public class SystemLinearEquationsInThreeVariables {
    double[][] systemOfEquations;

    //gets an expression and plugs it into the system
    private void PlugInValue(int[] inputting, int equationNum, String variable) {
        //converting input
        int varIndex;
        switch (variable) {
            case "x":
                varIndex = 0;
                break;
            case "y":
                varIndex = 1;
                break;
            case "z":
                varIndex = 2;
                break;
            default:
                varIndex = 100;
        }
        //coefficient to multiply to plugged in expression
        double coefficientMultiply = systemOfEquations[equationNum][varIndex];
        for (int i = 0; i < inputting.length; i++) {
            //when isolating one variable in the equation, all the values in the expression are divided by the isolated variable's coefficient
            inputting[i] /= inputting[varIndex];
            //when isolating, the constant is moved to one side through subtraction and a variable is isolated to one side also through subtraction
            //because of this, only all the variables need to be divided -1, while the constant keeps its original sign
            if (i != 4){
                inputting[i] *= -coefficientMultiply;
            }
            //the equation is changed by the plugged in expression
            systemOfEquations[equationNum][i] += inputting[i];
        }
        //plugging in an expression also removes the appearance of the variable the expression was plugged into
        systemOfEquations[equationNum][varIndex] = 0;
    }

    // gets user's input
    // then accordingly updates systemOfEquations
    private void UserInput() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\n ----New Problem----\n");
        int amountOfEquations = 0;
        // asking for the number of equations
        while (amountOfEquations <= 1) {
            System.out.print("How many linear equations are in your system of equations? ");
            amountOfEquations = userInput.nextInt();
            if (amountOfEquations <= 1) {
                System.out.println("That is not a viable input. Specifically, the program cannot solve it or it's a ridiculous number.\n");
            }
        }
        systemOfEquations = new double[amountOfEquations][4];
        System.out.println("There will be " + amountOfEquations + " equations in your system of linear equations.\n");
        // asking what the coefficients are (this is based on the amount of equations) UPDATED UPDATED
        for (int i = 0; i < amountOfEquations; i++) {
            System.out.println("Equation " + (i + 1));
            int inputPrintingAmount;
            if (amountOfEquations == 2){
                inputPrintingAmount = 3;
                System.out.println("Now input " + inputPrintingAmount + " numbers. These will be the coefficients for this equation: ()x + ()y = () ");
            }
            else{
                inputPrintingAmount = 4;
                System.out.println("Now input " + inputPrintingAmount + " numbers. These will be the coefficients for this equation: ()x + ()y + ()z = () ");
            }
            for (int x = 0; x < 4; x++) {
                if (amountOfEquations == 2 && x == 2){
                    systemOfEquations[i][2] = 0;
                }
                else{
                    systemOfEquations[i][x] = userInput.nextDouble();
                }
            }
        }
        /*
        ask for the number of variables
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
        */
    }

    // driver function
    private void Solve() {
        UserInput();
        for (int i = 0; i < systemOfEquations.length; i++){
            System.out.print(Arrays.toString(systemOfEquations[i]));
        }
    }

    public static void main(String[] args) {
        SystemLinearEquationsInThreeVariables problem1 = new SystemLinearEquationsInThreeVariables();
        problem1.Solve();
    }
}


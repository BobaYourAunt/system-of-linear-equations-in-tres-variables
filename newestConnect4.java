import java.util.Arrays;
import java.util.Scanner;

//LANCEEEEEEEEEEEEEEEEEEEEE LANCEEEEEEEEEEEEEEEEEEEEEEEEE LOOOOOOOOOOOK HEREEEEEEEEEEE
//left to do: fix play again function (down below) and test out the class

//fun for the whole familia
public class Main {
    int[][] board;
    int playerNum;
    int numberStraightP;
    int numberPiecesAdded;
    String winner;

    Main() {
        board = new int[6][7];
        playerNum = 1;
        numberStraightP = 1;
        numberPiecesAdded = 0;
        winner = "n/a";
    }

    /*
    PARAMETERS:
    none
    FUNCTIONALITY:
    prints the board
    RETURNS:
    void
    */
    private void printBoard() {
        System.out.println("\nBOARD:\n_____________________");
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("---------------------\n");
    }

    /*
    PARAMETERS:
    player number (1 or 2)
    FUNCTIONALITY:
    based on a certain player's specific input, adds a piece to the board or rejects them
    RETURNS:
    void
    */
    private void playerInput() {
        Scanner playerInput = new Scanner(System.in);
        System.out.println("PLAYER " + playerNum);
        System.out.println("Please input a location to add your piece. This ranges from 1 to 7. ");
        int playersLocation = playerInput.nextInt() - 1;
        while (!(addPiece(playersLocation))) {
            System.out.println("That is not a valid location.");
            System.out.println("Please input a location to add your piece. This ranges from 1 to 7. ");
            playersLocation = playerInput.nextInt() - 1;
        }
        this.printBoard();
        System.out.println("Piece successfully added!");
    }

    /*
    PARAMETERS:
    location (0 through 6), player number (1 or 2)
    FUNCTIONALITY:
    adds the piece at the next available open spot at a location
    RETURNS:
    boolean depending on success of operation
     */
    private boolean addPiece(int location) {
        //reference java short circuiting :)
        if (location < 7 && board[0][location] == 0) {
            for (int i = 0; i < 6; i++) {
                if (board[i][location] != 0) {
                    board[i - 1][location] = playerNum;
                    numberPiecesAdded++;
                    this.winnerCheck(i - 1, location);
                    return true;
                } else if (i == 5) {
                    board[i][location] = playerNum;
                    numberPiecesAdded++;
                    this.winnerCheck(i, location);
                    return true;
                }
            }
        }
        return false;
    }

    /*
    PARAMETERS:
    checkY (0 through 5, higher numbers mean lower on board), checkX (0 through 7)
    FUNCTIONALITY:
    checks the pieces next to a defined piece on the board (diagonally, vertically, and horizontally), if there is a connect 4 the winner field is set to the player number
    RETURNS:
    void
     */
    private void winnerCheck(int checkY, int checkX) {
        // northwest/southeast check
        for (int i = 0; i < 2; i++) {
            for (int x = 1; x < 4; x++) {
                //northwest
                if (checkY - x > -1 && checkX - x > -1 && i == 0 && playerNum == board[checkY - x][checkX - x]) {
                    numberStraightP++;
                } else if(playerNum != board[checkY - x][checkX - x]){
                  numberStraightP = -10;
                }
                
                //southeast
                if (checkY + x < 6 && checkX + x < 7 && i == 1 && playerNum == board[checkY + x][checkX + x]) {
                    numberStraightP++;
                } else if(playerNum != board[checkY + x][checkX + x]){
                  numberStraightP = -10;
                }
            }
        }
        //System.out.println("nw/se works"); // debug
        //System.out.println(numberStraightP); // debug
        if (numberStraightP < 4) {
            numberStraightP = 1;
        } else {
            winner = Integer.toString(playerNum);
        }
        // northeast/southwest check
        for (int i = 0; i < 2; i++) {
            for (int x = 1; x < 4; x++) {
                //northeast
                if (checkY - x > -1 && checkX + x < 7 && i == 0 && playerNum == board[checkY - x][checkX + x]) {
                    numberStraightP++;
                } else if(playerNum != board[checkY - x][checkX + x]){
                  numberStraightP = -10;
                }
                //southwest
                if (checkY + x < 6 && checkX - x > -1 && i == 0 && playerNum == board[checkY + x][checkX - x]) {
                    numberStraightP++;
                } else if(playerNum != board[checkY + x][checkX - x]){
                  numberStraightP = -10;
                }
            }
        }
        //System.out.println("ne/sw works"); // debug
        //System.out.println(numberStraightP); // debug
        if (numberStraightP < 4) {
            numberStraightP = 1;
        } else {
            winner = Integer.toString(playerNum);
        }
        // vertical check
        numberStraightP = 1;
        for (int i = 0; i < 2; i++) {
            for (int x = 1; x < 4; x++) {
                //down
                if (checkY + x < 6 && i == 0 && playerNum == board[checkY + x][checkX]) {
                    numberStraightP++;
                } else if(playerNum != board[checkY + x][checkX]){
                  numberStraightP = -10;
                }
                //up
                if (checkY - x > -1 && i == 1 && playerNum == board[checkY - x][checkX]) {
                    numberStraightP++;
                } else if(playerNum != board[checkY - x][checkX]){
                  numberStraightP = -10;
                }
            }
        }
        //System.out.println("vertical works"); // debug
        //System.out.println(numberStraightP); // debug
        if (numberStraightP < 4) {
            numberStraightP = 1;
        } else {
            winner = Integer.toString(playerNum);
        }
        // horizontal check
        for (int i = 0; i < 2; i++) {
            for (int x = 1; x < 4; x++) {
                //right
                if (checkX + x < 7 && i == 0 && playerNum == board[checkY][checkX + x]) {
                    numberStraightP++;
                } else if(playerNum != board[checkY][checkX + x]){
                  numberStraightP = -10;
                }
                //left
                if (checkX - x > -1 && i == 1 && playerNum == board[checkY][checkX - x]) {
                    numberStraightP++;
                } else if(playerNum != board[checkY][checkX - x]){
                  numberStraightP = -10;
                }
            }
        }
        //System.out.println("horizontal works"); // debug
        //System.out.println(numberStraightP); // debug
        if (numberStraightP < 4) {
            numberStraightP = 1;
        } else {
            winner = Integer.toString(playerNum);
        }
    }
    //work in progress >:(
    private void playAgain(){
        System.out.println("Would you like to play again? Please answer with either y or n.");
        Scanner playerInput = new Scanner(System.in);
        String playerAnswer = "n/a";
        while (playerAnswer != "y" || playerAnswer != "n") {
            playerAnswer = playerInput.next();
            System.out.println(playerAnswer);
            if (playerAnswer != "y" || playerAnswer != "n") {
                System.out.println("That is not a valid input, please try again.");
            }
        }
        switch (playerAnswer) {
            case "y":
                System.out.println("Starting new game!\n\n");
                Main game1 = new Main();
                game1.playGame();
            case "n":
                System.out.println("Ok loser.");
        }
    }
    /*
    PARAMETERS:
    none
    FUNCTIONALITY:
    driver function and play again
    RETURNS:
    void
     */
    private void playGame() {
        System.out.println("-----------CONNECT 4-----------");
        System.out.println("Welcome to connect 4! You should probably already know the rules, unless you don't then you're a loser.");
        this.printBoard();
        while (winner == "n/a") {
            this.playerInput();
            if (playerNum == 1) {
                playerNum = 2;
            } else {
                playerNum = 1;
            }
            if (numberPiecesAdded == 42) {
                System.out.println("\n\n\n\n\n\n\n\n\nThe entire board is covered, so the game is a tie.\n");
                break;
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\nWINNER OF THE GAME: Player " + winner);
        //once the play again function starts working properly, replace the line under this one with the function call for play again
        System.out.println("thanks for playing :)");
    }

    public static void main(String[] args) {
        Main drunkParty = new Main();
        drunkParty.playGame();
    }
}

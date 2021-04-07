import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsersInput {

    /*
    what this class does:
    - keeps track of the user's input
    - returns the user's input
    - once the button is pressed, notifies other classes to go start solving the returned system
    - after the other classes run and then use the setAnswer method, it displays updates the answer

    finishing touches to this class:
    - look at setAnswer function and updateAnswer function
     */

    private JPanel ui;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton runButton;
    public JLabel answerDisplayed;
    public String actualAnswer;

    //returns the inputted equations from the user in the form of a string object list
    public String[] getEquations(){
        String[] SystemOfEquations = {textField1.getText(), textField2.getText(), textField3.getText()};
        return SystemOfEquations;
    }

    //sets the answer
    public void setAnswer(String answer){
        //after calculating the answers, remember to call this function ***
        actualAnswer = answer;
    }

    //calls other files and classes to complete the inputted system of equations, then updates the text
    private void updateAnswer(){
        //add the calls for future classes here ***
        answerDisplayed.setText(actualAnswer);
    }

    //don't worry about these parts, it's how the ui is setup and displayed and etc.
    public UsersInput() {
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnswer();
            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Please insert a system of equations");
        frame.setContentPane(new UsersInput().ui);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.pack();
        frame.setVisible(true);
    }
}

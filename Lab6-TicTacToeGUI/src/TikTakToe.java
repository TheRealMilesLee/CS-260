/**
 * @author Hengyi Li
 * @className TikTakToe
 * @description This class is the GUI for the TicTacToe
 * @date 2021/12/07 12:07:02
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TikTakToe implements ActionListener
{

  final int SIZE = 9;
  // Buttons to hold the selection values
  JButton[] boardButtons = new JButton[SIZE];

  // buttons to restart or exit teh game
  JButton bRestart;
  JButton bExit;

  // to provide status message
  JLabel gameStatusLabel;
  JFrame gWindow; // main window object

  boolean moveToggleFlag = false; // toggles computer/user move
  int gameMoveCount = 0; // counts the number of moves to determine draw, etc

  // constructor
  public TikTakToe (String title)
  {

    // creating a JFrame window with the title
    gWindow = new JFrame(title);

    // The JPanel holds the buttons
    JPanel upperLayerPanel = new JPanel();
    upperLayerPanel.setLayout(new GridLayout(3, 3));
    // creating memory for the buttons
    for (int i = 0; i < SIZE; i++)
    {
      boardButtons[i] = new JButton();
      boardButtons[i].setText(Integer.toString(i + 1));
      boardButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 20));
      boardButtons[i].addActionListener(this);

      // adding the button to the Panel
      upperLayerPanel.add(boardButtons[i]);
    }


    // Panel holding buttons at the south side
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new GridLayout(2, 1));

    bRestart = new JButton("Restart Game");
    bRestart.setFont(new Font("SansSerif", Font.PLAIN, 16));
    bRestart.addActionListener(this);

    bExit = new JButton("Exit Game");
    bExit.setFont(new Font("SansSerif", Font.PLAIN, 16));
    bExit.addActionListener(this);


    gameStatusLabel = new JLabel("   Welcome. Your Turn. Select any button above to begin ..");
    gameStatusLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
    gameStatusLabel.setPreferredSize(new Dimension(100, 40));

    southPanel.add(gameStatusLabel, BorderLayout.CENTER);

    JPanel lowerButtonPanel = new JPanel();
    lowerButtonPanel.setLayout(new GridLayout(1, 2));
    lowerButtonPanel.add(bRestart, BorderLayout.WEST);
    lowerButtonPanel.add(bExit, BorderLayout.EAST);
    southPanel.add(lowerButtonPanel);


    // adding all the panels to the main window
    gWindow.setLayout(new BorderLayout());
    gWindow.add(upperLayerPanel, BorderLayout.CENTER);
    gWindow.add(southPanel, BorderLayout.SOUTH);


    gWindow.setSize(500, 500);
    gWindow.setVisible(true);
    gWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  // main driver program
  public static void main (String[] args)
  {
    // create an object of the TikTakToe class
    TikTakToe gameWindow = new TikTakToe("TikTakToe Game");
  }

  // this resets the buttons text values
  public void resetGame ()
  {
    // creating memory for the buttons
    for (int i = 0; i < SIZE; i++)
    {
      boardButtons[i].setText(Integer.toString(i + 1));
      boardButtons[i].setForeground(Color.BLACK);

    }

    gameMoveCount = 0;

    // other actions can be taken here
  }

  // Handles clicks on Compute button by computing the BMI.
  public void actionPerformed (ActionEvent event)
  {

    // if the event source is the restart button then
    if (event.getSource().equals(bRestart))
    {
      resetGame();
      this.gameStatusLabel.setText("   Game has restarted. Select any button above to begin ..");
      gWindow.setTitle("TicTacToe [Your Turn]"); // this can be randomized
    }
    else
    { // determine which cell button triggered the action event
      for (int i = 0; i < SIZE; i++)
      {
        if (event.getSource().equals(boardButtons[i]))
        { // button found

          // if the cell has already been selected then do not do anything
          if (boardButtons[i].getText().equals("H") == false && boardButtons[i].getText().equals("C") == false)
          {

            // this is the selected cell number
            gameStatusLabel.setText("  You have selected cell no " + (i + 1));

            if (moveToggleFlag == true)
            {
              gWindow.setTitle("TicTacToe [Your Turn]");
              boardButtons[i].setText("C");
              boardButtons[i].setForeground(Color.RED);
            }
            else
            {
              gWindow.setTitle("TicTacToe [Computers Turn]");
              boardButtons[i].setText("H");
              boardButtons[i].setForeground(Color.BLUE);
            }
            moveToggleFlag = !moveToggleFlag;
            gameMoveCount++; // keep counting the moves

            if (gameMoveCount == SIZE)
            { // if this is the last move
              gameStatusLabel.setText("    The Game Over! Restart the game to continue ...");
              gWindow.setTitle("TicTacToe [Game Over!]");
            }
          } // new move: if condition ends

        } // main if inside the loop ends
      } // for loop ends
    } // else block ends
  } // actionPerformed function ends

}

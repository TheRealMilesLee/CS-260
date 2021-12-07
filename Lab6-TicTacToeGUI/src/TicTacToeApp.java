/**
 * @author Hengyi Li
 * @className TicTacToeApp
 * @description This class is the GUI version for the TicTacToe
 * @date 2021/12/07 12:07:02
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeApp implements ActionListener
{

  static final int SIZE = 9;
  // Buttons to hold the selection values
  JButton[] boardButtons = new JButton[SIZE];

  JButton restartGame;
  JButton quitGame;

  // to provide status message
  JLabel gameStatusLabel;
  JFrame gameWindow; // main window object

  boolean moveToggleFlag = false; // toggles computer/user move
  int gameMoveCount = 0; // counts the number of moves to determine draw

  // constructor
  public TicTacToeApp (String title)
  {
    int columnSize = 3;
    int rowSize = 3;
    int fontSize = 20;
    String fontTypes = "SansSerif";
    gameWindow = new JFrame(title); // creating a JFrame window with the title

    // The JPanel holds the buttons
    JPanel upperLayerPanel = new JPanel();
    upperLayerPanel.setLayout(new GridLayout(rowSize, columnSize));
    for (int index = 0; index < SIZE; index++)
    {
      boardButtons[index] = new JButton();
      boardButtons[index].setText(Integer.toString(index + 1));
      boardButtons[index].setFont(new Font(fontTypes, Font.PLAIN, fontSize));
      boardButtons[index].addActionListener(this);
      upperLayerPanel.add(boardButtons[index]); // adding the button to the Panel
    }

    // Panel holding buttons at the south side
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new GridLayout(2, 1));

    restartGame = new JButton("Restart Game");
    restartGame.setFont(new Font(fontTypes, Font.PLAIN, 16));
    restartGame.addActionListener(this);

    quitGame = new JButton("Exit Game");
    quitGame.setFont(new Font(fontTypes, Font.PLAIN, 16));
    quitGame.addActionListener(this);


    gameStatusLabel = new JLabel("   Welcome. Your Turn. Select any button above to begin ..");
    gameStatusLabel.setFont(new Font(fontTypes, Font.PLAIN, 16));
    gameStatusLabel.setPreferredSize(new Dimension(100, 40));

    southPanel.add(gameStatusLabel, BorderLayout.CENTER);

    JPanel lowerButtonPanel = new JPanel();
    lowerButtonPanel.setLayout(new GridLayout(1, 2));
    lowerButtonPanel.add(restartGame, BorderLayout.WEST);
    lowerButtonPanel.add(quitGame, BorderLayout.EAST);
    southPanel.add(lowerButtonPanel);


    // adding all the panels to the main window
    gameWindow.setLayout(new BorderLayout());
    gameWindow.add(upperLayerPanel, BorderLayout.CENTER);
    gameWindow.add(southPanel, BorderLayout.SOUTH);


    gameWindow.setSize(500, 500);
    gameWindow.setVisible(true);
    gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public static void main (String[] args)
  {
    TicTacToeApp gameWindow = new TicTacToeApp("TicTacToeGUI Game");
  }

/**
 * This function is to reset the game
 */
  public void resetGame ()
  {
    for (int index = 0; index < SIZE; index++)
    {
      boardButtons[index].setText(Integer.toString(index + 1));
      boardButtons[index].setForeground(Color.BLACK);
    }
    gameMoveCount = 0;
  }

  // Handle clicks on Compute button by computing the BMI.
  public void actionPerformed (ActionEvent event)
  {

    // if the event source is the restart button then
    if (event.getSource().equals(restartGame))
    {
      resetGame();
      this.gameStatusLabel.setText("   Game has restarted. Select any button above to begin ..");
      gameWindow.setTitle("TicTacToe [Your Turn]"); // this can be randomized
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
              gameWindow.setTitle("TicTacToe [Your Turn]");
              boardButtons[i].setText("C");
              boardButtons[i].setForeground(Color.RED);
            }
            else
            {
              gameWindow.setTitle("TicTacToe [Computers Turn]");
              boardButtons[i].setText("H");
              boardButtons[i].setForeground(Color.BLUE);
            }
            moveToggleFlag = !moveToggleFlag;
            gameMoveCount++; // keep counting the moves

            if (gameMoveCount == SIZE)
            { // if this is the last move
              gameStatusLabel.setText("    The Game Over! Restart the game to continue ...");
              gameWindow.setTitle("TicTacToe [Game Over!]");
            }
          } // new move: if condition ends

        } // main if inside the loop ends
      } // for loop ends
    } // else block ends
  } // actionPerformed function ends

}

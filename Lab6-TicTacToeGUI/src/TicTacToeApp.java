/**
 * This file is to show the Tic Tac Toe app in GUI
 */

import edu.truman.li.cs260.gui.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Tic tac toe app.
 */
public class TicTacToeApp implements ActionListener
{
  /**
   * The Found winner switch.
   */
  boolean foundWinner = false;
  /**
   * The Board object.
   */
  Board boardObject = new Board();
  /**
   * The Player object.
   */
  Player playerObject = new Player();
  /**
   * The Number of buttons.
   */
  static final int NUMBER_OF_BUTTONS = 9;
  /**
   * The Board buttons.
   */
// Buttons to hold the selection values
  JButton[] boardButtons = new JButton[NUMBER_OF_BUTTONS];
  /**
   * Restart game button.
   */
  JButton restartGame;
  /**
   * Quit game button.
   */
  JButton quitGame;
  /**
   * Game status label.
   */
  JLabel gameStatusLabel;   // to provide status message
  /**
   * The Game window.
   */
  JFrame gameWindow; // main window object
  /**
   * The Game move count.
   */
  int gameMoveCount = 0; // counts the number of moves to determine draw
  
  /**
   * Instantiates a new Tic tac toe app.
   *
   * @param title the title
   */
// Constructor doing the UI things
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
    for (int index = 0; index < NUMBER_OF_BUTTONS; index++)
    {
      boardButtons[index] = new JButton();
      boardButtons[index].setText(Integer.toString(index + 1));
      boardButtons[index].setFont(new Font(fontTypes, Font.PLAIN, fontSize));
      boardButtons[index].addActionListener(this);
      upperLayerPanel.add(boardButtons[index]); // adding the button to the Panel
    }
    JPanel optionPanel = new JPanel();
    optionPanel.setLayout(new GridLayout(2, 1));
    
    // Button of restart game
    restartGame = new JButton("Restart Game");
    restartGame.setFont(new Font(fontTypes, Font.PLAIN, 16));
    restartGame.addActionListener(this);
    
    //Button of Exit Game
    quitGame = new JButton("Exit Game");
    quitGame.setFont(new Font(fontTypes, Font.PLAIN, 16));
    quitGame.addActionListener(this);
    
    gameStatusLabel = new JLabel("   Welcome. Your Turn. Select any button above to begin ..");
    gameStatusLabel.setFont(new Font(fontTypes, Font.PLAIN, 16));
    gameStatusLabel.setPreferredSize(new Dimension(100, 40));
    
    optionPanel.add(gameStatusLabel, BorderLayout.CENTER);
    
    JPanel lowerButtonPanel = new JPanel();
    lowerButtonPanel.setLayout(new GridLayout(1, 2));
    lowerButtonPanel.add(restartGame, BorderLayout.WEST);
    lowerButtonPanel.add(quitGame, BorderLayout.EAST);
    optionPanel.add(lowerButtonPanel);
    
    // adding all the panels to the main window
    gameWindow.setLayout(new BorderLayout());
    gameWindow.add(upperLayerPanel, BorderLayout.CENTER);
    gameWindow.add(optionPanel, BorderLayout.SOUTH);
    
    gameWindow.setSize(500, 500);
    gameWindow.setVisible(true);
    gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
  
  /**
   * The entry point of application.
   * @param args the input arguments
   */
  public static void main (String[] args)
  {
    TicTacToeApp gameWindow = new TicTacToeApp("TicTacToeGUI Game");
  }
  
  /**
   * Reset game.
   */
  public void resetGame ()
  {
    for (int index = 0; index < NUMBER_OF_BUTTONS; index++)
    {
      boardButtons[index].setText(Integer.toString(index + 1));
      boardButtons[index].setForeground(Color.BLACK);
    }
    gameMoveCount = 0;
  }
  
  /**
   * This function is to perform the action of the chess movement
   * @param event is the status of the game
   */
  public void actionPerformed (ActionEvent event)
  {
    // if the event source is the restart button then reset the title and the text
    if (event.getSource().equals(restartGame))
    {
      resetGame();
      foundWinner = false;
      this.gameStatusLabel.setText("   Game has restarted. Select any button above to begin ..");
      gameWindow.setTitle("TicTacToe [Your Turn]"); // this can be randomized
      boardObject.clearBoard();
    }
    else if (event.getSource().equals(quitGame))
    {
      System.exit(0);
    }
    else
    {
      // determine which cell button triggered the action event
      for(int index = 0;index < NUMBER_OF_BUTTONS && !foundWinner;index++)
      {
        if ((event.getSource().equals(boardButtons[index])) && (!boardButtons[index].getText().equals("H") && !boardButtons[index].getText().equals("C")))
        { // button found
          // if the cell has already been selected then do not do anything
            // this is the selected cell number
            if(gameMoveCount == NUMBER_OF_BUTTONS || boardObject.isFull())
            {
              gameStatusLabel.setText("    Tie Game! Restart the game to continue ...");
              gameWindow.setTitle("TicTacToe [Game Over!]");
              foundWinner = true;
            }
            if (playerObject.JudgeWinner(boardObject.getBoards()).equals("Human") || playerObject.JudgeWinner(boardObject.getBoards()).equals("Computer"))
            {
              gameStatusLabel.setText("    We have a Winner! The Winner is: " + playerObject.JudgeWinner(boardObject.getBoards()));
              gameWindow.setTitle("TicTacToe [Game Over!]");
              foundWinner = true;
            }
            else
            {
              gameStatusLabel.setText("  You have selected cell no " + (index + 1) );
              humanAction(index);
              if(gameMoveCount == NUMBER_OF_BUTTONS || boardObject.isFull())
              {
                gameStatusLabel.setText("    Tie Game! Restart the game to continue ...");
                gameWindow.setTitle("TicTacToe [Game Over!]");
                foundWinner = true;
              }
            }
            if (playerObject.JudgeWinner(boardObject.getBoards()).equals("Human") || playerObject.JudgeWinner(boardObject.getBoards()).equals("Computer"))
            {
              gameStatusLabel.setText("    We have a Winner! The Winner is: " + playerObject.JudgeWinner(boardObject.getBoards()));
              gameWindow.setTitle("TicTacToe [Game Over!]");
              foundWinner = true;
            }
            else
            {
              computerAction();
              if (playerObject.JudgeWinner(boardObject.getBoards()).equals("Human") || playerObject.JudgeWinner(boardObject.getBoards()).equals("Computer"))
              {
                gameStatusLabel.setText("    We have a Winner! The Winner is: " + playerObject.JudgeWinner(boardObject.getBoards()));
                gameWindow.setTitle("TicTacToe [Game Over!]");
                foundWinner = true;
              }
              gameMoveCount++; // keep counting the moves
  
              if (gameMoveCount == NUMBER_OF_BUTTONS || boardObject.isFull())
              {
                gameStatusLabel.setText("    Tie Game! Restart the game to continue ...");
                gameWindow.setTitle("TicTacToe [Game Over!]");
                foundWinner = true;
              }
            }
        } // new move: if condition ends
      } // main if inside the loop ends
    } // for loop ends
  } // else block ends
  
  /**
   * Computer action.
   */
  public void computerAction ()
  {
    gameWindow.setTitle("TicTacToe [Your Turn]");
    int computerIndex = boardObject.ComputerSide();
    boardButtons[computerIndex].setText("C");
    boardButtons[computerIndex].setForeground(Color.RED);
  }
  
  /**
   * Human action.
   * @param index the index that human selected
   */
  public void humanAction (int index)
  {
    gameWindow.setTitle("TicTacToe [Computers Turn]");
    int humanChoice = Integer.parseInt(boardButtons[index].getText());
    boardObject.changeBoards(humanChoice - 1);
    boardButtons[index].setText("H");
    boardButtons[index].setForeground(Color.BLUE);
  }
} // actionPerformed function ends

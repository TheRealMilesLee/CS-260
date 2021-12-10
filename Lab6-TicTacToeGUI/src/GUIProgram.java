import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIProgram implements ActionListener
{
  static final int NUMBER_OF_BUTTONS = 4;
  JButton[] boardButtons = new JButton[NUMBER_OF_BUTTONS];
  JButton nowPlaying;
  JButton mediaGuide;
  JButton Library;
  JButton HelpAndInfo;
  JButton OkButton;
  JLabel infoLabel;
  JFrame applicationWindow;
  JTextArea textSection;
  
  public GUIProgram(String title)
  {
    int fontSize = 20;
    String fontTypes = "SansSerif";
    applicationWindow = new JFrame(title); // creating a JFrame window with the title
    nowPlaying = new JButton("Now Playing");
    nowPlaying.setFont(new Font(fontTypes, Font.PLAIN, 16));
    nowPlaying.addActionListener(this);
    mediaGuide = new JButton("Media Guide");
    mediaGuide.setFont(new Font(fontTypes, Font.PLAIN, 16));
    mediaGuide.addActionListener(this);
    Library = new JButton("Library");
    Library.setFont(new Font(fontTypes, Font.PLAIN, 16));
    Library.addActionListener(this);
    HelpAndInfo = new JButton("Help & Info");
    HelpAndInfo.setFont(new Font(fontTypes, Font.PLAIN, 16));
    HelpAndInfo.addActionListener(this);
    
    JPanel leftButtonPanel = new JPanel();
    leftButtonPanel.setLayout(new GridLayout(4, 1));
    leftButtonPanel.add(nowPlaying, BorderLayout.NORTH);
    leftButtonPanel.add(mediaGuide, BorderLayout.NORTH);
    leftButtonPanel.add(Library, BorderLayout.NORTH);
    leftButtonPanel.add(HelpAndInfo, BorderLayout.NORTH);
  
    textSection = new JTextArea(35, 30);
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new FlowLayout());
    centerPanel.add(textSection, BorderLayout.CENTER);
    
    JPanel NumberButtonPanel = new JPanel();
    NumberButtonPanel.setLayout(new GridLayout(2, 2));
    for (int index = 0; index < NUMBER_OF_BUTTONS; index++)
    {
      boardButtons[index] = new JButton();
      boardButtons[index].setText(Integer.toString(index));
      boardButtons[index].setFont(new Font(fontTypes, Font.PLAIN, fontSize));
      boardButtons[index].addActionListener(this);
      NumberButtonPanel.add(boardButtons[index], BorderLayout.EAST); // adding the button to the Panel
    }
    
    JPanel OKButtonPanel = new JPanel();
    OKButtonPanel.setLayout(new FlowLayout());
    OkButton = new JButton("OK");
    OkButton.setFont(new Font(fontTypes, Font.PLAIN, 16));
    OkButton.setPreferredSize(new Dimension(160, 280));
    OkButton.addActionListener(this);
    OKButtonPanel.add(OkButton, BorderLayout.SOUTH);
  
    JPanel rightButtonPanel = new JPanel();
    rightButtonPanel.setLayout(new GridLayout(2,1));
    rightButtonPanel.add(NumberButtonPanel,BorderLayout.NORTH);
    rightButtonPanel.add(OKButtonPanel, BorderLayout.SOUTH);
    
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new FlowLayout());
    contentPanel.add(leftButtonPanel, BorderLayout.NORTH);
    contentPanel.add(centerPanel, BorderLayout.CENTER);
    contentPanel.add(rightButtonPanel, BorderLayout.NORTH);
    
    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new GridLayout(2, 8));
    infoLabel = new JLabel("                                       Movies   Music   Videos   DVD   Web Pages");
    infoLabel.setFont(new Font(fontTypes, Font.PLAIN, 16));
    infoLabel.setPreferredSize(new Dimension(100, 40));
    infoPanel.add(infoLabel, BorderLayout.CENTER);
    
    
    // adding all the panels to the main window
    applicationWindow.setLayout(new BorderLayout());
    applicationWindow.add(contentPanel, BorderLayout.NORTH);
    applicationWindow.add(infoPanel, BorderLayout.SOUTH);
  
    applicationWindow.setSize(750, 690);
    applicationWindow.setVisible(true);
    applicationWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
  public static void main (String[] args)
  {
    GUIProgram window = new GUIProgram("Movie on Thursday");
  }
  
  public void actionPerformed (ActionEvent event)
  {
    if(event.getSource().equals(nowPlaying))
    {
      this.textSection.append("Now Playing \n");
    }
    else if (event.getSource().equals(Library))
    {
      this.textSection.append("Library \n");
    }
    else if (event.getSource().equals(mediaGuide))
    {
      this.textSection.append("Media Guide \n");
    }
    else if (event.getSource().equals(HelpAndInfo))
    {
      this.textSection.append("Help & Info \n");
    }
    else if (event.getSource().equals(boardButtons[0]))
    {
      this.textSection.append("0 \n");
    }
    else if (event.getSource().equals(boardButtons[1]))
    {
      this.textSection.append("1 \n");
    }
    else if (event.getSource().equals(boardButtons[2]))
    {
      this.textSection.append("2 \n");
    }
    else if (event.getSource().equals(boardButtons[3]))
    {
      this.textSection.append("3 \n");
    }
    else
    {
      this.textSection.append("OK \n");
    }
  }
}

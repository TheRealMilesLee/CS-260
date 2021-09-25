package com.edu.truman.li.cs260;

public class Board {
  public Board() {
   String[][] boardArray = new String[3][3];
    for (String[] strings : boardArray) {
      System.out.println(" ----------------------");
      for (int col = 0; col < boardArray.length; col++) {
        System.out.printf("%s"," | "+ strings[col]);
      }
      System.out.printf("%s", " |");
      System.out.println();
    }
    System.out.println(" ----------------------");
  }
}

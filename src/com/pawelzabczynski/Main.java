package com.pawelzabczynski;

public class Main {

  public static void main(String[] args) {
    debiCardValid card = new debiCardValid();

    if (card.isValid(4448316251826725L)) {
      System.out.println("Is valid");
    } else {
      System.out.println("Is invalid");
    }
  }
}

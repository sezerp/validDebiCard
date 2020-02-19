package com.pawelzabczynski;

/** Created by PrZ on 16/04/2017. */
public class debiCardValid {

  debiCardValid() {}

  public boolean isValid(long number) {
    int a = sumOfDoubleEvenPlace(number);
    int b = sumOfOddPlace(number);

    a = a + b;

      return a % 10 == 0;
  }

  public int sumOfDoubleEvenPlace(long number) {

    int h = 1;
    int sum = 0;
    int i = getSize(number);

    while (h <= i) {

      if ((h % 2) == 0) {
        sum += getDigit(2 * (int) (number % 10));

      }
      number = number - (number % 10);
      number /= 10;

      h++;
    }
    return sum;
  }

  public int getDigit(int number) {
    int sum = 0;

    if (getSize(number) == 2) {
      int a;
      int b;
      a = number % 10;
      b = (number - a) / 10;
      number = a + b;

      return number;
    } else if (getSize(number) == 1) {
      return number;
    }

    return -1;
  }

  public int sumOfOddPlace(long number) {

    int h = 1;
    int sum = 0;
    int i = getSize(number);

    while (h <= i) {

      if ((h % 2) != 0) {
        sum += (int) (number % 10);
      }
      number = number - (number % 10);
      number /= 10;

      h++;
    }
    return sum;
  }

  public boolean prefixMatched(long number, int d) {
    int i = getSize(d);
    long j = getPrefix(number, i);

    return (long) d == j;
  }

  public int getSize(long d) {
    int i = 19;
    int cnt = 0;
    long y;
    long z;

    boolean firstNum = false;
    while (i >= 0) {
      y = d % (long) Math.pow(10, i);
      z = d - y;
      d = y;

      firstNum = z / (long) Math.pow(10, i) != 0 || firstNum;

      if (firstNum) {
        cnt++;
      }

      i--;
    }
    return cnt;
  }

  public long getPrefix(long number, int k) {

    int i = getSize(number);
    long y;
    long z;
    StringBuilder strNum = new StringBuilder();

    while (i >= 0) {
      y = number % (long) Math.pow(10, i);
      z = number - y;
      number = y;

      strNum.append(z / (long) Math.pow(10, i));

      i--;
    }

    for (int u = k; u > 0; u--) {
      number += (long) (strNum.charAt(u) - '0') * (long) Math.pow(10, (double) (u - 1));
    }

    return number;
  }
}

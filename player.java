import java.util.Scanner;
import java.util.Random;

public class player {
  //fields
  boolean toss = false;
  int tossBall = 0;
  char yOrN;
  char oOrE;
  int toChase = 0, batScore = 0;

  //Player Actions
  void batting() {
    int pBall = 0, cBall = 0;
    Scanner sc = new Scanner(System.in);

    while (true) {
      cBall = getRandom();
      System.out.println("Enter Your Number: ");
      pBall = sc.nextInt();

      if (pBall > 9 || pBall == 0) {
        System.out.println("Your Ball Should Be Above 0 and Under 9....... Try Again");
        continue;
      }

      if (cBall == pBall) {
        System.out.println("Gotcha! Your Score is :" + batScore);
        break;
      } else {
        batScore += pBall;
      }
    }
  }

  void bowling() {
    int pBall = 0, cBall = 0;
    Scanner sc = new Scanner(System.in);

    while (true) {
      cBall = getRandom();
      System.out.println("Enter Your Number: ");
      pBall = sc.nextInt();

      if (pBall > 9 || pBall == 0) {
        System.out.println("Your Ball Should Be Above 0 and Under 9............. Try Again");
        continue;
      }

      if (cBall == pBall) {
        System.out.println("Oops! My Score is : " + toChase);
        break;
      } else {
        toChase += cBall;
      }
    }
  }

  //Random Function
  int getRandom() {
    Random rand = new Random();
    
    return (rand.nextInt(9) + 1);
  }
}

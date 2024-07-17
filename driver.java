import java.util.Scanner;
import java.util.Random;

public class driver {
  public static void main(String[] args) {
    //Create a 'player' Instance
    player p1 = new player();

    //prompts
    System.out.println("------------------------------------------------------------");
    System.out.println("Hello! Are You Ready for the Game? ");
    System.out.println("Enter Y/N");

    System.out.println("Rules----------\nThe Only Rule is that Your Ball Should be More than 0 and Less Than 10 (Upto 9)");

    Scanner sc = new Scanner(System.in);
    String reader = sc.nextLine();
    p1.yOrN = reader.charAt(0);

    if (p1.yOrN == 'n' || p1.yOrN == 'N') {
      System.out.println("Get Lost........");
      return;
    }

    //Toss Starts
    System.out.println("Odd or Even? (Enter O/E): ");
    reader = sc.nextLine();
    p1.oOrE = reader.charAt(0);

    System.out.println("Enter Your Number: ");
    p1.tossBall = sc.nextInt();

    if ((p1.tossBall + getRandom()) % 2 == 0 && (p1.oOrE == 'e' || p1.oOrE == 'E')) {
      p1.toss = true;
    } else if ((p1.oOrE == 'o' || p1.oOrE == 'O') && (p1.tossBall + getRandom()) % 2 == 1) {
       p1.toss = true;
    } else {
      p1.toss = false;
    }
    
    //Role Selection and Play
    if (p1.toss == true) {
      System.out.println("Select Your Choice: 1. Batting\n 2. Bowling\n");
      p1.tossBall = sc.nextInt();

      if (p1.tossBall == 1) {
        p1.batting();
        System.out.println("Now Defend Your Score!");
        p1.bowling();
      } else {
        p1.bowling();
        System.out.println("Chase My Score if You Can!");
        p1.batting();
      }
    } else {
      if (getRandom() == 0) {
        System.out.println("I'll Bat First!");
        p1.bowling();
        System.out.println("It's Your Turn to Bat");
        p1.batting();
      } else {
        System.out.println("I'll Bowl First!");
        p1.batting();
        System.out.println("I'll Chase Your Score in No Time");
        p1.bowling();
      }
    }

    if (p1.toChase <= p1.batScore) {
      System.out.println("You Won!");
    } else {
      System.out.println("You Lost!");
    }
  }

  //Random Numbers Generator
  static int getRandom() {
    Random rand = new Random();
    int randInt = rand.nextInt(9) + 1;

    if (randInt % 2 == 0) {
      return 0;
    } else {
      return 1;
    }
  }
}

import java.util.*;

public class FizzBuzz {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Input minimum number:");
    int min = scan.nextInt();
    System.out.println("Input maximum number:");
    int max = scan.nextInt();

    for(int value = min; value <= max; value++){

      if(canFizz(value) & canBuzz(value)){
        System.out.println("Fizz-Buzz");
      }else if(canFizz(value)){
        System.out.println("Fizz");
      }else if(canBuzz(value)){
        System.out.println("Buzz");
      }else{
        System.out.println(value);
      }
    }

  }

  public static boolean canFizz(int input){
    boolean fizz = true;
    if(input % 3 != 0) return false;
    return fizz;
  }

  public static boolean canBuzz(int input){
    boolean buzz = true;
    if(input % 5 != 0) return false;
    return buzz;
  }
}

import java.text.NumberFormat;
import java.util.Scanner;

class Main {


  public static void  displayHeader() {
      System.out.println ("Sales Report");
      System.out.println ("Name..........Amount\n");
//Print header

  }

  public static int  displayBody(Scanner input) {
        int total = 0;
    //sum of all numbers
    while(input.hasNextLine()) {
      String name = input.nextLine();

      if (name.equals("quit")) 
        break;
      //if quit is ran then break
      input.nextLine();
      //skip
      String amount = input.nextLine();
      //get value input
      input.nextLine();
      //skip

      total += Integer.parseInt(amount);
      //convert string to an int
      System.out.println(addCommas(format(name, amount)));
      //print formatted 
    }

    return total;

  }

  public static void  displayFooter(int total) {

    System.out.println("");
    System.out.println(format("Total", addCommas(Integer.toString(total))));
    //print total with comma
  }


  public static String format(String name, String amount) {
    String output = "";
    int formatLength = 12 - name.length();
    //find input length

    output += name;

    for (int i = 0; i < formatLength; i++)
          output += ".";
          //add period if needed
    output += amount;

    return output;
  }
    public static void main(String[] args) {
    NumberFormat myFormat = NumberFormat.getInstance();
    myFormat.setGroupingUsed(true);

    Scanner inputFile = new Scanner(System.in);
    displayHeader();
    int total = displayBody(inputFile);

    displayFooter(total);
      //display total

  }

  public static String addCommas(String input) {
    if (input.length()>3) {
      int comma = input.length()-3;
      input = input.substring(0, comma) + "," + input.substring(comma);
    }
    return input;
  }
} 

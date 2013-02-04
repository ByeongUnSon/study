package lcson.codeinjection.test;
import java.util.Random;
 
class Protected
{
 
  public static boolean checkPassword(String password)
  {
    return String.valueOf( new Random().nextInt() ).equals(password);
  }
 
  public static void main(String[] argv)
  {
    if (argv.length != 1)
    {
      System.err.println("&quote;Please provide a password.&quote;");
      return;
    }
 
    if ( checkPassword(argv[0]) )
    {
      System.out.println("Success");
    }
    else
    {
      System.out.println("Failure");
    }
  }
}
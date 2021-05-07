import java.io.File;
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFile {
  public static void create(String fichier) {
    try {
      File myObj = new File(fichier);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
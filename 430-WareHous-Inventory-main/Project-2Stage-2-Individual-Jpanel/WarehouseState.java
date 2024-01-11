import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;

public abstract class WarehouseState {
  protected static WarehouseContext context;
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  protected WarehouseState() {
    // this.context = WarehouseContext.instance();
  }

  public abstract void run();

  public int getCommand() {
    do {
      try {
        int value = Integer.parseInt(getToken("Enter command:"));
        if (value <= 30 && value >= 0) {
          return value;
        }
      } catch (NumberFormatException nfe) {
        System.out.println("Enter a number");
      }
    } while (true);
  }

  public String getToken(String prompt) {
    do {
      try {
        System.out.println(prompt);
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
        if (tokenizer.hasMoreTokens()) {
          return tokenizer.nextToken();
        }
      } catch (IOException ioe) {
        System.exit(0);
      }
    } while (true);
  }

  protected boolean yesOrNo(String prompt) {
    String more = getToken(prompt + " (Y|y)[es] or anything else for no");
    if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
      return false;
    }
    return true;
  }
}

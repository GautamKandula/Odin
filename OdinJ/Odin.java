// Gautam Kandula
// Theory from "Crafting Interpreters"
// Project Started 3/18/2025

// Package Directory naming
package OdinJ;

// Importing needed utilities
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// Module class Odin
public class Odin {

    // Error Reporting Boolean
    static boolean issueOccured = false;

    // Main Functional project file
  public static void main(String[] args) throws IOException {
    if (args.length > 1) {
      System.out.println("Usage: jlox [script]");
      System.exit(64); 
    } else if (args.length == 1) {
      runFile(args[0]);
    } else {
      runPrompt();
    }
  }

  // Function to Run code from a file
  private static void runFile(String file) throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(file));
    run(new String(bytes, Charset.defaultCharset()));

    if (issueOccured) System.exit(-1);
  }

  // Function to Run code from a console
  private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);

    for(;;) {
        System.out.println("> ");
        String line = reader.readLine();
        if (line == null) {
            break;
        } 
        run(line);
        issueOccured = false;
    }
  }

  // Function to Run any code (Reads tokena and prints them for now)
  private static void run(String source) {
    Scanner scanner = new Scanner(source);
    List<Token> tokens = scanner.scanTokens();

    for (Token token: tokens) {
        System.out.println(token);
    }
  }

  // Error Handling Section
  // Function to Detect and display the error
  static void error(int line, String message) {
    reportError(line, "", message);
  }

  // Function to Generate error code
  private static void reportError(int line, String where, String message) {
    System.err.println("Line Number: " + line + "| Error" + where + ": " + message);
    issueOccured = true;
  }
}


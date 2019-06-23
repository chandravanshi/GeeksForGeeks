package geeks.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVReader {


  public static void main(String [] args) throws IOException {
    System.out.println("Enter file path");
    Path pathToFile = Paths.get("/Users/naveenkumarchandravanshi/Downloads/FIS_DUMP.xlsx");
    try (BufferedReader br = Files.newBufferedReader(pathToFile,
        StandardCharsets.UTF_8)) {

      // read the first line from the text file
      String line = br.readLine();
    }
  }

}

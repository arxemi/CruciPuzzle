import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author emilio
 */

public class MainClass {
    private static char[][] chars = null;
    private static int rows = -1;
    private static final int COLUMNS_NUMBER = 10;

    public static void main(String[] args){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter rows's number: ");
            String numRows_s = bufferedReader.readLine();
            rows = Integer.parseInt(numRows_s);
            chars = new char[rows][10];

            System.out.print("Load characters from file? (Y/N): ");
            String response = bufferedReader.readLine();

            if(response.charAt(0) == 'Y' || response.charAt(0) == 'y'){
                readFromFile("data.txt");
            }else {
                int count = 0;
                while (count < rows){
                    System.out.print("Enter a row: ");
                    String r = bufferedReader.readLine();
                    for(int i=0;i<r.length();i++){
                        chars[count][i] = r.charAt(i);
                    }
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        CruciPuzzle cruciPuzzle = new CruciPuzzle(chars,10,rows);
        String word = null;
        do{
            try {
                System.out.print("Enter the word to search: ");
                word = bufferedReader.readLine();
                cruciPuzzle.findWord(word);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (!word.equals("END") || !word.equals("end"));
    }

    private static void readFromFile(@NotNull  String fileName){
        try{
            Path path = Paths.get(fileName);
            List<String> reader = Files.readAllLines(path, Charset.defaultCharset());
            for(int j = 0;j < reader.size();j++){
                for(int i = 0;i < COLUMNS_NUMBER;i++){
                    chars[j][i] = reader.get(j).charAt(i);
                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}

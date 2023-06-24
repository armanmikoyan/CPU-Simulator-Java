import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileReader {
    public String[] readFile(String filePath) {
        List < String > wordsList = new ArrayList < > ();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);

                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    wordsList.add(word);
                }
            }

            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] file = new String[wordsList.size()];
        file = wordsList.toArray(file);

        return file;
    }
}
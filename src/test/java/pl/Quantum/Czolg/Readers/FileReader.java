package pl.Quantum.Czolg.Readers;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public JSONObject fileToJSON(File file){
        String fileContent = fileToString(file);
        JSONObject jsonObject = new JSONObject(fileContent);

        return jsonObject;
    }
    public String fileToString(File file){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
                stringBuilder.append(scanner.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }
}

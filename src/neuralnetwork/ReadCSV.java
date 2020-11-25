package neuralnetwork;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.*;

public class ReadCSV {

    public ReadCSV() {

    }

    public double[][] read(String fileName) {
        ArrayList<String[]> tempData = new ArrayList<>();
        String COMMA_DELIMITER = ",";
        int columnLength = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                String[] values = line.split(COMMA_DELIMITER);

                tempData.add(values);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException ie) {

        }
        
        double[][] dataset = new double[tempData.get(0).length][tempData.size()];

        int k = 0;
        for (String[] stringData : tempData) {
            for (int i = 0; i < stringData.length; i++) {
                dataset[i][k] = Double.parseDouble(stringData[i]);
            }
            k++;
        }
        
        return dataset;
    }
}
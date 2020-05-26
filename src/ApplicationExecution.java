import gameboard.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;



public class ApplicationExecution {
    //масив, съдържащ двете parse-нати от string към int променливи
    static int[] arrayOfParsedValues = new int[2];


    /**
     * @author Martin Petrov
     * main метод, това което успях да направя е да прочета данните в текстовия файл configurations и да
     * ги parse-на от string към int и получих int променливи за брой обезвреждания и брой анализи
     * @param args
     */
    public static void main(String[] args){

        File fileReference = new File("AdditionalResources/configurations");
        try {
            FileReader fileReferenceReader = new FileReader(fileReference);
            BufferedReader bufferedReader = new BufferedReader(fileReferenceReader);

            String lineReference;
            String nameOfVariableInExternalDocument;
            String variableValue;
            int parsedVariableValue;

            int i=0;

            while ((lineReference=bufferedReader.readLine()) != null) {

                String[] variablesCollection = lineReference.split("=");
                nameOfVariableInExternalDocument = variablesCollection[0];
                variableValue = variablesCollection [1];
                parsedVariableValue = Integer.parseInt(variablesCollection[1]);
                arrayOfParsedValues[i]=parsedVariableValue;
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        int numberOfProbes=arrayOfParsedValues[0];
        int numberOfDisposal=arrayOfParsedValues[1];



    }
}

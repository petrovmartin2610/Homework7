package gameboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GameBoardField {
    static int[] arrayOfParsedValues = new int[3];

    /**
     * @author Martin Petrov
     * main метод, това което успях да направя е да прочета данните в текстовия файл enemy territory и да
     * ги parse-на от string към int, получавайки ширината, дължината на масива и броя мини. main метода също
     * принтира в конзолата игралната дъска, но без други функционалности
     * @param args
     */
    public static void main(String[] args){
        File fileReference = new File("AdditionalResources/enemy_territory");
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

        String[][] gameBoardInit = new String [arrayOfParsedValues[0]][arrayOfParsedValues[1]];
        for (int i=0; i<gameBoardInit.length; i++){
            for (int j=0; j<gameBoardInit.length; j++){
                gameBoardInit[i][j] = "X";
            }
        }
        for (String[] width : gameBoardInit)
            System.out.println(Arrays.toString(width));

    }

}


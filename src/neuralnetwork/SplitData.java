package neuralnetwork;

import java.util.ArrayList;

public class SplitData {
    public double[][] splittingDataInput(double[][] splitData){
        double[][] input = new double[splitData.length - 1][splitData[0].length];
        
        for(int i = 0 ; i < input.length;i++){
            for(int k = 0 ; k < input[0].length; k++)
                input[i][k] = splitData[i][k];
        }
        
        return input;
    }
    
    public double[] splittingDataTarget(double[][] splitData){
        double[] target = new double[splitData[0].length];
        
        for(int i = 0 ; i < splitData[0].length; i++)
            target[i] = splitData[splitData.length - 1][i];
        
        return target;
    }
}

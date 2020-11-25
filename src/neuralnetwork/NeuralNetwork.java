package neuralnetwork;

public class NeuralNetwork {
    private double inputSequence[][];
    private double target[];
    private double threshold;
    private double newWeight[];
    private int bias;
    private int epoch = 1;
    
    
    public NeuralNetwork(double[][] inputSequence, double[] target, double threshold, int bias){
        this.inputSequence = inputSequence;
        this.target = target;
        this.threshold = threshold;
        this.bias = bias;
    }
    
    public double[] getWeight(int total, double min, double max){
        double[] randomWeight = new double[total];
        
        for(int i = 0 ; i < total; i++)
            randomWeight[i] =  min + Math.random() * (max - min);
        
        return randomWeight;
    }
    
    public double getLearningRate(int min, int max){
        double learningRate = (min + Math.random() * (max - min));
        
        return learningRate;
    }
    
    public void trainPerceptron(double[] weight){
        epoch = 1;
        while(true){
            int stopCondition = 0;
            for(int i = 0 ; i < inputSequence.length; i++){
                
                double summation = 0;
                for(int k = 0 ; k < weight.length; k++){
                    //sum each borizontal row
                    double temp = 0;
                    if(k == 0)
                        temp = bias * weight[k];
                    else
                        temp = inputSequence[i][k - 1] * weight[k];
                    
                    summation = summation + temp;
                }

                //generate output by comparing with threshold
                double output;
                if(summation >= threshold)
                    output = 1;
                else
                    output = 0;
                
                //if error more than 0 and also less than 0
                double error = getError(target[i], output);
                System.out.println(error);
                if(error != 0){
                    double newInput[] = recreateInput(inputSequence, i);
                    weight = recalculateWeight(weight, newInput, getLearningRate(-1, 1), error);

                    break;
                }
                stopCondition++;
            }
            if(stopCondition == inputSequence.length){
                newWeight = weight;
                break;
            }
            epoch++;
        }
    }
    
    public void trainPerceptron(double[] weight, int totalEpoch){
        epoch = 1;
        while(epoch < totalEpoch){
            int stopCondition = 0;
            for(int i = 0 ; i < inputSequence[0].length; i++){
                
                double summation = 0;
                for(int k = 0 ; k < weight.length; k++){
                    //sum each borizontal row
                    double temp = 0;
                    if(k == 0)
                        temp = bias * weight[k];
                    else
                        temp = inputSequence[k - 1][i] * weight[k];
                    
                    summation = summation + temp;
                }

                //generate output by comparing with threshold
                double output;
                if(summation >= threshold)
                    output = 2;
                else
                    output = 1;
                
                //if error more than 0 and also less than 0
                double error = getError(target[i], output);
                if(error != 0){
                    double newInput[] = recreateInput(inputSequence, i);
                    weight = recalculateWeight(weight, newInput, getLearningRate(-1, 1), error);

                    break;
                }
                stopCondition++;
            }
            if(stopCondition == inputSequence.length){
                newWeight = weight;
                break;
            }
            epoch++;
        }
        newWeight = weight;
    }
    
    public double[] classify(double[] weight, double[][] inputSequence){
        double[] classificationResult = new double[inputSequence[0].length];
        for(int i = 0 ; i < inputSequence[0].length; i++){
                
                double summation = 0;
                for(int k = 0 ; k < weight.length; k++){
                    //sum each borizontal row
                    double temp = 0;
                    if(k == 0)
                        temp = bias * weight[k];
                    else
                        temp = inputSequence[k - 1][i] * weight[k];
                    
                    summation = summation + temp;
                }

                //generate output by comparing with threshold
                double output;
                if(summation >= threshold)
                    output = 2;
                else
                    output = 1;

                //if error more than 0 and also less than 0
                classificationResult[i] = output;
        }
        
        return classificationResult;
    }
    
    public void countErrorRate(double[] result, double[] inputTarget){
        int sum = 0;
        System.out.println("Result | Target");
        for(int i = 0 ; i < result.length; i++){
            if(result[i] == inputTarget[i])
                sum = sum + 1;
            System.out.println(result[i] + " | " + inputTarget[i]);
        }
        
        int False = result.length - sum;
        double errorRate = ((double) False / (double) result.length) * 100;
        System.out.println("Correct Classification : " + sum);
        System.out.println("False Classification : " + False);
        System.out.println("Error Rate : " + errorRate + " %");
    }
    
    public double[] recreateInput(double[][] inputSequence, int index){
        double[] newInput = new double[inputSequence[0].length + 1];
        
        newInput[0] = bias;
        for(int i = 0; i < inputSequence[0].length; i++)
            newInput[i + 1] = inputSequence[index][i];
        
        return newInput;
    }
    
    public double[] recalculateWeight(double[] weight,double[] input, double learningRate, double error){
        for(int i = 0 ; i < weight.length;i++){
            weight[i] = weight[i] + (learningRate * input[i] * error);
        }
        
        return weight;
    }
    
    public double getError(double target, double output){
        return target - output;
    }
    
    public int getEpoch(){
        return epoch;
    }
    
    public double[] getNewWeight(){
        return newWeight;
    }
}
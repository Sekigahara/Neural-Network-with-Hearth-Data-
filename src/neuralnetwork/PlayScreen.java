package neuralnetwork;

public class PlayScreen {
    public static void main(String args[]){
        double[][] sampleInput = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        };
        
        double[] targetAND = {
            0, 0, 0, 1
        };
        
        double[] targetOR = {
            0, 1, 1, 1
        };
        
        //muda = 1, tinggi = 1
        //tua = 2, sedang = 2
        //paruh baya = 3, rendah = 3
        double[][] input = {
            {0, 0},
            {1, 1},
            {2, 0},
            {0, 2},
            {2, 1},
            {0, 1}
        };

        //ya = 1, tidak = 2
        double[] target = {
            1, 0, 0, 1, 1, 1
        };
        
        /*
        //training with AND target
        NeuralNetwork neuralNetwork = new NeuralNetwork(sampleInput, targetAND, 1, 1);
        neuralNetwork.trainPerceptron(neuralNetwork.getWeight(3, -1, 1));
        System.out.println("Epoch Iteration : " + neuralNetwork.getEpoch());
        
        System.out.println("Weight for AND");
        double[] weight = neuralNetwork.getNewWeight();
        for(int i = 0 ; i < weight.length;i++)
            System.out.println(weight[i]);
        
        //training with OR target
        NeuralNetwork neuralNetwork1 = new NeuralNetwork(sampleInput, targetOR, 1, 1);
        neuralNetwork.trainPerceptron(neuralNetwork1.getWeight(3, -1, 1));
        System.out.println("Epoch Iteration : " + neuralNetwork.getEpoch());
        
        System.out.println("Weight for OR");
        double[] weight1 = neuralNetwork.getNewWeight();
        for(int i = 0 ; i < weight.length;i++)
            System.out.println(weight1[i]);
        */
        
        //training with diabeteus
        /* 
        NeuralNetwork neuralNetwork2 = new NeuralNetwork(input, target, 1, 1);
        neuralNetwork2.trainPerceptron(neuralNetwork2.getWeight(3, -1, 1), 10000);
        System.out.println("Epoch Iteration : " + neuralNetwork2.getEpoch());
        
        System.out.println("Weight for Diabeteus");
        double[] weight2 = neuralNetwork2.getNewWeight();
        for(int i = 0 ; i < weight2.length;i++)
            System.out.println(weight2[i]);
        
        double[] result = neuralNetwork2.classify(weight2, input);
        neuralNetwork2.countErrorRate(result, target);
        */
        
        ReadCSV readCSV = new ReadCSV();
        double[][] dataset = readCSV.read("heart.csv");
        
        SplitData splitData = new SplitData();
        double[][] input3 = splitData.splittingDataInput(dataset);
        double[] target3 = splitData.splittingDataTarget(dataset);
  
        NeuralNetwork neuralNetwork3 = new NeuralNetwork(input3, target3, 0, 1);
        neuralNetwork3.trainPerceptron(neuralNetwork3.getWeight(dataset.length, -1, 1), 1000000);
        System.out.println("Epoch Iteration : " + neuralNetwork3.getEpoch());
        
        System.out.println("Weight for Hearth");
        double[] weight3 = neuralNetwork3.getNewWeight();
        for(int i = 0 ; i < weight3.length;i++)
            System.out.println(weight3[i]);
        
        double[] result3 = neuralNetwork3.classify(weight3, input3);
        neuralNetwork3.countErrorRate(result3, target3);
    }
}
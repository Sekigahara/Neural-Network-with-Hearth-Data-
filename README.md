This Repository is already included the Dataset within it's directory.

Class : 
1. ReadCSV.java
  - This Class is used to Extract Data from csv.
  - The Data will Filled inside Two Dimensional Array.
  - Also This Class is Customizable by the Return Value.

2. SplitData.java
  - This Class is used to Split Training Data and Target Data.
  - Basically Target data are placed in the last collumn

3. PlayScreen.java
  - This class is used for Calling the class in other words it used for like SplashScreen

4. NeuralNetwork.java
  - This is the class of Neural Network which Store the Required Data for Training and doing the training itself.
  - This is only Single Perceptron Neural Network.

How it's Work(?) :

1. First we define a random Weight , The Neural Network class has a method to do so.
2. Then we have to Define how big are the epoch iteration. The Longer the better result it gave.
    - After that the method train perceptron find the optimal weight for the dataset.
    - The loop of finding optimal weight will ended due to epoch that we input.
3. After we got the New Weight, we call classify method for classifying.
    - We could use our heart dataset
    - The Approach is to find the target based on optimal weight after the training.
    - After the result is coming out, in order to test how accurate the model that we create
      we could count the error rate by using countErrorRate method.
      This Method compare the target data which we extracted with the new target which we trained using our optimized weight.

*Something that need to be concerned with my source code are:
  1. The Data need to be Normalized by some approach of data mining
      #The given code using exactly raw data from the dataset.
        The Result is the error rate still high due to the values not optimum to do the training.
      Solution :
      There is two easiest approach to normalize the data.
      
      1. Min Max Method
      2. Z Score Method
      
      it's necessary to increase the accuracy of the model by normalize the data first.
      although the data still raw at least there is no Null values so we don't have to worry about Data Wrangling.
       

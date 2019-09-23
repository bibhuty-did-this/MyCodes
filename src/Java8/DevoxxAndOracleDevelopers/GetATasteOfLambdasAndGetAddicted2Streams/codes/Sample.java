package Java8.DevoxxAndOracleDevelopers.GetATasteOfLambdasAndGetAddicted2Streams.codes;

public class Sample {
    public static void main(String[] args) {
        Thread thread=new Thread(()-> System.out.println("In another thread"));
        thread.start();


    }
}

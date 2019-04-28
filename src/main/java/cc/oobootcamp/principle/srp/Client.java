package cc.oobootcamp.principle.srp;


public class Client {


    public static void main(String[] args) {

        String source = "19/01/2019";

        ConvertStringHandler convertStringHandler = new ConvertStringHandler(source);
        String target = convertStringHandler.convert();

        PrintStringHandler printStringHandler = new PrintStringHandler(source, target);
        printStringHandler.print();
    }

}

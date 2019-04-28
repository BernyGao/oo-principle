package cc.oobootcamp.principle.srp;



public class Client {


    public static void main(String[] args) {

        String source = "19/01/2019";

        StringHandler stringHandler = new StringHandler(source);

        stringHandler.convert();
        stringHandler.print();
    }

}

package cc.oobootcamp.principle.srp;

public class StringHandler {

    private String source;

    private String target;

    public StringHandler(String source) {
        this.source = source;
    }

    public String convert() {
        ConvertStringHandler convertStringHandler = new ConvertStringHandler(source);
        this.target = convertStringHandler.convert();
        return target;
    }

    public void print() {
        PrintStringHandler printStringHandler = new PrintStringHandler(source, target);
        printStringHandler.print();
    }
}

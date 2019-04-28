package cc.oobootcamp.principle.srp;

import java.util.HashMap;
import java.util.Map;

public class ConvertStringHandler {

    private String source;

    public ConvertStringHandler(String source) {
        this.source = source;
    }

    public String convert() {

        if (source.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return source.replaceAll("-", "");
        }

        if (source.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return source.replaceAll("/", "");
        }

        Map<String, Integer> result = new HashMap<>();
        char[] chars = source.toCharArray();
        for (char c : chars) {
            if (result.get(String.valueOf(c)) != null) {
                result.put(String.valueOf(c), result.get(String.valueOf(c)) + 1);
            } else {
                result.put(String.valueOf(c), 1);
            }
        }
        return result.toString();
    }

}

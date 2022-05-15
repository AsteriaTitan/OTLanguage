package Variable;

import item.Check;
import item.Setting;
import item.VariableWork;

public class FloatP extends Setting implements Check, VariableWork {

    private static final String SPECIFIED = "ㅇㅅㅇ";

    @Override
    public boolean check(String line) {
        return line.strip().startsWith(SPECIFIED);
    }

    @Override
    public void start(String line) {
        int start = line.indexOf(SPECIFIED) + SPECIFIED.length();
        int end = line.indexOf(":");
        String key = line.substring(start, end).strip();
        String value = line.substring(end+1);
        FM.put(key, Float.valueOf(value));
    }
}

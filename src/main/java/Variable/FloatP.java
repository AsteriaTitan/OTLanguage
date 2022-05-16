package Variable;

import item.Check;
import item.KeyValue;
import item.Setting;
import item.VariableWork;
import print.ScannerP;

public class FloatP extends Setting implements Check, VariableWork {

    private static final String SPECIFIED = "ㅇㅅㅇ";

    @Override
    public boolean check(String line) {
        return line.strip().startsWith(SPECIFIED);
    }

    @Override
    public void start(String line) throws Exception {
        KeyValue keyValue = setKeyValue(SPECIFIED, line);
        String key = keyValue.getKey();
        String value = keyValue.getValue();
        FM.put(key, Float.valueOf(value));
        set.add(key);
    }
}
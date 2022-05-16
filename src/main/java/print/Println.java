package print;

import Variable.Variable;
import item.Check;
import item.PrintWork;
import item.Setting;

import java.util.List;

public class Println extends Setting implements Check, PrintWork {

    private static final String SPECIFIED = "ㅆㅁㅆ";

    /**
     * @param line 1줄 받아오기
     * @return 만약 처음이 ㅆㅁㅆ 이면 println
     */
    @Override
    public boolean check(String line) {
        return line.strip().startsWith(SPECIFIED);
    }

    /**
     * @param line 줄을 받아옴
     */
    @Override
    public void start(String line) {
        /* -- ㅆㅁㅆ 제거 -- */
        int start = line.indexOf(SPECIFIED) + SPECIFIED.length();
        line = line.substring(start);
        if (variable.check(line)) {
            List<String> lists = variable.getVar(line);
            for (String list : lists)
                line = line.replaceFirst(list, checkValue(list));
        } System.out.println(line);
    }
}

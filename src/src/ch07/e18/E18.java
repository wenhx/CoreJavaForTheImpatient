package ch07.e18;

import java.util.Collections;
import java.util.List;

public class E18 {
    public static void run() {
        List<String> list1 = Collections.emptyList();
        //The following usage comes with a warning: Unchecked assignment: 'java.util.List' to 'java.util.List<java.lang.String>'
        //and they are not any different other than that.
        List<String> list2 = Collections.EMPTY_LIST;
        List list3 = Collections.EMPTY_LIST;
        List list4 = Collections.emptyList();
        System.out.println(list1 == list2);
    }
}

package Help;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test {
    public static double safepow(double x, double e) {
        System.out.println(Math.signum(x));
        return Math.signum(x) * Math.abs(Math.pow(Math.abs(x), e));
    }

    public static int least(ArrayList<Integer> m) {
        for (int k = 0; k < m.size() - 1; k++) {
            int large = 0;
            for (int p = 0; p < m.size(); p++) {
                if (m.get(p) > m.get(large)) large = p;
            }
            m.remove(large);
        }
        return m.get(0);
    }

    public static void main(String[] args) {
        ArrayList<Integer> m = new ArrayList<>();

        m.add(-27);
        m.add(-54);
        m.add(1);
        m.add(-5);
        m.add(5);
        m.add(89);
        m.add(156);
        System.out.println(least(m));
    }
}
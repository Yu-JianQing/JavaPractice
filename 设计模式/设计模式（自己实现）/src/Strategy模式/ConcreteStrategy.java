package Strategy模式;

import java.util.ArrayList;
import java.util.List;

public class ConcreteStrategy extends Strategy {
    @Override
    public List<Integer> sort(int[] num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - i - 1; j++)
                if (num[j] > num[j + 1])
                    swap(num, j, j + 1);
        }
        for (int x : num)
            list.add(x);
        return list;
    }

    private void swap(int num[], int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}

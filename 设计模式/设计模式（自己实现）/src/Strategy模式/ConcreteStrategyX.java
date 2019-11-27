package Strategy模式;

import java.util.ArrayList;
import java.util.List;

public class ConcreteStrategyX extends Strategy {
    @Override
    public List sort(int[] num) {
        List<Integer> list = new ArrayList<>();
        for (int x : quickSort(num, 0, num.length - 1))
            list.add(x);
        return list;
    }

    private int[] quickSort(int num[], int start, int end) {
        if (start >= end)
            return num;
        int mid = findMid(num, start, end);
        quickSort(num, start, mid - 1);
        quickSort(num, mid + 1, end);
        return num;
    }

    private int findMid(int num[], int start, int end) {
        int ele = num[start];
        while (start < end) {
            while (start < end && num[end] > ele)
                end--;
            if (start < end)
                num[start++] = num[end];
            while (start < end && num[start] < ele)
                start++;
            if (start < end)
                num[end--] = num[start];
        }
        num[start] = ele;
        return start;
    }
}

package Strategy模式;

import java.util.List;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void print(int num[]) {
        List<Integer> list = strategy.sort(num);
        for (int x : list)
            System.out.println(x);
    }
}

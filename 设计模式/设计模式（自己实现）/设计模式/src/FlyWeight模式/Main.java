package FlyWeight模式;

public class Main {
    public static void main(String[] args) {
        FlyWeightFactory factory = FlyWeightFactory.getInstance();

        FlyWeight flyWeight = factory.getFlyWeight(1, "tom");
        FlyWeight flyWeight2 = factory.getFlyWeight(2, "tom");
        FlyWeight flyWeight3 = factory.getFlyWeight(1, "tom");

        System.out.println(flyWeight == flyWeight2);
        System.out.println(flyWeight == flyWeight3);

    }
}

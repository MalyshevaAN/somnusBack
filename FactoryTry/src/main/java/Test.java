public class Test {
    public static void main(String[] args) {
        SushiBar cool = new SushiBar();
        SushiType order = SushiType.Kalifornia;
        Sushi item = cool.orderSushi(order);
        item.give();

    }
}

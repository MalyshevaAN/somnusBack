public class SushiBar {
    public Sushi orderSushi(SushiType type){
        SushiFactory factory = new SushiFactory();
        Sushi sushi = factory.getSushi(type);
        sushi.cut();
        sushi.roll();
        sushi.decore();
        return sushi;
    }
}

public class SushiFactory {
   public Sushi getSushi(SushiType type){
       Sushi sushi = null;
       switch (type){
           case Pfiladelphia -> {
               sushi = new Pfiladelphia();
               break;
           }
           case Kalifornia -> {
               sushi = new Kalifornia();
               break;
           }
           case Otory -> {
               sushi = new Otory();
               break;
           }
       }
       return sushi;
   }
}

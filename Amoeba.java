import java.util.Random;

public class Amoeba{
  public static void main (String[]args){
    double LiveCultures = 0;
    int percent = 0;
    //2,147,483,647
    double numCultures = 2147483647;
    for(double i = 0; i < numCultures; i++){
      if(Cell.process()){
        LiveCultures++;
      }
      if(i%((int)numCultures/100) == 0 && i != 0){
        percent++;
        System.out.println(percent+"%: "+(LiveCultures/i)*100);
      }
    }
    double avg = LiveCultures/numCultures;
    avg = avg * 100;
    System.out.println("Percent of cultures survived: " + avg + "%");
    System.out.println("Number of cultures total: " + (int)numCultures);
    System.out.println("Number of surviving cultures: " + (int)LiveCultures);
  }
}
class Cell{
  public static boolean process(){
    int AmoebaCount = 1;
      while(AmoebaCount > 0){
        if(AmoebaCount >= 20){
          return true;
        }
        else{
          Random gen = new Random();
          int ran = gen.nextInt(100);
          ran = ran%4;
          switch(ran){
            case 0: break;
            case 1: AmoebaCount--; break;
            case 2: AmoebaCount++; break;
            case 3: AmoebaCount+= 2; break;
            default: throw new IllegalArgumentException("This really shouldn't happen");
          }
        }
      }
    return false;
 }
}

package practic;

@FunctionalInterface
public interface My {

    void my2();
   default int my(){
       return my1();
   };

   private int my1(){
      return 0;
   }
}

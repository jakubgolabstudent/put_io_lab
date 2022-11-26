package put.io.patterns.implement;

public class SystemGarbageObserver implements SystemStateObserver{
    SystemState currentState;

    public void update(SystemState newState){
        this.currentState = newState;
        probe();
    }

     public void probe(){
         // Run garbage collector when out of memory
         if (currentState.getAvailableMemory() < 200.00){
             System.out.println("> Running garbage collector...");
         }
     }
}

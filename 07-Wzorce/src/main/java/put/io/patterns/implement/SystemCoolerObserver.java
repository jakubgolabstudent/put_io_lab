package put.io.patterns.implement;

public class SystemCoolerObserver implements SystemStateObserver {
    SystemState currentState;

    @Override
    public void update(SystemState newState) {
        currentState = newState;
        probe();
    }

    public void probe(){
        // Increase CPU cooling if the temperature is too high
        if (currentState.getCpuTemp() > 60.00){
            System.out.println("> Increasing cooling of the CPU...");
        }
    }
}

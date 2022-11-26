package put.io.patterns.implement;

public class USBObserver implements SystemStateObserver{
    SystemState currentState;

    int counter = -1;

    public void update(SystemState newState){
        this.currentState = newState;
        probe();
    }

    public void probe(){
        if (this.counter != this.currentState.getUsbDevices() && counter != -1){
            System.out.println(String.format("Actual number of USB devices: %d", this.currentState.getUsbDevices()));
        }
        this.counter = this.currentState.getUsbDevices();
    }
}

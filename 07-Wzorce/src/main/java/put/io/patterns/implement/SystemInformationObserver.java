package put.io.patterns.implement;

public class SystemInformationObserver implements SystemStateObserver{
    SystemState currentState;

    public void update(SystemState newState){
        this.currentState = newState;
        probe();
    }

    public void probe(){
        // Print information to the console
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", this.currentState.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", this.currentState.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", this.currentState.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", this.currentState.getUsbDevices()));
    }
}

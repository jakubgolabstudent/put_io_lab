package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String args[]){
        SystemMonitor monitor = new SystemMonitor();

        SystemCoolerObserver coolerObserver = new SystemCoolerObserver();
        USBObserver usbObserver = new USBObserver();
        SystemGarbageObserver garbageObserver = new SystemGarbageObserver();
        SystemInformationObserver informationObserver = new SystemInformationObserver();

        monitor.addSystemStateObserver(coolerObserver);
        monitor.addSystemStateObserver(usbObserver);
        monitor.addSystemStateObserver(garbageObserver);
        monitor.addSystemStateObserver(informationObserver);

        while (true) {

            monitor.probe();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

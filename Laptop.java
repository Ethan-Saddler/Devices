public class Laptop extends Device{
    private boolean overclockable;

    public Laptop(int serialNumber, int cpuCapacity, int length, boolean overclockable) {
        super(serialNumber, cpuCapacity, length);
        this.overclockable = overclockable;
    }
    public Laptop(int serialNumber, int cpuCapacity, int length) {
        super(serialNumber, cpuCapacity, length);
        this.overclockable = false;
    }

}

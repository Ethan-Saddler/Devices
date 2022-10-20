public abstract class Device {
    private final int serialNumber;
    protected final int cpuCapacity;
    protected int cpuRemaining;
    protected Task[] tasks;

    public Device(int serialNumber, int length) {
        this.serialNumber = serialNumber;
        this.tasks = new Task[length];
        this.cpuCapacity = 512;
        this.cpuRemaining = this.cpuCapacity;
    }

    public Device(int serialNumber, int cpuCapacity, int length) {
        this.serialNumber = serialNumber;
        this.tasks = new Task[length];
        this.cpuCapacity = cpuCapacity;
        this.cpuRemaining = this.cpuCapacity;
    }
    public abstract boolean canAddTask(Task task);

    public abstract boolean addTask(Task task);

    public boolean processTask(Task task) {
        if (task == null) {
            return false;
        } 
        for (int n = 0; n < tasks.length; n++) {
            if (tasks[n] == task) {
                this.cpuRemaining += tasks[n].cpuCost;
                System.out.printf("Processed: %s%n", tasks[n].toString());
                tasks[n] = null;
                return true;
            }
        }
        return false;
    }
    public boolean equals(Object device) {
        device = (Device) device;
        if (this.serialNumber == device.serialNumber && this.cpuCapacity == device.cpuCapacity && this.cpuRemaining == device.cpuRemaining) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        return String.format("Device with serial number %d has %d of %d CPU remaining.", serialNumber, cpuRemaining, cpuCapacity);
    }

}

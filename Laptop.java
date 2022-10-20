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

    public int bufferSlotsRequired(int cpuRemaining) {
        if (tasks.length <= 4) {
            return 0;
        } else if (cpuRemaining < 128) {
            return 2;
        } else {
            return 1;
        }
    }
    public boolean canAddTask(Task task) {
        int nullcount = 0;
        if (this.cpuRemaining >= task.cpuCost || (this.overclockable && (this.cpuRemaining + (cpuCapacity/4) >= task.cpuCost))) {
            for (int n = 0; n < tasks.length; n++) {
                if (tasks[n] == null) {
                    nullcount++;
                }
            }
            if (nullcount > this.bufferSlotsRequired(this.cpuRemaining)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    public boolean addTask(Task task) {
        if (this.canAddTask(task) == true) {
            if (this.cpuRemaining < task.cpuCost){
                this.overclockable = false;
                for (int n = 0; n < tasks.length; n++) {
                    if (tasks[n] == null) {
                        tasks[n] = task;
                        this.cpuRemaining -= task.cpuCost;
                        return true;
                    } 
                }
            }

        } 
        return false;
    }
    public boolean equals(Object laptop) {
        if (super.equals(laptop) && this.overclockable == laptop.overclockable) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        return (super.toString() + String.format(" This laptop %s have overclocking.", this.overclockable ? "does" : "does not"));
    }

}

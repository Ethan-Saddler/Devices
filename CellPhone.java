public class CellPhone extends Device {
    private int tasksCompleted = 0;

    public CellPhone(int serialNumber, int cpuCapacity, int length) {
        super(serialNumber, cpuCapacity, length);
    }
    public CellPhone(int serialNumber, int cpuCapacity) {
        super(serialNumber, cpuCapacity, 10);
    }

    public boolean canAddTask(Task task) {
        if (this.cpuRemaining >= task.cpuCost) {
            for (int n = 0; n < tasks.length; n++) {
                if (tasks[n] == null) {
                    return true;
                } 
            }
            return false;
        } else {
            return false;
        }
    }
    public boolean addTask(Task task) {
        if (this.canAddTask(task) == true) {
            for (int n = 0; n < tasks.length; n++) {
                if (tasks[n] == null) {
                    tasks[n] = task;
                    this.cpuRemaining -= task.cpuCost;
                    return true;
                } 
            }
        } 
        return false;
    }
    public boolean equals(Object phone) {
        phone = (CellPhone) phone;
        if (super.equals(phone) && this.tasksCompleted == phone.tasksCompleted) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        return (super.toString() + String.format(" It has completed %d tasks.", tasksCompleted));
    }

    public boolean processTask(Task task) {
        if (task == null) {
            return false;
        } 
        for (int n = 0; n < tasks.length; n++) {
            if (tasks[n] == task) {
                tasksCompleted += 1;
                this.cpuRemaining += tasks[n].getCost();
                System.out.printf("Processed: %s%n", tasks[n].toString());
                tasks[n] = null;
                return true;
            }
        }
        return false;
    }
}
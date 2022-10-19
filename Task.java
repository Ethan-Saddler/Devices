public class Task {
    private String name;
    public final int cpuCost;

    public Task(String name, int cpuCost) {
        if (name == null) {
            this.name = "GEN_TASK";
        } else {
            this.name = name;
        }
        if (cpuCost < 8) {
            this.cpuCost = 8;
        } else {
            this.cpuCost = cpuCost;
        }
    }
    public boolean equals(Task task) {
        if (task.name == name && task.cpuCost == cpuCost) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        return String.format("%s has CPU cost of %d", name, cpuCost);
    }
    public int getCost() {
        return this.cpuCost;
    }
}

package org.scheduler;

public class Task implements Cloneable {
    private int offset;
    private final int computation_time;
    private final int period_time;
    private final int quantum;
    private final int deadline;

    private int absolute_deadline;
    private int deadline_loss;
    private int turnaround_time;
    private int waiting_time;
    private int executions;
    private int progress;
    private int index;

    @Override
    public String toString() {
        return "Task: "+ index +"\n";
    }

    public Task(int offset, int computation_time, int period_time, int quantum, int deadline) {
        this.offset = offset;
        this.computation_time = computation_time;
        this.period_time = period_time;
        this.quantum = quantum;
        this.deadline = deadline;
        this.progress = 0;
    }

    public int getOffset() {
        return offset;
    }

    public int getComputation_time() {
        return computation_time;
    }

    public int getPeriod_time() {
        return period_time;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getQuantum() {
        return quantum;
    }

    public int getDeadline() {
        return deadline;
    }

    public int getAbsolute_deadline() {
        return absolute_deadline;
    }

    public int getDeadline_loss() {
        return deadline_loss;
    }

    public void setDeadline_loss(int deadline_loss) {
        this.deadline_loss = deadline_loss;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void incrementOffSet(){ this.offset += this.period_time; }

    public void generateDeadline(int time){ this.absolute_deadline = time+deadline; }

    public void setAbsolute_deadline(int absolute_deadline) {
        this.absolute_deadline = absolute_deadline;
    }

    public int getTurnaround_time() {
        return turnaround_time;
    }

    public void setTurnaround_time(int turnaround_time) {
        this.turnaround_time = turnaround_time;
    }

    public int getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }

    public int getExecutions() {
        return executions;
    }

    public void setExecutions(int executions) {
        this.executions = executions;
    }

    @Override
    public Object clone() throws  CloneNotSupportedException {
        return super.clone();
    }
}

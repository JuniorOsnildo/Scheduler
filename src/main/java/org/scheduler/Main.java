package org.scheduler;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        String path = "D:\\IdeaProjects\\Scheduler\\Json\\exemplo_sched.json";

        Scheduler scheduler = JsonReader.Read(path);

        if(scheduler != null)
           scheduler.schedule();

    }
}
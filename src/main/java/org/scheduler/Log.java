package org.scheduler;

import java.util.LinkedList;
import java.util.Queue;

public class Log {
    private final int task_number;
    private float system_waiting_time;
    private float system_turnaround_time;
    private float system_utilization;

    public LinkedList<String> deadline_loss_list = new LinkedList<>();

    public Log(int size) {
        this.task_number = size;
    }

    private void deadListToString(){
        for (String str: deadline_loss_list) {
            System.out.println(str+"\n");
        }
    }

    public void cpuUsage(float usage, int total_time){
        System.out.println("--------------------------------------");
        System.out.println("CPU usage: "+(((usage)/total_time)*100)+"%");
        System.out.println("--------------------------------------");
    }

    public void showLogs(Task[] tasks){
        int i = 0;
        float maior = tasks[0].getWaiting_time();
        int indexMaior = 0;
        float menor = tasks[0].getWaiting_time();
        int indexMenor = 0;

        int totalExecutions = 0;

        System.out.println("\n\n## all data ##");

        for (Task t : tasks) {
            system_waiting_time += t.getWaiting_time();

            totalExecutions += t.getExecutions();

            float medium = 0;

            if (t.getWaiting_time() > 0)
                medium = (float) t.getWaiting_time() /t.getExecutions();

            if (medium > maior) {
                maior = medium;
                indexMaior = t.getIndex();
            }

            if(medium < menor){
                menor = medium;
                indexMenor = t.getIndex();
            }

            System.out.println("Medium wainting time task "+
                    t.getIndex() +": " +medium);
        };
        System.out.println("--------------------------------------");
        System.out.println("Highest waiting time: "+maior+", from task: "+indexMaior);
        System.out.println("Lowest waiting time: "+menor+", from task: "+indexMenor);
        System.out.println("--------------------------------------");

        system_waiting_time /= totalExecutions;
        System.out.println("Medium system waiting time: "+ system_waiting_time);

        System.out.println("--------------------------------------");

        for (Task t : tasks) {
            system_turnaround_time += t.getTurnaround_time();

            float medium = (float) t.getTurnaround_time() / t.getExecutions();

            System.out.println("Medium turnaround time task "+
                    t.getIndex() +": " +medium);
        };

        System.out.println("--------------------------------------");

        system_turnaround_time /= totalExecutions;
        System.out.println("Medium system turnaround time: "+ system_turnaround_time);

        System.out.println("--------------------------------------");

        deadListToString();

        System.out.println("--------------------------------------");

            for (Task t: tasks) {
                System.out.println("Task "+t.getIndex()+" lost the deadline "+t.getDeadline_loss()+
                        " time(s) among "+t.getExecutions()+" executions");
            }

        }

    }

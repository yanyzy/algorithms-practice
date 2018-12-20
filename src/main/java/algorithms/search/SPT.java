package algorithms.search;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2018/11/8 下午5:48
 */
public class SPT {

    public Task[] spt(Task[] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            for (int j = 0; j < tasks.length - i - 1; j++) {
                if (tasks[j].getSeconds() > tasks[j + 1].getSeconds()) {
                    Task temp = tasks[j];
                    tasks[j] = tasks[j + 1];
                    tasks[j + 1] = temp;
                }
            }
        }
        return tasks;
    }

    public static void main(String[] args) {
        Task task1 = new Task("task1", 1000);
        Task task2 = new Task("task2", 2000);
        Task task3 = new Task("task3", 500);
        Task[] tasks = new Task[]{task1, task2, task3};
        System.out.println(Arrays.toString(new SPT().spt(tasks)));
    }
}


class Task {
    private String name;
    private int seconds;

    public Task(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String toString() {
        return this.name + ":" + this.seconds;
    }

}

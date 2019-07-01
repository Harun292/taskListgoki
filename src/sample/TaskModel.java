package sample;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class TaskModel {
    ObservableList<Task> tasks = FXCollections.observableArrayList();
    ObjectProperty<Task> currentTask = new SimpleObjectProperty<>();

    public TaskModel() {
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ObservableList<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getCurrentTask() {
        return currentTask.get();
    }

    public ObjectProperty<Task> currentTaskProperty() {
        return currentTask;
    }

    public void setCurrentTask(Task currentTask) {
        this.currentTask.set(currentTask);
    }

    public void initiate() {
        tasks.add(new Task("Buy Milk", "Go buy some milk", LocalDate.now()));
        tasks.add(new Task("Learn", "Go to college",LocalDate.now()));
        tasks.add(new Task("Exercise", "Hit the gym",LocalDate.now()));
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.removeAll(task);
    }
}

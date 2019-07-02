package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ListView<Task> taskList;
    public TextField taskNameField;
    public TextArea taskTextArea;
    public DatePicker taskDueField;
    private TaskModel model;

    Controller(TaskModel model) { this.model = model;}

    public void removeTask(ActionEvent actionEvent) {
        model.removeTask(taskList.getSelectionModel().getSelectedItem());
        taskList.refresh();
    }

    public void addTask(ActionEvent actionEvent) {
        model.addTask(new Task());
        taskList.getSelectionModel().selectLast();
        model.setCurrentTask(taskList.getSelectionModel().getSelectedItem());
        taskList.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        taskList.setItems(model.getTasks());
        model.setCurrentTask(model.getTasks().get(0));
        taskTextArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(taskNameField.getText().isEmpty())
                    taskNameField.getStyleClass().addAll("nijeValidna");
                else
                    taskNameField.getStyleClass().removeAll("nijeValidna");
            }
        });
        taskNameField.textProperty().bindBidirectional(model.getCurrentTask().nameProperty());
        taskTextArea.textProperty().bindBidirectional(model.getCurrentTask().descriptionProperty());
        taskDueField.valueProperty().bindBidirectional(model.getCurrentTask().dueDateProperty());


        taskList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldTask, newTask) -> model.setCurrentTask(taskList.getSelectionModel().getSelectedItem()));

        model.currentTaskProperty().addListener((observableValue, oldTask, newTask) -> {
            if(oldTask != null) {
                taskNameField.textProperty().unbindBidirectional(oldTask.nameProperty());
                taskTextArea.textProperty().unbindBidirectional(oldTask.descriptionProperty());
                taskDueField.valueProperty().unbindBidirectional(oldTask.dueDateProperty());
            }
            if(newTask == null) {
                taskNameField.setText("");
                taskTextArea.setText("");
                taskDueField.setValue(LocalDate.now());
            }
            else {
                taskNameField.textProperty().bindBidirectional(newTask.nameProperty());
                taskTextArea.textProperty().bindBidirectional(newTask.descriptionProperty());
                taskDueField.valueProperty().bindBidirectional(newTask.dueDateProperty());
            }
        });

    }
    private boolean validacija(){
        if(taskNameField.getText().isEmpty())
            return true;
        return false;
    }

}

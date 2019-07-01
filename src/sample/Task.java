package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Task {
    SimpleStringProperty name;
    SimpleStringProperty description;
    SimpleObjectProperty<LocalDate> dueDate;

    public Task(String name, String description, LocalDate localDate) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleObjectProperty<>(localDate);
    }

    public Task() {
        this.name = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
        this.dueDate = new SimpleObjectProperty<>(LocalDate.now());
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public LocalDate getDueDate() {
        return dueDate.get();
    }

    public SimpleObjectProperty<LocalDate> dueDateProperty() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate.set(dueDate);
    }

    @Override
    public String toString(){
        return getName();
    }
}

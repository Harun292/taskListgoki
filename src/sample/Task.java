package sample;

import javafx.beans.property.SimpleStringProperty;

public class Task {
    SimpleStringProperty name;
    SimpleStringProperty description;

    public Task(String name, String description) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
    }

    public Task() {
        this.name = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
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

    @Override
    public String toString(){
        return getName();
    }
}

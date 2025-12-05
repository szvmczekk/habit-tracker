package pl.habittracker.tracker.dto;

public class TaskSaveDto {
    private String name;
    private String description;

    public TaskSaveDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TaskSaveDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

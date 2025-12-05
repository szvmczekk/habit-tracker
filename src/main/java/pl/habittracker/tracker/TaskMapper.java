package pl.habittracker.tracker;

import org.springframework.stereotype.Service;
import pl.habittracker.tracker.dto.TaskSaveDto;

@Service
public class TaskMapper {

    public Task map(TaskSaveDto taskDto){
        return new Task(taskDto.getName(), taskDto.getDescription());
    }
}

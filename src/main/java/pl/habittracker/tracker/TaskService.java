package pl.habittracker.tracker;

import org.springframework.stereotype.Service;
import pl.habittracker.tracker.dto.TaskSaveDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    Optional<Task> findTaskById(Long id){
        return taskRepository.findById(id);
    }

    List<Task> findAllTasks(){
        List<Task> taskList = new ArrayList<>();
        taskRepository.findAll().forEach(taskList::add);
        return taskList;
    }

    void save(TaskSaveDto taskToSave){
        Task mappedTask = taskMapper.map(taskToSave);
        taskRepository.save(mappedTask);
    }


}

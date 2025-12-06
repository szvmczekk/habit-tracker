package pl.habittracker.tracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.habittracker.tracker.dto.TaskSaveDto;

@Controller
public class TaskController {
    private final TaskService taskService;
    private final static TaskSaveDto taskSkeleton = new TaskSaveDto();

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/change/{id}")
    String changeState(@PathVariable Long id){
        taskService.changeState(id);
        return "redirect:/";
    }

    @GetMapping("/")
    String home(Model model){
        model.addAttribute("tasks", taskService.findAllTasks());
        return "index";
    }

    @GetMapping("/add")
    String addTaskPage(Model model){
        model.addAttribute("task", taskSkeleton);
        return "add";
    }

    @PostMapping("/add")
    String addTask(@ModelAttribute TaskSaveDto task){
        taskService.save(task);
        return "redirect:/";
    }
}

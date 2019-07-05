package com.dmarchante.taskmaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/tasks")
    public Iterable<Tasks> getTasks(Model m) {
        Iterable<Tasks> tasks = taskRepository.findAll();
        return tasks;
    }

    @PostMapping("/tasks")
    public Tasks postTasks(String assignee, String description, String status, String title) {
        Tasks task = new Tasks();
        task.setAssignee(assignee);
        task.setDescription(description);
        task.setStatus(status);
        task.setTitle(title);

        taskRepository.save(task);
        return task;
    }

    @PutMapping("/tasks/{id}/state")
    public Tasks updateStatus(@PathVariable UUID id) {
        Tasks task = taskRepository.findById(id).get();

        if (task.getStatus().equals("Available")) {
            task.setStatus("Assigned");
        } else if (task.getStatus().equals("Assigned")) {
            task.setStatus("Accepted");
        } else {
            task.setStatus("Finished");
        }

        taskRepository.save(task);
        return task;
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<UUID> deleteTask(@PathVariable UUID id) {
        taskRepository.deleteById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/users/{name}/tasks")
    public List<Tasks> getAssigneeTasks(@PathVariable String name) {
        return taskRepository.findByAssignee(name);
    }

    @PutMapping("/tasks/{id}/assign/{assignee}")
    public Tasks setAssignee(@PathVariable UUID id, @PathVariable String assignee) {
        Tasks task = taskRepository.findById(id).get();

        task.setAssignee(assignee);

        taskRepository.save(task);
        return task;
    }

    // Integrate with Thymeleaf views

    //    @GetMapping("/tasks")
    //    public Iterable<Tasks> getTasks(Model m) {
    //        Iterable<Tasks> tasks = taskRepository.findAll();
    //        m.addAttribute("tasks", tasks);
    //        m.addAttribute("test", "test");
    //        return tasks;
    //    }


    //    @PostMapping("/tasks")
    //    public RedirectView postTasks(String description, String status, String title) {
    //        Tasks task = new Tasks();
    //        task.setDescription(description);
    //        task.setStatus(status);
    //        task.setTitle(title);
    //
    //        taskRepository.save(task);
    //        return new RedirectView("/tasks");
    //    }

    //    @PutMapping("/tasks/{id}/state")
    //    public RedirectView updateStatus(@PathVariable UUID id, Model m) {
    //        Tasks task = taskRepository.findById(id).get();
    //
    //        if (task.getStatus().equals("Available")) {
    //            task.setStatus("Assigned");
    //        } else if (task.getStatus().equals("Assigned")) {
    //            task.setStatus("Accepted");
    //        } else {
    //            task.setStatus("Finished");
    //        }
    //
    //        taskRepository.save(task);
    //        m.addAttribute("task", task);
    //        return new RedirectView("/tasks");
    //    }

    //    @GetMapping("/task/status")
    //    public String newStatus(Model m) {
    //        Tasks task = taskRepository.findById(id).get();
    //
    //    }
}

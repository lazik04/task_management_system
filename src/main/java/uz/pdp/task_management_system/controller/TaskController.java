package uz.pdp.task_management_system.controller;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.task_management_system.dao.TaskDao;
import uz.pdp.task_management_system.dto.TaskDto;
import uz.pdp.task_management_system.service.TaskService;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskDao taskDao;
    private final TaskService taskService;

    @GetMapping("/tasks")
    public ModelAndView tasks(ModelAndView modelAndView) {
        modelAndView.addObject("tasks", taskDao.getAll());
        modelAndView.setViewName("tasks");
        return modelAndView;
    }
    @PostMapping("/tasks")
    public ModelAndView tasks(ModelAndView modelAndView,@RequestParam("stat") String status) {
        if("By Deadline".equals(status)){
            modelAndView.addObject("tasks", taskService.sortByDeadline(taskDao.getAll()));
        } else {
            modelAndView.addObject("tasks", taskService.sortByStatus(taskDao.getAll()));
        }
        modelAndView.setViewName("tasks");
        return modelAndView;
    }
    @GetMapping("/tasks/add")
    public String add() {
        return "add_task";
    }
    @PostMapping("/tasks/add")
    public ModelAndView add(ModelAndView modelAndView,
                            @RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("deadline") String deadline,
                            @RequestParam("stat") String status) {
        taskDao.save(title,description,deadline,status);
        modelAndView.setViewName("redirect:/tasks");
        return modelAndView;
    }

    @GetMapping("/tasks/read/{id}")
    public ModelAndView read(ModelAndView modelAndView, @PathVariable("id") Long id){
        modelAndView.addObject("task",taskDao.getById(id));
        modelAndView.setViewName("read");
        return modelAndView;
    }
    @GetMapping("/tasks/delete/{id}")
    public ModelAndView delete1( ModelAndView modelAndView,@PathVariable("id") Long id){
        modelAndView.addObject("task",taskDao.getById(id));
        modelAndView.setViewName("delete");
        return modelAndView;

    }
    @GetMapping("/tasks/status/{id}")
    public ModelAndView status1( ModelAndView modelAndView,@PathVariable("id") Long id){
        modelAndView.addObject("id",id);
        modelAndView.setViewName("status");
        return modelAndView;

    }

    @PostMapping("/tasks/delete/")
    public ModelAndView delete(ModelAndView modelAndView,@RequestParam("id")Long id){
        taskDao.delete(id);
        modelAndView.setViewName("redirect:/tasks");
        return modelAndView;
    }
    @PostMapping("/tasks/status/")
    public ModelAndView status(ModelAndView modelAndView, @RequestParam("id") Long id,@RequestParam("stat") String status){
        taskDao.changeStatus(status, id);
        modelAndView.setViewName("redirect:/tasks");
        return modelAndView;
    }

}

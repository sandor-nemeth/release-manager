/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.releasemanager.api;

import org.releasemanager.domain.Task;
import org.releasemanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sandornemeth
 */
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    
    @Autowired private TaskRepository taskRepository;
    
    @RequestMapping(method = {RequestMethod.GET})
    public Iterable<Task> showAll() {
        return taskRepository.findAll();
    }
    
    @RequestMapping("/{taskId}")
    public Task show(@PathVariable Long taskId) {
        return taskRepository.findOne(taskId);
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.releasemanager.api;

import org.dozer.Mapper;
import org.releasemanager.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;


/**
 *
 * @author sandornemeth
 */
@Component
public class TaskResourceAssembler extends ResourceAssemblerSupport<Task, TaskResource>{

    @Autowired 
    private Mapper mapper;
    
    public TaskResourceAssembler() {
        super(TaskController.class, TaskResource.class);
    }

    @Override
    protected TaskResource instantiateResource(Task entity) {
        return mapper.map(entity, TaskResource.class);
    }

    @Override
    public TaskResource toResource(Task entity) {
        TaskResource resource = createResourceWithId(entity.getId(), entity);
        return resource;
    }
    
}

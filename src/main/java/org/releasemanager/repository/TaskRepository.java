/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.releasemanager.repository;

import org.releasemanager.domain.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author sandornemeth
 */
public interface TaskRepository extends PagingAndSortingRepository<Task, Long>{
    
}

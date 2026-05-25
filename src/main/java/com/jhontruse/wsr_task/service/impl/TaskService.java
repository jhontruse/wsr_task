package com.jhontruse.wsr_task.service.impl;

import com.jhontruse.wsr_task.model.entity.Task;
import com.jhontruse.wsr_task.repository.ITaskRepository;
import com.jhontruse.wsr_task.service.ITaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        log.info("Obteniendo todos los tasks");
        List<Task> tasks = taskRepository.findAll();
        if (tasks == null) {
            return tasks;
        }
        return tasks;
    }
}

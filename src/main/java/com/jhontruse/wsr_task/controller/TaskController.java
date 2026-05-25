package com.jhontruse.wsr_task.controller;

import com.jhontruse.wsr_task.model.entity.Task;
import com.jhontruse.wsr_task.service.impl.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${server.servlet.context-path.task}")
@Tag(name = "TASK", description = "Gestión de task del sistema")
@SecurityRequirement(name = "bearerAuth")
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "Listar todos los tasks")
    @GetMapping("${server.servlet.context-path.task.fin.all}")
    public ResponseEntity<List<Task>> findAll() {
        log.debug("GET /menu/find/all");
        return ResponseEntity.ok(taskService.findAll());
    }

}

package com.jhontruse.wsr_task.controller;

import com.jhontruse.wsr_task.model.entity.Task;
import com.jhontruse.wsr_task.model.records.GenericRespondePage;
import com.jhontruse.wsr_task.model.records.TaskResponse;
import com.jhontruse.wsr_task.service.impl.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<TaskResponse>> findAll() {
        log.info("TaskController - findAll ");
        return ResponseEntity.ok(taskService.findAll());
    }

    @Operation(summary = "Listar todos los tasks")
    @GetMapping("/find")
    public ResponseEntity<GenericRespondePage<TaskResponse>> findTaskByTitulo(
            @RequestParam String titulo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ) {
        log.info("TaskController - findTaskByTitulo ");
        log.info("titulo : {} ", titulo);
        log.info("page : {} ", page);
        log.info("size : {} ", size);
        return ResponseEntity.ok(taskService.findTaskByTitulo(titulo, page, size));
    }

    @Operation(summary = "Listar todos los tasks")
    @GetMapping("/find/titulo")
    public ResponseEntity<GenericRespondePage<TaskResponse>> findTaskByTituloContainingIgnoreCase(
            @RequestParam String titulo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ) {
        log.info("TaskController - findTaskByTituloContainingIgnoreCase ");
        log.info("titulo : {} ", titulo);
        log.info("page : {} ", page);
        log.info("size : {} ", size);
        return ResponseEntity.ok(taskService.findTaskByTituloContainingIgnoreCase(titulo, page, size));
    }

}

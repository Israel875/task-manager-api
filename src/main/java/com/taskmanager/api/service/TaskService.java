package com.taskmanager.api.service;

import com.taskmanager.api.dto.TaskMapper;
import com.taskmanager.api.dto.TaskRequestDTO;
import com.taskmanager.api.dto.TaskResponseDTO;
import com.taskmanager.api.entity.Task;
import com.taskmanager.api.entity.TaskStatus;
import com.taskmanager.api.exception.ResourceNotFoundException;
import com.taskmanager.api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskResponseDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }

    public TaskResponseDTO findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task não encontrada com id: " + id));
        return TaskMapper.toResponse(task);
    }

    public TaskResponseDTO create(TaskRequestDTO dto) {
        Task task = TaskMapper.toEntity(dto);
        return TaskMapper.toResponse(taskRepository.save(task));
    }

    public TaskResponseDTO update(Long id, TaskRequestDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task não encontrada com id: " + id));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        return TaskMapper.toResponse(taskRepository.save(task));
    }

    public void delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task não encontrada com id: " + id));
        taskRepository.delete(task);
    }

    public List<TaskResponseDTO> findByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status)
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }
}

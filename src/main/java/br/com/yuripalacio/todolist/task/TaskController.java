package br.com.yuripalacio.todolist.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yuripalacio.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {
  @Autowired
  private ITaskRepository taskRepository;

  @PostMapping("/")
  public ResponseEntity<Object> create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
    var idUser = request.getAttribute("idUser");

    taskModel.setIdUser((UUID) idUser);

    var currentDate = LocalDateTime.now();

    if (currentDate.isAfter(taskModel.getStartAt())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body("Start date should be greater than current date");
    }
    
    if (taskModel.getEndAt().isBefore(taskModel.getStartAt())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body("End date should be greater than start date");
    }

    var task = this.taskRepository.save(taskModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(task);
  }

  @GetMapping("/")
  public ResponseEntity<List<TaskModel>> list(HttpServletRequest request) {
    var idUser = request.getAttribute("idUser");
  
    var tasks = this.taskRepository.findByIdUser((UUID) idUser);

    return ResponseEntity.status(HttpStatus.OK).body(tasks);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable UUID id) {
    var task = this.taskRepository.findById(id).orElse(null);

    if (task == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task does not found.");
    }

    var idUser = request.getAttribute("idUser");

    if (!task.getIdUser().equals(idUser)) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This user is not the owner of that task");
    }

    Utils.copyNonNullProperties(taskModel, task);

    return ResponseEntity.status(HttpStatus.OK).body(this.taskRepository.save(task));
  }
}

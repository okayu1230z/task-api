package lupinus.com.workengagement.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lupinus.com.workengagement.domain.entity.Task;
import lupinus.com.workengagement.domain.respository.TaskRepository;
import org.springframework.stereotype.Service;

/**
 * タスクに関するユースケースを表現するサービス.
 */
@Service
@RequiredArgsConstructor
public class TaskService {
  private final TaskRepository taskRepository;

  /**
   * 全てのタスクを検索する.
   */
  public List<Task> findAll() {
    return taskRepository.findAll();
  }
}
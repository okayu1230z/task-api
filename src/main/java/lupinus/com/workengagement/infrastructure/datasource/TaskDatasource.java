package lupinus.com.workengagement.infrastructure.datasource;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lupinus.com.workengagement.domain.entity.Task;
import lupinus.com.workengagement.domain.respository.TaskRepository;
import lupinus.com.workengagement.infrastructure.datasource.dto.TaskDto;
import lupinus.com.workengagement.infrastructure.datasource.mapper.TaskMapper;
import org.springframework.stereotype.Repository;

/**
 * taskに関するデータベース操作.
 */
@Repository
@RequiredArgsConstructor
public class TaskDatasource implements TaskRepository {
  private final TaskMapper taskMapper;

  /**
   * すべてのtaskを検索する.
   *
   * @return taskの配列.
   */
  @Override
  public List<Task> findAll() {
    List<TaskDto> taskDtos = taskMapper.selectAll();
    List<Task> tasks = taskDtos.stream().map(TaskDto::toEntity).collect(Collectors.toList());
    return tasks;
  }
}

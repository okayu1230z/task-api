package lupinus.com.workengagement.presentation.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lupinus.com.workengagement.domain.entity.Task;

/**
 * タスクに関するDTO.
 */
@Data
@Builder
public class TaskResponseDto {
  private final int id;
  private final String taskDesc;
  private final boolean done;
  private final LocalDateTime createdAt;
  private final LocalDateTime updatedAt;

  /**
   * ドメインモデルに変換する.
   *
   * @param task taskオブジェクト
   * @return taskに関するDTOオブジェクト
   */
  public static TaskResponseDto from(Task task) {
    return new TaskResponseDto(task.getId().toInteger(), task.getTaskDesc().toString(),
        task.getDone().toBoolean(), task.getCreatedAt(), task.getUpdatedAt());
  }
}
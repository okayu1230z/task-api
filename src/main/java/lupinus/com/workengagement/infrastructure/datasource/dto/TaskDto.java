package lupinus.com.workengagement.infrastructure.datasource.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lupinus.com.workengagement.domain.entity.Task;
import lupinus.com.workengagement.domain.type.Done;
import lupinus.com.workengagement.domain.type.Id;
import lupinus.com.workengagement.domain.type.TaskDesc;

/**
 * タスクに関するDTO.
 */
@Data
@Builder
public class TaskDto {
  private final int id;
  private final String taskDesc;
  private final boolean done;
  private final LocalDateTime createdAt;
  private final LocalDateTime updatedAt;

  /**
   * ドメインモデルに変換する.
   *
   * @return taskオブジェクト
   */
  public Task toEntity() {
    return Task.of(Id.from(id), TaskDesc.from(taskDesc), Done.from(done), createdAt, updatedAt);
  }
}
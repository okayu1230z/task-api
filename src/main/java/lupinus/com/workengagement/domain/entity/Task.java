package lupinus.com.workengagement.domain.entity;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lupinus.com.workengagement.domain.type.Done;
import lupinus.com.workengagement.domain.type.Id;
import lupinus.com.workengagement.domain.type.TaskDesc;

/**
 * タスクに関するエンティティ.
 */
@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Task {
  private final Id id;
  private final TaskDesc taskDesc;
  private final Done done;
  private final LocalDateTime createdAt;
  private final LocalDateTime updatedAt;

  /**
   * ファクトリメソッド.
   *
   * @param id        task識別子
   * @param taskDesc  task詳細
   * @param done      taskをやったかどうか
   * @param createdAt 作成時間
   * @param updatedAt 更新時間
   * @return taskオブジェクト
   */
  public static Task of(
      Id id,
      TaskDesc taskDesc,
      Done done,
      LocalDateTime createdAt,
      LocalDateTime updatedAt
  ) {
    return new Task(id, taskDesc, done, createdAt, updatedAt);
  }
}
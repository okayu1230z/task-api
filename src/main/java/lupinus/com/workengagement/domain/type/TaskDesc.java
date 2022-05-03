package lupinus.com.workengagement.domain.type;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * taskの詳細を表す値オブジェクト.
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class TaskDesc {
  private final String value;

  public static TaskDesc from(String taskDesc) {
    return new TaskDesc(taskDesc);
  }

  @Override
  public String toString() {
    return this.value;
  }
}

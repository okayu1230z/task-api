package lupinus.com.workengagement.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lupinus.com.workengagement.domain.entity.Task;

/**
 * すべてのtaskを返却するレスポンス.
 */
public class TasksResponse {
  @JsonValue
  public static Map<String, Object> toMapForJson(List<Task> tasks) {
    Map<String, Object> response = new HashMap<>();
    List<TaskResponseDto> taskDtos =
        tasks.stream().map(TaskResponseDto::from).collect(Collectors.toList());
    response.put("tasks", taskDtos);
    return response;
  }
}
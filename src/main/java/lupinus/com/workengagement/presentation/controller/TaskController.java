package lupinus.com.workengagement.presentation.controller;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lupinus.com.workengagement.application.service.TaskService;
import lupinus.com.workengagement.domain.entity.Task;
import lupinus.com.workengagement.presentation.dto.TasksResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * taskに関するコントローラ.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class TaskController {
  private final TaskService taskService;

  /**
   * すべてのtaskを検索する.
   *
   * @return 検索結果のオブジェクト.
   */
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Map> getAllTask() {
    List<Task> tasks = taskService.findAll();
    return new ResponseEntity<>(TasksResponse.toMapForJson(tasks), HttpStatus.OK);
  }
}

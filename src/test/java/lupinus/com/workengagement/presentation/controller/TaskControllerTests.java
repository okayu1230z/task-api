package lupinus.com.workengagement.presentation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import lupinus.com.workengagement.application.service.TaskService;
import lupinus.com.workengagement.domain.entity.Task;
import lupinus.com.workengagement.domain.type.Done;
import lupinus.com.workengagement.domain.type.Id;
import lupinus.com.workengagement.domain.type.TaskDesc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootTest
@EnableWebMvc
@DisplayName("tasksのテスト")
public class TaskControllerTests {

  private MockMvc mockMvc;

  @Autowired
  TaskController taskController;

  @MockBean
  private TaskService taskService;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(new TaskController(taskService)).build();
  }

  @Nested
  class 正常系テスト {

    @Test
    public void 全てのタスクを検索() throws Exception {
      List<Task> tasks = Arrays.asList(Task.of(Id.from(1), TaskDesc.from(""), Done.from(true),
          LocalDateTime.now(), LocalDateTime.now()));
      doReturn(tasks).when(taskService).findAll();
      mockMvc.perform(get("/v1/")).andExpect(status().is(200));
    }
  }
}

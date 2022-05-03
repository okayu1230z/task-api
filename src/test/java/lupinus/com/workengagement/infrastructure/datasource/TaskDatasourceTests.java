package lupinus.com.workengagement.infrastructure.datasource;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.util.AssertionErrors.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import javax.sql.DataSource;
import lupinus.com.workengagement.domain.entity.Task;
import lupinus.com.workengagement.domain.respository.TaskRepository;
import lupinus.com.workengagement.domain.type.Done;
import lupinus.com.workengagement.domain.type.Id;
import lupinus.com.workengagement.domain.type.TaskDesc;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.CsvDataFileLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

@SpringBootTest
@DisplayName("DBアクセステスト")
public class TaskDatasourceTests {
  @Autowired
  private DataSource dataSource;
  private DataSourceDatabaseTester dataSourceDatabaseTester;
  private CsvDataFileLoader csvDataFileLoader;
  @Autowired
  private TaskRepository taskRepository;

  @BeforeEach
  public void setup() {
    dataSourceDatabaseTester = new DataSourceDatabaseTester(dataSource);
    dataSourceDatabaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
    csvDataFileLoader = new CsvDataFileLoader();
    try {
      dataSourceDatabaseTester
          .setDataSet(csvDataFileLoader.loadDataSet(ResourceUtils.getURL("classpath:scinario/")));
      System.out.println(dataSourceDatabaseTester);
      System.out.println(dataSourceDatabaseTester.getDataSet());
      dataSourceDatabaseTester.onSetup();
    } catch (Exception e) {
      fail();
    }
  }

  @Nested
  class 正常系 {

    @Test
    public void すべてのtaskを検索する() {
      List<Task> tasks = taskRepository.findAll();
      Task task = Task.of(Id.from(1), TaskDesc.from("買い物にいく"), Done.from(false), LocalDateTime
          .of(2020, 12, 20, 10, 20, 10), LocalDateTime
          .of(2020, 12, 20, 10, 20, 10));
      List<Task> expectedTasks = Arrays.asList(task);
      assertEquals("すべてのtaskを検索する", expectedTasks, tasks);
    }
  }
}

package lupinus.com.workengagement.domain.respository;

import java.util.List;
import lupinus.com.workengagement.domain.entity.Task;

/**
 * taskに関するI/Fを定義したリポジトリ.
 */
public interface TaskRepository {
  List<Task> findAll();
}

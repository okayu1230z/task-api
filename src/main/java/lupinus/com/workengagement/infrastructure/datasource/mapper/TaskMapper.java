package lupinus.com.workengagement.infrastructure.datasource.mapper;

import java.util.List;
import lupinus.com.workengagement.infrastructure.datasource.dto.TaskDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * taskに関するMapper.
 */
@Mapper
public interface TaskMapper {
  List<TaskDto> selectAll();
}

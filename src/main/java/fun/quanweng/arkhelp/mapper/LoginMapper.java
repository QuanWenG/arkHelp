package fun.quanweng.arkhelp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.quanweng.arkhelp.pojo.entity.UserTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<UserTable> {
}

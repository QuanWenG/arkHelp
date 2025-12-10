package fun.quanweng.arkhelp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.quanweng.arkhelp.pojo.entity.UserInfoTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoTable> {
}

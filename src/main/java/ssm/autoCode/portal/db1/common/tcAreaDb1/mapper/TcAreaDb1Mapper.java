package ssm.autoCode.portal.db1.common.tcAreaDb1.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;


import ssm.autoCode.portal.db1.common.tcAreaDb1.model.TcAreaDb1;

public interface TcAreaDb1Mapper {
    int deleteByPrimaryKey(TcAreaDb1 countyCode);

    int insert(TcAreaDb1 record);

    int insertSelective(TcAreaDb1 record);

    TcAreaDb1 selectByPrimaryKey(TcAreaDb1 countyCode);

    int updateByPrimaryKeySelective(TcAreaDb1 record);

    int updateByPrimaryKey(TcAreaDb1 record);


	List<TcAreaDb1> selectList(TcAreaDb1 record);

	int countAll(TcAreaDb1 record);

	List<TcAreaDb1> selectPage(@Param("record") TcAreaDb1 record, @Param("pageNo") Integer pageNum, @Param("pageSize") Integer pageSize);

	String getMaxId(String code);

}


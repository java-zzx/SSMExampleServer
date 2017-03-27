package ssm.autoCode.portal.db2.common.tcAreaDb2.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;


import ssm.autoCode.portal.db2.common.tcAreaDb2.model.TcAreaDb2;

public interface TcAreaDb2Mapper {
    int deleteByPrimaryKey(TcAreaDb2 countyCode);

    int insert(TcAreaDb2 record);

    int insertSelective(TcAreaDb2 record);

    TcAreaDb2 selectByPrimaryKey(TcAreaDb2 countyCode);

    int updateByPrimaryKeySelective(TcAreaDb2 record);

    int updateByPrimaryKey(TcAreaDb2 record);


	List<TcAreaDb2> selectList(TcAreaDb2 record);

	int countAll(TcAreaDb2 record);

	List<TcAreaDb2> selectPage(@Param("record") TcAreaDb2 record, @Param("pageNo") Integer pageNum, @Param("pageSize") Integer pageSize);

	String getMaxId(String code);

}


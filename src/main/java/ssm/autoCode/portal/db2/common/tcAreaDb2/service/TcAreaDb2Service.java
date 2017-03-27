package ssm.autoCode.portal.db2.common.tcAreaDb2.service;

import org.mybatis.generator.zzx.createFile.initmvc.page.PageSupport;
import ssm.autoCode.portal.db2.common.tcAreaDb2.mapper.TcAreaDb2Mapper;
import ssm.autoCode.portal.db2.common.tcAreaDb2.model.TcAreaDb2;
import org.mybatis.generator.zzx.createFile.initmvc.utils.CommonUtils;
import org.mybatis.generator.zzx.createFile.initmvc.utils.Contant;
import org.mybatis.generator.zzx.createFile.initmvc.utils.DateUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @des 例子
 * @author 蜘蛛侠
 * @qq 892508823
 * @notice 不可用于商用，后果自负
 */
@Service
public class TcAreaDb2Service  {
    @Autowired
    TcAreaDb2Mapper tcAreaDb2Mapper;
    public int create(TcAreaDb2 record){
    	//String code = "A"+DateUtils.getToDay();
    	//String recordId = getNextId(code);
    	//record.setCountyCode(recordId);
    	return tcAreaDb2Mapper.insertSelective(record);
    } 
    public int deleteByPrimaryKey(TcAreaDb2 key){
    	return tcAreaDb2Mapper.deleteByPrimaryKey(key); 
    } 
    public TcAreaDb2 selectByPrimaryKey(TcAreaDb2 key){
    	return tcAreaDb2Mapper.selectByPrimaryKey(key);
    }
    public int updateByPrimaryKeySelective(TcAreaDb2 record){
    	return tcAreaDb2Mapper.updateByPrimaryKeySelective(record);
    }
    public List<TcAreaDb2> selectList(TcAreaDb2 record){
    	return tcAreaDb2Mapper.selectList(record);
    }
    public PageSupport<TcAreaDb2> queryPage(TcAreaDb2 record, int pageNo,int pageSize){
    	int count = tcAreaDb2Mapper.countAll(record);
    	PageSupport<TcAreaDb2> page = new PageSupport<TcAreaDb2>(pageSize,count, pageNo);
    	List<TcAreaDb2> tcAreaDb2List = new ArrayList<TcAreaDb2>();
    	tcAreaDb2List = tcAreaDb2Mapper.selectPage(record, page.getStartIndex(), page.getPageSize());
    	page.setData(tcAreaDb2List);
    	return page;
    }
    public String getNextId(String code){
    	String oldObtainId = tcAreaDb2Mapper.getMaxId(code);
    	int serialNumber = 0;
    	String serialNumberStr = "";
    	if(StringUtils.isBlank(oldObtainId)||("null".equals(oldObtainId))){
    		return code + Contant.digit_start_six;
    	}else{
    		int previousSerialNumber = Integer.valueOf(oldObtainId.substring(oldObtainId.length()-5, oldObtainId.length()));
    		serialNumber = previousSerialNumber + 1;
    		serialNumberStr = CommonUtils.numToLenStr(serialNumber,Contant.SIX);
    		return code + serialNumberStr;
    	}
    }
} 
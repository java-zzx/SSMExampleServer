package ssm.autoCode.portal.db1.common.tcAreaDb1.service;

import org.mybatis.generator.zzx.createFile.initmvc.page.PageSupport;
import ssm.autoCode.portal.db1.common.tcAreaDb1.mapper.TcAreaDb1Mapper;
import ssm.autoCode.portal.db1.common.tcAreaDb1.model.TcAreaDb1;
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
public class TcAreaDb1Service  {
    @Autowired
    TcAreaDb1Mapper tcAreaDb1Mapper;
    public int create(TcAreaDb1 record){
    	//String code = "A"+DateUtils.getToDay();
    	//String recordId = getNextId(code);
    	//record.setCountyCode(recordId);
    	return tcAreaDb1Mapper.insertSelective(record);
    } 
    public int deleteByPrimaryKey(TcAreaDb1 key){
    	return tcAreaDb1Mapper.deleteByPrimaryKey(key); 
    } 
    public TcAreaDb1 selectByPrimaryKey(TcAreaDb1 key){
    	return tcAreaDb1Mapper.selectByPrimaryKey(key);
    }
    public int updateByPrimaryKeySelective(TcAreaDb1 record){
    	return tcAreaDb1Mapper.updateByPrimaryKeySelective(record);
    }
    public List<TcAreaDb1> selectList(TcAreaDb1 record){
    	return tcAreaDb1Mapper.selectList(record);
    }
    public PageSupport<TcAreaDb1> queryPage(TcAreaDb1 record, int pageNo,int pageSize){
    	int count = tcAreaDb1Mapper.countAll(record);
    	PageSupport<TcAreaDb1> page = new PageSupport<TcAreaDb1>(pageSize,count, pageNo);
    	List<TcAreaDb1> tcAreaDb1List = new ArrayList<TcAreaDb1>();
    	tcAreaDb1List = tcAreaDb1Mapper.selectPage(record, page.getStartIndex(), page.getPageSize());
    	page.setData(tcAreaDb1List);
    	return page;
    }
    public String getNextId(String code){
    	String oldObtainId = tcAreaDb1Mapper.getMaxId(code);
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
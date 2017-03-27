package ssm.autoCode.portal.db1.common.tcAreaDb1.controller;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.mybatis.generator.zzx.createFile.initmvc.page.PageSupport;
import org.mybatis.generator.zzx.createFile.initmvc.res.ResObj;
import ssm.autoCode.portal.db1.common.tcAreaDb1.model.TcAreaDb1;
import ssm.autoCode.portal.db1.common.tcAreaDb1.service.TcAreaDb1Service;
import org.mybatis.generator.zzx.createFile.initmvc.utils.CommonUtils;
import org.mybatis.generator.zzx.createFile.initmvc.utils.Contant;
import java.util.List;
import javax.annotation.Resource;
/**
 * @des 例子
 * @author 蜘蛛侠
 * @qq 892508823
 * @notice 不可用于商用，后果自负
 */
@RestController
@ResponseBody
@RequestMapping(value = "tcAreaDb1")
public class TcAreaDb1Controller  {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private TcAreaDb1Service tcAreaDb1Service;
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ResObj insert(TcAreaDb1 record) {
    	try{
    		int num =  tcAreaDb1Service.create(record);
    		if(num>0){
    			return new ResObj(800,"插入成功",record,this.getClass().getName());
    		}else{
    			return new ResObj(900,"插入失败",null,this.getClass().getName());
    		}
    	}catch(Exception e){
    		logger.error("数据插入出错误错误如下：{}",e);
    		return new ResObj(900,"程序出错请联系管理员",null,this.getClass().getName());
    	}
    }
    @RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.POST)
    public ResObj deleteByPrimaryKey(TcAreaDb1 record) {
    	try{
    		TcAreaDb1 tcAreaDb1 = tcAreaDb1Service.selectByPrimaryKey(record);
    		if(null==tcAreaDb1){
   				 return new ResObj(900,"无对应数据",null,this.getClass().getName());
    		}
    		int num = tcAreaDb1Service.deleteByPrimaryKey(record);
    		if(num<1){
    			return new ResObj(900,"无对应数据删除",null,this.getClass().getName());
    		}else if(num>1){
    			return new ResObj(900,"删除多条记录，请联系管理员",null,this.getClass().getName());
    		}else{
    			return new ResObj(800,"成功",null,this.getClass().getName());
    		}
    	}catch(Exception e){
    		logger.error("数据插入出错误错误如下：{}",e);
    		return new ResObj(900,"程序出错请联系管理员",null,this.getClass().getName());
    	}
    }
    @RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST)
    public ResObj selectByPrimaryKey(TcAreaDb1 record) {
    	TcAreaDb1 tcAreaDb1 = tcAreaDb1Service.selectByPrimaryKey(record);
    	if(null==tcAreaDb1){
    		return new ResObj(900,"通过主键查询失败",null,this.getClass().getName());
    	}
    	return new ResObj(800,"成功",tcAreaDb1,this.getClass().getName());
    }
    @RequestMapping(value = "updateByPrimaryKeySelective", method = RequestMethod.POST)
    public ResObj updateByPrimaryKeySelective(TcAreaDb1 record) {
    		TcAreaDb1 tcAreaDb1 = tcAreaDb1Service.selectByPrimaryKey(record);
    		if(null==tcAreaDb1){
   				 return new ResObj(900,"无对应数据",null,this.getClass().getName());
    		}
    	int num = tcAreaDb1Service.updateByPrimaryKeySelective(record);
    	if(num<1){
    		return new ResObj(900,"无对应数据修改",null,this.getClass().getName());
    	}else if(num>1){
    		return new ResObj(900,"修改多条记录，请联系管理员",null,this.getClass().getName());
    	}else{
    		return new ResObj(800,"修改成功",null,this.getClass().getName());
    	}
    }
    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    public ResObj selectList(TcAreaDb1 record) {
    	List<TcAreaDb1> tcAreaDb1List = tcAreaDb1Service.selectList(record);
    	return new ResObj(800,"成功",tcAreaDb1List,this.getClass().getName());
    }
    @RequestMapping(value = "queryPage", method = RequestMethod.POST)
    public ResObj queryPage(TcAreaDb1 record, String pageNo,String pageSize) {
    	if(StringUtils.isBlank(pageNo)){
    		return new ResObj(900,"必传参数pageNo为空",null,this.getClass().getName());
    	}
    	if(!CommonUtils.checkNum(pageNo)){
    		return new ResObj(900,"必传参数pageNo类型不对",null,this.getClass().getName());
    	}
    	int pageNoI = Integer.valueOf(pageNo);
    	if(StringUtils.isBlank(pageSize)){
    		pageSize = Contant.ten_str;
    	}
    	if(!CommonUtils.checkNum(pageSize)){
    		return new ResObj(900,"必传参数pageSize类型不对",null,this.getClass().getName());
    	}
    	int pageSizeI = Integer.valueOf(pageSize);
   		PageSupport<TcAreaDb1> tcAreaDb1Page = tcAreaDb1Service.queryPage(record,pageNoI,pageSizeI);
    	return new ResObj(800,"成功",tcAreaDb1Page,this.getClass().getName());
    }
} 
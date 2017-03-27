package zzx.createFile;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.zzx.createFile.initmvc.FullCreateControllerFile;
import org.mybatis.generator.zzx.createFile.initmvc.FullCreateServiceFile;
import org.mybatis.generator.zzx.createFile.initmvc.FullUpdateMapperJavaFile;
import org.mybatis.generator.zzx.createFile.initmvc.FullUpdateMapperXMLFile;



/**
 * @des 生成xml、dao层方法
 * @author 蜘蛛侠 
 * @email 892508823@qq.com
 * @des 该工程仅用于技术研究，请勿商业使用，最终解释权归蜘蛛侠所有
 * */
public class TestCreateTcAreaDb1MainClass {

	public void generator() throws Exception{
		
		//创建一个警告列表，整个MBG运行过程中的所有警告信息都放在这个列表中，执行完成后统一System.out
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//得到generatorConfig.xml文件
		File configFile = new File("db/create_tc_area_db1.xml"); 
		//创建配置解析器
		ConfigurationParser cp = new ConfigurationParser(warnings);
		//调用配置解析器创建配置对象（Configuration对象非常简单，可以简单理解为包含两个列表，一个列表是List<Context> contexts，包含了解析出来的Context对象，一个是List<String> classPathEntries，包含了配置的classPathEntry的location值）
		Configuration config = cp.parseConfiguration(configFile);
		//创建一个默认的ShellCallback对象，之前说过，shellcallback接口主要用来处理文件的创建和合并，传入overwrite参数；默认的shellcallback是不支持文件合并的；
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		//创建一个MyBatisGenerator对象。MyBatisGenerator类是真正用来执行生成动作的类
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
		//初始化page支持类
		List<Context> contextList = config.getContexts();
		Context context = contextList.get(0);
		JavaModelGeneratorConfiguration modelC = context.getJavaModelGeneratorConfiguration();
		
		//再次续写XMl
		FullUpdateMapperXMLFile.createServiceFile(configFile);
		//续写mapper。java
		FullUpdateMapperJavaFile.createServiceFile(configFile);
		//@TODO 需要创建对应的每个实体的service.只做初始化处理。
		FullCreateServiceFile.createServiceFile(configFile);
		//@TODO 需要创建对应的每个实体的service.只做初始化处理。
		FullCreateControllerFile.createControllerFile(configFile);
		//输出告警信息
		System.out.println(warnings.toString());
	} 
	public static void main(String[] args) throws Exception {
		try {
			TestCreateTcAreaDb1MainClass generatorSqlmap = new TestCreateTcAreaDb1MainClass();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

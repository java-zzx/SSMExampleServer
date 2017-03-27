package ssm.autoCode.portal.utils;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import net.sf.log4jdbc.sql.jdbcapi.ConnectionSpy;
import net.sf.log4jdbc.DriverSpy;
import net.sf.log4jdbc.SpyLogFactory;
import net.sf.log4jdbc.sql.rdbmsspecifics.MySqlRdbmsSpecifics;
import net.sf.log4jdbc.sql.rdbmsspecifics.RdbmsSpecifics;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @des log4j日志处理类，总感觉该类用处不大，续期需要研究优化处理
 * @author 蜘蛛侠
 * @qq 892508823
 * @notice 不可用于商用，后果自负
 */
public class DataSourceSpyInterceptor implements MethodInterceptor { 
	private  RdbmsSpecifics rdbmsSpecifics = null; 
	DriverSpy driverSpy = new DriverSpy();
	private RdbmsSpecifics getRdbmsSpecifics(Connection conn) { 
		if (rdbmsSpecifics == null) { 
			String driverName = "";
		    try
		    {
		      DatabaseMetaData dbm = conn.getMetaData();
		      driverName = dbm.getDriverName();
		    }
		    catch (SQLException s)
		    {
		      // silently fail
		    }

//		    log.debug("driver name is " + driverName);
		    MySqlRdbmsSpecifics mySql = new MySqlRdbmsSpecifics();
		    RdbmsSpecifics r = (RdbmsSpecifics) mySql;
		    return r;
		    
		} 
		return rdbmsSpecifics; 
	} 
	@Override public Object invoke(MethodInvocation invocation) throws Throwable { 
		Object result = invocation.proceed(); 
		if (SpyLogFactory.getSpyLogDelegator().isJdbcLoggingEnabled()) { 
			if (result instanceof Connection) { 
				Connection conn = (Connection) result; 
//				new ConnectionSpy(conn, getRdbmsSpecifics(conn));
				} 
			} 
		return result; 
		}
	}
package ssm.autoCode.portal.utils;

/**
 * @des
 * @author 蜘蛛侠
 * @qq 892508823
 * @notice 不可用于商用，后果自负
 */
public class SqlUtils {

    /**
     * 转换javaboolean与mysql的int值
     * @param intBoolean
     * @return
     */
    public static   boolean toBoolean(int intBoolean){
        return  intBoolean==1;
    }


    public  static int toInt(boolean booleanValue){
        return  booleanValue?1:0;
    }

}

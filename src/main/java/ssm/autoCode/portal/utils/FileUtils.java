package ssm.autoCode.portal.utils;

/**
 * @des  文件类型函数
 * @author 蜘蛛侠
 * @qq 892508823
 * @notice 不可用于商用，后果自负
 */
public class FileUtils {


    public static String getFileType(String fileName){
        int index = fileName.lastIndexOf(".");
        int length = fileName.length();
        String fileType = null;
        if( index == -1){
            fileType = "";
        }
        else {
            fileType =  fileName.substring(index,length);
        }
        return  fileType;


    }

}

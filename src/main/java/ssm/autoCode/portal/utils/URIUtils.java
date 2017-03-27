package ssm.autoCode.portal.utils;

import org.springframework.web.util.UriTemplate;
import org.springframework.web.util.UriUtils;

import java.net.URI;
import java.util.Objects;

/**
 * @des
 * @author 蜘蛛侠
 * @qq 892508823
 * @notice 不可用于商用，后果自负
 */
public class URIUtils {

    public static URI createURI(String url, Object... uriVariableValues) {
        return new UriTemplate(url).expand(uriVariableValues);
    }

}

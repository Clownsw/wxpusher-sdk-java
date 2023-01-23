package cn.smilex.wxpusher.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author smilex
 */
public final class CommonConfig {
    public static final String EMPTY_STRING = "";

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // 只进行已存在的字段序列化
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}

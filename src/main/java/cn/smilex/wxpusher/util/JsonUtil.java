package cn.smilex.wxpusher.util;

import cn.smilex.wxpusher.config.CommonConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;

import static cn.smilex.wxpusher.config.CommonConfig.OBJECT_MAPPER;

/**
 * @author smilex
 */
@SuppressWarnings("unused")
@Slf4j
public final class JsonUtil {

    /**
     * 解析JSON字符串并映射到指定类型
     *
     * @param jsonString json string
     * @param clazz      class
     * @param <T>        return value type
     * @return return value
     */
    public static <T> T parseByClass(String jsonString, Class<T> clazz) {
        return CommonUtil.tryRun(
                () -> OBJECT_MAPPER.readValue(jsonString, clazz),
                () -> null,
                e -> log.error("", e)
        );
    }

    /**
     * 解析JSON字符串并映射到指定类型
     *
     * @param jsonString    json string
     * @param typeReference typeReference
     * @param <T>           return value type
     * @return return value
     */
    public static <T> T parseByClass(String jsonString, TypeReference<T> typeReference) {
        return CommonUtil.tryRun(
                () -> OBJECT_MAPPER.readValue(jsonString, typeReference),
                () -> null,
                e -> log.error("", e)
        );
    }

    /**
     * 将对象序列化到JSON字符串
     *
     * @param object object
     * @return JSON字符串
     */
    public static String toJsonString(Object object) {
        return CommonUtil.tryRun(
                () -> OBJECT_MAPPER.writeValueAsString(object),
                () -> CommonConfig.EMPTY_STRING,
                e -> log.error("", e)
        );
    }
}

package cn.smilex.wxpusher.util;

import cn.smilex.req.HttpBodyBuilder;
import cn.smilex.req.HttpResponse;
import cn.smilex.wxpusher.entity.Result;
import cn.smilex.wxpusher.entity.ResultCode;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

/**
 * 说明：网络请求工具
 * 作者：zjiecode
 * 时间：2019-09-05
 */
@SuppressWarnings("unchecked")
public final class HttpUtils {
    private static final String BASE_URL = "http://wxpusher.zjiecode.com";
    private static final String CHARSET_NAME = "UTF-8";

    private HttpUtils() {
    }

    /**
     * 发送post请求
     *
     * @param data 发送的数据
     * @param path 请求后台的path
     * @return 发送的result结果
     */
    public static <T> Result<T> post(Object data, String path) {
        return CommonUtil.tryRun(
                () -> {
                    if (data == null) {
                        return new Result<>(ResultCode.UNKNOWN_ERROR, "数据为空");
                    }

                    HttpResponse httpResponse = RequestUtil.post(
                            buildUrl(path),
                            RequestUtil.REQUEST_JSON_HEADER,
                            HttpBodyBuilder.ofString(JsonUtil.toJsonString(data))
                    );

                    return dealConnect(httpResponse);
                },
                () -> null,
                e -> {
                }
        );
    }

    public static Result get(String path) {
        return get(null, path);
    }

    /**
     * 发送get请求
     */
    public static <T> Result<T> get(Map<String, Object> data, String path) {
        String url = buildUrl(path);
        String query = parseMap2Query(data);
        if (!query.isEmpty()) {
            url = url + "?" + query;
        }

        return dealConnect(
                RequestUtil.get(
                        url,
                        RequestUtil.REQUEST_JSON_HEADER,
                        HttpBodyBuilder.ofString(query)
                )
        );
    }

    /**
     * 把map转成query查询字符串
     */
    private static String parseMap2Query(Map<String, Object> data) {
        if (data == null || data.size() <= 0) {
            return "";
        }
        Set<Map.Entry<String, Object>> entries = data.entrySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : entries) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return stringBuilder.toString();
    }

    /**
     *
     */
    private static String buildUrl(String path) {
        String url = BASE_URL;
        if (path != null && path.length() > 0) {
            if (path.startsWith("/")) {
                url = BASE_URL + path;
            } else {
                url = BASE_URL + "/" + path;
            }
        }
        return url;
    }

    /**
     * 处理连接以后的状态信息
     *
     * @param httpResponse 请求响应对象
     * @return 返回发送结果
     */
    private static <T> Result<T> dealConnect(HttpResponse httpResponse) {
        int responseCode = Integer.parseInt(httpResponse.getStatusCode());
        if (responseCode != 200) {
            return new Result<>(responseCode, "http请求错误:" + responseCode);
        }

        if (StringUtils.isBlank(httpResponse.getBody())) {
            return new Result<>(ResultCode.INTERNAL_SERVER_ERROR, "服务器返回异常");
        }

        Result<T> result = JsonUtil.parseByClass(httpResponse.getBody(), Result.class);
        if (result == null) {
            return new Result<>(ResultCode.DATA_ERROR, "服务器返回数据解析异常");
        }

        return result;
    }

    /**
     * 从输入流中读取内容到字符串
     *
     * @param inputStream 输入路
     * @return 返回字符串
     */
    private static String inputStream2String(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] bytes = new byte[4096];
        try {
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            return outputStream.toString(CHARSET_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

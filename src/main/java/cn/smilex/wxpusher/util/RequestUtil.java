package cn.smilex.wxpusher.util;

import cn.smilex.req.HttpBodyInterface;
import cn.smilex.req.HttpRequest;
import cn.smilex.req.HttpResponse;
import cn.smilex.req.Requests;
import cn.smilex.wxpusher.builder.HashMapBuilder;

import java.util.HashMap;

import static cn.smilex.req.Requests.REQUEST_METHOD.GET;
import static cn.smilex.req.Requests.REQUEST_METHOD.POST;

/**
 * @author smilex
 */
@SuppressWarnings("unused")
public final class RequestUtil {
    public static HashMap<String, String> REQUEST_JSON_HEADER = new HashMapBuilder<String, String>(1)
            .put("content-type", "application/json")
            .getValue();

    public static HttpResponse get(
            String url,
            HashMap<String, String> headers,
            HttpBodyInterface body
    ) {
        return req(url, GET, headers, body);

    }

    public static HttpResponse post(
            String url,
            HashMap<String, String> headers,
            HttpBodyInterface body
    ) {
        return req(url, POST, headers, body);
    }

    public static HttpResponse req(
            String url,
            Requests.REQUEST_METHOD method,
            HashMap<String, String> headers,
            HttpBodyInterface body
    ) {
        return Requests.requests.request(
                HttpRequest.build()
                        .setUrl(url)
                        .setMethod(method)
                        .setHeaders(headers)
                        .setBody(body)
        );
    }

    public static HttpResponse req(
            Requests.REQUEST_METHOD method,
            String url,
            HashMap<String, String> headers,
            HashMap<String, String> cookies,
            HttpBodyInterface body
    ) {
        return Requests.requests.request(
                HttpRequest.build()
                        .setUrl(url)
                        .setMethod(method)
                        .setHeaders(headers)
                        .setCookies(cookies)
                        .setBody(body)
        );
    }
}

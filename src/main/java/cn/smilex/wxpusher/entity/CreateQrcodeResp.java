package cn.smilex.wxpusher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 说明：创建带参数的app临时二维码
 * 作者：zjiecode
 * 时间：2019-09-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateQrcodeResp {
    private long expires;
    private String code;
    private String shortUrl;
    private String url;
    private String extra;
}

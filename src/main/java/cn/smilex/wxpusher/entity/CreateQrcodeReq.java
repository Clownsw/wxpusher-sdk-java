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
public class CreateQrcodeReq {
    //应用的apptoken
    private String appToken;
    //附带的数据
    private String extra;
    //二维码有效时间，s为单位，最大30天。
    private Integer validTime;
}

package cn.smilex.wxpusher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 说明：微信用户数据
 * 作者：zjiecode
 * 时间：2019-10-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxUser {
    private Integer id;
    private String uid;
    private Integer openId;
    private String userToken;
    private String nickName;
    private String headImg;
    private Integer sex;
    private Boolean enable;
    private Long createTime;
}

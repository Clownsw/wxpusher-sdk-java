package cn.smilex.wxpusher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 说明：
 * 作者：zjiecode
 * 时间：2019-09-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResult {
    private String uid;
    private Integer topicId;
    private Long messageId;
    private Long messageContentId;
    private Long sendRecordId;
    private Integer code;
    private String status;
}

package cn.smilex.wxpusher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 说明：分页数据
 * 作者：zjiecode
 * 时间：2019-10-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    private Integer total;
    private Integer page;
    private Integer pageSize;
    private List<T> records;
}

package cn.smilex.wxpusher.test;

import cn.smilex.wxpusher.WxPusher;
import cn.smilex.wxpusher.entity.Result;
import org.junit.Test;

/**
 * @author smilex
 */
public class TestQueryMessageStatus {

    @Test
    public void context() {
        Result<?> result = WxPusher.queryMessageStatus(553515196L);
        System.out.println(result);
    }

}

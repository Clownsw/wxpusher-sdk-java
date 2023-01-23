package cn.smilex.wxpusher.test;

import cn.smilex.wxpusher.WxPusher;
import cn.smilex.wxpusher.entity.Page;
import cn.smilex.wxpusher.entity.Result;
import cn.smilex.wxpusher.entity.WxUser;
import org.junit.Test;

/**
 * @author smilex
 */
public class TestQueryWxUser {

    @Test
    public void context() {
        Result<Page<WxUser>> result = WxPusher.queryWxUser(
                "AT_ef58mH4EIAgMKE2qJ4TAZpBwOOIncKGj",
                1,
                10
        );
        System.out.println(result);
    }
}

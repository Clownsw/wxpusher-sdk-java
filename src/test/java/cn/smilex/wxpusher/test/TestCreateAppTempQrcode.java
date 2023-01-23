package cn.smilex.wxpusher.test;

import cn.smilex.wxpusher.WxPusher;
import cn.smilex.wxpusher.entity.CreateQrcodeReq;
import cn.smilex.wxpusher.entity.CreateQrcodeResp;
import cn.smilex.wxpusher.entity.Result;
import org.junit.Test;

/**
 * @author smilex
 */
public class TestCreateAppTempQrcode {

    @Test
    public void context() {
        Result<CreateQrcodeResp> result = WxPusher.createAppTempQrcode(new CreateQrcodeReq(
                "AT_ef58mH4EIAgMKE2qJ4TAZpBwOOIncKGj",
                "aaa",
                30
        ));
        System.out.println(result);
    }
}

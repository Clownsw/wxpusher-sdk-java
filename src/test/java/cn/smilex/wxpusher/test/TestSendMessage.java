package cn.smilex.wxpusher.test;

import cn.smilex.wxpusher.WxPusher;
import cn.smilex.wxpusher.entity.Message;
import cn.smilex.wxpusher.entity.MessageResult;
import cn.smilex.wxpusher.entity.Result;
import org.junit.Test;

import java.util.List;

/**
 * @author smilex
 */
public class TestSendMessage {

    @Test
    public void context() {
        Message message = new Message();
        message.setAppToken("");
        message.setContent("hello");
        message.setContentType(Message.CONTENT_TYPE_TEXT);
        message.setUid("UID_Bfo1YqFEEHa003o2BwjxzK7LcnhN");
        Result<List<MessageResult>> result = WxPusher.send(message);
        System.out.println(result);
    }
}

# WxPusher
微信消息实时推送服务[WxPusher]，可以通过API实时给个人微信推送消息.[http://wxpusher.zjiecode.com/admin](http://wxpusher.zjiecode.com/admin)

# 功能介绍说明

请直接访问官方说明文档[http://wxpusher.zjiecode.com/docs](http://wxpusher.zjiecode.com/docs)

# 声明
当前仓库非 **WxPusher** 官方提供, 本仓库根据官方仓库代码移植 **req_java**, 以及修复一些Bug, 不定期更新, 不建议使用。

## 功能说明
### 发送消息
最后可以在你需要的地方，直接调用方法，即可实时推送消息到微信上了，比如下面这样：

```java
Message message = new Message();
message.setAppToken("AT_xxxxx");
message.setContentType(Message.CONTENT_TYPE_TEXT);
message.setContent("不加限制的自由是很可怕的，因为很容易让任何人滑向深渊。");
message.setUid("UID_xxxxxx");
message.setUrl("http://wxpuser.zjiecode.com");//可选参数
Result<List<MessageResult>> result = WxPusher.send(message);
```
### 创建带参数的二维码
创建一个带参数的二维码，用户扫码的时候，回调里面会携带二维码的参数.
```java
CreateQrcodeReq createQrcodeReq = new CreateQrcodeReq();
createQrcodeReq.setAppToken("xxxx"); //必填，应用的appTOken
createQrcodeReq.setExtra("parameter");//必填，携带的参数
createQrcodeReq.setValidTime(3600);//可选，二维码有效时间，默认1800 s，最大30天，单位是s
Result<CreateQrcodeResp> tempQrcode = WxPusher.createAppTempQrcode(createQrcodeReq);
if (tempQrcode.isSuccess()) {
    //创建成功
}
```


### 查询消息发送状态
发送消息是异步的，你可以通过这个api查询消息发送状态
```java
Result result = WxPusher.queryMessageStatus(messageId);
```

### 查询关注APP的微信用户列表
```java
//分页查询全部用户
Result<Page<WxUser>> wxUsers = WxPusher.queryWxUser("AT_xxxxx", 1, 50);
wxUsers.getData().getRecords().forEach(d-> System.out.println(d.getUid()));
//根据查询指定UID用户
Result<Page<WxUser>> users = WxPusher.queryWxUser("AT_xxxx", "UID_xxxx");
System.out.println(JSONObject.toJSONString(users));
```
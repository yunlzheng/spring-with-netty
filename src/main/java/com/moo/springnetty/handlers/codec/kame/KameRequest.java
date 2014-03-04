package com.moo.springnetty.handlers.codec.kame;

import java.util.HashMap;
import java.util.Map;

/**
 * Kame Request Data
 * 协议内容
 * 编码方式(1byte)
 * 加密(1byte)
 * 扩展1(1byte)
 * 扩展2(1byte)
 * 会话ID(4byte)
 * 命令或结果码(4byte)
 * 包长(4byte)
 */
public class KameRequest {

    private byte encode; //编码格式

    private byte encrypt; //加密类型

    private byte extend1;

    private byte extend2;

    private int sessionId;

    private int command;

    private int length;

    private Map<String, String> params = new HashMap<String, String>();

    private String ip;

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public byte getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(byte encrypt) {
        this.encrypt = encrypt;
    }

    public byte getExtend1() {
        return extend1;
    }

    public void setExtend1(byte extend1) {
        this.extend1 = extend1;
    }

    public byte getExtend2() {
        return extend2;
    }

    public void setExtend2(byte extend2) {
        this.extend2 = extend2;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getValue(String key) {
        if(key==null) {
            return null;
        }
        return params.get(key);
    }

    public void setValue(String key, String value) {

        params.put(key, value);

    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "XLRequest [encode=" + encode + ", encrypt=" + encrypt + ", extend1=" + extend1 + ", extend2=" + extend2
                + ", sessionid=" + sessionId + ", command=" + command + ", length=" + length + ", params=" + params + ", ip=" + ip + "]";
    }

}

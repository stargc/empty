package com.example.empty.business.service.encode;

import com.example.empty.infrastructure.util.AESUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author created by guanchen on 2021/1/22 15:35
 */
@Service
@Slf4j
public class EncodeService {
    @Test
    public void base64() {
        String msg = "中国assdad,@!~";
        System.out.println("msg : " + msg);
        String encodeMsg = new String(Base64.getEncoder().encode(msg.getBytes()));
        System.out.println("base64 加密结果：" + encodeMsg);
        String decodeMsg = new String(Base64.getDecoder().decode(encodeMsg.getBytes()));
        System.out.println("base64 解密结果：" + decodeMsg);


        String msg1 = "中";
        String msg2 = "a";
        String msg3 = "中国中国中国中国中国中国";
        System.out.println("base64 加密结果：" + new String(Base64.getEncoder().encode(msg1.getBytes())));
        System.out.println("base64 加密结果：" + new String(Base64.getEncoder().encode(msg2.getBytes())));
        System.out.println("base64 加密结果：" + new String(Base64.getEncoder().encode(msg3.getBytes())));
    }

    @Test
    public void md5() {
        String msg = "中国assdad,@!~";
        System.out.println( DigestUtils.md5DigestAsHex(msg.getBytes()));

        String msg1 = "中";
        String msg2 = "a";
        String msg3 = "中国中国中国中国中国中国";
        System.out.println( DigestUtils.md5DigestAsHex(msg1.getBytes()));
        System.out.println( DigestUtils.md5DigestAsHex(msg2.getBytes()));
        System.out.println( DigestUtils.md5DigestAsHex(msg3.getBytes()));
    }

    @SneakyThrows
    @Test
    public void AES(){
        String content = "1564a6*/123";
        System.out.println("content:" + content);
        String s1 = AESUtil.encrypt(content);
        System.out.println("s1:" + s1);
        System.out.println("s2:" + AESUtil.decrypt(s1));
    }
}

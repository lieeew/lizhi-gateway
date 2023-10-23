package com.lizhi.lizhigateway;

import cn.hutool.core.util.ByteUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@SpringBootTest
class LizhiGateWayApplicationTests {

    private Assertions Assert;

    @Test
    void contextLoads() throws UnsupportedEncodingException {
        RSA rsa = new RSA();

        // 获得私钥
        rsa.getPrivateKeyBase64();
        // 获得公钥
        String publicKeyBase64 = rsa.getPublicKeyBase64();
        System.out.println("publicKeyBase64 = " + publicKeyBase64);

        // 私钥加密，公钥解密
        byte[] encrypt = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
        String encryptStr = new String(encrypt, CharsetUtil.ISO_8859_1);

        RSA rsa1 = new RSA(null, publicKeyBase64);
        byte[] decrypt = rsa1.decrypt(encryptStr.getBytes(StandardCharsets.ISO_8859_1), KeyType.PublicKey);

        // Junit单元测试
        String str = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);

        Assert.assertEquals("我是一段测试aaaa", str);

    }
}

package com.lizhi.lizhigateway.utils;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import sun.security.provider.DSAPublicKey;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/lieeew">leikooo</a>
 * @Description 进行解密
 */
public class SignUtils {

    /**
     * 进行解密
     * @param encryptText 被私钥加密后的内容
     * @param publicKey 公钥
     * @return
     */
    public static String decryptContent(String publicKey, String encryptText) {
        RSA rsa = new RSA(null, publicKey);
        byte[] decrypt = rsa.decrypt(encryptText.getBytes(StandardCharsets.UTF_8), KeyType.PublicKey);
        return Arrays.toString(decrypt);
    }
}

package com.lizhi.lizhigateway.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.util.Base64;

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
        // 判断内容是否为 “”
        if (StringUtils.isAnyEmpty(encryptText, publicKey)) {
            return "";
        }

        RSA rsa = new RSA(null, publicKey);
        // 将 Base64 字符串解码为 byte 数组
        byte[] decrypt = rsa.decrypt(Base64.getDecoder().decode(encryptText), KeyType.PublicKey);
        // 返回解密后的密钥
        return StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
    }
}

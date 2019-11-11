package top.suiyueran.user.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.DigestUtils;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:42 2019/11/11
 * @Modifyed by:
 */
public class EncryptUtils {
    public static void main(String[] args) {
        try {
            encript("aaa");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String encript(String str) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicSecret = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateSecret = (RSAPrivateKey) keyPair.getPrivate();
        System.out.println(JSON.toJSONString(publicSecret));
        System.out.println(JSON.toJSONString(privateSecret));
        return null;
    }

    public String enc() {

        return null;
    }

}

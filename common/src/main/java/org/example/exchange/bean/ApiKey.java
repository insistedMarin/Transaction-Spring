package org.example.exchange.bean;

import org.example.exchange.model.ui.ApiKeyAuthEntity;
import org.example.exchange.util.HashUtil;

import java.security.SecureRandom;
import java.util.Base64;

public record ApiKey(long userId, long expiresAt) {

    public boolean isExpired() {
        return System.currentTimeMillis() > expiresAt();
    }
    public static ApiKeyAuthEntity createApiKeyAuthEntity(long userId) {
        String apiKey = generateApiKey();
        String apiSecret = generateApiSecret();
        long expiresAt = System.currentTimeMillis() + (30 * 24 * 60 * 60 * 1000); // 30 days expiration
        ApiKeyAuthEntity aka = new ApiKeyAuthEntity();
        aka.apiKey=apiKey;
        aka.apiSecret=apiSecret;
        aka.expiresAt=expiresAt;
        aka.userId=userId;
        return aka;
    }

    private static String generateApiKey() {
        // 根据需要生成 API Key 的逻辑，这里简单返回一个随机字符串
        return generateRandomString(16);
    }

    private static String generateApiSecret() {
        // 根据需要生成 API Secret 的逻辑，这里简单返回一个随机字符串
        return generateRandomString(32);
    }

    private static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static ApiKey getFromSignature(String signature, String toSignature, String hmacKey){
        String[] ss = toSignature.split("\\:");
        String userid = ss[1];
        String expiresAt = ss[3];
        if (!signature.equals(HashUtil.hmacSha256(toSignature, hmacKey))) {
            throw new IllegalArgumentException("Invalid ApiKey.");
        }
        return new ApiKey(Long.parseLong(userid),Long.parseLong(expiresAt));

    }
}

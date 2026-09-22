package com.unifebe.devsecops.config;

/**
 * Ajustado as configurações de segurança sob as variáveis de ambiente
 */
public final class AppConfig {

    private AppConfig() {
    }

    public static String dbPassword() {
        return requireEnv("DB_PASSWORD");
    }

    public static String awsSecretAccessKey() {
        return requireEnv("AWS_SECRET_ACCESS_KEY");
    }

    public static String awsAccessKeyId() {
        return requireEnv("AWS_ACCESS_KEY_ID");
    }

    public static String paymentGatewayApiKey() {
        return requireEnv("PAYMENT_GATEWAY_API_KEY");
    }

    private static String requireEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Variavel de ambiente obrigatoria nao definida: " + name);
        }
        return value;
    }
}

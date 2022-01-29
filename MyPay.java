import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.AlipayConfig;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.FileItem;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;

public class MyPay {

    public static void main(String[] args) throws AlipayApiException {
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBip234P0sJoIR/CcyjPqrRXv8HPDl1Hq+2S8QZbPwpsKQAsDehNbJZdD4uBjvoOmx5Xw9RKqB+wRhWoQuQzJ4ICThRKliFMgv9BkYbJkwvY/pfFB86tkfTuAPEComOr4jGrdjfDtZLd8KBsSHCoixCOxGSL8sqK5GXvCtt+CYjIJZg/mvgXp4KIYvx/TjeYlQ/54aFJzQJaorqDKMM+UEUvHPnKclEVcP5hQnnH+eO84k2ES/ZBMb0uSlmo6ppYejczVxM0SoEJBC1aNVTQZFq6WqZoQS7eRkZ6+bot8KrHOy7Fmunnccelv41rRPW3D/F77JsDjnqH1M7YNumcWrAgMBAAECggEAajakoMr56oRca7Cq1vje4yVixlFYd6ljRy4+N5ycEDo7FucbCpgyoAk6cWRJFdmDI5i86GNvxolxiv0zmdcA/5ujgYzRsRjHFwJ2vR718A/NeqyyNeo9Qj1i2xbu6E+L7K6QJSMMak+BK/BmnS7W6wkc6XfmQBDCa/KWNmmo3opRmWb5wiN5m/v47rYe9yyyr1tQ9T+6M1YguqxO6+1UpAUnerDtGviXlwwgcldztLICUGWyH4pEKDhdiq7G4opFS0IxaId2Zn1NwFNXpj7t4S/VCa3dqSQa+SAsl2uxcrDnQYV5p8v7Bq/e9608WmzuTzgQmRKRFSB6y4DY7yp4AQKBgQDO6EKQucH1oD/oUSHEnuP8CIU2cFLFZYyMUgFwF6kiI7asC7LsDJNlV3f9cJ7L0MTaixf9R81M1Gnqi82352mpnci53FWvgYnH9QruRkwhNaByfVY9ucYxl6izg8Gj0xdEPn0R+juwKuwvw2uWUPGIxQQnVJkY9xg6HQs7qVSpqwKBgQCgRxXmBbdiDIB0UFXKcWWoqsHWLuk9FRmCY2zA64n907IloJSSutI/VtVn5eAOFPwoBK1NG1M9Y6AeNmvlWE7DN3e93uym4MWLNx+qer3G+gjuXYsxNu99pTjhgHv3Pt7EeD9Mv6BK01ZIHAjDAp+zOHWvjIPFEMkNFy3LWctUAQKBgHY3xFi2mfjCn+EYAgg6lJ6bK6nIEbLRa7V84W9vRWbJKwUwBgHSyaC8kkVPRJvFY8ROdt1zWfzM3NtzF448/WU5TsfK+XY2uEd0XdN4fOT4o/zmWhEYhQIu2ef/nvMAmCmY3pMX+2STkbFUobMX+nkfwFjMgFEAVWpWz+U9wa7TAoGAUU090ny71US6NEY7/oEfLDvSL6+EKLP3SKjelc3lJZipGWUneHbEB9UoU5fL29jRQAt/TUm7I7zRkAHTIXd2HJiaaPoX2V7TVhcUPQoeEjzrIt7YqJJRUc7p15mxSG3f2pGUqn3Z9ZrWfaWa3DEMiYDuUapZfTFSiw1i8XAPMAECgYEAxAqk8o/h7LjWAdozLkxz7n0C4S3kNN/Es2JLwx2chF85mdyYlr+a65GdG/rSnhK4EvfmBuz8DaTTYLNRETxpvKq4Ox6BpVf4malfqpsX3xYxraW3VcHq/lB8Nc/7MyiUyL9Qb+N0D4C99jnmK1kJtdYCl9UEKK0j9fbNOGse/ZU=";
        String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi9KjukfesN+edwgUmVj6ML7KQLHZOgFPIiqqprU0mxN9o6EIIO2z3UWfo7zgXfZfYvchjcdH04JWrV3AtMJlKIFQJyEvF+UQVC87Woe/FwKhns1Yhp+Vo60fgvS4VxM/xv7O26IGwxqVwXElyH8AJGSmvm/rqdJujDdUELPAGsN04hOFPf6CXAPZWbhHeQyyEjAzqURhkseKhSmGZFrO8c7ShBgnWgapCUKCqmJvE6TN7ET8UM6h1N//yybUN2+y+yZ7J10JzkbB6QkqBWloWuAk5WBHX3UozEy+mpRQEXzSV1/0O8kPSTAuvlc0eYnL1rk1r6Bjh0V9woJ0HMtyPwIDAQAB";
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl("https://openapi.alipaydev.com/gateway.do");
        alipayConfig.setAppId("2021000119604817");
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setFormat("json");
        alipayConfig.setAlipayPublicKey(alipayPublicKey);
        alipayConfig.setCharset("UTF8");
        alipayConfig.setSignType("RSA2");
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        model.setOutTradeNo("20150320010101001");
        model.setTotalAmount("88.88");
        model.setSubject("Iphone6 16G");
        request.setBizModel(model);
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        System.out.println(response.getBody());
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
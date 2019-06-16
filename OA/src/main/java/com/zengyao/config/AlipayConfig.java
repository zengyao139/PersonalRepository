package com.zengyao.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2019053065366819";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCBeMwOW5UFnxhy2zX+3GURHT88M2S9v3VSJuXR3MP/xv14I1luVbw3Ge+JhUMOo5CqF3lVSpz1cT3ZpZM4n6pgfhlOGmc2WA8R3WPgBuTcHPJSnVujNyVTTBs+2XTa0bb3mt9T0TD4lKSQcVz7VnhpepMGY2mbHHUn5dj3j4Ne8SCllwA3tzCHrXjsoNTTqrBCnMzPY7tIOpNapUq9ND/+5z0/pKATfoFfdFYAIbHugdJI/KP+n/WnxZIP2En5jX3e0MBotuQ8j5VZXiAZA5mFI6/dsOB0Haa6mSvyA5P1GPUoLpiD1obUjQ+ASXmZA64EH/Jcec18iR8MMWNeY+vDAgMBAAECggEADiOX/TVpJ80BCYIA+o0tCFpuTm+6X7Jp6IfQ70MxsFwV0CnkGVWJkWbmrtj7wryADuMzX+ofC/rK61rWogdlvtXmg44EmX2yX5wSzSNTmOocWINQv5lFHTyheRKcXU0rswyZuPiOZYcuFYwbwGLoEXTOW5M9tC++Z5YFRLvKd/KrfNDArDWOBcmXFqnix6l7+TVmG1bv1NlFa3BZvQAD1KnLDz4lhvx1J+5tux//9Z3GRfZnGqjVwbW5EqaeJiT1Y7SjD0ZiDPI1Nft1Zlh67e3ePFii6dNCuk7v1NqUMiM0TMLBB/OTKOK/HYhB8VUCGh3+GuZorVpQ7Ac+XE4NUQKBgQC6RlYkQ64mdhrQsgPr4rqCy1/UypRYpMCvgyENVq6Nwrepqb1ROe8WYcuqagYGei11Lp+RvRcjB30k/MgZlyIgj4bWIIfyKsqEGsZxwq3+naokw5zMQ4V2L3vJLP9J5VyFajYg1ovtf1Zi56pS8XG979iXjjnyKT/HZnFkJwXYaQKBgQCx71vY8zRY9pS8dxl6ZRI+LlPHPS5GWlMSIzZdL83ibX09xiYXVNJD8+ijO3qGzgMr7gV4X/DAyycrI3Ti6rtcbXDynozT+cuSXUtV/o+mDK6VSdW5UdFdYKs0ooVFa+9I3LrqitLydAOhrTYdnqEo8p3WLWmvn7m4I/AOiqi9SwKBgQCvKseE0LRq7LNov45ae1rC9ncGxv3bogqkwd4KChKZsps+DCXAxYck+BArEArcenZW9OIPjc69HSS87I1LK0lnbzDwGaVdwImy0u78OYOfpSpD6kN//pr5ucthMlRbbDmmKGwAU2FAlHdrCMmtt+krIOoAEzpAlDOq0pYdBWlEyQKBgERBgYYzpT0LOfsh5NAivWDE/LZNLdcnBv7KKyyMDfpx7b0oqawBibcvdWpIgrP7ixPq9oY6p2wNgjT2IPx69ux5vv4S/ArEo+a9iwyt3gTgkIgMDsRMMngTgRlrzpvWz6+vnLQkFM+U2V/Hxh6On1vJ1eo2+Xe5WdDdWFT7s8cJAoGBAKFCGljs4BWbJBIlcEsIZLSxovrhI4G7GgekrXtU9ARq1oYWq9aSVwIA1mEi6UWFJoWCj2zZLsY4pGl9p5QWpK1izufdGqk8KYa4YCY2cUfckD6BwuGC+SKB/vMG7jIVb98efZtOqLEzjXIUpHnNWSoVCtpBlKr+yrtywno38KzO";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAilz1GcDxyo8SOim5Bd5Pt6W0RHXriurkTcyu9z4VbMk2TyNis4BPg4GUoEk1vpYVe+t1+W6aofZABxIskCY96f7GWfTg/nLzEtqV/KhRORZDWwsj0D2UjPrnJbPnkZAWK9Ug148L80q7uLVNdvD674oNiVUWL15+6xisnSps2Pytm63feXdKRpAdbEhHot56DDcwXPJJbUdCzFolfGIjSSFcNZRNP1JJtY6h0+oCGzoH7d8yCMt5Fku5eNuUXNsLdkeK1p2xNG6lYlJVoShLH6t9E7rV1rivJOfxGuSshkZYoJFC+A+ynnyoJqvuEW5x6IYEpBWpS6aNnEwbz6vurQIDAQAB";
    
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


package br.com.csd.crawler.jsoup.login.github;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class CertificateJSoup {

    public static void main(String[] args) {
        try {
            installCertificate();

            Connection.Response loginForm = Jsoup.connect("https://github.com/session")
                .method(Connection.Method.GET)
                .execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void installCertificate() {
        // for avoiding javax.net.ssl.SSLProtocolException: handshake alert:  unrecognized_name
        System.setProperty("jsse.enableSNIExtension", "false");

        // WARNING: do it only if security isn't important, otherwise you have
        // to follow this advices: http://stackoverflow.com/a/7745706/1363265
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            ;
        }
    }
}

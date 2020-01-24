package br.com.csd.crawler.jsoup.login.github;

import lombok.extern.java.Log;
import lombok.val;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;

@Log
public class GitHubLoginTest {

    static final String USER_AGENT = "Mozilla";
    static final String LOGIN_FORM_URL = "https://github.com/login";
    static final String LOGIN_ACTION_URL = "https://github.com/session";
    static final String USERNAME = "XXX";
    static final String PSW = "XXX";

    public static void main(String[] args) {
        try {
            val loginForm = getLoginForm();

            // # Now send the form for login
            Connection.Response githubHomePage = Jsoup.connect(LOGIN_ACTION_URL)
                .cookies(new HashMap<>(loginForm.cookies()))
                .data(populateFormData(loginForm))
                .method(Connection.Method.POST)
                .userAgent(USER_AGENT)
                .execute();

            log.info(githubHomePage.parse().toString());
        } catch (Exception ex) {
            log.severe("Error: " + ex.getMessage());
        }
    }

    private static Connection.Response getLoginForm() throws IOException {
        return Jsoup.connect(LOGIN_FORM_URL)
            .method(Connection.Method.GET)
            .userAgent(USER_AGENT)
            .execute();
    }

    private static HashMap<String, String> populateFormData(final Connection.Response loginForm) throws IOException {
        val authToken = loginForm.parse()
            .select("input[name=authenticity_token]")
            .first()
            .attr("value");

        HashMap<String, String> formData = new HashMap<>();
        formData.put("commit", "Sign in");
        formData.put("utf8", "e2 9c 93");
        formData.put("login", USERNAME);
        formData.put("password", PSW);
        formData.put("authenticity_token", authToken);
        return formData;
    }
}

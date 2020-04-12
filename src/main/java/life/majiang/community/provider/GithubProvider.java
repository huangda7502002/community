package life.majiang.community.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

    public static final String url = "https://github.com/login/oauth/access_token";
    public static final String getUserUrl = "https://api.github.com/user";
    OkHttpClient client = new OkHttpClient();

    public String getAccessToken(AccessTokenDTO accessTokenDTO) throws IOException {
        RequestBody body = RequestBody.create(com.alibaba.fastjson.JSON.toJSONString(accessTokenDTO),
                MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String accessToken = response.body().string();
            String[] split = accessToken.split("&");
            String tokenStr = split[0];
            return tokenStr.split("=")[1];
        }
    }

    public GithubUser getUser(String accessToken) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(getUserUrl + "?access_token=" + accessToken)
                .build();
        Response response = client.newCall(request).execute();
        String userString = response.body().string();
        return JSON.parseObject(userString, GithubUser.class);
    }

}

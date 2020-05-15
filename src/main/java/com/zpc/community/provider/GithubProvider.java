package com.zpc.community.provider;

import com.alibaba.fastjson.JSON;
import com.zpc.community.dto.AccessTokenDTO;
import com.zpc.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.PushBuilder;
import java.io.IOException;

/**
 * ClassName: GithubProvider
 * Package: com.zpc.community.provider
 * Description:
 *
 * @Date: 2020/5/12 21:21
 * @Author:zpc@qq.com
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType json = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(json, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String str = response.body().string();
//                System.out.println(str);
                String token = str.split("&")[0].split("=")[1];
                return token;

        } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String str = response.body().string();
            //System.out.println(str);
            GithubUser githubUser = JSON.parseObject(str, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

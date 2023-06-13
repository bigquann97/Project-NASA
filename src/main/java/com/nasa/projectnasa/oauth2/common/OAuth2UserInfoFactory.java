package com.nasa.projectnasa.oauth2.common;

import com.nasa.projectnasa.account.entity.AuthProvider;
import com.nasa.projectnasa.oauth2.google.GoogleOAuth2User;
import com.nasa.projectnasa.oauth2.kakao.KakaoOAuth2User;
import com.nasa.projectnasa.oauth2.naver.NaverOAuth2User;
import java.util.Map;

public class OAuth2UserInfoFactory {

  public static OAuth2UserInfo getOAuth2UserInfo(AuthProvider authProvider, Map<String, Object> attributes) {
    switch (authProvider) {
      case GOOGLE: return new GoogleOAuth2User(attributes);
      case NAVER: return new NaverOAuth2User(attributes);
      case KAKAO: return new KakaoOAuth2User(attributes);

      default: throw new IllegalArgumentException("Invalid Provider Type.");
    }
  }
}
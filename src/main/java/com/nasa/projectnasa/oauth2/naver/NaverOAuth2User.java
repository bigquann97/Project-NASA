package com.nasa.projectnasa.oauth2.naver;

import com.nasa.projectnasa.oauth2.common.OAuth2UserInfo;
import java.util.Map;

public class NaverOAuth2User extends OAuth2UserInfo {

  public NaverOAuth2User(Map<String, Object> attributes) {
    super((Map<String, Object>) attributes.get("response"));
  }

  @Override
  public String getOAuth2Id() {
    return (String) attributes.get("id");
  }

  @Override
  public String getEmail() {
    return (String) attributes.get("email");
  }

  @Override
  public String getName() {
    return (String) attributes.get("nickname");
  }
}
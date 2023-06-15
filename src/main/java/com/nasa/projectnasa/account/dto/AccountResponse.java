package com.nasa.projectnasa.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class AccountResponse {

  @Builder
  @Getter
  @AllArgsConstructor
  public static class TokenInfo {
    private String grantType;
    private String accessToken;
    private Long accessTokenExpirationTime;
    private String refreshToken;
    private Long refreshTokenExpirationTime;
  }
}
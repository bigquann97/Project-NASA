package com.nasa.projectnasa.oauth2.common;

import com.nasa.projectnasa.account.entity.Account;
import com.nasa.projectnasa.common.security.AccountPrincipal;
import com.nasa.projectnasa.account.entity.AuthProvider;
import com.nasa.projectnasa.account.entity.Role;
import com.nasa.projectnasa.account.repository.AccountRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

  private final PasswordEncoder passwordEncoder;
  private final AccountRepository accountRepository;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
    OAuth2UserService oAuth2UserService = new DefaultOAuth2UserService();
    OAuth2User oAuth2User = oAuth2UserService.loadUser(oAuth2UserRequest);
    return processOAuth2User(oAuth2UserRequest, oAuth2User);
  }

  protected OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
    //OAuth2 로그인 플랫폼 구분
    AuthProvider authProvider = AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId().toUpperCase());
    OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(authProvider, oAuth2User.getAttributes());

    if (!StringUtils.hasText(oAuth2UserInfo.getEmail())) {
      throw new RuntimeException("Email not found from OAuth2 provider");
    }

    Account account = accountRepository.findByEmail(oAuth2UserInfo.getEmail()).orElse(null);
    //이미 가입된 경우
    if (account != null) {
      if (!account.getAuthProvider().equals(authProvider)) {
        throw new RuntimeException("Email already signed up.");
      }
      account = updateUser(account, oAuth2UserInfo);
    }
    //가입되지 않은 경우
    else {
      account = registerUser(authProvider, oAuth2UserInfo);
    }
    return AccountPrincipal.create(account, oAuth2UserInfo.getAttributes());
  }

  private Account registerUser(AuthProvider authProvider, OAuth2UserInfo oAuth2UserInfo) {
    Account user = Account.builder()
        .email(oAuth2UserInfo.getEmail())
        .nickname(oAuth2UserInfo.getName())
        .oauth2Id(oAuth2UserInfo.getOAuth2Id())
        .password(passwordEncoder.encode(UUID.randomUUID().toString()))
        .authProvider(authProvider)
        .role(Role.USER)
        .build();

    return accountRepository.save(user);
  }

  private Account updateUser(Account user, OAuth2UserInfo oAuth2UserInfo) {
    return accountRepository.save(user.update(oAuth2UserInfo));
  }
}
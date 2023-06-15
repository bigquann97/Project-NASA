package com.nasa.projectnasa.account.entity;

import com.nasa.projectnasa.common.entity.BaseEntity;
import com.nasa.projectnasa.oauth2.common.OAuth2UserInfo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  private String nickname;

  private String profileImageUrl;

  private String oauth2Id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AuthProvider authProvider;

  @Builder
  public Account(String email, String password, String nickname, String profileImageUrl,
      String oauth2Id, Role role, AuthProvider authProvider) {
    this.email = email;
    this.password = password;
    this.nickname = nickname;
    this.profileImageUrl = profileImageUrl;
    this.oauth2Id = oauth2Id;
    this.role = role;
    this.authProvider = authProvider;
  }

  public Account update(OAuth2UserInfo oAuth2UserInfo){
    return this;
  }

  public String getRoleKey(){
    return this.role.getKey();
  }

}

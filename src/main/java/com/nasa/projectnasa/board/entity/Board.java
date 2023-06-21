package com.nasa.projectnasa.board.entity;

import com.nasa.projectnasa.account.entity.Account;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String loginPw;

  private String nickname;

}

package com.nasa.projectnasa.wish.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Wish {

  @Id
  @GeneratedValue
  private Long id;
}

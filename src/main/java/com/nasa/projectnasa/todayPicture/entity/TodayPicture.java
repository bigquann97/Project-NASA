package com.nasa.projectnasa.todayPicture.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class TodayPicture {

  @Id
  private String date;

  private String explanation;

  private String hdurl;

  private String mediaType;

  private String serviceVersion;

  private String title;

  private String url;


}

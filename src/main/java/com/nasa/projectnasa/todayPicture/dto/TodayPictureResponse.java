package com.nasa.projectnasa.todayPicture.dto;

import com.nasa.projectnasa.todayPicture.entity.TodayPicture;
import lombok.Getter;

@Getter
public class TodayPictureResponse {

  private String date;
  private String explanation;
  private String hdurl;
  private String mediaType;
  private String serviceVersion;
  private String title;
  private String url;

  public static TodayPictureResponse of(TodayPicture orElseThrow) {
    return null;
  }

  public TodayPicture toEntity() {
    return null;
  }
}

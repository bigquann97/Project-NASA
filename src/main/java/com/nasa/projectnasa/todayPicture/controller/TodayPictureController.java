package com.nasa.projectnasa.todayPicture.controller;

import com.nasa.projectnasa.todayPicture.dto.TodayPictureResponse;
import com.nasa.projectnasa.todayPicture.service.TodayPictureService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/api/v1/today-pictures")
@RequiredArgsConstructor
public class TodayPictureController {

  private final TodayPictureService todayPictureService;

  @GetMapping
  public TodayPictureResponse getTodayPic(@RequestParam String date) throws IOException {
    TodayPictureResponse todayPictureResponse = todayPictureService.getTodayPicture(date);
    return todayPictureResponse;
  }

}

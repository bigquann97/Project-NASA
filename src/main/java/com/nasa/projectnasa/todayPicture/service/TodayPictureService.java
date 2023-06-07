package com.nasa.projectnasa.todayPicture.service;

import com.nasa.projectnasa.todayPicture.dto.TodayPictureResponse;
import java.io.IOException;

public interface TodayPictureService {

  TodayPictureResponse getTodayPicture(String date) throws IOException;
}

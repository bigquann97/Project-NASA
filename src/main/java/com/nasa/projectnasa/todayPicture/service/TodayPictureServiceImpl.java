package com.nasa.projectnasa.todayPicture.service;

import com.google.gson.Gson;
import com.nasa.projectnasa.nasa.ApodService;
import com.nasa.projectnasa.todayPicture.dto.TodayPictureResponse;
import com.nasa.projectnasa.todayPicture.entity.TodayPicture;
import com.nasa.projectnasa.todayPicture.repository.TodayPictureRepository;
import java.io.IOException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodayPictureServiceImpl implements TodayPictureService {

  private final TodayPictureRepository todayPictureRepository;
  private final ApodService apodService;

  public Optional<TodayPicture> checkIfDBHasData(String date) {
    Optional<TodayPicture> optionalAPOD = todayPictureRepository.findByDate(date);
    return optionalAPOD;
  }

  @Override
  public TodayPictureResponse getTodayPicture(String date) throws IOException {
    Optional<TodayPicture> optionalAPOD = checkIfDBHasData(date);
    TodayPictureResponse todayPictureResponse = null;

    String apodJson = apodService.getAopdUrl(date);
    Gson gson = new Gson();
    TodayPictureResponse response = gson.fromJson(apodJson, TodayPictureResponse.class);
    return response;
  }
}

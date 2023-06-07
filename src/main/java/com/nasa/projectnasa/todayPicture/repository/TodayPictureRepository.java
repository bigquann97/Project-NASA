package com.nasa.projectnasa.todayPicture.repository;

import com.nasa.projectnasa.todayPicture.entity.TodayPicture;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface TodayPictureRepository extends JpaRepository<TodayPicture, String> {

  Optional<TodayPicture> findByDate(@NonNull String date);

  Optional<TodayPicture> findByDateIgnoreCase(@NonNull String date);

}

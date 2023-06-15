package com.nasa.projectnasa.account.controller;

import com.nasa.projectnasa.account.service.AccountService;
import com.nasa.projectnasa.common.utils.NicknamingUtils;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;
  private final NicknamingUtils nicknamingUtils;
//  private final S3Uploader s3Uploader;

//  @PutMapping("/nickname")
//  public String updateUserName(@Valid @RequestBody UserNameDto userNameDto) {
//
//    return accountService.setUserName(userNameDto.getUsername());
//  }
//
//  @PutMapping("/profile")
//  public UserProfileUpdateRequestDto updateUserProfile(@Valid @RequestBody UserProfileUpdateRequestDto requestDto) {
//
//    return accountService.updateUserProfile(requestDto);
//  }
//
//  @PutMapping("/profileimage")
//  @ResponseBody
//  public List<String> upload(@RequestParam("data") List<MultipartFile> multipartFile) throws IOException {
//    return s3Uploader.upload(multipartFile, "profileImage");
//  }

  @GetMapping("/hihi")
  public void temp() {
    System.out.println(nicknamingUtils.makeRandomNaming());
  }
}
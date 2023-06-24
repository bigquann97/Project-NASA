package com.nasa.projectnasa.image.entity;

import com.nasa.projectnasa.board.entity.Board;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private Board board;

  @Column(nullable = false)
  private String origFileName;

  @Column(nullable = false)
  private String imagePath;

  private Long fileSize;

  @Builder
  public Image(Board board, String origFileName, String imagePath, Long fileSize) {
    this.board = board;
    this.origFileName = origFileName;
    this.imagePath = imagePath;
    this.fileSize = fileSize;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

//    public void updateImages(String origFileName, String imagePath, Long fileSize){
//        this.origFileName = origFileName;
//        this.imagePath = imagePath;
//        this.fileSize = fileSize;
//    }
}
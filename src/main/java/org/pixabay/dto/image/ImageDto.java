package org.pixabay.dto.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageDto {

    private Long id;
    private String pageURL;
    private String type;
    private String tags;

    private String previewURL;
    private Integer previewWidth;
    private Integer previewHeight;

    private String webformatURL;
    private Integer webformatWidth;
    private Integer webformatHeight;

    private String largeImageURL;
    private String fullHDURL;
    private String imageURL;
    private Integer imageWidth;
    private Integer imageHeight;
    private Integer imageSize;

    private Integer views;
    private Integer downloads;
    private Integer likes;
    private Integer comments;

    private Long user_id;
    private String user;
    private String userImageURL;
}

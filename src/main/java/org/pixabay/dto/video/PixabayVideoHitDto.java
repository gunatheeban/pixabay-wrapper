package org.pixabay.dto.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixabayVideoHitDto {

    private int id;
    private String pageURL;
    private String type;
    private String tags;
    private int duration;
    private VideoResolutionDto videos;
    private int views;
    private int downloads;
    private int likes;
    private int comments;
    private int user_id;
    private String user;
    private String userImageURL;
}

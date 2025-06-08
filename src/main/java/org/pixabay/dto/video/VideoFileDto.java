package org.pixabay.dto.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoFileDto {
    private String url;
    private int width;
    private int height;
    private int size;
    private String thumbnail;
}

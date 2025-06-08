package org.pixabay.dto.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoResolutionDto {

    private VideoFileDto large;
    private VideoFileDto medium;
    private VideoFileDto small;
    private VideoFileDto tiny;
}

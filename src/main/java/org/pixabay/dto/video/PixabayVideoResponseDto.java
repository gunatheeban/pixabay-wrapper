package org.pixabay.dto.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixabayVideoResponseDto  {

    private int total;
    private int totalHits;
    private List<PixabayVideoHitDto> hits;
}

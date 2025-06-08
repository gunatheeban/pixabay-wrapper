package org.pixabay.dto.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import org.pixabay.enums.CategoryEnum;
import org.pixabay.enums.LanguagesEnum;
import org.pixabay.enums.OrderEnum;
import org.pixabay.enums.VideoTypeEnum;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixabayVideoSearchRequestDto {

    private String q;
    @Enumerated
    private LanguagesEnum lang = LanguagesEnum.EN;
    private String id;
    @Enumerated
    private VideoTypeEnum videoType = VideoTypeEnum.ALL;
    @Enumerated
    private CategoryEnum category;
    private Integer minWidth = 0;
    private Integer minHeight = 0;
    private Boolean editorsChoice = false;
    private Boolean safesearch = false;
    @Enumerated
    private OrderEnum order = OrderEnum.POPULAR;
    private Integer page = 1;
    private Integer perPage = 20;
    private String callback;
    private Boolean pretty = false;
}

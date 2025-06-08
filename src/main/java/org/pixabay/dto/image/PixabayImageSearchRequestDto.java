package org.pixabay.dto.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.pixabay.enums.*;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixabayImageSearchRequestDto {

    private String q;

    @Enumerated(EnumType.STRING)
    private LanguagesEnum lang = LanguagesEnum.EN;
    private String id;

    @Enumerated(EnumType.STRING)
    private ImageTypeEnum imageType = ImageTypeEnum.ALL;

    @Enumerated(EnumType.STRING)
    private OrientationEnum orientation = OrientationEnum.ALL;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    private Integer minWidth = 0;
    private Integer minHeight = 0;

    @Enumerated(EnumType.STRING)
    private String colors;
    private Boolean editorsChoice = false;
    private Boolean safesearch = false;

    @Enumerated(EnumType.STRING)
    private OrderEnum order = OrderEnum.LATEST;
    private Integer page = 1;
    private Integer perPage = 20;
    private String callback;
    private Boolean pretty = false;
}

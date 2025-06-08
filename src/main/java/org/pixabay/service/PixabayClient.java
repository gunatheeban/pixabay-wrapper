package org.pixabay.service;

import org.pixabay.dto.image.ImageDto;
import org.pixabay.dto.image.PixabayImageSearchRequestDto;
import org.pixabay.dto.video.PixabayVideoResponseDto;
import org.pixabay.dto.video.PixabayVideoSearchRequestDto;

import java.util.List;

public interface PixabayClient {

    List<ImageDto> searchImages(PixabayImageSearchRequestDto pixabayImageSearchRequestDto);

    PixabayVideoResponseDto searchVideos(PixabayVideoSearchRequestDto pixabayVideoSearchRequestDto);
}

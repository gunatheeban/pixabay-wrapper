package org.pixabay.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.pixabay.dto.image.ImageDto;
import org.pixabay.dto.image.PixabayImageSearchRequestDto;
import org.pixabay.dto.video.PixabayVideoHitDto;
import org.pixabay.dto.video.PixabayVideoResponseDto;
import org.pixabay.dto.video.PixabayVideoSearchRequestDto;
import org.pixabay.service.PixabayClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.pixabay.constents.PixabayConstent.IMAGE_URL;
import static org.pixabay.constents.PixabayConstent.VIDEO_URL;

public class PixabayClientServiceImpl implements PixabayClient {

    private final String apiKey;
    private final CloseableHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public PixabayClientServiceImpl(String apiKey) {

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalArgumentException("Pixabay API key must not be null or empty");
        }
        this.apiKey = apiKey;
        this.httpClient = HttpClients.createDefault();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<ImageDto> searchImages(PixabayImageSearchRequestDto request) {
        try {
            StringBuilder urlBuilder = new StringBuilder(IMAGE_URL)
                    .append("?key=")
                    .append(URLEncoder.encode(apiKey, StandardCharsets.UTF_8));

            if (request.getQ() != null) urlBuilder.append("&q=").append(encode(request.getQ()));
            if (request.getLang() != null) urlBuilder.append("&lang=").append(request.getLang().name());
            if (request.getId() != null) urlBuilder.append("&id=").append(encode(request.getId()));
            if (request.getImageType() != null)
                urlBuilder.append("&image_type=").append(request.getImageType().name().toLowerCase());
            if (request.getOrientation() != null)
                urlBuilder.append("&orientation=").append(request.getOrientation().name().toLowerCase());
            if (request.getCategory() != null)
                urlBuilder.append("&category=").append(request.getCategory().name().toLowerCase());
            if (request.getMinWidth() != null && request.getMinWidth() > 0)
                urlBuilder.append("&min_width=").append(request.getMinWidth());
            if (request.getMinHeight() != null && request.getMinHeight() > 0)
                urlBuilder.append("&min_height=").append(request.getMinHeight());
            if (request.getColors() != null) urlBuilder.append("&colors=").append(encode(request.getColors()));
            if (Boolean.TRUE.equals(request.getEditorsChoice())) urlBuilder.append("&editors_choice=true");
            if (Boolean.TRUE.equals(request.getSafesearch())) urlBuilder.append("&safesearch=true");
            if (request.getOrder() != null)
                urlBuilder.append("&order=").append(request.getOrder().name().toLowerCase());
            if (request.getPage() != null) urlBuilder.append("&page=").append(request.getPage());
            if (request.getPerPage() != null) urlBuilder.append("&per_page=").append(request.getPerPage());
            if (request.getCallback() != null) urlBuilder.append("&callback=").append(encode(request.getCallback()));
            if (Boolean.TRUE.equals(request.getPretty())) urlBuilder.append("&pretty=true");

            HttpGet httpGet = new HttpGet(urlBuilder.toString());
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                String json = EntityUtils.toString(response.getEntity());
                JsonNode root = objectMapper.readTree(json);
                JsonNode hits = root.get("hits");

                List<ImageDto> results = new ArrayList<>();
                if (hits != null && hits.isArray()) {
                    for (JsonNode node : hits) {
                        ImageDto dto = new ImageDto();
                        dto.setId(node.get("id").asLong());
                        dto.setTags(node.get("tags").asText());
                        dto.setPreviewURL(node.get("previewURL").asText());
                        dto.setLargeImageURL(node.get("largeImageURL").asText());
                        dto.setUser(node.get("user").asText());
                        results.add(dto);
                    }
                }
                return results;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching from Pixabay", e);
        }
    }

    @Override
    public PixabayVideoResponseDto searchVideos(PixabayVideoSearchRequestDto request) {
        try {
            StringBuilder urlBuilder = new StringBuilder(VIDEO_URL)
                    .append("?key=")
                    .append(URLEncoder.encode(apiKey, StandardCharsets.UTF_8));

            if (request.getQ() != null) urlBuilder.append("&q=").append(encode(request.getQ()));
            if (request.getLang() != null) urlBuilder.append("&lang=").append(request.getLang().name().toLowerCase());
            if (request.getId() != null) urlBuilder.append("&id=").append(encode(request.getId()));
            if (request.getVideoType() != null) urlBuilder.append("&video_type=").append(request.getVideoType().name().toLowerCase());
            if (request.getCategory() != null) urlBuilder.append("&category=").append(request.getCategory().name().toLowerCase());
            if (request.getMinWidth() != null) urlBuilder.append("&min_width=").append(request.getMinWidth());
            if (request.getMinHeight() != null) urlBuilder.append("&min_height=").append(request.getMinHeight());
            if (request.getEditorsChoice() != null) urlBuilder.append("&editors_choice=").append(request.getEditorsChoice());
            if (request.getSafesearch() != null) urlBuilder.append("&safesearch=").append(request.getSafesearch());
            if (request.getOrder() != null) urlBuilder.append("&order=").append(request.getOrder().name().toLowerCase());
            if (request.getPage() != null) urlBuilder.append("&page=").append(request.getPage());
            if (request.getPerPage() != null) urlBuilder.append("&per_page=").append(request.getPerPage());
            if (request.getCallback() != null) urlBuilder.append("&callback=").append(request.getCallback());
            if (request.getPretty() != null) urlBuilder.append("&pretty=").append(request.getPretty());

            HttpGet httpGet = new HttpGet(urlBuilder.toString());

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                String json = EntityUtils.toString(response.getEntity());
                JsonNode root = objectMapper.readTree(json);
                JsonNode hits = root.get("hits");
                var pixabayVideoResponseDto = new PixabayVideoResponseDto();
                if (hits != null && hits.isArray()) {
                    List<PixabayVideoHitDto> pixabayVideoHitDtos = new ArrayList<>();
                    for (JsonNode hit : hits) {
                        pixabayVideoHitDtos.add(objectMapper.treeToValue(hit, PixabayVideoHitDto.class));
                    }
                    pixabayVideoResponseDto.setHits(pixabayVideoHitDtos);
                    return pixabayVideoResponseDto;
                } else {
                    return pixabayVideoResponseDto;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching from Pixabay", e);
        }
    }


    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}

package com.example.restaurant_practice.naver;

import com.example.restaurant_practice.naver.dto.SearchImageRes;
import com.example.restaurant_practice.naver.dto.SearchImageReq;
import com.example.restaurant_practice.naver.dto.SearchLocalReq;
import com.example.restaurant_practice.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {

    @Value("${naver.url.search.local}")
    private String searchLocalUrl;
    @Value("${naver.url.search.image}")
    private String searchImageUrl;
    @Value("${naver.client.id}")
    private String clientId;
    @Value("${naver.client.secret}")
    private String clientSecret;

    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq){
        var uri = UriComponentsBuilder
                .fromUriString(searchLocalUrl)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id",clientId);
        headers.add("X-Naver-Client-Secret",clientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};

        var localResponse = new RestTemplate()
                .exchange(
                        uri,
                        HttpMethod.GET
                ,httpEntity
                ,responseType);

        return localResponse.getBody();

    }

    public SearchImageRes searchImage(SearchImageReq searchImageReq){
        var uri = UriComponentsBuilder
                .fromUriString(searchImageUrl)
                .queryParams(searchImageReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id",clientId);
        headers.add("X-Naver-Client-Secret",clientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchImageRes>(){};

        var imageResponse = new RestTemplate()
                .exchange(
                        uri,
                        HttpMethod.GET
                        ,httpEntity
                        ,responseType);

        return imageResponse.getBody();

    }

}

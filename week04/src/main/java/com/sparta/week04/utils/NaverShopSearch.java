package com.sparta.week04.utils;

import com.sparta.week04.domain.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component  // 이제부터, @RequiredArgsConstructor 와 함께 사용할 경우 스프링이 자동으로 생성
public class NaverShopSearch {

    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "jHVGBDv6z6mzS_Ef5VgQ");
        headers.add("X-Naver-Client-Secret", "GTpczT2EAT");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=iphone", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = (HttpStatus) responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {
        // 문자열 정보를 JSONObject로 바꾸기
        JSONObject rjson = new JSONObject(result);
        // JSONObject에서 items 배열 꺼내기
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> ret = new ArrayList<>();
        // JSONArray로 for 문 돌기
        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJson);
            ret.add(itemDto);
        }
        return ret;
    }

//    public static void main(String[] args) {
//        NaverShopSearch naverShopSearch = new NaverShopSearch();
//
////        String ret = naverShopSearch.search("아이폰");
////        naverShopSearch.fromJSONtoItems(ret);
//
//    }
}

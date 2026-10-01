package example.test;

import java.net.URLEncoder;
import org.springframework.http.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/")
@RequiredArgsConstructor 
public class TestController {
    private final StringRedisTemplate redisTemplate;

    //1. 세션
    @GetMapping ("/session/add")
    public String addSessionData(@RequestParam ("data")String data, HttpSession session){
        List<String>list = (List<String>) session.getAttribute("SESSION_DATA");
        if(list==null)list = new ArrayList<>();
        list.add(data);
        session.setAttribute("SESSION_DATA", list);
        return "세션저장성공";
    }

    @GetMapping ("/session/all")
    public List<String> getAllSessionData(HttpSession session){
        List<String>result = (List<String>) session.getAttribute("SESSION_DATA");
        return result;
    }

    //2. 쿠키
    private final ObjectMapper ObjectMapper = new ObjectMapper();
    @GetMapping ("/cookie/add")
    public String addCookieData(@RequestParam("data") String data, @CookieValue(name="COOKIE_DATA", required=false) String cookieData,
                                HttpServletResponse response)throws Exception{
    List<String>list = (cookieData == null)? new ArrayList<>(): ObjectMapper.readValue(cookieData, List.class);
    list.add(data);
    String json = ObjectMapper.writeValueAsString(list);
    ResponseCookie cookie = ResponseCookie.from("COOKIE_DATA",URLEncoder.encode(json, StandardCharsets.UTF_8))
        .path("/")
        .build();
    response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
    return "쿠키저장성공";
    }

    @GetMapping ("/cookie/all")
    public List<String> getAllCookieData(@CookieValue(name = "COOKIE_DATA", required = false) String cookieData) throws Exception {
        if (cookieData == null) {
            return Collections.emptyList();
        }
        return ObjectMapper.readValue(cookieData, List.class );
    }

    //3. 레디스
    @GetMapping ("/redis/add")
    public String addRedisData(@RequestParam("data") String data){
        redisTemplate.opsForValue().set(data,data);
        return "레디스저장성공";
    }

    @GetMapping ("/redis/all")
    public List<String> getAllRedisData() {
        Set<String> keys = redisTemplate.keys("*");
         List<String> list = new ArrayList<>();
        for( String key : keys ){ 
            String data = redisTemplate.opsForValue().get(key);
            list.add( data );
        }
        return list;

    }
}

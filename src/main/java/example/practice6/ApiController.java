package example.practice6;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;
    @GetMapping(value = "/test1", produces = "application/xml")
    public Map<String, Object> test1() {
        return apiService.test1();
    }
}
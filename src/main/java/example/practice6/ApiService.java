package example.practice6;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


@Service 
public class ApiService {
    @Value("${api.public-data.service-key}")
    private String serviceKey;
    private WebClient webClient = WebClient.builder().build();
    public Map<String,Object> test1(){
        String url="https://apis.data.go.kr/6260000/BusanTblDpstcRsdService/getTblDpstcRsdInfo";
        url += "?serviceKey="+serviceKey;
        url += "&pageNo="+1;
        url += "&numOfRows="+10;
        String response = webClient.get( ).uri( url ).retrieve()
                .bodyToMono(String.class) 
                .block();
        XmlMapper xmlMapper = new XmlMapper(); 
        try{
            Map<String,Object> map = xmlMapper.readValue( response , Map.class );
            return  map;
        }catch( Exception e ){ System.out.println( e ); }
        return  null;
    }
}

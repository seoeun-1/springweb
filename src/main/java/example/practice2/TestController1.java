package example.practice2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TestController1 {
    @Autowired private TestService testService;

    @PostMapping("/test")
    public boolean testWrite(@RequestBody TestEntity testEntityentity) {
        return testService.testWrite(testEntityentity);
    }
    
    @GetMapping("/test")
    public List<TestEntity> testPrint(){ 
        return testService.testPrint( );
    }

    @GetMapping("/test/detail")
    public TestEntity testDetail( @RequestParam( name = "no") int no ){
        return testService.testdetail( no );
    }
    @DeleteMapping("/test/{no}")
    public boolean testDelete(@PathVariable(name = "no")int no){
        return testService.testDelete( no );
    }
    @PutMapping("/test")
    public boolean testUpdate(@RequestBody TestEntity testEntity) {
        return testService.testUpdate(testEntity);
    }
    
}
    
   
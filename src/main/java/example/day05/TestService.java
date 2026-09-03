package example.day05;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired private TestRepository testRepository;

    // 1. 전체조회
    public List<TestDto> 전체조회(){
        List<TestEntity> entities = testRepository.findAll();
        List<TestDto> list = new ArrayList<>();
        entities.forEach((entity) -> {
            TestDto dto = TestDto.from(entity);
            list.add(dto);
        });
        return list;
    }

    // 2. 저장
    public boolean 저장(TestDto testDto){
        TestEntity testEntity = testDto.toEntity();
        TestEntity savedEntity = testRepository.save(testEntity);
        if(savedEntity.getNo() >= 1){return true;}
        return false;
    }

    // 3. 수정
    public boolean 수정(TestDto testDto){
        Optional<TestEntity> optional
        = testRepository.findById(testDto.getNo());
        if(optional.isPresent()){
            TestEntity entity = optional.get();
            entity.setPrice(testDto.getPrice());
            entity.setDescri(testDto.getDescri());
            return true;
        }
        return false;
    }
}

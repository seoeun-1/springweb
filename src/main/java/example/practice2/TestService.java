package example.practice2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService{
    @Autowired private TestRepository testRepository;

    public boolean testWrite(TestEntity testEntity){
        TestEntity savedEntity = testRepository.save(testEntity);
        if (savedEntity.getNo()>=10) { return true; }
        return false;      
    }
    public List<TestEntity> testPrint( ){
        List<TestEntity> list = testRepository.findAll();
        return list;
    }
    public TestEntity testdetail(int no){
        Optional<TestEntity> optional = testRepository.findById(no);
        if( optional.isPresent() ){
            TestEntity entity = optional.get(); 
            return entity;
        }
        return null; 
    }
    public boolean testDelete(int no){
        Optional<TestEntity> optional = testRepository.findById(no);
        if(optional.isPresent()){
            testRepository.delete(optional.get());
            return true;
        }
        return false;
    }
    public boolean testUpdate( TestEntity testEntity ){
        Optional<TestEntity> optional = testRepository.findById(testEntity.getNo());
        if(optional.isPresent()){
            TestEntity entity = optional.get();
            entity.setContent(testEntity.getContent());
            return true;
        }
        return false;
    }
}


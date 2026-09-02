package example.practice.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.practice.model.dao.WaitingDao;
import example.practice.model.dto.WaitingDto;

@RestController
public class WaitingController {

    private WaitingDao wd = WaitingDao.getInstance();


    // [1] 등록
    @PostMapping("/waiting/save")
    public boolean save( WaitingDto waitingDto) {
        boolean result = wd.save(waitingDto);
        return result;
    }


    // [2] 전체조회
    @GetMapping("/waiting/findall")
    public ArrayList<WaitingDto> findAll() {

        ArrayList<WaitingDto> result = wd.findAll();

        return result;
    }


    // [3] 개별수정
    @PutMapping("/waiting/update")
    public boolean update( WaitingDto waitingDto) {

        return wd.update(waitingDto);
    }


    // [4] 개별삭제
    @DeleteMapping("/waiting/delete") // 현 강의는 17버전, 25버전
    public boolean delete( @RequestParam(name="phone") String phone ) {
        System.out.println("WaitingController.delete()");
        System.out.println( phone  );
        return wd.delete(phone );
    }

} // class end
package example.practice.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import example.practice.model.dto.WaitingDto;

public class WaitingDao extends BaseDao {

    // 싱글톤
    private WaitingDao() {}

    private static final WaitingDao instance = new WaitingDao();

    public static WaitingDao getInstance() {
        return instance;
    }


    // [1] 대기명단 등록
    public boolean save(WaitingDto waitingDto) {

        try {

            // 1. SQL 작성
            String sql =
                    "insert into waiting(phone, customer) values(?, ?)";

            // 2. SQL 기재
            PreparedStatement ps =
                    conn.prepareStatement(sql);

            // 3. SQL 매개변수 대입
            ps.setString(1, waitingDto.getPhone());
            ps.setInt(2, waitingDto.getCustomer());

            // 4. SQL 실행
            int result = ps.executeUpdate();

            // 5. 실행 결과
            if (result == 1) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }


    // [2] 대기명단 전체조회
    public ArrayList<WaitingDto> findAll() {

        ArrayList<WaitingDto> list = new ArrayList<>();

        try {

            // 1. SQL 작성
            String sql =
                    "select no, phone, customer from waiting order by no asc";

            // 2. SQL 기재
            PreparedStatement ps =
                    conn.prepareStatement(sql);

            // 3. SQL 실행
            ResultSet rs =
                    ps.executeQuery();

            // 4. 조회 결과 처리
            while (rs.next()) {

                WaitingDto waitingDto =
                        new WaitingDto();

                waitingDto.setNo(
                        rs.getInt("no")
                );

                waitingDto.setPhone(
                        rs.getString("phone")
                );

                waitingDto.setCustomer(
                        rs.getInt("customer")
                );

                list.add(waitingDto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }


    // [3] 대기명단 개별수정
    public boolean update(WaitingDto waitingDto) {

        try {

            // 1. SQL 작성
            String sql =
                    "update waiting set customer = ? where phone = ?";

            // 2. SQL 기재
            PreparedStatement ps =
                    conn.prepareStatement(sql);

            // 3. SQL 매개변수 대입
            ps.setInt(
                    1,
                    waitingDto.getCustomer()
            );

            ps.setString(
                    2,
                    waitingDto.getPhone()
            );

            // 4. SQL 실행
            int result =
                    ps.executeUpdate();

            // 5. 실행 결과
            if (result == 1) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }


    // [4] 대기명단 개별삭제
    public boolean delete(String phone) {

        try {

            // 1. SQL 작성
            String sql =
                    "delete from waiting where phone = ?";

            // 2. SQL 기재
            PreparedStatement ps =
                    conn.prepareStatement(sql);

            // 3. SQL 매개변수 대입
            ps.setString(1, phone);

            // 4. SQL 실행
            int result =
                    ps.executeUpdate();

            // 5. 실행 결과
            if (result == 1) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

} // class end
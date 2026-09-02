package example.practice.model.dto;

public class WaitingDto {

    private int no;
    private String phone;
    private int customer;
 
    public WaitingDto() {
    }

    public WaitingDto(int no, String phone, int customer) {
        this.no = no;
        this.phone = phone;
        this.customer = customer;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }
       @Override
    public String toString() {
        return "BoardDto [no=" + no + ", phone =" + phone+ ", customer=" + customer + "]";
    }
}

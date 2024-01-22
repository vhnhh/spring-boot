package ra.demo_spring_boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private Integer studentId;
    private String studentName;
    private String phoneNb;
    private Boolean sex;
    private Date birthday;
    private String imgUrl;
    private String address;
}

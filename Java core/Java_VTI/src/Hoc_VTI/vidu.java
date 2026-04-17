package Hoc_VTI;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class vidu {
    public static void main(String[] args) {

        LocalDate ngaysinh=LocalDate.parse("2003-11-09");
        System.out.println(ngaysinh);
        // Cách 2: Tạo từ ngày, tháng, năm cụ thể (rất rõ ràng)
        LocalDate ngayKhac = LocalDate.of(2002, 2, 2);
        System.out.println(ngayKhac);
        LocalDateTime gio=LocalDateTime.now();
        System.out.println(gio);

        int diem[]={1,2,3,4,5};
        for (int i=0;i<diem.length;i++)
        {
            System.out.println(diem[i]);
        }

    }
}

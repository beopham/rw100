package Bai_Tap_Buoi_2;

import java.time.LocalDate;

public class Exercise_1 {
    public static void main(String[] args) {


        // --- PHẦN 1: DEPARTMENT ---
        Department department1 = new Department();
        department1.departmentID = 1;
        department1.departmentName = "Sale";

        Department department2 = new Department();
        department2.departmentID = 2;
        department2.departmentName = "Marketing";

        Department department3 = new Department();
        department3.departmentID = 3;
        department3.departmentName = "Director";


        // --- PHẦN 2: POSITION ---
        Position pos1 = new Position();
        pos1.PositionID = 1;
        pos1.positionName = PositionName.DEV;

        Position pos2 = new Position();
        pos2.PositionID = 2;
        pos2.positionName = PositionName.TEST;

        Position pos3 = new Position();
        pos3.PositionID = 3;
        pos3.positionName = PositionName.SCRUM_MASTER;


        // --- PHẦN 3: ACCOUNT ---


        // Account 1
        Account acc1 = new Account();
        acc1.AccountID = 1;
        acc1.email = "nam.vti01@gmail.com"; // Thêm dòng này
        acc1.Username = "nam_vti_01";
        acc1.department = department1;
        acc1.position = pos1;
        acc1.localDate = LocalDate.now();

// Account 2
        Account acc2 = new Account();
        acc2.AccountID = 2;
        acc2.email = "trang.vti02@gmail.com"; // Thêm dòng này
        acc2.Username = "trang_vti_02";
        acc2.department = department1;
        acc2.position = pos2;
        acc2.localDate = LocalDate.of(2023, 10, 15);

// Account 3
        Account acc3 = new Account();
        acc3.AccountID = 3;
        acc3.email = "quan.vti03@gmail.com"; // Thêm dòng này
        acc3.Username = "quan_vti_03";
        acc3.department = department2;
        acc3.position = pos1;
        acc3.localDate = LocalDate.parse("2024-01-20");
        // Group 1: Nhóm Java do acc1 tạo
        Group group1 = new Group();
        group1.groupId = 1;
        group1.groupName = "Java Fresher";
        group1.account = acc1; // Gán đối tượng Account 1 làm người tạo
        group1.createDate = LocalDate.now();

        // Group 2: Nhóm Test do acc2 tạo
        Group group2 = new Group();
        group2.groupId = 2;
        group2.groupName = "Automation Test";
        group2.account = acc2; // Gán đối tượng Account 2 làm người tạo
        group2.createDate = LocalDate.of(2023, 12, 25);

        // Group 3: Nhóm Manager do acc3 tạo
        Group group3 = new Group();
        group3.groupId = 3;
        group3.groupName = "Management";
        group3.account = acc3; // Gán đối tượng Account 3 làm người tạo
        group3.createDate = LocalDate.parse("2024-04-17");


        // 1. Account 1 tham gia Group 1
        GroupAccount ga1 = new GroupAccount();
        ga1.group = group1;       // Gán đối tượng group1 đã tạo ở trên
        ga1.account = acc1;       // Gán đối tượng acc1 đã tạo ở trên
        ga1.joinDate = LocalDate.now();

        // 2. Account 2 cũng tham gia Group 1
        GroupAccount ga2 = new GroupAccount();
        ga2.group = group1;
        ga2.account = acc2;
        ga2.joinDate = LocalDate.of(2024, 3, 15);

        // 3. Account 3 tham gia Group 2
        GroupAccount ga3 = new GroupAccount();
        ga3.group = group2;
        ga3.account = acc3;
        ga3.joinDate = LocalDate.parse("2024-04-10");


        // Type 1
        TypeQuestion type1 = new TypeQuestion();
        type1.TypeID = 1;
        type1.typeName = TypeName.Essay;

        // Type 2
        TypeQuestion type2 = new TypeQuestion();
        type2.TypeID = 2;
        type2.typeName = TypeName.MultipleChoice;

        // Type 3 (Giả sử hệ thống chỉ có 2 loại, ta tạo thêm 1 cái Essay nữa)
        TypeQuestion type3 = new TypeQuestion();
        type3.TypeID = 3;
        type3.typeName = TypeName.Essay;

// --- PHẦN 7: CATEGORY QUESTION (DÙNG STRING) ---

        // Category 1
        CategoryQuestion cat1 = new CategoryQuestion();
        cat1.categoryId = 1;
        cat1.categoryName = "Java";

        // Category 2
        CategoryQuestion cat2 = new CategoryQuestion();
        cat2.categoryId = 2;
        cat2.categoryName = "SQL";

        // Category 3
        CategoryQuestion cat3 = new CategoryQuestion();
        cat3.categoryId = 3;
        cat3.categoryName = "Postman";


        // 1. Câu hỏi số 1
        Question q1 = new Question();
        q1.questionId = 1;
        q1.content = "Java là gì?";
        q1.category = cat1;
        q1.type = type1;
        q1.creator = acc1;
        q1.createDate = LocalDate.now();

        // 2. Câu hỏi số 2
        Question q2 = new Question();
        q2.questionId = 2;
        q2.content = "SQL có mấy loại Join?";
        q2.category = cat2;
        q2.type = type2;
        q2.creator = acc2;
        q2.createDate = LocalDate.of(2024, 3, 15);

        // 3. Câu hỏi số 3
        Question q3 = new Question();
        q3.questionId = 3;
        q3.content = "Postman dùng để làm gì?";
        q3.category = cat3;
        q3.type = type1;
        q3.creator = acc1;
        q3.createDate = LocalDate.parse("2024-04-10");


        Answer ans1 = new Answer();
        ans1.answerId = 1;
        ans1.content = "Java là ngôn ngữ lập trình hướng đối tượng.";
        ans1.question = q1; // Gán cho câu hỏi q1
        ans1.isCorrect = true;

        // Đáp án 2: Cho câu hỏi 1 (Sai)
        Answer ans2 = new Answer();
        ans2.answerId = 2;
        ans2.content = "Java chỉ dùng để nấu cà phê.";
        ans2.question = q1; // Gán cho câu hỏi q1
        ans2.isCorrect = false;

        // Đáp án 3: Cho câu hỏi 2 (Đúng)
        Answer ans3 = new Answer();
        ans3.answerId = 3;
        ans3.content = "Trong SQL có các loại Join như: Inner, Left, Right, Full.";
        ans3.question = q2; // Gán cho câu hỏi q2
        ans3.isCorrect = true;


        // Đề thi 1
        Exam ex1 = new Exam();
        ex1.examId = 1;
        ex1.code = "VTI001";
        ex1.title = "Đề thi Java Core";
        ex1.category = cat1;  // Gán đối tượng cat1 (có ID là 1)
        ex1.duration = 60;
        ex1.creator = acc1;    // Gán đối tượng acc1 (có ID là 1)
        ex1.createDate = LocalDate.now();

        // Đề thi 2
        Exam ex2 = new Exam();
        ex2.examId = 2;
        ex2.code = "VTI002";
        ex2.title = "Đề thi SQL";
        ex2.category = cat2;  // Gán đối tượng cat2 (có ID là 2)
        ex2.duration = 45;
        ex2.creator = acc2;    // Gán đối tượng acc2 (có ID là 2)
        ex2.createDate = LocalDate.of(2024, 4, 1);

        // Đề thi 3
        Exam ex3 = new Exam();
        ex3.examId = 3;
        ex3.code = "VTI003";
        ex3.title = "Đề thi Postman";
        ex3.category = cat3;  // Gán đối tượng cat3 (có ID là 3)
        ex3.duration = 90;
        ex3.creator = acc1;    // Gán lại đối tượng acc1
        ex3.createDate = LocalDate.parse("2024-04-15");


        ExamQuestion eq1 = new ExamQuestion();
        eq1.exam = ex1;
        eq1.question = q1;

        // 2. Cho câu hỏi 2 vào đề thi 1
        ExamQuestion eq2 = new ExamQuestion();
        eq2.exam = ex1;
        eq2.question = q2;

        // 3. Cho câu hỏi 3 vào đề thi 2
        ExamQuestion eq3 = new ExamQuestion();
        eq3.exam = ex2;
        eq3.question = q3;
//        Question 1:
//        Kiểm tra account thứ 2
//        Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
//        "Nhân viên này chưa có phòng ban"
//        Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
        if (acc2.department == null) {
            System.out.println("nhân viên này chưa có phòng ban");
        } else {
            System.out.println("phòng ban của nhân viên này là " + acc2.department.departmentName);
        }
//        Question 2:
//        Kiểm tra account thứ 2
//        Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//        Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//        Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//        Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"


//        Question 3:
//        Sử dụng toán tử ternary để làm Question 1
// --- Question 3: Toán tử 3 ngôi cho Question 1 ---
        String result = (acc2.department == null)
                ? "Nhân viên này chưa có phòng ban"
                : "Phòng ban của nhân viên này là " + acc2.department.departmentName;
        System.out.println(result);
// --- QUESTION 4: Kiểm tra Position của Account 1 bằng toán tử 3 ngôi --

        String positionCheck = (acc1.position.positionName == PositionName.DEV)
                ? "Đây là Developer"
                : "Người này không phải là Developer";

        System.out.println(positionCheck);

//        Question 5:
//        Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//        Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//        Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//        Còn lại in ra "Nhóm có nhiều thành viên"

//
//        Question 6:
//        Sử dụng switch case để làm lại Question 2
//
//        Question 7:
//        Sử dụng switch case để làm lại Question 4

        switch (acc1.position.positionName) {
            case DEV:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
                break;
        }
//        Question 8:
//        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
         Account danhsachacc[] ={acc1,acc2,acc3};

        for (Account acc : danhsachacc)
        {
            System.out.println(acc.email);
            System.out.println(acc.Username);
            System.out.println(acc.department.departmentName);
        }
//
//        Question 9:
//        In ra thông tin các phòng ban bao gồm: id và name
        Department danhsachpb []={department1,department2,department3};
        for(Department khoa: danhsachpb)
        {
            System.out.println(khoa.departmentID);
            System.out.println(khoa.departmentName);
        }
//        Question 10:
//        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//        Thông tin account thứ 1 là:
//        Email: NguyenVanA@gmail.com
//        Full name: Nguyễn Văn A
//        Phòng ban: Sale
//
//        Thông tin account thứ 2 là:
//        Email: NguyenVanB@gmail.com
//        Full name: Nguyễn Văn B
//        Phòng ban: Marketting
        for(int i=0;i<danhsachacc.length;i++)
        {
            System.out.println("Thông tin account thứ "+ (i+1)+" là " );
            System.out.println("Email" +danhsachacc[i].email);
            System.out.println("Email" +danhsachacc[i].Username);
            System.out.println("Email" +danhsachacc[i].department.departmentName);
            System.out.println("======================");
        }


//        Question 11:
//        In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//        Thông tin department thứ 1 là:
//        Id: 1
//        Name: Sale
//        Thông tin department thứ 2 là:
//        Id: 2
//        Name: Marketing

        for (int i=0;i<danhsachpb.length;i++)
        {
            System.out.println("Thông tin account thứ "+ (i+1)+" là " );
            System.out.println(danhsachpb[i].departmentID);
            System.out.println(danhsachpb[i].departmentName);
        }
//
//        Question 12:
//        Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10

        for(int i=0;i<2;i++)
        {

            System.out.println("Thông tin account thứ "+ (i+1)+" là " );
                System.out.println("Email" +danhsachacc[i].email);
                System.out.println("Email" +danhsachacc[i].Username);
                System.out.println("Email" +danhsachacc[i].department.departmentName);
                System.out.println("======================");


        }
//        Question 13:
//        In ra thông tin tất cả các account ngoại trừ account thứ 2
        for(int i=0;i<danhsachacc.length;i++)
        {

            if(danhsachacc[i].AccountID==2)
            {
                continue;
            }
            System.out.println("Thông tin account thứ "+ (i+1)+" là " );
            System.out.println("Email" +danhsachacc[i].email);
            System.out.println("Email" +danhsachacc[i].Username);
            System.out.println("Email" +danhsachacc[i].department.departmentName);
            System.out.println("======================");
        }

//        Question 14:
//        In ra thông tin tất cả các account có id < 4
        for(int i=0;i<danhsachacc.length;i++)
        {
            if(danhsachacc[i].AccountID<4)
            {
                System.out.println("Thông tin account thứ "+ (i+1)+" là " );
                System.out.println("Email" +danhsachacc[i].email);
                System.out.println("Email" +danhsachacc[i].Username);
                System.out.println("Email" +danhsachacc[i].department.departmentName);
                System.out.println("======================");
            }
        }

//        Question 15:
//        In ra các số chẵn nhỏ hơn hoặc bằng 20
          for(int i=0;i<=20;i++)
          {
              if(i%2==0)
              {
                  System.out.println(i);
              }
          }

//        Question 16: Làm lại các câu FOR bằng WHILE
//        16.1 (Làm lại Q10): In thông tin tất cả Account
        Account[] accounts = { acc1, acc2, acc3 };
        int i = 0;
        while (i < accounts.length) {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].Username);
            System.out.println("Phòng ban: " + accounts[i].department.departmentName);
            System.out.println("");
            i++;
        }
//        16.2 (Làm lại Q11): In thông tin tất cả Department
        Department[] depts = { department1, department2, department3 };
        int j = 0;
        while (j < depts.length) {
            System.out.println("Thông tin department thứ " + (j + 1) + " là:");
            System.out.println("Id: " + depts[j].departmentID);
            System.out.println("Name: " + depts[j].departmentName);
            j++;
        }
//        16.3 (Làm lại Q12): Chỉ in 2 Department đầu (Dùng break)
        int k = 0;
        while (k < depts.length) {
            if (k == 2) {
                break; // Thoát vòng lặp khi đã in xong 2 cái (index 0 và 1)
            }
            System.out.println("Thông tin department thứ " + (k + 1) + " là:");
            System.out.println("Id: " + depts[k].departmentID);
            System.out.println("Name: " + depts[k].departmentName);
            k++;
        }

//        16.4 (Làm lại Q13): In tất cả Account ngoại trừ cái thứ 2 (Dùng continue)
        int l = 0;
        while (l < accounts.length) {
            if (l == 1) { // Account thứ 2 có index là 1
                l++; // Phải tăng biến đếm trước khi continue để tránh lặp vô tận
                continue;
            }
            System.out.println("Thông tin account thứ " + (l + 1) + " là:");
            System.out.println("Email: " + accounts[l].email);
            l++;
        }
//        16.5 (Làm lại Q14): In Account có ID < 4

        int m = 0;
        while (m < accounts.length) {
            if (accounts[m].AccountID >= 4) {
                m++;
                continue;
            }
            System.out.println("Account ID < 4: " + accounts[m].Username);
            m++;
        }

//        16.6 (Làm lại Q15): In số chẵn <= 20
        int n = 0;
        while (n <= 20) {
            if (n % 2 == 0) { // Nếu n là số chẵn
                System.out.println("Số chẵn: " + n);
            }
            n++; // Luôn tăng n sau mỗi lần kiểm tra
        }

// ================== QUESTION 17: LÀM LẠI BẰNG DO-WHILE ==================

// 17.1 (Làm lại Q10): In thông tin tất cả Account
        System.out.println("--- Question 17.1: In thông tin Account ---");
        Account[] accountsArr = { acc1, acc2, acc3 };
        int a = 0;
        if (accountsArr.length > 0) {
            do {
                System.out.println("Thông tin account thứ " + (a + 1) + " là:");
                System.out.println("Email: " + accountsArr[a].email);
                System.out.println("Full name: " + accountsArr[a].Username);
                System.out.println("Phòng ban: " + (accountsArr[a].department != null ? accountsArr[a].department.departmentName : "Chưa có"));
                System.out.println("");
                a++;
            } while (a < accountsArr.length);
        }

// 17.2 (Làm lại Q11): In thông tin tất cả Department
        System.out.println("--- Question 17.2: In thông tin Department ---");
        Department[] deptsArr = { department1, department2, department3 };
        int b = 0;
        if (deptsArr.length > 0) {
            do {
                System.out.println("Thông tin department thứ " + (b + 1) + " là:");
                System.out.println("Id: " + deptsArr[b].departmentID);
                System.out.println("Name: " + deptsArr[b].departmentName);
                b++;
            } while (b < deptsArr.length);
        }

// 17.3 (Làm lại Q12): Chỉ in 2 Department đầu (Dùng break)
        System.out.println("--- Question 17.3: In 2 Department đầu ---");
        int c = 0;
        if (deptsArr.length > 0) {
            do {
                if (c == 2) {
                    break;
                }
                System.out.println("Thông tin department thứ " + (c + 1) + " là:");
                System.out.println("Id: " + deptsArr[c].departmentID);
                System.out.println("Name: " + deptsArr[c].departmentName);
                c++;
            } while (c < deptsArr.length);
        }

// 17.4 (Làm lại Q13): In Account ngoại trừ cái thứ 2 (Dùng continue)
        System.out.println("--- Question 17.4: In Account trừ cái thứ 2 ---");
        int d = 0;
        if (accountsArr.length > 0) {
            do {
                if (d == 1) { // Account thứ 2 index là 1
                    d++;
                    continue;
                }
                System.out.println("Thông tin account thứ " + (d + 1) + " là:");
                System.out.println("Email: " + accountsArr[d].email);
                d++;
            } while (d < accountsArr.length);
        }

// 17.5 (Làm lại Q14): In Account có ID < 4
        System.out.println("--- Question 17.5: In Account ID < 4 ---");
        int e = 0;
        if (accountsArr.length > 0) {
            do {
                if (accountsArr[e].AccountID >= 4) {
                    e++;
                    continue;
                }
                System.out.println("Account ID < 4: " + accountsArr[e].Username);
                e++;
            } while (e < accountsArr.length);
        }

// 17.6 (Làm lại Q15): In số chẵn <= 20
        System.out.println("--- Question 17.6: In số chẵn <= 20 ---");
        int f = 0;
        do {
            if (f % 2 != 0) {
                f++;
                continue;
            }
            System.out.println("Số chẵn: " + f);
            f++;
        } while (f <= 20);

// =========================================================================
    }
}

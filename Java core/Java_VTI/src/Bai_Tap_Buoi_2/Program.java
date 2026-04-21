package Bai_Tap_Buoi_2;

// 1. Phải import cái này thì mới dùng được ngày tháng

import java.time.LocalDate;

public class Program {
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

        System.out.println("--- Thông tin phòng ban ---");
        department1.show();
        department2.show();
        department3.show();


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

        System.out.println("--- Thông tin chức vụ ---");
        pos1.show();
        pos2.show();
        pos3.show();


        // --- PHẦN 3: ACCOUNT ---


        // Account 1
        Account acc1 = new Account();
        acc1.AccountID = 1;
        acc1.Username = "nam_vti_01";
        acc1.department = department1; // Fix: đổi dep1 thành department1
        acc1.position = pos1;
        acc1.localDate = LocalDate.now();

        // Account 2
        Account acc2 = new Account();
        acc2.AccountID = 2;
        acc2.Username = "trang_vti_02";
        acc2.department = department1; // Fix: đổi dep1 thành department1
        acc2.position = pos2;
        acc2.localDate = LocalDate.of(2023, 10, 15);

        // Account 3
        Account acc3 = new Account();
        acc3.AccountID = 3;
        acc3.Username = "quan_vti_03";
        acc3.department = department2; // Fix: đổi dep2 thành department2
        acc3.position = pos1;
        acc3.localDate = LocalDate.parse("2024-01-20");

        // --- BƯỚC 4: IN THÔNG TIN ACCOUNT ---
        System.out.println("--- Thông tin tài khoản ---");
        acc1.show();
        acc2.show();
        acc3.show();

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

        // --- IN THÔNG TIN ---
        System.out.println("--- THÔNG TIN CÁC NHÓM ĐÃ TẠO ---");
        group1.show();
        group2.show();
        group3.show();
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

        // --- IN THÔNG TIN ---
        System.out.println("--- DANH SÁCH THÀNH VIÊN TRONG NHÓM ---");
        ga1.show();
        ga2.show();
        ga3.show();


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

        // In thông tin
        System.out.println("--- DANH SÁCH LOẠI CÂU HỎI ---");
        type1.show();
        type2.show();
        type3.show();
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

        // In thông tin ra màn hình
        System.out.println("--- DANH SÁCH CHỦ ĐỀ CÂU HỎI ---");
        cat1.show();
        cat2.show();
        cat3.show();

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


        // --- 7. IN KẾT QUẢ ---
        System.out.println("========= DANH SÁCH CÂU HỎI =========");
        q1.show();
        q2.show();
        q3.show();

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

        // --- IN THÔNG TIN ---
        System.out.println("--- DANH SÁCH ĐÁP ÁN ---");
        ans1.show();
        ans2.show();
        ans3.show();


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

        // --- GỌI HÀM IN ---
        System.out.println("--- DANH SÁCH ĐỀ THI ---");
        ex1.show();
        ex2.show();
        ex3.show();


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

        // --- IN KẾT QUẢ ---
        System.out.println("--- CHI TIẾT CÂU HỎI TRONG ĐỀ THI ---");
        eq1.show();
        eq2.show();
        eq3.show();
    }


}
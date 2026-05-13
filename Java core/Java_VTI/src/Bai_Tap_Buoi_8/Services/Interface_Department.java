package Bai_Tap_Buoi_8.Services;

import Bai_Tap_Buoi_8.Entity.Department;
import Bai_Tap_Buoi_8.Entity.Position;

import java.util.List;

public interface Interface_Department {
    public List<Department> inDanhSachPhongBanCoTu2NhanVien();

    public List<Department> selectALLdepartment();
    public boolean insert(Department department);
    public boolean delete(int id);
    public boolean update(Department department);
    public Department getByid(int id);
}

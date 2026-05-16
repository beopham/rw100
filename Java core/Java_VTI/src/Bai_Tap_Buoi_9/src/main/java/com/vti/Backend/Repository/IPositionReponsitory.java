package com.vti.Backend.Repository;

import com.vti.Entity.Account;
import com.vti.Entity.Department;
import com.vti.Entity.Position;

import java.util.List;

public interface IPositionReponsitory {
    public List<Position> findAll();
    public boolean Insert(Position position);
    public boolean Update(Position position);
    public boolean Delete(int id);
    public Position selectByid(int id);
}

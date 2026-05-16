package com.vti.Backend.Service;

import com.vti.Entity.Department;
import com.vti.Entity.Position;

import java.util.List;

public interface IPositionService {
    public List<Position> findAll();
    public boolean Insert(Position position);
    public boolean Update(Position position);
    public boolean Delete(int id);
    public Position selectByid(int id);
}

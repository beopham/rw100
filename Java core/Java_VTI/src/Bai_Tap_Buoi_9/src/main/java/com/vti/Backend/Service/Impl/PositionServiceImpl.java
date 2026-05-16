package com.vti.Backend.Service.Impl;

import com.vti.Backend.Repository.IPositionReponsitory;
import com.vti.Backend.Repository.Impl.PositionReponsitoryImpl;
import com.vti.Backend.Service.IPositionService;
import com.vti.Entity.Position;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionReponsitory iPositionReponsitory=new PositionReponsitoryImpl();
    @Override
    public List<Position> findAll() {
        return iPositionReponsitory.findAll();
    }

    @Override
    public boolean Insert(Position position) {
        return iPositionReponsitory.Insert(position);
    }

    @Override
    public boolean Update(Position position) {
        return iPositionReponsitory.Update(position);
    }

    @Override
    public boolean Delete(int id) {
        return iPositionReponsitory.Delete(id);
    }

    @Override
    public Position selectByid(int id) {
        return iPositionReponsitory.selectByid(id);
    }
}

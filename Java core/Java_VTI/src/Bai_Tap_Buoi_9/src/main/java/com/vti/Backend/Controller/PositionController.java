package com.vti.Backend.Controller;

import com.vti.Backend.Service.IPositionService;
import com.vti.Backend.Service.Impl.PositionServiceImpl;
import com.vti.Entity.Position;
import com.vti.Enums.PositionName;

import java.util.List;

public class PositionController {
    private IPositionService iPositionService=new PositionServiceImpl();
    public List<Position> findAll() {
        return iPositionService.findAll();
    }

    public boolean Insert(Position position) {
        return iPositionService.Insert(position);
    }

    public boolean Update(Position position) {
        return iPositionService.Update(position);
    }

    public boolean Delete(int id) {
        return iPositionService.Delete(id);
    }

    public Position selectByid(int id) {
        return iPositionService.selectByid(id);
    }
    public boolean checkPositionNameExist(PositionName positionName) {
        return iPositionService.checkPositionNameExist(positionName);
    }
    public boolean checkId(int id) {
        return iPositionService.checkId(id);
    }
    public boolean checkExistNameAndIdNot(PositionName positionName, int id) {
        return  iPositionService.checkExistNameAndIdNot(positionName,id);
    }
}

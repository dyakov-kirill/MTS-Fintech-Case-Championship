package org.example.services;

import org.example.entities.Furnace;
import org.example.entities.FurnaceType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FurnaceFactory {

    public List<Furnace> createFurnaceList(int smallNum, int mediumNum, int bigNum) {
        List<Furnace> result = new ArrayList<>(smallNum + mediumNum + bigNum);
        for (int i = 0; i < smallNum; i++) {
            result.add(new Furnace(FurnaceType.SMALL));
        }
        for (int i = 0; i < mediumNum; i++) {
            result.add(new Furnace(FurnaceType.MEDIUM));
        }
        for (int i = 0; i < bigNum; i++) {
            result.add(new Furnace(FurnaceType.BIG));
        }
        return result;
    }
}

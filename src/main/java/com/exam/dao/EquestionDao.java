package com.exam.dao;

import com.exam.pojo.equestion;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
//题库Dao
@Repository
public class EquestionDao {
    private static Map<Integer,equestion>  equestions = null;

    static {
        equestions = new HashMap<Integer,equestion>();

        equestions.put(1, new equestion(1, "扑克牌", "娱乐", "10"));
        equestions.put(2, new equestion(2, "充电宝", "科技", "8"));
        equestions.put(3, new equestion(3, "雨伞", "生活", "5"));
        equestions.put(4, new equestion(4, "茶具", "生活", "3"));
    }

    private static Integer initId=5;

    public static void save(equestion eques){
        if(eques.getId()==null){
            eques.setId(initId++);
        }
        equestions.put(eques.getId(),eques);
    }

    //获得所有题库的信息
    public Collection<equestion> getAll(){

        return equestions.values();
    }

    //通过id得到题库
    public equestion getequestionById(Integer id){
        return equestions.get(id);
    }

    public static void delete(Integer id){
        equestions.remove(id);
    }
}

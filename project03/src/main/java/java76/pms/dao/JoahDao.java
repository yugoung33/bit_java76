package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Joah;

public interface JoahDao {
  List<Joah> selectList(Map<String,Object> paramMap);
  
  int insert(Joah joah);
  
  int delete(Map<String,Object> paramMap);
  
  int update(Joah joah);

  Joah selectOne(int no);
}








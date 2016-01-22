package java76.pms.controller.ajax;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java76.pms.dao.JoahDao;
import java76.pms.domain.AjaxResult;
import java76.pms.domain.Joah;

@Controller("ajax.JoahController")
@RequestMapping("/joah/ajax/*")
public class JoahController { 
  
  public static final String SAVED_DIR = "/attachfile";
  
  @Autowired JoahDao joahDao;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      @RequestParam(defaultValue="no") String keyword,
      @RequestParam(defaultValue="desc") String align) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);
    
    List<Joah> joahs = joahDao.selectList(paramMap);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", joahs);
    
    return resultMap;
  }
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "joah/JoahForm";
  }
      
  @RequestMapping(value="add", method=RequestMethod.POST)
  public AjaxResult add(Joah joah/*, MultipartFile file*/) throws Exception {
    /*
    if (file.getSize() > 0) {
      String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
      File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
                                  + "/" + newFileName);
      file.transferTo(attachfile);
      joah.setAttachFile(newFileName);
    }
    */
    joahDao.insert(joah);
    
    return new AjaxResult("success", null);
  }
  
  @RequestMapping("detail")
  public Object detail(int no) throws Exception {
    Joah joah = joahDao.selectOne(no);
    return new AjaxResult("success", joah);
  }

  @RequestMapping(value="update", method=RequestMethod.POST)
  public AjaxResult update(Joah joah/*, MultipartFile file*/) throws Exception {
    /*
    if (file.getSize() > 0) {
      String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
      File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
                                  + "/" + newFileName);
      file.transferTo(attachfile);
      joah.setAttachFile(newFileName);
    } else if (joah.getAttachFile().length() == 0) {
      joah.setAttachFile(null);
    }
    */
    
    if (joahDao.update(joah) <= 0) {
      return new AjaxResult("failure", null);
    } 
    
    return new AjaxResult("success", null);
  }
  
  @RequestMapping("delete.do")
  public AjaxResult delete(int no, String password) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", no);
    paramMap.put("password", password);
    
    if (joahDao.delete(paramMap) <= 0) {
      return new AjaxResult("failure", null);
    } 

    return new AjaxResult("success", null);
  }
}

package v11.server.servlet;

import java.util.HashMap;

public interface Servlet {
  void service(HashMap<String,Object> params);
}

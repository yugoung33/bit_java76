<%@ page language = "java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=EUC_KR">
<title>Title</title>
<script>
function checkID() {
      var id = document.regist.id.value;
      if( id == '' )
      {
            alert('���̵� �Է��ϼ���');
            return;
      }   
      
      var url ='IdCheck.jsp?id=' + id;
      
      window.open(url, '',  'width=300, height=350, left=0, top=0');
}
 
function enableID()
{
      document.regist.checker.disabled = false;
}
 
function disableID()
{
      document.regist.checker.disabled = true;
}
</script>
</head>
<body>
  <% request.setCharacterEncoding("euc-kr"); %>
 
  <form name="func">
            <input onclick="disableID()" type="hidden" name="disable_id" />
      </form>
 
      <form name="regist">
            <table align="center">
                  <tr>
                        <td colspan="3"><hr noshade="noshade" /></td>
                  </tr>
                  <tr>
                        <td>���̵�</td>
                        <td><input onkeyup="enableID()" type="text" name="id" /></td>
                        <td><input onclick="checkID()" type="button" name="checker" value="�ߺ�Ȯ��" /></td>
                  </tr>
            </table>
      </form>
</body>
</html>
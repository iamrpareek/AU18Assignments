<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Employee</h1>
       <form:form method="POST" action="editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="Eid" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input path="Ename"  /></td>
         </tr>  
         <tr>  
          <td>Age :</td>  
          <td><form:input path="Eage" /></td>
         </tr> 

         <tr>  
          <td> </td>  
          <td><input type="submit" value="editsave" /></td>  
         </tr>  
        </table>  
       </form:form>  

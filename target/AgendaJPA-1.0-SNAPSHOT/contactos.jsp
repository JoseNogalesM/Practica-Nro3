<%-- 
    Document   : contactos
    Created on : 19 nov. de 2023, 15:56:51
    Author     : nogal
--%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Contacto"%>
<%

List<Contacto> lista =(List<Contacto>) request.getAttribute("contacto");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Contactos </h1>
        <a href="main?action=nuevo">Crear</a>
        
        <table border="1">
            
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>telefono</th>
                    <th>Correo</th>
                    <th></th>
                    <th></th>
                </tr>
                <%
                for(Contacto item :lista){
                
                    
                %>
                <tr>
                    <td><%= item.getId()%></td>
                    <td><%= item.getNombre() %></td>
                    <td><%= item.getTelefono() %></td>
                    <td><%= item.getCorreo() %></td>
                    <td><a href="main?action=edit&id=<%= item.getId()%>">Actualizar</a></td>
                                        <th><a href="main?action=delete&id=<%= item.getId()%>">Eliminar</a></th>

                </tr>
                <%
                    }%>
            
            
        </table>

    </body>
</html>

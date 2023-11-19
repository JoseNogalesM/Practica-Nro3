package com.emergentes.controler;

import com.emergentes.bean.BeanContacto;
import com.emergentes.entidades.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "main", urlPatterns = {"/main"})
public class main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // System.out.println("Estamos en el servlet");
        //nuevo();
        //mostrar();
        //editar();
        //mostrar();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
                    Contacto c = new Contacto();
                    int id;
        BeanContacto daoContacto=new BeanContacto();

        switch (action) {
                
            case "nuevo":
                request.setAttribute("contacto",c);
                request.getRequestDispatcher("contactos-editar.jsp").forward(request, response);
                break;
            case "edit":
                id=Integer.parseInt(request.getParameter("id"));
                c=daoContacto.buscar(Integer.parseInt("id"));
                request.setAttribute("contacto", c);
                request.getRequestDispatcher("contactos.jsp").forward(request, response);
                break;
          
            case "delete":
                id= Integer.parseInt("id");
                daoContacto.elmininar(id);
                                response.sendRedirect("main");

                break;
            case "view":

                BeanContacto dao = new BeanContacto();

                List<Contacto> lista = dao.listarTodos();
                request.setAttribute("contacto", lista);
                request.getRequestDispatcher("contactos.jsp").forward(request, response);
            default:
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanContacto daoContacto=new BeanContacto();
Contacto c=new Contacto();


c.setNombre(request.getParameter("nombre"));
c.setTelefono(request.getParameter("telefono"));
c.setCorreo(request.getParameter("correo"));

if(c.getId()==0){
    System.out.println("Registro nuevo");
    daoContacto.insertar(c);
}else{
    daoContacto.editar(c);
    
}
{
                response.sendRedirect("main");
            }
    }
    //  private void editar(){
    //  BeanContacto dao= new BeanContacto();
    //  Integer id=2;
    //  Contacto c= dao.buscar(id);
    //  c.setNombre("Tapia Ricardo");
    // c.setCorreo("ricardo@gmail.com");
    // dao.editar(c);
    // }
    //private void eliminar(){

    //   BeanContacto dao= new BeanContacto();
    //  Integer id = 3;
    // dao.elmininar(id);
// }
    // private void nuevo() {
    //  BeanContacto dao = new BeanContacto();
    //   Contacto c = new Contacto();
    //  c.setNombre("Armando Terrazas");
    // c.setTelefono("21323213");
    //  c.setCorreo("armando@gmail.com");
    // dao.insertar(c);
    // }
    // private void mostrar() {
    //    for (Contacto item : lista) {
    //      System.out.println("ID:"+item.getId());
    //    System.out.println("Nombre>" +item.getNombre());
    //}
}

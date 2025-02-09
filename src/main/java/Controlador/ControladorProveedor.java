package Controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImp.ClassProveedorImp;
import model.TblProveedorcl2;

/**
 * Servlet implementation class ControladorProveedor
 */
public class ControladorProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProveedor() {
        super();
        // TODO Auto-generated constructor stub
    }//fin del constructor proveedor

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//instanciamos la respectiva clase 
		ClassProveedorImp crudimp=new ClassProveedorImp();
		//recuperamos el listado de productos de la BD
		List<TblProveedorcl2> listadoproveedores=crudimp.ListadoProveedor();
		TblProveedorcl2 tblprov=new TblProveedorcl2();
		//enviamos hacia la vista
		//almacenamos en el respectivo metodo...
		request.setAttribute("listado",listadoproveedores);

		
		//declaramos una variable tipo string
		//recibimos el valor segun la accion
		String accion=request.getParameter("accion");
		//aplicamos una condicion
		if(accion != null){
			//aplicamos un switch
			switch(accion){
			case "Modificar":
				//obtenemos el codigo	
				int cod = Integer.parseInt(request.getParameter("cod"));
				//asignamos valores
				tblprov.setIdproveedorcl2(cod);
				//buscamos el codigo a actualizar
				TblProveedorcl2 prov=crudimp.BuscarProveedor(tblprov);
				SimpleDateFormat format=new SimpleDateFormat("dd/MM/yy");
				//asignamos los valores
				//para enviarlos hacia la vista (formulario actualizar)
				request.setAttribute("codigo", prov.getIdproveedorcl2());
				request.setAttribute("nombre", prov.getNomproveecl2());
				request.setAttribute("rucprov", prov.getRucproveecl2());
				request.setAttribute("rsocial", prov.getRsocialproveecl2());
				request.setAttribute("email", prov.getEmailproveecl2());
				request.setAttribute("fechaing", format.format(prov.getFeingproveecl2()));
				
				//redireccionamos
				request.getRequestDispatcher("/FrmActualizarProveedor.jsp").forward(request, response);				
				
				//salimos 
				break;
			case "Registrar":
				//redireccionamos hacia la vista(.jsp)
				request.getRequestDispatcher("/FrmRegistrarProveedor.jsp").forward(request, response);
				//salimos
				break;
			case "Eliminar":
				//obtenemos el codigo	
				int codelim = Integer.parseInt(request.getParameter("cod"));
				//asignamos el codigo
				tblprov.setIdproveedorcl2(codelim);
				//invocamos al metodo eliminar
				crudimp.EliminarProveedor(tblprov);
				List<TblProveedorcl2> listado=crudimp.ListadoProveedor();
				//enviamos hacia la vista
				request.setAttribute("listado",listado);
				//redireccionamos
				request.getRequestDispatcher("/FrmRegistrarProveedor.jsp").forward(request, response);				
				//salimos
				break;
			case "Listar": 	
			    List<TblProveedorcl2> listadoProveedores = crudimp.ListadoProveedor();
			    request.setAttribute("listado", listadoProveedores);
				//redireccionamos hacia la vista (.jsp)
				request.getRequestDispatcher("/Main.jsp").forward(request,response);
			}//fin del switch
		}
		
	}//fin del metodo doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//recuperamos los datos del formulario
				String codigo = request.getParameter("codigo");
				String nombre = request.getParameter("nombre");
				String rucprov=request.getParameter("rucprov");
				String rsocial=request.getParameter("rsocial");
				String email=request.getParameter("email");
				Date fecha = new Date();
				Date fechasql = new Date(fecha.getTime());
				//hacer respectivas instancias...
				TblProveedorcl2 tblprov=new TblProveedorcl2();
				ClassProveedorImp climp=new ClassProveedorImp();
				//asignamos los valores	
				
				tblprov.setNomproveecl2(nombre);
				tblprov.setRucproveecl2(rucprov);
				tblprov.setRsocialproveecl2(rsocial);
				tblprov.setEmailproveecl2(email);
				tblprov.setFeingproveecl2(fechasql);
				//aplicamos una condicion 
				if(codigo!=null){
					int cod=Integer.parseInt(codigo);
					//luego asignamos el codigo a actualizar
					tblprov.setIdproveedorcl2(cod);
					//invocamos el metodo actualizar
					climp.ActualizarProveedor(tblprov);
					//invocamos el metodo registrar	
				}else {
					climp.RegistrarProveedor(tblprov);;
				}
				//actualizamos el listado
//				List<TblProveedorcl2>listado=climp.ListadoProveedor();
//				//enviamos a la vista
//				request.setAttribute("listado", listado);
//				//redireccionamos
//				request.getRequestDispatcher("/Main.jsp").forward(request,response);
				
			    // Actualizamos la lista de proveedores
			    List<TblProveedorcl2> listado = climp.ListadoProveedor();
			    request.setAttribute("listado", listado);
			    request.setAttribute("mensaje", "Dato registrado en la BD");
			    // Redirigir a FrmRegistrarProveedor.jsp para mantener la vista
			    request.getRequestDispatcher("/FrmRegistrarProveedor.jsp").forward(request, response);

		
	}//fin del metodo doPost

}//fin del controlador

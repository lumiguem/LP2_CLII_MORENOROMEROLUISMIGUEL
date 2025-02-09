package TestEntidades;

import java.util.Date;
import java.util.List;

import DaoImp.ClassProveedorImp;
import model.TblProveedorcl2;

public class TestEntidadProveedor {

	public static void main(String[] args) {
		//instanciamos la respectivas clases
		TblProveedorcl2 tbl=new TblProveedorcl2();
		ClassProveedorImp crudimp=new ClassProveedorImp();
		//asignamos los respectivos valores

//		tbl.setNomproveecl2("MIGUEL CORNEJO");
//		tbl.setRucproveecl2("20597684321");
//		tbl.setRsocialproveecl2("PROVEEDOR C");
//		tbl.setEmailproveecl2("proveedorc@mail.com");
//		Date fecha=new Date();
//		Date fechasql=new Date(fecha.getTime());
//		tbl.setFeingproveecl2(fechasql);
//		//invocamos el respectivo metodo registrar...
//		crudimp.RegistrarProveedor(tbl);
		
		//**************TESTEANDO METODO ACTUALIZAR 
		tbl.setIdproveedorcl2(2);
		tbl.setNomproveecl2("GONZALO GAMBOA");
		tbl.setRucproveecl2("20856125005");
		tbl.setRsocialproveecl2("PROVEEDOR B");
		tbl.setEmailproveecl2("proveedorb@mail.com");
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		tbl.setFeingproveecl2(fechasql);
		//invocamos el respectivo metodo actualizar.
		crudimp.ActualizarProveedor(tbl);
		
		//***********************TESTEANDO EL METODO LISTADO ...
//		List<TblProveedorcl2> listadoproveedores=crudimp.ListadoProveedor();
//		
//		//aplicamos un bucle for...
//		for(TblProveedorcl2 prov:listadoproveedores){
//			
//			//imprimir por pantalla
//			System.out.println(" codigo " + prov.getIdproveedorcl2() + " nombre " 
//			+prov.getNomproveecl2()+ " ruc " + prov.getRucproveecl2()+ " razon social "
//				+prov.getRsocialproveecl2()+ " email " + prov.getEmailproveecl2() +
//				" fecha ingreso " + prov.getFeingproveecl2());		
//		} //fin del bucle for
		
		//***********************TESTEANDO EL METODO BUSCAR...
		tbl.setIdproveedorcl2(2);
		TblProveedorcl2 buscaprov=crudimp.BuscarProveedor(tbl);
		//imprimimos por pantalla mensaje...
		System.out.println(" codigo " + buscaprov.getIdproveedorcl2() + " nombre " 
			+buscaprov.getNomproveecl2()+ " ruc " + buscaprov.getRucproveecl2()+ " razon social "
				+buscaprov.getRsocialproveecl2()+ " email " + buscaprov.getEmailproveecl2() +
				" fecha ingreso " + buscaprov.getFeingproveecl2());

	}//fin del metodo principal 

}//fin de la clase 

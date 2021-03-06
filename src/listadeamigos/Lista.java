package listadeamigos;

public class Lista {

	   Nodo primero;
	   
	   public Lista(){
		   Nodo n1 = new Nodo();
		   Nodo n2 = new Nodo();
		   Nodo n3 = new Nodo();
		   
		   Persona p1 = new Persona("111");
		   Persona p2 = new Persona("555");
		   Persona p3 = new Persona("888");
		   
		   // p1 y p2 son amigos
		   p1.amigos[5] = p2;
		   p2.amigos[3] = p1;
		   
		   // p3 y p2 son amigos
		   p3.amigos[9] = p2;
		   p2.amigos[1] = p3;
		   
		   n1.info = p1;
		   n2.info = p2;
		   n3.info = p3;
		   primero = n1;
		   n1.next = n2;
		   n2.next = n3;
	   }

	   public void eliminar(String id){
	   // Precondicion: �id� corresponde a un elemento de la lista
	   // Postcondicion: se ha eliminado el elemento de la lista 
	   //                correspondiente a �id�.
	   //                Tambi�n se han borrado (puesto a null) las referencias 
	   //                de los amigos que apuntaban a  �id�
		   if(id != null) {
			   Nodo act = primero;
			   Nodo ant = null;
			   boolean salir = false;
			   while( !salir ) { //BUSQUEDA DE REFERENCIAS
				   if( !act.info.id.equals(id) ) { //NO ES IGUAL
					   act.info.eliminarReferencias(id);
					   if( act.next == null) {
						   salir = true;
					   }else {
						   if(act.equals(primero)) {
							   ant = primero;
						   }else {
							   ant = ant.next;
						   }
						   act = act.next;
					   }
					   
				   }else if( (act.info.id.equals(id)) && (act.next != null) ) {
					   if(act.equals(primero)) {
						   primero = act.next;
					   }else {
						   ant.next = ant.next.next;
						   act.next = null;
						   act = ant.next;
					   }
				   }else if( (act.info.id.equals(id)) && (act.next == null) ) {
					   ant.next = null;
					   act = null;
					   salir = true;
				   }
			   }
		   }
	   }
	   
	   public void print(){
		   Nodo act = primero;

		   while (act != null){
			   System.out.print(act.info.id);
			   System.out.print( " Amigos: ");
			   for (Persona p: act.info.amigos) if (p != null) System.out.print(p.id + " ");
			   System.out.println();
			   act = act.next;
		   }
	   }
	
	public static void main(String[] args) {


		Lista l = new Lista();
		
		System.out.println("Lista original: ");
		l.print();
		
		l.eliminar("555");
		System.out.println("\nDespues de llamar a eliminar(555): ");
		l.print();
		
		
	}

}

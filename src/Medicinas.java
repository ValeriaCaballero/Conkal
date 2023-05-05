
public class Medicinas {
	
	String medicina; 
	int precio;
	
	
	public Medicinas() {
		
	}
	public Medicinas(String medicina, int precio) {
		//super();
		this.medicina = medicina;
		this.precio = precio;
	}

	public String getMedicina() {
		return medicina;
	}
	public void setMedicina(String medicina) {
		this.medicina = medicina;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return this.medicina;
	} 
	

}

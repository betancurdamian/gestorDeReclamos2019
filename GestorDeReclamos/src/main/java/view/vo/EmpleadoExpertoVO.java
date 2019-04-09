
package view.vo;

import model.Empleado;

/**
 *
 * @author JUANA
 */
public class EmpleadoExpertoVO {
    private Empleado empleado;
    private int cantidadTotalDeReclamo;

    public EmpleadoExpertoVO() {
        empleado= new Empleado();
    }

    
    
    
    public EmpleadoExpertoVO(Empleado empleado) {
        this.empleado = empleado;
    }

 

    public int getCantidadTotalDeReclamo() {
        return cantidadTotalDeReclamo;
    }

    public void setCantidadTotalDeReclamo(int cantidadTotalDeReclamo) {
        this.cantidadTotalDeReclamo = cantidadTotalDeReclamo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    
}

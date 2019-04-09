package controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Empleado;
import model.EstadoLineaDeReclamo;
import model.EstadoReclamo;
import model.JpaController.ClienteJpaController;
import model.JpaController.Conexion;
import model.JpaController.EmpleadoJpaController;
import model.JpaController.EstadoLineaDeReclamoJpaController;
import model.JpaController.EstadoReclamoJpaController;
import model.JpaController.LineaDeReclamoJpaController;
import model.JpaController.ReclamoJpaController;
import model.JpaController.ServicioJpaController;
import model.JpaController.TipoDeReclamoJpaController;
import model.JpaController.TipoDeUrgenciaJpaController;
import model.LineaDeReclamo;
import model.Reclamo;
import model.Servicio;
import model.TipoDeReclamo;
import model.TipoDeUrgencia;
import view.vo.EmpleadoExpertoVO;

public class ControllerProcesarReclamo {
//se crea las variables DAO.

    private final ClienteJpaController clienteDao = new ClienteJpaController(Conexion.getEntityManagerFactory());
    ;
    private final TipoDeReclamoJpaController tipoDeReclamoDao = new TipoDeReclamoJpaController(Conexion.getEntityManagerFactory());
    private final ServicioJpaController servicioDao = new ServicioJpaController(Conexion.getEntityManagerFactory());
    ;
    private  ReclamoJpaController reclamoDao = new ReclamoJpaController(Conexion.getEntityManagerFactory());
    private final TipoDeUrgenciaJpaController tipoDeUrgenciaDao = new TipoDeUrgenciaJpaController(Conexion.getEntityManagerFactory());
    private final EmpleadoJpaController empleadoDao = new EmpleadoJpaController(Conexion.getEntityManagerFactory());
    private final EstadoReclamoJpaController estadoReclamoDao = new EstadoReclamoJpaController(Conexion.getEntityManagerFactory());
    private final EstadoLineaDeReclamoJpaController estadoLineaDeReclamoDao = new EstadoLineaDeReclamoJpaController(Conexion.getEntityManagerFactory());
    private final LineaDeReclamoJpaController lineaDeReclamoDao = new LineaDeReclamoJpaController(Conexion.getEntityManagerFactory());

//Se crea las variables de las clases.
    private Cliente unClienteReclamo;
    private Empleado unEmpleadoExperto;
    private Servicio unServicioReclamo;
    private TipoDeReclamo unTipoDeReclamo;
    private String UnaDescripcionInicialReclamo;
    private TipoDeUrgencia unTipoDeUrgenciaReclamo;
    private Reclamo unReclamo;
    private EstadoReclamo unEstadoReclamo;
    private List<EmpleadoExpertoVO> listaDeEmpleadosExpertos;
    private EstadoLineaDeReclamo unEstadoLineaDeReclamo;
    private EmpleadoExpertoVO empleadoExpertoVO;
    private LineaDeReclamo lineaDeReclamoNueva;

    public ControllerProcesarReclamo() {
        listaDeEmpleadosExpertos = new ArrayList<>();

    }

//------------------------------------------PANEL 1-----------------------------------------
//se crea la tabla CLIENTE 
//Listar los cliente en una tabla    
    public void ListarClientes(JTable tabla, String dni) {
        //se crea el modelo
        DefaultTableModel model;
        //la cantidad de columnas
        String[] titulo = {"DNI", "APELLIDO", "NOMBRE", "NRO CLIENTE"};

        model = new DefaultTableModel(null, titulo) {
            @Override
            //hace que las 4 columnas no sean editables.
            public boolean isCellEditable(int row, int column) {
                if (column == 4) {
                    return true;
                } else {

                    return false;
                }
            }
        };
        List<Cliente> clientebd = buscarCliente(dni);

        String[] datosPersonas = new String[4];

        for (Cliente cliente : clientebd) {
            datosPersonas[0] = cliente.getDni();
            datosPersonas[1] = cliente.getApellido();
            datosPersonas[2] = cliente.getNombre();
            datosPersonas[3] = cliente.getNroCliente() + "";
            model.addRow(datosPersonas);
        }
        tabla.setModel(model);
    }

//buscar cliente en base de datos.
    private List<Cliente> buscarCliente(String dni) {

        EntityManager em = clienteDao.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.dni LIKE :dni");
        query.setParameter("dni", dni + "%");
        List<Cliente> lista = query.getResultList();

        return lista;

    }

    //se busca al cliente en la BD
    //comparando el cliente parametro con el cliente recorrido de la BD
    //retorna un cliente encontrado     
    public Cliente encontrarCliente(Cliente clienteParametro) {
        Cliente clienteRetorno = null;
        for (Cliente clienteRecorrido : clienteDao.findClienteEntities()) {
            if (clienteRecorrido.getDni().equals(clienteParametro.getDni())) {
                clienteRetorno = clienteRecorrido;
            }
        }

        return clienteRetorno;

    }

//-----------------------------------------FIN PANEL 1----------------------------------------
//----------------------------------------PANEL 2---------------------------------------------  
    //Busca los servicio de la BD 
    //retorna una lista de servicio
    public List<Servicio> buscarServicio() {
        List<Servicio> tiposDeServicios = new ArrayList<>();
        for (Servicio recorridoServicio : servicioDao.findServicioEntities()) {
            tiposDeServicios.add(recorridoServicio);
        }
        return tiposDeServicios;
    }

    //se busca un servicio en la BD
    //retorna un servicio encontrado
    public Servicio encontrarServicio(String tipoServicio) {
        Servicio servicioAuxiliar = null;

        for (Servicio recorridoServicio : servicioDao.findServicioEntities()) {
            if (recorridoServicio.getDescripcion().equals(tipoServicio)) {
                servicioAuxiliar = recorridoServicio;
            }
        }
        return servicioAuxiliar;
    }

//---------------------------------------fin panel 2-------------------------------------------------------------
//------------------------------------------PANEL 3--------------------------------------------
//Trae una lista de Tipos de reclamos de la BD 
    //De acuerdo al servicio que se paso como parametro
    //retorna una lista de tipo de reclamo 
    public List<TipoDeReclamo> ListarTipoDeReclamos(Servicio servicioParametro) {
        List<TipoDeReclamo> listaTiposDeReclamos = new ArrayList<TipoDeReclamo>();
        for (TipoDeReclamo tipoDeReclamoRecorrido : tipoDeReclamoDao.findTipoDeReclamoEntities()) {
            if (tipoDeReclamoRecorrido.getServicio().equals(servicioParametro)) {
                listaTiposDeReclamos.add(tipoDeReclamoRecorrido);

            }
        }
        return listaTiposDeReclamos;
    }

//buscar tipo de reclamo 
//comparando el parametro codigo con tipo de reclamo recorrido de la BD 
//retorna un tipo de reclamo
    public TipoDeReclamo buscarTipoDeReclamoId(int codigo) {
        TipoDeReclamo retorno = null;
        for (TipoDeReclamo tipoDeReclamoRecorrido : tipoDeReclamoDao.findTipoDeReclamoEntities()) {
            if (tipoDeReclamoRecorrido.getId() == codigo) {
                retorno = tipoDeReclamoRecorrido;
            }
        }
        return retorno;
    }

//trae una lista de tipo de reclamo de la BD
//compara el parametro motivo con  el motivo de la BD
//Retorna una lista de tipos de reclamos    
    public List<TipoDeReclamo> ListarTipoDeReclamosMotivo(String motivo) {
        List<TipoDeReclamo> listaTiposDeReclamos = new ArrayList<TipoDeReclamo>();
        for (TipoDeReclamo tipoDeReclamoRecorrido : tipoDeReclamoDao.findTipoDeReclamoEntities()) {
            if (tipoDeReclamoRecorrido.getDescripcion().equals(motivo)) {
                listaTiposDeReclamos.add(tipoDeReclamoRecorrido);

            }
        }
        return listaTiposDeReclamos;
    }

//    public TipoDeReclamo encontrarTipoDeReclamo(String motivo) {
//        TipoDeReclamo tipoDeReclamoAuxiliar = null;
//
//        for (TipoDeReclamo recorridoTipoDeReclamo : tipoDeReclamoDao.findTipoDeReclamoEntities()) {
//            if (recorridoTipoDeReclamo.getDescripcion().equals(motivo)) {
//                tipoDeReclamoAuxiliar = recorridoTipoDeReclamo;
//            }
//        }
//
//        return tipoDeReclamoAuxiliar;
//
//    }
//-----------------------------------------FIN PANEL 3----------------------------------------
//----------------------------------------PANEL 5-----------------------------------------------------------
//buscar tipo de urgencia 
//comparando el parametro tipo de urgencia con tipo de urgencia recorrido de la BD 
//retorna un tipo de urgencia  
    public TipoDeUrgencia encontrarTipoDeUrgencia(String tipoUrgencia) {
        TipoDeUrgencia tipoUrgenciaAuxiliar = null;

        for (TipoDeUrgencia recorridoTipoUrgencia : tipoDeUrgenciaDao.findTipoDeUrgenciaEntities()) {
            if (recorridoTipoUrgencia.getDescripcion().equals(tipoUrgencia)) {
                tipoUrgenciaAuxiliar = recorridoTipoUrgencia;
            }
        }
        return tipoUrgenciaAuxiliar;
    }

//----------------------------------------------FIN PANEL 5------------------------------------------------
//-------------------------------------------------PANEL 6---------------------------------------------------
//buscar un empleado 
//comparando el parametro apellido con el apellido recorrido de la BD 
//retorna un empleado
    public Empleado encontrarEmpleado(String apellido) {
        Empleado empleadoAuxiliar = null;

        for (Empleado recorridoEmpleado : empleadoDao.findEmpleadoEntities()) {
            if (recorridoEmpleado.getApellido().equals(apellido)) {
                empleadoAuxiliar = recorridoEmpleado;
            }
        }
        return empleadoAuxiliar;
    }

//buscar un Estado linea de reclamo
//comparando el parametro estado linea de reclamo con el estado linea de reclamo recorrido de la BD 
//retorna un Estado linea de Reclamo 
    public EstadoLineaDeReclamo encontrarEstadoLineaDeReclamo(String estadoLineaDeReclamoParametro) {
        EstadoLineaDeReclamo estadoLineaReclamoAuxiliar = null;

        for (EstadoLineaDeReclamo recorridoEstadoLineaDeReclamo : estadoLineaDeReclamoDao.findEstadoLineaDeReclamoEntities()) {
            if (recorridoEstadoLineaDeReclamo.getDescripcion().equals(estadoLineaDeReclamoParametro)) {
                estadoLineaReclamoAuxiliar = recorridoEstadoLineaDeReclamo;
            }
        }
        return estadoLineaReclamoAuxiliar;
    }

    //buscar un Estado Reclamo
//comparando el parametro estado con el estado recorrido de la BD 
//retorna un Estado Reclamo 
    public EstadoReclamo encontrarEstadoDeReclamo(String estadoReclamoParametro) {
        EstadoReclamo estadoReclamoAuxiliar = null;

        for (EstadoReclamo recorridoEstadoReclamo : estadoReclamoDao.findEstadoReclamoEntities()) {
            if (recorridoEstadoReclamo.getDescripcion().equals(estadoReclamoParametro)) {
                estadoReclamoAuxiliar = recorridoEstadoReclamo;
            }
        }
        return estadoReclamoAuxiliar;
    }

//busca los empleados expetos de la BD
//Retorna una lista de empleado expertos.
    public void cargarEmpleadoExperto() {
        //recorre
        for (Empleado empleadoRecorrido : empleadoDao.findEmpleadoEntities()) {
            if (empleadoRecorrido.getUnTipoEmpleado().getDescripcion().equals("Experto")) {

                EmpleadoExpertoVO unEmpleadoExperto = new EmpleadoExpertoVO(empleadoRecorrido);
                unEmpleadoExperto.setCantidadTotalDeReclamo(cantidadTotalDeReclamosDeEmpleadoExperto(empleadoRecorrido));
                listaDeEmpleadosExpertos.add(unEmpleadoExperto);
            }
        }
    }

//este metodo trae la cantidad total de reclamos de un empleado experto  
//si el empleado es experto, se compara el parametro empleado con el empleado recorrido
//retorna la cantidad de reclamo del empleado
    public int cantidadTotalDeReclamosDeEmpleadoExperto(Empleado unEmpleadoExpertoParam) {
        int cantidadDeReclamos = 0;

        if (unEmpleadoExpertoParam.getUnTipoEmpleado().getDescripcion().equals("Experto")) {

            for (Reclamo reclamoRecorrido : reclamoDao.findReclamoEntities()) {
                if (reclamoRecorrido.getUnEmpleadoExperto().getApellido().equals(unEmpleadoExpertoParam.getApellido())) {
                    cantidadDeReclamos++;
                }
            }
        } else {
            System.out.println("El empleado no es experto");
        }
        return cantidadDeReclamos;
    }

//se busca en la BD el empleado que mas reclamos tenga resuelto
//retorna el empleado
    public Empleado encontrarEmpleadoExpertoParaReclamoCritico() {
        Empleado empleadoAux = null;
        int totalDeReclamos = 0;
//        int cantidadDeReclamosAux = 0;

        for (EmpleadoExpertoVO empleadoRecorrido : getListaDeEmpleadosExpertos()) {
            if (empleadoRecorrido.getCantidadTotalDeReclamo() > totalDeReclamos) {
                totalDeReclamos = empleadoRecorrido.getCantidadTotalDeReclamo();
                empleadoAux = empleadoRecorrido.getEmpleado();
            }
        }
        return empleadoAux;
    }

//Se busca el empleado que menos reclamos tenga asignado
//se retorna el empleado
    public Empleado encontrarEmpleadoExpertoParaReclamoUrgente() {
        int valorInicial = 0;
        int index = 0;
        int contador = 0;
        if (getListaDeEmpleadosExpertos().size() > 0) {
            valorInicial = listaDeEmpleadosExpertos.get(0).getCantidadTotalDeReclamo();
            for (EmpleadoExpertoVO empleadoRecorrido : getListaDeEmpleadosExpertos()) {
                contador++;
                if (empleadoRecorrido.getCantidadTotalDeReclamo() < valorInicial) {
                    index = contador - 1;
                }
            }
        }
        return listaDeEmpleadosExpertos.get(index).getEmpleado();
    }

//para asignar un reclamo a un empleado experto
//se debe cumplir dos condiciones
//si el reclamo es critico se le asigna al empleado que mas reclamos haya resuelto
//si el reclamo es urgente se le asigna al empleado que menos reclamos tenga resuelto
    public void asignarEmpleadoExpertoReclamo(Reclamo unReclamoParametro) {
        Empleado empleadoAuxiliar = null;
        if (unReclamoParametro.getUnTipoDeUrgencia().getDescripcion().equals("critico")) {
            empleadoAuxiliar = this.encontrarEmpleadoExpertoParaReclamoCritico();
            System.out.println("EMPLEADO Critico: " + empleadoAuxiliar);

        }
        if (unReclamoParametro.getUnTipoDeUrgencia().getDescripcion().equals("urgente")) {
            empleadoAuxiliar = this.encontrarEmpleadoExpertoParaReclamoUrgente();
            System.out.println("EMPLEADO URGENTE: " + empleadoAuxiliar);
        }
        if (empleadoAuxiliar != null) {
            unReclamoParametro.setUnEmpleadoExperto(empleadoAuxiliar);
        }
        System.out.println("empleado auxiliar al final del metodo: " + empleadoAuxiliar);
    }
//---------------------------------------------FIN PANEL 6----------------------------------------------------------------

//----------------------------------------------PANEL BUSCAR RECLAMO DE CLIENTE-------------------------------------
//    public List<Cliente> ListaDeReclamos(String dniParametro) {
//        List<Cliente> listaDeReclamos = new ArrayList<>();
//        for (Cliente clienteRecorrido : clienteDao.findClienteEntities()) {
//            if (clienteRecorrido.getDni().equals(dniParametro)) {
//                listaDeReclamos.add(clienteRecorrido);
//
//            }
//        }
//        return listaDeReclamos;
//    }
    public List<Reclamo> ListaDeReclamos(String dniParametro) {
        List<Reclamo> listaDeReclamos = new ArrayList<Reclamo>();
        for (Reclamo clienteRecorrido : reclamoDao.findReclamoEntities()) {
            if (clienteRecorrido.getUnCliente().getDni().equals(dniParametro)) {
                listaDeReclamos.add(clienteRecorrido);

            }
        }
        return listaDeReclamos;
    }
//-----------------------------------------------FIN PANEL BUSCAR RECLAMO DE CLIENTE-----------------------------------

    public void guardarReclamo(Reclamo reclamo) {
       reclamoDao.create(reclamo);
    }

    public Cliente getUnClienteReclamo() {
        return unClienteReclamo;
    }

    public void setUnClienteReclamo(Cliente unClienteReclamo) {
        this.unClienteReclamo = unClienteReclamo;
    }

    public Servicio getUnServicioReclamo() {
        return unServicioReclamo;
    }

    public void setUnServicioReclamo(Servicio unServicioReclamo) {
        this.unServicioReclamo = unServicioReclamo;
    }

    public TipoDeReclamo getUnTipoDeReclamo() {
        return unTipoDeReclamo;
    }

    public void setUnTipoDeReclamo(TipoDeReclamo unTipoDeReclamo) {
        this.unTipoDeReclamo = unTipoDeReclamo;
    }

    public TipoDeUrgencia getUnTipoDeUrgenciaReclamo() {
        return unTipoDeUrgenciaReclamo;
    }

    public void setUnTipoDeUrgenciaReclamo(TipoDeUrgencia unTipoDeUrgenciaReclamo) {
        this.unTipoDeUrgenciaReclamo = unTipoDeUrgenciaReclamo;
    }

    public EstadoReclamo getUnEstadoReclamo() {
        return unEstadoReclamo;
    }

    public void setUnEstadoReclamo(EstadoReclamo unEstadoReclamo) {
        this.unEstadoReclamo = unEstadoReclamo;
    }

    public Reclamo getUnReclamo() {
        return unReclamo;
    }

    public void setUnReclamo(Reclamo unReclamo) {
        this.unReclamo = unReclamo;
    }

    public Empleado getUnEmpleadoExperto() {
        return unEmpleadoExperto;
    }

    public void setUnEmpleadoExperto(Empleado unEmpleadoExperto) {
        this.unEmpleadoExperto = unEmpleadoExperto;
    }

    public List<EmpleadoExpertoVO> getListaDeEmpleadosExpertos() {
        return listaDeEmpleadosExpertos;
    }

    public EstadoLineaDeReclamo getUnEstadoLineaDeReclamo() {
        return unEstadoLineaDeReclamo;
    }

    public void setUnEstadoLineaDeReclamo(EstadoLineaDeReclamo unEstadoLineaDeReclamo) {
        this.unEstadoLineaDeReclamo = unEstadoLineaDeReclamo;
    }

    public String getUnaDescripcionInicialReclamo() {
        return UnaDescripcionInicialReclamo;
    }

    public void setUnaDescripcionInicialReclamo(String UnaDescripcionInicialReclamo) {
        this.UnaDescripcionInicialReclamo = UnaDescripcionInicialReclamo;
    }

    public LineaDeReclamo getLineaDeReclamoNueva() {
        return lineaDeReclamoNueva;
    }

    public void setLineaDeReclamoNueva(LineaDeReclamo lineaDeReclamoNueva) {
        this.lineaDeReclamoNueva = lineaDeReclamoNueva;
    }

}

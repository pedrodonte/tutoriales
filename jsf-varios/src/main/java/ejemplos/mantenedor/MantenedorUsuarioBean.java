package ejemplos.mantenedor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "mantenedorBean")
@SessionScoped
public class MantenedorUsuarioBean implements Serializable {

	private static final long serialVersionUID = -6511074107707618792L;

	public enum ModosEdicion {
		OFF, EDIT, NEW
	};

	Logger logger = Logger.getGlobal();

	private List<Usuario> registros = new ArrayList<Usuario>();
	private Usuario seleccionado;
	private Usuario usuarioEnEdicion;

	private boolean mostrarFormulario = false;
	private ModosEdicion modo = ModosEdicion.OFF;

	public void doNuevo(ActionEvent event) {
		setUsuarioEnEdicion(new Usuario());
		initNuevoRegistro();
	}

	public void doEliminar(ActionEvent event) {
		Usuario usuario = (Usuario) event.getComponent().getAttributes()
				.get("usuario");
		logger.info("Eliminando " + usuario.toString());
		registros.remove(usuario);
		mensaje("Ultima Acción: Elimina Registro");
	}

	public void doEditar(ActionEvent event) {
		Usuario usuario = (Usuario) event.getComponent().getAttributes()
				.get("usuario");
		try {
			seleccionado = usuario;
			usuarioEnEdicion = (Usuario) usuario.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		logger.info("Editando " + usuarioEnEdicion.toString());
		initEditarRegistro();
	}

	public void doCerrarFormulario(ActionEvent event) {
		mostrarFormulario = false;
		setModo(ModosEdicion.OFF);
	}

	public void doGuardarFormulario(ActionEvent event) {
		logger.info("Registro a Guardar: " + usuarioEnEdicion);
		try {

			if (modo.equals(ModosEdicion.NEW)) {
				logger.info("Ultima Acción: Nuevo Registro");
				mensaje("Ultima Acción: Nuevo Registro");
				usuarioEnEdicion.setCodigo(Usuario.generarSecuencia());
				registros.add(usuarioEnEdicion);
				
			} else if (modo.equals(ModosEdicion.EDIT)) {
				logger.info("Ultima Acción: Actualiza Registro");
				mensaje("Ultima Acción: Actualiza Registro");
				registros.remove(seleccionado);
				registros.add(usuarioEnEdicion);
				
			} else {
				logger.info("No se hace nada con el registro");
			}
			mostrarFormulario = false;
			setModo(ModosEdicion.OFF);
			Collections.sort(registros, new UsuarioComparador());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mensaje(String string) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", string));
	}

	@PostConstruct
	public void init() {
		registros.add(new Usuario("pedrodonte", "pedrodonte@gmail.com"));
		registros.add(new Usuario("snoopy", "snopdog@hotmail.com"));
		registros.add(new Usuario("larry", "larrcas@yahoo.es"));
		registros.add(new Usuario("xena", "xenawarrior@penta.org"));
		registros.add(new Usuario("lex", "lexlutor@pinpon.cl"));
		registros.add(new Usuario("pepito", "pep@terra.net"));
		registros.add(new Usuario("jhonny", "rambo@balas.es"));
	}

	private void initNuevoRegistro() {
		modo = ModosEdicion.NEW;
		mostrarFormulario = true;
	}

	private void initEditarRegistro() {
		modo = ModosEdicion.EDIT;
		mostrarFormulario = true;
	}

	public List<Usuario> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Usuario> registros) {
		this.registros = registros;
	}

	public Usuario getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(Usuario seleccionado) {
		this.seleccionado = seleccionado;
	}

	public ModosEdicion getModo() {
		return modo;
	}

	public void setModo(ModosEdicion modo) {
		this.modo = modo;
	}

	@Override
	public String toString() {
		return "MantenedorUsuarioBean [registros=" + registros
				+ ", usuarioEnEdicion=" + usuarioEnEdicion
				+ ", mostrarFormulario=" + mostrarFormulario + ", modo=" + modo
				+ "]";
	}

	public Usuario getUsuarioEnEdicion() {
		return usuarioEnEdicion;
	}

	public void setUsuarioEnEdicion(Usuario usuarioEnEdicion) {
		this.usuarioEnEdicion = usuarioEnEdicion;
	}

	public boolean isMostrarFormulario() {
		return mostrarFormulario;
	}

	public void setMostrarFormulario(boolean mostrarFormulario) {
		this.mostrarFormulario = mostrarFormulario;
	}

}

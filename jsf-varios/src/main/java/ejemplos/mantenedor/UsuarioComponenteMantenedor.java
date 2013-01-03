package ejemplos.mantenedor;

import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

@FacesComponent(value = "UsuarioComponenteMantenedor")
public class UsuarioComponenteMantenedor extends UIInput implements NamingContainer {

	@Override
	public String getFamily() {
		return ("javax.faces.NamingContainer");
	}

	@Override
	public Object getSubmittedValue() {
		return (this);
	}

	@Override
	protected Object getConvertedValue(FacesContext context,
			Object newSubmittedValue) throws ConverterException {
		UIInput nombreComponent = (UIInput) findComponent("nombre");
		UIInput correoComponent = (UIInput) findComponent("correo");
		
		Usuario usuario = new Usuario();
		usuario.setCorreo((String) correoComponent.getValue());
		usuario.setNombre((String) nombreComponent.getValue());
		return usuario;
	}
}
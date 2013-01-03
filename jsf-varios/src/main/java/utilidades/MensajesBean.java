package utilidades;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MensajesBean  implements java.io.Serializable {

	private static final long serialVersionUID = 161848263L;

	public void msgInfo(String msg) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"INFO", msg));  
    }  
  
    public void msgWarn(String msg) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"ALERTA", msg));  
    }  
  
    public void msgError(String msg) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", msg));  
    }  
  
    public void msgFatal(String msg) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"FATAL", msg));  
    } 

}

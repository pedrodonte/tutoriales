package ejemplos;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
@ManagedBean
@ViewScoped
public class IndexBean implements Serializable {

    private static final long serialVersionUID = -6989441633260622062L;
    private int count;

    public int getCount() {
        return count;
    }

    public void update(AjaxBehaviorEvent event) {
        count++;
    }
}

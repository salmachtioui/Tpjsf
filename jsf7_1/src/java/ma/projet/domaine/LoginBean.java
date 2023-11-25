package ma.projet.domaine;

import com.sun.faces.context.SessionMap;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class LoginBean {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        // Perform authentication logic here
        if ("yahyachtioui".equals(username) && "123456".equals(password)) {
            // Successful login
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            SessionMap sessionMap = (SessionMap) externalContext.getSessionMap();
            sessionMap.put("username", username);
            return "employeForm?faces-redirect=true";
        } else {
            // Unsuccessful login
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
            return null;
        }
       
    }
    public String logout() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);
        session.invalidate();
        return "login?faces-redirect=true";
    }
}

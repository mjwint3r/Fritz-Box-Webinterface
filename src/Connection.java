import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * The class {@code Connection} represents a Connection to a website.
 * 
 * @author moritz
 * 
 */
public class Connection {
    
    private String loginActionName;
    private String loginUserNameParameter;
    private String loginPasswordParameterName;
    
    private String loginUserName;
    private String loginPassword;
    
    private URL targetURL;
    
    public Connection(String loginActionName, String loginUserNameParameter,
	    String loginPasswordParameterName, String loginUserName,
	    String loginPassword, String url) throws MalformedURLException {
	this.loginActionName = loginActionName;
	this.loginUserNameParameter = loginUserNameParameter;
	this.loginPasswordParameterName = loginPasswordParameterName;
	this.loginUserName = loginUserName;
	this.loginPassword = loginPassword;
	this.setTargetURL(url);
    }
    
    public Connection(String loginActionName, String loginUserNameParameter,
	    String loginPasswordParameterName, String loginUserName,
	    String loginPassword) {
	this.loginActionName = loginActionName;
	this.loginUserNameParameter = loginUserNameParameter;
	this.loginPasswordParameterName = loginPasswordParameterName;
	this.loginUserName = loginUserName;
	this.loginPassword = loginPassword;
	this.targetURL = null;
    }

    public Connection() {
	this.loginActionName = "";
	this.loginUserNameParameter = "";
	this.loginPasswordParameterName = "";
	this.loginUserName = "";
	this.loginPassword = "";
	this.targetURL = null;
    }
    
    
    public String getLoginActionName() {
        return this.loginActionName;
    }

    public void setLoginActionName(String loginActionName) {
        this.loginActionName = loginActionName;
    }

    public String getLoginUserNameParameter() {
        return this.loginUserNameParameter;
    }

    public void setLoginUserNameParameter(String loginUserNameParameter) {
        this.loginUserNameParameter = loginUserNameParameter;
    }

    public String getLoginPasswordParameterName() {
        return this.loginPasswordParameterName;
    }

    public void setLoginPasswordParameterName(String loginPasswordParameterName) {
        this.loginPasswordParameterName = loginPasswordParameterName;
    }

    public String getLoginUserName() {
        return this.loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public URL getTargetURL() {
        return this.targetURL;
    }

    public void setTargetURL(String url) throws MalformedURLException {
	if (url.substring(0, 7).equals("http://")) {
		this.targetURL = new URL(url);
	    } else {
		this.targetURL = new URL("http://" + url);
	    }
    }

    /**
     * Returns the html-sourcecode from the website at url.
     * 
     * @param url
     *            the specified URL
     * @return the html-sourcecode
     * @throws MalformedURLException
     * @throws IOException
     */
    public String getSite() throws MalformedURLException, IOException {
	String code = "";
	InputStream is = null;

	
	is = this.targetURL.openStream(); // = openConnection().getInputStream();
	code = new Scanner(is).useDelimiter("\\Z").next();

	if (is != null) {
	    is.close();
	}

	return code;
    }

    

}

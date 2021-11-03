package task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebAddressParser {
    private URL address;
    public WebAddressParser(String address){
        try {
            this.address = new URL(address);
        }
        catch (MalformedURLException e){
            this.address = null;
        }
    }
    public String getLogin(){
        if (isValid()){
            String[] Authority = address.getAuthority().split("@");
            if (Authority.length >= 2){
                String[] Info = Authority[0].split(":");
                if (Info.length >= 2){
                    return Info[0];
                }
            }
        }
        return "";
    }
    public String getPassword(){
        if (isValid()){
            String[] Authority = address.getAuthority().split("@");
            if (Authority.length >= 2){
                String[] Info = Authority[0].split(":");
                if (Info.length >= 2){
                    return Info[1];
                }
            }
        }
        return "";
    }
    public String getScheme(){
        if (isValid()){
            return address.getProtocol();
        }
        return "";
    }
    public boolean isValid(){
        if (address != null){
            return true;
        }
        return false;
    }
    public String getHost(){
        if (isValid()){
            return address.getHost();
        }
        return "";
    }
    public String getPort(){
        if (isValid() && address.getPort() != -1){
            return Integer.toString(address.getPort());
        }
        return "";
    }
    public String getUrl(){
        if (isValid()){
            return address.getPath().replaceFirst("/", "");
        }
        return "";
    }
    public HashMap<String, String> getParameters(){
        HashMap<String, String> Parameters = new HashMap<>();
        if (isValid() && address.getQuery() != null){
            String[] a = address.getQuery().split("&");
            String b[];
            for (int i = 0; i < a.length; ++i){
                b = a[i].split("=");
                Parameters.put(b[0], b[1]);
            }
        }
        return Parameters;
    }
    public String getFragment(){
        if (isValid() && address.getRef() != null){
            return address.getRef();
        }
        return "";
    }
}

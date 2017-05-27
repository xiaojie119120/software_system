package cn.jiesunshine.software_system.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	HttpServletRequest orgRequest = null;  
	  
    public XssHttpServletRequestWrapper(HttpServletRequest request) {  
        super(request);  
        orgRequest = request;  
    }  
  
    /** 
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤 
     */  
    @Override  
    public String getParameter(String name) {  
        String value = super.getParameter(xssEncode(name));  
        if (value != null) {  
            value = xssEncode(value);  
        }  
        return value;  
    }  
    

	/** 
     * 覆盖getParameterValues方法，将参数名和参数值都做xss过滤 
     */  
    @Override
    public String[] getParameterValues(String parameter) {  
        String[] values = super.getParameterValues(parameter); 
        
        if (values==null)  {  
            return null;  
        }  
        int count = values.length;  
        String[] encodedValues = new String[count];  
        for (int i = 0; i < count; i++) {  
            encodedValues[i] = xssEncode(values[i]);  
        }  
        return encodedValues;  
    }  
      
    /** 
     * 获取request的属性时，做xss过滤 
     */  
     @Override  
    public Object getAttribute(String name) {  
        Object value = super.getAttribute(name);  
        if (null != value && value instanceof String) {  
            value = xssEncode((String) value);  
        }  
        return value;  
    };  
      
    /** 
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/> 
     */  
    @Override  
    public String getHeader(String name) {  
        String value = super.getHeader(xssEncode(name));  
        if (value != null) {  
            value = xssEncode(value);  
        }  
        return value;  
    }  
      
      
    /** 
     * 将容易引起xss漏洞的半角字符直接替换成全角字符 
     *  
     * @param s 
     * @return 
     */  
    private static String xssEncode(String s) {  
        if (s == null || s.isEmpty()) {  
            return s;  
        }  
        try {  
        	StringBuilder sb = new StringBuilder(s.length());
    		for (int i = 0, c = s.length(); i < c; i++) {
    			char ch = s.charAt(i);
    			switch (ch) {
    			case '&':
    				sb.append("&amp;");
    				break;
    			case '<':
    				sb.append("&lt;");
    				break;
    			case '>':
    				sb.append("&gt;");
    				break;
    			default:
    				sb.append(ch);
    			}
    		}
    		return sb.toString();
        } catch (NullPointerException e) {  
            return s;  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
  
        return null;  
    }  
  
    /** 
     * 获取最原始的request 
     *  
     * @return 
     */  
    public HttpServletRequest getOrgRequest() {  
        return orgRequest;  
    }  
  
    /** 
     * 获取最原始的request的静态方法 
     *  
     * @return 
     */  
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {  
        if (req instanceof XssHttpServletRequestWrapper) {  
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();  
        }  
  
        return req;  
    }
}

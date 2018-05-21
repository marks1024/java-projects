package kz.edu.nu.cs.teaching;

/**
 * This class is intended to serve as an example for computing 
 * code metrics.  In particular, we want to find the cyclomatic complexity
 * of toString() and the Lack of Cohesion on Methods (LCOM). 
 * 
 * @author marksterling
 *
 */
public class CodeMetricsExample {
    String id;
    String[] props;
    
    public CodeMetricsExample(String id) {
        this.id = id;
    }

    public String[] getProps() {
        return props;
    }

    public void setProps(String... props) {
        this.props = props;
    }

    @Override
    public String toString() {
        String res = "Code Metrics Example: ";
        if (props==null) {
            return res + id;
        } else {
            if (id.length() > 10) {
                res += id.substring(0, 5) + "...";
            } else {
                res += id;
            }
            
            res += " [";
            for (String s : props) {
                res += s;
                if (!s.equals(props[props.length - 1])) {
                    res += ", ";
                }
            }
            res += "]";
            return res;
        }
    }
    
    public static void main(String[] args) {
        CodeMetricsExample e = new CodeMetricsExample("thisisalongname");
        e.setProps("Juniper", "Birch");
        
        System.out.println(e);
    }
}

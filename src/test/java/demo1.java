import edu.ustc.iot.test.fu;
import edu.ustc.iot.test.zi;
import org.springframework.beans.BeanUtils;

public class demo1 {
    public static void main(String[] args) {
        fu zi = new zi("zi_namee");
        fu hun = new zi();

        BeanUtils.copyProperties(zi,hun);
        System.out.println(hun);
    }
}

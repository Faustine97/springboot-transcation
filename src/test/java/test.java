import com.ucar.train.test.config.BeanConfiguration;
import com.ucar.train.test.vo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class test {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        User user = (User)ac.getBean("user");
        System.out.println(user.toString());
    }
}

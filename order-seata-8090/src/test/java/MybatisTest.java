import com.it.alibaba.service.impl.PaymentServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author JiangKangWei
 * @create 2022/9/2 11:55
 */
@SpringBootTest
public class MybatisTest {

    @Autowired
    private PaymentServiceImpl paymentService;
    @Test
    public void test(){
        System.out.println(paymentService.getPayment(1L));
    }
}

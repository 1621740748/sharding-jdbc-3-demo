package shardingsphere.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import shardingsphere.demo.entity.Order;
import shardingsphere.demo.mapper.OrderCopyMapper;
import shardingsphere.demo.mapper.OrderMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderCopyMapper orderCopyMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void add() {
        Order order = new Order();
        for (int i =0; i <=20; i++) {
            for (int j = 0; j <= 30; j++) {
                order.setUserId(i);
                order.setOrderId(j);
                orderMapper.insert(order);
            }
        }
    }
    @Test
    public void addCopy() {
        Order order = new Order();
        for (int i =0; i <=20; i++) {
            for (int j = 0; j <= 30; j++) {
                order.setUserId(i);
                order.setOrderId(j);
                orderCopyMapper.insert(order);
            }
        }
    }

    @Test
    public void getByUserId(){
        List<Order> byUserId = orderMapper.findByUserId(20);
        for (Order order : byUserId) {
            System.out.println(order);
        }

    }
    @Test
    public void getCopyByUserId(){
        List<Order> byUserId = orderCopyMapper.findByUserId(20);
        for (Order order : byUserId) {
            System.out.println(order);
        }

    }

}

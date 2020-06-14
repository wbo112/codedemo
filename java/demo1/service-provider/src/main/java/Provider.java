import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class Provider {
    public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
//        context.start();
//        System.in.read(); // 按任意键退出

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("provider.xml");

//		OrderService orderService = applicationContext.getBean(OrderService.class);
//
//		orderService.initOrder("1");
        System.out.println("调用完成....");
        System.in.read();
    }
}
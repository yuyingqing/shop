
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);
    /*
    创建一个购物车的数组：存的是商品
     */
    static Product carts[] = new Product[3];//创建购物车（用数组模拟）

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        boolean bo = true;
        while (bo) {
            System.out.println("请输入用户名：");
            String username = sc.next();//阻塞方法
            System.out.println("请输入密码：");
            String password = sc.next();

            //File file = new File("C:\\Users\\Administrator\\IdeaProjects\\ConsoleShop\\src\\users.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            InputStream inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();//创建对象
            User users[] = readExcel.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登录成功");
                    bo = false;
                    /*
                    显示商品
                     */
                    while (true) {
                        System.out.println("购买商品请按 1：");
                        System.out.println("查看购物车请按 2：");
                        System.out.println("结账请按 3：");
                        System.out.println("退出请按 4：");
                        int choose = sc.nextInt();
                        if (choose == 1) {
                            shopping(inProduct);
                        } else if (choose == 2) {
                            viewCarts();
                        }
                        else if(choose==3){
                            Order order=new Order();
                            order.setUser(users[i]);
                            order.setProducts(carts);
                            /*
                            统计每个商品的数量,并写入Excel
                             */
                            int count1[][];
                            for(int k=0;k<carts.length;k++)
                            {
                                for(int q=k+1;q<carts.length;q++){

                                }
                            }
                        }
                        else if (choose == 4) {
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }

    public static void viewCarts() {
        System.out.println("当前购物车商品如下：");
        for (Product p : carts) {
            if (p != null) {
                System.out.print(p.getpId());
                System.out.print("\t" + p.getpName());
                System.out.print("\t" + p.getPrice());
                System.out.println("\t" + p.getpDesc());
            }
        }
    }

    public static void shopping(InputStream in) throws ClassNotFoundException {
        ReadProductExcel readProductExcel = new ReadProductExcel();
        Product products[] = readProductExcel.readExcel(in);
        for (Product product : products) {
            System.out.print(product.getpId());
            System.out.print("\t" + product.getpName());
            System.out.print("\t" + product.getPrice());
            System.out.println("\t" + product.getpDesc());
        }
        System.out.println("请输入商品ID把该商品加入购物车");
        String pId = sc.next();
        int count = 0;
        /*
        根据此ID去Excel中去查找是否有该ID的商品信息，如果有则返回该商品即可
         */
        in = null;
        in = Class.forName("Test").getResourceAsStream("/product.xlsx");
        Product product = readProductExcel.getProductById(pId, in);
        System.out.println("要购买的商品价格：" + product.getPrice());
        if (product != null) {
            // System.out.println("找到了该商品");
            carts[count++] = product;
        }
    }
}
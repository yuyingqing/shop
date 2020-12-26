import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("请输入用户名：");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();//阻塞方法
        System.out.println("你输入的用户名为："+username);

        System.out.println("请输入密码：");
        String password=sc.next();
        System.out.println("你输入的密码为："+password);

        File file=new File("C:\\Users\\lenovo\\IdeaProjects\\shop\\src\\users.xlsx");
        ReadExcel readExcel=new ReadExcel();//创建对象
        User user[]=readExcel.readExcel(file);
        for(int i=0;i<user.length;i++)
        {
            if(username.equals(user[i].getUsername()) && password.equals(user[i].getPassword())){
                System.out.println("登录成功");
                break;
            }
            else{
                System.out.println("登录失败");
            }
        }
    }
}

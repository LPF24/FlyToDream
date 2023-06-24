package 用户管理系统.atguigu.view;

import 用户管理系统.atguigu.bean.User;
import 用户管理系统.atguigu.data.CustomerList;
import com.atguigu.util.*;
import 用户管理系统.atguigu.util.CMUtility;

import java.util.Arrays;


/**
 * @ClassName: User
 * @createDate: 2023/6/22 18:52
 * @author: liu
 * @description:用户
 */
public class CustomerView {


    private static CustomerList list;

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        list = new CustomerList();
        view.showView();
    }

    //    boolean flag=true;
    public void showView() {

        while (true) {
            // 搭建页面结构
            System.out.println("""
                    ----------------------客户信息管理软件----------------------
                                     1 添加客户
                                     2.修改客户
                                     3.删除客户
                                     4.客户列表
                                     5.退   出
                                     
                                     请选择(1-5):""");

            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1' -> addCustomer();
                case '2' -> updateCustomr();
                case '3' -> deleteCustomer();
                case '4' -> showCustomers();
                case '5' -> {
                    if (exit()) return;
                }
            }
        }
    }


    private void addCustomer() {
        //  1.接收用户输入的内容
        System.out.println("----------------------添加用户----------------------");
        System.out.println("姓名:");
        String name = CMUtility.readString(4);
        System.out.println("性别:");
        String gender = CMUtility.readString(2);
        System.out.println("年龄:");
        int age = CMUtility.readInt();

        System.out.println("phone:");
        String phone = CMUtility.readString(11);
        System.out.println("email:");
        String email = CMUtility.readString(100);
        System.out.println("----------------------添加成功----------------------");

        // String info="姓名:"+name+",性别:"+gender+",年龄:"+age+",电话:"+phone+",邮箱:"+email;
        // 2.将用户输入的数据封装成为一个对象
        User u = new User(name, gender, age, phone, email);

        // 3.将添加的用户存起来(将数据放入到users数组中)
/*      无法通过 getuser和getcount来添加用户，count 初始化时为0，index-1=-1 ，给getuser传参时 1<index<101
        int index=list.getCount();
        User newuser=list.getUser(index-1);
        newuser=u;*/
        list.addUser(u);

 /*     当getUsers方法直接返回users时，可以通过getCount方法添加用户
        User[] x=list.getUsers();
        x[list.getCount()]=u;*/

    }

    private void updateCustomr() {
        System.out.println("------------------------修改用户------------------------");
        System.out.println("请输入待修改用户的编号(-1退出)：");
        int index = CMUtility.readInt();
        if (index > 0) { //  如果用户输入的不是-1，表示要修改数据
            index -= 1;
            User oldUser = list.getUsers()[index];
            ;

            System.out.print("姓名（" + oldUser.getName() + ")");
            String newName = CMUtility.readString(4, oldUser.getName());
            oldUser.setName(newName);

            System.out.print("性别（" + oldUser.getGender() + ")");
            String newGender = CMUtility.readString(2, oldUser.getGender());
            oldUser.setName(newGender);

            System.out.print("年龄（" + oldUser.getAge() + ")");
            int newAge = CMUtility.readInt(oldUser.getAge());
            oldUser.setAge(newAge);


            System.out.print("Phone（" + oldUser.getPhone() + ")");
            String newPhone = CMUtility.readString(11, oldUser.getPhone());
            oldUser.setName(newPhone);

            System.out.print("邮箱（" + oldUser.getEmail() + ")");
            String newEmail = CMUtility.readString(100, oldUser.getEmail());
            oldUser.setName(newEmail);

            //  此时的 olduser应经重新初始化
            // 将初始化后的olduser传给list
            list.updateUserByIndex(index, oldUser);
//                if (list.getUser(index - 1) == null) {
//                    System.out.println("找不到用户信息");
//                    continue;
//                } else {
//                    System.out.println("已找到待修改的用户信息，请输入要修改的用户信息");
//                    System.out.println("姓名:");
//                    String name = CMUtility.readString(4);
//                    System.out.println("性别:");
//                    String gender = CMUtility.readString(2);
//                    System.out.println("年龄:");
//                    int age = CMUtility.readInt();
//                    System.out.println("phone:");
//                    String phone = CMUtility.readString(11);
//                    System.out.println("email:");
//                    String email = CMUtility.readString(100);
//
//                    list.getUser(index - 1).setName(name);
//                    list.getUser(index - 1).setGender(gender);
//                    list.getUser(index - 1).setAge(age);
//                    list.getUser(index - 1).setPhone(phone);
//                    list.getUser(index - 1).setEmail(email);
//                }
        } else return;


        System.out.println("------------------------修改完成------------------------");

    }


    private void deleteCustomer() {
        System.out.println("------------------------删除用户------------------------");
        System.out.print("请输入要删除的用户编号(-1退出): ");
        int index = CMUtility.readInt();
        if (index > 0) {
            if(index<list.getCount()){
                list.deleteUserByIndex(index - 1);
            }else {
                System.out.println("找不到用户信息");
                return;
            }

        }
        System.out.println("------------------------删除成功------------------------");
        System.out.println(Arrays.toString(list.getUsers()));
        return;
    }


    private void showCustomers() {
        System.out.println("----------------------客户列表----------------------");
        System.out.print("编号  姓名      性别     年龄   电话           邮箱\n");
        for (int i = 0; i < list.getCount(); i++) {
            User user = list.getUsers()[i];
            System.out.println((i + 1) + "\t" + user.getName() + "\t\t" + user.getAge() + "\t\t" + user.getGender() + "\t\t" + user.getPhone() + "\t\t\t" + user.getEmail());
        }
        System.out.println("----------------------客户列表完成----------------------");
        System.out.println(Arrays.toString(list.getUsers()));
    }

    /*    private void exit(){
            System.out.println("是否确定退出?Y/N:");
            Scanner scanner = new Scanner(System.in);
            char c=CMUtility.readConfirmSelection();
            if(c== 'Y') flag=false;
            System.out.println("退出");
        }*/
    private boolean exit() {
        System.out.println("是否确定退出?Y/N:");
        char confirm = CMUtility.readConfirmSelection();
        return confirm == 'Y';
//        System.out.println("退出");
    }


}

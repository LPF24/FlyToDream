package 用户管理系统.atguigu.data;

import 用户管理系统.atguigu.bean.User;

import java.util.Arrays;

/**
 * @ClassName: CustomerList
 * @createDate: 2023/6/23 18:01
 * @author: liu
 * @description:用来实现对用户的增删改查
 */
public class CustomerList {

    //  定义一个数组，来存储用户对象
    private User[] users = new User[100];
    private int count = 0;

    //  users初始化
    public CustomerList(){
        users[0]=new User("张三","男",19,"12345678","125w5wv6@125w.com");
        users[1]=new User("李四","女",34,"1244555","125wvv4v6@12355w.com");
        users[2]=new User("王五","男",54,"12355558","1256bnznz@1235.com");
        users[3]=new User("赵六","女",15,"12345555","1255@1253.com");
        count=4;
    }

    //  添加用户
    public void addUser(User user) {
        users[count++] = user;
    }


    public int getCount() {
        return count;
    }

    public User[] getUsers() {
        //  将users彻底私有化
        return Arrays.copyOf(users,count);
    }

//    public User getUser(int index){
//        return users[index];
//    }

    public void updateUserByIndex(int index, User user){
        users[index]=user;
        return;
    }

    public boolean deleteUserByIndex(int index){
        if(index<0 || index>count) return false;
        for (int i = index; i <count ; i++) {
            users[i]=users[i+1];
        }
        users[--count]=null;
        return true;
    }


}

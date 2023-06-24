package 用户管理系统.atguigu.bean;

/**
 * @ClassName: User
 * @createDate: 2023/6/23 17:08
 * @author: liu
 * @description:user的JavaBean
 */
public class User {
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String email;

    public User(){}

    //  构造方法
    public User(String name,String gender,int age,String phone,String email){
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.phone=phone;
        this.email=email;

    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

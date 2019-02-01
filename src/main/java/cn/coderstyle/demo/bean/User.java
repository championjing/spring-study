package cn.coderstyle.demo.bean;

/**
 * @ClassName: User
 * @Description: TODO
 * @Date: 2019/1/24 0024 14:49
 * @Auth: championjing
 */
public class User {
    private Long id;
    private String name;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

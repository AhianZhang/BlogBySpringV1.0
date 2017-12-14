package top.ahianzhang.model;

/**
 * 博主信息
 * Created by AhianZhang on 2017/10/30.
 */
public class Blogger
{
    private Integer id;
    private String username; //用户名
    private String password;
    private String nickname; //昵称
    private String sign;  //签名
    private String aboutme; //简介
    private String imagename; //头像

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getSign()
    {
        return sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }

    public String getAboutme()
    {
        return aboutme;
    }

    public void setAboutme(String aboutme)
    {
        this.aboutme = aboutme;
    }

    public String getImagename()
    {
        return imagename;
    }

    public void setImagename(String imagename)
    {
        this.imagename = imagename;
    }
}

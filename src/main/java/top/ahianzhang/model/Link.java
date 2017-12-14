package top.ahianzhang.model;

/**
 * Created by AhianZhang on 2017/11/2.
 */
public class Link
{
    private Integer id;
    private String linkname;
    private String linkurl;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getLinkname()
    {
        return linkname;
    }

    public void setLinkname(String linkname)
    {
        this.linkname = linkname;
    }

    public String getLinkurl()
    {
        return linkurl;
    }

    public void setLinkurl(String linkurl)
    {
        this.linkurl = linkurl;
    }
}

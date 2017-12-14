package top.ahianzhang.model;

/**
 * Created by AhianZhang on 2017/11/2.
 */
public class Catalog
{
    private Integer id;
    private String cataname;
    private Integer orderNo;
private Integer blogCount;//非数据库数据
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCataname()
    {
        return cataname;
    }

    public void setCataname(String cataname)
    {
        this.cataname = cataname;
    }

    public Integer getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    public Integer getBlogCount()
    {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount)
    {
        this.blogCount = blogCount;
    }

    @Override
    public String toString()
    {
        return "Catalog{" +
                "id=" + id +
                ", cataname='" + cataname + '\'' +
                ", orderNo=" + orderNo +
                ", blogCount=" + blogCount +
                '}';
    }
}

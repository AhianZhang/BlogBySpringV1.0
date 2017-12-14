package top.ahianzhang.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by AhianZhang on 2017/11/2.
 */
public class Blog
{
private Integer id;
private String title;
private String summary;
private Date releaseDate;
private Integer clickHit;
private Integer replyHit;
private String content;
private String tag;
private Catalog catalog;
private Integer blogCount;//非数据库数据
private  String releaseDateStr;
    /**
     * 获取博客里的图片
     */
    private List<String> imgList = new ArrayList<String>();


    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit()
    {
        return clickHit;
    }

    public void setClickHit(Integer clickHit)
    {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit()
    {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit)
    {
        this.replyHit = replyHit;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public Catalog getCatalog()
    {
        return catalog;
    }

    public void setCatalog(Catalog catalog)
    {
        this.catalog = catalog;
    }

    public Integer getBlogCount()
    {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount)
    {
        this.blogCount = blogCount;
    }

    public String getReleaseDateStr()
    {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr)
    {
        this.releaseDateStr = releaseDateStr;
    }

    public List<String> getImgList()
    {
        return imgList;
    }

    public void setImgList(List<String> imgList)
    {
        this.imgList = imgList;
    }

    @Override
    public String toString()
    {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", releaseDate=" + releaseDate +
                ", clickHit=" + clickHit +
                ", replyHit=" + replyHit +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                ", catalog=" + catalog +
                ", blogCount=" + blogCount +
                ", releaseDateStr='" + releaseDateStr + '\'' +
                '}';
    }
}

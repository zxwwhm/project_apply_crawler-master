package com.zxw.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */

@Entity
@Table(name = "project")//填表名
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //其他属性
  private String title;
  private  String date;
  private String url;
  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  private Date createTime;

  @Temporal(TemporalType.TIMESTAMP)
  @UpdateTimestamp
  private Date updateTime;

  public Project(){

  }

  //get和set方法


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public Project(String title,String date,String url) {
    this.title = title;
    this.date=date;
    this.url=url;
  }

  @Override
  public String toString() {
    return "Project{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", date='" + date + '\'' +
            ", url='" + url + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}

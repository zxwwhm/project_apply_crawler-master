package com.zxw.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * author:zxw
 *
 */


@Entity
@Table(name="Information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String date;
    private String detail;
    private String url;
    private String appendixUrl;
    private String appendixName;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateTime;

    public Information(){

    }

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppendixUrl() {
        return appendixUrl;
    }

    public void setAppendixUrl(String appendixUrl) {
        this.appendixUrl = appendixUrl;
    }

    public String getAppendixName() {
        return appendixName;
    }

    public void setAppendixName(String appendixName) {
        this.appendixName = appendixName;
    }

    public Information(String title, String date, String detail, String url, String appendixUrl, String appendixName, Date createTime, Date updateTime) {
        this.title = title;
        this.date = date;
        this.detail = detail;
        this.url = url;
        this.appendixUrl = appendixUrl;
        this.appendixName = appendixName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    public Information(String title,String url){
        this.title=title;
        this.url=url;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", detail='" + detail + '\'' +
                ", url='" + url + '\'' +
                ", appendixUrl='" + appendixUrl + '\'' +
                ", appendixName='" + appendixName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

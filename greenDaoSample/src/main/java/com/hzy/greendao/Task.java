package com.hzy.greendao;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Task {
    @Id(autoincrement = true)
    Long id;
    String taskName;//任务名称
    String taskContent; //任务描述
    String time;
    @Generated(hash = 619408533)
    public Task(Long id, String taskName, String taskContent, String time) {
        this.id = id;
        this.taskName = taskName;
        this.taskContent = taskContent;
        this.time = time;
    }
    @Generated(hash = 733837707)
    public Task() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTaskName() {
        return this.taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskContent() {
        return this.taskContent;
    }
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}

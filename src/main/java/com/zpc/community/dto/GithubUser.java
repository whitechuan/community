package com.zpc.community.dto;

/**
 * ClassName: GithubUser
 * Package: com.zpc.community.dto
 * Description:
 *
 * @Date: 2020/5/12 22:06
 * @Author:zpc@qq.com
 */
public class GithubUser {
    private String name;
    private long id;
    private String blo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlo() {
        return blo;
    }

    public void setBlo(String blo) {
        this.blo = blo;
    }
}

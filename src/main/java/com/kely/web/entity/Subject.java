package com.kely.web.entity;/**
 * Created by YMO on 2018/9/13.
 */

/**
 * @Descrition TODO
 * @Author YMO
 * @Date 2018/9/13 14:40
 **/
public class Subject {

    private int id;
    private String no;
    private int cid;
    private int score;

    public Subject(int id,String no, int cid, int score) {
        this.id = id;
        this.no = no;
        this.cid = cid;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", cid=" + cid +
                ", score=" + score +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

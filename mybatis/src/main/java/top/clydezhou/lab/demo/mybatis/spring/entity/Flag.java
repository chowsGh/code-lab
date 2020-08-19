package top.clydezhou.lab.demo.mybatis.spring.entity;

/**
 * @author clyde
 * @date 2020-08-09 23:11
 */
public enum Flag {
    NORMAL("正常", 1), DELETED("删除", 0);
    private String note;
    private int code;
    private Flag(String note, int code) {
        this.note = note;
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Flag{" + "note='" + note + '\'' + ", code=" + code + "} ";
    }
}

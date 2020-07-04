package top.clydezhou.lab.demo.springdata.mongodb.entity;

/**
 * @author clyde
 * @date 2020-06-22 23:19
 */
public class Acl {

    private String groupId;
    private String groupName;
    private String roleId;
    private String roleName;
    private String groupType;
    private String userId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Acl{" + "groupId='" + groupId + '\'' + ", groupName='" + groupName + '\'' + ", roleId='" + roleId + '\''
            + ", roleName='" + roleName + '\'' + ", groupType='" + groupType + '\'' + ", userId='" + userId + '\''
            + '}';
    }
}
package com.myfarm.flashsale.core.modules.user.model;

public class UserRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.user_role.role_id
     *
     * @mbg.generated Sat Jan 23 16:36:08 CST 2021
     */
    private Object roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.user_role.role_name
     *
     * @mbg.generated Sat Jan 23 16:36:08 CST 2021
     */
    private String roleName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.user_role.role_id
     *
     * @return the value of public.user_role.role_id
     *
     * @mbg.generated Sat Jan 23 16:36:08 CST 2021
     */
    public Object getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.user_role.role_id
     *
     * @param roleId the value for public.user_role.role_id
     *
     * @mbg.generated Sat Jan 23 16:36:08 CST 2021
     */
    public void setRoleId(Object roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.user_role.role_name
     *
     * @return the value of public.user_role.role_name
     *
     * @mbg.generated Sat Jan 23 16:36:08 CST 2021
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.user_role.role_name
     *
     * @param roleName the value for public.user_role.role_name
     *
     * @mbg.generated Sat Jan 23 16:36:08 CST 2021
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}
package com.myfarm.flashsale.core.modules.order.model;

import java.util.Date;

public class ProdOrder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.order_id
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private Object orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.receiver
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private String receiver;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.telphone
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private String telphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.user_id
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private Object userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.number_of_prod
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private Integer numberOfProd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.total_pay
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private Double totalPay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.actual_pay
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private Double actualPay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.payment_id
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private Object paymentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.status
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.create_date
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.prod_order.update_date
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.order_id
     *
     * @return the value of public.prod_order.order_id
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public Object getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.order_id
     *
     * @param orderId the value for public.prod_order.order_id
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.receiver
     *
     * @return the value of public.prod_order.receiver
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.receiver
     *
     * @param receiver the value for public.prod_order.receiver
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.telphone
     *
     * @return the value of public.prod_order.telphone
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.telphone
     *
     * @param telphone the value for public.prod_order.telphone
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.user_id
     *
     * @return the value of public.prod_order.user_id
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public Object getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.user_id
     *
     * @param userId the value for public.prod_order.user_id
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setUserId(Object userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.number_of_prod
     *
     * @return the value of public.prod_order.number_of_prod
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public Integer getNumberOfProd() {
        return numberOfProd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.number_of_prod
     *
     * @param numberOfProd the value for public.prod_order.number_of_prod
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setNumberOfProd(Integer numberOfProd) {
        this.numberOfProd = numberOfProd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.total_pay
     *
     * @return the value of public.prod_order.total_pay
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public Double getTotalPay() {
        return totalPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.total_pay
     *
     * @param totalPay the value for public.prod_order.total_pay
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.actual_pay
     *
     * @return the value of public.prod_order.actual_pay
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public Double getActualPay() {
        return actualPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.actual_pay
     *
     * @param actualPay the value for public.prod_order.actual_pay
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.payment_id
     *
     * @return the value of public.prod_order.payment_id
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public Object getPaymentId() {
        return paymentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.payment_id
     *
     * @param paymentId the value for public.prod_order.payment_id
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setPaymentId(Object paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.status
     *
     * @return the value of public.prod_order.status
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.status
     *
     * @param status the value for public.prod_order.status
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.create_date
     *
     * @return the value of public.prod_order.create_date
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.create_date
     *
     * @param createDate the value for public.prod_order.create_date
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.prod_order.update_date
     *
     * @return the value of public.prod_order.update_date
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.prod_order.update_date
     *
     * @param updateDate the value for public.prod_order.update_date
     *
     * @mbg.generated Fri Jan 22 17:49:56 CST 2021
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
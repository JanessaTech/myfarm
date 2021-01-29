package com.myfarm.flashsale.core.modules.common;

public class Constants {
    public static final String API_RESPONSE_SUCCESS_MESSAGE_DEFAULT_KEY = "OK";
    public static final String API_RESPONSE_FAIL_MESSAGE_DEFAULT_KEY = "ERROR";
    public static final String API_RESPONSE_SUCCESS_MESSAGE_DEFAULT_VALUE = "success";
    public static final String host = "localhost";
    public enum Order{
        ASC("ASC", ""),
        DESC("DESC","");
        private String code;
        private String description;

        Order(String code, String des){
            this.code = code;
            this.description = des;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "code='" + code + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    public enum SiteStatus{
        In_business("In_business", ""),
        Out_business("Out_business", "");
        private String status;
        private String des;
        SiteStatus(String status, String des){
            this.status = status;
            this.des = des;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        @Override
        public String toString() {
            return "SiteStatus{" +
                    "status='" + status + '\'' +
                    ", des='" + des + '\'' +
                    '}';
        }
    }

    public enum ProviderStatus{
        In_business("In_business", ""),
        Out_business("Out_business", "");
        private String status;
        private String des;
        ProviderStatus(String status, String des){
            this.status = status;
            this.des = des;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        @Override
        public String toString() {
            return "SiteStatus{" +
                    "status='" + status + '\'' +
                    ", des='" + des + '\'' +
                    '}';
        }
    }


    //swagger related info
    public static final String API_TITLE = "农菜鲜后端api手册";
    public static final String project_description = "农菜鲜项目描述";
}

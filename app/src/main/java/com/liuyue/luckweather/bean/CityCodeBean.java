package com.liuyue.luckweather.bean;

import java.util.List;

public class CityCodeBean {

    /**
     * ERRORCODE : 0
     * RESULT : [{"city_name":"张家口-河北","city_id":"101090301"}]
     */

    private String ERRORCODE;

    public CityCodeBean setRESULT(List<RESULTBean> RESULT) {
        this.RESULT = RESULT;
        return this;
    }

    private List<RESULTBean> RESULT;

    public String getERRORCODE() {
        return ERRORCODE;
    }

    public void setERRORCODE(String ERRORCODE) {
        this.ERRORCODE = ERRORCODE;
    }

    public List<RESULTBean> getRESULT() {
        return RESULT;
    }



    public static class RESULTBean {
        /**
         * city_name : 张家口-河北
         * city_id : 101090301
         */

        private String city_name;

        public String getCity_name() {
            return city_name;
        }

        public RESULTBean setCity_name(String city_name) {
            this.city_name = city_name;
            return this;
        }

        public String getCity_id() {
            return city_id;
        }

        public RESULTBean setCity_id(String city_id) {
            this.city_id = city_id;
            return this;
        }

        private String city_id;


    }
}

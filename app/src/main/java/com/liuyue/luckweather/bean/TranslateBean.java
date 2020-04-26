package com.liuyue.luckweather.bean;

import java.util.List;

public class TranslateBean {
    /**
     * from : zh
     * to : en
     * domain : all
     * type : 2
     * status : 0
     * data : [{"dst":"The lucky elf reports to you that today's weather is cloudy, the highest temperature is 10 degrees, the lowest temperature is 11 degrees, the wind is not big or small, the report is over, wish you have a good mood","prefixWrap":0,"src":"幸运精灵向您报道，今天的天气是多云,最高温度10度,最低温度11度,风大小心别上天,报告完毕，祝您有一个好心情","relation":[],"result":[[0,"The lucky elf reports to you that today's weather is cloudy, the highest temperature is 10 degrees, the lowest temperature is 11 degrees, the wind is not big or small, the report is over, wish you have a good mood",["0|149"],[],["0|149"],["0|213"]]]}]
     */

    private String from;
    private String to;
    private String domain;
    private int type;
    private int status;
    private List<DataBean> data;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * dst : The lucky elf reports to you that today's weather is cloudy, the highest temperature is 10 degrees, the lowest temperature is 11 degrees, the wind is not big or small, the report is over, wish you have a good mood
         * prefixWrap : 0
         * src : 幸运精灵向您报道，今天的天气是多云,最高温度10度,最低温度11度,风大小心别上天,报告完毕，祝您有一个好心情
         * relation : []
         * result : [[0,"The lucky elf reports to you that today's weather is cloudy, the highest temperature is 10 degrees, the lowest temperature is 11 degrees, the wind is not big or small, the report is over, wish you have a good mood",["0|149"],[],["0|149"],["0|213"]]]
         */

        private String dst;
        private int prefixWrap;
        private String src;
        private List<?> relation;
        private List<List<Integer>> result;

        public String getDst() {
            return dst;
        }

        public void setDst(String dst) {
            this.dst = dst;
        }

        public int getPrefixWrap() {
            return prefixWrap;
        }

        public void setPrefixWrap(int prefixWrap) {
            this.prefixWrap = prefixWrap;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public List<?> getRelation() {
            return relation;
        }

        public void setRelation(List<?> relation) {
            this.relation = relation;
        }

        public List<List<Integer>> getResult() {
            return result;
        }

        public void setResult(List<List<Integer>> result) {
            this.result = result;
        }
    }
}

package com.example.liuyue.luckweather.bean;

import com.example.liuyue.luckweather.utils.TextUtil;

import java.util.List;

public class WeatherFlyme {
    /**
     * alarms : [{"alarmContent":"张家口市气象台2018年09月20日16时57分发布霜冻蓝色预警信号：受较强冷空气影响，21～24日早晨气温较低，坝下大部最低气温将达到2～5℃，出现初霜冻；坝上大部最低气温将达到-4～-1℃，出现冰冻。请做好预防工作。\n防御指南：\n1、政府及农林主管部门按照职责做好防霜冻准备工作；\n2、对农作物、蔬菜、花卉、瓜果、林业育种要采取一定的防护措施；\n3、农村基层组织和农户要关注当地霜冻预警信息，以便采取措施加强防护。（预警信息来源：国家预警信息发布中心）","alarmDesc":"河北省张家口市气象台发布霜冻蓝色预警","alarmId":"2af5aea251a094f7947e27869f732c20","alarmLevelNo":"01","alarmLevelNoDesc":"蓝色","alarmType":"11","alarmTypeDesc":"霜冻蓝色","precaution":"1.出门前准备好手套.帽子等御寒衣物；\n\n2.户外活动警惕冻伤风险。","publishTime":"2018-09-20 17:08:34"}]
     * city : 张家口
     * cityid : 101090301
     * dataVersion : null
     * flymeVersion : null
     * indexes : [{"abbreviation":"uv","alias":"","content":"辐射较弱，涂擦SPF12-15、PA+护肤品。","level":"弱","name":"紫外线强度指数"},{"abbreviation":"pp","alias":"","content":"建议用露质面霜打底，水质无油粉底霜，透明粉饼，粉质胭脂。","level":"控油","name":"化妆指数"},{"abbreviation":"yd","alias":"","content":"天气较好，且紫外线辐射不强，适宜户外运动。","level":"适宜","name":"运动指数"},{"abbreviation":"xc","alias":"","content":"洗车后，可至少保持4天车辆清洁，非常适宜洗车。","level":"非常适宜","name":"洗车指数"},{"abbreviation":"gm","alias":"","content":"感冒极易发生，避免去人群密集的场所，勤洗手勤通风有利于降低感冒几率。","level":"极易发","name":"感冒指数"},{"abbreviation":"ct","alias":"","content":"天气偏凉，增加衣物厚度。","level":"温凉","name":"穿衣指数"}]
     * pm25 : {"advice":"0","aqi":"19","citycount":577,"cityrank":94,"co":"2","color":"0","level":"0","no2":"3","o3":"19","pm10":"15","pm25":"7","quality":"优","so2":"2","timestamp":"","upDateTime":"2018-09-15 10:00:00"}
     * provinceName : 河北省
     * realtime : {"img":"2","sD":"55","sendibleTemp":"12","temp":"13","time":"2018-09-15 10:40:08","wD":"西北风","wS":"4","weather":"阴","ziwaixian":"N/A"}
     * weatherDetailsInfo : {"publishTime":"2018-09-15 10:00:00","weather24HoursDetailsInfos":[{"endTime":"2018-09-15 12:00:00","highestTemperature":"15","img":"0","isRainFall":"","lowerestTemperature":"15","precipitation":"0","startTime":"2018-09-15 11:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 13:00:00","highestTemperature":"17","img":"0","isRainFall":"","lowerestTemperature":"17","precipitation":"0","startTime":"2018-09-15 12:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 14:00:00","highestTemperature":"19","img":"0","isRainFall":"","lowerestTemperature":"19","precipitation":"0","startTime":"2018-09-15 13:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 15:00:00","highestTemperature":"20","img":"0","isRainFall":"","lowerestTemperature":"20","precipitation":"0","startTime":"2018-09-15 14:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 16:00:00","highestTemperature":"21","img":"0","isRainFall":"","lowerestTemperature":"21","precipitation":"0","startTime":"2018-09-15 15:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 17:00:00","highestTemperature":"20","img":"0","isRainFall":"","lowerestTemperature":"20","precipitation":"0","startTime":"2018-09-15 16:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 18:00:00","highestTemperature":"18","img":"0","isRainFall":"","lowerestTemperature":"18","precipitation":"0","startTime":"2018-09-15 17:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 19:00:00","highestTemperature":"16","img":"0","isRainFall":"","lowerestTemperature":"16","precipitation":"0","startTime":"2018-09-15 18:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 20:00:00","highestTemperature":"13","img":"0","isRainFall":"","lowerestTemperature":"13","precipitation":"0","startTime":"2018-09-15 19:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 21:00:00","highestTemperature":"11","img":"0","isRainFall":"","lowerestTemperature":"11","precipitation":"0","startTime":"2018-09-15 20:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 22:00:00","highestTemperature":"9","img":"0","isRainFall":"","lowerestTemperature":"9","precipitation":"0","startTime":"2018-09-15 21:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 23:00:00","highestTemperature":"8","img":"0","isRainFall":"","lowerestTemperature":"8","precipitation":"0","startTime":"2018-09-15 22:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 00:00:00","highestTemperature":"8","img":"0","isRainFall":"","lowerestTemperature":"8","precipitation":"0","startTime":"2018-09-15 23:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 01:00:00","highestTemperature":"8","img":"0","isRainFall":"","lowerestTemperature":"8","precipitation":"0","startTime":"2018-09-16 00:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 02:00:00","highestTemperature":"9","img":"0","isRainFall":"","lowerestTemperature":"9","precipitation":"0","startTime":"2018-09-16 01:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 03:00:00","highestTemperature":"10","img":"0","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 02:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 04:00:00","highestTemperature":"10","img":"1","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 03:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 05:00:00","highestTemperature":"10","img":"1","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 04:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 06:00:00","highestTemperature":"10","img":"2","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 05:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2018-09-16 07:00:00","highestTemperature":"10","img":"2","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 06:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2018-09-16 08:00:00","highestTemperature":"10","img":"1","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 07:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 09:00:00","highestTemperature":"11","img":"1","isRainFall":"","lowerestTemperature":"11","precipitation":"0","startTime":"2018-09-16 08:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 10:00:00","highestTemperature":"12","img":"1","isRainFall":"","lowerestTemperature":"12","precipitation":"0","startTime":"2018-09-16 09:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 11:00:00","highestTemperature":"14","img":"0","isRainFall":"","lowerestTemperature":"14","precipitation":"0","startTime":"2018-09-16 10:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 12:00:00","highestTemperature":"14","img":"0","isRainFall":"","lowerestTemperature":"14","precipitation":"0","startTime":"2018-09-16 11:00:00","wd":"","weather":"晴","ws":""}]}
     * weathers : [{"date":"2018-09-15","img":"1","sun_down_time":"18:31","sun_rise_time":"06:00","temp_day_c":"21","temp_day_f":"69.8","temp_night_c":"8","temp_night_f":"46.4","wd":"","weather":"多云","week":"星期六","ws":""},{"date":"2018-09-16","img":"1","sun_down_time":"18:31","sun_rise_time":"06:00","temp_day_c":"22","temp_day_f":"71.6","temp_night_c":"10","temp_night_f":"50.0","wd":"","weather":"多云","week":"星期日","ws":""},{"date":"2018-09-17","img":"1","sun_down_time":"18:31","sun_rise_time":"06:00","temp_day_c":"23","temp_day_f":"73.4","temp_night_c":"13","temp_night_f":"55.4","wd":"","weather":"多云","week":"星期一","ws":""},{"date":"2018-09-18","img":"1","sun_down_time":"18:31","sun_rise_time":"06:00","temp_day_c":"22","temp_day_f":"71.6","temp_night_c":"13","temp_night_f":"55.4","wd":"","weather":"多云","week":"星期二","ws":""},{"date":"2018-09-19","img":"1","sun_down_time":"18:31","sun_rise_time":"06:00","temp_day_c":"22","temp_day_f":"71.6","temp_night_c":"12","temp_night_f":"53.6","wd":"","weather":"多云","week":"星期三","ws":""},{"date":"2018-09-20","img":"1","sun_down_time":"18:31","sun_rise_time":"06:00","temp_day_c":"22","temp_day_f":"71.6","temp_night_c":"10","temp_night_f":"50.0","wd":"","weather":"多云","week":"星期四","ws":""},{"date":"2018-09-14","img":"4","sun_down_time":"18:31","sun_rise_time":"06:00","temp_day_c":"24","temp_day_f":"75.2","temp_night_c":"12","temp_night_f":"53.6","wd":"","weather":"雷阵雨","week":"星期五","ws":""}]
     */

    private String city;
    private int cityid;
    private Object dataVersion;
    private Object flymeVersion;
    private Pm25Bean pm25;
    private String provinceName;
    private RealtimeBean realtime;
    private WeatherDetailsInfoBean weatherDetailsInfo;
    private List<AlarmsBean> alarms;
    private List<IndexesBean> indexes;
    private List<WeathersBean> weathers;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public Object getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Object dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Object getFlymeVersion() {
        return flymeVersion;
    }

    public void setFlymeVersion(Object flymeVersion) {
        this.flymeVersion = flymeVersion;
    }

    public Pm25Bean getPm25() {
        return pm25;
    }

    public void setPm25(Pm25Bean pm25) {
        this.pm25 = pm25;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public RealtimeBean getRealtime() {
        return realtime;
    }

    public void setRealtime(RealtimeBean realtime) {
        this.realtime = realtime;
    }

    public WeatherDetailsInfoBean getWeatherDetailsInfo() {
        return weatherDetailsInfo;
    }

    public void setWeatherDetailsInfo(WeatherDetailsInfoBean weatherDetailsInfo) {
        this.weatherDetailsInfo = weatherDetailsInfo;
    }

    public List<AlarmsBean> getAlarms() {
        return alarms;
    }

    public void setAlarms(List<AlarmsBean> alarms) {
        this.alarms = alarms;
    }

    public List<IndexesBean> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<IndexesBean> indexes) {
        this.indexes = indexes;
    }

    public List<WeathersBean> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeathersBean> weathers) {
        this.weathers = weathers;
    }

    public static class Pm25Bean {
        /**
         * advice : 0
         * aqi : 19
         * citycount : 577
         * cityrank : 94
         * co : 2
         * color : 0
         * level : 0
         * no2 : 3
         * o3 : 19
         * pm10 : 15
         * pm25 : 7
         * quality : 优
         * so2 : 2
         * timestamp :
         * upDateTime : 2018-09-15 10:00:00
         */

        private String advice;
        private String aqi;
        private int citycount;
        private int cityrank;
        private String co;
        private String color;
        private String level;
        private String no2;
        private String o3;
        private String pm10;
        private String pm25;
        private String quality;
        private String so2;
        private String timestamp;
        private String upDateTime;

        public String getAdvice() {
            return advice;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public int getCitycount() {
            return citycount;
        }

        public void setCitycount(int citycount) {
            this.citycount = citycount;
        }

        public int getCityrank() {
            return cityrank;
        }

        public void setCityrank(int cityrank) {
            this.cityrank = cityrank;
        }

        public String getCo() {
            return co;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getNo2() {
            return no2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public String getO3() {
            return o3;
        }

        public void setO3(String o3) {
            this.o3 = o3;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getSo2() {
            return so2;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getUpDateTime() {
            return upDateTime;
        }

        public void setUpDateTime(String upDateTime) {
            this.upDateTime = upDateTime;
        }
    }

    public static class AlarmsBean {
        /**
         * alarmContent : 张家口市气象台2018年09月20日16时57分发布霜冻蓝色预警信号：受较强冷空气影响，21～24日早晨气温较低，坝下大部最低气温将达到2～5℃，出现初霜冻；坝上大部最低气温将达到-4～-1℃，出现冰冻。请做好预防工作。
         防御指南：
         1、政府及农林主管部门按照职责做好防霜冻准备工作；
         2、对农作物、蔬菜、花卉、瓜果、林业育种要采取一定的防护措施；
         3、农村基层组织和农户要关注当地霜冻预警信息，以便采取措施加强防护。（预警信息来源：国家预警信息发布中心）
         * alarmDesc : 河北省张家口市气象台发布霜冻蓝色预警
         * alarmId : 2af5aea251a094f7947e27869f732c20
         * alarmLevelNo : 01
         * alarmLevelNoDesc : 蓝色
         * alarmType : 11
         * alarmTypeDesc : 霜冻蓝色
         * precaution : 1.出门前准备好手套.帽子等御寒衣物；

         2.户外活动警惕冻伤风险。
         * publishTime : 2018-09-20 17:08:34
         */

        private String alarmContent;
        private String alarmDesc;
        private String alarmId;
        private String alarmLevelNo;
        private String alarmLevelNoDesc;
        private String alarmType;
        private String alarmTypeDesc;
        private String precaution;
        private String publishTime;

        public String getAlarmContent() {
            return alarmContent;
        }

        public void setAlarmContent(String alarmContent) {
            this.alarmContent = alarmContent;
        }

        public String getAlarmDesc() {
            return alarmDesc;
        }

        public void setAlarmDesc(String alarmDesc) {
            this.alarmDesc = alarmDesc;
        }

        public String getAlarmId() {
            return alarmId;
        }

        public void setAlarmId(String alarmId) {
            this.alarmId = alarmId;
        }

        public String getAlarmLevelNo() {
            return alarmLevelNo;
        }

        public void setAlarmLevelNo(String alarmLevelNo) {
            this.alarmLevelNo = alarmLevelNo;
        }

        public String getAlarmLevelNoDesc() {
            return alarmLevelNoDesc;
        }

        public void setAlarmLevelNoDesc(String alarmLevelNoDesc) {
            this.alarmLevelNoDesc = alarmLevelNoDesc;
        }

        public String getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(String alarmType) {
            this.alarmType = alarmType;
        }

        public String getAlarmTypeDesc() {
            return alarmTypeDesc;
        }

        public void setAlarmTypeDesc(String alarmTypeDesc) {
            this.alarmTypeDesc = alarmTypeDesc;
        }

        public String getPrecaution() {
            return precaution;
        }

        public void setPrecaution(String precaution) {
            this.precaution = precaution;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }
    }

    public static class RealtimeBean {
        /**
         * img : 2
         * sD : 55
         * sendibleTemp : 12
         * temp : 13
         * time : 2018-09-15 10:40:08
         * wD : 西北风
         * wS : 4
         * weather : 阴
         * ziwaixian : N/A
         */

        private String img;
        private String sD;
        private String sendibleTemp;
        private String temp;
        private String time;
        private String wD;
        private String wS;
        private String weather;
        private String ziwaixian;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getSD() {
            return sD;
        }

        public void setSD(String sD) {
            this.sD = sD;
        }

        public int getSendibleTemp() {
            return TextUtil.getInteger(sendibleTemp);
        }

        public void setSendibleTemp(String sendibleTemp) {
            this.sendibleTemp = sendibleTemp;
        }

        public int getTemp() {
            return TextUtil.getInteger(temp);
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getTime() {
            return time.split(" ")[1].substring(0,5);
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getWD() {
            return wD;
        }

        public void setWD(String wD) {
            this.wD = wD;
        }

        public String getWS() {
            return wS;
        }

        public void setWS(String wS) {
            this.wS = wS;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getZiwaixian() {
            return ziwaixian;
        }

        public void setZiwaixian(String ziwaixian) {
            this.ziwaixian = ziwaixian;
        }
    }

    public static class WeatherDetailsInfoBean {
        /**
         * publishTime : 2018-09-15 10:00:00
         * weather24HoursDetailsInfos : [{"endTime":"2018-09-15 12:00:00","highestTemperature":"15","img":"0","isRainFall":"","lowerestTemperature":"15","precipitation":"0","startTime":"2018-09-15 11:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 13:00:00","highestTemperature":"17","img":"0","isRainFall":"","lowerestTemperature":"17","precipitation":"0","startTime":"2018-09-15 12:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 14:00:00","highestTemperature":"19","img":"0","isRainFall":"","lowerestTemperature":"19","precipitation":"0","startTime":"2018-09-15 13:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 15:00:00","highestTemperature":"20","img":"0","isRainFall":"","lowerestTemperature":"20","precipitation":"0","startTime":"2018-09-15 14:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 16:00:00","highestTemperature":"21","img":"0","isRainFall":"","lowerestTemperature":"21","precipitation":"0","startTime":"2018-09-15 15:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 17:00:00","highestTemperature":"20","img":"0","isRainFall":"","lowerestTemperature":"20","precipitation":"0","startTime":"2018-09-15 16:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 18:00:00","highestTemperature":"18","img":"0","isRainFall":"","lowerestTemperature":"18","precipitation":"0","startTime":"2018-09-15 17:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 19:00:00","highestTemperature":"16","img":"0","isRainFall":"","lowerestTemperature":"16","precipitation":"0","startTime":"2018-09-15 18:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 20:00:00","highestTemperature":"13","img":"0","isRainFall":"","lowerestTemperature":"13","precipitation":"0","startTime":"2018-09-15 19:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 21:00:00","highestTemperature":"11","img":"0","isRainFall":"","lowerestTemperature":"11","precipitation":"0","startTime":"2018-09-15 20:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 22:00:00","highestTemperature":"9","img":"0","isRainFall":"","lowerestTemperature":"9","precipitation":"0","startTime":"2018-09-15 21:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-15 23:00:00","highestTemperature":"8","img":"0","isRainFall":"","lowerestTemperature":"8","precipitation":"0","startTime":"2018-09-15 22:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 00:00:00","highestTemperature":"8","img":"0","isRainFall":"","lowerestTemperature":"8","precipitation":"0","startTime":"2018-09-15 23:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 01:00:00","highestTemperature":"8","img":"0","isRainFall":"","lowerestTemperature":"8","precipitation":"0","startTime":"2018-09-16 00:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 02:00:00","highestTemperature":"9","img":"0","isRainFall":"","lowerestTemperature":"9","precipitation":"0","startTime":"2018-09-16 01:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 03:00:00","highestTemperature":"10","img":"0","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 02:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 04:00:00","highestTemperature":"10","img":"1","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 03:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 05:00:00","highestTemperature":"10","img":"1","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 04:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 06:00:00","highestTemperature":"10","img":"2","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 05:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2018-09-16 07:00:00","highestTemperature":"10","img":"2","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 06:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2018-09-16 08:00:00","highestTemperature":"10","img":"1","isRainFall":"","lowerestTemperature":"10","precipitation":"0","startTime":"2018-09-16 07:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 09:00:00","highestTemperature":"11","img":"1","isRainFall":"","lowerestTemperature":"11","precipitation":"0","startTime":"2018-09-16 08:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 10:00:00","highestTemperature":"12","img":"1","isRainFall":"","lowerestTemperature":"12","precipitation":"0","startTime":"2018-09-16 09:00:00","wd":"","weather":"少云","ws":""},{"endTime":"2018-09-16 11:00:00","highestTemperature":"14","img":"0","isRainFall":"","lowerestTemperature":"14","precipitation":"0","startTime":"2018-09-16 10:00:00","wd":"","weather":"晴","ws":""},{"endTime":"2018-09-16 12:00:00","highestTemperature":"14","img":"0","isRainFall":"","lowerestTemperature":"14","precipitation":"0","startTime":"2018-09-16 11:00:00","wd":"","weather":"晴","ws":""}]
         */

        private String publishTime;
        private List<Weather24HoursDetailsInfosBean> weather24HoursDetailsInfos;

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public List<Weather24HoursDetailsInfosBean> getWeather24HoursDetailsInfos() {
            return weather24HoursDetailsInfos;
        }

        public void setWeather24HoursDetailsInfos(List<Weather24HoursDetailsInfosBean> weather24HoursDetailsInfos) {
            this.weather24HoursDetailsInfos = weather24HoursDetailsInfos;
        }

        public static class Weather24HoursDetailsInfosBean {
            /**
             * endTime : 2018-09-15 12:00:00
             * highestTemperature : 15
             * img : 0
             * isRainFall :
             * lowerestTemperature : 15
             * precipitation : 0
             * startTime : 2018-09-15 11:00:00
             * wd :
             * weather : 晴
             * ws :
             */

            private String endTime;
            private String highestTemperature;
            private String img;
            private String isRainFall;
            private String lowerestTemperature;
            private String precipitation;
            private String startTime;
            private String wd;
            private String weather;
            private String ws;

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public int getHighestTemperature() {
                return TextUtil.getInteger(highestTemperature);
            }

            public void setHighestTemperature(String highestTemperature) {
                this.highestTemperature = highestTemperature;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getIsRainFall() {
                return isRainFall;
            }

            public void setIsRainFall(String isRainFall) {
                this.isRainFall = isRainFall;
            }

            public int getLowerestTemperature() {
                return TextUtil.getInteger(lowerestTemperature);
            }

            public void setLowerestTemperature(String lowerestTemperature) {
                this.lowerestTemperature = lowerestTemperature;
            }

            public String getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(String precipitation) {
                this.precipitation = precipitation;
            }

            public String getStartTime() {
                return startTime.split(" ")[1].substring(0,5);
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWs() {
                return ws;
            }

            public void setWs(String ws) {
                this.ws = ws;
            }
        }
    }

    public static class IndexesBean {
        /**
         * abbreviation : uv
         * alias :
         * content : 辐射较弱，涂擦SPF12-15、PA+护肤品。
         * level : 弱
         * name : 紫外线强度指数
         */

        private String abbreviation;
        private String alias;
        private String content;
        private String level;
        private String name;

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class WeathersBean {
        /**
         * date : 2018-09-15
         * img : 1
         * sun_down_time : 18:31
         * sun_rise_time : 06:00
         * temp_day_c : 21
         * temp_day_f : 69.8
         * temp_night_c : 8
         * temp_night_f : 46.4
         * wd :
         * weather : 多云
         * week : 星期六
         * ws :
         */

        private String date;
        private String img;
        private String sun_down_time;
        private String sun_rise_time;
        private String temp_day_c;
        private String temp_day_f;
        private String temp_night_c;
        private String temp_night_f;
        private String wd;
        private String weather;
        private String week;
        private String ws;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getSun_down_time() {
            return sun_down_time;
        }

        public void setSun_down_time(String sun_down_time) {
            this.sun_down_time = sun_down_time;
        }

        public String getSun_rise_time() {
            return sun_rise_time;
        }

        public void setSun_rise_time(String sun_rise_time) {
            this.sun_rise_time = sun_rise_time;
        }

        public int getTemp_day_c() {
            return TextUtil.getInteger(temp_day_c);
        }

        public void setTemp_day_c(String temp_day_c) {
            this.temp_day_c = temp_day_c;
        }

        public String getTemp_day_f() {
            return temp_day_f;
        }

        public void setTemp_day_f(String temp_day_f) {
            this.temp_day_f = temp_day_f;
        }

        public int getTemp_night_c() {
            return TextUtil.getInteger(temp_night_c);
        }

        public void setTemp_night_c(String temp_night_c) {
            this.temp_night_c = temp_night_c;
        }

        public String getTemp_night_f() {
            return temp_night_f;
        }

        public void setTemp_night_f(String temp_night_f) {
            this.temp_night_f = temp_night_f;
        }

        public String getWd() {
            return wd;
        }

        public void setWd(String wd) {
            this.wd = wd;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWs() {
            return ws;
        }

        public void setWs(String ws) {
            this.ws = ws;
        }
    }
}

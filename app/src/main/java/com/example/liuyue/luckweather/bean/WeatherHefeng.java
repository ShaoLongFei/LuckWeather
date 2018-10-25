package com.example.liuyue.luckweather.bean;

import com.example.liuyue.luckweather.utils.TextUtil;

import java.util.List;

public class WeatherHefeng {
    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101090301","location":"张家口","parent_city":"张家口","admin_area":"河北","cnty":"中国","lat":"40.81190109","lon":"114.88409424","tz":"+8.00"}
         * update : {"loc":"2018-09-15 09:45","utc":"2018-09-15 01:45"}
         * status : ok
         * now : {"cloud":"14","cond_code":"104","cond_txt":"阴","fl":"8","hum":"55","pcpn":"0.0","pres":"1024","tmp":"13","vis":"20","wind_deg":"287","wind_dir":"西北风","wind_sc":"4","wind_spd":"24"}
         * daily_forecast : [{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-09-15","hum":"58","mr":"11:44","ms":"22:03","pcpn":"1.0","pop":"55","pres":"1024","sr":"06:02","ss":"18:27","tmp_max":"21","tmp_min":"8","uv_index":"4","vis":"20","wind_deg":"315","wind_dir":"西北风","wind_sc":"3-4","wind_spd":"24"},{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2018-09-16","hum":"39","mr":"12:43","ms":"22:43","pcpn":"0.0","pop":"0","pres":"1024","sr":"06:02","ss":"18:26","tmp_max":"22","tmp_min":"10","uv_index":"3","vis":"20","wind_deg":"285","wind_dir":"西北风","wind_sc":"3-4","wind_spd":"20"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-09-17","hum":"35","mr":"13:39","ms":"23:27","pcpn":"1.0","pop":"55","pres":"1022","sr":"06:03","ss":"18:24","tmp_max":"23","tmp_min":"13","uv_index":"3","vis":"20","wind_deg":"104","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"4"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-09-18","hum":"83","mr":"14:30","ms":"00:00","pcpn":"1.0","pop":"55","pres":"1019","sr":"06:04","ss":"18:22","tmp_max":"22","tmp_min":"13","uv_index":"3","vis":"16","wind_deg":"139","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"5"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-09-19","hum":"85","mr":"15:17","ms":"00:14","pcpn":"0.0","pop":"0","pres":"1016","sr":"06:05","ss":"18:21","tmp_max":"22","tmp_min":"12","uv_index":"5","vis":"20","wind_deg":"169","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-09-20","hum":"78","mr":"15:59","ms":"01:05","pcpn":"0.0","pop":"0","pres":"1009","sr":"06:06","ss":"18:19","tmp_max":"22","tmp_min":"10","uv_index":"5","vis":"20","wind_deg":"326","wind_dir":"西北风","wind_sc":"4-5","wind_spd":"25"},{"cond_code_d":"100","cond_code_n":"101","cond_txt_d":"晴","cond_txt_n":"多云","date":"2018-09-21","hum":"36","mr":"16:37","ms":"02:00","pcpn":"0.0","pop":"0","pres":"1016","sr":"06:07","ss":"18:17","tmp_max":"20","tmp_min":"5","uv_index":"5","vis":"20","wind_deg":"311","wind_dir":"西北风","wind_sc":"5-6","wind_spd":"38"}]
         * hourly : [{"cloud":"74","cond_code":"101","cond_txt":"多云","dew":"2","hum":"47","pop":"0","pres":"1023","time":"2018-09-15 13:00","tmp":"20","wind_deg":"319","wind_dir":"西北风","wind_sc":"3-4","wind_spd":"15"},{"cloud":"60","cond_code":"101","cond_txt":"多云","dew":"0","hum":"42","pop":"0","pres":"1023","time":"2018-09-15 16:00","tmp":"19","wind_deg":"342","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"3"},{"cloud":"17","cond_code":"101","cond_txt":"多云","dew":"0","hum":"49","pop":"0","pres":"1021","time":"2018-09-15 19:00","tmp":"17","wind_deg":"332","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"7"},{"cloud":"0","cond_code":"101","cond_txt":"多云","dew":"-1","hum":"60","pop":"0","pres":"1023","time":"2018-09-15 22:00","tmp":"15","wind_deg":"176","wind_dir":"南风","wind_sc":"3-4","wind_spd":"15"},{"cloud":"5","cond_code":"101","cond_txt":"多云","dew":"-4","hum":"66","pop":"0","pres":"1023","time":"2018-09-16 01:00","tmp":"12","wind_deg":"303","wind_dir":"西北风","wind_sc":"3-4","wind_spd":"20"},{"cloud":"64","cond_code":"101","cond_txt":"多云","dew":"-5","hum":"69","pop":"0","pres":"1023","time":"2018-09-16 04:00","tmp":"9","wind_deg":"349","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"6"},{"cloud":"86","cond_code":"101","cond_txt":"多云","dew":"-3","hum":"64","pop":"0","pres":"1023","time":"2018-09-16 07:00","tmp":"10","wind_deg":"358","wind_dir":"北风","wind_sc":"1-2","wind_spd":"2"},{"cloud":"59","cond_code":"101","cond_txt":"多云","dew":"-3","hum":"39","pop":"0","pres":"1023","time":"2018-09-16 10:00","tmp":"15","wind_deg":"341","wind_dir":"西北风","wind_sc":"3-4","wind_spd":"23"}]
         * lifestyle : [{"type":"comf","brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},{"type":"drsg","brf":"较舒适","txt":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"},{"type":"flu","brf":"较易发","txt":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。"},{"type":"sport","brf":"较适宜","txt":"天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"},{"type":"trav","brf":"适宜","txt":"天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"},{"type":"uv","brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"},{"type":"cw","brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},{"type":"air","brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private NowBean now;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyBean> hourly;
        private List<LifestyleBean> lifestyle;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
        }

        public List<LifestyleBean> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<LifestyleBean> lifestyle) {
            this.lifestyle = lifestyle;
        }

        public static class BasicBean {
            /**
             * cid : CN101090301
             * location : 张家口
             * parent_city : 张家口
             * admin_area : 河北
             * cnty : 中国
             * lat : 40.81190109
             * lon : 114.88409424
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean {
            /**
             * loc : 2018-09-15 09:45
             * utc : 2018-09-15 01:45
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class NowBean {
            /**
             * cloud : 14
             * cond_code : 104
             * cond_txt : 阴
             * fl : 8
             * hum : 55
             * pcpn : 0.0
             * pres : 1024
             * tmp : 13
             * vis : 20
             * wind_deg : 287
             * wind_dir : 西北风
             * wind_sc : 4
             * wind_spd : 24
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir="西北风";
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class DailyForecastBean {
            /**
             * cond_code_d : 101
             * cond_code_n : 101
             * cond_txt_d : 多云
             * cond_txt_n : 多云
             * date : 2018-09-15
             * hum : 58
             * mr : 11:44
             * ms : 22:03
             * pcpn : 1.0
             * pop : 55
             * pres : 1024
             * sr : 06:02
             * ss : 18:27
             * tmp_max : 21
             * tmp_min : 8
             * uv_index : 4
             * vis : 20
             * wind_deg : 315
             * wind_dir : 西北风
             * wind_sc : 3-4
             * wind_spd : 24
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public int getTmp_max() {
                return TextUtil.getInteger(tmp_max);
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public int getTmp_min() {
                return TextUtil.getInteger(tmp_min);
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class HourlyBean {
            /**
             * cloud : 74
             * cond_code : 101
             * cond_txt : 多云
             * dew : 2
             * hum : 47
             * pop : 0
             * pres : 1023
             * time : 2018-09-15 13:00
             * tmp : 20
             * wind_deg : 319
             * wind_dir : 西北风
             * wind_sc : 3-4
             * wind_spd : 15
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String dew;
            private String hum;
            private String pop;
            private String pres;
            private String time;
            private String tmp;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getDew() {
                return dew;
            }

            public void setDew(String dew) {
                this.dew = dew;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class LifestyleBean {
            /**
             * type : comf
             * brf : 舒适
             * txt : 白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。
             */

            private String type;
            private String brf;
            private String txt;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }
    }
}

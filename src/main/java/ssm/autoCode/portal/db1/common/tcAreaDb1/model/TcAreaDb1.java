package ssm.autoCode.portal.db1.common.tcAreaDb1.model;

public class TcAreaDb1 {
    private String countyCode;

    private String provinCode;

    private String provinName;

    private String provinPym;

    private String cityCode;

    private String cityName;

    private String cityPym;

    private String countyName;

    private String countyPym;

    private String isHotcity;

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    public String getProvinCode() {
        return provinCode;
    }

    public void setProvinCode(String provinCode) {
        this.provinCode = provinCode == null ? null : provinCode.trim();
    }

    public String getProvinName() {
        return provinName;
    }

    public void setProvinName(String provinName) {
        this.provinName = provinName == null ? null : provinName.trim();
    }

    public String getProvinPym() {
        return provinPym;
    }

    public void setProvinPym(String provinPym) {
        this.provinPym = provinPym == null ? null : provinPym.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCityPym() {
        return cityPym;
    }

    public void setCityPym(String cityPym) {
        this.cityPym = cityPym == null ? null : cityPym.trim();
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    public String getCountyPym() {
        return countyPym;
    }

    public void setCountyPym(String countyPym) {
        this.countyPym = countyPym == null ? null : countyPym.trim();
    }

    public String getIsHotcity() {
        return isHotcity;
    }

    public void setIsHotcity(String isHotcity) {
        this.isHotcity = isHotcity == null ? null : isHotcity.trim();
    }
}
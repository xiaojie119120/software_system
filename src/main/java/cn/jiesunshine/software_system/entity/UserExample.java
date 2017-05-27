package cn.jiesunshine.software_system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPicLinkIsNull() {
            addCriterion("pic_link is null");
            return (Criteria) this;
        }

        public Criteria andPicLinkIsNotNull() {
            addCriterion("pic_link is not null");
            return (Criteria) this;
        }

        public Criteria andPicLinkEqualTo(String value) {
            addCriterion("pic_link =", value, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkNotEqualTo(String value) {
            addCriterion("pic_link <>", value, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkGreaterThan(String value) {
            addCriterion("pic_link >", value, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkGreaterThanOrEqualTo(String value) {
            addCriterion("pic_link >=", value, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkLessThan(String value) {
            addCriterion("pic_link <", value, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkLessThanOrEqualTo(String value) {
            addCriterion("pic_link <=", value, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkLike(String value) {
            addCriterion("pic_link like", value, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkNotLike(String value) {
            addCriterion("pic_link not like", value, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkIn(List<String> values) {
            addCriterion("pic_link in", values, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkNotIn(List<String> values) {
            addCriterion("pic_link not in", values, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkBetween(String value1, String value2) {
            addCriterion("pic_link between", value1, value2, "picLink");
            return (Criteria) this;
        }

        public Criteria andPicLinkNotBetween(String value1, String value2) {
            addCriterion("pic_link not between", value1, value2, "picLink");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountIsNull() {
            addCriterion("software_count is null");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountIsNotNull() {
            addCriterion("software_count is not null");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountEqualTo(Integer value) {
            addCriterion("software_count =", value, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountNotEqualTo(Integer value) {
            addCriterion("software_count <>", value, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountGreaterThan(Integer value) {
            addCriterion("software_count >", value, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("software_count >=", value, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountLessThan(Integer value) {
            addCriterion("software_count <", value, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountLessThanOrEqualTo(Integer value) {
            addCriterion("software_count <=", value, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountIn(List<Integer> values) {
            addCriterion("software_count in", values, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountNotIn(List<Integer> values) {
            addCriterion("software_count not in", values, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountBetween(Integer value1, Integer value2) {
            addCriterion("software_count between", value1, value2, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andSoftwareCountNotBetween(Integer value1, Integer value2) {
            addCriterion("software_count not between", value1, value2, "softwareCount");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNull() {
            addCriterion("reg_time is null");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNotNull() {
            addCriterion("reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegTimeEqualTo(Date value) {
            addCriterion("reg_time =", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotEqualTo(Date value) {
            addCriterion("reg_time <>", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThan(Date value) {
            addCriterion("reg_time >", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reg_time >=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThan(Date value) {
            addCriterion("reg_time <", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("reg_time <=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeIn(List<Date> values) {
            addCriterion("reg_time in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotIn(List<Date> values) {
            addCriterion("reg_time not in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeBetween(Date value1, Date value2) {
            addCriterion("reg_time between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("reg_time not between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegIpIsNull() {
            addCriterion("reg_ip is null");
            return (Criteria) this;
        }

        public Criteria andRegIpIsNotNull() {
            addCriterion("reg_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRegIpEqualTo(String value) {
            addCriterion("reg_ip =", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotEqualTo(String value) {
            addCriterion("reg_ip <>", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpGreaterThan(String value) {
            addCriterion("reg_ip >", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpGreaterThanOrEqualTo(String value) {
            addCriterion("reg_ip >=", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpLessThan(String value) {
            addCriterion("reg_ip <", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpLessThanOrEqualTo(String value) {
            addCriterion("reg_ip <=", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpLike(String value) {
            addCriterion("reg_ip like", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotLike(String value) {
            addCriterion("reg_ip not like", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpIn(List<String> values) {
            addCriterion("reg_ip in", values, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotIn(List<String> values) {
            addCriterion("reg_ip not in", values, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpBetween(String value1, String value2) {
            addCriterion("reg_ip between", value1, value2, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotBetween(String value1, String value2) {
            addCriterion("reg_ip not between", value1, value2, "regIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeIsNull() {
            addCriterion("pre_login_time is null");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeIsNotNull() {
            addCriterion("pre_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeEqualTo(Date value) {
            addCriterion("pre_login_time =", value, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeNotEqualTo(Date value) {
            addCriterion("pre_login_time <>", value, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeGreaterThan(Date value) {
            addCriterion("pre_login_time >", value, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pre_login_time >=", value, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeLessThan(Date value) {
            addCriterion("pre_login_time <", value, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("pre_login_time <=", value, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeIn(List<Date> values) {
            addCriterion("pre_login_time in", values, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeNotIn(List<Date> values) {
            addCriterion("pre_login_time not in", values, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeBetween(Date value1, Date value2) {
            addCriterion("pre_login_time between", value1, value2, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("pre_login_time not between", value1, value2, "preLoginTime");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpIsNull() {
            addCriterion("pre_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpIsNotNull() {
            addCriterion("pre_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpEqualTo(String value) {
            addCriterion("pre_login_ip =", value, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpNotEqualTo(String value) {
            addCriterion("pre_login_ip <>", value, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpGreaterThan(String value) {
            addCriterion("pre_login_ip >", value, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("pre_login_ip >=", value, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpLessThan(String value) {
            addCriterion("pre_login_ip <", value, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpLessThanOrEqualTo(String value) {
            addCriterion("pre_login_ip <=", value, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpLike(String value) {
            addCriterion("pre_login_ip like", value, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpNotLike(String value) {
            addCriterion("pre_login_ip not like", value, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpIn(List<String> values) {
            addCriterion("pre_login_ip in", values, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpNotIn(List<String> values) {
            addCriterion("pre_login_ip not in", values, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpBetween(String value1, String value2) {
            addCriterion("pre_login_ip between", value1, value2, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreLoginIpNotBetween(String value1, String value2) {
            addCriterion("pre_login_ip not between", value1, value2, "preLoginIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeIsNull() {
            addCriterion("pre_update_time is null");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeIsNotNull() {
            addCriterion("pre_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeEqualTo(Date value) {
            addCriterion("pre_update_time =", value, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeNotEqualTo(Date value) {
            addCriterion("pre_update_time <>", value, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeGreaterThan(Date value) {
            addCriterion("pre_update_time >", value, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pre_update_time >=", value, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeLessThan(Date value) {
            addCriterion("pre_update_time <", value, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("pre_update_time <=", value, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeIn(List<Date> values) {
            addCriterion("pre_update_time in", values, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeNotIn(List<Date> values) {
            addCriterion("pre_update_time not in", values, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("pre_update_time between", value1, value2, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("pre_update_time not between", value1, value2, "preUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpIsNull() {
            addCriterion("pre_update_ip is null");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpIsNotNull() {
            addCriterion("pre_update_ip is not null");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpEqualTo(String value) {
            addCriterion("pre_update_ip =", value, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpNotEqualTo(String value) {
            addCriterion("pre_update_ip <>", value, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpGreaterThan(String value) {
            addCriterion("pre_update_ip >", value, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpGreaterThanOrEqualTo(String value) {
            addCriterion("pre_update_ip >=", value, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpLessThan(String value) {
            addCriterion("pre_update_ip <", value, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpLessThanOrEqualTo(String value) {
            addCriterion("pre_update_ip <=", value, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpLike(String value) {
            addCriterion("pre_update_ip like", value, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpNotLike(String value) {
            addCriterion("pre_update_ip not like", value, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpIn(List<String> values) {
            addCriterion("pre_update_ip in", values, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpNotIn(List<String> values) {
            addCriterion("pre_update_ip not in", values, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpBetween(String value1, String value2) {
            addCriterion("pre_update_ip between", value1, value2, "preUpdateIp");
            return (Criteria) this;
        }

        public Criteria andPreUpdateIpNotBetween(String value1, String value2) {
            addCriterion("pre_update_ip not between", value1, value2, "preUpdateIp");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
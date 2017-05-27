package cn.jiesunshine.software_system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SoftwareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SoftwareExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSoftIdIsNull() {
            addCriterion("soft_id is null");
            return (Criteria) this;
        }

        public Criteria andSoftIdIsNotNull() {
            addCriterion("soft_id is not null");
            return (Criteria) this;
        }

        public Criteria andSoftIdEqualTo(Integer value) {
            addCriterion("soft_id =", value, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftIdNotEqualTo(Integer value) {
            addCriterion("soft_id <>", value, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftIdGreaterThan(Integer value) {
            addCriterion("soft_id >", value, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("soft_id >=", value, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftIdLessThan(Integer value) {
            addCriterion("soft_id <", value, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftIdLessThanOrEqualTo(Integer value) {
            addCriterion("soft_id <=", value, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftIdIn(List<Integer> values) {
            addCriterion("soft_id in", values, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftIdNotIn(List<Integer> values) {
            addCriterion("soft_id not in", values, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftIdBetween(Integer value1, Integer value2) {
            addCriterion("soft_id between", value1, value2, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftIdNotBetween(Integer value1, Integer value2) {
            addCriterion("soft_id not between", value1, value2, "softId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdIsNull() {
            addCriterion("soft_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdIsNotNull() {
            addCriterion("soft_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdEqualTo(Integer value) {
            addCriterion("soft_user_id =", value, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdNotEqualTo(Integer value) {
            addCriterion("soft_user_id <>", value, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdGreaterThan(Integer value) {
            addCriterion("soft_user_id >", value, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("soft_user_id >=", value, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdLessThan(Integer value) {
            addCriterion("soft_user_id <", value, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("soft_user_id <=", value, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdIn(List<Integer> values) {
            addCriterion("soft_user_id in", values, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdNotIn(List<Integer> values) {
            addCriterion("soft_user_id not in", values, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdBetween(Integer value1, Integer value2) {
            addCriterion("soft_user_id between", value1, value2, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("soft_user_id not between", value1, value2, "softUserId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdIsNull() {
            addCriterion("soft_group_id is null");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdIsNotNull() {
            addCriterion("soft_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdEqualTo(Integer value) {
            addCriterion("soft_group_id =", value, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdNotEqualTo(Integer value) {
            addCriterion("soft_group_id <>", value, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdGreaterThan(Integer value) {
            addCriterion("soft_group_id >", value, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("soft_group_id >=", value, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdLessThan(Integer value) {
            addCriterion("soft_group_id <", value, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("soft_group_id <=", value, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdIn(List<Integer> values) {
            addCriterion("soft_group_id in", values, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdNotIn(List<Integer> values) {
            addCriterion("soft_group_id not in", values, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("soft_group_id between", value1, value2, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("soft_group_id not between", value1, value2, "softGroupId");
            return (Criteria) this;
        }

        public Criteria andSoftNameIsNull() {
            addCriterion("soft_name is null");
            return (Criteria) this;
        }

        public Criteria andSoftNameIsNotNull() {
            addCriterion("soft_name is not null");
            return (Criteria) this;
        }

        public Criteria andSoftNameEqualTo(String value) {
            addCriterion("soft_name =", value, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameNotEqualTo(String value) {
            addCriterion("soft_name <>", value, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameGreaterThan(String value) {
            addCriterion("soft_name >", value, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameGreaterThanOrEqualTo(String value) {
            addCriterion("soft_name >=", value, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameLessThan(String value) {
            addCriterion("soft_name <", value, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameLessThanOrEqualTo(String value) {
            addCriterion("soft_name <=", value, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameLike(String value) {
            addCriterion("soft_name like", value, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameNotLike(String value) {
            addCriterion("soft_name not like", value, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameIn(List<String> values) {
            addCriterion("soft_name in", values, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameNotIn(List<String> values) {
            addCriterion("soft_name not in", values, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameBetween(String value1, String value2) {
            addCriterion("soft_name between", value1, value2, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftNameNotBetween(String value1, String value2) {
            addCriterion("soft_name not between", value1, value2, "softName");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractIsNull() {
            addCriterion("soft_abstract is null");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractIsNotNull() {
            addCriterion("soft_abstract is not null");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractEqualTo(String value) {
            addCriterion("soft_abstract =", value, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractNotEqualTo(String value) {
            addCriterion("soft_abstract <>", value, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractGreaterThan(String value) {
            addCriterion("soft_abstract >", value, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractGreaterThanOrEqualTo(String value) {
            addCriterion("soft_abstract >=", value, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractLessThan(String value) {
            addCriterion("soft_abstract <", value, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractLessThanOrEqualTo(String value) {
            addCriterion("soft_abstract <=", value, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractLike(String value) {
            addCriterion("soft_abstract like", value, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractNotLike(String value) {
            addCriterion("soft_abstract not like", value, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractIn(List<String> values) {
            addCriterion("soft_abstract in", values, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractNotIn(List<String> values) {
            addCriterion("soft_abstract not in", values, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractBetween(String value1, String value2) {
            addCriterion("soft_abstract between", value1, value2, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftAbstractNotBetween(String value1, String value2) {
            addCriterion("soft_abstract not between", value1, value2, "softAbstract");
            return (Criteria) this;
        }

        public Criteria andSoftSizeIsNull() {
            addCriterion("soft_size is null");
            return (Criteria) this;
        }

        public Criteria andSoftSizeIsNotNull() {
            addCriterion("soft_size is not null");
            return (Criteria) this;
        }

        public Criteria andSoftSizeEqualTo(Long value) {
            addCriterion("soft_size =", value, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftSizeNotEqualTo(Long value) {
            addCriterion("soft_size <>", value, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftSizeGreaterThan(Long value) {
            addCriterion("soft_size >", value, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("soft_size >=", value, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftSizeLessThan(Long value) {
            addCriterion("soft_size <", value, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftSizeLessThanOrEqualTo(Long value) {
            addCriterion("soft_size <=", value, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftSizeIn(List<Long> values) {
            addCriterion("soft_size in", values, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftSizeNotIn(List<Long> values) {
            addCriterion("soft_size not in", values, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftSizeBetween(Long value1, Long value2) {
            addCriterion("soft_size between", value1, value2, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftSizeNotBetween(Long value1, Long value2) {
            addCriterion("soft_size not between", value1, value2, "softSize");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIsNull() {
            addCriterion("soft_version is null");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIsNotNull() {
            addCriterion("soft_version is not null");
            return (Criteria) this;
        }

        public Criteria andSoftVersionEqualTo(String value) {
            addCriterion("soft_version =", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotEqualTo(String value) {
            addCriterion("soft_version <>", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionGreaterThan(String value) {
            addCriterion("soft_version >", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionGreaterThanOrEqualTo(String value) {
            addCriterion("soft_version >=", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLessThan(String value) {
            addCriterion("soft_version <", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLessThanOrEqualTo(String value) {
            addCriterion("soft_version <=", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLike(String value) {
            addCriterion("soft_version like", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotLike(String value) {
            addCriterion("soft_version not like", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIn(List<String> values) {
            addCriterion("soft_version in", values, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotIn(List<String> values) {
            addCriterion("soft_version not in", values, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionBetween(String value1, String value2) {
            addCriterion("soft_version between", value1, value2, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotBetween(String value1, String value2) {
            addCriterion("soft_version not between", value1, value2, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftDateIsNull() {
            addCriterion("soft_date is null");
            return (Criteria) this;
        }

        public Criteria andSoftDateIsNotNull() {
            addCriterion("soft_date is not null");
            return (Criteria) this;
        }

        public Criteria andSoftDateEqualTo(Date value) {
            addCriterionForJDBCDate("soft_date =", value, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("soft_date <>", value, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftDateGreaterThan(Date value) {
            addCriterionForJDBCDate("soft_date >", value, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("soft_date >=", value, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftDateLessThan(Date value) {
            addCriterionForJDBCDate("soft_date <", value, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("soft_date <=", value, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftDateIn(List<Date> values) {
            addCriterionForJDBCDate("soft_date in", values, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("soft_date not in", values, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("soft_date between", value1, value2, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("soft_date not between", value1, value2, "softDate");
            return (Criteria) this;
        }

        public Criteria andSoftOsIsNull() {
            addCriterion("soft_os is null");
            return (Criteria) this;
        }

        public Criteria andSoftOsIsNotNull() {
            addCriterion("soft_os is not null");
            return (Criteria) this;
        }

        public Criteria andSoftOsEqualTo(String value) {
            addCriterion("soft_os =", value, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsNotEqualTo(String value) {
            addCriterion("soft_os <>", value, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsGreaterThan(String value) {
            addCriterion("soft_os >", value, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsGreaterThanOrEqualTo(String value) {
            addCriterion("soft_os >=", value, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsLessThan(String value) {
            addCriterion("soft_os <", value, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsLessThanOrEqualTo(String value) {
            addCriterion("soft_os <=", value, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsLike(String value) {
            addCriterion("soft_os like", value, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsNotLike(String value) {
            addCriterion("soft_os not like", value, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsIn(List<String> values) {
            addCriterion("soft_os in", values, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsNotIn(List<String> values) {
            addCriterion("soft_os not in", values, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsBetween(String value1, String value2) {
            addCriterion("soft_os between", value1, value2, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftOsNotBetween(String value1, String value2) {
            addCriterion("soft_os not between", value1, value2, "softOs");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeIsNull() {
            addCriterion("soft_download_volume is null");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeIsNotNull() {
            addCriterion("soft_download_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeEqualTo(Integer value) {
            addCriterion("soft_download_volume =", value, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeNotEqualTo(Integer value) {
            addCriterion("soft_download_volume <>", value, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeGreaterThan(Integer value) {
            addCriterion("soft_download_volume >", value, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("soft_download_volume >=", value, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeLessThan(Integer value) {
            addCriterion("soft_download_volume <", value, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("soft_download_volume <=", value, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeIn(List<Integer> values) {
            addCriterion("soft_download_volume in", values, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeNotIn(List<Integer> values) {
            addCriterion("soft_download_volume not in", values, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeBetween(Integer value1, Integer value2) {
            addCriterion("soft_download_volume between", value1, value2, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftDownloadVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("soft_download_volume not between", value1, value2, "softDownloadVolume");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkIsNull() {
            addCriterion("soft_file_link is null");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkIsNotNull() {
            addCriterion("soft_file_link is not null");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkEqualTo(String value) {
            addCriterion("soft_file_link =", value, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkNotEqualTo(String value) {
            addCriterion("soft_file_link <>", value, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkGreaterThan(String value) {
            addCriterion("soft_file_link >", value, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkGreaterThanOrEqualTo(String value) {
            addCriterion("soft_file_link >=", value, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkLessThan(String value) {
            addCriterion("soft_file_link <", value, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkLessThanOrEqualTo(String value) {
            addCriterion("soft_file_link <=", value, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkLike(String value) {
            addCriterion("soft_file_link like", value, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkNotLike(String value) {
            addCriterion("soft_file_link not like", value, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkIn(List<String> values) {
            addCriterion("soft_file_link in", values, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkNotIn(List<String> values) {
            addCriterion("soft_file_link not in", values, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkBetween(String value1, String value2) {
            addCriterion("soft_file_link between", value1, value2, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftFileLinkNotBetween(String value1, String value2) {
            addCriterion("soft_file_link not between", value1, value2, "softFileLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkIsNull() {
            addCriterion("soft_icon_link is null");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkIsNotNull() {
            addCriterion("soft_icon_link is not null");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkEqualTo(String value) {
            addCriterion("soft_icon_link =", value, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkNotEqualTo(String value) {
            addCriterion("soft_icon_link <>", value, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkGreaterThan(String value) {
            addCriterion("soft_icon_link >", value, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkGreaterThanOrEqualTo(String value) {
            addCriterion("soft_icon_link >=", value, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkLessThan(String value) {
            addCriterion("soft_icon_link <", value, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkLessThanOrEqualTo(String value) {
            addCriterion("soft_icon_link <=", value, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkLike(String value) {
            addCriterion("soft_icon_link like", value, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkNotLike(String value) {
            addCriterion("soft_icon_link not like", value, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkIn(List<String> values) {
            addCriterion("soft_icon_link in", values, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkNotIn(List<String> values) {
            addCriterion("soft_icon_link not in", values, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkBetween(String value1, String value2) {
            addCriterion("soft_icon_link between", value1, value2, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftIconLinkNotBetween(String value1, String value2) {
            addCriterion("soft_icon_link not between", value1, value2, "softIconLink");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeIsNull() {
            addCriterion("soft_create_time is null");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeIsNotNull() {
            addCriterion("soft_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeEqualTo(Date value) {
            addCriterion("soft_create_time =", value, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeNotEqualTo(Date value) {
            addCriterion("soft_create_time <>", value, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeGreaterThan(Date value) {
            addCriterion("soft_create_time >", value, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("soft_create_time >=", value, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeLessThan(Date value) {
            addCriterion("soft_create_time <", value, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("soft_create_time <=", value, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeIn(List<Date> values) {
            addCriterion("soft_create_time in", values, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeNotIn(List<Date> values) {
            addCriterion("soft_create_time not in", values, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeBetween(Date value1, Date value2) {
            addCriterion("soft_create_time between", value1, value2, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("soft_create_time not between", value1, value2, "softCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpIsNull() {
            addCriterion("soft_create_ip is null");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpIsNotNull() {
            addCriterion("soft_create_ip is not null");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpEqualTo(String value) {
            addCriterion("soft_create_ip =", value, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpNotEqualTo(String value) {
            addCriterion("soft_create_ip <>", value, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpGreaterThan(String value) {
            addCriterion("soft_create_ip >", value, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpGreaterThanOrEqualTo(String value) {
            addCriterion("soft_create_ip >=", value, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpLessThan(String value) {
            addCriterion("soft_create_ip <", value, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpLessThanOrEqualTo(String value) {
            addCriterion("soft_create_ip <=", value, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpLike(String value) {
            addCriterion("soft_create_ip like", value, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpNotLike(String value) {
            addCriterion("soft_create_ip not like", value, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpIn(List<String> values) {
            addCriterion("soft_create_ip in", values, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpNotIn(List<String> values) {
            addCriterion("soft_create_ip not in", values, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpBetween(String value1, String value2) {
            addCriterion("soft_create_ip between", value1, value2, "softCreateIp");
            return (Criteria) this;
        }

        public Criteria andSoftCreateIpNotBetween(String value1, String value2) {
            addCriterion("soft_create_ip not between", value1, value2, "softCreateIp");
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
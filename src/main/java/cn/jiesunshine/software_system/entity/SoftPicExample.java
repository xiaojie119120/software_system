package cn.jiesunshine.software_system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SoftPicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SoftPicExample() {
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

        public Criteria andPicIdIsNull() {
            addCriterion("pic_id is null");
            return (Criteria) this;
        }

        public Criteria andPicIdIsNotNull() {
            addCriterion("pic_id is not null");
            return (Criteria) this;
        }

        public Criteria andPicIdEqualTo(Integer value) {
            addCriterion("pic_id =", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotEqualTo(Integer value) {
            addCriterion("pic_id <>", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThan(Integer value) {
            addCriterion("pic_id >", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_id >=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThan(Integer value) {
            addCriterion("pic_id <", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThanOrEqualTo(Integer value) {
            addCriterion("pic_id <=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdIn(List<Integer> values) {
            addCriterion("pic_id in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotIn(List<Integer> values) {
            addCriterion("pic_id not in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdBetween(Integer value1, Integer value2) {
            addCriterion("pic_id between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_id not between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdIsNull() {
            addCriterion("pic_soft_id is null");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdIsNotNull() {
            addCriterion("pic_soft_id is not null");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdEqualTo(Integer value) {
            addCriterion("pic_soft_id =", value, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdNotEqualTo(Integer value) {
            addCriterion("pic_soft_id <>", value, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdGreaterThan(Integer value) {
            addCriterion("pic_soft_id >", value, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_soft_id >=", value, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdLessThan(Integer value) {
            addCriterion("pic_soft_id <", value, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdLessThanOrEqualTo(Integer value) {
            addCriterion("pic_soft_id <=", value, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdIn(List<Integer> values) {
            addCriterion("pic_soft_id in", values, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdNotIn(List<Integer> values) {
            addCriterion("pic_soft_id not in", values, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdBetween(Integer value1, Integer value2) {
            addCriterion("pic_soft_id between", value1, value2, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicSoftIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_soft_id not between", value1, value2, "picSoftId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdIsNull() {
            addCriterion("pic_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPicUserIdIsNotNull() {
            addCriterion("pic_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPicUserIdEqualTo(Integer value) {
            addCriterion("pic_user_id =", value, "picUserId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdNotEqualTo(Integer value) {
            addCriterion("pic_user_id <>", value, "picUserId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdGreaterThan(Integer value) {
            addCriterion("pic_user_id >", value, "picUserId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_user_id >=", value, "picUserId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdLessThan(Integer value) {
            addCriterion("pic_user_id <", value, "picUserId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("pic_user_id <=", value, "picUserId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdIn(List<Integer> values) {
            addCriterion("pic_user_id in", values, "picUserId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdNotIn(List<Integer> values) {
            addCriterion("pic_user_id not in", values, "picUserId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdBetween(Integer value1, Integer value2) {
            addCriterion("pic_user_id between", value1, value2, "picUserId");
            return (Criteria) this;
        }

        public Criteria andPicUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_user_id not between", value1, value2, "picUserId");
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

        public Criteria andPicSizeIsNull() {
            addCriterion("pic_size is null");
            return (Criteria) this;
        }

        public Criteria andPicSizeIsNotNull() {
            addCriterion("pic_size is not null");
            return (Criteria) this;
        }

        public Criteria andPicSizeEqualTo(Long value) {
            addCriterion("pic_size =", value, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicSizeNotEqualTo(Long value) {
            addCriterion("pic_size <>", value, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicSizeGreaterThan(Long value) {
            addCriterion("pic_size >", value, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("pic_size >=", value, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicSizeLessThan(Long value) {
            addCriterion("pic_size <", value, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicSizeLessThanOrEqualTo(Long value) {
            addCriterion("pic_size <=", value, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicSizeIn(List<Long> values) {
            addCriterion("pic_size in", values, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicSizeNotIn(List<Long> values) {
            addCriterion("pic_size not in", values, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicSizeBetween(Long value1, Long value2) {
            addCriterion("pic_size between", value1, value2, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicSizeNotBetween(Long value1, Long value2) {
            addCriterion("pic_size not between", value1, value2, "picSize");
            return (Criteria) this;
        }

        public Criteria andPicTypeIsNull() {
            addCriterion("pic_type is null");
            return (Criteria) this;
        }

        public Criteria andPicTypeIsNotNull() {
            addCriterion("pic_type is not null");
            return (Criteria) this;
        }

        public Criteria andPicTypeEqualTo(String value) {
            addCriterion("pic_type =", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotEqualTo(String value) {
            addCriterion("pic_type <>", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeGreaterThan(String value) {
            addCriterion("pic_type >", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pic_type >=", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeLessThan(String value) {
            addCriterion("pic_type <", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeLessThanOrEqualTo(String value) {
            addCriterion("pic_type <=", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeLike(String value) {
            addCriterion("pic_type like", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotLike(String value) {
            addCriterion("pic_type not like", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeIn(List<String> values) {
            addCriterion("pic_type in", values, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotIn(List<String> values) {
            addCriterion("pic_type not in", values, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeBetween(String value1, String value2) {
            addCriterion("pic_type between", value1, value2, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotBetween(String value1, String value2) {
            addCriterion("pic_type not between", value1, value2, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTimeIsNull() {
            addCriterion("pic_time is null");
            return (Criteria) this;
        }

        public Criteria andPicTimeIsNotNull() {
            addCriterion("pic_time is not null");
            return (Criteria) this;
        }

        public Criteria andPicTimeEqualTo(Date value) {
            addCriterion("pic_time =", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeNotEqualTo(Date value) {
            addCriterion("pic_time <>", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeGreaterThan(Date value) {
            addCriterion("pic_time >", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pic_time >=", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeLessThan(Date value) {
            addCriterion("pic_time <", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeLessThanOrEqualTo(Date value) {
            addCriterion("pic_time <=", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeIn(List<Date> values) {
            addCriterion("pic_time in", values, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeNotIn(List<Date> values) {
            addCriterion("pic_time not in", values, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeBetween(Date value1, Date value2) {
            addCriterion("pic_time between", value1, value2, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeNotBetween(Date value1, Date value2) {
            addCriterion("pic_time not between", value1, value2, "picTime");
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
package cn.jiesunshine.software_system.entity;

import java.util.ArrayList;
import java.util.List;

public class BaiduLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaiduLinkExample() {
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

        public Criteria andBdIdIsNull() {
            addCriterion("bd_id is null");
            return (Criteria) this;
        }

        public Criteria andBdIdIsNotNull() {
            addCriterion("bd_id is not null");
            return (Criteria) this;
        }

        public Criteria andBdIdEqualTo(Integer value) {
            addCriterion("bd_id =", value, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdIdNotEqualTo(Integer value) {
            addCriterion("bd_id <>", value, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdIdGreaterThan(Integer value) {
            addCriterion("bd_id >", value, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bd_id >=", value, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdIdLessThan(Integer value) {
            addCriterion("bd_id <", value, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdIdLessThanOrEqualTo(Integer value) {
            addCriterion("bd_id <=", value, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdIdIn(List<Integer> values) {
            addCriterion("bd_id in", values, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdIdNotIn(List<Integer> values) {
            addCriterion("bd_id not in", values, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdIdBetween(Integer value1, Integer value2) {
            addCriterion("bd_id between", value1, value2, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bd_id not between", value1, value2, "bdId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdIsNull() {
            addCriterion("bd_soft_id is null");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdIsNotNull() {
            addCriterion("bd_soft_id is not null");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdEqualTo(Integer value) {
            addCriterion("bd_soft_id =", value, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdNotEqualTo(Integer value) {
            addCriterion("bd_soft_id <>", value, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdGreaterThan(Integer value) {
            addCriterion("bd_soft_id >", value, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bd_soft_id >=", value, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdLessThan(Integer value) {
            addCriterion("bd_soft_id <", value, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdLessThanOrEqualTo(Integer value) {
            addCriterion("bd_soft_id <=", value, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdIn(List<Integer> values) {
            addCriterion("bd_soft_id in", values, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdNotIn(List<Integer> values) {
            addCriterion("bd_soft_id not in", values, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdBetween(Integer value1, Integer value2) {
            addCriterion("bd_soft_id between", value1, value2, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdSoftIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bd_soft_id not between", value1, value2, "bdSoftId");
            return (Criteria) this;
        }

        public Criteria andBdLinkIsNull() {
            addCriterion("bd_link is null");
            return (Criteria) this;
        }

        public Criteria andBdLinkIsNotNull() {
            addCriterion("bd_link is not null");
            return (Criteria) this;
        }

        public Criteria andBdLinkEqualTo(String value) {
            addCriterion("bd_link =", value, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkNotEqualTo(String value) {
            addCriterion("bd_link <>", value, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkGreaterThan(String value) {
            addCriterion("bd_link >", value, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkGreaterThanOrEqualTo(String value) {
            addCriterion("bd_link >=", value, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkLessThan(String value) {
            addCriterion("bd_link <", value, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkLessThanOrEqualTo(String value) {
            addCriterion("bd_link <=", value, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkLike(String value) {
            addCriterion("bd_link like", value, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkNotLike(String value) {
            addCriterion("bd_link not like", value, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkIn(List<String> values) {
            addCriterion("bd_link in", values, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkNotIn(List<String> values) {
            addCriterion("bd_link not in", values, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkBetween(String value1, String value2) {
            addCriterion("bd_link between", value1, value2, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdLinkNotBetween(String value1, String value2) {
            addCriterion("bd_link not between", value1, value2, "bdLink");
            return (Criteria) this;
        }

        public Criteria andBdTypeIsNull() {
            addCriterion("bd_type is null");
            return (Criteria) this;
        }

        public Criteria andBdTypeIsNotNull() {
            addCriterion("bd_type is not null");
            return (Criteria) this;
        }

        public Criteria andBdTypeEqualTo(Integer value) {
            addCriterion("bd_type =", value, "bdType");
            return (Criteria) this;
        }

        public Criteria andBdTypeNotEqualTo(Integer value) {
            addCriterion("bd_type <>", value, "bdType");
            return (Criteria) this;
        }

        public Criteria andBdTypeGreaterThan(Integer value) {
            addCriterion("bd_type >", value, "bdType");
            return (Criteria) this;
        }

        public Criteria andBdTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bd_type >=", value, "bdType");
            return (Criteria) this;
        }

        public Criteria andBdTypeLessThan(Integer value) {
            addCriterion("bd_type <", value, "bdType");
            return (Criteria) this;
        }

        public Criteria andBdTypeLessThanOrEqualTo(Integer value) {
            addCriterion("bd_type <=", value, "bdType");
            return (Criteria) this;
        }

        public Criteria andBdTypeIn(List<Integer> values) {
            addCriterion("bd_type in", values, "bdType");
            return (Criteria) this;
        }

        public Criteria andBdTypeNotIn(List<Integer> values) {
            addCriterion("bd_type not in", values, "bdType");
            return (Criteria) this;
        }

        public Criteria andBdTypeBetween(Integer value1, Integer value2) {
            addCriterion("bd_type between", value1, value2, "bdType");
            return (Criteria) this;
        }

        public Criteria andBdTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("bd_type not between", value1, value2, "bdType");
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
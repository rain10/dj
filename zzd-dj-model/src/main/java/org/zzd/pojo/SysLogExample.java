package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysLogExample() {
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
            addCriterion("ID_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP_ is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP_ is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP_ =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP_ <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP_ >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP_ >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP_ <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP_ <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP_ like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP_ not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP_ in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP_ not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP_ between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP_ not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("LOGIN_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("LOGIN_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("LOGIN_TIME_ =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("LOGIN_TIME_ <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("LOGIN_TIME_ >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LOGIN_TIME_ >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("LOGIN_TIME_ <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("LOGIN_TIME_ <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("LOGIN_TIME_ in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("LOGIN_TIME_ not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("LOGIN_TIME_ between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("LOGIN_TIME_ not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("MAC_ is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("MAC_ is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("MAC_ =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("MAC_ <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("MAC_ >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("MAC_ >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("MAC_ <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("MAC_ <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("MAC_ like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("MAC_ not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("MAC_ in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("MAC_ not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("MAC_ between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("MAC_ not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID_ =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID_ <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID_ >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID_ >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID_ <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID_ <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID_ in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID_ not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID_ between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID_ not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME_ is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME_ is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME_ =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME_ <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME_ >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME_ >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME_ <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME_ <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME_ like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME_ not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME_ in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME_ not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME_ between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME_ not between", value1, value2, "username");
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
package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysTokenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysTokenExample() {
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

        public Criteria andTokenIsNull() {
            addCriterion("TOKEN_ is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("TOKEN_ is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("TOKEN_ =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("TOKEN_ <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("TOKEN_ >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("TOKEN_ >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("TOKEN_ <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("TOKEN_ <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("TOKEN_ like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("TOKEN_ not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("TOKEN_ in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("TOKEN_ not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("TOKEN_ between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("TOKEN_ not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenTimeIsNull() {
            addCriterion("TOKEN_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andTokenTimeIsNotNull() {
            addCriterion("TOKEN_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andTokenTimeEqualTo(Date value) {
            addCriterion("TOKEN_TIME_ =", value, "tokenTime");
            return (Criteria) this;
        }

        public Criteria andTokenTimeNotEqualTo(Date value) {
            addCriterion("TOKEN_TIME_ <>", value, "tokenTime");
            return (Criteria) this;
        }

        public Criteria andTokenTimeGreaterThan(Date value) {
            addCriterion("TOKEN_TIME_ >", value, "tokenTime");
            return (Criteria) this;
        }

        public Criteria andTokenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TOKEN_TIME_ >=", value, "tokenTime");
            return (Criteria) this;
        }

        public Criteria andTokenTimeLessThan(Date value) {
            addCriterion("TOKEN_TIME_ <", value, "tokenTime");
            return (Criteria) this;
        }

        public Criteria andTokenTimeLessThanOrEqualTo(Date value) {
            addCriterion("TOKEN_TIME_ <=", value, "tokenTime");
            return (Criteria) this;
        }

        public Criteria andTokenTimeIn(List<Date> values) {
            addCriterion("TOKEN_TIME_ in", values, "tokenTime");
            return (Criteria) this;
        }

        public Criteria andTokenTimeNotIn(List<Date> values) {
            addCriterion("TOKEN_TIME_ not in", values, "tokenTime");
            return (Criteria) this;
        }

        public Criteria andTokenTimeBetween(Date value1, Date value2) {
            addCriterion("TOKEN_TIME_ between", value1, value2, "tokenTime");
            return (Criteria) this;
        }

        public Criteria andTokenTimeNotBetween(Date value1, Date value2) {
            addCriterion("TOKEN_TIME_ not between", value1, value2, "tokenTime");
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
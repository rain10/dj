package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberTestExample() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id_ is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id_ =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id_ <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id_ >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id_ >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id_ <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id_ <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id_ in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id_ not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id_ between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id_ not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andTestIdIsNull() {
            addCriterion("test_id_ is null");
            return (Criteria) this;
        }

        public Criteria andTestIdIsNotNull() {
            addCriterion("test_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andTestIdEqualTo(Long value) {
            addCriterion("test_id_ =", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotEqualTo(Long value) {
            addCriterion("test_id_ <>", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThan(Long value) {
            addCriterion("test_id_ >", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThanOrEqualTo(Long value) {
            addCriterion("test_id_ >=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThan(Long value) {
            addCriterion("test_id_ <", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThanOrEqualTo(Long value) {
            addCriterion("test_id_ <=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdIn(List<Long> values) {
            addCriterion("test_id_ in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotIn(List<Long> values) {
            addCriterion("test_id_ not in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdBetween(Long value1, Long value2) {
            addCriterion("test_id_ between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotBetween(Long value1, Long value2) {
            addCriterion("test_id_ not between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTimeCostIsNull() {
            addCriterion("time_cost_ is null");
            return (Criteria) this;
        }

        public Criteria andTimeCostIsNotNull() {
            addCriterion("time_cost_ is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCostEqualTo(Date value) {
            addCriterion("time_cost_ =", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotEqualTo(Date value) {
            addCriterion("time_cost_ <>", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostGreaterThan(Date value) {
            addCriterion("time_cost_ >", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostGreaterThanOrEqualTo(Date value) {
            addCriterion("time_cost_ >=", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostLessThan(Date value) {
            addCriterion("time_cost_ <", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostLessThanOrEqualTo(Date value) {
            addCriterion("time_cost_ <=", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostIn(List<Date> values) {
            addCriterion("time_cost_ in", values, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotIn(List<Date> values) {
            addCriterion("time_cost_ not in", values, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostBetween(Date value1, Date value2) {
            addCriterion("time_cost_ between", value1, value2, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotBetween(Date value1, Date value2) {
            addCriterion("time_cost_ not between", value1, value2, "timeCost");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score_ is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score_ is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score_ =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score_ <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score_ >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_ >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score_ <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score_ <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score_ in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score_ not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score_ between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score_ not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state_ is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state_ is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state_ =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state_ <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state_ >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state_ >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state_ <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state_ <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state_ in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state_ not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state_ between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state_ not between", value1, value2, "state");
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
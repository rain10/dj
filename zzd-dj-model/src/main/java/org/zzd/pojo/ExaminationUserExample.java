package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExaminationUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExaminationUserExample() {
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
            addCriterion("id_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id_ is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id_ =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id_ <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id_ >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id_ >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id_ <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id_ <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id_ in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id_ not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id_ between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id_ not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andExamIdIsNull() {
            addCriterion("exam_id_ is null");
            return (Criteria) this;
        }

        public Criteria andExamIdIsNotNull() {
            addCriterion("exam_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andExamIdEqualTo(Long value) {
            addCriterion("exam_id_ =", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotEqualTo(Long value) {
            addCriterion("exam_id_ <>", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdGreaterThan(Long value) {
            addCriterion("exam_id_ >", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("exam_id_ >=", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdLessThan(Long value) {
            addCriterion("exam_id_ <", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdLessThanOrEqualTo(Long value) {
            addCriterion("exam_id_ <=", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdIn(List<Long> values) {
            addCriterion("exam_id_ in", values, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotIn(List<Long> values) {
            addCriterion("exam_id_ not in", values, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdBetween(Long value1, Long value2) {
            addCriterion("exam_id_ between", value1, value2, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotBetween(Long value1, Long value2) {
            addCriterion("exam_id_ not between", value1, value2, "examId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time_ is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time_ =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time_ <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time_ >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time_ >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time_ <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time_ <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time_ in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time_ not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time_ between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time_ not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andIngIsNull() {
            addCriterion("ing_ is null");
            return (Criteria) this;
        }

        public Criteria andIngIsNotNull() {
            addCriterion("ing_ is not null");
            return (Criteria) this;
        }

        public Criteria andIngEqualTo(Integer value) {
            addCriterion("ing_ =", value, "ing");
            return (Criteria) this;
        }

        public Criteria andIngNotEqualTo(Integer value) {
            addCriterion("ing_ <>", value, "ing");
            return (Criteria) this;
        }

        public Criteria andIngGreaterThan(Integer value) {
            addCriterion("ing_ >", value, "ing");
            return (Criteria) this;
        }

        public Criteria andIngGreaterThanOrEqualTo(Integer value) {
            addCriterion("ing_ >=", value, "ing");
            return (Criteria) this;
        }

        public Criteria andIngLessThan(Integer value) {
            addCriterion("ing_ <", value, "ing");
            return (Criteria) this;
        }

        public Criteria andIngLessThanOrEqualTo(Integer value) {
            addCriterion("ing_ <=", value, "ing");
            return (Criteria) this;
        }

        public Criteria andIngIn(List<Integer> values) {
            addCriterion("ing_ in", values, "ing");
            return (Criteria) this;
        }

        public Criteria andIngNotIn(List<Integer> values) {
            addCriterion("ing_ not in", values, "ing");
            return (Criteria) this;
        }

        public Criteria andIngBetween(Integer value1, Integer value2) {
            addCriterion("ing_ between", value1, value2, "ing");
            return (Criteria) this;
        }

        public Criteria andIngNotBetween(Integer value1, Integer value2) {
            addCriterion("ing_ not between", value1, value2, "ing");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time_ is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time_ =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time_ <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time_ >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time_ >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time_ <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time_ <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time_ in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time_ not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time_ between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time_ not between", value1, value2, "endTime");
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

        public Criteria andScoreEqualTo(Long value) {
            addCriterion("score_ =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Long value) {
            addCriterion("score_ <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Long value) {
            addCriterion("score_ >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("score_ >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Long value) {
            addCriterion("score_ <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Long value) {
            addCriterion("score_ <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Long> values) {
            addCriterion("score_ in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Long> values) {
            addCriterion("score_ not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Long value1, Long value2) {
            addCriterion("score_ between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Long value1, Long value2) {
            addCriterion("score_ not between", value1, value2, "score");
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
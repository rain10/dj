package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
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

        public Criteria andNumberIsNull() {
            addCriterion("number_ is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number_ is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Long value) {
            addCriterion("number_ =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Long value) {
            addCriterion("number_ <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Long value) {
            addCriterion("number_ >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("number_ >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Long value) {
            addCriterion("number_ <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Long value) {
            addCriterion("number_ <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Long> values) {
            addCriterion("number_ in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Long> values) {
            addCriterion("number_ not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Long value1, Long value2) {
            addCriterion("number_ between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Long value1, Long value2) {
            addCriterion("number_ not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNull() {
            addCriterion("question_ is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("question_ is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("question_ =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("question_ <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("question_ >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("question_ >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("question_ <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("question_ <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("question_ like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("question_ not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("question_ in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("question_ not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("question_ between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("question_ not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer_ is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer_ is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer_ =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer_ <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer_ >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer_ >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer_ <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer_ <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer_ like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer_ not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer_ in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer_ not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer_ between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer_ not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type_ is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type_ is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type_ =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type_ <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type_ >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_ >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type_ <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type_ <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type_ in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type_ not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type_ between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type_ not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled_ is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled_ is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Integer value) {
            addCriterion("enabled_ =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Integer value) {
            addCriterion("enabled_ <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Integer value) {
            addCriterion("enabled_ >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("enabled_ >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Integer value) {
            addCriterion("enabled_ <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("enabled_ <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Integer> values) {
            addCriterion("enabled_ in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Integer> values) {
            addCriterion("enabled_ not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Integer value1, Integer value2) {
            addCriterion("enabled_ between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("enabled_ not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager_ is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager_ is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(Long value) {
            addCriterion("manager_ =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(Long value) {
            addCriterion("manager_ <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(Long value) {
            addCriterion("manager_ >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(Long value) {
            addCriterion("manager_ >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(Long value) {
            addCriterion("manager_ <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(Long value) {
            addCriterion("manager_ <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<Long> values) {
            addCriterion("manager_ in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<Long> values) {
            addCriterion("manager_ not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(Long value1, Long value2) {
            addCriterion("manager_ between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(Long value1, Long value2) {
            addCriterion("manager_ not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManegerTimeIsNull() {
            addCriterion("maneger_time_ is null");
            return (Criteria) this;
        }

        public Criteria andManegerTimeIsNotNull() {
            addCriterion("maneger_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andManegerTimeEqualTo(Date value) {
            addCriterion("maneger_time_ =", value, "manegerTime");
            return (Criteria) this;
        }

        public Criteria andManegerTimeNotEqualTo(Date value) {
            addCriterion("maneger_time_ <>", value, "manegerTime");
            return (Criteria) this;
        }

        public Criteria andManegerTimeGreaterThan(Date value) {
            addCriterion("maneger_time_ >", value, "manegerTime");
            return (Criteria) this;
        }

        public Criteria andManegerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("maneger_time_ >=", value, "manegerTime");
            return (Criteria) this;
        }

        public Criteria andManegerTimeLessThan(Date value) {
            addCriterion("maneger_time_ <", value, "manegerTime");
            return (Criteria) this;
        }

        public Criteria andManegerTimeLessThanOrEqualTo(Date value) {
            addCriterion("maneger_time_ <=", value, "manegerTime");
            return (Criteria) this;
        }

        public Criteria andManegerTimeIn(List<Date> values) {
            addCriterion("maneger_time_ in", values, "manegerTime");
            return (Criteria) this;
        }

        public Criteria andManegerTimeNotIn(List<Date> values) {
            addCriterion("maneger_time_ not in", values, "manegerTime");
            return (Criteria) this;
        }

        public Criteria andManegerTimeBetween(Date value1, Date value2) {
            addCriterion("maneger_time_ between", value1, value2, "manegerTime");
            return (Criteria) this;
        }

        public Criteria andManegerTimeNotBetween(Date value1, Date value2) {
            addCriterion("maneger_time_ not between", value1, value2, "manegerTime");
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
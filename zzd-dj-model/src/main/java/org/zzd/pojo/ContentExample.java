package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContentExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title_ is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title_ is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title_ =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title_ <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title_ >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title_ >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title_ <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title_ <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title_ like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title_ not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title_ in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title_ not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title_ between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title_ not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("recommend_ is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("recommend_ is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(Integer value) {
            addCriterion("recommend_ =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(Integer value) {
            addCriterion("recommend_ <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(Integer value) {
            addCriterion("recommend_ >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_ >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(Integer value) {
            addCriterion("recommend_ <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_ <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<Integer> values) {
            addCriterion("recommend_ in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<Integer> values) {
            addCriterion("recommend_ not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(Integer value1, Integer value2) {
            addCriterion("recommend_ between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_ not between", value1, value2, "recommend");
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

        public Criteria andOtherIsNull() {
            addCriterion("other_ is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other_ is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other_ =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other_ <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other_ >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other_ >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other_ <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other_ <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other_ like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other_ not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other_ in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other_ not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other_ between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other_ not between", value1, value2, "other");
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

        public Criteria andManagerEqualTo(String value) {
            addCriterion("manager_ =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(String value) {
            addCriterion("manager_ <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(String value) {
            addCriterion("manager_ >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(String value) {
            addCriterion("manager_ >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(String value) {
            addCriterion("manager_ <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(String value) {
            addCriterion("manager_ <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLike(String value) {
            addCriterion("manager_ like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotLike(String value) {
            addCriterion("manager_ not like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<String> values) {
            addCriterion("manager_ in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<String> values) {
            addCriterion("manager_ not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(String value1, String value2) {
            addCriterion("manager_ between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(String value1, String value2) {
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

        public Criteria andOrgidIsNull() {
            addCriterion("orgid_ is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("orgid_ is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(Long value) {
            addCriterion("orgid_ =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(Long value) {
            addCriterion("orgid_ <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(Long value) {
            addCriterion("orgid_ >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(Long value) {
            addCriterion("orgid_ >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(Long value) {
            addCriterion("orgid_ <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(Long value) {
            addCriterion("orgid_ <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(List<Long> values) {
            addCriterion("orgid_ in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(List<Long> values) {
            addCriterion("orgid_ not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(Long value1, Long value2) {
            addCriterion("orgid_ between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(Long value1, Long value2) {
            addCriterion("orgid_ not between", value1, value2, "orgid");
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
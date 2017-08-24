package org.zzd.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDictionaryExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE_ is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE_ is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE_ =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE_ <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE_ >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_ >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE_ <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE_ <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE_ like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE_ not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE_ in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE_ not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE_ between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE_ not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("VALUE_ is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("VALUE_ is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("VALUE_ =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("VALUE_ <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("VALUE_ >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("VALUE_ >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("VALUE_ <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("VALUE_ <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("VALUE_ like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("VALUE_ not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("VALUE_ in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("VALUE_ not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("VALUE_ between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("VALUE_ not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME_ is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME_ is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME_ =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME_ <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME_ >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_ >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME_ <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME_ <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME_ like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME_ not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME_ in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME_ not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME_ between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME_ not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNull() {
            addCriterion("DISPLAY_ is null");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNotNull() {
            addCriterion("DISPLAY_ is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayEqualTo(String value) {
            addCriterion("DISPLAY_ =", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotEqualTo(String value) {
            addCriterion("DISPLAY_ <>", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThan(String value) {
            addCriterion("DISPLAY_ >", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("DISPLAY_ >=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThan(String value) {
            addCriterion("DISPLAY_ <", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThanOrEqualTo(String value) {
            addCriterion("DISPLAY_ <=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLike(String value) {
            addCriterion("DISPLAY_ like", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotLike(String value) {
            addCriterion("DISPLAY_ not like", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayIn(List<String> values) {
            addCriterion("DISPLAY_ in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotIn(List<String> values) {
            addCriterion("DISPLAY_ not in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayBetween(String value1, String value2) {
            addCriterion("DISPLAY_ between", value1, value2, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotBetween(String value1, String value2) {
            addCriterion("DISPLAY_ not between", value1, value2, "display");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("ENABLED_ is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("ENABLED_ is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Integer value) {
            addCriterion("ENABLED_ =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Integer value) {
            addCriterion("ENABLED_ <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Integer value) {
            addCriterion("ENABLED_ >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENABLED_ >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Integer value) {
            addCriterion("ENABLED_ <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("ENABLED_ <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Integer> values) {
            addCriterion("ENABLED_ in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Integer> values) {
            addCriterion("ENABLED_ not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Integer value1, Integer value2) {
            addCriterion("ENABLED_ between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("ENABLED_ not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT_ is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT_ is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT_ =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT_ <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT_ >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT_ >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT_ <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT_ <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("SORT_ in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("SORT_ not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT_ between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT_ not between", value1, value2, "sort");
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
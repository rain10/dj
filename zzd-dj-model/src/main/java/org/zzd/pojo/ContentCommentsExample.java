package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentCommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContentCommentsExample() {
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

        public Criteria andContentIdIsNull() {
            addCriterion("content_id_ is null");
            return (Criteria) this;
        }

        public Criteria andContentIdIsNotNull() {
            addCriterion("content_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andContentIdEqualTo(Long value) {
            addCriterion("content_id_ =", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotEqualTo(Long value) {
            addCriterion("content_id_ <>", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThan(Long value) {
            addCriterion("content_id_ >", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("content_id_ >=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThan(Long value) {
            addCriterion("content_id_ <", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThanOrEqualTo(Long value) {
            addCriterion("content_id_ <=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdIn(List<Long> values) {
            addCriterion("content_id_ in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotIn(List<Long> values) {
            addCriterion("content_id_ not in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdBetween(Long value1, Long value2) {
            addCriterion("content_id_ between", value1, value2, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotBetween(Long value1, Long value2) {
            addCriterion("content_id_ not between", value1, value2, "contentId");
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

        public Criteria andOpTimeIsNull() {
            addCriterion("op_time_ is null");
            return (Criteria) this;
        }

        public Criteria andOpTimeIsNotNull() {
            addCriterion("op_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andOpTimeEqualTo(Date value) {
            addCriterion("op_time_ =", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotEqualTo(Date value) {
            addCriterion("op_time_ <>", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeGreaterThan(Date value) {
            addCriterion("op_time_ >", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("op_time_ >=", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeLessThan(Date value) {
            addCriterion("op_time_ <", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeLessThanOrEqualTo(Date value) {
            addCriterion("op_time_ <=", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeIn(List<Date> values) {
            addCriterion("op_time_ in", values, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotIn(List<Date> values) {
            addCriterion("op_time_ not in", values, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeBetween(Date value1, Date value2) {
            addCriterion("op_time_ between", value1, value2, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotBetween(Date value1, Date value2) {
            addCriterion("op_time_ not between", value1, value2, "opTime");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor_ is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor_ is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("auditor_ =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("auditor_ <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("auditor_ >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("auditor_ >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("auditor_ <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("auditor_ <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("auditor_ like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("auditor_ not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("auditor_ in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("auditor_ not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("auditor_ between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("auditor_ not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time_ is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time_ =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time_ <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time_ >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time_ >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time_ <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time_ <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time_ in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time_ not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time_ between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time_ not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditIsNull() {
            addCriterion("audit_ is null");
            return (Criteria) this;
        }

        public Criteria andAuditIsNotNull() {
            addCriterion("audit_ is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEqualTo(Integer value) {
            addCriterion("audit_ =", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotEqualTo(Integer value) {
            addCriterion("audit_ <>", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThan(Integer value) {
            addCriterion("audit_ >", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_ >=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThan(Integer value) {
            addCriterion("audit_ <", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThanOrEqualTo(Integer value) {
            addCriterion("audit_ <=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditIn(List<Integer> values) {
            addCriterion("audit_ in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotIn(List<Integer> values) {
            addCriterion("audit_ not in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditBetween(Integer value1, Integer value2) {
            addCriterion("audit_ between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_ not between", value1, value2, "audit");
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
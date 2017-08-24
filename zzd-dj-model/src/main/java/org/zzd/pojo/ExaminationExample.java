package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExaminationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExaminationExample() {
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

        public Criteria andManagerTimeIsNull() {
            addCriterion("manager_time_ is null");
            return (Criteria) this;
        }

        public Criteria andManagerTimeIsNotNull() {
            addCriterion("manager_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andManagerTimeEqualTo(Date value) {
            addCriterion("manager_time_ =", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeNotEqualTo(Date value) {
            addCriterion("manager_time_ <>", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeGreaterThan(Date value) {
            addCriterion("manager_time_ >", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("manager_time_ >=", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeLessThan(Date value) {
            addCriterion("manager_time_ <", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeLessThanOrEqualTo(Date value) {
            addCriterion("manager_time_ <=", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeIn(List<Date> values) {
            addCriterion("manager_time_ in", values, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeNotIn(List<Date> values) {
            addCriterion("manager_time_ not in", values, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeBetween(Date value1, Date value2) {
            addCriterion("manager_time_ between", value1, value2, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeNotBetween(Date value1, Date value2) {
            addCriterion("manager_time_ not between", value1, value2, "managerTime");
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

        public Criteria andIngTimeIsNull() {
            addCriterion("ing_time_ is null");
            return (Criteria) this;
        }

        public Criteria andIngTimeIsNotNull() {
            addCriterion("ing_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andIngTimeEqualTo(Long value) {
            addCriterion("ing_time_ =", value, "ingTime");
            return (Criteria) this;
        }

        public Criteria andIngTimeNotEqualTo(Long value) {
            addCriterion("ing_time_ <>", value, "ingTime");
            return (Criteria) this;
        }

        public Criteria andIngTimeGreaterThan(Long value) {
            addCriterion("ing_time_ >", value, "ingTime");
            return (Criteria) this;
        }

        public Criteria andIngTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("ing_time_ >=", value, "ingTime");
            return (Criteria) this;
        }

        public Criteria andIngTimeLessThan(Long value) {
            addCriterion("ing_time_ <", value, "ingTime");
            return (Criteria) this;
        }

        public Criteria andIngTimeLessThanOrEqualTo(Long value) {
            addCriterion("ing_time_ <=", value, "ingTime");
            return (Criteria) this;
        }

        public Criteria andIngTimeIn(List<Long> values) {
            addCriterion("ing_time_ in", values, "ingTime");
            return (Criteria) this;
        }

        public Criteria andIngTimeNotIn(List<Long> values) {
            addCriterion("ing_time_ not in", values, "ingTime");
            return (Criteria) this;
        }

        public Criteria andIngTimeBetween(Long value1, Long value2) {
            addCriterion("ing_time_ between", value1, value2, "ingTime");
            return (Criteria) this;
        }

        public Criteria andIngTimeNotBetween(Long value1, Long value2) {
            addCriterion("ing_time_ not between", value1, value2, "ingTime");
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

        public Criteria andExamTypeIsNull() {
            addCriterion("exam_type_ is null");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNotNull() {
            addCriterion("exam_type_ is not null");
            return (Criteria) this;
        }

        public Criteria andExamTypeEqualTo(String value) {
            addCriterion("exam_type_ =", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotEqualTo(String value) {
            addCriterion("exam_type_ <>", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThan(String value) {
            addCriterion("exam_type_ >", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_type_ >=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThan(String value) {
            addCriterion("exam_type_ <", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThanOrEqualTo(String value) {
            addCriterion("exam_type_ <=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLike(String value) {
            addCriterion("exam_type_ like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotLike(String value) {
            addCriterion("exam_type_ not like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeIn(List<String> values) {
            addCriterion("exam_type_ in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotIn(List<String> values) {
            addCriterion("exam_type_ not in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeBetween(String value1, String value2) {
            addCriterion("exam_type_ between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotBetween(String value1, String value2) {
            addCriterion("exam_type_ not between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNull() {
            addCriterion("paper_id_ is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("paper_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(Long value) {
            addCriterion("paper_id_ =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(Long value) {
            addCriterion("paper_id_ <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(Long value) {
            addCriterion("paper_id_ >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("paper_id_ >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(Long value) {
            addCriterion("paper_id_ <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(Long value) {
            addCriterion("paper_id_ <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<Long> values) {
            addCriterion("paper_id_ in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<Long> values) {
            addCriterion("paper_id_ not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(Long value1, Long value2) {
            addCriterion("paper_id_ between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(Long value1, Long value2) {
            addCriterion("paper_id_ not between", value1, value2, "paperId");
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
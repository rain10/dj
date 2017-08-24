package org.zzd.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysResourceExample() {
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

        public Criteria andAuthorIsNull() {
            addCriterion("AUTHOR_ is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("AUTHOR_ is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("AUTHOR_ =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("AUTHOR_ <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("AUTHOR_ >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHOR_ >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("AUTHOR_ <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("AUTHOR_ <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("AUTHOR_ like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("AUTHOR_ not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("AUTHOR_ in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("AUTHOR_ not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("AUTHOR_ between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("AUTHOR_ not between", value1, value2, "author");
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

        public Criteria andEnabledEqualTo(Short value) {
            addCriterion("ENABLED_ =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Short value) {
            addCriterion("ENABLED_ <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Short value) {
            addCriterion("ENABLED_ >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Short value) {
            addCriterion("ENABLED_ >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Short value) {
            addCriterion("ENABLED_ <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Short value) {
            addCriterion("ENABLED_ <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Short> values) {
            addCriterion("ENABLED_ in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Short> values) {
            addCriterion("ENABLED_ not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Short value1, Short value2) {
            addCriterion("ENABLED_ between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Short value1, Short value2) {
            addCriterion("ENABLED_ not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("ICON_ is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("ICON_ is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("ICON_ =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("ICON_ <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("ICON_ >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("ICON_ >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("ICON_ <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("ICON_ <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("ICON_ like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("ICON_ not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("ICON_ in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("ICON_ not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("ICON_ between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("ICON_ not between", value1, value2, "icon");
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

        public Criteria andPidIsNull() {
            addCriterion("PID_ is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID_ is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("PID_ =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("PID_ <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("PID_ >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("PID_ >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("PID_ <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("PID_ <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("PID_ in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("PID_ not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("PID_ between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("PID_ not between", value1, value2, "pid");
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

        public Criteria andTargetIsNull() {
            addCriterion("TARGET_ is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("TARGET_ is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(String value) {
            addCriterion("TARGET_ =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(String value) {
            addCriterion("TARGET_ <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(String value) {
            addCriterion("TARGET_ >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_ >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(String value) {
            addCriterion("TARGET_ <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(String value) {
            addCriterion("TARGET_ <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLike(String value) {
            addCriterion("TARGET_ like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotLike(String value) {
            addCriterion("TARGET_ not like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(List<String> values) {
            addCriterion("TARGET_ in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(List<String> values) {
            addCriterion("TARGET_ not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(String value1, String value2) {
            addCriterion("TARGET_ between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(String value1, String value2) {
            addCriterion("TARGET_ not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE_ is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE_ is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE_ =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE_ <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE_ >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE_ >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE_ <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE_ <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE_ like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE_ not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE_ in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE_ not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE_ between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE_ not between", value1, value2, "title");
            return (Criteria) this;
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

        public Criteria andAuthorizationIsNull() {
            addCriterion("AUTHORIZATION_ is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIsNotNull() {
            addCriterion("AUTHORIZATION_ is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationEqualTo(Short value) {
            addCriterion("AUTHORIZATION_ =", value, "authorization");
            return (Criteria) this;
        }

        public Criteria andAuthorizationNotEqualTo(Short value) {
            addCriterion("AUTHORIZATION_ <>", value, "authorization");
            return (Criteria) this;
        }

        public Criteria andAuthorizationGreaterThan(Short value) {
            addCriterion("AUTHORIZATION_ >", value, "authorization");
            return (Criteria) this;
        }

        public Criteria andAuthorizationGreaterThanOrEqualTo(Short value) {
            addCriterion("AUTHORIZATION_ >=", value, "authorization");
            return (Criteria) this;
        }

        public Criteria andAuthorizationLessThan(Short value) {
            addCriterion("AUTHORIZATION_ <", value, "authorization");
            return (Criteria) this;
        }

        public Criteria andAuthorizationLessThanOrEqualTo(Short value) {
            addCriterion("AUTHORIZATION_ <=", value, "authorization");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIn(List<Short> values) {
            addCriterion("AUTHORIZATION_ in", values, "authorization");
            return (Criteria) this;
        }

        public Criteria andAuthorizationNotIn(List<Short> values) {
            addCriterion("AUTHORIZATION_ not in", values, "authorization");
            return (Criteria) this;
        }

        public Criteria andAuthorizationBetween(Short value1, Short value2) {
            addCriterion("AUTHORIZATION_ between", value1, value2, "authorization");
            return (Criteria) this;
        }

        public Criteria andAuthorizationNotBetween(Short value1, Short value2) {
            addCriterion("AUTHORIZATION_ not between", value1, value2, "authorization");
            return (Criteria) this;
        }

        public Criteria andHavemuneIsNull() {
            addCriterion("HAVEMUNE_ is null");
            return (Criteria) this;
        }

        public Criteria andHavemuneIsNotNull() {
            addCriterion("HAVEMUNE_ is not null");
            return (Criteria) this;
        }

        public Criteria andHavemuneEqualTo(Short value) {
            addCriterion("HAVEMUNE_ =", value, "havemune");
            return (Criteria) this;
        }

        public Criteria andHavemuneNotEqualTo(Short value) {
            addCriterion("HAVEMUNE_ <>", value, "havemune");
            return (Criteria) this;
        }

        public Criteria andHavemuneGreaterThan(Short value) {
            addCriterion("HAVEMUNE_ >", value, "havemune");
            return (Criteria) this;
        }

        public Criteria andHavemuneGreaterThanOrEqualTo(Short value) {
            addCriterion("HAVEMUNE_ >=", value, "havemune");
            return (Criteria) this;
        }

        public Criteria andHavemuneLessThan(Short value) {
            addCriterion("HAVEMUNE_ <", value, "havemune");
            return (Criteria) this;
        }

        public Criteria andHavemuneLessThanOrEqualTo(Short value) {
            addCriterion("HAVEMUNE_ <=", value, "havemune");
            return (Criteria) this;
        }

        public Criteria andHavemuneIn(List<Short> values) {
            addCriterion("HAVEMUNE_ in", values, "havemune");
            return (Criteria) this;
        }

        public Criteria andHavemuneNotIn(List<Short> values) {
            addCriterion("HAVEMUNE_ not in", values, "havemune");
            return (Criteria) this;
        }

        public Criteria andHavemuneBetween(Short value1, Short value2) {
            addCriterion("HAVEMUNE_ between", value1, value2, "havemune");
            return (Criteria) this;
        }

        public Criteria andHavemuneNotBetween(Short value1, Short value2) {
            addCriterion("HAVEMUNE_ not between", value1, value2, "havemune");
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
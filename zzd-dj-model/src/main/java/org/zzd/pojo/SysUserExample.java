package org.zzd.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
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

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS_ is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS_ is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS_ =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS_ <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS_ >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS_ >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS_ <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS_ <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS_ like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS_ not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS_ in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS_ not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS_ between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS_ not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL_ is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL_ is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL_ =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL_ <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL_ >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_ >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL_ <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_ <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL_ like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL_ not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL_ in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL_ not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL_ between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL_ not between", value1, value2, "email");
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

        public Criteria andExpiredIsNull() {
            addCriterion("EXPIRED_ is null");
            return (Criteria) this;
        }

        public Criteria andExpiredIsNotNull() {
            addCriterion("EXPIRED_ is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredEqualTo(Short value) {
            addCriterion("EXPIRED_ =", value, "expired");
            return (Criteria) this;
        }

        public Criteria andExpiredNotEqualTo(Short value) {
            addCriterion("EXPIRED_ <>", value, "expired");
            return (Criteria) this;
        }

        public Criteria andExpiredGreaterThan(Short value) {
            addCriterion("EXPIRED_ >", value, "expired");
            return (Criteria) this;
        }

        public Criteria andExpiredGreaterThanOrEqualTo(Short value) {
            addCriterion("EXPIRED_ >=", value, "expired");
            return (Criteria) this;
        }

        public Criteria andExpiredLessThan(Short value) {
            addCriterion("EXPIRED_ <", value, "expired");
            return (Criteria) this;
        }

        public Criteria andExpiredLessThanOrEqualTo(Short value) {
            addCriterion("EXPIRED_ <=", value, "expired");
            return (Criteria) this;
        }

        public Criteria andExpiredIn(List<Short> values) {
            addCriterion("EXPIRED_ in", values, "expired");
            return (Criteria) this;
        }

        public Criteria andExpiredNotIn(List<Short> values) {
            addCriterion("EXPIRED_ not in", values, "expired");
            return (Criteria) this;
        }

        public Criteria andExpiredBetween(Short value1, Short value2) {
            addCriterion("EXPIRED_ between", value1, value2, "expired");
            return (Criteria) this;
        }

        public Criteria andExpiredNotBetween(Short value1, Short value2) {
            addCriterion("EXPIRED_ not between", value1, value2, "expired");
            return (Criteria) this;
        }

        public Criteria andLockedIsNull() {
            addCriterion("LOCKED_ is null");
            return (Criteria) this;
        }

        public Criteria andLockedIsNotNull() {
            addCriterion("LOCKED_ is not null");
            return (Criteria) this;
        }

        public Criteria andLockedEqualTo(Short value) {
            addCriterion("LOCKED_ =", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotEqualTo(Short value) {
            addCriterion("LOCKED_ <>", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThan(Short value) {
            addCriterion("LOCKED_ >", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCKED_ >=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThan(Short value) {
            addCriterion("LOCKED_ <", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThanOrEqualTo(Short value) {
            addCriterion("LOCKED_ <=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedIn(List<Short> values) {
            addCriterion("LOCKED_ in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotIn(List<Short> values) {
            addCriterion("LOCKED_ not in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedBetween(Short value1, Short value2) {
            addCriterion("LOCKED_ between", value1, value2, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotBetween(Short value1, Short value2) {
            addCriterion("LOCKED_ not between", value1, value2, "locked");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD_ is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD_ is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD_ =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD_ <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD_ >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD_ >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD_ <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD_ <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD_ like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD_ not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD_ in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD_ not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD_ between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD_ not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE_ is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE_ is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE_ =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE_ <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE_ >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_ >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE_ <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE_ <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE_ like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE_ not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE_ in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE_ not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE_ between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE_ not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("REALNAME_ is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("REALNAME_ is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("REALNAME_ =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("REALNAME_ <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("REALNAME_ >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("REALNAME_ >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("REALNAME_ <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("REALNAME_ <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("REALNAME_ like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("REALNAME_ not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("REALNAME_ in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("REALNAME_ not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("REALNAME_ between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("REALNAME_ not between", value1, value2, "realname");
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

        public Criteria andUsertypeIsNull() {
            addCriterion("USERTYPE_ is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("USERTYPE_ is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Short value) {
            addCriterion("USERTYPE_ =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Short value) {
            addCriterion("USERTYPE_ <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Short value) {
            addCriterion("USERTYPE_ >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Short value) {
            addCriterion("USERTYPE_ >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Short value) {
            addCriterion("USERTYPE_ <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Short value) {
            addCriterion("USERTYPE_ <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Short> values) {
            addCriterion("USERTYPE_ in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Short> values) {
            addCriterion("USERTYPE_ not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Short value1, Short value2) {
            addCriterion("USERTYPE_ between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Short value1, Short value2) {
            addCriterion("USERTYPE_ not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNull() {
            addCriterion("ORGID is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("ORGID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(Long value) {
            addCriterion("ORGID =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(Long value) {
            addCriterion("ORGID <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(Long value) {
            addCriterion("ORGID >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(Long value) {
            addCriterion("ORGID >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(Long value) {
            addCriterion("ORGID <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(Long value) {
            addCriterion("ORGID <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(List<Long> values) {
            addCriterion("ORGID in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(List<Long> values) {
            addCriterion("ORGID not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(Long value1, Long value2) {
            addCriterion("ORGID between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(Long value1, Long value2) {
            addCriterion("ORGID not between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andDepidIsNull() {
            addCriterion("DEPID is null");
            return (Criteria) this;
        }

        public Criteria andDepidIsNotNull() {
            addCriterion("DEPID is not null");
            return (Criteria) this;
        }

        public Criteria andDepidEqualTo(Long value) {
            addCriterion("DEPID =", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidNotEqualTo(Long value) {
            addCriterion("DEPID <>", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidGreaterThan(Long value) {
            addCriterion("DEPID >", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidGreaterThanOrEqualTo(Long value) {
            addCriterion("DEPID >=", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidLessThan(Long value) {
            addCriterion("DEPID <", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidLessThanOrEqualTo(Long value) {
            addCriterion("DEPID <=", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidIn(List<Long> values) {
            addCriterion("DEPID in", values, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidNotIn(List<Long> values) {
            addCriterion("DEPID not in", values, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidBetween(Long value1, Long value2) {
            addCriterion("DEPID between", value1, value2, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidNotBetween(Long value1, Long value2) {
            addCriterion("DEPID not between", value1, value2, "depid");
            return (Criteria) this;
        }

        public Criteria andPrphoneIsNull() {
            addCriterion("PRPHONE_ is null");
            return (Criteria) this;
        }

        public Criteria andPrphoneIsNotNull() {
            addCriterion("PRPHONE_ is not null");
            return (Criteria) this;
        }

        public Criteria andPrphoneEqualTo(String value) {
            addCriterion("PRPHONE_ =", value, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneNotEqualTo(String value) {
            addCriterion("PRPHONE_ <>", value, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneGreaterThan(String value) {
            addCriterion("PRPHONE_ >", value, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneGreaterThanOrEqualTo(String value) {
            addCriterion("PRPHONE_ >=", value, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneLessThan(String value) {
            addCriterion("PRPHONE_ <", value, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneLessThanOrEqualTo(String value) {
            addCriterion("PRPHONE_ <=", value, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneLike(String value) {
            addCriterion("PRPHONE_ like", value, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneNotLike(String value) {
            addCriterion("PRPHONE_ not like", value, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneIn(List<String> values) {
            addCriterion("PRPHONE_ in", values, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneNotIn(List<String> values) {
            addCriterion("PRPHONE_ not in", values, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneBetween(String value1, String value2) {
            addCriterion("PRPHONE_ between", value1, value2, "prphone");
            return (Criteria) this;
        }

        public Criteria andPrphoneNotBetween(String value1, String value2) {
            addCriterion("PRPHONE_ not between", value1, value2, "prphone");
            return (Criteria) this;
        }

        public Criteria andPropenIsNull() {
            addCriterion("PROPEN is null");
            return (Criteria) this;
        }

        public Criteria andPropenIsNotNull() {
            addCriterion("PROPEN is not null");
            return (Criteria) this;
        }

        public Criteria andPropenEqualTo(String value) {
            addCriterion("PROPEN =", value, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenNotEqualTo(String value) {
            addCriterion("PROPEN <>", value, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenGreaterThan(String value) {
            addCriterion("PROPEN >", value, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenGreaterThanOrEqualTo(String value) {
            addCriterion("PROPEN >=", value, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenLessThan(String value) {
            addCriterion("PROPEN <", value, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenLessThanOrEqualTo(String value) {
            addCriterion("PROPEN <=", value, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenLike(String value) {
            addCriterion("PROPEN like", value, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenNotLike(String value) {
            addCriterion("PROPEN not like", value, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenIn(List<String> values) {
            addCriterion("PROPEN in", values, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenNotIn(List<String> values) {
            addCriterion("PROPEN not in", values, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenBetween(String value1, String value2) {
            addCriterion("PROPEN between", value1, value2, "propen");
            return (Criteria) this;
        }

        public Criteria andPropenNotBetween(String value1, String value2) {
            addCriterion("PROPEN not between", value1, value2, "propen");
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